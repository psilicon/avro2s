# Testing

#### Testing strategy:
 - Generate source code from Avro schema files
 - Incorporate this source code into the test code
 - Test that the generator produces the expected source code (in case of regressions)
 - Test that the generated source code serializes and deserializes as intended

#### Ease of use:
 - `test/scala/RegenerateTestCode.scala` can be run to auto generate the source code under test from the schemas in `test/resources/input/...`

#### Native enum plugin regression:

The `native-enums/regressions` scripted test generates, compiles, and runs Scala 2.13 and Scala 3 code. It covers mixed AVDL/AVSC inputs sharing a namespace, member-colliding symbols, `_`, repeated namespace segments, empty enums, and `org`/`Array` shadowing in large ASCII and Unicode schemas. Generic Avro writers/readers independently verify the original wire symbols through direct fields, options, collections, and unions.

Run from the repository root:

```sh
sbt 'avro2s2_12/publishLocal' \
  'project sbtAvro2s2_12' \
  'set Compile / packageBin / publishArtifact := true' \
  'scripted native-enums/regressions'
```

The session-only override enables the plugin JAR for local test publication; the build currently disables its publication by default.

#### Native enum verification:

- `NativeEnumGeneratorTest` compares every generated native file, including Scala 2 aliases, with the compiled serialization fixtures. It also covers complete single-schema output, shared-store incremental aliases, and namespace validation. Companion-member collisions are exercised by the scripted compilation and serialization regression.
- Scala 2.13 and Scala 3 serialization tests use ordinary stock Avro constructors for direct, optional, array, map, and union enum positions. Scala 3 also tests class-based readers and schema lookup.
- `sbt test` retains the existing Java-mode output comparisons.

#### Scaladoc verification:

- `ScaladocGeneratorTest` covers multiline and blank docs, field-only docs, reserved parameter names, comment escaping, records and nested fixed/enum types, and native enum aliases (including empty enums) on both output targets.
- The documented fixtures under `test/docs` and the native enum fixtures compile as part of `sbt test`; source comparisons check that they match the current generator output.

#### Custom coder verification (Scala 3)

`custom-coders/regressions` compiles and runs standalone Scala 3 applications
with Java/native enums and logical types enabled/disabled. Their only runtime
libraries are Scala and Apache Avro. The tests check both wire directions
against Apache Avro generic and specific readers/writers, forced custom paths
that throw if `get`/`put` is called, the disabled/faster-reader fallback paths,
record reuse, nested/recursive types, collection blocks, JSON, container files,
schema evolution and rejected invalid input. Each application runs in a forked
JVM so an uncaught exception fails the scripted test.

The separate `ArrayValues` fixture covers primitive/string arrays and nested
arrays at sizes from 0 to 2,049 elements, including 31/32/33 and 63/64/65.
It checks mixed block sizes, blocking encoders, numeric item promotion, ordering,
immutable lists retained across record reuse, consecutive records, and truncation
inside an array block as well as at the end of a record.

```sh
sbt 'project sbtAvro2s2_12' \
  'set Compile / packageBin / publishArtifact := true' \
  'scripted custom-coders/regressions'
```

`CustomCoderGeneratorTest` checks that the option defaults to off, that Scala 2
targets reject it, that existing public declarations and schemas are unchanged,
and that recursive schemas do not cause infinite source expansion.
