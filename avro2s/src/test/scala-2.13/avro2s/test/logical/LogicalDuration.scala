/** GENERATED CODE */

package avro2s.test.logical

import scala.annotation.switch

case class LogicalDuration(var _duration: org.apache.avro.util.TimePeriod) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(org.apache.avro.util.TimePeriod.of(0L, 0L, 0L))

  override def getSchema: org.apache.avro.Schema = LogicalDuration.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => {new org.apache.avro.Conversions.DurationConversion().toFixed(_duration, avro2s.test.logical.DurationFixed.SCHEMA$, avro2s.test.logical.DurationFixed.SCHEMA$.getLogicalType)}.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._duration = {value.asInstanceOf[org.apache.avro.util.TimePeriod]}
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def getConversion(field: Int): org.apache.avro.Conversion[_] = {
    (field: @switch) match {
      case 0 => null
      case _ => null
    }
  }
}

object LogicalDuration {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"LogicalDuration","namespace":"avro2s.test.logical","fields":[{"name":"_duration","type":{"type":"fixed","name":"DurationFixed","size":12,"logicalType":"duration"}}]}""")
}