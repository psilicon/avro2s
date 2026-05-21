package avro2s.generator

import avro2s.filehelper.FileHelper
import avro2s.filesorter.AvscFileSorter
import avro2s.generator.specific.{ScalaSpecificDataGenerator, SpecificGenerator}
import avro2s.schema.{NestedSchemaExtractor, SchemaInspector, SchemaStore}
import org.apache.avro.Schema
import org.apache.avro.Schema.Type.ENUM

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
    val perSchema = schemas.flatMap { schema =>
      generateCode(schema, schemaStore, generatorConfig)
    }

    if (generatorConfig.enumType.isEmpty) perSchema
    else {
      val enumSchemas = collectEnumSchemas(schemas)
      if (enumSchemas.isEmpty) perSchema
      else {
        val raw = ScalaSpecificDataGenerator.generate(enumSchemas)
        perSchema :+ raw.copy(code = trimTrailingSpaces(raw.code))
      }
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

  private def collectEnumSchemas(schemas: List[Schema]): List[Schema] = {
    val store = new SchemaStore
    schemas.flatMap { schema =>
      NestedSchemaExtractor.getNestedSchemas(schema, store)
    }.distinct.filter(_.getType == ENUM)
  }

  private def trimTrailingSpaces(s: String): String = s.split("\n").map(_.replaceAll("\\s*$", "")).mkString("\n")
}
