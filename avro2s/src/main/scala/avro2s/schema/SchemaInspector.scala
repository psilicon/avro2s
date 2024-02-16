package avro2s.schema

import org.apache.avro.Schema

private[avro2s] object SchemaInspector {

  import Schema.Type._

  def getNamespace(schema: Schema): Option[String] = schema.getType match {
    case RECORD | ENUM | FIXED =>
      Option(schema.getNamespace)
    case _ => None
  }
}