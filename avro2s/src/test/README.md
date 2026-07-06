# Testing

#### Testing strategy:
 - Generate source code from Avro schema files
 - Incorporate this source code into the test code
 - Test that the generator produces the expected source code (in case of regressions)
 - Test that the generated source code serializes and deserializes as intended

#### Ease of use:
 - `test/scala/RegenerateTestCode.scala` can be run to auto generate the source code under test from the schemas in `test/resources/input/...`

#### Native enum plugin regression:

The `native-enums/regressions` scripted test generates, compiles, and runs Scala 2.13 and Scala 3 code. It covers mixed AVDL/AVSC inputs sharing a namespace, enum symbols named `value` and `List`, and large ASCII and Unicode schema descriptions.

Run from the repository root:

```sh
sbt 'avro2s2_12/publishLocal' \
  'project sbtAvro2s2_12' \
  'set Compile / packageBin / publishArtifact := true' \
  'scripted native-enums/regressions'
```

The session-only override enables the plugin JAR for local test publication; the build currently disables its publication by default.

#### Native enum verification:

- `NativeEnumGeneratorTest` compares every generated native file, including Scala 2 aliases, with the compiled serialization fixtures. It also covers complete single-schema output, shared-store incremental aliases, namespace validation, and companion-member collisions.
- Scala 2.13 and Scala 3 serialization tests use ordinary stock Avro constructors for direct, optional, array, map, and union enum positions. Scala 3 also tests class-based readers and schema lookup.
- `sbt test` retains the existing Java-mode output comparisons.
