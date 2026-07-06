package avro2s.generator

import avro2s.filehelper.FileHelper
import avro2s.filesorter.AvscFileSorter
import avro2s.generator.specific.SpecificGenerator
import avro2s.generator.specific.scala2.enumeration.PackageObjectGenerator
import avro2s.language.ScalaVersion
import avro2s.schema.{NestedSchemaExtractor, SchemaInspector, SchemaStore}
import org.apache.avro.Schema

import java.io.File

object CodeGenerator {
  def generateCode(
    inputDirectory: String,
    outputDirectory: String,
    generatorConfig: GeneratorConfig
  ): List[File] =
    generateCode(FileHelper.findAvscFiles(inputDirectory), outputDirectory, generatorConfig)

  def generateCode(
    inputFiles: List[File],
    outputDirectory: String,
    generatorConfig: GeneratorConfig
  ): List[File] = {
    val sortedFiles = AvscFileSorter.sortSchemaFiles(inputFiles.distinct)
    val schemas = FileHelper.getSchemasFromFiles(sortedFiles)
    val generatedCode = generateCode(schemas, generatorConfig)

    CodeWriter.writeToDirectory(outputDirectory)(generatedCode)
  }

  def generateCode(
    schemas: List[Schema],
    generatorConfig: GeneratorConfig
  ): List[GeneratedCode] = {
    val schemaStore = new SchemaStore
    val generated = schemas.flatMap { schema =>
      compileSchema(schema, schemaStore, generatorConfig)
    }
    generated ::: packageObjects(schemaStore, generatorConfig)
  }

  def generateCode(
    schema: Schema,
    schemaStore: SchemaStore,
    generatorConfig: GeneratorConfig): List[GeneratedCode] = {
    val generated = compileSchema(schema, schemaStore, generatorConfig)
    generated ::: packageObjects(schemaStore, generatorConfig)
  }

  private def packageObjects(schemaStore: SchemaStore, config: GeneratorConfig): List[GeneratedCode] =
    if (config.enumType != EnumType.ScalaEnum || config.targetScalaVersion != ScalaVersion.Scala_2_13) Nil
    else schemaStore.schemas.values.toList.filter(_.getType == Schema.Type.ENUM)
      .groupBy(_.getNamespace).toList.sortBy(_._1).map { case (namespace, enums) =>
        PackageObjectGenerator.forNamespace(namespace, enums)
      }

  private def compileSchema(
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
