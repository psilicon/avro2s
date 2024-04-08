package avro2s.filehelper

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class FileHelperTest extends AnyFunSuite with Matchers {
  test("findAvscFiles should return a list of all avsc files in a directory") {
    val directory = "avro2s/src/test/resources/input"
    val expectedFiles = List(
      "avro2s/src/test/resources/input/arrays/arrays.avsc",
      "avro2s/src/test/resources/input/namespaces/namespaces.avsc",
      "avro2s/src/test/resources/input/reserved/reserved-scala-3.avsc",
      "avro2s/src/test/resources/input/reserved/reserved-scala-2.avsc",
      "avro2s/src/test/resources/input/spec/spec.avsc",
      "avro2s/src/test/resources/input/unions/unions.avsc",
      "avro2s/src/test/resources/input/unions/options-with-null-as-second-type.avsc",
      "avro2s/src/test/resources/input/unions/primitives.avsc",
      "avro2s/src/test/resources/input/maps/maps.avsc",
      "avro2s/src/test/resources/input/logical/logical.avsc",
      "avro2s/src/test/resources/input/logical/logical-disabled.avsc",
      "avro2s/src/test/resources/input/logical/logical-complex.avsc",
      "avro2s/src/test/resources/input/logical/logical-complex-disabled.avsc",
    )

    FileHelper.findAvscFiles(directory).map(_.getPath) should contain theSameElementsAs expectedFiles
  }

  test("getSchemasFromFiles should return a list of schemas from a list of files") {
    val files = List(
      new java.io.File("avro2s/src/test/resources/input/unions/unions.avsc"),
      new java.io.File("avro2s/src/test/resources/input/maps/maps.avsc"),
      new java.io.File("avro2s/src/test/resources/input/arrays/arrays.avsc")
    )
    val expectedSchemas = List("avro2s.test.unions.Unions", "avro2s.test.maps.Maps", "avro2s.test.arrays.Arrays")

    FileHelper.getSchemasFromFiles(files).map(s => s"${s.getNamespace}.${s.getName}") should contain theSameElementsAs expectedSchemas
  }
}
