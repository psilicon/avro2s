package avro2s.parser

/*
 * This code is from the avrohugger project - https://github.com/julianpeeters/avrohugger
 * Modifications:
 *  - package name
 *  - significant reimplementation/simplification
 *  - removal of support for non .avsc file types
 */

import org.apache.avro.{Schema, SchemaParseException}
import org.apache.avro.Schema.Parser
import org.apache.avro.Schema.Type.{ENUM, FIXED, RECORD, UNION}

import java.io.File
import scala.jdk.CollectionConverters._
import scala.util.Try

class FileInputParser {

  val schemaParser = new Parser()

  def getSchemas(
    file: File,
    parser: Parser = schemaParser): List[Schema] = {
    def unUnion(schema: Schema): List[Schema] = {
      schema.getType match {
        case UNION => schema.getTypes.asScala.toList
        case RECORD => List(schema)
        case ENUM => List(schema)
        case FIXED => List(schema)
        case _ => sys.error("""Neither a record, enum nor a union of either.
                              |Nothing to map to a definition.""".trim.stripMargin)
      }
    }

    def copySchemas(tempParser: Parser, parser: Parser): Unit = {
      val tempKeys = tempParser.getTypes.keySet().asScala
      val keys = parser.getTypes.keySet().asScala
      val commonElements = tempKeys.intersect(keys)
      val nonEqualElements = commonElements.filter { element =>
        parser.getTypes.get(element) != tempParser.getTypes.get(element)
      }
      if (nonEqualElements.nonEmpty) {
        sys.error(s"Can't redefine:  ${nonEqualElements.mkString(",")} in $file")
      } else {
        if (commonElements.isEmpty) {
          val _ = parser.addTypes(tempParser.getTypes)
        } else {
          val missingTypes = tempParser.getTypes.keySet().asScala.diff(parser.getTypes.keySet().asScala)
          val _ = parser.addTypes(missingTypes.map { t =>
            t -> tempParser.getTypes.get(t)
          }.toMap.asJava)
        }
      }
    }

    def mightBeRecoverable(e: SchemaParseException): Boolean = {
      val msg = e.getMessage
      msg.contains("Undefined name:") || msg.contains("is not a defined name")
    }

    def tryParse(inFile: File, parser: Schema.Parser): List[Schema] = {
      val tempParser = new Parser()
      val parsed = Try(tempParser.parse(inFile)).map(schema => {
        copySchemas(tempParser, parser)
        schema
      }).recoverWith { case e: SchemaParseException if mightBeRecoverable(e) =>
        Try(parser.parse(inFile))
      }
      unUnion(parsed.get)
    }

    val schema: List[Schema] = {

      file.getName.split("\\.").last match {
        case "avsc" => tryParse(file, parser)
        case _ => throw new Exception("""File must end in ".avsc"""".trim.stripMargin)
      }
    }

    schema
  }
}