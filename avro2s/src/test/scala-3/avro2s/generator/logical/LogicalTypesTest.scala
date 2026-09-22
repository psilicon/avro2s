package avro2s.generator.logical

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import java.util.UUID

class LogicalTypesTest extends AnyFunSuite with Matchers {

  import avro2s.serialization.SerializationHelpers._

  private val fixedUuid = UUID.fromString("550e8400-e29b-41d4-a716-446655440000")
  private val fixedDate = java.time.LocalDate.of(2009, 2, 13)
  private val fixedTimeMillis = java.time.LocalTime.ofNanoOfDay(45296123000000L)
  private val fixedTimeMicros = java.time.LocalTime.ofNanoOfDay(45296123456000L)
  private val fixedTimestampMillis = java.time.Instant.ofEpochMilli(1234567890123L)
  private val fixedTimestampMicros = java.time.Instant.ofEpochSecond(1234567890L, 123456000L)
  private val fixedLocalTimestampMillis = java.time.LocalDateTime.ofInstant(fixedTimestampMillis, java.time.ZoneOffset.UTC)
  private val fixedLocalTimestampMicros = java.time.LocalDateTime.ofInstant(fixedTimestampMicros, java.time.ZoneOffset.UTC)
  private val fixedTimestampNanos = java.time.Instant.ofEpochSecond(1234567890L, 123456789L)
  private val fixedLocalTimestampNanos = java.time.LocalDateTime.ofInstant(fixedTimestampNanos, java.time.ZoneOffset.UTC)

  /**
   * What Avro's own conversion would encode this value as. These assertions used to check that get
   * handed back the logical type, which only held while the type was delegated; get now hands back
   * the encoded form. Checking that against Avro's own conversion is the stronger assertion - it
   * pins the wire form rather than the field type the constructor already fixes, and it is the
   * thing that has to stay true for a reader built with any model to decode what we wrote.
   */
  private def avroEncodes[T](record: org.apache.avro.specific.SpecificRecordBase, index: Int, value: T): AnyRef = {
    val schema = record.getSchema.getFields.get(index).schema()
    val conversion = org.apache.avro.specific.SpecificData.get()
      .getConversionFor[T](schema.getLogicalType)
    org.apache.avro.Conversions.convertToRawType(value, schema, schema.getLogicalType, conversion)
  }

  /**
   * Nanos cannot use Avro as its oracle: TimestampNanosConversion.toLong subtracts 1000000 where it
   * means 1000000000, so for a negative epoch second with a non-zero nano it encodes ~0.999s off.
   * Generated code does this arithmetic itself, which is what removed that bug from Scala 2 as
   * well as Scala 3. LogicalNanosModelTest pins that Avro's fromLong reads these back correctly.
   */
  private def nanosOf(seconds: Long, nano: Int): AnyRef =
    java.lang.Long.valueOf(java.lang.Math.addExact(java.lang.Math.multiplyExact(seconds, 1000000000L), nano.toLong))

  test("no-arg records share immutable logical defaults while retaining independent fields") {
    val first = new avro2s.test.logical.LogicalTypes()
    val second = new avro2s.test.logical.LogicalTypes()
    val expected = Seq[AnyRef](
      new UUID(0L, 0L),
      java.time.LocalDate.ofEpochDay(0),
      java.time.LocalTime.MIDNIGHT,
      java.time.LocalTime.MIDNIGHT,
      java.time.Instant.EPOCH,
      java.time.Instant.EPOCH,
      java.time.LocalDateTime.of(1970, 1, 1, 0, 0),
      java.time.LocalDateTime.of(1970, 1, 1, 0, 0)
    )

    // Read through the fields, not get: get encodes on the way out for a self-converting type and
    // boxes a fresh value each call, which would defeat the identity check without the defaults
    // having changed at all.
    val fields = Seq[avro2s.test.logical.LogicalTypes => AnyRef](
      _._uuid, _._date, _._time_millis, _._time_micros,
      _._timestamp_millis, _._timestamp_micros,
      _._local_timestamp_millis, _._local_timestamp_micros)

    expected.zip(fields).foreach { case (value, field) =>
      field(first) shouldBe value
      (field(first) eq field(second)) shouldBe true
    }

    first._uuid = fixedUuid
    first._date = fixedDate
    first._local_timestamp_millis = fixedLocalTimestampMillis
    second._uuid shouldBe expected(0)
    second._date shouldBe expected(1)
    second._local_timestamp_millis shouldBe expected(6)
    deserialize[avro2s.test.logical.LogicalTypes](serialize(second), second.getSchema) shouldBe second
  }

  test("time-millis should work at the edges") {
    def logicalTypes(time: java.time.LocalTime) = avro2s.test.logical.LogicalTypes(
      _uuid = fixedUuid,
      _date = fixedDate,
      _time_millis = time,
      _time_micros = fixedTimeMicros,
      _timestamp_millis = fixedTimestampMillis,
      _timestamp_micros = fixedTimestampMicros,
      _local_timestamp_millis = fixedLocalTimestampMillis,
      _local_timestamp_micros = fixedLocalTimestampMicros,
      _timestamp_nanos = fixedTimestampNanos,
      _local_timestamp_nanos = fixedLocalTimestampNanos,
      _decimal = scala.math.BigDecimal("12345.67"),
      _big_decimal = new java.math.BigDecimal("12345.67")
    )

    val startOfDay = java.time.LocalTime.ofNanoOfDay(0)
    val endOfDay = java.time.LocalTime.ofNanoOfDay(86399999999999L)
    startOfDay.format(java.time.format.DateTimeFormatter.ISO_LOCAL_TIME) shouldBe "00:00:00"
    endOfDay.format(java.time.format.DateTimeFormatter.ISO_LOCAL_TIME) shouldBe "23:59:59.999999999"

    val start = logicalTypes(startOfDay)
    val end = logicalTypes(endOfDay)
    deserialize[avro2s.test.logical.LogicalTypes](serialize(start), start.getSchema) shouldBe start
    // endOfDay has nanosecond precision that gets truncated to millis
    val endDeserialized = deserialize[avro2s.test.logical.LogicalTypes](serialize(end), end.getSchema)
    endDeserialized._time_millis shouldBe java.time.LocalTime.ofNanoOfDay(86399999000000L)

    start.get(2) shouldBe avroEncodes(start, 2, startOfDay)
    end.get(2) shouldBe avroEncodes(end, 2, endOfDay)
  }

  test("time-micros should work at the edges") {
    def logicalTypes(time: java.time.LocalTime) = avro2s.test.logical.LogicalTypes(
      _uuid = fixedUuid,
      _date = fixedDate,
      _time_millis = fixedTimeMillis,
      _time_micros = time,
      _timestamp_millis = fixedTimestampMillis,
      _timestamp_micros = fixedTimestampMicros,
      _local_timestamp_millis = fixedLocalTimestampMillis,
      _local_timestamp_micros = fixedLocalTimestampMicros,
      _timestamp_nanos = fixedTimestampNanos,
      _local_timestamp_nanos = fixedLocalTimestampNanos,
      _decimal = scala.math.BigDecimal("12345.67"),
      _big_decimal = new java.math.BigDecimal("12345.67")
    )

    val startOfDay = java.time.LocalTime.ofNanoOfDay(0)
    val endOfDay = java.time.LocalTime.ofNanoOfDay(86399999999999L)
    startOfDay.format(java.time.format.DateTimeFormatter.ISO_LOCAL_TIME) shouldBe "00:00:00"
    endOfDay.format(java.time.format.DateTimeFormatter.ISO_LOCAL_TIME) shouldBe "23:59:59.999999999"

    val start = logicalTypes(startOfDay)
    val end = logicalTypes(endOfDay)
    deserialize[avro2s.test.logical.LogicalTypes](serialize(start), start.getSchema) shouldBe start
    // endOfDay has nanosecond precision that gets truncated to micros
    val endDeserialized = deserialize[avro2s.test.logical.LogicalTypes](serialize(end), end.getSchema)
    endDeserialized._time_micros shouldBe java.time.LocalTime.ofNanoOfDay(86399999999000L)

    start.get(3) shouldBe avroEncodes(start, 3, startOfDay)
    end.get(3) shouldBe avroEncodes(end, 3, endOfDay)
  }

  test("timestamp-millis should work at the edges") {
    def logicalTypes(time: java.time.Instant) = avro2s.test.logical.LogicalTypes(
      _uuid = fixedUuid,
      _date = fixedDate,
      _time_millis = fixedTimeMillis,
      _time_micros = fixedTimeMicros,
      _timestamp_millis = time,
      _timestamp_micros = fixedTimestampMicros,
      _local_timestamp_millis = fixedLocalTimestampMillis,
      _local_timestamp_micros = fixedLocalTimestampMicros,
      _timestamp_nanos = fixedTimestampNanos,
      _local_timestamp_nanos = fixedLocalTimestampNanos,
      _decimal = scala.math.BigDecimal("12345.67"),
      _big_decimal = new java.math.BigDecimal("12345.67")
    )

    val startOfEpoch = java.time.Instant.ofEpochMilli(0)
    val endOfFormatRange = java.time.Instant.ofEpochMilli(253402300799999L)
    val postFormatRange = java.time.Instant.ofEpochMilli(253402300800000L)
    val upperBound = java.time.Instant.ofEpochMilli(Long.MaxValue)
    val startOfEra = java.time.Instant.ofEpochMilli(-62135596800000L)
    startOfEpoch.toString shouldBe "1970-01-01T00:00:00Z"
    endOfFormatRange.toString shouldBe "9999-12-31T23:59:59.999Z"
    postFormatRange.toString shouldBe "+10000-01-01T00:00:00Z"
    upperBound.toString shouldBe "+292278994-08-17T07:12:55.807Z"
    startOfEra.toString shouldBe "0001-01-01T00:00:00Z"

    val start = logicalTypes(startOfEpoch)
    val end = logicalTypes(endOfFormatRange)
    val post = logicalTypes(postFormatRange)
    val upper = logicalTypes(upperBound)
    val era = logicalTypes(startOfEra)
    deserialize[avro2s.test.logical.LogicalTypes](serialize(start), start.getSchema) shouldBe start
    deserialize[avro2s.test.logical.LogicalTypes](serialize(end), end.getSchema) shouldBe end
    deserialize[avro2s.test.logical.LogicalTypes](serialize(post), post.getSchema) shouldBe post
    deserialize[avro2s.test.logical.LogicalTypes](serialize(upper), upper.getSchema) shouldBe upper
    deserialize[avro2s.test.logical.LogicalTypes](serialize(era), era.getSchema) shouldBe era

    start.get(4) shouldBe avroEncodes(start, 4, startOfEpoch)
    end.get(4) shouldBe avroEncodes(end, 4, endOfFormatRange)
    post.get(4) shouldBe avroEncodes(post, 4, postFormatRange)
    upper.get(4) shouldBe avroEncodes(upper, 4, upperBound)
    era.get(4) shouldBe avroEncodes(era, 4, startOfEra)
  }

  test("timestamp-micros should work at the edges") {
    def logicalTypes(time: java.time.Instant) = avro2s.test.logical.LogicalTypes(
      _uuid = fixedUuid,
      _date = fixedDate,
      _time_millis = fixedTimeMillis,
      _time_micros = fixedTimeMicros,
      _timestamp_millis = fixedTimestampMillis,
      _timestamp_micros = time,
      _local_timestamp_millis = fixedLocalTimestampMillis,
      _local_timestamp_micros = fixedLocalTimestampMicros,
      _timestamp_nanos = fixedTimestampNanos,
      _local_timestamp_nanos = fixedLocalTimestampNanos,
      _decimal = scala.math.BigDecimal("12345.67"),
      _big_decimal = new java.math.BigDecimal("12345.67")
    )

    val startOfEpoch = java.time.Instant.ofEpochSecond(0, 0)
    val endOfFormatRange = java.time.Instant.ofEpochSecond(253402300799L, 999999000)
    val postFormatRange = java.time.Instant.ofEpochSecond(253402300800L, 0)
    val upperBound = java.time.Instant.ofEpochSecond(9223372036854L, 775807000)
    val startOfEra = java.time.Instant.ofEpochSecond(-62135596800L, 0)
    startOfEpoch.toString shouldBe "1970-01-01T00:00:00Z"
    endOfFormatRange.toString shouldBe "9999-12-31T23:59:59.999999Z"
    postFormatRange.toString shouldBe "+10000-01-01T00:00:00Z"
    upperBound.toString shouldBe "+294247-01-10T04:00:54.775807Z"
    startOfEra.toString shouldBe "0001-01-01T00:00:00Z"

    val start = logicalTypes(startOfEpoch)
    val end = logicalTypes(endOfFormatRange)
    val post = logicalTypes(postFormatRange)
    val upper = logicalTypes(upperBound)
    val era = logicalTypes(startOfEra)
    deserialize[avro2s.test.logical.LogicalTypes](serialize(start), start.getSchema) shouldBe start
    deserialize[avro2s.test.logical.LogicalTypes](serialize(end), end.getSchema) shouldBe end
    deserialize[avro2s.test.logical.LogicalTypes](serialize(post), post.getSchema) shouldBe post
    deserialize[avro2s.test.logical.LogicalTypes](serialize(upper), upper.getSchema) shouldBe upper
    deserialize[avro2s.test.logical.LogicalTypes](serialize(era), era.getSchema) shouldBe era

    start.get(5) shouldBe avroEncodes(start, 5, startOfEpoch)
    end.get(5) shouldBe avroEncodes(end, 5, endOfFormatRange)
    post.get(5) shouldBe avroEncodes(post, 5, postFormatRange)
    upper.get(5) shouldBe avroEncodes(upper, 5, upperBound)
    era.get(5) shouldBe avroEncodes(era, 5, startOfEra)
  }

  test("local-timestamp-millis should work at the edges") {
    def logicalTypes(time: java.time.LocalDateTime) = avro2s.test.logical.LogicalTypes(
      _uuid = fixedUuid,
      _date = fixedDate,
      _time_millis = fixedTimeMillis,
      _time_micros = fixedTimeMicros,
      _timestamp_millis = fixedTimestampMillis,
      _timestamp_micros = fixedTimestampMicros,
      _local_timestamp_millis = time,
      _local_timestamp_micros = fixedLocalTimestampMicros,
      _timestamp_nanos = fixedTimestampNanos,
      _local_timestamp_nanos = fixedLocalTimestampNanos,
      _decimal = scala.math.BigDecimal("12345.67"),
      _big_decimal = new java.math.BigDecimal("12345.67")
    )

    val startOfEpoch = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(0), java.time.ZoneId.of("UTC"))
    val endOfFormatRange = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(253402300799999L), java.time.ZoneId.of("UTC"))
    val postFormatRange = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(253402300800000L), java.time.ZoneId.of("UTC"))
    val upperBound = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(Long.MaxValue), java.time.ZoneId.of("UTC"))
    val startOfEra = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(-62135596800000L), java.time.ZoneId.of("UTC"))
    startOfEpoch.toString shouldBe "1970-01-01T00:00"
    endOfFormatRange.toString shouldBe "9999-12-31T23:59:59.999"
    postFormatRange.toString shouldBe "+10000-01-01T00:00"
    upperBound.toString shouldBe "+292278994-08-17T07:12:55.807"
    startOfEra.toString shouldBe "0001-01-01T00:00"

    val start = logicalTypes(startOfEpoch)
    val end = logicalTypes(endOfFormatRange)
    val post = logicalTypes(postFormatRange)
    val upper = logicalTypes(upperBound)
    val era = logicalTypes(startOfEra)
    deserialize[avro2s.test.logical.LogicalTypes](serialize(start), start.getSchema) shouldBe start
    deserialize[avro2s.test.logical.LogicalTypes](serialize(end), end.getSchema) shouldBe end
    deserialize[avro2s.test.logical.LogicalTypes](serialize(post), post.getSchema) shouldBe post
    deserialize[avro2s.test.logical.LogicalTypes](serialize(upper), upper.getSchema) shouldBe upper
    deserialize[avro2s.test.logical.LogicalTypes](serialize(era), era.getSchema) shouldBe era

    start.get(6) shouldBe avroEncodes(start, 6, startOfEpoch)
    end.get(6) shouldBe avroEncodes(end, 6, endOfFormatRange)
    post.get(6) shouldBe avroEncodes(post, 6, postFormatRange)
    upper.get(6) shouldBe avroEncodes(upper, 6, upperBound)
    era.get(6) shouldBe avroEncodes(era, 6, startOfEra)
  }

  test("local-timestamp-micros should work at the edges") {
    def logicalTypes(time: java.time.LocalDateTime) = avro2s.test.logical.LogicalTypes(
      _uuid = fixedUuid,
      _date = fixedDate,
      _time_millis = fixedTimeMillis,
      _time_micros = fixedTimeMicros,
      _timestamp_millis = fixedTimestampMillis,
      _timestamp_micros = fixedTimestampMicros,
      _local_timestamp_millis = fixedLocalTimestampMillis,
      _local_timestamp_micros = time,
      _timestamp_nanos = fixedTimestampNanos,
      _local_timestamp_nanos = fixedLocalTimestampNanos,
      _decimal = scala.math.BigDecimal("12345.67"),
      _big_decimal = new java.math.BigDecimal("12345.67")
    )

    val startOfEpoch = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(0, 0), java.time.ZoneId.of("UTC"))
    val endOfFormatRange = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(253402300799L, 999999000), java.time.ZoneId.of("UTC"))
    val postFormatRange = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(253402300800L, 0), java.time.ZoneId.of("UTC"))
    val upperBound = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(9223372036854L, 775807000), java.time.ZoneId.of("UTC"))
    val startOfEra = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(-62135596800L, 0), java.time.ZoneId.of("UTC"))
    startOfEpoch.toString shouldBe "1970-01-01T00:00"
    endOfFormatRange.toString shouldBe "9999-12-31T23:59:59.999999"
    postFormatRange.toString shouldBe "+10000-01-01T00:00"
    upperBound.toString shouldBe "+294247-01-10T04:00:54.775807"
    startOfEra.toString shouldBe "0001-01-01T00:00"


    val start = logicalTypes(startOfEpoch)
    val end = logicalTypes(endOfFormatRange)
    val post = logicalTypes(postFormatRange)
    val upper = logicalTypes(upperBound)
    val era = logicalTypes(startOfEra)
    deserialize[avro2s.test.logical.LogicalTypes](serialize(start), start.getSchema) shouldBe start
    deserialize[avro2s.test.logical.LogicalTypes](serialize(end), end.getSchema) shouldBe end
    deserialize[avro2s.test.logical.LogicalTypes](serialize(post), post.getSchema) shouldBe post
    deserialize[avro2s.test.logical.LogicalTypes](serialize(upper), upper.getSchema) shouldBe upper
    deserialize[avro2s.test.logical.LogicalTypes](serialize(era), era.getSchema) shouldBe era

    start.get(7) shouldBe avroEncodes(start, 7, startOfEpoch)
    end.get(7) shouldBe avroEncodes(end, 7, endOfFormatRange)
    post.get(7) shouldBe avroEncodes(post, 7, postFormatRange)
    upper.get(7) shouldBe avroEncodes(upper, 7, upperBound)
    era.get(7) shouldBe avroEncodes(era, 7, startOfEra)
  }

  test("timestamp-nanos should work at the edges") {
    def logicalTypes(time: java.time.Instant) = avro2s.test.logical.LogicalTypes(
      _uuid = fixedUuid,
      _date = fixedDate,
      _time_millis = fixedTimeMillis,
      _time_micros = fixedTimeMicros,
      _timestamp_millis = fixedTimestampMillis,
      _timestamp_micros = fixedTimestampMicros,
      _local_timestamp_millis = fixedLocalTimestampMillis,
      _local_timestamp_micros = fixedLocalTimestampMicros,
      _timestamp_nanos = time,
      _local_timestamp_nanos = fixedLocalTimestampNanos,
      _decimal = scala.math.BigDecimal("12345.67"),
      _big_decimal = new java.math.BigDecimal("12345.67")
    )

    val startOfEpoch = java.time.Instant.ofEpochSecond(0L, 0L)
    val nanoPrecision = java.time.Instant.ofEpochSecond(1234567890L, 123456789L)
    val upperBound = java.time.Instant.ofEpochSecond(Long.MaxValue / 1_000_000_000L, Long.MaxValue % 1_000_000_000L)
    // Before the epoch with positive nanos. Avro 1.12's own TimestampNanosConversion encodes this
    // to a positive number and reads it back as 1970-01-01T00:00:00.499Z, so avro2s registers a
    // corrected conversion; without it these assertions fail silently rather than throwing.
    val preEpoch = java.time.Instant.ofEpochSecond(-1L, 500000000L)
    val deepPreEpoch = java.time.Instant.ofEpochSecond(-100L, 999999999L)

    val start = logicalTypes(startOfEpoch)
    val nano = logicalTypes(nanoPrecision)
    val upper = logicalTypes(upperBound)
    val pre = logicalTypes(preEpoch)
    val deep = logicalTypes(deepPreEpoch)
    deserialize[avro2s.test.logical.LogicalTypes](serialize(start), start.getSchema) shouldBe start
    deserialize[avro2s.test.logical.LogicalTypes](serialize(nano), nano.getSchema) shouldBe nano
    deserialize[avro2s.test.logical.LogicalTypes](serialize(upper), upper.getSchema) shouldBe upper

    deserialize[avro2s.test.logical.LogicalTypes](serialize(pre), pre.getSchema) shouldBe pre
    deserialize[avro2s.test.logical.LogicalTypes](serialize(deep), deep.getSchema) shouldBe deep

    start.get(8) shouldBe nanosOf(startOfEpoch.getEpochSecond, startOfEpoch.getNano)
    pre.get(8) shouldBe nanosOf(preEpoch.getEpochSecond, preEpoch.getNano)
    deep.get(8) shouldBe nanosOf(deepPreEpoch.getEpochSecond, deepPreEpoch.getNano)
    nano.get(8) shouldBe nanosOf(nanoPrecision.getEpochSecond, nanoPrecision.getNano)
    upper.get(8) shouldBe nanosOf(upperBound.getEpochSecond, upperBound.getNano)
  }

  test("local-timestamp-nanos should work at the edges") {
    def logicalTypes(time: java.time.LocalDateTime) = avro2s.test.logical.LogicalTypes(
      _uuid = fixedUuid,
      _date = fixedDate,
      _time_millis = fixedTimeMillis,
      _time_micros = fixedTimeMicros,
      _timestamp_millis = fixedTimestampMillis,
      _timestamp_micros = fixedTimestampMicros,
      _local_timestamp_millis = fixedLocalTimestampMillis,
      _local_timestamp_micros = fixedLocalTimestampMicros,
      _timestamp_nanos = fixedTimestampNanos,
      _local_timestamp_nanos = time,
      _decimal = scala.math.BigDecimal("12345.67"),
      _big_decimal = new java.math.BigDecimal("12345.67")
    )

    val startOfEpoch = java.time.LocalDateTime.ofEpochSecond(0L, 0, java.time.ZoneOffset.UTC)
    val nanoPrecision = java.time.LocalDateTime.ofEpochSecond(1234567890L, 123456789, java.time.ZoneOffset.UTC)
    val upperBound = java.time.LocalDateTime.ofEpochSecond(Long.MaxValue / 1_000_000_000L, (Long.MaxValue % 1_000_000_000L).toInt, java.time.ZoneOffset.UTC)
    // Same pre-epoch defect as timestamp-nanos. This one additionally threw DateTimeException on
    // read before the fix, because LocalDateTime.ofEpochSecond rejects a negative nanoOfSecond.
    val preEpoch = java.time.LocalDateTime.ofEpochSecond(-1L, 500000000, java.time.ZoneOffset.UTC)
    val deepPreEpoch = java.time.LocalDateTime.ofEpochSecond(-100L, 999999999, java.time.ZoneOffset.UTC)

    val start = logicalTypes(startOfEpoch)
    val nano = logicalTypes(nanoPrecision)
    val upper = logicalTypes(upperBound)
    val pre = logicalTypes(preEpoch)
    val deep = logicalTypes(deepPreEpoch)
    deserialize[avro2s.test.logical.LogicalTypes](serialize(start), start.getSchema) shouldBe start
    deserialize[avro2s.test.logical.LogicalTypes](serialize(nano), nano.getSchema) shouldBe nano
    deserialize[avro2s.test.logical.LogicalTypes](serialize(upper), upper.getSchema) shouldBe upper

    deserialize[avro2s.test.logical.LogicalTypes](serialize(pre), pre.getSchema) shouldBe pre
    deserialize[avro2s.test.logical.LogicalTypes](serialize(deep), deep.getSchema) shouldBe deep

    start.get(9) shouldBe nanosOf(startOfEpoch.toEpochSecond(java.time.ZoneOffset.UTC), startOfEpoch.getNano)
    pre.get(9) shouldBe nanosOf(preEpoch.toEpochSecond(java.time.ZoneOffset.UTC), preEpoch.getNano)
    deep.get(9) shouldBe nanosOf(deepPreEpoch.toEpochSecond(java.time.ZoneOffset.UTC), deepPreEpoch.getNano)
    nano.get(9) shouldBe nanosOf(nanoPrecision.toEpochSecond(java.time.ZoneOffset.UTC), nanoPrecision.getNano)
    upper.get(9) shouldBe nanosOf(upperBound.toEpochSecond(java.time.ZoneOffset.UTC), upperBound.getNano)
  }
}
