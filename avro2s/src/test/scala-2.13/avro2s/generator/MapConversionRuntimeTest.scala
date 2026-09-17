package avro2s.generator

import avro2s.serialization.SerializationHelpers.serialize
import avro2s.test.maps.Maps
import org.apache.avro.io.DecoderFactory
import org.apache.avro.specific.SpecificDatumReader
import org.apache.avro.util.Utf8
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class MapConversionRuntimeTest extends AnyFunSuite with Matchers {

  test("empty map conversion reuses the immutable singleton without traversing entries") {
    val empty = new java.util.HashMap[Utf8, Utf8]() {
      override def entrySet(): java.util.Set[java.util.Map.Entry[Utf8, Utf8]] =
        throw new AssertionError("Empty map conversion must not request its entries")
    }
    val record = new Maps()
    for (field <- 0 until record.getSchema.getFields.size()) {
      record.put(field, empty)
      record.get(field).asInstanceOf[java.util.Map[_, _]].isEmpty shouldBe true
    }
    assert(record._map_of_string eq Map.empty[String, String])

    record.put(record.getSchema.getField("_map_of_maps").pos(), java.util.Collections.singletonMap(new Utf8("nested"), empty))
    record._map_of_maps shouldBe Map("nested" -> Map.empty)
    assert(record._map_of_maps("nested") eq Map.empty[String, String])

    val arrays = new avro2s.test.arrays.Arrays()
    arrays.put(arrays.getSchema.getField("_array_of_maps").pos(), java.util.Collections.singletonList(empty))
    arrays._array_of_maps shouldBe List(Map.empty)
    assert(arrays._array_of_maps.head eq Map.empty[String, String])

    val unions = new avro2s.test.unions.Unions()
    unions.put(unions.getSchema.getField("_optional_map").pos(), empty)
    unions._optional_map shouldBe Some(Map.empty)
    assert(unions._optional_map.get eq Map.empty[String, String])
    val unionField = unions.getSchema.getField("_union_of_map_of_option").pos()
    unions.put(unionField, empty)
    unions.get(unionField).asInstanceOf[java.util.Map[_, _]].isEmpty shouldBe true
  }

  test("map getters preserve entries and detached mutability across sizing boundaries and hash collisions") {
    val collidingKeys = (1 to 7).foldLeft(List("")) { (keys, _) =>
      keys.flatMap(prefix => List(prefix + "Aa", prefix + "BB"))
    }
    assert(collidingKeys.map(_.hashCode).distinct.size == 1)
    val record = new Maps()
    val field = record.getSchema.getField("_map_of_int").pos()
    val genericReader = new org.apache.avro.generic.GenericDatumReader[org.apache.avro.generic.GenericData.Record](record.getSchema)
    for (size <- List(0, 1, 12, 13, 24, 25, 64, 128)) {
      val expected = collidingKeys.take(size).zipWithIndex.map { case (key, index) => key -> (1000 + index) }.toMap
      record._map_of_int = expected
      record._map_of_maps = Map("nested" -> Map("key" -> "value"))
      val result = record.get(field).asInstanceOf[java.util.Map[String, java.lang.Integer]]
      result.size() shouldBe size
      expected.foreach { case (key, value) => result.get(key).intValue() shouldBe value }
      result.clear()
      record._map_of_int shouldBe expected
      val nestedField = record.getSchema.getField("_map_of_maps").pos()
      record.get(nestedField).asInstanceOf[java.util.Map[String, java.util.Map[String, String]]].get("nested").clear()
      record._map_of_maps shouldBe Map("nested" -> Map("key" -> "value"))

      val decoded = genericReader.read(null, DecoderFactory.get().binaryDecoder(serialize(record), null))
      val wireMap = decoded.get("_map_of_int").asInstanceOf[java.util.Map[Utf8, java.lang.Integer]]
      wireMap.size() shouldBe size
      expected.foreach { case (key, value) => wireMap.get(new Utf8(key)).intValue() shouldBe value }
    }
  }
  test("map put converts wire keys and values into an independent immutable map") {
    val input = new java.util.HashMap[Utf8, java.lang.Integer]()
    val expected = (0 until 128).map(i => s"key_$i" -> (1000 + i)).toMap
    expected.foreach { case (key, value) => input.put(new Utf8(key), value) }

    val record = new Maps()
    record.put(record.getSchema.getField("_map_of_int").pos(), input)
    record._map_of_int shouldBe expected
    input.clear()
    record._map_of_int shouldBe expected

    val inner = new java.util.HashMap[Utf8, Utf8]()
    inner.put(new Utf8("inner"), new Utf8("value"))
    val outer = new java.util.HashMap[Utf8, java.util.Map[Utf8, Utf8]]()
    outer.put(new Utf8("outer"), inner)
    record.put(record.getSchema.getField("_map_of_maps").pos(), outer)
    inner.clear()
    outer.clear()
    record._map_of_maps shouldBe Map("outer" -> Map("inner" -> "value"))
  }

  test("map deserialization supports record reuse across populated and empty maps") {
    val reused = new Maps()
    val reader = new SpecificDatumReader[Maps](reused.getSchema)
    List(128, 0, 1).foreach { size =>
      val input = new Maps()
      input._map_of_int = (0 until size).map(i => s"key_$i" -> (1000 + i)).toMap
      input._map_of_maps = (0 until size).map(i => s"key_$i" -> Map("inner" -> s"value_$i")).toMap
      input._map_of_arrays = Map("items" -> List("a", "b"))
      val decoder = DecoderFactory.get().binaryDecoder(serialize(input), null)
      val result = reader.read(reused, decoder)

      assert(result eq reused)
      result._map_of_int shouldBe input._map_of_int
      result._map_of_maps shouldBe input._map_of_maps
      result._map_of_arrays shouldBe input._map_of_arrays
    }
  }
}
