/** GENERATED CODE */

package avro2s.test.records

import scala.annotation.switch

case class EmptyRecord() extends org.apache.avro.specific.SpecificRecordBase {

  override def getSchema: org.apache.avro.Schema = EmptyRecord.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object EmptyRecord {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"EmptyRecord","namespace":"avro2s.test.records","fields":[]}""")
}