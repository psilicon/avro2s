/** GENERATED CODE */

package avro2s.test.namespaces.explicit

import scala.annotation.switch

case class RecordWithNamespaceInheritedFromIndirectNonTopLevelParent(var _string: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("")

  override def getSchema: org.apache.avro.Schema = RecordWithNamespaceInheritedFromIndirectNonTopLevelParent.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _string.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._string = {
        value.toString.asInstanceOf[String]
      }
    }
  }
}

object RecordWithNamespaceInheritedFromIndirectNonTopLevelParent {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"RecordWithNamespaceInheritedFromIndirectNonTopLevelParent","namespace":"avro2s.test.namespaces.explicit","fields":[{"name":"_string","type":"string"}]}""")
}