package avro2s.generator

import avro2s.language.ScalaVersion
import org.apache.avro.Schema
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class CustomCoderGeneratorTest extends AnyFunSuite with Matchers {
  private val schema = new Schema.Parser().parse("""{"type":"record","name":"Tree","namespace":"example","fields":[
    {"name":"values","type":{"type":"array","items":"long"}},
    {"name":"children","type":{"type":"map","values":"Tree"}}
  ]}""")

  test("the custom coder setting does not affect Scala 2 output") {
    val config = GeneratorConfig(ScalaVersion.Scala_2_13, logicalTypesEnabled = true)
    val enabled = CodeGenerator.generateCode(List(schema), config).head.code
    val disabled = CodeGenerator.generateCode(List(schema), config.copy(customCodersEnabled = false)).head.code
    enabled shouldBe disabled
    enabled should not include "def customEncode"
    enabled should not include "def customDecode"
  }

  locally {
    val target = ScalaVersion.Scala_3
    test(s"custom coders default on and preserve the existing API for $target") {
      val config = GeneratorConfig(target, logicalTypesEnabled = true)
      config.customCodersEnabled shouldBe true
      GeneratorConfig(target, true, EnumType.ScalaEnum).customCodersEnabled shouldBe true
      new GeneratorConfig(target, true).customCodersEnabled shouldBe true
      val standard = CodeGenerator.generateCode(List(schema), config.copy(customCodersEnabled = false)).head.code
      val custom = CodeGenerator.generateCode(List(schema), config).head.code
      standard should not include "def customEncode"
      standard should not include "def customDecode"
      custom should include("override protected def hasCustomCoders(): Boolean = true")
      def declarations(code: String) = code.split("\n").filter(line =>
        line.startsWith("case class") || line.contains("def this()") || line.contains("override def get(") ||
          line.contains("override def put(") || line.contains("val SCHEMA$:")).toList
      declarations(custom) shouldBe declarations(standard)
      custom should not include "avro2s."
      // Recursive schemas terminate and share their helper instead of recursively expanding source.
      custom.sliding("private def decodeRecord$".length).count(_ == "private def decodeRecord$") shouldBe 1
    }
  }
}
