package avro2s.generator

import avro2s.serialization.SerializationHelpers.serialize
import avro2s.test.arrays.Arrays
import avro2s.test.unions.{ComplexOptions, OptionsWithNullAsSecondType}
import org.apache.avro.generic.{GenericData, GenericDatumWriter}
import org.apache.avro.io.{DecoderFactory, EncoderFactory}
import org.apache.avro.specific.{SpecificDatumReader, SpecificRecordBase}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

class GeneratedArrayRuntimeTest extends AnyFunSuite with Matchers {
  private def populatedArrays(): Arrays = {
    val value = new Arrays()
    value._array_of_arrays = List(List("nested", "values"), List.empty)
    value._array_of_maps = List(Map("key" -> "value"))
    value._array_of_bytes = List(Array[Byte](1, 2, 3), Array.emptyByteArray)
    value._array_of_strings = List("first", "second")
    value._array_of_ints = List(1000, -1000)
    value._array_of_longs = List(1000L, -1000L)
    value._array_of_floats = List(1.5f, -2.5f)
    value._array_of_doubles = List(1.5, -2.5)
    value._array_of_booleans = List(true, false)
    value
  }

  private def readInto[T <: SpecificRecordBase](source: T, existing: T): T = {
    val decoder = DecoderFactory.get().binaryDecoder(serialize(source), null)
    new SpecificDatumReader[T](source.getSchema).read(existing, decoder)
  }

  test("array getters return mutable detached collections, including nested arrays") {
    val value = populatedArrays()
    val expectedBytes = serialize(value).toSeq
    for (field <- List(1, 7, 8, 9, 10, 11, 12, 13)) {
      value.get(field).asInstanceOf[java.util.List[_]].clear()
    }
    val nested = value.get(0).asInstanceOf[java.util.List[java.util.List[String]]]
    nested.get(0).clear()
    nested.clear()

    serialize(value).toSeq shouldBe expectedBytes
  }

  test("array getters preserve Avro wire bytes for boxed primitives and converted values") {
    val value = populatedArrays()
    val expected = new GenericData.Record(value.getSchema)
    for (field <- 0 until value.getSchema.getFields.size()) {
      expected.put(field, java.util.Collections.emptyList[AnyRef]())
    }
    expected.put(0, java.util.Arrays.asList(
      java.util.Arrays.asList("nested", "values"), java.util.Collections.emptyList[String]()))
    expected.put(1, java.util.Arrays.asList(java.util.Collections.singletonMap("key", "value")))
    expected.put(7, java.util.Arrays.asList(ByteBuffer.wrap(Array[Byte](1, 2, 3)), ByteBuffer.wrap(Array.emptyByteArray)))
    expected.put(8, java.util.Arrays.asList("first", "second"))
    expected.put(9, java.util.Arrays.asList(Int.box(1000), Int.box(-1000)))
    expected.put(10, java.util.Arrays.asList(Long.box(1000L), Long.box(-1000L)))
    expected.put(11, java.util.Arrays.asList(Float.box(1.5f), Float.box(-2.5f)))
    expected.put(12, java.util.Arrays.asList(Double.box(1.5), Double.box(-2.5)))
    expected.put(13, java.util.Arrays.asList(Boolean.box(true), Boolean.box(false)))
    val out = new ByteArrayOutputStream()
    val encoder = EncoderFactory.get().binaryEncoder(out, null)
    new GenericDatumWriter[GenericData.Record](value.getSchema).write(expected, encoder)
    encoder.flush()

    serialize(value).toSeq shouldBe out.toByteArray.toSeq
  }

  test("populated records can be reused when reading arrays and then empty arrays") {
    val source = populatedArrays()
    val existing = populatedArrays()
    existing._array_of_strings = List("old")
    existing._array_of_ints = List(9999)
    val result = readInto(source, existing)
    result should be theSameInstanceAs existing
    serialize(result).toSeq shouldBe serialize(source).toSeq

    val empty = new Arrays()
    readInto(empty, existing) should be theSameInstanceAs existing
    serialize(existing).toSeq shouldBe serialize(empty).toSeq
  }

  test("arrays inside options and maps remain detached and support record reuse") {
    val source = new ComplexOptions()
    source._map_of_option_of_array = Map("group" -> Some(List("first", "second")), "missing" -> None)
    source._array_of_option_of_array = List(Some(List("nested")), None, Some(List.empty))
    val expectedBytes = serialize(source).toSeq
    val map = source.get(2).asInstanceOf[java.util.Map[String, java.util.List[String]]]
    map.get("group").clear()
    val arrays = source.get(5).asInstanceOf[java.util.List[java.util.List[String]]]
    arrays.get(0).clear()
    arrays.clear()
    serialize(source).toSeq shouldBe expectedBytes

    val existing = new ComplexOptions()
    existing._map_of_option_of_array = Map("old" -> Some(List("old")))
    existing._array_of_option_of_array = List(Some(List("old")))
    readInto(source, existing) should be theSameInstanceAs existing
    existing._map_of_option_of_array shouldBe source._map_of_option_of_array
    existing._array_of_option_of_array shouldBe source._array_of_option_of_array

    val optional = new OptionsWithNullAsSecondType()
    optional._optional_array = Some(List(true, false))
    val oldOptional = new OptionsWithNullAsSecondType()
    oldOptional._optional_array = Some(List(false))
    readInto(optional, oldOptional) should be theSameInstanceAs oldOptional
    oldOptional._optional_array shouldBe optional._optional_array
  }
}
