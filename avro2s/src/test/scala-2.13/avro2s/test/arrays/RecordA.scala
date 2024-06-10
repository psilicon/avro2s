/** GENERATED CODE */

package avro2s.test.arrays

import scala.annotation.switch

case class RecordA(var _string: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("")

  override def getSchema: org.apache.avro.Schema = RecordA.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _string.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._string = value.toString.asInstanceOf[String]
    }
  }
}

object RecordA {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"RecordA","namespace":"avro2s.test.arrays","fields":[{"name":"_string","type":"string"}]}""")
}