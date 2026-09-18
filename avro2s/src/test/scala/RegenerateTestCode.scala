import avro2s.generator.{CodeGenerator, EnumType, GeneratorConfig}
import avro2s.filehelper.FileHelper
import avro2s.language.ScalaVersion

object RegenerateTestCode extends App {
  // The 360-field large schema tests source generation/schema literal splitting only;
  // its constructor exceeds Scala 2's JVM parameter limit and is not a compiled fixture.
  val defaultSchemas = FileHelper.findAvscFiles("avro2s/src/test/resources/input/default")
    .filterNot(_.getParentFile.getName == "large")

  // Regenerate test code for Scala 2.13
  CodeGenerator.generateCode(
    defaultSchemas,
    "avro2s/src/test/scala-2.13",
    GeneratorConfig(ScalaVersion.Scala_2_13, logicalTypesEnabled = false)
  )

  CodeGenerator.generateCode(
    "avro2s/src/test/resources/input/scala-2.13",
    "avro2s/src/test/scala-2.13",
    GeneratorConfig(ScalaVersion.Scala_2_13, logicalTypesEnabled = false)
  )

  CodeGenerator.generateCode(
    "avro2s/src/test/resources/input/logical-enabled",
    "avro2s/src/test/scala-2.13",
    GeneratorConfig(ScalaVersion.Scala_2_13, logicalTypesEnabled = true)
  )
  
  // Regenerate test code for Scala 3
  CodeGenerator.generateCode(
    defaultSchemas,
    "avro2s/src/test/scala-3",
    GeneratorConfig(ScalaVersion.Scala_3, logicalTypesEnabled = false)
  )

  CodeGenerator.generateCode(
    "avro2s/src/test/resources/input/scala-3",
    "avro2s/src/test/scala-3",
    GeneratorConfig(ScalaVersion.Scala_3, logicalTypesEnabled = false)
  )

  CodeGenerator.generateCode(
    "avro2s/src/test/resources/input/logical-enabled",
    "avro2s/src/test/scala-3",
    GeneratorConfig(ScalaVersion.Scala_3, logicalTypesEnabled = true)
  )

  CodeGenerator.generateCode(
    "avro2s/src/test/resources/input/scala-3-enums",
    "avro2s/src/test/scala-3",
    GeneratorConfig(ScalaVersion.Scala_3, logicalTypesEnabled = false, enumType = EnumType.ScalaEnum)
  )

  CodeGenerator.generateCode(
    "avro2s/src/test/resources/input/scala-2.13-enums",
    "avro2s/src/test/scala-2.13",
    GeneratorConfig(ScalaVersion.Scala_2_13, logicalTypesEnabled = false, enumType = EnumType.ScalaEnum)
  )
}
