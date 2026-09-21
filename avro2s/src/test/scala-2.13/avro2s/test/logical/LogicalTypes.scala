/** GENERATED CODE */

package avro2s.test.logical

import scala.annotation.switch

case class LogicalTypes(var _uuid: java.util.UUID, var _date: java.time.LocalDate, var _time_millis: java.time.LocalTime, var _time_micros: java.time.LocalTime, var _timestamp_millis: java.time.Instant, var _timestamp_micros: java.time.Instant, var _local_timestamp_millis: java.time.LocalDateTime, var _local_timestamp_micros: java.time.LocalDateTime, var _timestamp_nanos: java.time.Instant, var _local_timestamp_nanos: java.time.LocalDateTime, var _decimal: scala.math.BigDecimal, var _big_decimal: java.math.BigDecimal) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(LogicalTypes.$default$0, LogicalTypes.$default$1, LogicalTypes.$default$2, LogicalTypes.$default$2, LogicalTypes.$default$3, LogicalTypes.$default$4, LogicalTypes.$default$5, LogicalTypes.$default$6, LogicalTypes.$default$7, LogicalTypes.$default$8, LogicalTypes.$default$9, LogicalTypes.$default$10)

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
      case 10 => {val decimal$ = (try _decimal.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + _decimal.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; val encoded$ = new Array[Byte](width$); var rest$ = unscaled$; var at$ = width$ - 1; while (at$ >= 0) { encoded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$) } else java.nio.ByteBuffer.wrap(decimal$.unscaledValue().toByteArray)}.asInstanceOf[AnyRef]
      case 11 => _big_decimal.asInstanceOf[AnyRef]
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
          case buffer: java.nio.ByteBuffer => {{ val buffer$ = buffer; val length$ = buffer$.remaining; if (length$ >= 1 && length$ <= 8) { val offset$ = buffer$.position(); var unscaled$ = if (buffer$.get(offset$) < 0) -1L else 0L; var index$ = 0; while (index$ < length$) { unscaled$ = (unscaled$ << 8) | (buffer$.get(offset$ + index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else { val offset$ = buffer$.position(); val bytes$ = new Array[Byte](length$); buffer$.get(bytes$); (buffer$: java.nio.Buffer).position(offset$); scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$), 2)) } }}
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
      case 11 => LogicalTypes.$BigDecimalConversion
      case _ => null
    }
  }
}

object LogicalTypes {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"LogicalTypes","namespace":"avro2s.test.logical","fields":[{"name":"_uuid","type":{"type":"string","logicalType":"uuid"}},{"name":"_date","type":{"type":"int","logicalType":"date"}},{"name":"_time_millis","type":{"type":"int","logicalType":"time-millis"}},{"name":"_time_micros","type":{"type":"long","logicalType":"time-micros"}},{"name":"_timestamp_millis","type":{"type":"long","logicalType":"timestamp-millis"}},{"name":"_timestamp_micros","type":{"type":"long","logicalType":"timestamp-micros"}},{"name":"_local_timestamp_millis","type":{"type":"long","logicalType":"local-timestamp-millis"}},{"name":"_local_timestamp_micros","type":{"type":"long","logicalType":"local-timestamp-micros"}},{"name":"_timestamp_nanos","type":{"type":"long","logicalType":"timestamp-nanos"}},{"name":"_local_timestamp_nanos","type":{"type":"long","logicalType":"local-timestamp-nanos"}},{"name":"_decimal","type":{"type":"bytes","logicalType":"decimal","precision":10,"scale":2}},{"name":"_big_decimal","type":{"type":"bytes","logicalType":"big-decimal"}}]}""")
  val $UUIDConversion: org.apache.avro.Conversion[_] = new org.apache.avro.Conversions.UUIDConversion()
  val $DateConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.DateConversion()
  val $TimeMillisConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.TimeMillisConversion()
  val $TimeMicrosConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.TimeMicrosConversion()
  val $TimestampMillisConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.TimestampMillisConversion()
  val $TimestampMicrosConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.TimestampMicrosConversion()
  val $LocalTimestampMillisConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.LocalTimestampMillisConversion()
  val $LocalTimestampMicrosConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.LocalTimestampMicrosConversion()
  val $TimestampNanosConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.TimestampNanosConversion() { override def fromLong(value: java.lang.Long, schema: org.apache.avro.Schema, logicalType: org.apache.avro.LogicalType): java.time.Instant = java.time.Instant.ofEpochSecond(java.lang.Math.floorDiv(value.longValue, 1000000000L), java.lang.Math.floorMod(value.longValue, 1000000000L)); override def toLong(value: java.time.Instant, schema: org.apache.avro.Schema, logicalType: org.apache.avro.LogicalType): java.lang.Long = java.lang.Long.valueOf(java.lang.Math.addExact(java.lang.Math.multiplyExact(value.getEpochSecond, 1000000000L), value.getNano.toLong)) }
  val $LocalTimestampNanosConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.LocalTimestampNanosConversion() { override def fromLong(value: java.lang.Long, schema: org.apache.avro.Schema, logicalType: org.apache.avro.LogicalType): java.time.LocalDateTime = java.time.LocalDateTime.ofEpochSecond(java.lang.Math.floorDiv(value.longValue, 1000000000L), java.lang.Math.floorMod(value.longValue, 1000000000L).toInt, java.time.ZoneOffset.UTC); override def toLong(value: java.time.LocalDateTime, schema: org.apache.avro.Schema, logicalType: org.apache.avro.LogicalType): java.lang.Long = java.lang.Long.valueOf(java.lang.Math.addExact(java.lang.Math.multiplyExact(value.toEpochSecond(java.time.ZoneOffset.UTC), 1000000000L), value.getNano.toLong)) }
  val $BigDecimalConversion: org.apache.avro.Conversion[_] = new org.apache.avro.Conversions.BigDecimalConversion()
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
    model.addLogicalTypeConversion($BigDecimalConversion)
    model
  }
  private val $default$0: java.util.UUID = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")
  private val $default$1: java.time.LocalDate = java.time.LocalDate.ofEpochDay(0)
  private val $default$2: java.time.LocalTime = java.time.LocalTime.ofNanoOfDay(0)
  private val $default$3: java.time.Instant = java.time.Instant.ofEpochMilli(0)
  private val $default$4: java.time.Instant = java.time.Instant.ofEpochSecond(0, 0)
  private val $default$5: java.time.LocalDateTime = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(0), java.time.ZoneId.of("UTC"))
  private val $default$6: java.time.LocalDateTime = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(0, 0), java.time.ZoneId.of("UTC"))
  private val $default$7: java.time.Instant = java.time.Instant.ofEpochSecond(0L, 0L)
  private val $default$8: java.time.LocalDateTime = java.time.LocalDateTime.ofEpochSecond(0L, 0, java.time.ZoneOffset.UTC)
  private val $default$9: scala.math.BigDecimal = scala.math.BigDecimal(0)
  private val $default$10: java.math.BigDecimal = java.math.BigDecimal.ZERO
}