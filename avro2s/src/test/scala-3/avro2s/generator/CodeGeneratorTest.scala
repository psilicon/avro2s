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
    val code = generateCode("input/default/spec/spec.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("spec", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  test("arrays schema should produce expected output") {
    val code = generateCode("input/default/arrays/arrays.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("arrays", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  test("maps schema should produce expected output") {
    val code = generateCode("input/default/maps/maps.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("maps", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  test("namespaces schema should produce expected output") {
    val code = generateCode("input/default/namespaces/namespaces.avsc")

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
    val code = generateCode("input/default/unions/unions.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("unions", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  test("union with primitives schema should produce expected output") {
    val code = generateCode("input/scala-3/unions/primitives.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("unions", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  test("options with null as second type schema should produce expected output") {
    val code = generateCode("input/default/unions/options-with-null-as-second-type.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("unions", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  test("reserved schema should produce expected output") {
    val code = generateCode("input/scala-3/reserved/reserved-scala-3.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("reserved", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  test("logical types should produce expected output") {
    val code = generateCode("input/logical-enabled/logical/logical.avsc", logicalTypesEnabled = true)

    code.foreach { code =>
      val expectedCode = loadTestCode("logical", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  test("logical types disabled should produce expected output") {
    val code = generateCode("input/default/logical/logical-disabled.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("logical", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  test("logical complex types should produce expected output") {
    val code = generateCode("input/logical-enabled/logical/logical-complex.avsc", logicalTypesEnabled = true)

    code.foreach { code =>
      val expectedCode = loadTestCode("logical", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  test("logical complex types disabled should produce expected output") {
    val code = generateCode("input/default/logical/logical-complex-disabled.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("logical", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }
  
  test("complex options schema should produce expected output") {
    val code = generateCode("input/default/unions/complex-options.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("unions", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }
  
  test("empty records should produce expected output") {
    val code = generateCode("input/default/records/empty-records.avsc")

    code.foreach { code =>
      val expectedCode = loadTestCode("records", code.path.split("/").last)
      testResult(code, expectedCode)
    }
  }

  test("large schema should produce chunked SCHEMA$ val") {
    val padding = "a" * 65001
    val schemaJson =
      s"""{"type":"record","name":"BigRecord","namespace":"test","doc":"$padding","fields":[{"name":"id","type":"string"}]}"""
    val schema = new org.apache.avro.Schema.Parser().parse(schemaJson)
    val schemaStore = new SchemaStore
    val generatorConfig = GeneratorConfig(ScalaVersion.Scala_3, false)

    val results = CodeGenerator.generateCode(schema, schemaStore, generatorConfig)

    results should have length 1
    val code = results.head.code
    code should include("Array(")
    code should include(".mkString")
    val tripleQuotedSegments = code.split("\"\"\"").zipWithIndex.collect {
      case (seg, i) if i % 2 == 1 => seg
    }
    tripleQuotedSegments should not be empty
    tripleQuotedSegments.foreach(seg => seg.length should be <= 65000)
  }

  test("large avsc file with over 65000 chars should produce chunked SCHEMA$ val") {
    val results = generateCode("input/default/large/large.avsc")

    results should have length 1
    val code = results.head.code
    code should include("Array(")
    code should include(".mkString")
    val tripleQuotedSegments = code.split("\"\"\"").zipWithIndex.collect {
      case (seg, i) if i % 2 == 1 => seg
    }
    tripleQuotedSegments should not be empty
    tripleQuotedSegments.foreach(seg => seg.length should be <= 65000)
  }

  def generateCode(path: String, logicalTypesEnabled: Boolean = false): List[GeneratedCode] = {
    val generatorConfig = GeneratorConfig(ScalaVersion.Scala_3, logicalTypesEnabled)

    val resourcePath = getClass.getClassLoader.getResource(path).getPath
    val file = new File(resourcePath)
    val schemas = new FileInputParser().getSchemas(file)
    val schemaStore = new SchemaStore

    for {
      schema <- schemas
      generatedCode <- CodeGenerator.generateCode(schema, schemaStore, generatorConfig)
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
