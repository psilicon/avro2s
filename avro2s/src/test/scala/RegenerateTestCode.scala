import avro2s.generator.{CodeGenerator, GeneratorConfig}
import avro2s.language.ScalaVersion

object RegenerateTestCode extends App {
  // Regenerate test code for Scala 2.13
  CodeGenerator.generateCode(
    "avro2s/src/test/resources/input/default",
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
    "avro2s/src/test/resources/input/default",
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
}
