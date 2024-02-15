package avro2s.generator

import avro2s.generator.specific.SpecificGenerator
import avro2s.language.ScalaVersion
import avro2s.schema.{SchemaInspector, NestedSchemaExtractor, SchemaStore}
import org.apache.avro.Schema

object CodeGenerator {
  def generateCode(
    schema: Schema,
    schemaStore: SchemaStore,
    targetScalaVersion: ScalaVersion): List[GeneratedCode] = {
    
    val topNS: Option[String] = SchemaInspector.getNamespace(schema)
    val flattenedSchemas: List[Schema] = NestedSchemaExtractor.getNestedSchemas(schema, schemaStore)

    flattenedSchemas.reverse.distinct.map(schema => {
      schemaStore.accept(schema)
      val ns = SchemaInspector.getNamespace(schema) orElse topNS
      SpecificGenerator.compile(schema, ns, targetScalaVersion)
    })
  }

}
