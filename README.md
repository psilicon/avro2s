# Avro2s

Avro2s (Avro to Scala) is an avro schema to scala case class converter. It generates case classes that extend Avro's Java types, such as SpecificRecordBase, SpecificFixed, GenericEnumSymbol, etc. This ensures compatibility with community tooling, including [Confluent Schema Registry](https://github.com/confluentinc/schema-registry).

Avro2s is essentially a rewrite of [avrohugger](https://github.com/julianpeeters/avrohugger). The motivations for the rewrite include:
 - Enhanced support for Union types
 - Improved maintainability by removing the use of and dependency on [treehugger](https://github.com/eed3si9n/treehugger), which is no longer actively maintained
 - Ease of implementing Scala 3 code generation

#### Features:
 - Supports Scala 3
   - Union types are supported without the need for shapeless
   - Enums are generated as Java enums by default; opt into Scala-native enums with `Compile / avro2sEnumType := "scala"` (see Enum Representation below)
 - Supports Scala 2.13
 - Compatibility with all Avro types
 - SBT plugin

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
    GeneratorConfig(ScalaVersion.Scala_2_13, logicalTypesEnabled = true)
  )
}  
```

#### Enum Representation:

By default, avro2s generates enums as Java enums (`.java` sources extending Avro's `GenericEnumSymbol`), for maximum interoperability with Java code and other JVM tooling. Setting `avro2sEnumType := "scala"`, scoped to the configuration that runs `avro2sGenerate`, switches to **plain Scala-native enums** instead:

```
Compile / avro2sEnumType := "scala"
```

The plugin's default (`"java"`) is itself set per-configuration (`Compile`/`Test`), so an unscoped `avro2sEnumType := "scala"` in your `build.sbt` lands in the global scope and is shadowed by that default — always scope the override to match, e.g. `Test / avro2sEnumType := "scala"` too if you also generate under `Test`.

One `avro2sGenerate` invocation combines AVDL-derived and authored AVSC schemas before generating code, so enums from both formats can share a namespace.

Scala 3 targets get a real `enum <Name> { case ... }`; Scala 2.13 targets get a `sealed trait` + case object ADT. Either way, the generated type has no Avro-specific API (no `getSchema`, no `GenericEnumSymbol`) and no `java.lang.Enum` API (no `compareTo`, no `name`) — it's a plain Scala type, and it works through stock Avro readers and writers. Avro's own reflective class discovery, schema lookup, and record construction remain in use; no custom reflective bridge or data adapter is generated.

Under the hood, the real type is generated at `<namespace>.internal.<Name>` and re-exposed as `<namespace>.<Name>` via a compile-time alias (a top-level type + val alias on Scala 3, a package object on Scala 2.13). Because no JVM class exists at the schema's full name, stock Avro's class-by-schema-name lookup falls back to `GenericData.EnumSymbol`, so generated records convert at the Avro boundary: `get()` wraps the field in an `EnumSymbol`, and `put()` converts it back via the companion object's `valueOf`. Scala 3 records also carry a `@scala.annotation.static SCHEMA$`, so class-based readers and schema-from-class lookups keep working.

Limitations:
 - No JVM class exists at the schema's fullname, so Java-side lookup-by-schema-name misses; Java callers must import `<namespace>.internal.<Name>` directly rather than `<namespace>.<Name>`.
 - Enums must have a namespace.
 - Enum symbols named `values` or `valueOf` are rejected at generation time because they collide with companion members. Scala 3 also rejects `fromOrdinal`.
 - On Scala 2.13, one `package.scala` is generated per namespace. Batch generation collects its aliases from the schema store without rediscovering schemas. Repeated single-schema calls sharing the same `SchemaStore` include all previously discovered aliases. Independent calls with separate stores writing to the same namespace can still overwrite each other's alias file.
 - User schemas that define types under `<namespace>.internal` (or a type literally named `internal`) collide with the generated internal package in `scala` mode.

Direct library users select `GeneratorConfig(targetScalaVersion, logicalTypesEnabled, EnumType.ScalaEnum)`; Java mode remains the default. Use ordinary Avro `SpecificDatumReader` and `SpecificDatumWriter` constructors. There are no generated `datumReader`/`datumWriter` factories to configure.

#### Roadmap:
 - Scaladoc generation

#### Acknowledgments:
 - Thank you to everyone who contributed to [avrohugger](https://github.com/julianpeeters/avrohugger), upon which this code is based.
   - Parts of this code are directly copied from avrohugger; a lot of the code within the `filesorter`, `parser` and `schema` packages has been changed only slightly.
 - [ScalaPB](https://github.com/scalapb/ScalaPB), for inspiration on streamlining the code generation process, particularly for the `FunctionalPrinter` class.
