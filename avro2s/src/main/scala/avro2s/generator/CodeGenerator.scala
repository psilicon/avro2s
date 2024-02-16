package avro2s.generator

import avro2s.filehelper.FileHelper
import avro2s.filesorter.AvscFileSorter
import avro2s.generator.specific.SpecificGenerator
import avro2s.language.ScalaVersion
import avro2s.schema.{NestedSchemaExtractor, SchemaInspector, SchemaStore}
import org.apache.avro.Schema

object CodeGenerator {
  
  def generateCode(
    inputDirectory: String,
    outputDirectory: String,
    targetScalaVersion: ScalaVersion
  ): Unit = {
    val unsortedFiles = FileHelper.findAvscFiles(inputDirectory)
    val sortedFiles = AvscFileSorter.sortSchemaFiles(unsortedFiles)
    val schemas = FileHelper.getSchemasFromFiles(sortedFiles)
    val generatedCode = generateCode(schemas, targetScalaVersion)
    
    CodeWriter.writeToDirectory(outputDirectory)(generatedCode)
  }
  
  def generateCode(
    schemas: List[Schema],
    targetScalaVersion: ScalaVersion
  ): List[GeneratedCode] = {
    val schemaStore = new SchemaStore
    schemas.flatMap { schema =>
      generateCode(schema, schemaStore, targetScalaVersion)
    }
  }
  
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
