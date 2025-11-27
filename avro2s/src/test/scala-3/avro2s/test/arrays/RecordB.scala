/** GENERATED CODE */

package avro2s.test.arrays

import scala.annotation.switch

case class RecordB(var _string: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("")

  override def getSchema: org.apache.avro.Schema = RecordB.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _string.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._string = {
        value.toString.asInstanceOf[String]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object RecordB {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"RecordB","namespace":"avro2s.test.arrays","fields":[{"name":"_string","type":"string"}]}""")
}