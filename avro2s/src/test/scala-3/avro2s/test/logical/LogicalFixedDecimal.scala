/** GENERATED CODE */

package avro2s.test.logical

import scala.annotation.switch

case class LogicalFixedDecimal(var _decimal_fixed: scala.math.BigDecimal) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(LogicalFixedDecimal.$default$0)

  override def getSchema: org.apache.avro.Schema = LogicalFixedDecimal.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => {val decimal$ = (try _decimal_fixed.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + _decimal_fixed.scale + " as scale 2") }); if (decimal$.precision > 4) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 4"); val padded$ = new Array[Byte](2); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; if (width$ > 2) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 2 + " bytes"); if (unscaled$ < 0) java.util.Arrays.fill(padded$, 0, 2 - width$, 0xFF.toByte); var rest$ = unscaled$; var at$ = 2 - 1; while (at$ >= 2 - width$) { padded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 } } else { val unscaled$ = decimal$.unscaledValue().toByteArray; if (unscaled$.length > 2) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 2 + " bytes"); if (unscaled$(0) < 0) java.util.Arrays.fill(padded$, 0, 2 - unscaled$.length, 0xFF.toByte); System.arraycopy(unscaled$, 0, padded$, 2 - unscaled$.length, unscaled$.length) }; val result$ = new avro2s.test.logical.DecimalFixed(); result$.bytes(padded$); result$}.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._decimal_fixed = {
        {{ val raw$ = value.asInstanceOf[avro2s.test.logical.DecimalFixed].bytes(); val sign$ = if (raw$(0) < 0) -1L else 0L; val signByte$ = sign$.toByte; var first$ = 0; while (first$ < raw$.length - 1 && raw$(first$) == signByte$ && ((raw$(first$ + 1) < 0) == (signByte$ < 0))) first$ += 1; if (raw$.length - first$ <= 8) { var unscaled$ = sign$; var index$ = first$; while (index$ < raw$.length) { unscaled$ = (unscaled$ << 8) | (raw$(index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(raw$), 2)) }}
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object LogicalFixedDecimal {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"LogicalFixedDecimal","namespace":"avro2s.test.logical","fields":[{"name":"_decimal_fixed","type":{"type":"fixed","name":"DecimalFixed","size":2,"logicalType":"decimal","precision":4,"scale":2}}]}""")
  private val $default$0: scala.math.BigDecimal = scala.math.BigDecimal(0)
}