package avro2s.filehelper

import avro2s.parser.FileInputParser
import org.apache.avro.Schema

import java.io.File
import scala.annotation.tailrec

object FileHelper {

  def findAvscFiles(directory: String): List[File] = findFiles(directory, ".avsc")
  def findAvdlFiles(directory: String): List[File] = findFiles(directory, ".avdl")

  def findFiles(directory: String, suffix: String): List[File] = {
    @tailrec
    def loop(filesToCheck: List[File], foundFiles: List[File]): List[File] = {
      filesToCheck match {
        case Nil => foundFiles
        case head :: tail =>
          if (head.isDirectory) {
            loop(head.listFiles().toList ::: tail, foundFiles)
          } else {
            if (head.getName.endsWith(suffix)) {
              loop(tail, head :: foundFiles)
            } else {
              loop(tail, foundFiles)
            }
          }
      }
    }

    val initialDir = new File(directory)
    if (initialDir.exists && initialDir.isDirectory) {
      loop(List(initialDir), Nil)
    } else {
      throw new IllegalArgumentException(s"The provided path '$directory' is not a valid directory")
    }
  }

  def getSchemasFromFiles(files: List[File]): List[Schema] = {
    val fileInputParser = new FileInputParser()
    files.flatMap { file =>
      fileInputParser.getSchemas(file)
    }
  }
}
