/** GENERATED CODE */

package avro2s.test.logical

import scala.annotation.switch

/**
 * Every supported logical type in the options position.
 */
case class LogicalMatrixOptions(var _uuid: Option[java.util.UUID], var _date: Option[java.time.LocalDate], var _time_millis: Option[java.time.LocalTime], var _time_micros: Option[java.time.LocalTime], var _timestamp_millis: Option[java.time.Instant], var _timestamp_micros: Option[java.time.Instant], var _timestamp_nanos: Option[java.time.Instant], var _local_timestamp_millis: Option[java.time.LocalDateTime], var _local_timestamp_micros: Option[java.time.LocalDateTime], var _local_timestamp_nanos: Option[java.time.LocalDateTime], var _decimal_bytes: Option[scala.math.BigDecimal], var _decimal_fixed: Option[scala.math.BigDecimal], var _big_decimal: Option[java.math.BigDecimal], var _duration: Option[org.apache.avro.util.TimePeriod]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(None, None, None, None, None, None, None, None, None, None, None, None, None, None)

  override def getSchema: org.apache.avro.Schema = LogicalMatrixOptions.SCHEMA$

  override def getSpecificData(): org.apache.avro.specific.SpecificData = LogicalMatrixOptions.MODEL$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _uuid match {
        case Some(x: java.util.UUID) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 1 => _date match {
        case Some(x: java.time.LocalDate) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 2 => _time_millis match {
        case Some(x: java.time.LocalTime) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 3 => _time_micros match {
        case Some(x: java.time.LocalTime) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 4 => _timestamp_millis match {
        case Some(x: java.time.Instant) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 5 => _timestamp_micros match {
        case Some(x: java.time.Instant) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 6 => _timestamp_nanos match {
        case Some(x: java.time.Instant) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 7 => _local_timestamp_millis match {
        case Some(x: java.time.LocalDateTime) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 8 => _local_timestamp_micros match {
        case Some(x: java.time.LocalDateTime) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 9 => _local_timestamp_nanos match {
        case Some(x: java.time.LocalDateTime) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 10 => _decimal_bytes match {
        case Some(x: scala.math.BigDecimal) => {val decimal$ = (try x.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + x.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; val encoded$ = new Array[Byte](width$); var rest$ = unscaled$; var at$ = width$ - 1; while (at$ >= 0) { encoded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$) } else java.nio.ByteBuffer.wrap(decimal$.unscaledValue().toByteArray)}.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 11 => _decimal_fixed match {
        case Some(x: scala.math.BigDecimal) => {val decimal$ = (try x.setScale(4).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + x.scale + " as scale 4") }); if (decimal$.precision > 20) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 20"); val padded$ = new Array[Byte](16); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(4).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; if (width$ > 16) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 16 + " bytes"); if (unscaled$ < 0) java.util.Arrays.fill(padded$, 0, 16 - width$, 0xFF.toByte); var rest$ = unscaled$; var at$ = 16 - 1; while (at$ >= 16 - width$) { padded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 } } else { val unscaled$ = decimal$.unscaledValue().toByteArray; if (unscaled$.length > 16) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 16 + " bytes"); if (unscaled$(0) < 0) java.util.Arrays.fill(padded$, 0, 16 - unscaled$.length, 0xFF.toByte); System.arraycopy(unscaled$, 0, padded$, 16 - unscaled$.length, unscaled$.length) }; val result$ = new avro2s.test.logical.MatrixDecimalFixed(); result$.bytes(padded$); result$}.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 12 => _big_decimal match {
        case Some(x: java.math.BigDecimal) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 13 => _duration match {
        case Some(x: org.apache.avro.util.TimePeriod) => {{ val period$ = x; val result$ = new avro2s.test.logical.MatrixDurationFixed(); val bytes$ = result$.bytes(); var word$ = period$.getMonths.toInt; bytes$(0) = word$.toByte; bytes$(1) = (word$ >>> 8).toByte; bytes$(2) = (word$ >>> 16).toByte; bytes$(3) = (word$ >>> 24).toByte; word$ = period$.getDays.toInt; bytes$(4) = word$.toByte; bytes$(5) = (word$ >>> 8).toByte; bytes$(6) = (word$ >>> 16).toByte; bytes$(7) = (word$ >>> 24).toByte; word$ = period$.getMillis.toInt; bytes$(8) = word$.toByte; bytes$(9) = (word$ >>> 8).toByte; bytes$(10) = (word$ >>> 16).toByte; bytes$(11) = (word$ >>> 24).toByte; result$ }}.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._uuid = {
        value match {
          case null => None
          case x: java.util.UUID => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 1 => this._date = {
        value match {
          case null => None
          case x: java.time.LocalDate => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 2 => this._time_millis = {
        value match {
          case null => None
          case x: java.time.LocalTime => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 3 => this._time_micros = {
        value match {
          case null => None
          case x: java.time.LocalTime => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 4 => this._timestamp_millis = {
        value match {
          case null => None
          case x: java.time.Instant => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 5 => this._timestamp_micros = {
        value match {
          case null => None
          case x: java.time.Instant => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 6 => this._timestamp_nanos = {
        value match {
          case null => None
          case x: java.time.Instant => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 7 => this._local_timestamp_millis = {
        value match {
          case null => None
          case x: java.time.LocalDateTime => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 8 => this._local_timestamp_micros = {
        value match {
          case null => None
          case x: java.time.LocalDateTime => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 9 => this._local_timestamp_nanos = {
        value match {
          case null => None
          case x: java.time.LocalDateTime => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 10 => this._decimal_bytes = {
        value match {
          case null => None
          case x: java.nio.ByteBuffer => Option({{ val buffer$ = x; val length$ = buffer$.remaining; if (length$ >= 1 && length$ <= 8) { val offset$ = buffer$.position(); var unscaled$ = if (buffer$.get(offset$) < 0) -1L else 0L; var index$ = 0; while (index$ < length$) { unscaled$ = (unscaled$ << 8) | (buffer$.get(offset$ + index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else { val offset$ = buffer$.position(); val bytes$ = new Array[Byte](length$); buffer$.get(bytes$); (buffer$: java.nio.Buffer).position(offset$); scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$), 2)) } }})
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 11 => this._decimal_fixed = {
        value match {
          case null => None
          case x: avro2s.test.logical.MatrixDecimalFixed => Option({{ val raw$ = x.asInstanceOf[avro2s.test.logical.MatrixDecimalFixed].bytes(); val sign$ = if (raw$(0) < 0) -1L else 0L; val signByte$ = sign$.toByte; var first$ = 0; while (first$ < raw$.length - 1 && raw$(first$) == signByte$ && ((raw$(first$ + 1) < 0) == (signByte$ < 0))) first$ += 1; if (raw$.length - first$ <= 8) { var unscaled$ = sign$; var index$ = first$; while (index$ < raw$.length) { unscaled$ = (unscaled$ << 8) | (raw$(index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 4)) } else scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(raw$), 4)) }}.asInstanceOf[scala.math.BigDecimal])
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 12 => this._big_decimal = {
        value match {
          case null => None
          case x: java.math.BigDecimal => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 13 => this._duration = {
        value match {
          case null => None
          case x: org.apache.avro.util.TimePeriod => Option(x.asInstanceOf[org.apache.avro.util.TimePeriod])
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object LogicalMatrixOptions {
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
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"LogicalMatrixOptions","namespace":"avro2s.test.logical","doc":"Every supported logical type in the options position.","fields":[{"name":"_uuid","type":["null",{"type":"string","logicalType":"uuid"}]},{"name":"_date","type":["null",{"type":"int","logicalType":"date"}]},{"name":"_time_millis","type":["null",{"type":"int","logicalType":"time-millis"}]},{"name":"_time_micros","type":["null",{"type":"long","logicalType":"time-micros"}]},{"name":"_timestamp_millis","type":["null",{"type":"long","logicalType":"timestamp-millis"}]},{"name":"_timestamp_micros","type":["null",{"type":"long","logicalType":"timestamp-micros"}]},{"name":"_timestamp_nanos","type":["null",{"type":"long","logicalType":"timestamp-nanos"}]},{"name":"_local_timestamp_millis","type":["null",{"type":"long","logicalType":"local-timestamp-millis"}]},{"name":"_local_timestamp_micros","type":["null",{"type":"long","logicalType":"local-timestamp-micros"}]},{"name":"_local_timestamp_nanos","type":["null",{"type":"long","logicalType":"local-timestamp-nanos"}]},{"name":"_decimal_bytes","type":["null",{"type":"bytes","logicalType":"decimal","precision":10,"scale":2}]},{"name":"_decimal_fixed","type":["null",{"type":"fixed","name":"MatrixDecimalFixed","size":16,"logicalType":"decimal","precision":20,"scale":4}]},{"name":"_big_decimal","type":["null",{"type":"bytes","logicalType":"big-decimal"}]},{"name":"_duration","type":["null",{"type":"fixed","name":"MatrixDurationFixed","size":12,"logicalType":"duration"}]}]}""")
}