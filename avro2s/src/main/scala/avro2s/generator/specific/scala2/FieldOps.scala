package avro2s.generator.specific.scala2

import org.apache.avro.Schema

private[avro2s] object FieldOps {
  implicit class FieldOps(field: Schema.Field) {
    def safeName: String = {
      val name = field.name()
      if (ReservedWords.set.contains(name)) s"`$name`" else name
    }
  }
}
