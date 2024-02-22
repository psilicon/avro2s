/** GENERATED CODE */

package avro2s.test.unions

import scala.annotation.switch

case class Record2(var field2: Long) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(0)
  
  override def getSchema: org.apache.avro.Schema = Record2.SCHEMA$
  
  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => field2.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
  
  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.field2 = value.asInstanceOf[Long]
    }
  }
}

object Record2 {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Record2","namespace":"avro2s.test.unions","fields":[{"name":"field2","type":"long"}]}""")
}