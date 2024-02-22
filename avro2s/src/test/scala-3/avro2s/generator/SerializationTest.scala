package avro2s.generator

import avro2s.serialization.SerializationHelpers._
import avro2s.test.unions.{Optionals, UnionSimple, Unions}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SerializationTest extends AnyFunSuite with Matchers {
  test("unions can be serialised and deserialised") {
    List("moo", 100L, false, null, Map("foo" -> 2.0, "bar" -> 4)).foreach { value =>
      val us = UnionSimple(value)
      deserialize[UnionSimple](serialize(us), us.getSchema) shouldBe us
    }
  }

  test("optionals can be serialised and deserialized") {
    val v = Optionals(Some("foo"), Some(List(true)), List(Some("moo"), None, Some("bar")))
    val got = deserialize[Optionals](serialize(v), v.getSchema)
//    println(got)
    got shouldBe v
  }

  test("unions can be serialized and deserialized") {
    val unions = Unions(
      _union_of_map_of_union = null,
      _union_of_map_of_option = Map("a" -> Some("b"), "c" -> None),
      _union_of_array_of_option = List(Some("a"), None),
      _union_of_array_of_union = null,
      _union_of_array_of_array = null,
      _union_of_records = avro2s.test.unions.Record1(field1 = "a"),
      _union_of_enum = avro2s.test.unions.Enum1.sym2,
      _union_of_fixed = 0x6f,
      _union_of_string = "a",
      _union_of_int = 1,
      _union_of_long = 1L,
      _union_of_float = 1.0f,
      _union_of_double = 1.0,
      _union_of_boolean = true,
      _union_of_bytes = Array[Byte](0x6f, 0x6e),
      _optional_record = Option(avro2s.test.unions.Record3(field3 = "a")),
      _optional_enum = Option(avro2s.test.unions.Enum2.sym4),
      _optional_fixed = Option(avro2s.test.unions.Fixed2(Array[Byte](0x6f))),
      _optional_string = Option("a"),
      _optional_int = Option(1),
      _optional_long = Option(1L),
      _optional_float = Option(1.0f),
      _optional_double = Option(1.0),
      _optional_boolean = Option(true),
      _optional_bytes = Option(Array[Byte](0x6f, 0x6e)),
      _optional_map = Option(Map("a" -> "b", "c" -> "d")),
      _optional_array = Option(List("a", "b", "c")),
      _optional_map_of_array = Option(Map("a" -> List("b", "c"), "d" -> List("e", "f"))),
      _optional_array_of_map = Option(List(Map("a" -> "b", "c" -> "d"), Map("e" -> "f", "g" -> "h"))),
      _optional_map_of_map = Option(Map("a" -> Map("b" -> "c", "d" -> "e"), "f" -> Map("g" -> "h", "i" -> "j"))),
      _optional_array_of_array = Option(List(List("a", "b", "c"), List("d", "e", "f"))),
      _optional_map_of_union = Option(Map("a" -> null)),
      _optional_array_of_union = Option(List(null)),
    )

    deserialize[Unions](serialize(unions), unions.getSchema) shouldBe unions
  }
}
