package avro2s.generator

import avro2s.serialization.SerializationHelpers.serialize
import avro2s.test.maps.Maps
import org.apache.avro.io.DecoderFactory
import org.apache.avro.specific.SpecificDatumReader
import org.apache.avro.util.Utf8
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class MapConversionRuntimeTest extends AnyFunSuite with Matchers {
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
