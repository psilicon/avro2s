package avro2s.generator.specific

import org.apache.avro.Schema
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ScalaSpecificDataGeneratorTest extends AnyFunSuite with Matchers {

  test("emits a case arm per enum schema and a fallback") {
    val suit = new Schema.Parser().parse(
      """{"type":"enum","name":"Suit","namespace":"a.b","symbols":["SPADES","HEARTS"]}"""
    )
    val direction = new Schema.Parser().parse(
      """{"type":"enum","name":"Direction","namespace":"x.y","symbols":["NORTH","SOUTH"]}"""
    )

    val gc = ScalaSpecificDataGenerator.generate(List(suit, direction))

    gc.path shouldBe "avro2s/generated/ScalaSpecificData.scala"
    gc.code should include("class ScalaSpecificData extends SpecificData")
    gc.code should include("""case "a.b.Suit" => a.b.Suit.fromString(symbol)""")
    gc.code should include("""case "x.y.Direction" => x.y.Direction.fromString(symbol)""")
    gc.code should include("case _ => super.createEnum(symbol, schema)")
  }

  test("emits only fallback for empty input") {
    val gc = ScalaSpecificDataGenerator.generate(Nil)
    gc.code should include("case _ => super.createEnum(symbol, schema)")
    gc.code should not include "fromString(symbol)"
  }

  test("singleton accessor present") {
    val gc = ScalaSpecificDataGenerator.generate(Nil)
    gc.code should include("def get(): ScalaSpecificData = instance")
  }

  test("handles enum without a namespace") {
    val noNs = new Schema.Parser().parse("""{"type":"enum","name":"Status","symbols":["ON","OFF"]}""")
    val gc = ScalaSpecificDataGenerator.generate(List(noNs))
    gc.code should include("""case "Status" => Status.fromString(symbol)""")
  }
}
