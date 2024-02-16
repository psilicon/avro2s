package avro2s.generator.specific

import avro2s.error.Error.{NotImplementedError, SchemaError}
import avro2s.generator.GeneratedCode
import avro2s.generator.javagenerator.JavaGenericEnumGenerator.schemaToJavaEnum
import avro2s.generator.specific.scala2.fixed.SpecificFixedGenerator.schemaToScala2Fixed
import avro2s.generator.specific.scala2.record.SpecificRecordGenerator.schemaToScala2Record
import avro2s.language.ScalaVersion
import org.apache.avro.Schema
import org.apache.avro.Schema.Type.{ENUM, FIXED, RECORD}

private[avro2s] object SpecificGenerator {

  def compile(
    schema: Schema,
    namespace: Option[String],
    targetScalaVersion: ScalaVersion): GeneratedCode = {

    targetScalaVersion match {
      case ScalaVersion.Scala_2_13 => compileScala2(schema, namespace)
      case ScalaVersion.Scala_3 => throw NotImplementedError("Scala 3 not implemented yet")
    }
  }

  private def compileScala2(schema: Schema, namespace: Option[String]): GeneratedCode = {
    schema.getType match {
      case RECORD => schemaToScala2Record(schema, namespace)
      case ENUM => schemaToJavaEnum(schema, namespace)
      case FIXED => schemaToScala2Fixed(schema, namespace)
      case _ => throw SchemaError("Only RECORD, or ENUM can be toplevel definitions")
    }
  }
}
