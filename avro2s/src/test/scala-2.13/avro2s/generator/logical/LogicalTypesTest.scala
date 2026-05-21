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

    start.get(2).asInstanceOf[java.time.LocalTime] shouldBe startOfDay
    end.get(2).asInstanceOf[java.time.LocalTime] shouldBe endOfDay
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

    start.get(3).asInstanceOf[java.time.LocalTime] shouldBe startOfDay
    end.get(3).asInstanceOf[java.time.LocalTime] shouldBe endOfDay
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

    start.get(4).asInstanceOf[java.time.Instant] shouldBe startOfEpoch
    end.get(4).asInstanceOf[java.time.Instant] shouldBe endOfFormatRange
    post.get(4).asInstanceOf[java.time.Instant] shouldBe postFormatRange
    upper.get(4).asInstanceOf[java.time.Instant] shouldBe upperBound
    era.get(4).asInstanceOf[java.time.Instant] shouldBe startOfEra
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

    start.get(5).asInstanceOf[java.time.Instant] shouldBe startOfEpoch
    end.get(5).asInstanceOf[java.time.Instant] shouldBe endOfFormatRange
    post.get(5).asInstanceOf[java.time.Instant] shouldBe postFormatRange
    upper.get(5).asInstanceOf[java.time.Instant] shouldBe upperBound
    era.get(5).asInstanceOf[java.time.Instant] shouldBe startOfEra
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

    start.get(6).asInstanceOf[java.time.LocalDateTime] shouldBe startOfEpoch
    end.get(6).asInstanceOf[java.time.LocalDateTime] shouldBe endOfFormatRange
    post.get(6).asInstanceOf[java.time.LocalDateTime] shouldBe postFormatRange
    upper.get(6).asInstanceOf[java.time.LocalDateTime] shouldBe upperBound
    era.get(6).asInstanceOf[java.time.LocalDateTime] shouldBe startOfEra
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

    start.get(7).asInstanceOf[java.time.LocalDateTime] shouldBe startOfEpoch
    end.get(7).asInstanceOf[java.time.LocalDateTime] shouldBe endOfFormatRange
    post.get(7).asInstanceOf[java.time.LocalDateTime] shouldBe postFormatRange
    upper.get(7).asInstanceOf[java.time.LocalDateTime] shouldBe upperBound
    era.get(7).asInstanceOf[java.time.LocalDateTime] shouldBe startOfEra
  }

  // Pre-epoch nanos cases are omitted: Avro 1.12's TimestampNanosConversion.toLong
  // has a bug for negative seconds with positive nanos (subtracts 1_000_000 instead
  // of 1_000_000_000), so round-trip is lossy below the epoch.
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

    val start = logicalTypes(startOfEpoch)
    val nano = logicalTypes(nanoPrecision)
    val upper = logicalTypes(upperBound)
    deserialize[avro2s.test.logical.LogicalTypes](serialize(start), start.getSchema) shouldBe start
    deserialize[avro2s.test.logical.LogicalTypes](serialize(nano), nano.getSchema) shouldBe nano
    deserialize[avro2s.test.logical.LogicalTypes](serialize(upper), upper.getSchema) shouldBe upper

    start.get(8).asInstanceOf[java.time.Instant] shouldBe startOfEpoch
    nano.get(8).asInstanceOf[java.time.Instant] shouldBe nanoPrecision
    upper.get(8).asInstanceOf[java.time.Instant] shouldBe upperBound
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

    val start = logicalTypes(startOfEpoch)
    val nano = logicalTypes(nanoPrecision)
    val upper = logicalTypes(upperBound)
    deserialize[avro2s.test.logical.LogicalTypes](serialize(start), start.getSchema) shouldBe start
    deserialize[avro2s.test.logical.LogicalTypes](serialize(nano), nano.getSchema) shouldBe nano
    deserialize[avro2s.test.logical.LogicalTypes](serialize(upper), upper.getSchema) shouldBe upper

    start.get(9).asInstanceOf[java.time.LocalDateTime] shouldBe startOfEpoch
    nano.get(9).asInstanceOf[java.time.LocalDateTime] shouldBe nanoPrecision
    upper.get(9).asInstanceOf[java.time.LocalDateTime] shouldBe upperBound
  }
}
