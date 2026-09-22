package avro2s.generator

import avro2s.serialization.SerializationHelpers._
import avro2s.test.logical._
import org.apache.avro.io.{DecoderFactory, EncoderFactory}
import org.apache.avro.specific.{SpecificData, SpecificDatumReader, SpecificDatumWriter}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import java.io.ByteArrayOutputStream

/**
 * The Scala 2 counterpart to the Scala 3 suite of the same name.
 *
 * Avro finds a generated class's model by reflecting for a static field named MODEL$. Scala 2 has
 * no way to emit one - an object val becomes an instance field on LogicalMatrixArrays$ plus a
 * static forwarder method - so getForClass falls back to SpecificData.get(), whose nanos
 * conversions are Avro's own. Avro's TimestampNanosConversion.toLong is wrong for instants with a
 * negative epoch second and a non-zero nano, leaving nested values ~0.999s out.
 *
 * That fallback is still real, and these tests pin it. It no longer costs correctness, though:
 * generated code encodes a nanos timestamp itself and getConversion advertises nothing, so Avro's
 * toLong is never reached and the value round-trips under the global model as well as under
 * MODEL$. The bug was only ever in toLong - Avro's fromLong is correct - which is why declining to
 * delegate on the way out is enough to be rid of it on Scala 2 as well as Scala 3.
 */
class LogicalNanosModelTest extends AnyFunSuite with Matchers {
  private val instant = java.time.Instant.ofEpochSecond(-1500000000L, 123456789)

  private def roundTripWith(record: LogicalMatrixArrays, model: SpecificData): LogicalMatrixArrays = {
    val out = new ByteArrayOutputStream()
    val encoder = EncoderFactory.get().binaryEncoder(out, null)
    new SpecificDatumWriter[LogicalMatrixArrays](record.getSchema, model).write(record, encoder)
    encoder.flush()
    val reader = new SpecificDatumReader[LogicalMatrixArrays](record.getSchema, record.getSchema, model)
    reader.read(null, DecoderFactory.get().binaryDecoder(out.toByteArray, null))
  }

  private def arrayOf(value: java.time.Instant): LogicalMatrixArrays = {
    val record = new LogicalMatrixArrays()
    record._timestamp_nanos = List(value)
    record
  }

  test("MODEL$ is not reachable by Avro's reflective lookup on Scala 2") {
    SpecificData.getForClass(classOf[LogicalMatrixArrays]) should be theSameInstanceAs SpecificData.get()
    SpecificData.getForClass(classOf[LogicalMatrixArrays]) should not be theSameInstanceAs(LogicalMatrixArrays.MODEL$)
  }

  test("pre-epoch nanos in a nested position is correct under the global model") {
    // This used to assert the opposite, pinning a known limitation: the global model's
    // TimestampNanosConversion.toLong subtracts 1000000 where it means 1000000000, so a nested
    // value came back ~0.999s late and getEpochSecond was one too high. Nothing about that model
    // has changed - generated code simply no longer asks it to encode, so toLong is never called.
    val result = deserialize[LogicalMatrixArrays](serialize(arrayOf(instant)), arrayOf(instant).getSchema)
    result._timestamp_nanos shouldBe List(instant)
  }

  test("the encoded form is what Avro's own fromLong reads back, bug or no bug") {
    // The oracle: Avro's read half is correct, so decoding what we wrote with it must give the
    // value back. This is what makes accepting either shape in put safe for nanos.
    val schema = arrayOf(instant).getSchema.getField("_timestamp_nanos").schema().getElementType
    val encoded = arrayOf(instant).get(6).asInstanceOf[java.util.List[_]].get(0).asInstanceOf[java.lang.Long]
    new org.apache.avro.data.TimeConversions.TimestampNanosConversion()
      .fromLong(encoded, schema, schema.getLogicalType) shouldBe instant
  }

  test("pre-epoch nanos in a nested position is correct when MODEL$ is supplied explicitly") {
    roundTripWith(arrayOf(instant), LogicalMatrixArrays.MODEL$)._timestamp_nanos shouldBe List(instant)
  }
}
