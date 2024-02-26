package avro2s.generator

import avro2s.language.ScalaVersion
import avro2s.parser.FileInputParser
import avro2s.schema.SchemaStore
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import java.io.File
import scala.io.Source
import scala.util.Using

class CodeGeneratorTest extends AnyFunSuite with Matchers {
  test("avro spec schema should produce expected output") {
    val code = generateCode("input/spec/spec.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("spec", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  test("arrays schema should produce expected output") {
    val code = generateCode("input/arrays/arrays.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("arrays", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  test("maps schema should produce expected output") {
    val code = generateCode("input/maps/maps.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("maps", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  test("namespaces schema should produce expected output") {
    val code = generateCode("input/namespaces/namespaces.avsc")

    code.foreach { code =>
      if (code.path.contains("explicit")) {
        val expectedCode = loadTestCode("namespaces/explicit", code.path.split("/").last)
        withClue("For path: " + code.path) {
          testResult(code, expectedCode)
        }
      } else {
        val expectedCode = loadTestCode("namespaces", code.path.split("/").last)
        withClue("For path: " + code.path) {
          testResult(code, expectedCode)
        }
      }
    }
  }

  test("unions schema should produce expected output") {
    val code = generateCode("input/unions/unions.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("unions", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  test("union with primitives schema should produce expected output") {
    val code = generateCode("input/unions/primitives.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("unions", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  test("options with null as second type schema should produce expected output") {
    val code = generateCode("input/unions/options-with-null-as-second-type.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("unions", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  test("reserved schema should produce expected output") {
    val code = generateCode("input/reserved/reserved-scala-3.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("reserved", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  private def generateCode(path: String): List[GeneratedCode] = {
    val resourcePath = getClass.getClassLoader.getResource(path).getPath
    val file = new File(resourcePath)
    val schemas = new FileInputParser().getSchemas(file)
    val schemaStore = new SchemaStore

    for {
      schema <- schemas
      generatedCode <- CodeGenerator.generateCode(schema, schemaStore, ScalaVersion.Scala_3)
    } yield generatedCode
  }

  private def loadTestCode(test: String, name: String): String = {
    Using(Source.fromFile(s"avro2s/src/test/scala-3/avro2s/test/$test/$name"))(_.getLines.mkString("\n")).get
  }

  private def testResult(gc: GeneratedCode, expected: String): Unit = {
    val generated = gc.code
    if (generated != expected) println(s"${gc.path}\n>$generated<\n\n")
    generated shouldBe expected
  }
}
