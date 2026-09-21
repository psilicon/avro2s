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
 * MODEL$ itself is correct; only the lookup fails. These tests pin both halves of that: the
 * fallback is real, and passing MODEL$ explicitly is a working remedy for callers who need it.
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

  test("pre-epoch nanos in a nested position is wrong under the global model") {
    // Characterising a known limitation, not endorsing it: Avro loses ~0.999s on the write.
    val result = deserialize[LogicalMatrixArrays](serialize(arrayOf(instant)), arrayOf(instant).getSchema)
    result._timestamp_nanos should not be List(instant)
    result._timestamp_nanos.head.getEpochSecond shouldBe instant.getEpochSecond + 1
  }

  test("pre-epoch nanos in a nested position is correct when MODEL$ is supplied explicitly") {
    roundTripWith(arrayOf(instant), LogicalMatrixArrays.MODEL$)._timestamp_nanos shouldBe List(instant)
  }
}
