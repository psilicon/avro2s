/** GENERATED CODE */

package avro2s.test.logical

import scala.annotation.switch

case class LogicalTypes(var _uuid: java.util.UUID, var _date: java.time.LocalDate, var _time_millis: java.time.LocalTime, var _time_micros: java.time.LocalTime, var _timestamp_millis: java.time.Instant, var _timestamp_micros: java.time.Instant, var _local_timestamp_millis: java.time.LocalDateTime, var _local_timestamp_micros: java.time.LocalDateTime, var _timestamp_nanos: java.time.Instant, var _local_timestamp_nanos: java.time.LocalDateTime, var _decimal: scala.math.BigDecimal, var _big_decimal: java.math.BigDecimal) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(java.util.UUID.fromString("00000000-0000-0000-0000-000000000000"), java.time.LocalDate.ofEpochDay(0), java.time.LocalTime.ofNanoOfDay(0), java.time.LocalTime.ofNanoOfDay(0), java.time.Instant.ofEpochMilli(0), java.time.Instant.ofEpochSecond(0, 0), java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(0), java.time.ZoneId.of("UTC")), java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(0, 0), java.time.ZoneId.of("UTC")), java.time.Instant.ofEpochSecond(0L, 0L), java.time.LocalDateTime.ofEpochSecond(0L, 0, java.time.ZoneOffset.UTC), scala.math.BigDecimal(0), java.math.BigDecimal.ZERO)

  override def getSchema: org.apache.avro.Schema = LogicalTypes.SCHEMA$

  override def getSpecificData(): org.apache.avro.specific.SpecificData = LogicalTypes.MODEL$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _uuid.asInstanceOf[AnyRef]
      case 1 => _date.asInstanceOf[AnyRef]
      case 2 => _time_millis.asInstanceOf[AnyRef]
      case 3 => _time_micros.asInstanceOf[AnyRef]
      case 4 => _timestamp_millis.asInstanceOf[AnyRef]
      case 5 => _timestamp_micros.asInstanceOf[AnyRef]
      case 6 => _local_timestamp_millis.asInstanceOf[AnyRef]
      case 7 => _local_timestamp_micros.asInstanceOf[AnyRef]
      case 8 => _timestamp_nanos.asInstanceOf[AnyRef]
      case 9 => _local_timestamp_nanos.asInstanceOf[AnyRef]
      case 10 => {java.nio.ByteBuffer.wrap(_decimal.setScale(2).bigDecimal.unscaledValue().toByteArray)}.asInstanceOf[AnyRef]
      case 11 => {new org.apache.avro.Conversions.BigDecimalConversion().toBytes(_big_decimal, null, null)}.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._uuid = value.asInstanceOf[java.util.UUID]
      case 1 => this._date = value.asInstanceOf[java.time.LocalDate]
      case 2 => this._time_millis = value.asInstanceOf[java.time.LocalTime]
      case 3 => this._time_micros = value.asInstanceOf[java.time.LocalTime]
      case 4 => this._timestamp_millis = value.asInstanceOf[java.time.Instant]
      case 5 => this._timestamp_micros = value.asInstanceOf[java.time.Instant]
      case 6 => this._local_timestamp_millis = value.asInstanceOf[java.time.LocalDateTime]
      case 7 => this._local_timestamp_micros = value.asInstanceOf[java.time.LocalDateTime]
      case 8 => this._timestamp_nanos = value.asInstanceOf[java.time.Instant]
      case 9 => this._local_timestamp_nanos = value.asInstanceOf[java.time.LocalDateTime]
      case 10 => this._decimal = {
        value match {
          case buffer: java.nio.ByteBuffer => {scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(buffer.array()), 2))}
        }
      }
      case 11 => this._big_decimal = value.asInstanceOf[java.math.BigDecimal]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def getConversion(field: Int): org.apache.avro.Conversion[_] = {
    (field: @switch) match {
      case 0 => LogicalTypes.$UUIDConversion
      case 1 => LogicalTypes.$DateConversion
      case 2 => LogicalTypes.$TimeMillisConversion
      case 3 => LogicalTypes.$TimeMicrosConversion
      case 4 => LogicalTypes.$TimestampMillisConversion
      case 5 => LogicalTypes.$TimestampMicrosConversion
      case 6 => LogicalTypes.$LocalTimestampMillisConversion
      case 7 => LogicalTypes.$LocalTimestampMicrosConversion
      case 8 => LogicalTypes.$TimestampNanosConversion
      case 9 => LogicalTypes.$LocalTimestampNanosConversion
      case 10 => null
      case 11 => null
      case _ => null
    }
  }
}

object LogicalTypes {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"LogicalTypes","namespace":"avro2s.test.logical","fields":[{"name":"_uuid","type":{"type":"string","logicalType":"uuid"}},{"name":"_date","type":{"type":"int","logicalType":"date"}},{"name":"_time_millis","type":{"type":"int","logicalType":"time-millis"}},{"name":"_time_micros","type":{"type":"long","logicalType":"time-micros"}},{"name":"_timestamp_millis","type":{"type":"long","logicalType":"timestamp-millis"}},{"name":"_timestamp_micros","type":{"type":"long","logicalType":"timestamp-micros"}},{"name":"_local_timestamp_millis","type":{"type":"long","logicalType":"local-timestamp-millis"}},{"name":"_local_timestamp_micros","type":{"type":"long","logicalType":"local-timestamp-micros"}},{"name":"_timestamp_nanos","type":{"type":"long","logicalType":"timestamp-nanos"}},{"name":"_local_timestamp_nanos","type":{"type":"long","logicalType":"local-timestamp-nanos"}},{"name":"_decimal","type":{"type":"bytes","logicalType":"decimal","precision":10,"scale":2}},{"name":"_big_decimal","type":{"type":"bytes","logicalType":"big-decimal"}}]}""")
  val $UUIDConversion: org.apache.avro.Conversion[_] = new org.apache.avro.Conversions.UUIDConversion()
  val $DateConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.DateConversion()
  val $TimeMillisConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.TimeMillisConversion()
  val $TimeMicrosConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.TimeMicrosConversion()
  val $TimestampMillisConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.TimestampMillisConversion()
  val $TimestampMicrosConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.TimestampMicrosConversion()
  val $LocalTimestampMillisConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.LocalTimestampMillisConversion()
  val $LocalTimestampMicrosConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.LocalTimestampMicrosConversion()
  val $TimestampNanosConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.TimestampNanosConversion()
  val $LocalTimestampNanosConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.LocalTimestampNanosConversion()
  val MODEL$: org.apache.avro.specific.SpecificData = {
    val model = new org.apache.avro.specific.SpecificData()
    model.addLogicalTypeConversion($UUIDConversion)
    model.addLogicalTypeConversion($DateConversion)
    model.addLogicalTypeConversion($TimeMillisConversion)
    model.addLogicalTypeConversion($TimeMicrosConversion)
    model.addLogicalTypeConversion($TimestampMillisConversion)
    model.addLogicalTypeConversion($TimestampMicrosConversion)
    model.addLogicalTypeConversion($LocalTimestampMillisConversion)
    model.addLogicalTypeConversion($LocalTimestampMicrosConversion)
    model.addLogicalTypeConversion($TimestampNanosConversion)
    model.addLogicalTypeConversion($LocalTimestampNanosConversion)
    model
  }
}