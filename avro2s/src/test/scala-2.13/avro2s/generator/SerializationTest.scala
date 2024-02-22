package avro2s.generator

import avro2s.test.arrays.{Arrays, Record => ArrayRecord}
import avro2s.test.maps.{Maps, Record => MapRecord}
import avro2s.test.namespaces.{Namespaces, RecordWithInheritedNamespace, RecordWithNamespaceInheritedFromIndirectParent}
import avro2s.test.namespaces.explicit.{RecordWithExplicitNamespace, RecordWithNamespaceInheritedFromDirectParent, RecordWithNamespaceInheritedFromIndirectNonTopLevelParent, RecordWithNamespaceInheritedViaArray, RecordWithNamespaceInheritedViaMap, RecordWithNamespaceInheritedViaUnion}
import avro2s.test.spec.{AvroSpec, Suit, md5}
import avro2s.test.unions.Unions
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import shapeless.{:+:, CNil, Coproduct}

class SerializationTest extends AnyFunSuite with Matchers {

  import avro2s.serialization.SerializationHelpers._

  test("arrays can be serialized and deserialized") {
    type Union1 = String :+: Int :+: CNil

    val arrays = Arrays(
      _array_of_arrays = List(List("a", "b", "c"), List("d", "e", "f")),
      _array_of_maps = List(Map("a" -> "b", "c" -> "d"), Map("e" -> "f", "g" -> "h")),
      _array_of_unions = List(Coproduct[Union1]("a"), Coproduct[Union1](1)),
      _array_of_records = List(ArrayRecord(_string = "a", _int = 1), ArrayRecord(_string = "b", _int = 2)),
      _array_of_enums = List(avro2s.test.arrays.Enum.A, avro2s.test.arrays.Enum.B),
      _array_of_fixed = List(avro2s.test.arrays.Fixed(Array[Byte](0x6f, 0x6e))),
      _array_of_bytes = List(Array[Byte](0x6f, 0x6e)),
      _array_of_strings = List("a", "b", "c"),
      _array_of_ints = List(1, 2, 3),
      _array_of_longs = List(1L, 2L, 3L),
      _array_of_floats = List(1.0f, 2.0f, 3.0f),
      _array_of_doubles = List(1.0, 2.0, 3.0),
      _array_of_booleans = List(true, false, true)
    )

    deserialize[Arrays](serialize(arrays), arrays.getSchema) shouldBe arrays
  }

  test("maps can be serialized and deserialized") {
    type Union1 = String :+: Int :+: CNil
    type Union2 = String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil
    type Union3 = String :+: Long :+: Boolean :+: Map[String, Map[String, Union2]] :+: scala.Null :+: CNil

    val maps = Maps(
      _map_of_maps = Map("a" -> Map("b" -> "c", "d" -> "e"), "f" -> Map("g" -> "h", "i" -> "j")),
      _map_of_union = Map("a" -> Coproduct[Union1]("b"), "c" -> Coproduct[Union1](1)),
      _map_of_union_of_map_of_union = Map(
        "a" -> Coproduct[Union3]("b"),
        "c" -> Coproduct[Union3](1L),
        "d" -> Coproduct[Union3](true),
        "e" -> Coproduct[Union3](Map("f" -> Map("g" -> Coproduct[Union2]("h"), "i" -> Coproduct[Union2](1L), "j" -> Coproduct[Union2](true), "k" -> Coproduct[Union2](1.0), "l" -> Coproduct[Union2](null))))
      ),
      _map_of_map_of_union = Map(
        "a" -> Map("b" -> Coproduct[Union2]("c"), "d" -> Coproduct[Union2](1L), "e" -> Coproduct[Union2](true), "f" -> Coproduct[Union2](1.0), "g" -> Coproduct[Union2](null)),
      ),
      _map_of_arrays_of_maps = Map(
        "a" -> List(Map("b" -> false), Map("c" -> true)),
      ),
      _map_of_arrays = Map(
        "a" -> List("b", "c", "d"),
        "b" -> List("b", "c", "d"),
      ),
      _map_of_map_of_arrays = Map(
        "a" -> Map("b" -> List("c", "d"), "e" -> List("f", "g")),
      ),
      _map_of_fixed = Map(
        "a" -> avro2s.test.maps.Fixed(Array[Byte](0x6f, 0x6e)),
        "b" -> avro2s.test.maps.Fixed(Array[Byte](0x6f, 0x6e)),
      ),
      _map_of_enum = Map(
        "a" -> avro2s.test.maps.Enum.A,
        "b" -> avro2s.test.maps.Enum.B,
      ),
      _map_of_record = Map(
        "a" -> MapRecord(a = "b"),
        "b" -> MapRecord(a = "c"),
      ),
      _map_of_bytes = Map(
        "a" -> Array[Byte](0x6f, 0x6e),
        "b" -> Array[Byte](0x6f, 0x6e),
      ),
      _map_of_string = Map("a" -> "b", "b" -> "c"),
      _map_of_int = Map("a" -> 1, "b" -> 2),
      _map_of_long = Map("a" -> 1L, "b" -> 2L),
      _map_of_float = Map("a" -> 1.0f, "b" -> 2.0f),
      _map_of_double = Map("a" -> 1.0, "b" -> 2.0),
      _map_of_boolean = Map("a" -> true, "b" -> false),
      _map_of_null = Map("a" -> null, "b" -> null),
    )

    deserialize[Maps](serialize(maps), maps.getSchema) shouldBe maps
  }

  test("namespaces can be serialized and deserialized") {
    val namespaces = Namespaces(
      _record_with_explicit_namespace = RecordWithExplicitNamespace(
        _string = "a",
        _record_with_namespace_inherited_from_direct_parent = RecordWithNamespaceInheritedFromDirectParent(
          _string = "b",
          _record_with_namespace_inherited_from_indirect_non_top_level_parent = RecordWithNamespaceInheritedFromIndirectNonTopLevelParent(_string = "c")
        ),
        _array_of_records = List(RecordWithNamespaceInheritedViaArray(_string = "d"), RecordWithNamespaceInheritedViaArray(_string = "e")),
        _map_of_records = Map("f" -> RecordWithNamespaceInheritedViaMap(_string = "g"), "h" -> RecordWithNamespaceInheritedViaMap(_string = "i")),
        _union_of_records = Coproduct[RecordWithNamespaceInheritedViaUnion :+: String :+: CNil](RecordWithNamespaceInheritedViaUnion(_string = "j")),
      ),
      _record_with_inherited_namespace = RecordWithInheritedNamespace(
        _string = "b",
        _record_with_namespace_inherited_from_indirect_parent = RecordWithNamespaceInheritedFromIndirectParent(_string = "c"),
      )
    )

    deserialize[Namespaces](serialize(namespaces), namespaces.getSchema) shouldBe namespaces
  }

  test("unions can be serialized and deserialized") {
    type Union1 = String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil
    type Union2 = String :+: Long :+: Boolean :+: Map[String, Map[String, Union1]] :+: scala.Null :+: CNil
    type Union3 = String :+: Long :+: Boolean :+: Map[String, Option[String]] :+: scala.Null :+: CNil
    type Union4 = String :+: Long :+: Boolean :+: List[Option[String]] :+: scala.Null :+: CNil
    type Union5 = String :+: Long :+: Boolean :+: List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil] :+: scala.Null :+: CNil
    type Union6 = String :+: Long :+: Boolean :+: List[List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil
    type Union7 = String :+: Long :+: Boolean :+: avro2s.test.unions.Record1 :+: avro2s.test.unions.Record2 :+: scala.Null :+: CNil
    type Union8 = String :+: Long :+: Boolean :+: avro2s.test.unions.Enum1 :+: scala.Null :+: CNil
    type Union9 = String :+: Long :+: Boolean :+: avro2s.test.unions.Fixed1 :+: scala.Null :+: CNil
    type Union10 = String :+: Long :+: scala.Null :+: CNil
    type Union11 = Int :+: String :+: CNil
    type Union12 = Long :+: String :+: CNil
    type Union13 = Float :+: String :+: CNil
    type Union14 = Double :+: String :+: CNil
    type Union15 = Boolean :+: String :+: CNil
    type Union16 = Array[Byte] :+: String :+: CNil
    type Union17 = String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil


    val unions = Unions(
      _union_of_map_of_union = Coproduct[Union2](Map("a" -> Map("b" -> Coproduct[Union1]("c"), "d" -> Coproduct[Union1](1L), "e" -> Coproduct[Union1](true), "f" -> Coproduct[Union1](1.0), "g" -> Coproduct[Union1](null)))),
      _union_of_map_of_option = Coproduct[Union3](Map("a" -> Some("b"), "c" -> None)),
      _union_of_array_of_option = Coproduct[Union4](List(Some("a"), None)),
      _union_of_array_of_union = Coproduct[Union5](List(Coproduct[Union1]("a"), Coproduct[Union1](1L), Coproduct[Union1](true), Coproduct[Union1](1.0), Coproduct[Union1](null))),
      _union_of_array_of_array = Coproduct[Union6](List(List(Coproduct[Union1]("a"), Coproduct[Union1](1L), Coproduct[Union1](true), Coproduct[Union1](1.0), Coproduct[Union1](null)), List(Coproduct[Union1]("b"), Coproduct[Union1](2L), Coproduct[Union1](false), Coproduct[Union1](2.0), Coproduct[Union1](null)))),
      _union_of_records = Coproduct[Union7](avro2s.test.unions.Record1(field1 = "a")),
      _union_of_enum = Coproduct[Union8](avro2s.test.unions.Enum1.sym2),
      _union_of_fixed = Coproduct[Union9](avro2s.test.unions.Fixed1(Array[Byte](0x6f))),
      _union_of_string = Coproduct[Union10]("a"),
      _union_of_int = Coproduct[Union11](1),
      _union_of_long = Coproduct[Union12](1L),
      _union_of_float = Coproduct[Union13](1.0f),
      _union_of_double = Coproduct[Union14](1.0),
      _union_of_boolean = Coproduct[Union15](true),
      _union_of_bytes = Coproduct[Union16](Array[Byte](0x6f, 0x6e)),
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
      _optional_map_of_union = Option(Map("a" -> Coproduct[Union17]("b"), "c" -> Coproduct[Union17](1L), "d" -> Coproduct[Union17](true), "e" -> Coproduct[Union17](1.0), "f" -> Coproduct[Union17](null))),
      _optional_array_of_union = Option(List(Coproduct[Union17]("a"), Coproduct[Union17](1L), Coproduct[Union17](true), Coproduct[Union17](1.0), Coproduct[Union17](null))),
    )

    deserialize[Unions](serialize(unions), unions.getSchema) shouldBe unions
  }

  test("spec can be serialized and deserialized") {
    // spec is a basic test based on the avro specification found at: https://avro.apache.org/docs/1.11.1/specification/

    val spec = AvroSpec(
      _null = null,
      _boolean = true,
      _int = 1,
      _long = 1L,
      _float = 1.0f,
      _double = 1.0,
      _bytes = Array[Byte](1, 2, 3),
      _string = "a",
      _array = List("a", "b", "c"),
      _map = Map("a" -> 1L, "b" -> 2L, "c" -> 3L),
      _union_other = Coproduct[String :+: Int :+: CNil]("a"),
      _union_nullable = Some("string"),
      _fixed = md5(Array[Byte](0x6f, 0x6e, 0x65, 0x00, 0x74, 0x77, 0x6f, 0x00, 0x74, 0x68, 0x72, 0x65, 0x65, 0x72, 0x65, 0x65)),
      _enum = Suit.HEARTS
    )

    deserialize[AvroSpec](serialize(spec), spec.getSchema) shouldBe spec
  }
  
  test("reserved can be serialized and deserialized") {
    val reserved = avro2s.test.reserved.Reserved(
      `abstract` = null,
      `case` = true,
      `catch` = 1,
      `class` = 1L,
      `def` = 1.0f,
      `do` = 1.0,
      `else` = Array[Byte](1, 2, 3),
      `extends` = "a",
      `false` = null,
      `final` = true,
      `finally` = 1,
      `for` = 1L,
      `forSome` = 1.0f,
      `if` = 1.0,
      `implicit` = Array[Byte](1, 2, 3),
      `import` = "a",
      `lazy` = null,
      `macro` = true,
      `match` = 1,
      `new` = 1L,
      `null` = 1.0f,
      `object` = 1.0,
      `override` = Array[Byte](1, 2, 3),
      `package` = "a",
      `private` = null,
      `protected` = true,
      `return` = 1,
      `sealed` = 1L,
      `super` = 1.0f,
      `this` = 1.0,
      `throw` = Array[Byte](1, 2, 3),
      `trait` = "a",
      `try` = null,
      `true` = true,
      `type` = 1,
      `val` = 1L,
      `var` = 1.0f,
      `while` = 1.0,
      `with` = Array[Byte](1, 2, 3),
      `yield` = "a"
    )

    deserialize[avro2s.test.reserved.Reserved](serialize(reserved), reserved.getSchema) shouldBe reserved
  }
}