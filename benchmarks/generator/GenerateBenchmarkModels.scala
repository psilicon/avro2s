import avro2s.generator.{CodeGenerator, EnumType, GeneratorConfig}
import avro2s.language.ScalaVersion

/**
 * Generates the benchmark models from the schemas in benchmarks/src/main/resources/avro.
 *
 * The build runs this for the current working tree. scripts/compare-benchmarks.sh also runs
 * this file, unchanged, inside a worktree of another revision to produce the baseline arm, so
 * it must stay free of dependencies on anything but avro2s's own public generator API.
 *
 * Arguments: <resourceRoot> <outputDirectory> <2.13|3> [namespace]
 *
 * A namespace argument rewrites the schemas' namespace before generation, which is what lets
 * a second revision's output be compiled alongside the current one in a single JVM.
 */
object GenerateBenchmarkModels extends App {
  private val modelNamespace = "avro2s.benchmarks.models"

  private val resourceRoot = args(0)
  private val outputDirectory = args(1)
  private val scalaVersion = args(2) match {
    case "2.13" => ScalaVersion.Scala_2_13
    case "3" => ScalaVersion.Scala_3
    case other => sys.error(s"Unsupported target Scala version: $other")
  }
  private val namespace = if (args.length > 3) args(3) else modelNamespace

  // Rewriting the namespace on disk keeps CodeGenerator on its ordinary file-based entry point,
  // so the baseline arm is generated exactly the way a real user's build would generate it.
  private def stage(directory: String): String = {
    val source = new java.io.File(resourceRoot, directory)
    val staged = new java.io.File(outputDirectory, s"schemas/$directory")
    staged.mkdirs()
    source.listFiles().filter(_.getName.endsWith(".avsc")).foreach { file =>
      val json = new String(java.nio.file.Files.readAllBytes(file.toPath), "UTF-8")
      val rewritten = json.replace(s""""$modelNamespace"""", s""""$namespace"""")
      java.nio.file.Files.write(new java.io.File(staged, file.getName).toPath, rewritten.getBytes("UTF-8"))
    }
    staged.getAbsolutePath
  }

  private def generate(directory: String, config: GeneratorConfig): Unit =
    CodeGenerator.generateCode(stage(directory), outputDirectory, config)

  generate("default", GeneratorConfig(scalaVersion, logicalTypesEnabled = false))
  generate("logical", GeneratorConfig(scalaVersion, logicalTypesEnabled = true))
  generate("scala-enums", GeneratorConfig(scalaVersion, logicalTypesEnabled = false, enumType = EnumType.ScalaEnum))
}
