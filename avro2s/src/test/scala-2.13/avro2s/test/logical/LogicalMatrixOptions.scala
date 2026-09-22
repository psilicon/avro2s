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
        case None => null
        case Some(x) => {x.toString}.asInstanceOf[AnyRef]
      }
      case 1 => _date match {
        case None => null
        case Some(x) => {x.toEpochDay.toInt}.asInstanceOf[AnyRef]
      }
      case 2 => _time_millis match {
        case None => null
        case Some(x) => {(x.toNanoOfDay / 1000000L).toInt}.asInstanceOf[AnyRef]
      }
      case 3 => _time_micros match {
        case None => null
        case Some(x) => {x.toNanoOfDay / 1000L}.asInstanceOf[AnyRef]
      }
      case 4 => _timestamp_millis match {
        case None => null
        case Some(x) => {x.toEpochMilli}.asInstanceOf[AnyRef]
      }
      case 5 => _timestamp_micros match {
        case None => null
        case Some(x) => {(x.getEpochSecond * 1000000L) + (x.getNano / 1000L)}.asInstanceOf[AnyRef]
      }
      case 6 => _timestamp_nanos match {
        case None => null
        case Some(x) => {java.lang.Math.addExact(java.lang.Math.multiplyExact(x.getEpochSecond, 1000000000L), x.getNano.toLong)}.asInstanceOf[AnyRef]
      }
      case 7 => _local_timestamp_millis match {
        case None => null
        case Some(x) => {x.atZone(java.time.ZoneId.of("UTC")).toInstant.toEpochMilli}.asInstanceOf[AnyRef]
      }
      case 8 => _local_timestamp_micros match {
        case None => null
        case Some(x) => {x.atZone(java.time.ZoneId.of("UTC")).toInstant.getEpochSecond * 1000000L + x.atZone(java.time.ZoneId.of("UTC")).toInstant.getNano / 1000L}.asInstanceOf[AnyRef]
      }
      case 9 => _local_timestamp_nanos match {
        case None => null
        case Some(x) => {java.lang.Math.addExact(java.lang.Math.multiplyExact(x.toEpochSecond(java.time.ZoneOffset.UTC), 1000000000L), x.getNano.toLong)}.asInstanceOf[AnyRef]
      }
      case 10 => _decimal_bytes match {
        case None => null
        case Some(x) => {val decimal$ = (try x.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + x.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; val encoded$ = new Array[Byte](width$); var rest$ = unscaled$; var at$ = width$ - 1; while (at$ >= 0) { encoded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$) } else java.nio.ByteBuffer.wrap(decimal$.unscaledValue().toByteArray)}.asInstanceOf[AnyRef]
      }
      case 11 => _decimal_fixed match {
        case None => null
        case Some(x) => {val decimal$ = (try x.setScale(4).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + x.scale + " as scale 4") }); if (decimal$.precision > 20) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 20"); val padded$ = new Array[Byte](16); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(4).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; if (width$ > 16) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 16 + " bytes"); if (unscaled$ < 0) java.util.Arrays.fill(padded$, 0, 16 - width$, 0xFF.toByte); var rest$ = unscaled$; var at$ = 16 - 1; while (at$ >= 16 - width$) { padded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 } } else { val unscaled$ = decimal$.unscaledValue().toByteArray; if (unscaled$.length > 16) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 16 + " bytes"); if (unscaled$(0) < 0) java.util.Arrays.fill(padded$, 0, 16 - unscaled$.length, 0xFF.toByte); System.arraycopy(unscaled$, 0, padded$, 16 - unscaled$.length, unscaled$.length) }; val result$ = new avro2s.test.logical.MatrixDecimalFixed(); result$.bytes(padded$); result$}.asInstanceOf[AnyRef]
      }
      case 12 => _big_decimal match {
        case None => null
        case Some(x) => {{ val decimal$ = x; val unscaled$ = decimal$.unscaledValue().toByteArray(); val zigzagLength$ = (unscaled$.length << 1) ^ (unscaled$.length >> 31); val zigzagScale$ = (decimal$.scale << 1) ^ (decimal$.scale >> 31); var width$ = 1; var measure$ = zigzagLength$ >>> 7; while (measure$ != 0) { width$ += 1; measure$ >>>= 7 }; var scaleWidth$ = 1; measure$ = zigzagScale$ >>> 7; while (measure$ != 0) { scaleWidth$ += 1; measure$ >>>= 7 }; val encoded$ = new Array[Byte](width$ + unscaled$.length + scaleWidth$); var at$ = 0; var word$ = zigzagLength$; while ((word$ & ~0x7F) != 0) { encoded$(at$) = ((word$ | 0x80) & 0xFF).toByte; word$ >>>= 7; at$ += 1 }; encoded$(at$) = word$.toByte; at$ += 1; java.lang.System.arraycopy(unscaled$, 0, encoded$, at$, unscaled$.length); at$ += unscaled$.length; word$ = zigzagScale$; while ((word$ & ~0x7F) != 0) { encoded$(at$) = ((word$ | 0x80) & 0xFF).toByte; word$ >>>= 7; at$ += 1 }; encoded$(at$) = word$.toByte; java.nio.ByteBuffer.wrap(encoded$) }}.asInstanceOf[AnyRef]
      }
      case 13 => _duration match {
        case None => null
        case Some(x) => {{ val period$ = x; val result$ = new avro2s.test.logical.MatrixDurationFixed(); val bytes$ = result$.bytes(); var word$ = period$.getMonths.toInt; bytes$(0) = word$.toByte; bytes$(1) = (word$ >>> 8).toByte; bytes$(2) = (word$ >>> 16).toByte; bytes$(3) = (word$ >>> 24).toByte; word$ = period$.getDays.toInt; bytes$(4) = word$.toByte; bytes$(5) = (word$ >>> 8).toByte; bytes$(6) = (word$ >>> 16).toByte; bytes$(7) = (word$ >>> 24).toByte; word$ = period$.getMillis.toInt; bytes$(8) = word$.toByte; bytes$(9) = (word$ >>> 8).toByte; bytes$(10) = (word$ >>> 16).toByte; bytes$(11) = (word$ >>> 24).toByte; result$ }}.asInstanceOf[AnyRef]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._uuid = {
        value match {
          case null => None
          case x: java.util.UUID => Some(x)
          case x: CharSequence => Some({java.util.UUID.fromString(x.toString)})
        }
      }
      case 1 => this._date = {
        value match {
          case null => None
          case x: java.time.LocalDate => Some(x)
          case x: Int => Some({java.time.LocalDate.ofEpochDay(x)})
        }
      }
      case 2 => this._time_millis = {
        value match {
          case null => None
          case x: java.time.LocalTime => Some(x)
          case x: Int => Some({java.time.LocalTime.ofNanoOfDay(x * 1000000L)})
        }
      }
      case 3 => this._time_micros = {
        value match {
          case null => None
          case x: java.time.LocalTime => Some(x)
          case x: Long => Some({java.time.LocalTime.ofNanoOfDay(x * 1000L)})
        }
      }
      case 4 => this._timestamp_millis = {
        value match {
          case null => None
          case x: java.time.Instant => Some(x)
          case x: Long => Some({java.time.Instant.ofEpochMilli(x)})
        }
      }
      case 5 => this._timestamp_micros = {
        value match {
          case null => None
          case x: java.time.Instant => Some(x)
          case x: Long => Some({java.time.Instant.ofEpochSecond(x / 1000000L, (x % 1000000L) * 1000L)})
        }
      }
      case 6 => this._timestamp_nanos = {
        value match {
          case null => None
          case x: java.time.Instant => Some(x)
          case x: Long => Some({java.time.Instant.ofEpochSecond(java.lang.Math.floorDiv(x, 1000000000L), java.lang.Math.floorMod(x, 1000000000L))})
        }
      }
      case 7 => this._local_timestamp_millis = {
        value match {
          case null => None
          case x: java.time.LocalDateTime => Some(x)
          case x: Long => Some({java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(x), java.time.ZoneId.of("UTC"))})
        }
      }
      case 8 => this._local_timestamp_micros = {
        value match {
          case null => None
          case x: java.time.LocalDateTime => Some(x)
          case x: Long => Some({java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(x / 1000000L, (x % 1000000L) * 1000L), java.time.ZoneId.of("UTC"))})
        }
      }
      case 9 => this._local_timestamp_nanos = {
        value match {
          case null => None
          case x: java.time.LocalDateTime => Some(x)
          case x: Long => Some({java.time.LocalDateTime.ofEpochSecond(java.lang.Math.floorDiv(x, 1000000000L), java.lang.Math.floorMod(x, 1000000000L).toInt, java.time.ZoneOffset.UTC)})
        }
      }
      case 10 => this._decimal_bytes = {
        value match {
          case null => None
          case x: java.math.BigDecimal => Some(scala.math.BigDecimal(x))
          case x: java.nio.ByteBuffer => Some({{ val buffer$ = x; val length$ = buffer$.remaining; if (length$ >= 1 && length$ <= 8) { val offset$ = buffer$.position(); var unscaled$ = if (buffer$.get(offset$) < 0) -1L else 0L; var index$ = 0; while (index$ < length$) { unscaled$ = (unscaled$ << 8) | (buffer$.get(offset$ + index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else { val offset$ = buffer$.position(); val bytes$ = new Array[Byte](length$); buffer$.get(bytes$); (buffer$: java.nio.Buffer).position(offset$); scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$), 2)) } }})
        }
      }
      case 11 => this._decimal_fixed = {
        value match {
          case null => None
          case x: java.math.BigDecimal => Some(scala.math.BigDecimal(x))
          case x: avro2s.test.logical.MatrixDecimalFixed => Some({{ val raw$ = x.bytes(); val sign$ = if (raw$(0) < 0) -1L else 0L; val signByte$ = sign$.toByte; var first$ = 0; while (first$ < raw$.length - 1 && raw$(first$) == signByte$ && ((raw$(first$ + 1) < 0) == (signByte$ < 0))) first$ += 1; if (raw$.length - first$ <= 8) { var unscaled$ = sign$; var index$ = first$; while (index$ < raw$.length) { unscaled$ = (unscaled$ << 8) | (raw$(index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 4)) } else scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(raw$), 4)) }})
        }
      }
      case 12 => this._big_decimal = {
        value match {
          case null => None
          case x: java.math.BigDecimal => Some(x)
          case x: java.nio.ByteBuffer => Some({{ val buffer$ = x; var at$ = buffer$.position(); val length$ = { var shift$ = 0; var word$ = 0; var more$ = true; while (more$) { val chunk$ = buffer$.get(at$) & 0xFF; at$ += 1; word$ |= (chunk$ & 0x7F) << shift$; shift$ += 7; more$ = (chunk$ & 0x80) != 0 }; (word$ >>> 1) ^ -(word$ & 1) }; val unscaled$ = new Array[Byte](length$); var index$ = 0; while (index$ < length$) { unscaled$(index$) = buffer$.get(at$ + index$); index$ += 1 }; at$ += length$; val scale$ = { var shift$ = 0; var word$ = 0; var more$ = true; while (more$) { val chunk$ = buffer$.get(at$) & 0xFF; at$ += 1; word$ |= (chunk$ & 0x7F) << shift$; shift$ += 7; more$ = (chunk$ & 0x80) != 0 }; (word$ >>> 1) ^ -(word$ & 1) }; new java.math.BigDecimal(new java.math.BigInteger(unscaled$), scale$) }})
        }
      }
      case 13 => this._duration = {
        value match {
          case null => None
          case x: org.apache.avro.util.TimePeriod => Some(x)
          case x: avro2s.test.logical.MatrixDurationFixed => Some({{ val bytes$ = x.bytes(); org.apache.avro.util.TimePeriod.of(((bytes$(0) & 0xFFL) | ((bytes$(1) & 0xFFL) << 8) | ((bytes$(2) & 0xFFL) << 16) | ((bytes$(3) & 0xFFL) << 24)), ((bytes$(4) & 0xFFL) | ((bytes$(5) & 0xFFL) << 8) | ((bytes$(6) & 0xFFL) << 16) | ((bytes$(7) & 0xFFL) << 24)), ((bytes$(8) & 0xFFL) | ((bytes$(9) & 0xFFL) << 8) | ((bytes$(10) & 0xFFL) << 16) | ((bytes$(11) & 0xFFL) << 24))) }})
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object LogicalMatrixOptions {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"LogicalMatrixOptions","namespace":"avro2s.test.logical","doc":"Every supported logical type in the options position.","fields":[{"name":"_uuid","type":["null",{"type":"string","logicalType":"uuid"}]},{"name":"_date","type":["null",{"type":"int","logicalType":"date"}]},{"name":"_time_millis","type":["null",{"type":"int","logicalType":"time-millis"}]},{"name":"_time_micros","type":["null",{"type":"long","logicalType":"time-micros"}]},{"name":"_timestamp_millis","type":["null",{"type":"long","logicalType":"timestamp-millis"}]},{"name":"_timestamp_micros","type":["null",{"type":"long","logicalType":"timestamp-micros"}]},{"name":"_timestamp_nanos","type":["null",{"type":"long","logicalType":"timestamp-nanos"}]},{"name":"_local_timestamp_millis","type":["null",{"type":"long","logicalType":"local-timestamp-millis"}]},{"name":"_local_timestamp_micros","type":["null",{"type":"long","logicalType":"local-timestamp-micros"}]},{"name":"_local_timestamp_nanos","type":["null",{"type":"long","logicalType":"local-timestamp-nanos"}]},{"name":"_decimal_bytes","type":["null",{"type":"bytes","logicalType":"decimal","precision":10,"scale":2}]},{"name":"_decimal_fixed","type":["null",{"type":"fixed","name":"MatrixDecimalFixed","size":16,"logicalType":"decimal","precision":20,"scale":4}]},{"name":"_big_decimal","type":["null",{"type":"bytes","logicalType":"big-decimal"}]},{"name":"_duration","type":["null",{"type":"fixed","name":"MatrixDurationFixed","size":12,"logicalType":"duration"}]}]}""")
  val $UUIDConversion: org.apache.avro.Conversion[_] = new org.apache.avro.Conversions.UUIDConversion()
  val $DateConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.DateConversion()
  val $TimeMillisConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.TimeMillisConversion()
  val $TimeMicrosConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.TimeMicrosConversion()
  val $TimestampMillisConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.TimestampMillisConversion()
  val $TimestampMicrosConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.TimestampMicrosConversion()
  val $TimestampNanosConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.TimestampNanosConversion() { override def fromLong(value: java.lang.Long, schema: org.apache.avro.Schema, logicalType: org.apache.avro.LogicalType): java.time.Instant = java.time.Instant.ofEpochSecond(java.lang.Math.floorDiv(value.longValue, 1000000000L), java.lang.Math.floorMod(value.longValue, 1000000000L)); override def toLong(value: java.time.Instant, schema: org.apache.avro.Schema, logicalType: org.apache.avro.LogicalType): java.lang.Long = java.lang.Long.valueOf(java.lang.Math.addExact(java.lang.Math.multiplyExact(value.getEpochSecond, 1000000000L), value.getNano.toLong)) }
  val $LocalTimestampMillisConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.LocalTimestampMillisConversion()
  val $LocalTimestampMicrosConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.LocalTimestampMicrosConversion()
  val $LocalTimestampNanosConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.LocalTimestampNanosConversion() { override def fromLong(value: java.lang.Long, schema: org.apache.avro.Schema, logicalType: org.apache.avro.LogicalType): java.time.LocalDateTime = java.time.LocalDateTime.ofEpochSecond(java.lang.Math.floorDiv(value.longValue, 1000000000L), java.lang.Math.floorMod(value.longValue, 1000000000L).toInt, java.time.ZoneOffset.UTC); override def toLong(value: java.time.LocalDateTime, schema: org.apache.avro.Schema, logicalType: org.apache.avro.LogicalType): java.lang.Long = java.lang.Long.valueOf(java.lang.Math.addExact(java.lang.Math.multiplyExact(value.toEpochSecond(java.time.ZoneOffset.UTC), 1000000000L), value.getNano.toLong)) }
  val $DurationConversion: org.apache.avro.Conversion[_] = new org.apache.avro.Conversions.DurationConversion()
  val MODEL$: org.apache.avro.specific.SpecificData = {
    val model = new org.apache.avro.specific.SpecificData()
    model.addLogicalTypeConversion($UUIDConversion)
    model.addLogicalTypeConversion($DateConversion)
    model.addLogicalTypeConversion($TimeMillisConversion)
    model.addLogicalTypeConversion($TimeMicrosConversion)
    model.addLogicalTypeConversion($TimestampMillisConversion)
    model.addLogicalTypeConversion($TimestampMicrosConversion)
    model.addLogicalTypeConversion($TimestampNanosConversion)
    model.addLogicalTypeConversion($LocalTimestampMillisConversion)
    model.addLogicalTypeConversion($LocalTimestampMicrosConversion)
    model.addLogicalTypeConversion($LocalTimestampNanosConversion)
    model.addLogicalTypeConversion($DurationConversion)
    model
  }
}