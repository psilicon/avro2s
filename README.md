# Avro2s

Avro2s (Avro to Scala) is an avro schema to scala case class converter. It generates case classes that extend Avro's Java types, such as SpecificRecordBase, SpecificFixed, GenericEnumSymbol, etc. This ensures compatibility with community tooling, including [Confluent Schema Registry](https://github.com/confluentinc/schema-registry).

Avro2s is essentially a rewrite of [avrohugger](https://github.com/julianpeeters/avrohugger). The motivations for the rewrite include:
 - Enhanced support for Union types
 - Improved maintainability by removing the use of and dependency on [treehugger](https://github.com/eed3si9n/treehugger), which is no longer actively maintained
 - Ease of implementing Scala 3 code generation

#### Features:
 - Supports Scala 3
   - Union types are supported without the need for shapeless
   - Currently, Enums are still generated as Java enums
 - Supports Scala 2.13
 - Compatibility with all Avro types

#### Usage:
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
    ScalaVersion.Scala_2_13
  )
}  
```

#### Roadmap:
 - Logical Types
 - SBT plugin
 - Scala 3 Enum support
 - Scaladoc generation

#### Acknowledgments:
 - Thank you to everyone who contributed to [avrohugger](https://github.com/julianpeeters/avrohugger), upon which this code is based.
   - Parts of this code are directly copied from avrohugger; a lot of the code within the `filesorter`, `parser` and `schema` packages has been changed only slightly.
 - [ScalaPB](https://github.com/scalapb/ScalaPB), for inspiration on streamlining the code generation process, particularly for the `FunctionalPrinter` class.