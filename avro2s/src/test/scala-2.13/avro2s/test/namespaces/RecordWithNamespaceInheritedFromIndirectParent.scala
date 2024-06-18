/** GENERATED CODE */

package avro2s.test.namespaces

import scala.annotation.switch

case class RecordWithNamespaceInheritedFromIndirectParent(var _string: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("")

  override def getSchema: org.apache.avro.Schema = RecordWithNamespaceInheritedFromIndirectParent.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _string.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._string = value.toString.asInstanceOf[String]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object RecordWithNamespaceInheritedFromIndirectParent {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"RecordWithNamespaceInheritedFromIndirectParent","namespace":"avro2s.test.namespaces","fields":[{"name":"_string","type":"string"}]}""")
}