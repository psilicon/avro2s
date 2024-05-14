package avro2s.filehelper

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class FileHelperTest extends AnyFunSuite with Matchers {
  test("findAvscFiles should return a list of all avsc files in a directory") {
    val directory = "avro2s/src/test/resources/input/default"
    val expectedFiles = List(
      "avro2s/src/test/resources/input/default/arrays/arrays.avsc",
      "avro2s/src/test/resources/input/default/namespaces/namespaces.avsc",
      "avro2s/src/test/resources/input/default/spec/spec.avsc",
      "avro2s/src/test/resources/input/default/unions/unions.avsc",
      "avro2s/src/test/resources/input/default/unions/options-with-null-as-second-type.avsc",
      "avro2s/src/test/resources/input/default/maps/maps.avsc",
    )

    FileHelper.findAvscFiles(directory).map(_.getPath) should contain allElementsOf expectedFiles
  }

  test("getSchemasFromFiles should return a list of schemas from a list of files") {
    val files = List(
      new java.io.File("avro2s/src/test/resources/input/default/unions/unions.avsc"),
      new java.io.File("avro2s/src/test/resources/input/default/maps/maps.avsc"),
      new java.io.File("avro2s/src/test/resources/input/default/arrays/arrays.avsc")
    )
    val expectedSchemas = List("avro2s.test.unions.Unions", "avro2s.test.maps.Maps", "avro2s.test.arrays.Arrays")

    FileHelper.getSchemasFromFiles(files).map(s => s"${s.getNamespace}.${s.getName}") should contain theSameElementsAs expectedSchemas
  }
}
