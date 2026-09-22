# Benchmarks

JMH benchmarks for the code avro2s generates. They measure generated records, not the
generator: how fast the emitted `get`/`put` run, and what they cost inside a real Avro
encode and decode.

## Running

```sh
# Every shape, this working tree against main, Scala 3 and 2.13. Takes a while.
scripts/compare-benchmarks.sh

# One shape, Scala 3 only.
scripts/compare-benchmarks.sh --scala 3 MapsBenchmark

# Without a comparison arm.
scripts/compare-benchmarks.sh --current-only

# Against some other revision.
scripts/compare-benchmarks.sh --against v0.29.0

# Ballpark numbers in a couple of minutes rather than hours.
scripts/compare-benchmarks.sh --profile fast --sizes 16 "(IdentityArrays|Maps)Benchmark"

# Check the harness runs at all. Not numbers.
scripts/compare-benchmarks.sh --profile smoke --scala 3 PrimitivesBenchmark.write
```

| Profile | Forks | Warmup | Measurement | Use |
| --- | --- | --- | --- | --- |
| `smoke` | 1 | 1 × 1s | 2 × 1s | Does the harness run |
| `fast` | 1 | 3 × 2s | 3 × 2s | Ballpark while working on a change |
| `two` | 2 | 3 × 3s | 3 × 3s | A second fork catches the per-JVM compilation and heap differences a single fork hides |
| `full` (default) | 3 | 5 × 5s | 5 × 5s | Numbers worth quoting |

Every profile also collects `-prof gc`. Allocation per operation barely moves between runs, so
read the `B/op` table first and treat timing as corroboration.

`--sizes` narrows the `collectionSize` sweep, which is the other big lever on run time.
A full unrestricted run takes hours; `--profile fast --sizes 16` over a few shapes takes
minutes.

Results are written to `benchmarks/results/`, which is not tracked. Nothing in this module
is published; see the comment on `publish / skip` in `build.sbt`.

To run JMH directly, `sbt 'benchmarks3/Jmh/run -h'` (Scala 3) or `sbt 'benchmarks/Jmh/run -h'`
(Scala 2.13). That uses the annotations on `ShapeBenchmark` - 2 forks, 5 × 1s warmup, 5 × 1s
measurement - which is none of the profiles above; pass the flags yourself to match one.
Restrict to the working tree with `-p arm=current`; the baseline arm only exists after
`compare-benchmarks.sh` has generated it.

## What is measured

Each shape has a benchmark class with two measurements:

| Measurement | What it covers |
| --- | --- |
| `write` | A `SpecificDatumWriter` write, which drives the generated `get(i)` for every field |
| `read` | A `SpecificDatumReader` read, which drives the generated `put(i, v)` for every field |

These are whole operations, because that is what callers experience and the only level at
which the numbers are trustworthy. Benchmarking `get` and `put` in isolation was tried and
removed: with their results unused the JIT can eliminate allocations a real write cannot, so
the isolated figures understated the work and did not reconcile with the write containing them.

Shapes live in `src/main/resources/avro`, one schema per shape. `IdentityArrays`,
`ConvertingArrays`, `Maps`, `Strings` and `Bytes` sweep a `collectionSize` parameter;
the rest use a fixed size.

Adding a shape means adding a schema and one line in `Workloads.shapes`. The guard suite
asserts every schema in the resource directory is covered, so a new schema cannot be added
and then forgotten.

## How the comparison works

Both arms are generated from the same schemas. The build generates the working tree's models
into `avro2s.benchmarks.models` on every compile. `compare-benchmarks.sh` checks the
comparison revision out into a detached worktree and generates *its* output into
`avro2s.benchmarks.baseline`, so the two can be loaded into one JVM without colliding.

Benchmark code therefore never names a generated class. It resolves one by name at setup and
works through `SpecificRecord`, which is both the interface Avro itself uses and the one
carrying the methods under test. JMH forks every benchmark and parameter combination
separately, so a fork only ever loads one arm's class at those call sites and the dispatch
stays monomorphic.

The comparison revision has no benchmarks module of its own. The script drives its generator
by adding `benchmarks/generator/GenerateBenchmarkModels.scala` to its test sources through an
in-memory sbt setting; no tracked file in the worktree is modified.

## Correctness

Benchmarks only report numbers, so `WorkloadSpec` runs with the ordinary `test` task and
asserts every shape round-trips at every benchmarked size. Expected values are built as plain
`GenericData.Record`s and encoded with a stock `GenericDatumWriter`, so no generated code helps
produce the value it is checked against. Each benchmark also calls `verify()` in `@Setup`, so a
JMH run cannot report a number for a model that does not round-trip.
