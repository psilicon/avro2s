package avro2s.generator.specific

import avro2s.error.Error.ConfigError
import avro2s.error.Error.SchemaError
import avro2s.generator.EnumType
import avro2s.generator.logical.LogicalTypes
import avro2s.generator.logical.LogicalTypes.LogicalTypeConverter
import avro2s.generator.javagenerator.JavaGenericEnumGenerator.schemaToJavaEnum
import avro2s.generator.specific.scala2.enumeration.ScalaAdtEnumGenerator
import avro2s.generator.specific.scala2.fixed.SpecificFixedGenerator.schemaToScala2Fixed
import avro2s.generator.specific.scala3.enumeration.Scala3EnumGenerator
import avro2s.generator.{GeneratedCode, GeneratorConfig}
import avro2s.language.ScalaVersion
import org.apache.avro.Schema
import org.apache.avro.Schema.Type.{ENUM, FIXED, RECORD}

private[avro2s] class SpecificGenerator(generatorConfig: GeneratorConfig) {
  private val scala2SpecificGenerator = new scala2.record.SpecificRecordGenerator(generatorConfig)
  private val scala3SpecificGenerator = new scala3.record.SpecificRecordGenerator(generatorConfig)
  import scala2SpecificGenerator._
  import scala3SpecificGenerator._

  private val ltc = LogicalTypeConverter(
    if (generatorConfig.logicalTypesEnabled) LogicalTypes.logicalTypeMap else Map.empty)

  def compile(
    schema: Schema,
    namespace: Option[String]): GeneratedCode = {

    UnionValidator.validate(schema, ltc)

    generatorConfig.targetScalaVersion match {
      case ScalaVersion.Scala_2_13 => compileScala2(schema, namespace)
      case ScalaVersion.Scala_3 => compileScala3(schema, namespace)
    }
  }

  private def compileScala2(schema: Schema, namespace: Option[String]): GeneratedCode = {
    schema.getType match {
      case RECORD => schemaToScala2Record(schema, namespace)
      case ENUM => compileEnum(schema, namespace)
      case FIXED => schemaToScala2Fixed(schema, namespace)
      case _ => throw SchemaError("Only RECORD, or ENUM can be toplevel definitions")
    }
  }

  private def compileScala3(schema: Schema, namespace: Option[String]): GeneratedCode = {
    schema.getType match {
      case RECORD => schemaToScala3Record(schema, namespace)
      case ENUM => compileEnum(schema, namespace)
      case FIXED => schemaToScala2Fixed(schema, namespace)
      case _ => throw SchemaError("Only RECORD, or ENUM can be toplevel definitions")
    }
  }

  private def compileEnum(schema: Schema, namespace: Option[String]): GeneratedCode = {
    (generatorConfig.enumType, generatorConfig.targetScalaVersion) match {
      case (EnumType.ScalaEnum, _) if Option(schema.getNamespace).forall(_.isEmpty) =>
        throw ConfigError(s"Scala-native enumType requires enum ${schema.getName} to have a namespace")
      case (EnumType.ScalaEnum, ScalaVersion.Scala_3) =>
        Scala3EnumGenerator.schemaToScala3Enum(schema)
      case (EnumType.ScalaEnum, ScalaVersion.Scala_2_13) =>
        ScalaAdtEnumGenerator.schemaToScala2Adt(schema)
      case _ =>
        schemaToJavaEnum(schema, namespace)
    }
  }
}
