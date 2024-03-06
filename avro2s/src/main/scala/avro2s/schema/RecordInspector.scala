package avro2s.schema

import avro2s.error.Error.SchemaError
import org.apache.avro.{LogicalType, Schema}

import scala.annotation.tailrec
import scala.collection.compat._
import scala.jdk.CollectionConverters._

private[avro2s] object RecordInspector {
  import Schema.Type._
  
  def containsType(schema: Schema, schemaType: Schema.Type): Boolean = {
    if (schema.getType != RECORD) throw SchemaError(s"Schema must be of type RECORD, but was ${schema.getType}")

    @tailrec
    def containsType(schemas: List[Schema], schemaType: Schema.Type): Boolean = {
      schemas.headOption match {
        case Some(schema) =>
          schema.getType match {
            case `schemaType` => true
            case UNION =>
              containsType(schema.getTypes.asScala.toList ++ schemas.tail, schemaType)
            case ARRAY =>
              schema.getElementType.getType == schemaType || containsType(schemas.tail, schemaType)
            case MAP =>
              schema.getValueType.getType == schemaType || containsType(schemas.tail, schemaType)
            case _ =>
              containsType(schemas.tail, schemaType)
          }
        case None => false
      }
    }

    containsType(schema.getFields.asScala.toList.map(_.schema()), schemaType)
  }

  def containsLogicalType(schema: Schema, logicalType: Class[_ <: LogicalType]): Boolean = {
    if (schema.getType != RECORD) throw new SchemaError(s"Schema must be of type RECORD, but was ${schema.getType}")

    @tailrec
    def containsLogicalType(schemas: List[Schema], logicalType: Class[_ <: LogicalType]): Boolean = {
      schemas.headOption match {
        case Some(schema) =>
          schema.getLogicalType match {
            case lt if logicalType.isInstance(lt) => true
            case _ =>
              schema.getType match {
                case UNION =>
                  containsLogicalType(schema.getTypes.asScala.toList ++ schemas.tail, logicalType)
                case ARRAY =>
                  containsLogicalType(schema.getElementType :: schemas.tail, logicalType)
                case MAP =>
                  containsLogicalType(schema.getValueType :: schemas.tail, logicalType)
                case RECORD =>
                  containsLogicalType(schema.getFields.asScala.toList.map(_.schema()) ++ schemas.tail, logicalType)
                case _ =>
                  containsLogicalType(schemas.tail, logicalType)
              }
          }
        case None => false
      }
    }

    containsLogicalType(List(schema), logicalType)
  }

  def containsNonOptionUnion(schema: Schema): Boolean = {
    if (schema.getType != RECORD) throw SchemaError(s"Schema must be of type RECORD, but was ${schema.getType}")

    @tailrec
    def containsNonOptionUnion(schemas: List[Schema]): Boolean = {
      schemas.headOption match {
        case Some(schema) =>
          schema.getType match {
            case UNION =>
              (schema.getTypes.size() != 2 || !schema.getTypes.asScala.map(_.getType).contains(NULL)) || containsNonOptionUnion(schema.getTypes.asScala.toList ++ schemas.tail)
            case ARRAY =>
              containsNonOptionUnion(schema.getElementType +: schemas.tail)
            case MAP =>
              containsNonOptionUnion(schema.getValueType +: schemas.tail)
            case _ =>
              containsNonOptionUnion(schemas.tail)
          }
        case None => false
      }
    }

    containsNonOptionUnion(schema.getFields.asScala.toList.map(_.schema()))
  }
}
