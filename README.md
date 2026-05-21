# Avro2s

Avro2s (Avro to Scala) is an avro schema to scala case class converter. It generates case classes that extend Avro's Java types, such as SpecificRecordBase, SpecificFixed, GenericEnumSymbol, etc. This ensures compatibility with community tooling, including [Confluent Schema Registry](https://github.com/confluentinc/schema-registry).

Avro2s is essentially a rewrite of [avrohugger](https://github.com/julianpeeters/avrohugger). The motivations for the rewrite include:
 - Enhanced support for Union types
 - Improved maintainability by removing the use of and dependency on [treehugger](https://github.com/eed3si9n/treehugger), which is no longer actively maintained
 - Ease of implementing Scala 3 code generation

#### Features:
 - Supports Scala 3
   - Union types are supported without the need for shapeless
 - Supports Scala 2.13
 - Compatibility with all Avro types
 - SBT plugin
 - Optional idiomatic Scala enum generation (Scala 2.13 sealed ADT or Scala 3 native `enum`)

#### SBT Plugin Usage

Add `sbt-avro2s` to your `project/plugins.sbt`

```
addSbtPlugin("io.psilicon" % "sbt-avro2s" % "0.22.0")
```

Add the task as a compilation dependency in your `build.sbt`:

```
Compile / sourceGenerators += (Compile / avro2sGenerate).taskValue
```

Now when you compile your project the `sbt-avro2s` plugin will attempt to generate case classes for all `*.avdl` and `*.avsc` under the `src/main/avro` directory.

This is only going to succeed if you also have avro in your dependencies. For example,

```
libraryDependencies ++= Seq(
  "org.apache.avro" % "avro" % "1.11.3"
)
```

#### Direct Usage:
Add avro2s to your `build.sbt`:
```scala
libraryDependencies += "io.psilicon" % "avro2s_2.13" % "0.3.0"
```
For Scala 2.13 generation. If you are using Union types, other than unions representing nullable (`["null", T]`),
you will need to add shapeless to your `build.sbt` to run the generated code:
```scala
libraryDependencies += "com.chuusai" % "shapeless_2.13" % "2.3.10"
```
Example usage:
```scala
import avro2s.generator.CodeGenerator
import avro2s.language.ScalaVersion

object Demo extends App {
  
  CodeGenerator.generateCode(
    "input_directory",
    "output_directory",
    GeneratorConfig(ScalaVersion.Scala_2_13, logicalTypesEnabled = true, enumType = None)
  )
}  
```

#### Scala enums (optional)

By default avro2s generates Java `enum` types for Avro enum schemas. To generate idiomatic Scala enums instead, set `avro2sEnumType` in your `build.sbt`:

```scala
// Scala 2.13 — sealed abstract class with case objects:
avro2sEnumType := Some(avro2s.generator.EnumType.ScalaADT)

// Scala 3 — native enum:
avro2sEnumType := Some(avro2s.generator.EnumType.Scala3Enum)
```

When set, avro2s additionally emits an `avro2s.generated.ScalaSpecificData` class. Each generated record that contains an enum field (or logical-type conversions) gets a `MODEL$` value in its companion object and overrides `getSpecificData` to return it. `ScalaSpecificData.createEnum` dispatches to each generated enum's companion `fromString` via a closed pattern match — no reflection.

Wire format is unchanged. Java and Scala consumers of the same schema can interoperate.

**Deserialization note:** Avro's `SpecificDatumReader(schema)` uses the default `SpecificData` instance, which does not know about your Scala enums. When using Scala enums, construct your reader with the record's `MODEL$` explicitly:

```scala
import org.apache.avro.specific.SpecificDatumReader

val reader = new SpecificDatumReader[MyRecord](
  MyRecord.SCHEMA$, MyRecord.SCHEMA$, MyRecord.MODEL$
)
```

#### Roadmap:
 - Scaladoc generation

#### Acknowledgments:
 - Thank you to everyone who contributed to [avrohugger](https://github.com/julianpeeters/avrohugger), upon which this code is based.
   - Parts of this code are directly copied from avrohugger; a lot of the code within the `filesorter`, `parser` and `schema` packages has been changed only slightly.
 - [ScalaPB](https://github.com/scalapb/ScalaPB), for inspiration on streamlining the code generation process, particularly for the `FunctionalPrinter` class.