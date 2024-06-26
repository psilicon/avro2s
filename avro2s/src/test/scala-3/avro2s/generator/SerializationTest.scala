package avro2s.generator

import avro2s.serialization.SerializationHelpers._
import avro2s.test.unions.{OptionsWithNullAsSecondType, UnionOfPrimitives, Unions}
import avro2s.test.arrays.{Arrays, Record => ArrayRecord, Record1 => ArrayRecord1, Record2 => ArrayRecord2, RecordA => ArrayRecordA, RecordB => ArrayRecordB, EnumA => ArrayEnumA, EnumB => ArrayEnumB, FixedA => ArrayFixedA}
import avro2s.test.maps.{Maps, Record => MapRecord}
import avro2s.test.namespaces.{Namespaces, RecordWithInheritedNamespace, RecordWithNamespaceInheritedFromIndirectParent}
import avro2s.test.namespaces.explicit.{RecordWithExplicitNamespace, RecordWithNamespaceInheritedFromDirectParent, RecordWithNamespaceInheritedFromIndirectNonTopLevelParent, RecordWithNamespaceInheritedViaArray, RecordWithNamespaceInheritedViaMap, RecordWithNamespaceInheritedViaUnion}
import avro2s.test.spec.{AvroSpec, Suit, md5}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import java.time.{Instant, LocalDate}
import java.util.UUID

class SerializationTest extends AnyFunSuite with Matchers {
  test("unions can be serialized and deserialized") {
    val unions = Unions(
      _union_of_map_of_union = Some(Map("a" -> Map("b" -> Some("c"), "d" -> Some(1L), "e" -> Some(true), "f" -> Some(1.0), "g" -> None))),
      _union_of_map_of_option = Some(Map("a" -> Some("b"), "c" -> None)),
      _union_of_array_of_option = Some(List(Some("a"), None)),
      _union_of_array_of_union = Some(List(Some("a"), Some(1L), Some(true), Some(1.0), None, Some(Array[Byte](0x6f, 0x6e)))),
      _union_of_array_of_array = Some(List(List(Some("a"), Some(1L), Some(true), Some(1.0), None))),
      _union_of_records = Some(avro2s.test.unions.Record1(field1 = "a")),
      _union_of_enum = Some(avro2s.test.unions.Enum1.sym2),
      _union_of_fixed = Some(0x6f),
      _union_of_string = Some("a"),
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
      _optional_map_of_union = Option(Map("a" -> Some("b"), "c" -> Some(1L), "d" -> Some(true), "e" -> Some(1.0), "f" -> None)),
      _optional_array_of_union = Option(List(Some("a"), Some(1L), Some(true), Some(1.0), None)),
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
        "a" -> Some("b"),
        "c" -> Some(1L),
        "d" -> Some(true),
        "e" -> Some(Map("f" -> Map("g" -> Some("h"), "i" -> Some(1L), "j" -> Some(true), "k" -> Some(1.0), "l" -> None)))
      ),
      _map_of_map_of_union = Map(
        "a" -> Map("b" -> Some("c"), "d" -> Some(1L), "e" -> Some(true), "f" -> Some(1.0), "g" -> None),
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
      _map_of_union_of_record = Map(
        "a" -> Some(MapRecord(a = "b")),
        "b" -> Some(1),
        "c" -> None,
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
      _map_of_union_of_array = Map(
        "a" -> Some(List("b", "c", "d")),
        "b" -> Some(1),
        "c" -> None,
      ),
    )

    deserialize[Maps](serialize(maps), maps.getSchema) shouldBe maps
  }

  test("arrays can be serialized and deserialized") {
    val arrays = Arrays(
      _array_of_arrays = List(List("a", "b", "c"), List("d", "e", "f")),
      _array_of_maps = List(Map("a" -> "b", "c" -> "d"), Map("e" -> "f", "g" -> "h")),
      _array_of_unions = List("a", 1),
      _array_of_records = List(ArrayRecord(_string = "a", _int = 1), ArrayRecord(_string = "b", _int = 2)),
      _array_of_union_of_records = List(ArrayRecord1(_string = "a", _int = 1), ArrayRecord2(_string = "b", _int = 2), 4),
      _array_of_enums = List(avro2s.test.arrays.Enum.A, avro2s.test.arrays.Enum.B),
      _array_of_fixed = List(avro2s.test.arrays.Fixed(Array[Byte](0x6f, 0x6e))),
      _array_of_bytes = List(Array[Byte](0x6f, 0x6e)),
      _array_of_strings = List("a", "b", "c"),
      _array_of_ints = List(1, 2, 3),
      _array_of_longs = List(1L, 2L, 3L),
      _array_of_floats = List(1.0f, 2.0f, 3.0f),
      _array_of_doubles = List(1.0, 2.0, 3.0),
      _array_of_booleans = List(true, false, true),
      _array_of_union_of_only_records = List(ArrayRecordA("A"), ArrayRecordB("B")),
      _array_of_union_of_only_enums = List(ArrayEnumA.A, ArrayEnumB.B),
      _array_of_union_of_only_fixed = List(ArrayFixedA(Array[Byte](0x6f, 0x6e))),
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


  test("logical types can be serialized and deserialized") {
    val logicalTypes = avro2s.test.logical.LogicalTypes(
      _uuid = UUID.randomUUID(),
      _date = java.time.LocalDate.now(),
      _time_millis = java.time.LocalTime.now(),
      _time_micros = java.time.LocalTime.now(),
      _timestamp_millis = java.time.Instant.now(),
      _timestamp_micros = java.time.Instant.now(),
      _local_timestamp_millis = java.time.LocalDateTime.now(),
      _local_timestamp_micros = java.time.LocalDateTime.now()
    )

    deserialize[avro2s.test.logical.LogicalTypes](serialize(logicalTypes), logicalTypes.getSchema) shouldBe logicalTypes
  }

  test("logical types disabled can be serialized and deserialized") {
    val logicalTypesDisabled = avro2s.test.logical.LogicalTypesDisabled(
      _uuid = UUID.randomUUID().toString,
      _date = java.time.LocalDate.now().toEpochDay.toInt,
      _time_millis = java.time.LocalTime.now().toNanoOfDay.toInt / 1000000,
      _time_micros = java.time.LocalTime.now().toNanoOfDay / 1000,
      _timestamp_millis = java.time.Instant.now().toEpochMilli,
      _timestamp_micros = java.time.Instant.now().toEpochMilli * 1000,
      _local_timestamp_millis = java.time.LocalDateTime.now().toInstant(java.time.ZoneOffset.UTC).toEpochMilli,
      _local_timestamp_micros = java.time.LocalDateTime.now().toInstant(java.time.ZoneOffset.UTC).toEpochMilli * 1000
    )

    deserialize[avro2s.test.logical.LogicalTypesDisabled](serialize(logicalTypesDisabled), logicalTypesDisabled.getSchema) shouldBe logicalTypesDisabled
  }

  test("logical complex types can be serialized and deserialized") {
    val logicalComplexTypes = avro2s.test.logical.ComplexLogicalTypes(
      _map = Map("a" -> UUID.randomUUID, "c" -> UUID.randomUUID),
      _map_alt = Map("a" -> LocalDate.now, "c" -> LocalDate.now),
      _array = List(LocalDate.now),
      _union = Instant.now,
      _option = Some(UUID.randomUUID),
      _option_alt = Some(LocalDate.now),
      _map_union = Map("a" -> Instant.now, "c" -> 1),
      _map_option = Map("a" -> Some(Instant.now), "c" -> None),
      _map_array = Map("a" -> List(LocalDate.now, LocalDate.now)),
      _union_map = Map("a" -> UUID.randomUUID),
      _union_map_alt = Map("a" -> LocalDate.now),
      _union_array = List(LocalDate.now),
      _array_map = List(Map("a" -> UUID.randomUUID), Map("e" -> UUID.randomUUID)),
      _array_map_alt = List(Map("a" -> LocalDate.now), Map("e" -> LocalDate.now)),
      _array_union = List(Instant.now, 1),
      _array_option = List(Some(UUID.randomUUID), None),
      _array_option_alt = List(Some(LocalDate.now), None)
    )

    val serialized = serialize(logicalComplexTypes)
    deserialize[avro2s.test.logical.ComplexLogicalTypes](serialized, logicalComplexTypes.getSchema) shouldBe logicalComplexTypes
  }

  test("logical complex types disabled can be serialized and deserialized") {
    val logicalComplexTypesDisabled = avro2s.test.logical.ComplexLogicalTypesDisabled(
      _map = Map("a" -> UUID.randomUUID.toString, "c" -> UUID.randomUUID.toString),
      _array = List(LocalDate.now.toEpochDay.toInt),
      _union = Instant.now.toEpochMilli,
      _option = Some(UUID.randomUUID.toString),
      _map_union = Map("a" -> Instant.now.toEpochMilli, "c" -> 1L),
      _map_array = Map("a" -> List(LocalDate.now.toEpochDay.toInt, LocalDate.now.toEpochDay.toInt)),
      _union_map = Map("a" -> UUID.randomUUID.toString),
      _union_array = List(LocalDate.now.toEpochDay.toInt),
      _array_map = List(Map("a" -> UUID.randomUUID.toString), Map("e" -> UUID.randomUUID.toString)),
      _array_union = List(Instant.now.toEpochMilli, 1L),
      _array_option = List(Some(UUID.randomUUID.toString), None)
    )

    val serialized = serialize(logicalComplexTypesDisabled)
    deserialize[avro2s.test.logical.ComplexLogicalTypesDisabled](serialized, logicalComplexTypesDisabled.getSchema) shouldBe logicalComplexTypesDisabled
  }

  test("complex options can be serialized and deserialized") {
    val complexOptions = avro2s.test.unions.ComplexOptions(
      _map_of_option_of_record = Map("a" -> Some(avro2s.test.unions.RecordForComplexOptions(field1 = "b")), "c" -> None),
      _map_of_option_of_map = Map("a" -> Some(Map("b" -> "c", "d" -> "e")), "f" -> None),
      _map_of_option_of_array = Map("a" -> Some(List("b", "c")), "d" -> None),
      _array_of_option_of_record = List[Option[avro2s.test.unions.RecordForComplexOptions]](Some(avro2s.test.unions.RecordForComplexOptions(field1 = "a")), None),
      _array_of_option_of_map = List[Option[Map[String, String]]](Some(Map("a" -> "b", "c" -> "d")), None),
      _array_of_option_of_array = List[Option[List[String]]](Some(List("a", "b", "c")), Some(List("d", "e", "f")), None),
      _array_of_map_of_option_of_record = List(Map("a" -> Some(avro2s.test.unions.RecordForComplexOptions(field1 = "b")), "c" -> None)),
      _map_of_array_of_option_of_record = Map("a" -> List(Some(avro2s.test.unions.RecordForComplexOptions(field1 = "b")), None)),
      _map_of_option_of_bytes = Map("a" -> Some(Array[Byte](0x6f, 0x6e)), "b" -> None),
      _map_of_option_of_fixed = Map("a" -> Some(avro2s.test.unions.FixedForComplexOptions()), "b" -> None),
      _map_of_option_of_enum = Map("a" -> Some(avro2s.test.unions.EnumForComplexOptions.A), "b" -> None),
    )

    val serialized = serialize(complexOptions)
    deserialize[avro2s.test.unions.ComplexOptions](serialized, complexOptions.getSchema) shouldBe complexOptions
  }
  
  test("empty records can be serialized and deserialized") {
    val emptyRecords = avro2s.test.records.EmptyRecords(
      _string = "foo",
      _empty_record = avro2s.test.records.EmptyRecord(),
      _int = 5
    )
    
    val serialized = serialize(emptyRecords)
    deserialize[avro2s.test.records.EmptyRecords](serialized, emptyRecords.getSchema) shouldBe emptyRecords
  }
}
