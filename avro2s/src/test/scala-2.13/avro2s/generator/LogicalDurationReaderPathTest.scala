package avro2s.generator

import avro2s.serialization.SerializationHelpers._
import avro2s.test.logical._
import org.apache.avro.io.DecoderFactory
import org.apache.avro.specific.{SpecificData, SpecificDatumReader}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

/**
 * Duration is the one logical type whose value reaches put already converted, because Avro's
 * DurationConversion is registered on the model rather than advertised by getConversion(pos).
 * That holds only on Avro's fast reader: the slow reader consults getConversion(pos) alone for a
 * top-level field, hands put the raw fixed, and the cast used to fail. Readers can be put on the
 * slow path by setFastReaderEnabled(false) or the org.apache.avro.fastread system property, so
 * put has to accept either shape.
 */
class LogicalDurationReaderPathTest extends AnyFunSuite with Matchers {
  private def slowModel: SpecificData = {
    val model = new SpecificData()
    model.addLogicalTypeConversion(new org.apache.avro.Conversions.DurationConversion())
    model.setFastReaderEnabled(false)
    model
  }

  test("duration at a top-level field survives the slow reader") {
    val record = LogicalDuration(org.apache.avro.util.TimePeriod.of(1L, 2L, 3L))
    val reader = new SpecificDatumReader[LogicalDuration](record.getSchema, record.getSchema, slowModel)
    val result = reader.read(null, DecoderFactory.get().binaryDecoder(serialize(record), null))
    result shouldBe record
  }

  test("duration in a nested position survives the slow reader") {
    val record = new LogicalMatrixArrays()
    record._duration = List(org.apache.avro.util.TimePeriod.of(4L, 5L, 6L))
    val reader = new SpecificDatumReader[LogicalMatrixArrays](record.getSchema, record.getSchema, slowModel)
    val result = reader.read(null, DecoderFactory.get().binaryDecoder(serialize(record), null))
    result._duration shouldBe record._duration
  }
}
