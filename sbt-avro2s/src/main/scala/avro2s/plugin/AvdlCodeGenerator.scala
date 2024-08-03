package avro2s.plugin


import avro2s.filehelper.FileHelper
import avro2s.generator.{CodeGenerator, GeneratorConfig}
import org.apache.avro.Schema
import org.apache.avro.compiler.idl.Idl
import sbt.io.IO

import java.io.{File, PrintStream}
import scala.jdk.CollectionConverters.*

class AvdlCodeGenerator(avscOutputDir: String, logger: sbt.util.Logger) {

  def generateAvsc(avdlInputPath: String): Unit =
    FileHelper.findAvdlFiles(avdlInputPath).foreach(runSingle(_, saveAvsc))

  private def saveAvsc(avdlInputFile: File, schema: String): Unit = {
    val avscOutputFileName = avdlInputFile.getName.replace(".avdl", ".avsc")
    val avscOutputFile     = new File(avscOutputDir, avscOutputFileName)
    val ps                 = new PrintStream(avscOutputFile)
    ps.println(schema)
    ps.close()

    logger.info(s"[avro2s] Compiling Avro IDL $avdlInputFile")
  }

  // Can be removed if SBT ever migrates to Scala 2.13+
  implicit class WithMaxOption[A: Ordering, B](self: Iterable[A]) {
    def maxOptionBy(f: A => B)(implicit cmp: Ordering[B]) = if (self.isEmpty) None else Some(self.maxBy(f))
  }

  private def runSingle(
                         avdlFile: File,
                         op: (File, String) => Unit,
                       ): Unit = {
    val parser   = new Idl(avdlFile)
    val protocol = parser.CompilationUnit

    // Can be tested by duplicating a variable comment so there are two.
    parser.getWarningsAfterParsing.forEach(warnings => warnings.split("\n").foreach(w => logger.warn(s"[avro2s] Parser Warning: $w")))

    protocol
      .getTypes
      .asScala
      .map((sch: Schema) => sch.toString(true))
      .maxOptionBy(_.length)
      .foreach((schema: String) => op(avdlFile, schema))

    parser.close()
  }
}

object AvdlCodeGenerator {
  def generateCode(
                    inputDirectory: String,
                    avscDirectory: String,
                    outputDirectory: String,
                    generatorConfig: GeneratorConfig,
                    logger: sbt.util.Logger,
                  ): List[File] = {
    IO.createDirectory(new File(avscDirectory))
    new AvdlCodeGenerator(
      avscDirectory,
      logger,
    ).generateAvsc(inputDirectory)

    CodeGenerator.generateCode(
      avscDirectory,
      outputDirectory,
      generatorConfig,
    )
  }
}