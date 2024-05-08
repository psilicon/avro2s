/** GENERATED CODE */

package avro2s.test.unions

import scala.annotation.switch

case class RecordForComplexOptions(var field1: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("")

  override def getSchema: org.apache.avro.Schema = RecordForComplexOptions.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => field1.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.field1 = value.toString.asInstanceOf[String]
    }
  }
}

object RecordForComplexOptions {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"RecordForComplexOptions","namespace":"avro2s.test.unions","fields":[{"name":"field1","type":"string"}]}""")
}