/** GENERATED CODE */

package avro2s.test.maps

import scala.annotation.switch

case class Record(var a: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("")

  override def getSchema: org.apache.avro.Schema = Record.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => a.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.a = {
        value.toString.asInstanceOf[String]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object Record {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Record","namespace":"avro2s.test.maps","fields":[{"name":"a","type":"string"}]}""")
}