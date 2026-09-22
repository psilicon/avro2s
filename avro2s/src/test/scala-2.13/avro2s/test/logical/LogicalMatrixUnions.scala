/** GENERATED CODE */

package avro2s.test.logical

import org.apache.avro.AvroRuntimeException

import scala.annotation.switch
import shapeless.{:+:, CNil, Coproduct, Inl, Inr}

/**
 * Every supported logical type in the unions position.
 */
case class LogicalMatrixUnions(var _uuid: scala.Null :+: java.util.UUID :+: Int :+: CNil, var _date: scala.Null :+: java.time.LocalDate :+: String :+: CNil, var _time_millis: scala.Null :+: java.time.LocalTime :+: String :+: CNil, var _time_micros: scala.Null :+: java.time.LocalTime :+: String :+: CNil, var _timestamp_millis: scala.Null :+: java.time.Instant :+: String :+: CNil, var _timestamp_micros: scala.Null :+: java.time.Instant :+: String :+: CNil, var _timestamp_nanos: scala.Null :+: java.time.Instant :+: String :+: CNil, var _local_timestamp_millis: scala.Null :+: java.time.LocalDateTime :+: String :+: CNil, var _local_timestamp_micros: scala.Null :+: java.time.LocalDateTime :+: String :+: CNil, var _local_timestamp_nanos: scala.Null :+: java.time.LocalDateTime :+: String :+: CNil, var _decimal_bytes: scala.Null :+: scala.math.BigDecimal :+: String :+: CNil, var _decimal_fixed: scala.Null :+: scala.math.BigDecimal :+: String :+: CNil, var _big_decimal: scala.Null :+: java.math.BigDecimal :+: String :+: CNil, var _duration: scala.Null :+: org.apache.avro.util.TimePeriod :+: String :+: CNil) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(Inl(null), Inl(null), Inl(null), Inl(null), Inl(null), Inl(null), Inl(null), Inl(null), Inl(null), Inl(null), Inl(null), Inl(null), Inl(null), Inl(null))

  override def getSchema: org.apache.avro.Schema = LogicalMatrixUnions.SCHEMA$

  override def getSpecificData(): org.apache.avro.specific.SpecificData = LogicalMatrixUnions.MODEL$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _uuid match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => {x.toString}.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 1 => _date match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => {x.toEpochDay.toInt}.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 2 => _time_millis match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => {(x.toNanoOfDay / 1000000L).toInt}.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 3 => _time_micros match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => {x.toNanoOfDay / 1000L}.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 4 => _timestamp_millis match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => {x.toEpochMilli}.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 5 => _timestamp_micros match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => {(x.getEpochSecond * 1000000L) + (x.getNano / 1000L)}.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 6 => _timestamp_nanos match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => {java.lang.Math.addExact(java.lang.Math.multiplyExact(x.getEpochSecond, 1000000000L), x.getNano.toLong)}.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 7 => _local_timestamp_millis match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => {x.atZone(java.time.ZoneId.of("UTC")).toInstant.toEpochMilli}.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 8 => _local_timestamp_micros match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => {x.atZone(java.time.ZoneId.of("UTC")).toInstant.getEpochSecond * 1000000L + x.atZone(java.time.ZoneId.of("UTC")).toInstant.getNano / 1000L}.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 9 => _local_timestamp_nanos match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => {java.lang.Math.addExact(java.lang.Math.multiplyExact(x.toEpochSecond(java.time.ZoneOffset.UTC), 1000000000L), x.getNano.toLong)}.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 10 => _decimal_bytes match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => {val decimal$ = (try x.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + x.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; val encoded$ = new Array[Byte](width$); var rest$ = unscaled$; var at$ = width$ - 1; while (at$ >= 0) { encoded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$) } else java.nio.ByteBuffer.wrap(decimal$.unscaledValue().toByteArray)}.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 11 => _decimal_fixed match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => {val decimal$ = (try x.setScale(4).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + x.scale + " as scale 4") }); if (decimal$.precision > 20) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 20"); val padded$ = new Array[Byte](16); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(4).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; if (width$ > 16) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 16 + " bytes"); if (unscaled$ < 0) java.util.Arrays.fill(padded$, 0, 16 - width$, 0xFF.toByte); var rest$ = unscaled$; var at$ = 16 - 1; while (at$ >= 16 - width$) { padded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 } } else { val unscaled$ = decimal$.unscaledValue().toByteArray; if (unscaled$.length > 16) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 16 + " bytes"); if (unscaled$(0) < 0) java.util.Arrays.fill(padded$, 0, 16 - unscaled$.length, 0xFF.toByte); System.arraycopy(unscaled$, 0, padded$, 16 - unscaled$.length, unscaled$.length) }; val result$ = new avro2s.test.logical.MatrixDecimalFixed(); result$.bytes(padded$); result$}.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 12 => _big_decimal match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 13 => _duration match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => {{ val period$ = x; val result$ = new avro2s.test.logical.MatrixDurationFixed(); val bytes$ = result$.bytes(); var word$ = period$.getMonths.toInt; bytes$(0) = word$.toByte; bytes$(1) = (word$ >>> 8).toByte; bytes$(2) = (word$ >>> 16).toByte; bytes$(3) = (word$ >>> 24).toByte; word$ = period$.getDays.toInt; bytes$(4) = word$.toByte; bytes$(5) = (word$ >>> 8).toByte; bytes$(6) = (word$ >>> 16).toByte; bytes$(7) = (word$ >>> 24).toByte; word$ = period$.getMillis.toInt; bytes$(8) = word$.toByte; bytes$(9) = (word$ >>> 8).toByte; bytes$(10) = (word$ >>> 16).toByte; bytes$(11) = (word$ >>> 24).toByte; result$ }}.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._uuid = {
        value match {
          case x @ null => Coproduct[scala.Null :+: java.util.UUID :+: Int :+: CNil](x)
          case x: java.util.UUID => Coproduct[scala.Null :+: java.util.UUID :+: Int :+: CNil](x)
          case x: CharSequence => Coproduct[scala.Null :+: java.util.UUID :+: Int :+: CNil]({java.util.UUID.fromString(x.toString)})
          case x: Int => Coproduct[scala.Null :+: java.util.UUID :+: Int :+: CNil](x)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 1 => this._date = {
        value match {
          case x @ null => Coproduct[scala.Null :+: java.time.LocalDate :+: String :+: CNil](x)
          case x: java.time.LocalDate => Coproduct[scala.Null :+: java.time.LocalDate :+: String :+: CNil](x)
          case x: Int => Coproduct[scala.Null :+: java.time.LocalDate :+: String :+: CNil]({java.time.LocalDate.ofEpochDay(x)})
          case x: java.lang.CharSequence => Coproduct[scala.Null :+: java.time.LocalDate :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 2 => this._time_millis = {
        value match {
          case x @ null => Coproduct[scala.Null :+: java.time.LocalTime :+: String :+: CNil](x)
          case x: java.time.LocalTime => Coproduct[scala.Null :+: java.time.LocalTime :+: String :+: CNil](x)
          case x: Int => Coproduct[scala.Null :+: java.time.LocalTime :+: String :+: CNil]({java.time.LocalTime.ofNanoOfDay(x * 1000000L)})
          case x: java.lang.CharSequence => Coproduct[scala.Null :+: java.time.LocalTime :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 3 => this._time_micros = {
        value match {
          case x @ null => Coproduct[scala.Null :+: java.time.LocalTime :+: String :+: CNil](x)
          case x: java.time.LocalTime => Coproduct[scala.Null :+: java.time.LocalTime :+: String :+: CNil](x)
          case x: Long => Coproduct[scala.Null :+: java.time.LocalTime :+: String :+: CNil]({java.time.LocalTime.ofNanoOfDay(x * 1000L)})
          case x: java.lang.CharSequence => Coproduct[scala.Null :+: java.time.LocalTime :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 4 => this._timestamp_millis = {
        value match {
          case x @ null => Coproduct[scala.Null :+: java.time.Instant :+: String :+: CNil](x)
          case x: java.time.Instant => Coproduct[scala.Null :+: java.time.Instant :+: String :+: CNil](x)
          case x: Long => Coproduct[scala.Null :+: java.time.Instant :+: String :+: CNil]({java.time.Instant.ofEpochMilli(x)})
          case x: java.lang.CharSequence => Coproduct[scala.Null :+: java.time.Instant :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 5 => this._timestamp_micros = {
        value match {
          case x @ null => Coproduct[scala.Null :+: java.time.Instant :+: String :+: CNil](x)
          case x: java.time.Instant => Coproduct[scala.Null :+: java.time.Instant :+: String :+: CNil](x)
          case x: Long => Coproduct[scala.Null :+: java.time.Instant :+: String :+: CNil]({java.time.Instant.ofEpochSecond(x / 1000000L, (x % 1000000L) * 1000L)})
          case x: java.lang.CharSequence => Coproduct[scala.Null :+: java.time.Instant :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 6 => this._timestamp_nanos = {
        value match {
          case x @ null => Coproduct[scala.Null :+: java.time.Instant :+: String :+: CNil](x)
          case x: java.time.Instant => Coproduct[scala.Null :+: java.time.Instant :+: String :+: CNil](x)
          case x: Long => Coproduct[scala.Null :+: java.time.Instant :+: String :+: CNil]({java.time.Instant.ofEpochSecond(java.lang.Math.floorDiv(x, 1000000000L), java.lang.Math.floorMod(x, 1000000000L))})
          case x: java.lang.CharSequence => Coproduct[scala.Null :+: java.time.Instant :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 7 => this._local_timestamp_millis = {
        value match {
          case x @ null => Coproduct[scala.Null :+: java.time.LocalDateTime :+: String :+: CNil](x)
          case x: java.time.LocalDateTime => Coproduct[scala.Null :+: java.time.LocalDateTime :+: String :+: CNil](x)
          case x: Long => Coproduct[scala.Null :+: java.time.LocalDateTime :+: String :+: CNil]({java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(x), java.time.ZoneId.of("UTC"))})
          case x: java.lang.CharSequence => Coproduct[scala.Null :+: java.time.LocalDateTime :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 8 => this._local_timestamp_micros = {
        value match {
          case x @ null => Coproduct[scala.Null :+: java.time.LocalDateTime :+: String :+: CNil](x)
          case x: java.time.LocalDateTime => Coproduct[scala.Null :+: java.time.LocalDateTime :+: String :+: CNil](x)
          case x: Long => Coproduct[scala.Null :+: java.time.LocalDateTime :+: String :+: CNil]({java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(x / 1000000L, (x % 1000000L) * 1000L), java.time.ZoneId.of("UTC"))})
          case x: java.lang.CharSequence => Coproduct[scala.Null :+: java.time.LocalDateTime :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 9 => this._local_timestamp_nanos = {
        value match {
          case x @ null => Coproduct[scala.Null :+: java.time.LocalDateTime :+: String :+: CNil](x)
          case x: java.time.LocalDateTime => Coproduct[scala.Null :+: java.time.LocalDateTime :+: String :+: CNil](x)
          case x: Long => Coproduct[scala.Null :+: java.time.LocalDateTime :+: String :+: CNil]({java.time.LocalDateTime.ofEpochSecond(java.lang.Math.floorDiv(x, 1000000000L), java.lang.Math.floorMod(x, 1000000000L).toInt, java.time.ZoneOffset.UTC)})
          case x: java.lang.CharSequence => Coproduct[scala.Null :+: java.time.LocalDateTime :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 10 => this._decimal_bytes = {
        value match {
          case x @ null => Coproduct[scala.Null :+: scala.math.BigDecimal :+: String :+: CNil](x)
          case x: java.math.BigDecimal => Coproduct[scala.Null :+: scala.math.BigDecimal :+: String :+: CNil](scala.math.BigDecimal(x))
          case x: java.nio.ByteBuffer => Coproduct[scala.Null :+: scala.math.BigDecimal :+: String :+: CNil]({{ val buffer$ = x; val length$ = buffer$.remaining; if (length$ >= 1 && length$ <= 8) { val offset$ = buffer$.position(); var unscaled$ = if (buffer$.get(offset$) < 0) -1L else 0L; var index$ = 0; while (index$ < length$) { unscaled$ = (unscaled$ << 8) | (buffer$.get(offset$ + index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else { val offset$ = buffer$.position(); val bytes$ = new Array[Byte](length$); buffer$.get(bytes$); (buffer$: java.nio.Buffer).position(offset$); scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$), 2)) } }})
          case x: java.lang.CharSequence => Coproduct[scala.Null :+: scala.math.BigDecimal :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 11 => this._decimal_fixed = {
        value match {
          case x @ null => Coproduct[scala.Null :+: scala.math.BigDecimal :+: String :+: CNil](x)
          case x: java.math.BigDecimal => Coproduct[scala.Null :+: scala.math.BigDecimal :+: String :+: CNil](scala.math.BigDecimal(x))
          case x: avro2s.test.logical.MatrixDecimalFixed => Coproduct[scala.Null :+: scala.math.BigDecimal :+: String :+: CNil]({{ val raw$ = x.bytes(); val sign$ = if (raw$(0) < 0) -1L else 0L; val signByte$ = sign$.toByte; var first$ = 0; while (first$ < raw$.length - 1 && raw$(first$) == signByte$ && ((raw$(first$ + 1) < 0) == (signByte$ < 0))) first$ += 1; if (raw$.length - first$ <= 8) { var unscaled$ = sign$; var index$ = first$; while (index$ < raw$.length) { unscaled$ = (unscaled$ << 8) | (raw$(index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 4)) } else scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(raw$), 4)) }})
          case x: java.lang.CharSequence => Coproduct[scala.Null :+: scala.math.BigDecimal :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 12 => this._big_decimal = {
        value match {
          case x @ null => Coproduct[scala.Null :+: java.math.BigDecimal :+: String :+: CNil](x)
          case x: java.math.BigDecimal => Coproduct[scala.Null :+: java.math.BigDecimal :+: String :+: CNil](x)
          case x: java.lang.CharSequence => Coproduct[scala.Null :+: java.math.BigDecimal :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 13 => this._duration = {
        value match {
          case x @ null => Coproduct[scala.Null :+: org.apache.avro.util.TimePeriod :+: String :+: CNil](x)
          case x: org.apache.avro.util.TimePeriod => Coproduct[scala.Null :+: org.apache.avro.util.TimePeriod :+: String :+: CNil](x)
          case x: avro2s.test.logical.MatrixDurationFixed => Coproduct[scala.Null :+: org.apache.avro.util.TimePeriod :+: String :+: CNil]({{ val bytes$ = x.bytes(); org.apache.avro.util.TimePeriod.of(((bytes$(0) & 0xFFL) | ((bytes$(1) & 0xFFL) << 8) | ((bytes$(2) & 0xFFL) << 16) | ((bytes$(3) & 0xFFL) << 24)), ((bytes$(4) & 0xFFL) | ((bytes$(5) & 0xFFL) << 8) | ((bytes$(6) & 0xFFL) << 16) | ((bytes$(7) & 0xFFL) << 24)), ((bytes$(8) & 0xFFL) | ((bytes$(9) & 0xFFL) << 8) | ((bytes$(10) & 0xFFL) << 16) | ((bytes$(11) & 0xFFL) << 24))) }})
          case x: java.lang.CharSequence => Coproduct[scala.Null :+: org.apache.avro.util.TimePeriod :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object LogicalMatrixUnions {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"LogicalMatrixUnions","namespace":"avro2s.test.logical","doc":"Every supported logical type in the unions position.","fields":[{"name":"_uuid","type":["null",{"type":"string","logicalType":"uuid"},"int"]},{"name":"_date","type":["null",{"type":"int","logicalType":"date"},"string"]},{"name":"_time_millis","type":["null",{"type":"int","logicalType":"time-millis"},"string"]},{"name":"_time_micros","type":["null",{"type":"long","logicalType":"time-micros"},"string"]},{"name":"_timestamp_millis","type":["null",{"type":"long","logicalType":"timestamp-millis"},"string"]},{"name":"_timestamp_micros","type":["null",{"type":"long","logicalType":"timestamp-micros"},"string"]},{"name":"_timestamp_nanos","type":["null",{"type":"long","logicalType":"timestamp-nanos"},"string"]},{"name":"_local_timestamp_millis","type":["null",{"type":"long","logicalType":"local-timestamp-millis"},"string"]},{"name":"_local_timestamp_micros","type":["null",{"type":"long","logicalType":"local-timestamp-micros"},"string"]},{"name":"_local_timestamp_nanos","type":["null",{"type":"long","logicalType":"local-timestamp-nanos"},"string"]},{"name":"_decimal_bytes","type":["null",{"type":"bytes","logicalType":"decimal","precision":10,"scale":2},"string"]},{"name":"_decimal_fixed","type":["null",{"type":"fixed","name":"MatrixDecimalFixed","size":16,"logicalType":"decimal","precision":20,"scale":4},"string"]},{"name":"_big_decimal","type":["null",{"type":"bytes","logicalType":"big-decimal"},"string"]},{"name":"_duration","type":["null",{"type":"fixed","name":"MatrixDurationFixed","size":12,"logicalType":"duration"},"string"]}]}""")
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
  val $BigDecimalConversion: org.apache.avro.Conversion[_] = new org.apache.avro.Conversions.BigDecimalConversion()
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
    model.addLogicalTypeConversion($BigDecimalConversion)
    model.addLogicalTypeConversion($DurationConversion)
    model
  }
}