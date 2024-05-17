package avro2s.generator.specific.scala3.record

import avro2s.error.Error.SchemaError
import avro2s.generator.logical.LogicalTypes.LogicalTypeConverter
import org.apache.avro.Schema
import org.apache.avro.Schema.Type._

import scala.jdk.CollectionConverters._

private[avro2s] class TypeHelpers(ltc: LogicalTypeConverter) {
  def toStringConverter(x: String, schema: Schema): String = {
    schema.getType match {
      case STRING => s"$x.toString"
      case _ => x
    }
  }

  def typeCast(x: String, schema: Schema): String = {
    schema.getType match {
      case STRING => s"$x.toString"
      case RECORD => s"$x.asInstanceOf[${schema.getFullName}]"
      case ENUM => s"$x.asInstanceOf[${schema.getFullName}]"
      case FIXED => s"$x.asInstanceOf[${schema.getFullName}]"
      case other => s"$x.asInstanceOf[${simpleTypeToScala(other)}]"
    }
  }

  def schemas(schema: Schema): List[Schema] = {
    schema.getType match {
      case UNION => schema.getTypes.asScala.toList
      case _ => List(schema)
    }
  }

  def schemaToScalaType(schema: Schema, useLogical: Boolean): String = {
    schema.getType match {
      case UNION => TypeUnion(schemas(schema)).toString(typeHelpers = this)
      case RECORD => schema.getFullName
      case ENUM => schema.getFullName
      case FIXED => ltc.getType(schema, schema.getFullName)
      case ARRAY => s"List[${schemaToScalaType(schema.getElementType, useLogical)}]"
      case MAP =>
        val valueType = schemaToScalaType(schema.getValueType, useLogical)
        s"Map[String, $valueType]"
      case other => 
        if (useLogical) ltc.getType(schema, simpleTypeToScala(other))
        else simpleTypeToScala(other)
    }
  }

  def simpleTypeToScala(schemaType: Schema.Type): String = {
    schemaType match {
      case Schema.Type.BOOLEAN => "Boolean"
      case Schema.Type.INT => "Int"
      case Schema.Type.LONG => "Long"
      case Schema.Type.FLOAT => "Float"
      case Schema.Type.DOUBLE => "Double"
      case Schema.Type.STRING => "String"
      case Schema.Type.BYTES => "Array[Byte]"
      case Schema.Type.NULL => "scala.Null"
      case other => throw SchemaError(s"Unsupported type: $other")
    }
  }

  def simpleTypeToScalaReceiveType(schemaType: Schema.Type): String = {
    schemaType match {
      case Schema.Type.BOOLEAN => "Boolean"
      case Schema.Type.INT => "Int"
      case Schema.Type.LONG => "Long"
      case Schema.Type.FLOAT => "Float"
      case Schema.Type.DOUBLE => "Double"
      case Schema.Type.STRING => "org.apache.avro.util.Utf8"
      case Schema.Type.BYTES => "java.nio.ByteBuffer"
      case Schema.Type.NULL => "scala.Null"
      case other => throw SchemaError(s"Unsupported type: $other")
    }
  }


  final case class TypeUnion(types: List[Schema]) {
    lazy val noNulls: List[Schema] = types.filterNot(_.getType == NULL)
    lazy val hasNull: Boolean = types.exists(_.getType == NULL)
    def innerTypeStr(typeHelpers: TypeHelpers): String = noNulls.map(typeHelpers.schemaToScalaType(_, useLogical = true)).mkString(" | ")

    def toString(typeHelpers: TypeHelpers): String = if (hasNull) "Option[" + innerTypeStr(typeHelpers) + "]" else innerTypeStr(typeHelpers)
    def toTypeString: String = toString
    def toConstructString(value: String): String = if (hasNull) s"Option($value)" else s"$value"
  }
}