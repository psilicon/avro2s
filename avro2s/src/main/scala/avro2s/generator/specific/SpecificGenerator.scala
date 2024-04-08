package avro2s.generator.specific

import avro2s.error.Error.SchemaError
import avro2s.generator.javagenerator.JavaGenericEnumGenerator.schemaToJavaEnum
import avro2s.generator.specific.scala2.fixed.SpecificFixedGenerator.schemaToScala2Fixed
import avro2s.generator.{GeneratedCode, GeneratorConfig}
import avro2s.language.ScalaVersion
import org.apache.avro.Schema
import org.apache.avro.Schema.Type.{ENUM, FIXED, RECORD}

private[avro2s] class SpecificGenerator(generatorConfig: GeneratorConfig) {
  private val scala2SpecificGenerator = new scala2.record.SpecificRecordGenerator(generatorConfig)
  private val scala3SpecificGenerator = new scala3.record.SpecificRecordGenerator(generatorConfig)
  import scala2SpecificGenerator._
  import scala3SpecificGenerator._

  def compile(
    schema: Schema,
    namespace: Option[String]): GeneratedCode = {

    generatorConfig.targetScalaVersion match {
      case ScalaVersion.Scala_2_13 => compileScala2(schema, namespace)
      case ScalaVersion.Scala_3 => compileScala3(schema, namespace)
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

  private def compileScala3(schema: Schema, namespace: Option[String]): GeneratedCode = {
    schema.getType match {
      case RECORD => schemaToScala3Record(schema, namespace)
      case ENUM => schemaToJavaEnum(schema, namespace)
      case FIXED => schemaToScala2Fixed(schema, namespace)
      case _ => throw SchemaError("Only RECORD, or ENUM can be toplevel definitions")
    }
  }
}
