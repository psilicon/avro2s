package avro2s.generator

import avro2s.test.logical.LogicalMatrixDirect
import org.apache.avro.{Conversion, Conversions}
import org.apache.avro.data.TimeConversions
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

/**
 * Avro's own Conversion classes as the oracle for every logical type, in both directions.
 *
 * Generated code converts these itself now, so nothing forces it to agree with Avro - and it has
 * to, or a reader built with any other model decodes what we wrote incorrectly. Each case asserts
 * both halves: what get produces is byte-for-byte what Avro's conversion would have produced, and
 * what put makes of Avro's own output is the value we started with.
 *
 * timestamp-nanos and local-timestamp-nanos are deliberately excluded from the write half and
 * covered separately below: Avro's toLong is wrong before the epoch, so it cannot be an oracle
 * there. Its fromLong is correct, and that is what the separate test uses.
 */
class LogicalTypeOracleTest extends AnyFunSuite with Matchers {

  private val epoch = java.time.Instant.EPOCH
  private val preEpoch = java.time.Instant.ofEpochSecond(-1500000000L, 123456789)
  private def ldt(i: java.time.Instant) = java.time.LocalDateTime.ofInstant(i, java.time.ZoneOffset.UTC)

  /**
   * values round-trip exactly. encodeOnly are values a conversion legitimately truncates, so only
   * the encode half applies - both sides must truncate identically, but put cannot give them back.
   */
  private final class Case(
      val name: String,
      val index: Int,
      val values: List[Any],
      val conversion: Conversion[_],
      val set: (LogicalMatrixDirect, Any) => Unit,
      val read: LogicalMatrixDirect => Any,
      val encodeOnly: List[Any] = Nil)

  private def base(): LogicalMatrixDirect = new LogicalMatrixDirect()

  private val cases: List[Case] = List(
    new Case("uuid", 0,
      // Both halves all-zero and all-ones, and a mixed sign pattern: UUID.toString formats the two
      // longs as unsigned hex, so a sign bit set in either half is where formatting goes wrong.
      List(new java.util.UUID(0L, 0L),
           new java.util.UUID(-1L, -1L),
           new java.util.UUID(Long.MinValue, Long.MaxValue),
           java.util.UUID.fromString("f81d4fae-7dec-11d0-a765-00a0c91e6bf6")),
      new Conversions.UUIDConversion(),
      (r, v) => r._uuid = v.asInstanceOf[java.util.UUID], _._uuid),

    new Case("date", 1,
      // date is an int of epoch days, so the int limits are the type's limits.
      List(java.time.LocalDate.ofEpochDay(0),
           java.time.LocalDate.ofEpochDay(-1),
           java.time.LocalDate.ofEpochDay(1),
           java.time.LocalDate.ofEpochDay(Int.MinValue.toLong),
           java.time.LocalDate.ofEpochDay(Int.MaxValue.toLong)),
      new TimeConversions.DateConversion(),
      (r, v) => r._date = v.asInstanceOf[java.time.LocalDate], _._date),

    new Case("time-millis", 2,
      List(java.time.LocalTime.MIDNIGHT,
           java.time.LocalTime.ofNanoOfDay(1000000L),
           java.time.LocalTime.of(23, 59, 59, 999000000)),
      new TimeConversions.TimeMillisConversion(),
      (r, v) => r._time_millis = v.asInstanceOf[java.time.LocalTime], _._time_millis,
      // Sub-millisecond precision is dropped by both sides; they must drop it the same way.
      encodeOnly = List(java.time.LocalTime.MAX, java.time.LocalTime.ofNanoOfDay(999999L))),

    new Case("time-micros", 3,
      List(java.time.LocalTime.MIDNIGHT,
           java.time.LocalTime.ofNanoOfDay(1000L),
           java.time.LocalTime.of(23, 59, 59, 999999000)),
      new TimeConversions.TimeMicrosConversion(),
      (r, v) => r._time_micros = v.asInstanceOf[java.time.LocalTime], _._time_micros,
      encodeOnly = List(java.time.LocalTime.MAX, java.time.LocalTime.ofNanoOfDay(999L))),

    new Case("timestamp-millis", 4,
      // The epoch boundary in both directions, plus the millisecond either side of it.
      List(epoch,
           java.time.Instant.ofEpochMilli(-1L),
           java.time.Instant.ofEpochMilli(1L),
           java.time.Instant.ofEpochMilli(-1500L),
           java.time.Instant.ofEpochMilli(1700000000123L),
           java.time.Instant.ofEpochMilli(Long.MinValue / 2),
           java.time.Instant.ofEpochMilli(Long.MaxValue / 2)),
      new TimeConversions.TimestampMillisConversion(),
      (r, v) => r._timestamp_millis = v.asInstanceOf[java.time.Instant], _._timestamp_millis),

    new Case("timestamp-micros", 5,
      // seconds < 0 with a non-zero nano is the shape that broke nanos, so it is laboured here.
      List(epoch,
           java.time.Instant.ofEpochSecond(-1L, 1000L),
           java.time.Instant.ofEpochSecond(-1L, 999999000L),
           java.time.Instant.ofEpochSecond(0L, 1000L),
           java.time.Instant.ofEpochSecond(-2L, 500000000L),
           java.time.Instant.ofEpochSecond(1700000000L, 123456000L)),
      new TimeConversions.TimestampMicrosConversion(),
      (r, v) => r._timestamp_micros = v.asInstanceOf[java.time.Instant], _._timestamp_micros),

    new Case("local-timestamp-millis", 7,
      List(ldt(epoch),
           ldt(java.time.Instant.ofEpochMilli(-1L)),
           ldt(java.time.Instant.ofEpochMilli(1L)),
           ldt(java.time.Instant.ofEpochMilli(-1500L)),
           ldt(java.time.Instant.ofEpochMilli(1700000000123L))),
      new TimeConversions.LocalTimestampMillisConversion(),
      (r, v) => r._local_timestamp_millis = v.asInstanceOf[java.time.LocalDateTime], _._local_timestamp_millis),

    new Case("local-timestamp-micros", 8,
      List(ldt(epoch),
           ldt(java.time.Instant.ofEpochSecond(-1L, 1000L)),
           ldt(java.time.Instant.ofEpochSecond(-1L, 999999000L)),
           ldt(java.time.Instant.ofEpochSecond(0L, 1000L)),
           ldt(java.time.Instant.ofEpochSecond(-2L, 500000000L)),
           ldt(java.time.Instant.ofEpochSecond(1700000000L, 123456000L))),
      new TimeConversions.LocalTimestampMicrosConversion(),
      (r, v) => r._local_timestamp_micros = v.asInstanceOf[java.time.LocalDateTime], _._local_timestamp_micros),

    new Case("decimal on bytes", 10,
      // precision 10, scale 2: the extremes that still fit, the smallest non-zero either side of
      // zero, and the values that sit either side of a byte-width change in the unscaled form.
      List(scala.math.BigDecimal("0.00"),
           scala.math.BigDecimal("0.01"),
           scala.math.BigDecimal("-0.01"),
           scala.math.BigDecimal("1.27"), scala.math.BigDecimal("1.28"),
           scala.math.BigDecimal("-1.28"), scala.math.BigDecimal("-1.29"),
           scala.math.BigDecimal("99999999.99"),
           scala.math.BigDecimal("-99999999.99")),
      new Conversions.DecimalConversion(),
      (r, v) => r._decimal_bytes = v.asInstanceOf[scala.math.BigDecimal], _._decimal_bytes),

    new Case("decimal on fixed", 11,
      // precision 20, scale 4 in a 16-byte fixed. The decoder has a Long fast path taken when the
      // sign-trimmed form is 8 bytes or fewer, so both sides of that branch are covered: the
      // 1234567890.1234 values stay inside a Long, the 20-digit ones do not.
      List(scala.math.BigDecimal("0.0000"),
           scala.math.BigDecimal("0.0001"),
           scala.math.BigDecimal("-0.0001"),
           scala.math.BigDecimal("1234567890.1234"),
           scala.math.BigDecimal("-1234567890.1234"),
           scala.math.BigDecimal("922337203685477.5807"),   // unscaled = Long.MaxValue
           scala.math.BigDecimal("-922337203685477.5808"),  // unscaled = Long.MinValue
           scala.math.BigDecimal("922337203685477.5808"),   // one past it: no longer a Long
           scala.math.BigDecimal("9999999999999999.9999"),
           scala.math.BigDecimal("-9999999999999999.9999")),
      new Conversions.DecimalConversion(),
      (r, v) => r._decimal_fixed = v.asInstanceOf[scala.math.BigDecimal], _._decimal_fixed),

    new Case("big-decimal", 12,
      // Scale is carried per value here, so the varint framing is what is under test: a scale past
      // 63 and past 8191 needs a multi-byte varint, and a negative scale exercises the zigzag sign.
      List(java.math.BigDecimal.ZERO,
           new java.math.BigDecimal("-0.5"),
           new java.math.BigDecimal("12345.6789"),
           new java.math.BigDecimal(java.math.BigInteger.ONE, 100),
           new java.math.BigDecimal(java.math.BigInteger.ONE, 100000),
           new java.math.BigDecimal(java.math.BigInteger.valueOf(123L), -3),
           new java.math.BigDecimal(new java.math.BigInteger("9" * 200), 7)),
      new Conversions.BigDecimalConversion(),
      (r, v) => r._big_decimal = v.asInstanceOf[java.math.BigDecimal], _._big_decimal),

    new Case("duration", 13,
      // Three unsigned 32-bit words. Int.MaxValue and the value just past it are where a signed
      // read would go negative; the all-ones case is the unsigned maximum.
      List(org.apache.avro.util.TimePeriod.of(0L, 0L, 0L),
           org.apache.avro.util.TimePeriod.of(1L, 2L, 3L),
           org.apache.avro.util.TimePeriod.of(255L, 256L, 257L),
           org.apache.avro.util.TimePeriod.of(2147483647L, 2147483647L, 2147483647L),
           org.apache.avro.util.TimePeriod.of(2147483648L, 2147483648L, 2147483648L),
           org.apache.avro.util.TimePeriod.of(4294967295L, 4294967295L, 4294967295L),
           org.apache.avro.util.TimePeriod.of(4294967295L, 0L, 4294967295L)),
      new Conversions.DurationConversion(),
      (r, v) => r._duration = v.asInstanceOf[org.apache.avro.util.TimePeriod], _._duration))

  private def schemaAt(index: Int) = LogicalMatrixDirect.SCHEMA$.getFields.get(index).schema()

  private def avroRaw(c: Case, value: Any): AnyRef = {
    val schema = schemaAt(c.index)
    val datum = value match {
      case b: scala.math.BigDecimal => b.bigDecimal
      case other => other
    }
    Conversions.convertToRawType(datum, schema, schema.getLogicalType, c.conversion.asInstanceOf[Conversion[Any]])
  }

  private def normalise(value: AnyRef): Any = value match {
    case b: java.nio.ByteBuffer =>
      val copy = b.duplicate(); val a = new Array[Byte](copy.remaining); copy.get(a); a.toList
    case f: org.apache.avro.generic.GenericFixed => f.bytes().toList
    case c: CharSequence => c.toString
    case other => other
  }

  cases.foreach { c =>
    test(s"${c.name}: get produces exactly what Avro's conversion would") {
      (c.values ++ c.encodeOnly).foreach { value =>
        val record = base()
        c.set(record, value)
        withClue(s"${c.name} = $value: ") {
          normalise(record.get(c.index)) shouldBe normalise(avroRaw(c, value))
        }
      }
    }

    test(s"${c.name}: put decodes Avro's own encoding back to the value") {
      c.values.foreach { value =>
        val record = base()
        record.put(c.index, avroRaw(c, value))
        withClue(s"${c.name} = $value: ") { c.read(record) shouldBe value }
      }
    }
  }

  test("nanos: Avro's fromLong reads our encoding back, though its toLong cannot be an oracle") {
    val instants = List(epoch, preEpoch, java.time.Instant.ofEpochSecond(1700000000L, 123456789))
    val tsSchema = schemaAt(6)
    val ltsSchema = schemaAt(9)
    val ts = new TimeConversions.TimestampNanosConversion()
    val lts = new TimeConversions.LocalTimestampNanosConversion()

    instants.foreach { instant =>
      val record = base()
      record._timestamp_nanos = instant
      record._local_timestamp_nanos = ldt(instant)

      withClue(s"timestamp-nanos $instant: ") {
        ts.fromLong(record.get(6).asInstanceOf[java.lang.Long], tsSchema, tsSchema.getLogicalType) shouldBe instant
      }
      withClue(s"local-timestamp-nanos $instant: ") {
        lts.fromLong(record.get(9).asInstanceOf[java.lang.Long], ltsSchema, ltsSchema.getLogicalType) shouldBe ldt(instant)
      }
    }
  }

  test("nanos: Avro's toLong is the half that is wrong, and only before the epoch") {
    // Pins why the write half is excluded above rather than leaving it unexplained. If a future
    // Avro fixes toLong this test fails, which is the signal to fold nanos into the table.
    val tsSchema = schemaAt(6)
    val ts = new TimeConversions.TimestampNanosConversion()
    val record = base()

    record._timestamp_nanos = preEpoch
    ts.toLong(preEpoch, tsSchema, tsSchema.getLogicalType) should not be record.get(6)

    val afterEpoch = java.time.Instant.ofEpochSecond(1700000000L, 123456789)
    record._timestamp_nanos = afterEpoch
    ts.toLong(afterEpoch, tsSchema, tsSchema.getLogicalType) shouldBe record.get(6)
  }
}
