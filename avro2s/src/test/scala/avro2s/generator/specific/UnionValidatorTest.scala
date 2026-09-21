package avro2s.generator.specific

import avro2s.error.Error.SchemaError
import avro2s.generator.{CodeGenerator, GeneratorConfig}
import avro2s.language.ScalaVersion
import org.apache.avro.Schema
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class UnionValidatorTest extends AnyFunSuite with Matchers {
  private val millis = """{"type":"int","logicalType":"time-millis"}"""
  private val micros = """{"type":"long","logicalType":"time-micros"}"""

  private def record(field: String): Schema =
    new Schema.Parser().parse(
      s"""{"type":"record","name":"R","namespace":"probe","fields":[{"name":"t","type":$field}]}""")

  private def generate(schema: Schema, target: ScalaVersion, logicalTypesEnabled: Boolean): String =
    CodeGenerator.generateCode(List(schema), GeneratorConfig(target, logicalTypesEnabled))
      .map(_.code).mkString("\n")

  private val targets = List("2.13" -> ScalaVersion.Scala_2_13, "3" -> ScalaVersion.Scala_3)

  targets.foreach { case (version, target) =>
    test(s"Scala $version rejects a union whose logical types collapse to one Scala type") {
      // Both orderings: which branch wins is what decides whether the corruption is truncation or a
      // wholly wrong time, so neither may generate.
      List(s"""["null",$millis,$micros]""", s"""["null",$micros,$millis]""").foreach { union =>
        a[SchemaError] should be thrownBy generate(record(union), target, logicalTypesEnabled = true)
      }
    }

    test(s"Scala $version reports the field and both colliding branches") {
      val error = the[SchemaError] thrownBy generate(record(s"""["null",$millis,$micros]"""), target, true)
      error.getMessage should include("probe.R.t")
      error.getMessage should include("java.time.LocalTime")
      error.getMessage should include("int (time-millis)")
      error.getMessage should include("long (time-micros)")
      error.getMessage should include("logical types disabled")
    }

    test(s"Scala $version rejects a union of the same logical type on different Avro types") {
      // decimal sits on bytes or fixed, so Avro sees two distinct branch names while avro2s maps
      // both to scala.math.BigDecimal. Two differently named fixed durations collide the same way.
      val decimals = s"""["null",{"type":"bytes","logicalType":"decimal","precision":10,"scale":2},""" +
        """{"type":"fixed","name":"FD","size":16,"logicalType":"decimal","precision":20,"scale":4}]"""
      val durations = """["null",{"type":"fixed","name":"D1","size":12,"logicalType":"duration"},""" +
        """{"type":"fixed","name":"D2","size":12,"logicalType":"duration"}]"""

      val decimalError = the[SchemaError] thrownBy generate(record(decimals), target, logicalTypesEnabled = true)
      decimalError.getMessage should include("scala.math.BigDecimal")
      decimalError.getMessage should include("bytes (decimal)")
      decimalError.getMessage should include("fixed (decimal)")

      val durationError = the[SchemaError] thrownBy generate(record(durations), target, logicalTypesEnabled = true)
      durationError.getMessage should include("org.apache.avro.util.TimePeriod")
    }

    test(s"Scala $version generates the same union once logical types are disabled") {
      // The documented way out: the branches map to distinct Scala types and round-trip correctly.
      val code = generate(record(s"""["null",$millis,$micros]"""), target, logicalTypesEnabled = false)
      code should include("Int")
      code should include("Long")
    }

    test(s"Scala $version finds colliding unions nested in arrays and maps") {
      List(
        s"""{"type":"array","items":["null",$millis,$micros]}""",
        s"""{"type":"map","values":["null",$millis,$micros]}""",
        s"""{"type":"array","items":{"type":"map","values":["null",$millis,$micros]}}"""
      ).foreach { field =>
        a[SchemaError] should be thrownBy generate(record(field), target, logicalTypesEnabled = true)
      }
    }

    test(s"Scala $version accepts logical types in a union when they map to different Scala types") {
      val union = """["null",{"type":"int","logicalType":"date"},{"type":"long","logicalType":"timestamp-millis"}]"""
      val code = generate(record(union), target, logicalTypesEnabled = true)
      code should include("java.time.LocalDate")
      code should include("java.time.Instant")
    }

    test(s"Scala $version validates a union held by a nested record") {
      val nested = new Schema.Parser().parse(
        s"""{"type":"record","name":"Outer","namespace":"probe","fields":[
           |{"name":"inner","type":{"type":"record","name":"Inner","fields":[
           |{"name":"t","type":["null",$millis,$micros]}]}}]}""".stripMargin)
      val error = the[SchemaError] thrownBy generate(nested, target, logicalTypesEnabled = true)
      error.getMessage should include("probe.Inner.t")
    }

    test(s"Scala $version validates a recursive schema without recursing forever") {
      val recursive = new Schema.Parser().parse(
        """{"type":"record","name":"Node","namespace":"probe","fields":[
          |{"name":"next","type":["null","Node"]},
          |{"name":"children","type":{"type":"array","items":"Node"}}]}""".stripMargin)
      noException should be thrownBy generate(recursive, target, logicalTypesEnabled = true)
    }
  }
}
