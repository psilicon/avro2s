/** GENERATED CODE */

package avro2s.test.logical

import scala.annotation.switch

case class LogicalFixedDecimal(var _decimal_fixed: scala.math.BigDecimal) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(scala.math.BigDecimal(0))

  override def getSchema: org.apache.avro.Schema = LogicalFixedDecimal.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => {val unscaled = _decimal_fixed.setScale(2).bigDecimal.unscaledValue().toByteArray; if (unscaled.length > 2) throw new ArithmeticException("Decimal value does not fit in " + 2 + " bytes: requires " + unscaled.length + " bytes"); val padded = new Array[Byte](2); val fillByte: Byte = if (unscaled.length > 0 && unscaled(0) < 0) 0xFF.toByte else 0x00.toByte; java.util.Arrays.fill(padded, fillByte); System.arraycopy(unscaled, 0, padded, 2 - unscaled.length, unscaled.length); val result = new avro2s.test.logical.DecimalFixed(); result.bytes(padded); result}.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._decimal_fixed = {
        {scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(value.asInstanceOf[org.apache.avro.generic.GenericFixed].bytes()), 2))}
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def getConversion(field: Int): org.apache.avro.Conversion[?] = {
    (field: @switch) match {
      case 0 => null
      case _ => null
    }
  }
}

object LogicalFixedDecimal {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"LogicalFixedDecimal","namespace":"avro2s.test.logical","fields":[{"name":"_decimal_fixed","type":{"type":"fixed","name":"DecimalFixed","size":2,"logicalType":"decimal","precision":4,"scale":2}}]}""")
}