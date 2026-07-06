package avro2s.plugin

import avro2s.filehelper.FileHelper
import avro2s.generator.{CodeGenerator, EnumType, GeneratorConfig}
import sbt.Keys.*
import sbt.internal.util.ManagedLogger
import sbt.*

import java.io.File

object Avro2sPlugin extends AutoPlugin {

  object autoImport {
    // sbt tasks:
    lazy val avro2sGenerate         = taskKey[Seq[File]]("Generate Scala sources from avro files")

    // sbt settings
    lazy val avro2sSchemaSource    = settingKey[File]("Avro schema directory for Scala code generation")
    lazy val avro2sGeneratedScalaTarget = settingKey[File]("Scala source directory for compiled avro")
    lazy val avro2sGeneratedAvscTarget  = settingKey[File]("Target for storing 'avsc' files generated from avro2sSchemaSource 'avdl' files")
    lazy val avro2sLogicalTypesEnabled = settingKey[Boolean]("Whether to enable avro2s logical types")
    lazy val avro2sEnumType = settingKey[String]("Enum representation: java (default) or scala (native Scala enums)")

    lazy val defaultSettings: Seq[Setting[?]] = Seq(
      avro2sSchemaSource := sourceDirectory.value / "avro",
      avro2sGeneratedAvscTarget := target.value / "avro2s" / "generated" / "avsc",
      avro2sGeneratedScalaTarget := (Compile / sourceManaged).value / "compiled_avro",
      avro2sLogicalTypesEnabled := true,
      avro2sEnumType := "java"
    )
  }

  import autoImport._
  override def requires = plugins.JvmPlugin
  override def trigger = allRequirements

  lazy val baseSettings = defaultSettings ++ Seq(
    avro2sGenerate := generateAvro2s.value
  )

  override lazy val projectSettings: Seq[Def.Setting[_]] =
    inConfig(Compile)(baseSettings) ++
      inConfig(Test)(baseSettings)

  private val logger: Def.Initialize[Task[ManagedLogger]] = Def.task(streams.value.log)

  private val generateAvro2s: Def.Initialize[Task[Seq[File]]] = Def.task {
    val log = logger.value

    val scalaVersionValue = avro2s.language.ScalaVersion.fromString(scalaBinaryVersion.value)

    val generatorConfig  = GeneratorConfig(
      scalaVersionValue,
      logicalTypesEnabled = avro2sLogicalTypesEnabled.value,
      enumType = EnumType.fromString(avro2sEnumType.value),
    )

    val convertedFiles = AvdlCodeGenerator.generateAvsc(
      avro2sSchemaSource.value.getPath,
      avro2sGeneratedAvscTarget.value.getPath,
      log,
    )

    CodeGenerator.generateCode(
      convertedFiles ::: FileHelper.findAvscFiles(avro2sSchemaSource.value.getPath),
      avro2sGeneratedScalaTarget.value.getPath,
      generatorConfig,
    )
  }
}
