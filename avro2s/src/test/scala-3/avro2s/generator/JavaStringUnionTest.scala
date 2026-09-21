package avro2s.generator

import avro2s.serialization.SerializationHelpers._
import avro2s.test.javastring.JavaStrings
import org.apache.avro.generic.GenericData
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class JavaStringUnionTest extends AnyFunSuite with Matchers {
  private def record = JavaStrings(
    optional_name = Some("a"),
    name_or_count = "b",
    names = List("c", 1),
    lookup = Map("d" -> "e", "f" -> 2))

  test("the schema keeps avro.java.string, so these tests cannot pass vacuously") {
    // Without the property the reader supplies Utf8 and every assertion below holds either way.
    val stringBranch = JavaStrings.SCHEMA$.getField("name_or_count").schema.getTypes.get(0)
    stringBranch.getProp(GenericData.STRING_PROP) shouldBe "String"
  }

  test("union string branches round-trip when the reader supplies java.lang.String") {
    deserialize[JavaStrings](serialize(record), JavaStrings.SCHEMA$) shouldBe record
  }

  test("put accepts a java.lang.String in every union position") {
    // What the reader actually hands over, asserted without going through the reader.
    val target = new JavaStrings()
    target.put(0, "a")
    target.put(1, "b")
    target.put(2, java.util.List.of[AnyRef]("c", Integer.valueOf(1)))
    target.put(3, java.util.Map.of[AnyRef, AnyRef]("d", "e", "f", Integer.valueOf(2)))
    target shouldBe record
  }

  test("put still accepts Utf8, which is what a schema without the property yields") {
    val target = new JavaStrings()
    target.put(1, new org.apache.avro.util.Utf8("b"))
    target.name_or_count shouldBe "b"
  }
}
