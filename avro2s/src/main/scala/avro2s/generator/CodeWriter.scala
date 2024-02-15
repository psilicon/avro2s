package avro2s.generator

import java.io.{File, FileWriter}
import scala.util.Using

object CodeWriter {
  def writeToDirectory(outDir: String)(generatedCode: List[GeneratedCode]): Unit = {
    generatedCode.foreach { generated =>
      val path = generated.path
      val code = generated.code
      val file = new File(outDir, path)
      file.getParentFile.mkdirs()
      Using(new FileWriter(file)) { writer =>
        writer.write(code)
      }
    }
  }
}
