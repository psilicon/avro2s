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

Under the hood, the real type is generated at `<namespace>.internal.<Name>` and re-exposed as `<namespace>.<Name>` via a compile-time alias (a top-level type + val alias on Scala 3, a package object on Scala 2.13). Because no JVM class exists at the schema's full name, stock Avro's class-by-schema-name lookup falls back to `GenericData.EnumSymbol`, so generated records convert at the Avro boundary: `get()` wraps the field in an `EnumSymbol`, and `put()` converts it back via the companion object's `fromAvroSymbol`. Scala 3 records also carry a `@scala.annotation.static SCHEMA$`, so class-based readers and schema-from-class lookups keep working. Generated application code has no runtime dependency on avro2s. See [the integration decision](docs/native-enum-integration.md) for the evaluated alternatives to `.internal`.

Symbols that conflict with companion members get a `$avro` suffix in Scala, such as `Suit.values$avro` or `Suit.toString$avro`. Because `$` is not allowed in Avro identifiers, the generated name cannot collide with an authored symbol. Keywords use backticks; `_` becomes `_$avro` because Scala 3 forbids even a backquoted `_`. `toString` always returns the original Avro symbol, and `Suit.fromAvroSymbol("values")` returns `Suit.values$avro`. Unknown wire symbols throw `AvroRuntimeException`.

Use `fromAvroSymbol` for wire names on both Scala targets. Scala 3's compiler-generated `valueOf` continues to use Scala case names (for example, `Suit.valueOf("values$avro")`); Scala 2's existing `valueOf` accepts original Avro symbols. Ordinary case names remain unchanged. In Scala 3, a symbol named `fromOrdinal` is renamed too.

Avro enums with `symbols: []` generate an uninhabited sealed trait, including on Scala 3, where an empty native enum is not allowed. The companion has an empty `values`, and symbol lookup always fails. Scala 3's `fromOrdinal` also always fails. Such a type can still be used in a nullable field or an empty collection.

Limitations:
 - No JVM class exists at the schema's fullname, so Java-side lookup-by-schema-name misses; Java callers must import `<namespace>.internal.<Name>` directly rather than `<namespace>.<Name>`.
 - Enums must have a namespace.
 - On Scala 2.13, one `package.scala` is generated per namespace. Batch generation collects its aliases from the schema store without rediscovering schemas. Repeated single-schema calls sharing the same `SchemaStore` include all previously discovered aliases. Independent calls with separate stores writing to the same namespace can still overwrite each other's alias file.
 - User schemas that define types under `<namespace>.internal` (or a type literally named `internal`) collide with the generated internal package in `scala` mode.

Direct library users select `GeneratorConfig(targetScalaVersion, logicalTypesEnabled, EnumType.ScalaEnum)`; Java mode remains the default. Use ordinary Avro `SpecificDatumReader` and `SpecificDatumWriter` constructors. There are no generated `datumReader`/`datumWriter` factories to configure.

#### Generated documentation

Avro `doc` strings are emitted automatically as Scaladoc on generated records,
fixed types, and Scala enum types (including their public aliases). Record field
`doc` strings become `@param` entries on the case class. Java enums receive Javadoc.
This applies to both Scala 2.13 and Scala 3 output, including nested named types.
Field descriptions appear in the class/constructor parameter documentation. With
the current Scala toolchain, they are not repeated beneath the individual `var`
entries in the member list. Generated Avro methods such as `get` and `put` do not
currently receive additional descriptions.

Multiline documentation is preserved; missing or whitespace-only docs produce no
comment. Comment delimiters and backslashes are escaped so documentation cannot
break the generated source. No additional configuration is required.

#### Logical types

On by default under the sbt plugin; turn them off with
`Compile / avro2sLogicalTypesEnabled := false`, which maps each of these to its underlying Avro type
instead. Direct library users pass `logicalTypesEnabled` to `GeneratorConfig`. Supported:

| Logical type | Avro type | Scala type |
|---|---|---|
| `uuid` | `string` | `java.util.UUID` |
| `date` | `int` | `java.time.LocalDate` |
| `time-millis` | `int` | `java.time.LocalTime` |
| `time-micros` | `long` | `java.time.LocalTime` |
| `timestamp-millis` / `-micros` / `-nanos` | `long` | `java.time.Instant` |
| `local-timestamp-millis` / `-micros` / `-nanos` | `long` | `java.time.LocalDateTime` |
| `decimal` | `bytes` or `fixed` | `scala.math.BigDecimal` |
| `big-decimal` | `bytes` | `java.math.BigDecimal` |
| `duration` | `fixed` (size 12) | `org.apache.avro.util.TimePeriod` |

Generated code converts these itself, in both directions, rather than delegating to Avro's
`Conversion` classes. That is what makes a generated record independent of the data model it is
read or written with.

The two directions are not symmetric, because Avro resolves conversions differently each way:

 - **Writing.** `get` hands back the encoded form - a `Long`, a `ByteBuffer`, the generated fixed -
   and `getConversion` advertises nothing. Avro looks a write conversion up by the datum's own
   class (`GenericDatumWriter.write`), finds none registered for a `Long`, and writes it verbatim.
   The bytes are therefore identical whichever model you supply, including an empty one.
 - **Reading.** Avro looks a read conversion up by logical type *name* against whichever model is
   in play, so a model carrying `TimestampMillisConversion` converts the value before `put` sees
   it, and an empty model does not. `put` accepts either shape and cannot be made to care:

   ```scala
   value match {
     case instant: java.time.Instant => instant                         // the model converted it
     case long: java.lang.Long => java.time.Instant.ofEpochMilli(long)  // it did not
   }
   ```

   Both arms are the same arithmetic, so it makes no difference which runs. A value that is
   neither shape - a custom conversion returning something unexpected - raises
   `AvroRuntimeException` naming the field's logical type and the class it got.

A consequence worth knowing: `get` returns the encoded form, so `toString` renders a
`timestamp-millis` as `1700000000123` rather than `2023-11-14T22:13:20.123Z`, and `equals`,
`hashCode` and `compareTo` compare encoded values. Equality is unchanged for every type except
`big-decimal`, where it becomes scale-sensitive - `1.5` and `1.50` are now distinct records, which
is what the wire format and this document always said, and what `java.math.BigDecimal.compareTo`
previously contradicted.

`decimal` stores its scale in the schema, so values are coerced to it. A shorter value is padded; a
more precise one throws `AvroTypeException` rather than silently dropping digits, as does one with
more digits than the declared precision. Avro's own conversion refuses both in the same way.
`big-decimal` carries the scale per value instead, so `1.5`, `1.50` and `1.500` stay distinct.

Because a field's value is encoded inside `get`, a record holding a decimal that does not fit its
schema will throw from `equals`, `hashCode` and `toString` as well as when written - those come from
`SpecificRecordBase` and read every field through `get`.

The companion still carries a `MODEL$`, emitted as a static field on Scala 3 so Avro's reflective
lookup finds it, and returned from `getSpecificData` on both. It is no longer load-bearing for
correctness: nothing in the encode path consults its conversions.

#### Upgrading from 0.31

Five logical types were previously unrecognised, so fields carrying them generated as their
underlying Avro type. They now generate as the table above, which changes those field types and
will not compile against existing code until it is updated:

| logical type | on 0.31 | now |
| ------------ | ------- | --- |
| `decimal` on `bytes` or `fixed` | `Array[Byte]` | `scala.math.BigDecimal` |
| `big-decimal` | `Array[Byte]` | `java.math.BigDecimal` |
| `duration` | the generated `fixed` class | `org.apache.avro.util.TimePeriod` |
| `timestamp-nanos` | `Long` | `java.time.Instant` |
| `local-timestamp-nanos` | `Long` | `java.time.LocalDateTime` |

Nothing else changes shape: records without these logical types generate the same constructors,
field types and members as before. Generating with `logicalTypesEnabled = false` is unaffected.

Three behaviours change for records that do carry a logical type, because `get` now returns the
encoded form:

 - `toString` renders the encoded value - `1700000000123` rather than `2023-11-14T22:13:20.123Z`.
 - `hashCode` returns different numbers than before. It stays consistent with `equals`.
 - `equals` on a `big-decimal` field becomes scale-sensitive, so `1.5` and `1.50` are distinct
   records. They always encoded to different bytes; `java.math.BigDecimal.compareTo` ignores scale,
   so equality used to disagree with the wire format.

In exchange, a pre-epoch `timestamp-nanos` or `local-timestamp-nanos` is now correct in every
position on Scala 2.12 and 2.13, which it previously was not.

#### Known limitations

**Unions whose logical types map to the same Scala type are rejected.** Avro keeps
union branches apart by type name, so `["null", {"type":"int","logicalType":"time-millis"},
{"type":"long","logicalType":"time-micros"}]` is a legal schema - the branches are `int`
and `long`. Both map to `java.time.LocalTime`, though, which leaves the two branches
indistinguishable in generated code.

Reads would still be correct, because the decoder resolves the branch itself. Writes
would not: Avro picks a union branch from the value's class, so every value would be
encoded as whichever branch was declared first, silently. A consumer holding only the
other branch then decodes the payload through the wrong conversion - and because Avro
promotes `int` to `long` when matching branches, it does so without error. A
`time-millis` of `20:35:34.567` comes back as `00:01:14.134567`.

Rather than generate code that can do that, avro2s fails with a `SchemaError` naming the
field and the colliding branches. Generate the schema with logical types disabled to use
it: the same branches then map to `Int` and `Long`, which are distinct and round-trip
correctly.

The check is on the generated Scala type, so it covers any set of branches that collapses onto
one, not just that example. The cases Avro itself accepts are:

 - `time-millis` (an `int`) with `time-micros` (a `long`), both `java.time.LocalTime`
 - a `decimal` on `bytes` with a `decimal` on `fixed`, both `scala.math.BigDecimal`
 - two `fixed` branches with different names carrying the same logical type - two `decimal`s, or
   two `duration`s - since Avro keeps named types apart by name

`timestamp-millis`/`timestamp-micros` and `local-timestamp-millis`/`local-timestamp-micros`
cannot reach the check: both are `long` on the wire, so Avro rejects such a union first.

#### Acknowledgments:
 - Thank you to everyone who contributed to [avrohugger](https://github.com/julianpeeters/avrohugger), upon which this code is based.
   - Parts of this code are directly copied from avrohugger; a lot of the code within the `filesorter`, `parser` and `schema` packages has been changed only slightly.
 - [ScalaPB](https://github.com/scalapb/ScalaPB), for inspiration on streamlining the code generation process, particularly for the `FunctionalPrinter` class.
