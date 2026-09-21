/** GENERATED CODE */

package avro2s.test.logical

import scala.annotation.switch

/**
 * Every supported logical type in the direct position.
 */
case class LogicalMatrixDirect(var _uuid: java.util.UUID, var _date: java.time.LocalDate, var _time_millis: java.time.LocalTime, var _time_micros: java.time.LocalTime, var _timestamp_millis: java.time.Instant, var _timestamp_micros: java.time.Instant, var _timestamp_nanos: java.time.Instant, var _local_timestamp_millis: java.time.LocalDateTime, var _local_timestamp_micros: java.time.LocalDateTime, var _local_timestamp_nanos: java.time.LocalDateTime, var _decimal_bytes: scala.math.BigDecimal, var _decimal_fixed: scala.math.BigDecimal, var _big_decimal: java.math.BigDecimal, var _duration: org.apache.avro.util.TimePeriod) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(LogicalMatrixDirect.$default$0, LogicalMatrixDirect.$default$1, LogicalMatrixDirect.$default$2, LogicalMatrixDirect.$default$2, LogicalMatrixDirect.$default$3, LogicalMatrixDirect.$default$4, LogicalMatrixDirect.$default$5, LogicalMatrixDirect.$default$6, LogicalMatrixDirect.$default$7, LogicalMatrixDirect.$default$8, LogicalMatrixDirect.$default$9, LogicalMatrixDirect.$default$9, LogicalMatrixDirect.$default$10, LogicalMatrixDirect.$default$11)

  override def getSchema: org.apache.avro.Schema = LogicalMatrixDirect.SCHEMA$

  override def getSpecificData(): org.apache.avro.specific.SpecificData = LogicalMatrixDirect.MODEL$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _uuid.asInstanceOf[AnyRef]
      case 1 => _date.asInstanceOf[AnyRef]
      case 2 => _time_millis.asInstanceOf[AnyRef]
      case 3 => _time_micros.asInstanceOf[AnyRef]
      case 4 => _timestamp_millis.asInstanceOf[AnyRef]
      case 5 => _timestamp_micros.asInstanceOf[AnyRef]
      case 6 => _timestamp_nanos.asInstanceOf[AnyRef]
      case 7 => _local_timestamp_millis.asInstanceOf[AnyRef]
      case 8 => _local_timestamp_micros.asInstanceOf[AnyRef]
      case 9 => _local_timestamp_nanos.asInstanceOf[AnyRef]
      case 10 => {val decimal$ = (try _decimal_bytes.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + _decimal_bytes.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; val encoded$ = new Array[Byte](width$); var rest$ = unscaled$; var at$ = width$ - 1; while (at$ >= 0) { encoded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$) } else java.nio.ByteBuffer.wrap(decimal$.unscaledValue().toByteArray)}.asInstanceOf[AnyRef]
      case 11 => {val decimal$ = (try _decimal_fixed.setScale(4).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + _decimal_fixed.scale + " as scale 4") }); if (decimal$.precision > 20) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 20"); val padded$ = new Array[Byte](16); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(4).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; if (width$ > 16) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 16 + " bytes"); if (unscaled$ < 0) java.util.Arrays.fill(padded$, 0, 16 - width$, 0xFF.toByte); var rest$ = unscaled$; var at$ = 16 - 1; while (at$ >= 16 - width$) { padded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 } } else { val unscaled$ = decimal$.unscaledValue().toByteArray; if (unscaled$.length > 16) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 16 + " bytes"); if (unscaled$(0) < 0) java.util.Arrays.fill(padded$, 0, 16 - unscaled$.length, 0xFF.toByte); System.arraycopy(unscaled$, 0, padded$, 16 - unscaled$.length, unscaled$.length) }; val result$ = new avro2s.test.logical.MatrixDecimalFixed(); result$.bytes(padded$); result$}.asInstanceOf[AnyRef]
      case 12 => _big_decimal.asInstanceOf[AnyRef]
      case 13 => {{ val period$ = _duration; val result$ = new avro2s.test.logical.MatrixDurationFixed(); val bytes$ = result$.bytes(); var word$ = period$.getMonths.toInt; bytes$(0) = word$.toByte; bytes$(1) = (word$ >>> 8).toByte; bytes$(2) = (word$ >>> 16).toByte; bytes$(3) = (word$ >>> 24).toByte; word$ = period$.getDays.toInt; bytes$(4) = word$.toByte; bytes$(5) = (word$ >>> 8).toByte; bytes$(6) = (word$ >>> 16).toByte; bytes$(7) = (word$ >>> 24).toByte; word$ = period$.getMillis.toInt; bytes$(8) = word$.toByte; bytes$(9) = (word$ >>> 8).toByte; bytes$(10) = (word$ >>> 16).toByte; bytes$(11) = (word$ >>> 24).toByte; result$ }}.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._uuid = {
        value.asInstanceOf[java.util.UUID]
      }
      case 1 => this._date = {
        value.asInstanceOf[java.time.LocalDate]
      }
      case 2 => this._time_millis = {
        value.asInstanceOf[java.time.LocalTime]
      }
      case 3 => this._time_micros = {
        value.asInstanceOf[java.time.LocalTime]
      }
      case 4 => this._timestamp_millis = {
        value.asInstanceOf[java.time.Instant]
      }
      case 5 => this._timestamp_micros = {
        value.asInstanceOf[java.time.Instant]
      }
      case 6 => this._timestamp_nanos = {
        value.asInstanceOf[java.time.Instant]
      }
      case 7 => this._local_timestamp_millis = {
        value.asInstanceOf[java.time.LocalDateTime]
      }
      case 8 => this._local_timestamp_micros = {
        value.asInstanceOf[java.time.LocalDateTime]
      }
      case 9 => this._local_timestamp_nanos = {
        value.asInstanceOf[java.time.LocalDateTime]
      }
      case 10 => this._decimal_bytes = {
        val buffer = value.asInstanceOf[java.nio.ByteBuffer]
        {{ val buffer$ = buffer; val length$ = buffer$.remaining; if (length$ >= 1 && length$ <= 8) { val offset$ = buffer$.position(); var unscaled$ = if (buffer$.get(offset$) < 0) -1L else 0L; var index$ = 0; while (index$ < length$) { unscaled$ = (unscaled$ << 8) | (buffer$.get(offset$ + index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else { val offset$ = buffer$.position(); val bytes$ = new Array[Byte](length$); buffer$.get(bytes$); (buffer$: java.nio.Buffer).position(offset$); scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$), 2)) } }}
      }
      case 11 => this._decimal_fixed = {
        {{ val raw$ = value.asInstanceOf[avro2s.test.logical.MatrixDecimalFixed].bytes(); val sign$ = if (raw$(0) < 0) -1L else 0L; val signByte$ = sign$.toByte; var first$ = 0; while (first$ < raw$.length - 1 && raw$(first$) == signByte$ && ((raw$(first$ + 1) < 0) == (signByte$ < 0))) first$ += 1; if (raw$.length - first$ <= 8) { var unscaled$ = sign$; var index$ = first$; while (index$ < raw$.length) { unscaled$ = (unscaled$ << 8) | (raw$(index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 4)) } else scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(raw$), 4)) }}
      }
      case 12 => this._big_decimal = {
        value.asInstanceOf[java.math.BigDecimal]
      }
      case 13 => this._duration = {
        {(value match { case null => null; case period$: org.apache.avro.util.TimePeriod => period$; case fixed$: avro2s.test.logical.MatrixDurationFixed => { val bytes$ = fixed$.bytes(); org.apache.avro.util.TimePeriod.of(((bytes$(0) & 0xFFL) | ((bytes$(1) & 0xFFL) << 8) | ((bytes$(2) & 0xFFL) << 16) | ((bytes$(3) & 0xFFL) << 24)), ((bytes$(4) & 0xFFL) | ((bytes$(5) & 0xFFL) << 8) | ((bytes$(6) & 0xFFL) << 16) | ((bytes$(7) & 0xFFL) << 24)), ((bytes$(8) & 0xFFL) | ((bytes$(9) & 0xFFL) << 8) | ((bytes$(10) & 0xFFL) << 16) | ((bytes$(11) & 0xFFL) << 24))) } })}
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def getConversion(field: Int): org.apache.avro.Conversion[?] = {
    (field: @switch) match {
      case 0 => LogicalMatrixDirect.$UUIDConversion
      case 1 => LogicalMatrixDirect.$DateConversion
      case 2 => LogicalMatrixDirect.$TimeMillisConversion
      case 3 => LogicalMatrixDirect.$TimeMicrosConversion
      case 4 => LogicalMatrixDirect.$TimestampMillisConversion
      case 5 => LogicalMatrixDirect.$TimestampMicrosConversion
      case 6 => LogicalMatrixDirect.$TimestampNanosConversion
      case 7 => LogicalMatrixDirect.$LocalTimestampMillisConversion
      case 8 => LogicalMatrixDirect.$LocalTimestampMicrosConversion
      case 9 => LogicalMatrixDirect.$LocalTimestampNanosConversion
      case 10 => null
      case 11 => null
      case 12 => LogicalMatrixDirect.$BigDecimalConversion
      case 13 => null
      case _ => null
    }
  }
}

object LogicalMatrixDirect {
  @scala.annotation.static val $UUIDConversion: org.apache.avro.Conversion[?] = new org.apache.avro.Conversions.UUIDConversion()
  @scala.annotation.static val $DateConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.DateConversion()
  @scala.annotation.static val $TimeMillisConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.TimeMillisConversion()
  @scala.annotation.static val $TimeMicrosConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.TimeMicrosConversion()
  @scala.annotation.static val $TimestampMillisConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.TimestampMillisConversion()
  @scala.annotation.static val $TimestampMicrosConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.TimestampMicrosConversion()
  @scala.annotation.static val $TimestampNanosConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.TimestampNanosConversion() { override def fromLong(value: java.lang.Long, schema: org.apache.avro.Schema, logicalType: org.apache.avro.LogicalType): java.time.Instant = java.time.Instant.ofEpochSecond(java.lang.Math.floorDiv(value.longValue, 1000000000L), java.lang.Math.floorMod(value.longValue, 1000000000L)); override def toLong(value: java.time.Instant, schema: org.apache.avro.Schema, logicalType: org.apache.avro.LogicalType): java.lang.Long = java.lang.Long.valueOf(java.lang.Math.addExact(java.lang.Math.multiplyExact(value.getEpochSecond, 1000000000L), value.getNano.toLong)) }
  @scala.annotation.static val $LocalTimestampMillisConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.LocalTimestampMillisConversion()
  @scala.annotation.static val $LocalTimestampMicrosConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.LocalTimestampMicrosConversion()
  @scala.annotation.static val $LocalTimestampNanosConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.LocalTimestampNanosConversion() { override def fromLong(value: java.lang.Long, schema: org.apache.avro.Schema, logicalType: org.apache.avro.LogicalType): java.time.LocalDateTime = java.time.LocalDateTime.ofEpochSecond(java.lang.Math.floorDiv(value.longValue, 1000000000L), java.lang.Math.floorMod(value.longValue, 1000000000L).toInt, java.time.ZoneOffset.UTC); override def toLong(value: java.time.LocalDateTime, schema: org.apache.avro.Schema, logicalType: org.apache.avro.LogicalType): java.lang.Long = java.lang.Long.valueOf(java.lang.Math.addExact(java.lang.Math.multiplyExact(value.toEpochSecond(java.time.ZoneOffset.UTC), 1000000000L), value.getNano.toLong)) }
  @scala.annotation.static val $BigDecimalConversion: org.apache.avro.Conversion[?] = new org.apache.avro.Conversions.BigDecimalConversion()
  @scala.annotation.static val $DurationConversion: org.apache.avro.Conversion[?] = new org.apache.avro.Conversions.DurationConversion()
  @scala.annotation.static val MODEL$: org.apache.avro.specific.SpecificData = List($UUIDConversion, $DateConversion, $TimeMillisConversion, $TimeMicrosConversion, $TimestampMillisConversion, $TimestampMicrosConversion, $TimestampNanosConversion, $LocalTimestampMillisConversion, $LocalTimestampMicrosConversion, $LocalTimestampNanosConversion, $BigDecimalConversion, $DurationConversion).foldLeft(new org.apache.avro.specific.SpecificData())((model, conversion) => { model.addLogicalTypeConversion(conversion); model })
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"LogicalMatrixDirect","namespace":"avro2s.test.logical","doc":"Every supported logical type in the direct position.","fields":[{"name":"_uuid","type":{"type":"string","logicalType":"uuid"}},{"name":"_date","type":{"type":"int","logicalType":"date"}},{"name":"_time_millis","type":{"type":"int","logicalType":"time-millis"}},{"name":"_time_micros","type":{"type":"long","logicalType":"time-micros"}},{"name":"_timestamp_millis","type":{"type":"long","logicalType":"timestamp-millis"}},{"name":"_timestamp_micros","type":{"type":"long","logicalType":"timestamp-micros"}},{"name":"_timestamp_nanos","type":{"type":"long","logicalType":"timestamp-nanos"}},{"name":"_local_timestamp_millis","type":{"type":"long","logicalType":"local-timestamp-millis"}},{"name":"_local_timestamp_micros","type":{"type":"long","logicalType":"local-timestamp-micros"}},{"name":"_local_timestamp_nanos","type":{"type":"long","logicalType":"local-timestamp-nanos"}},{"name":"_decimal_bytes","type":{"type":"bytes","logicalType":"decimal","precision":10,"scale":2}},{"name":"_decimal_fixed","type":{"type":"fixed","name":"MatrixDecimalFixed","size":16,"logicalType":"decimal","precision":20,"scale":4}},{"name":"_big_decimal","type":{"type":"bytes","logicalType":"big-decimal"}},{"name":"_duration","type":{"type":"fixed","name":"MatrixDurationFixed","size":12,"logicalType":"duration"}}]}""")
  private val $default$0: java.util.UUID = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")
  private val $default$1: java.time.LocalDate = java.time.LocalDate.ofEpochDay(0)
  private val $default$2: java.time.LocalTime = java.time.LocalTime.ofNanoOfDay(0)
  private val $default$3: java.time.Instant = java.time.Instant.ofEpochMilli(0)
  private val $default$4: java.time.Instant = java.time.Instant.ofEpochSecond(0, 0)
  private val $default$5: java.time.Instant = java.time.Instant.ofEpochSecond(0L, 0L)
  private val $default$6: java.time.LocalDateTime = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(0), java.time.ZoneId.of("UTC"))
  private val $default$7: java.time.LocalDateTime = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(0, 0), java.time.ZoneId.of("UTC"))
  private val $default$8: java.time.LocalDateTime = java.time.LocalDateTime.ofEpochSecond(0L, 0, java.time.ZoneOffset.UTC)
  private val $default$9: scala.math.BigDecimal = scala.math.BigDecimal(0)
  private val $default$10: java.math.BigDecimal = java.math.BigDecimal.ZERO
  private val $default$11: org.apache.avro.util.TimePeriod = org.apache.avro.util.TimePeriod.of(0L, 0L, 0L)
}