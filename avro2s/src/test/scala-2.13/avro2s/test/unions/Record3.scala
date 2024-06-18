/** GENERATED CODE */

package avro2s.test.unions

import scala.annotation.switch

case class Record3(var field3: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("")

  override def getSchema: org.apache.avro.Schema = Record3.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => field3.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.field3 = value.toString.asInstanceOf[String]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object Record3 {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Record3","namespace":"avro2s.test.unions","fields":[{"name":"field3","type":"string"}]}""")
}