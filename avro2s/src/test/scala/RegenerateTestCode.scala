import avro2s.filehelper.FileHelper
import avro2s.generator.{CodeGenerator, EnumType, GeneratorConfig}
import avro2s.language.ScalaVersion

object RegenerateTestCode extends App {
  // large.avsc exists only as a fixture for CodeGeneratorTest's chunked-SCHEMA$ assertions. Its 361
  // fields exceed the JVM's 254-parameter limit, so writing it out as a source file breaks the
  // Scala 2.13 build; it is read in memory from its resource path instead.
  private val excluded = Set("large.avsc")

  private def inputs(directory: String) =
    FileHelper.findAvscFiles(directory).filterNot(f => excluded(f.getName))

  // Regenerate test code for Scala 2.13
  CodeGenerator.generateCode(
    inputs("avro2s/src/test/resources/input/default"),
    "avro2s/src/test/scala-2.13",
    GeneratorConfig(ScalaVersion.Scala_2_13, logicalTypesEnabled = false)
  )

  CodeGenerator.generateCode(
    inputs("avro2s/src/test/resources/input/scala-2.13"),
    "avro2s/src/test/scala-2.13",
    GeneratorConfig(ScalaVersion.Scala_2_13, logicalTypesEnabled = false)
  )

  CodeGenerator.generateCode(
    inputs("avro2s/src/test/resources/input/logical-enabled"),
    "avro2s/src/test/scala-2.13",
    GeneratorConfig(ScalaVersion.Scala_2_13, logicalTypesEnabled = true)
  )
  
  // Regenerate test code for Scala 3
  CodeGenerator.generateCode(
    inputs("avro2s/src/test/resources/input/default"),
    "avro2s/src/test/scala-3",
    GeneratorConfig(ScalaVersion.Scala_3, logicalTypesEnabled = false)
  )

  CodeGenerator.generateCode(
    inputs("avro2s/src/test/resources/input/scala-3"),
    "avro2s/src/test/scala-3",
    GeneratorConfig(ScalaVersion.Scala_3, logicalTypesEnabled = false)
  )

  CodeGenerator.generateCode(
    inputs("avro2s/src/test/resources/input/logical-enabled"),
    "avro2s/src/test/scala-3",
    GeneratorConfig(ScalaVersion.Scala_3, logicalTypesEnabled = true)
  )

  CodeGenerator.generateCode(
    inputs("avro2s/src/test/resources/input/scala-3-enums"),
    "avro2s/src/test/scala-3",
    GeneratorConfig(ScalaVersion.Scala_3, logicalTypesEnabled = false, enumType = EnumType.ScalaEnum)
  )

  CodeGenerator.generateCode(
    inputs("avro2s/src/test/resources/input/scala-2.13-enums"),
    "avro2s/src/test/scala-2.13",
    GeneratorConfig(ScalaVersion.Scala_2_13, logicalTypesEnabled = false, enumType = EnumType.ScalaEnum)
  )
}
