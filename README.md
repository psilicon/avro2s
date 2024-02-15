# Avro2s

Avro2s (Avro to Scala) is an avro schema to scala case class converter. It generates case classes that extend Avro's Java types, such as SpecificRecordBase, SpecificFixed, GenericEnumSymbol, etc. This ensures compatibility with community tooling, including [Confluent Schema Registry](https://github.com/confluentinc/schema-registry).

Avro2s is essentially a rewrite of [avrohugger](https://github.com/julianpeeters/avrohugger). The motivations for the rewrite include:
 - Enhanced support for Union types.
 - Improved maintainability by removing the use of and dependency on [treehugger](https://github.com/eed3si9n/treehugger), which is no longer actively maintained.
 - Laying the groundwork for Scala 3 support (Scala 3 support is yet to implemented).

#### Features:
 - Supports Scala 2.13.
 - Compatibility with all Avro types.

#### Usage:
```scala
  val inputDir = "input"
  val outputDir = "output"
  val schemaStore = new SchemaStore()
  
  val unsortedFiles = getFilesInDirectory(inputDir)
  val sortedFiles = AvscFileSorter.sortSchemaFiles(unsortedFiles)
  val schemas = getSchemasFromFiles(sortedFiles)
  val generatedCode = schemas.flatMap { schema =>
    CodeGenerator.generateCode(schema, schemaStore, ScalaVersion.Scala_2_13)
  }
  
  CodeWriter.writeToDirectory(outputDir)(generatedCode)
  
  private def getFilesInDirectory(dir: String): List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

  private def getSchemasFromFiles(files: List[File]): List[Schema] = {
    val fileInputParser = new FileInputParser()
    files.flatMap { file =>
      fileInputParser.getSchemas(file)
    }
  }
```

#### Roadmap:
 - Simplify usage.
 - Logical Types.
 - SBT plugin.
 - Scala 3 support.

#### Acknowledgments:
 - Thank you to everyone who contributed to [avrohugger](https://github.com/julianpeeters/avrohugger), upon which this code is based.
 - [ScalaPB](https://github.com/scalapb/ScalaPB), for inspiration on streamlining the code generation process, particularly for the `FunctionalPrinter` class.