package avro2s.generator

import avro2s.filehelper.FileHelper
import avro2s.filesorter.AvscFileSorter
import avro2s.generator.specific.SpecificGenerator
import avro2s.language.ScalaVersion
import avro2s.schema.{NestedSchemaExtractor, SchemaInspector, SchemaStore}
import org.apache.avro.Schema

import java.io.File

object CodeGenerator {
  def generateCode(
    inputDirectory: String,
    outputDirectory: String,
    generatorConfig: GeneratorConfig
  ): List[File] = {
    val unsortedFiles = FileHelper.findAvscFiles(inputDirectory)
    val sortedFiles = AvscFileSorter.sortSchemaFiles(unsortedFiles)
    val schemas = FileHelper.getSchemasFromFiles(sortedFiles)
    val generatedCode = generateCode(schemas, generatorConfig)

    CodeWriter.writeToDirectory(outputDirectory)(generatedCode)
  }

  def generateCode(
    schemas: List[Schema],
    generatorConfig: GeneratorConfig
  ): List[GeneratedCode] = {
    val schemaStore = new SchemaStore
    schemas.flatMap { schema =>
      generateCode(schema, schemaStore, generatorConfig)
    }
  }

  def generateCode(
    schema: Schema,
    schemaStore: SchemaStore,
    generatorConfig: GeneratorConfig): List[GeneratedCode] = {
    
    val generator = new SpecificGenerator(generatorConfig)

    val topNS: Option[String] = SchemaInspector.getNamespace(schema)
    val flattenedSchemas: List[Schema] = NestedSchemaExtractor.getNestedSchemas(schema, schemaStore)

    flattenedSchemas.reverse.distinct.map(schema => {
      schemaStore.accept(schema)
      val ns = SchemaInspector.getNamespace(schema) orElse topNS
      generator.compile(schema, ns)
    }).map(gc => gc.copy(code = trimTrailingSpaces(gc.code)))
  }

  private def trimTrailingSpaces(s: String): String = s.split("\n").map(_.replaceAll("\\s*$", "")).mkString("\n")
}
