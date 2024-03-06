package avro2s.generator.specific.scala2.record

import avro2s.error.Error.SchemaError
import avro2s.generator.logical.LogicalTypes.LogicalTypeConverter
import org.apache.avro.Schema
import org.apache.avro.Schema.Type._

import scala.collection.compat._
import scala.jdk.CollectionConverters._

private[avro2s] class TypeHelpers(ltc: LogicalTypeConverter) {
  import UnionRepresentation._

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

  def unionSchemasToType(schemas: List[Schema]): UnionRepresentation = {
    schemas match {
      case Nil => throw SchemaError("Empty schemas")
      case _ :: Nil => throw SchemaError("Union with only one type")
      case head :: next :: Nil if head.getType == NULL => OptionRepresentation(next)
      case head :: next :: Nil if next.getType == NULL => OptionRepresentation(head)
      case list => CoproductRepresentation(list)
    }
  }

  def schemaToScalaType(schema: Schema, useLogical: Boolean): String = {
    schema.getType match {
      case UNION => unionSchemasToType(schemas(schema)).asString(typeHelpers = this)
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
}

object UnionRepresentation {
  sealed trait UnionRepresentation {
    def asString(typeHelpers: TypeHelpers): String
  }
  
  final case class CoproductRepresentation(types: List[Schema]) extends UnionRepresentation {
    override def asString(typeHelpers: TypeHelpers): String = types.map(t => typeHelpers.schemaToScalaType(t, true)).mkString(" :+: ") + " :+: CNil"
  }

  final case class OptionRepresentation(`type`: Schema) extends UnionRepresentation {
    override def asString(typeHelpers: TypeHelpers): String = s"Option[${typeHelpers.schemaToScalaType(`type`, true)}]"
  }
}