# Native enum integration with Avro

This records the decision following the [post-merge review of PR #35](https://github.com/psilicon/avro2s/pull/35#pullrequestreview-5180863236).

## Requirements

- Generate plain Scala 2 ADTs and Scala 3 enums without a Java-enum API.
- Preserve ordinary Avro readers and writers, including schema-based readers on both targets, no-argument/class-based readers on Scala 3, and explicitly supplied stock `SpecificData`.
- Generated application code must have no runtime dependency on avro2s.
- Preserve original Avro symbols even when their Scala identifiers require renaming.

## Decision

Retain the implementation type at `<namespace>.internal.<Name>` and the public Scala aliases for this change. The name separation is intentional: stock Avro cannot find a JVM enum class at the schema fullname, so it constructs a `GenericData.EnumSymbol`. Generated record `put` converts that symbol using `fromAvroSymbol`; `get` wraps the Scala value using its original-symbol `toString`.

The symbol mapping is generated explicitly. Conflicting companion names get a `$avro` suffix, which cannot collide with an authored Avro symbol because Avro identifiers do not allow `$`. Keywords are escaped with backticks; `_` gets the suffix too because Scala 3 rejects it even in backticks. No runtime registry or avro2s library is needed.

## Alternatives evaluated

### Java-compatible Scala 3 enums

Generating an enum extending `java.lang.Enum` at the schema fullname could satisfy stock Avro's Java-enum construction path. It would add the Java-enum API, change the currently documented plain-Scala contract, and supply no equivalent Scala 2 ADT solution. It also does not by itself solve arbitrary wire-symbol mappings or empty enums. Avro's `createEnum` calls Java `Enum.valueOf`, with its own reserved-word transformation; a separately renamed Scala case would need a compatible lookup strategy.

This is a possible separate representation mode, not a compatible replacement for the current `scala` mode.

### Generated `SpecificData`

A generated data implementation could control `createEnum` without adding an avro2s runtime dependency. Avro can discover a record's static `MODEL$` for class-based or record-schema-based readers/writers. That makes the approach viable for a narrower constructor contract; it does not automatically cover all existing entry points.

In Avro 1.12.1, `new SpecificDatumReader()` starts with `SpecificData.get()`. Its subsequent `setSchema` uses that data instance and does not switch to the record's `MODEL$`. Explicitly supplied stock `SpecificData` also remains stock. Moving the plain Scala type to its schema fullname would then send `SpecificData.createEnum` into Java `Enum.valueOf`, which cannot construct a plain Scala enum/ADT. Model selection also needs to be considered for enum and container roots, since `getForSchema` only attempts class-based selection for records and unions.

Replacing `.internal` with this approach would therefore require a separately agreed reader/data configuration contract and compatibility tests for nested records, logical conversions, and schema evolution. This change keeps the existing integration contract instead.

## Source evidence

Inspected the Apache Avro checkout at tag `release-1.12.1`, commit `9110c693767c1dde2665b2b57939333478b12036`, matching this project's pinned dependency:

- [SpecificData](https://github.com/apache/avro/blob/9110c693767c1dde2665b2b57939333478b12036/lang/java/avro/src/main/java/org/apache/avro/specific/SpecificData.java): `MODEL_CACHE`, `getForSchema`, `getForClass`, and `createEnum`.
- [SpecificDatumReader](https://github.com/apache/avro/blob/9110c693767c1dde2665b2b57939333478b12036/lang/java/avro/src/main/java/org/apache/avro/specific/SpecificDatumReader.java): constructors and `setSchema`.

## Verification

The native-enum scripted regression compiles generated application code with only Scala, Avro, and (for Scala 2 unions) shapeless. It writes original symbols with a generic Avro writer, reads them through generated records using schema-based readers on both targets (plus no-argument/class-based readers on Scala 3), and reads the generated writer's output back with a generic reader. This checks the wire symbols independently of a matching writer/reader conversion bug.

The regression covers renamed companion members, keywords and `_`, library-name shadowing with large schemas, repeated namespace segments, and nullable empty enums. Existing fixture tests retain stock reader/writer and class-based schema-lookup coverage.

Scala 2's existing generated records do not expose the static `SCHEMA$` field required by Avro class-based schema discovery. No-argument readers followed by `setSchema` and class-based readers therefore remain a Scala 3-only part of this regression; this PR does not change Scala 2 record schema discovery.
