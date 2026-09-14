package avro2s.generator

import avro2s.filehelper.FileHelper
import avro2s.language.ScalaVersion
import org.apache.avro.Schema
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import java.nio.charset.StandardCharsets.UTF_8
import java.nio.file.{Files, Paths}

class ScaladocGeneratorTest extends AnyFunSuite with Matchers {
  private def record(doc: String, fieldDoc: String): Schema = {
    val schema = Schema.createRecord("Example", doc, "docs", false)
    schema.setFields(java.util.Arrays.asList(
      new Schema.Field("type", Schema.create(Schema.Type.STRING), fieldDoc, null)
    ))
    schema
  }

  List("2.13" -> ScalaVersion.Scala_2_13, "3" -> ScalaVersion.Scala_3).foreach { case (version, target) =>
    val config = GeneratorConfig(target, logicalTypesEnabled = false)
    def generate(schema: Schema): String = CodeGenerator.generateCode(List(schema), config).head.code

    test(s"Scala $version documented output matches compiled fixtures, including nested types") {
      val schemas = FileHelper.getSchemasFromFiles(FileHelper.findAvscFiles("avro2s/src/test/resources/input/default/docs"))
      val generated = CodeGenerator.generateCode(schemas, config)
      generated.map(_.path.split('/').last).sorted shouldBe
        List("DocumentedEnum.java", "DocumentedFixed.scala", "DocumentedRecord.scala")
      generated.foreach { code =>
        val expected = new String(Files.readAllBytes(Paths.get(s"avro2s/src/test/scala-$version/${code.path}")), UTF_8)
        withClue(code.path) { code.code shouldBe expected }
      }
    }

    test(s"Scala $version preserves multiline docs and emits field docs using Avro parameter names") {
      val code = generate(record("First line.\r\n\r\nLast line.", "Category.\rMore detail."))
      code should include(
        "/**\n * First line.\n *\n * Last line.\n *\n * @param type Category.\n *   More detail.\n */\ncase class Example(var `type`: String)"
      )
    }

    test(s"Scala $version emits field-only and record-only documentation") {
      generate(record(null, "Category.")) should include("/**\n * @param type Category.\n */\ncase class")
      generate(record("An example.", null)) should include("/**\n * An example.\n */\ncase class")
      val empty = Schema.createRecord("Empty", "An empty record.", "docs", false)
      empty.setFields(java.util.Collections.emptyList[Schema.Field]())
      generate(empty) should include("/**\n * An empty record.\n */\ncase class Empty()")
    }

    test(s"Scala $version omits missing and blank documentation") {
      val noDocs = generate(record(null, null)).takeWhile(_ != '{')
      List(null, "", " \t\r\n ").foreach { doc =>
        generate(record(doc, doc)).takeWhile(_ != '{') shouldBe noDocs
      }
    }

    test(s"Scala $version escapes comment delimiters and Unicode escape sequences") {
      val unicodeEscape = "\\" + "u002a/"
      val doc = s"Literal /* and */ and /*/ and $unicodeEscape"
      val code = generate(record(doc, doc))
      code should include(" * Literal /&#42; and &#42;/ and /&#42;/ and &#92;u002a/\n")
      code should include(" * @param type Literal /&#42; and &#42;/ and /&#42;/ and &#92;u002a/\n")
    }

    test(s"Scala $version documents native enum declarations and public aliases, including empty enums") {
      List(List("ON", "OFF"), Nil).foreach { symbols =>
        val schema = Schema.createEnum("State", "Available states.", "docs", java.util.Arrays.asList(symbols: _*))
        val generated = CodeGenerator.generateCode(List(schema), config.copy(enumType = EnumType.ScalaEnum))
        val declaration = if (version == "3" && symbols.nonEmpty) "enum State(" else "sealed trait State "
        val implementation = generated.find(_.code.contains(declaration)).get.code
        implementation should include(s" * Available states.\n${if (version == "3") "  " else ""} */\n${if (version == "3") "  " else ""}$declaration")
        val aliases = generated.find(_.code.contains("type State =")).get.code
        aliases should include(" * Available states.\n   */\n  type State =")
        aliases should include(" * Available states.\n   */\n  val State:")
      }
    }

    test(s"Scala $version Java enum output carries schema documentation") {
      val schema = Schema.createEnum("State", "Available states.", "docs", java.util.Arrays.asList("ON"))
      generate(schema) should include("/**\n * Available states.\n */\npublic enum State")
    }
  }
}
