package avro2s.language

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ScalaVersionTest extends AnyFunSuite with Matchers {

  test("fromString should return Scala_2_13 when given 2.13") {
    ScalaVersion.fromString("2.13") shouldBe ScalaVersion.Scala_2_13
  }
  
  test("fromString should return Scala_3_X when given 3.X") {
    ScalaVersion.fromString("3.X") shouldBe ScalaVersion.Scala_3
    ScalaVersion.fromString("3.x") shouldBe ScalaVersion.Scala_3
    ScalaVersion.fromString("3.0") shouldBe ScalaVersion.Scala_3
    ScalaVersion.fromString("3.1") shouldBe ScalaVersion.Scala_3
    ScalaVersion.fromString("3.2") shouldBe ScalaVersion.Scala_3
    ScalaVersion.fromString("3.3") shouldBe ScalaVersion.Scala_3
  }
  
  test("fromString should throw ConfigError when given an invalid Scala version") {
    val thrown = intercept[avro2s.error.Error.ConfigError] {
      ScalaVersion.fromString("2.14")
    }
    thrown.getMessage shouldBe "Invalid Scala version: 2.14"
  }
}
