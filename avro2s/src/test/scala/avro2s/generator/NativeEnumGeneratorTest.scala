package avro2s.generator

import avro2s.error.Error.ConfigError
import avro2s.filehelper.FileHelper
import avro2s.language.ScalaVersion
import avro2s.schema.SchemaStore
import org.apache.avro.Schema
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import java.nio.charset.StandardCharsets.UTF_8
import java.nio.file.{Files, Paths}

class NativeEnumGeneratorTest extends AnyFunSuite with Matchers {
  test("enum mode represents only the user choice") {
    EnumType.fromString("java") shouldBe EnumType.JavaEnum
    EnumType.fromString("scala") shouldBe EnumType.ScalaEnum
    a[ConfigError] should be thrownBy EnumType.fromString("kotlin")
  }

  test("incremental Scala 2 generation preserves aliases from its shared schema store") {
    val first = new Schema.Parser().parse("""{"type":"enum","name":"Suit","namespace":"cards","symbols":["A"]}""")
    val second = new Schema.Parser().parse("""{"type":"enum","name":"Color","namespace":"cards","symbols":["RED"]}""")
    val config = GeneratorConfig(ScalaVersion.Scala_2_13, logicalTypesEnabled = false, enumType = EnumType.ScalaEnum)
    val store = new SchemaStore
    CodeGenerator.generateCode(first, store, config)
    val incremental = CodeGenerator.generateCode(second, store, config)
    val batch = CodeGenerator.generateCode(List(first, second), config)
    incremental.find(_.path == "cards/package.scala") shouldBe batch.find(_.path == "cards/package.scala")
    incremental.find(_.path == "cards/package.scala").get.code should include("type Suit")
    incremental.find(_.path == "cards/package.scala").get.code should include("type Color")
  }

  List("2.13" -> ScalaVersion.Scala_2_13, "3" -> ScalaVersion.Scala_3).foreach { case (version, target) =>
    val config = GeneratorConfig(target, logicalTypesEnabled = false, enumType = EnumType.ScalaEnum)

    test(s"Scala $version native output matches every compiled enum fixture") {
      val input = s"avro2s/src/test/resources/input/scala-$version-enums"
      val schemas = FileHelper.getSchemasFromFiles(FileHelper.findAvscFiles(input))
      val generated = CodeGenerator.generateCode(schemas, config)
      val paths = if (version == "3") List("Card.scala", "Kw.scala", "Suit.scala")
        else List("Card.scala", "internal/Kw.scala", "internal/Suit.scala", "package.scala")
      generated.map(_.path).sorted shouldBe paths
        .map(name => s"avro2s/test/${if (version == "3") "scalaenums" else "adtenums"}/$name").sorted
      generated.foreach { code =>
        val expected = new String(Files.readAllBytes(Paths.get(s"avro2s/src/test/scala-$version/${code.path}")), UTF_8)
        withClue(code.path) { code.code shouldBe expected }
      }
      CodeGenerator.generateCode(schemas.head, new SchemaStore, config) shouldBe generated
    }

    test(s"Scala $version rejects enums without a namespace") {
      val schema = new Schema.Parser().parse("""{"type":"enum","name":"Suit","symbols":["A"]}""")
      a[ConfigError] should be thrownBy CodeGenerator.generateCode(List(schema), config)
    }

    test(s"Scala $version rejects a default-package enum referenced from a named package") {
      val schema = new Schema.Parser().parse("""{"type":"record","name":"Hand","namespace":"cards","fields":[
        {"name":"suit","type":{"type":"enum","name":"Suit","namespace":"","symbols":["A"]}}]}""")
      a[ConfigError] should be thrownBy CodeGenerator.generateCode(List(schema), config)
    }
  }
}
