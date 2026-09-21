/** GENERATED CODE */

package avro2s.test.logical

import scala.annotation.switch

case class LogicalDuration(var _duration: org.apache.avro.util.TimePeriod) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(LogicalDuration.$default$0)

  override def getSchema: org.apache.avro.Schema = LogicalDuration.SCHEMA$

  override def getSpecificData(): org.apache.avro.specific.SpecificData = LogicalDuration.MODEL$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => {{ val period$ = _duration; val result$ = new avro2s.test.logical.DurationFixed(); val bytes$ = result$.bytes(); var word$ = period$.getMonths.toInt; bytes$(0) = word$.toByte; bytes$(1) = (word$ >>> 8).toByte; bytes$(2) = (word$ >>> 16).toByte; bytes$(3) = (word$ >>> 24).toByte; word$ = period$.getDays.toInt; bytes$(4) = word$.toByte; bytes$(5) = (word$ >>> 8).toByte; bytes$(6) = (word$ >>> 16).toByte; bytes$(7) = (word$ >>> 24).toByte; word$ = period$.getMillis.toInt; bytes$(8) = word$.toByte; bytes$(9) = (word$ >>> 8).toByte; bytes$(10) = (word$ >>> 16).toByte; bytes$(11) = (word$ >>> 24).toByte; result$ }}.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._duration = {
        {(value match { case null => null; case period$: org.apache.avro.util.TimePeriod => period$; case fixed$: avro2s.test.logical.DurationFixed => { val bytes$ = fixed$.bytes(); org.apache.avro.util.TimePeriod.of(((bytes$(0) & 0xFFL) | ((bytes$(1) & 0xFFL) << 8) | ((bytes$(2) & 0xFFL) << 16) | ((bytes$(3) & 0xFFL) << 24)), ((bytes$(4) & 0xFFL) | ((bytes$(5) & 0xFFL) << 8) | ((bytes$(6) & 0xFFL) << 16) | ((bytes$(7) & 0xFFL) << 24)), ((bytes$(8) & 0xFFL) | ((bytes$(9) & 0xFFL) << 8) | ((bytes$(10) & 0xFFL) << 16) | ((bytes$(11) & 0xFFL) << 24))) } })}
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object LogicalDuration {
  @scala.annotation.static val $DurationConversion: org.apache.avro.Conversion[?] = new org.apache.avro.Conversions.DurationConversion()
  @scala.annotation.static val MODEL$: org.apache.avro.specific.SpecificData = List($DurationConversion).foldLeft(new org.apache.avro.specific.SpecificData())((model, conversion) => { model.addLogicalTypeConversion(conversion); model })
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"LogicalDuration","namespace":"avro2s.test.logical","fields":[{"name":"_duration","type":{"type":"fixed","name":"DurationFixed","size":12,"logicalType":"duration"}}]}""")
  private val $default$0: org.apache.avro.util.TimePeriod = org.apache.avro.util.TimePeriod.of(0L, 0L, 0L)
}