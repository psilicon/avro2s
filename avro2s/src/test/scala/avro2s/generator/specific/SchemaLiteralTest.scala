package avro2s.generator.specific

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import java.io.{ByteArrayOutputStream, DataOutputStream}

class SchemaLiteralTest extends AnyFunSuite with Matchers {

  test("short schema uses single triple-quoted literal") {
    val json = """{"type":"record","name":"Foo","fields":[]}"""
    val result = SchemaLiteral.parseExpression(json)
    result shouldBe s"""new _root_.org.apache.avro.Schema.Parser().parse(\"\"\"$json\"\"\")"""
    result should not include "Array("
  }

  test("schema at exactly threshold uses single literal") {
    val json = "x" * 65000
    val result = SchemaLiteral.parseExpression(json)
    result should not include "Array("
    result should include(json)
  }

  test("schema one char over threshold uses chunked Array form") {
    val json = "x" * 65001
    val result = SchemaLiteral.parseExpression(json)
    result should include("Array(")
    result should include(".mkString")
  }

  test("chunked form contains no single literal exceeding 65000 chars") {
    val json = "x" * 130001
    val result = SchemaLiteral.parseExpression(json)
    val segments = result.split("\"\"\"")
    segments.zipWithIndex.foreach { case (seg, i) =>
      if (i % 2 == 1) seg.length should be <= 65000
    }
  }

  test("chunked form roundtrips to original string") {
    val json = "abcdefghij" * 7000  // 70000 chars
    val result = SchemaLiteral.parseExpression(json)
    val segments = result.split("\"\"\"")
    val contents = segments.zipWithIndex.collect { case (seg, i) if i % 2 == 1 => seg }
    contents.mkString shouldBe json
  }

  test("chunked form produces three chunks for 130001 char input") {
    val json = "x" * 130001
    val result = SchemaLiteral.parseExpression(json)
    val contents = result.split("\"\"\"").zipWithIndex.collect { case (seg, i) if i % 2 == 1 => seg }
    contents should have length 3
  }

  test("Unicode chunks fit JVM modified UTF-8 constants and preserve code points") {
    List("\u0000", "é", "界", "😀").foreach { character =>
      val json = character * 65000
      val contents = SchemaLiteral.parseExpression(json).split("\"\"\"").zipWithIndex.collect {
        case (segment, i) if i % 2 == 1 => segment
      }
      contents.mkString shouldBe json
      contents.length should be > 1
      contents.foreach { chunk =>
        val output = new ByteArrayOutputStream()
        new DataOutputStream(output).writeUTF(chunk)
        output.size() - 2 should be <= 65000
        Character.isHighSurrogate(chunk.last) shouldBe false
        Character.isLowSurrogate(chunk.head) shouldBe false
      }
    }
  }
}
