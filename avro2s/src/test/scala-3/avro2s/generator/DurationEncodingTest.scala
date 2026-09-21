package avro2s.generator

import org.apache.avro.Conversions
import org.apache.avro.generic.GenericFixed
import org.apache.avro.util.TimePeriod
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

/**
 * A duration is twelve bytes: months, days and milliseconds as unsigned little-endian 32-bit
 * words. avro2s writes those words itself rather than calling Avro's toFixed, so the bytes must
 * match what Avro would have produced - Avro's own DurationConversion is the oracle here, not a
 * hand-written expectation. The unsigned range matters: each field is written from a Long and
 * truncated to 32 bits, so values above Int.MaxValue have to survive the round trip.
 */
class DurationEncodingTest extends AnyFunSuite with Matchers {
  private val schema = avro2s.test.logical.LogicalDuration.SCHEMA$.getField("_duration").schema()
  private val conversion = new Conversions.DurationConversion()

  private val periods = List(
    TimePeriod.of(0L, 0L, 0L),
    TimePeriod.of(1L, 2L, 3L),
    TimePeriod.of(255L, 256L, 257L),
    TimePeriod.of(65535L, 65536L, 65537L),
    TimePeriod.of(2147483647L, 2147483647L, 2147483647L),   // Int.MaxValue
    TimePeriod.of(2147483648L, 2147483648L, 2147483648L),   // one past it: unsigned territory
    TimePeriod.of(4294967295L, 4294967295L, 4294967295L)    // the unsigned 32-bit maximum
  )

  private def ours(period: TimePeriod): Array[Byte] =
    avro2s.test.logical.LogicalDuration(period).get(0).asInstanceOf[GenericFixed].bytes()

  private def avros(period: TimePeriod): Array[Byte] =
    conversion.toFixed(period, schema, schema.getLogicalType).bytes()

  test("a duration encodes exactly as Avro's own conversion would") {
    periods.foreach { period =>
      withClue(s"period $period: ") { ours(period) shouldBe avros(period) }
    }
  }

  test("a duration round-trips through Avro's own conversion") {
    periods.foreach { period =>
      withClue(s"period $period: ") {
        conversion.fromFixed(new org.apache.avro.generic.GenericData.Fixed(schema, ours(period)),
          schema, schema.getLogicalType) shouldBe period
      }
    }
  }

  test("a duration is twelve bytes") {
    periods.foreach(period => ours(period).length shouldBe 12)
  }
}
