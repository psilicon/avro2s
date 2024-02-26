package avro2s.generator

import avro2s.serialization.SerializationHelpers._
import avro2s.test.unions.{OptionsWithNullAsSecondType, Unions, UnionOfPrimitives}
import avro2s.test.arrays.{Arrays, Record => ArrayRecord}
import avro2s.test.maps.{Maps, Record => MapRecord}
import avro2s.test.namespaces.{Namespaces, RecordWithInheritedNamespace, RecordWithNamespaceInheritedFromIndirectParent}
import avro2s.test.namespaces.explicit.{RecordWithExplicitNamespace, RecordWithNamespaceInheritedFromDirectParent, RecordWithNamespaceInheritedFromIndirectNonTopLevelParent, RecordWithNamespaceInheritedViaArray, RecordWithNamespaceInheritedViaMap, RecordWithNamespaceInheritedViaUnion}
import avro2s.test.spec.{AvroSpec, Suit, md5}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SerializationTest extends AnyFunSuite with Matchers {
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

  test("unions with primitives can be serialized and deserialized") {
    List(100L, false, 1).foreach { value =>
      val primitives = UnionOfPrimitives(value)
      deserialize[UnionOfPrimitives](serialize(primitives), primitives.getSchema) shouldBe primitives
    }
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
      _union_other = "a",
      _union_nullable = Some("string"),
      _fixed = md5(Array[Byte](0x6f, 0x6e, 0x65, 0x00, 0x74, 0x77, 0x6f, 0x00, 0x74, 0x68, 0x72, 0x65, 0x65, 0x72, 0x65, 0x65)),
      _enum = Suit.HEARTS
    )

    deserialize[AvroSpec](serialize(spec), spec.getSchema) shouldBe spec
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
        _union_of_records = RecordWithNamespaceInheritedViaUnion(_string = "j"),
      ),
      _record_with_inherited_namespace = RecordWithInheritedNamespace(
        _string = "b",
        _record_with_namespace_inherited_from_indirect_parent = RecordWithNamespaceInheritedFromIndirectParent(_string = "c"),
      )
    )

    deserialize[Namespaces](serialize(namespaces), namespaces.getSchema) shouldBe namespaces
  }

  test("maps can be serialized and deserialized") {
    val maps = Maps(
      _map_of_maps = Map("a" -> Map("b" -> "c", "d" -> "e"), "f" -> Map("g" -> "h", "i" -> "j")),
      _map_of_union = Map("a" -> "b", "c" -> 1),
      _map_of_union_of_map_of_union = Map(
        "a" -> "b",
        "c" -> 1L,
        "d" -> true,
        "e" -> Map("f" -> Map("g" -> "h", "i" -> 1L, "j" -> true, "k" -> 1.0, "l" -> null))
      ),
      _map_of_map_of_union = Map(
        "a" -> Map("b" -> "c", "d" -> 1L, "e" -> true, "f" -> 1.0, "g" -> null),
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

  test("arrays can be serialized and deserialized") {
    val arrays = Arrays(
      _array_of_arrays = List(List("a", "b", "c"), List("d", "e", "f")),
      _array_of_maps = List(Map("a" -> "b", "c" -> "d"), Map("e" -> "f", "g" -> "h")),
      _array_of_unions = List("a", 1),
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
  
  test("reserved can be serialized and deserialized") {
    val reserved = avro2s.test.reserved.ReservedScala3(
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
      `yield` = "a",
      `enum` = null,
      `export` = true,
      `given` = 1,
      `then` = 1L
    )

    deserialize[avro2s.test.reserved.ReservedScala3](serialize(reserved), reserved.getSchema) shouldBe reserved
  }
  
  test("options with null as second type can be serialized and deserialized") {
    val optionsWithNullAsSecondType = avro2s.test.unions.OptionsWithNullAsSecondType(
      _simple = Some("a"),
      _optional_array = Some(List(true, false, true)),
      _array_of_options = List(Some("a"), None),
      _map_of_options = Map("a" -> Some("b"), "c" -> None)
    )

    deserialize[avro2s.test.unions.OptionsWithNullAsSecondType](serialize(optionsWithNullAsSecondType), optionsWithNullAsSecondType.getSchema) shouldBe optionsWithNullAsSecondType
  }
}
