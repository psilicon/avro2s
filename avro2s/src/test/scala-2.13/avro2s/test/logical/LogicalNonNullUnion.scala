/** GENERATED CODE */

package avro2s.test.logical

import org.apache.avro.AvroRuntimeException

import scala.annotation.switch
import shapeless.{:+:, CNil, Coproduct, Inl, Inr}

/**
 * Unions without a null branch, whose first branch carries a logical type. The no-arg constructor defaults to the first branch, so it has to use the logical type's default rather than the underlying Avro type's.
 */
case class LogicalNonNullUnion(var _date_or_string: java.time.LocalDate :+: String :+: CNil, var _instant_or_string: java.time.Instant :+: String :+: CNil, var _uuid_or_int: java.util.UUID :+: Int :+: CNil, var _decimal_or_string: scala.math.BigDecimal :+: String :+: CNil) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(Inl(LogicalNonNullUnion.$default$0), Inl(LogicalNonNullUnion.$default$1), Inl(LogicalNonNullUnion.$default$2), Inl(LogicalNonNullUnion.$default$3))

  override def getSchema: org.apache.avro.Schema = LogicalNonNullUnion.SCHEMA$

  override def getSpecificData(): org.apache.avro.specific.SpecificData = LogicalNonNullUnion.MODEL$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _date_or_string match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 1 => _instant_or_string match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 2 => _uuid_or_int match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 3 => _decimal_or_string match {
        case Inl(x) => {val decimal$ = (try x.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + x.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; val encoded$ = new Array[Byte](width$); var rest$ = unscaled$; var at$ = width$ - 1; while (at$ >= 0) { encoded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$) } else java.nio.ByteBuffer.wrap(decimal$.unscaledValue().toByteArray)}.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._date_or_string = {
        value match {
          case x: java.time.LocalDate => Coproduct[java.time.LocalDate :+: String :+: CNil](x)
          case x: java.lang.CharSequence => Coproduct[java.time.LocalDate :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 1 => this._instant_or_string = {
        value match {
          case x: java.time.Instant => Coproduct[java.time.Instant :+: String :+: CNil](x)
          case x: java.lang.CharSequence => Coproduct[java.time.Instant :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 2 => this._uuid_or_int = {
        value match {
          case x: java.util.UUID => Coproduct[java.util.UUID :+: Int :+: CNil](x)
          case x: Int => Coproduct[java.util.UUID :+: Int :+: CNil](x)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 3 => this._decimal_or_string = {
        value match {
          case x: java.nio.ByteBuffer => Coproduct[scala.math.BigDecimal :+: String :+: CNil]({{ val buffer$ = x; val length$ = buffer$.remaining; if (length$ >= 1 && length$ <= 8) { val offset$ = buffer$.position(); var unscaled$ = if (buffer$.get(offset$) < 0) -1L else 0L; var index$ = 0; while (index$ < length$) { unscaled$ = (unscaled$ << 8) | (buffer$.get(offset$ + index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else { val offset$ = buffer$.position(); val bytes$ = new Array[Byte](length$); buffer$.get(bytes$); (buffer$: java.nio.Buffer).position(offset$); scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$), 2)) } }})
          case x: java.lang.CharSequence => Coproduct[scala.math.BigDecimal :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object LogicalNonNullUnion {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"LogicalNonNullUnion","namespace":"avro2s.test.logical","doc":"Unions without a null branch, whose first branch carries a logical type. The no-arg constructor defaults to the first branch, so it has to use the logical type's default rather than the underlying Avro type's.","fields":[{"name":"_date_or_string","type":[{"type":"int","logicalType":"date"},"string"]},{"name":"_instant_or_string","type":[{"type":"long","logicalType":"timestamp-millis"},"string"]},{"name":"_uuid_or_int","type":[{"type":"string","logicalType":"uuid"},"int"]},{"name":"_decimal_or_string","type":[{"type":"bytes","logicalType":"decimal","precision":10,"scale":2},"string"]}]}""")
  val $DateConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.DateConversion()
  val $TimestampMillisConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.TimestampMillisConversion()
  val $UUIDConversion: org.apache.avro.Conversion[_] = new org.apache.avro.Conversions.UUIDConversion()
  val MODEL$: org.apache.avro.specific.SpecificData = {
    val model = new org.apache.avro.specific.SpecificData()
    model.addLogicalTypeConversion($DateConversion)
    model.addLogicalTypeConversion($TimestampMillisConversion)
    model.addLogicalTypeConversion($UUIDConversion)
    model
  }
  private val $default$0: java.time.LocalDate = java.time.LocalDate.ofEpochDay(0)
  private val $default$1: java.time.Instant = java.time.Instant.ofEpochMilli(0)
  private val $default$2: java.util.UUID = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")
  private val $default$3: scala.math.BigDecimal = scala.math.BigDecimal(0)
}