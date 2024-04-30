package avro2s.generator.logical

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import java.util.UUID

class LogicalTypesTest extends AnyFunSuite with Matchers {

  import avro2s.serialization.SerializationHelpers._
  
  test("time-millis should work at the edges") {
    def logicalTypes(time: java.time.LocalTime) = avro2s.test.logical.LogicalTypes(
      _uuid = UUID.randomUUID(),
      _date = java.time.LocalDate.now(),
      _time_millis = time,
      _time_micros = java.time.LocalTime.now(),
      _timestamp_millis = java.time.Instant.now(),
      _timestamp_micros = java.time.Instant.now(),
      _local_timestamp_millis = java.time.LocalDateTime.now(),
      _local_timestamp_micros = java.time.LocalDateTime.now()
    )
    
    val startOfDay = java.time.LocalTime.ofNanoOfDay(0)
    val endOfDay = java.time.LocalTime.ofNanoOfDay(86399999999999L)
    startOfDay.format(java.time.format.DateTimeFormatter.ISO_LOCAL_TIME) shouldBe "00:00:00"
    endOfDay.format(java.time.format.DateTimeFormatter.ISO_LOCAL_TIME) shouldBe "23:59:59.999999999"
    
    val start = logicalTypes(startOfDay)
    val end = logicalTypes(endOfDay)
    deserialize[avro2s.test.logical.LogicalTypes](serialize(start), start.getSchema) shouldBe start
    deserialize[avro2s.test.logical.LogicalTypes](serialize(end), end.getSchema) shouldBe end
    
    start.get(2).asInstanceOf[Long] shouldBe 0
    end.get(2).asInstanceOf[Long] shouldBe 86399999L
  }
  
  test("time-micros should work at the edges") {
    def logicalTypes(time: java.time.LocalTime) = avro2s.test.logical.LogicalTypes(
      _uuid = UUID.randomUUID(),
      _date = java.time.LocalDate.now(),
      _time_millis = java.time.LocalTime.now(),
      _time_micros = time,
      _timestamp_millis = java.time.Instant.now(),
      _timestamp_micros = java.time.Instant.now(),
      _local_timestamp_millis = java.time.LocalDateTime.now(),
      _local_timestamp_micros = java.time.LocalDateTime.now()
    )
    
    val startOfDay = java.time.LocalTime.ofNanoOfDay(0)
    val endOfDay = java.time.LocalTime.ofNanoOfDay(86399999999999L)
    startOfDay.format(java.time.format.DateTimeFormatter.ISO_LOCAL_TIME) shouldBe "00:00:00"
    endOfDay.format(java.time.format.DateTimeFormatter.ISO_LOCAL_TIME) shouldBe "23:59:59.999999999"
    
    val start = logicalTypes(startOfDay)
    val end = logicalTypes(endOfDay)
    deserialize[avro2s.test.logical.LogicalTypes](serialize(start), start.getSchema) shouldBe start
    deserialize[avro2s.test.logical.LogicalTypes](serialize(end), end.getSchema) shouldBe end
    
    start.get(3).asInstanceOf[Long] shouldBe 0L
    end.get(3).asInstanceOf[Long] shouldBe 86399999999L
  }
  
  test("timestamp-millis should work at the edges") {
    def logicalTypes(time: java.time.Instant) = avro2s.test.logical.LogicalTypes(
      _uuid = UUID.randomUUID(),
      _date = java.time.LocalDate.now(),
      _time_millis = java.time.LocalTime.now(),
      _time_micros = java.time.LocalTime.now(),
      _timestamp_millis = time,
      _timestamp_micros = java.time.Instant.now(),
      _local_timestamp_millis = java.time.LocalDateTime.now(),
      _local_timestamp_micros = java.time.LocalDateTime.now()
    )
    
    val startOfEpoch = java.time.Instant.ofEpochMilli(0)
    val endOfFormatRange = java.time.Instant.ofEpochMilli(253402300799999L)
    val postFormatRange = java.time.Instant.ofEpochMilli(253402300800000L)
    val upperBound = java.time.Instant.ofEpochMilli(Long.MaxValue)
    startOfEpoch.toString shouldBe "1970-01-01T00:00:00Z"
    endOfFormatRange.toString shouldBe "9999-12-31T23:59:59.999Z"
    postFormatRange.toString shouldBe "+10000-01-01T00:00:00Z"
    upperBound.toString shouldBe "+292278994-08-17T07:12:55.807Z"
    
    val start = logicalTypes(startOfEpoch)
    val end = logicalTypes(endOfFormatRange)
    val post = logicalTypes(postFormatRange)
    val upper = logicalTypes(upperBound)
    deserialize[avro2s.test.logical.LogicalTypes](serialize(start), start.getSchema) shouldBe start
    deserialize[avro2s.test.logical.LogicalTypes](serialize(end), end.getSchema) shouldBe end
    deserialize[avro2s.test.logical.LogicalTypes](serialize(post), post.getSchema) shouldBe post
    deserialize[avro2s.test.logical.LogicalTypes](serialize(upper), upper.getSchema) shouldBe upper
    
    start.get(4).asInstanceOf[Long] shouldBe 0L
    end.get(4).asInstanceOf[Long] shouldBe 253402300799999L
    post.get(4).asInstanceOf[Long] shouldBe 253402300800000L
    upper.get(4).asInstanceOf[Long] shouldBe Long.MaxValue
  }
  
  test("timestamp-micros should work at the edges") {
    def logicalTypes(time: java.time.Instant) = avro2s.test.logical.LogicalTypes(
      _uuid = UUID.randomUUID(),
      _date = java.time.LocalDate.now(),
      _time_millis = java.time.LocalTime.now(),
      _time_micros = java.time.LocalTime.now(),
      _timestamp_millis = java.time.Instant.now(),
      _timestamp_micros = time,
      _local_timestamp_millis = java.time.LocalDateTime.now(),
      _local_timestamp_micros = java.time.LocalDateTime.now()
    )
    
    val startOfEpoch = java.time.Instant.ofEpochSecond(0, 0)
    val endOfFormatRange = java.time.Instant.ofEpochSecond(253402300799L, 999999000)
    val postFormatRange = java.time.Instant.ofEpochSecond(253402300800L, 0)
    val upperBound = java.time.Instant.ofEpochSecond(9223372036854L, 775807000)
    startOfEpoch.toString shouldBe "1970-01-01T00:00:00Z"
    endOfFormatRange.toString shouldBe "9999-12-31T23:59:59.999999Z"
    postFormatRange.toString shouldBe "+10000-01-01T00:00:00Z"
    upperBound.toString shouldBe "+294247-01-10T04:00:54.775807Z"
    
    val start = logicalTypes(startOfEpoch)
    val end = logicalTypes(endOfFormatRange)
    val post = logicalTypes(postFormatRange)
    val upper = logicalTypes(upperBound)
    deserialize[avro2s.test.logical.LogicalTypes](serialize(start), start.getSchema) shouldBe start
    deserialize[avro2s.test.logical.LogicalTypes](serialize(end), end.getSchema) shouldBe end
    deserialize[avro2s.test.logical.LogicalTypes](serialize(post), post.getSchema) shouldBe post
    deserialize[avro2s.test.logical.LogicalTypes](serialize(upper), upper.getSchema) shouldBe upper
    
    start.get(5).asInstanceOf[Long] shouldBe 0L
    end.get(5).asInstanceOf[Long] shouldBe 253402300799999999L
    post.get(5).asInstanceOf[Long] shouldBe 253402300800000000L
    upper.get(5).asInstanceOf[Long] shouldBe Long.MaxValue
  }
  
  test("local-timestamp-millis should work at the edges") {
    def logicalTypes(time: java.time.LocalDateTime) = avro2s.test.logical.LogicalTypes(
      _uuid = UUID.randomUUID(),
      _date = java.time.LocalDate.now(),
      _time_millis = java.time.LocalTime.now(),
      _time_micros = java.time.LocalTime.now(),
      _timestamp_millis = java.time.Instant.now(),
      _timestamp_micros = java.time.Instant.now(),
      _local_timestamp_millis = time,
      _local_timestamp_micros = java.time.LocalDateTime.now()
    )
    
    val startOfEpoch = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(0), java.time.ZoneId.of("UTC"))
    val endOfFormatRange = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(253402300799999L), java.time.ZoneId.of("UTC"))
    val postFormatRange = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(253402300800000L), java.time.ZoneId.of("UTC"))
    val upperBound = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(Long.MaxValue), java.time.ZoneId.of("UTC"))
    startOfEpoch.toString shouldBe "1970-01-01T00:00"
    endOfFormatRange.toString shouldBe "9999-12-31T23:59:59.999"
    postFormatRange.toString shouldBe "+10000-01-01T00:00"
    upperBound.toString shouldBe "+292278994-08-17T07:12:55.807"
    
    val start = logicalTypes(startOfEpoch)
    val end = logicalTypes(endOfFormatRange)
    val post = logicalTypes(postFormatRange)
    val upper = logicalTypes(upperBound)
    deserialize[avro2s.test.logical.LogicalTypes](serialize(start), start.getSchema) shouldBe start
    deserialize[avro2s.test.logical.LogicalTypes](serialize(end), end.getSchema) shouldBe end
    deserialize[avro2s.test.logical.LogicalTypes](serialize(post), post.getSchema) shouldBe post
    deserialize[avro2s.test.logical.LogicalTypes](serialize(upper), upper.getSchema) shouldBe upper
    
    start.get(6).asInstanceOf[Long] shouldBe 0L
    end.get(6).asInstanceOf[Long] shouldBe 253402300799999L
    post.get(6).asInstanceOf[Long] shouldBe 253402300800000L
    upper.get(6).asInstanceOf[Long] shouldBe Long.MaxValue
  }
  
  test("local-timestamp-micros should work at the edges") {
    def logicalTypes(time: java.time.LocalDateTime) = avro2s.test.logical.LogicalTypes(
      _uuid = UUID.randomUUID(),
      _date = java.time.LocalDate.now(),
      _time_millis = java.time.LocalTime.now(),
      _time_micros = java.time.LocalTime.now(),
      _timestamp_millis = java.time.Instant.now(),
      _timestamp_micros = java.time.Instant.now(),
      _local_timestamp_millis = java.time.LocalDateTime.now(),
      _local_timestamp_micros = time
    )
    
    val startOfEpoch = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(0, 0), java.time.ZoneId.of("UTC"))
    val endOfFormatRange = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(253402300799L, 999999000), java.time.ZoneId.of("UTC"))
    val postFormatRange = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(253402300800L, 0), java.time.ZoneId.of("UTC"))
    val upperBound = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(9223372036854L, 775807000), java.time.ZoneId.of("UTC"))
    startOfEpoch.toString shouldBe "1970-01-01T00:00"
    endOfFormatRange.toString shouldBe "9999-12-31T23:59:59.999999"
    postFormatRange.toString shouldBe "+10000-01-01T00:00"
    upperBound.toString shouldBe "+294247-01-10T04:00:54.775807"
    
    
    val start = logicalTypes(startOfEpoch)
    val end = logicalTypes(endOfFormatRange)
    val post = logicalTypes(postFormatRange)
    val upper = logicalTypes(upperBound)
    deserialize[avro2s.test.logical.LogicalTypes](serialize(start), start.getSchema) shouldBe start
    deserialize[avro2s.test.logical.LogicalTypes](serialize(end), end.getSchema) shouldBe end
    deserialize[avro2s.test.logical.LogicalTypes](serialize(post), post.getSchema) shouldBe post
    deserialize[avro2s.test.logical.LogicalTypes](serialize(upper), upper.getSchema) shouldBe upper
    
    start.get(7).asInstanceOf[Long] shouldBe 0L
    end.get(7).asInstanceOf[Long] shouldBe 253402300799999999L
    post.get(7).asInstanceOf[Long] shouldBe 253402300800000000L
    upper.get(7).asInstanceOf[Long] shouldBe Long.MaxValue
  }
}
