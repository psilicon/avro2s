package avro2s.schema

/*
 * This code is from the avrohugger project - https://github.com/julianpeeters/avrohugger
 * Modifications:
 *  - package name
 *  - comment removal
 *  - other minor changes
 */

import org.apache.avro.Schema
import org.apache.avro.Schema.Type._

import scala.jdk.CollectionConverters._

private[avro2s] object NestedSchemaExtractor {
  def getNestedSchemas(
    schema: Schema,
    schemaStore: SchemaStore): List[Schema] = {
    def extract(
      schema: Schema,
      fieldPath: List[String] = List.empty): List[Schema] = {

      schema.getType match {
        case RECORD =>
          val fields: List[Schema.Field] = schema.getFields.asScala.toList
          val fieldSchemas: List[Schema] = fields.map(field => field.schema)
          def flattenSchema(fieldSchema: Schema): List[Schema] = {
            fieldSchema.getType match {
              case ARRAY => flattenSchema(fieldSchema.getElementType)
              case MAP => flattenSchema(fieldSchema.getValueType)
              case RECORD =>
                if (schemaStore.schemas.contains(fieldSchema.getFullName)) List()
                else if (fieldPath.contains(fieldSchema.getFullName)) List()
                else fieldSchema :: extract(fieldSchema, fieldSchema.getFullName :: fieldPath)
              case UNION => fieldSchema.getTypes.asScala.toList.flatMap(x => flattenSchema(x))
              case ENUM =>
                if (schemaStore.schemas.contains(fieldSchema.getFullName)) List()
                else List(fieldSchema)
              case FIXED =>
                if (schemaStore.schemas.contains(fieldSchema.getFullName)) List()
                else List(fieldSchema)
              case _ => List(fieldSchema)
            }
          }
          val flatSchemas = fieldSchemas.flatMap(fieldSchema => flattenSchema(fieldSchema))
          def topLevelTypes(schema: Schema) = {
            schema.getType == RECORD | schema.getType == ENUM | schema.getType == FIXED
          }
          val nestedTopLevelSchemas = flatSchemas.filter(topLevelTypes)
          nestedTopLevelSchemas
        case ENUM => List(schema)
        case FIXED => List(schema)
        case _ => Nil
      } 
    }

    schema :: extract(schema)
  }
}

