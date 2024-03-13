/** GENERATED CODE */

package avro2s.test.namespaces

import scala.annotation.switch

case class RecordWithInheritedNamespace(var _string: String, var _record_with_namespace_inherited_from_indirect_parent: avro2s.test.namespaces.RecordWithNamespaceInheritedFromIndirectParent) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("", new avro2s.test.namespaces.RecordWithNamespaceInheritedFromIndirectParent())

  override def getSchema: org.apache.avro.Schema = RecordWithInheritedNamespace.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _string.asInstanceOf[AnyRef]
      case 1 => _record_with_namespace_inherited_from_indirect_parent.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._string = value.toString.asInstanceOf[String]
      case 1 => this._record_with_namespace_inherited_from_indirect_parent = value.asInstanceOf[avro2s.test.namespaces.RecordWithNamespaceInheritedFromIndirectParent]
    }
  }
}

object RecordWithInheritedNamespace {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"RecordWithInheritedNamespace","namespace":"avro2s.test.namespaces","fields":[{"name":"_string","type":"string"},{"name":"_record_with_namespace_inherited_from_indirect_parent","type":{"type":"record","name":"RecordWithNamespaceInheritedFromIndirectParent","fields":[{"name":"_string","type":"string"}]}}]}""")
}