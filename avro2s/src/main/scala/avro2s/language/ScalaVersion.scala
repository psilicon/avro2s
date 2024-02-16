package avro2s.language

import avro2s.error.Error.ConfigError

sealed abstract class ScalaVersion(val asString: String)

object ScalaVersion {
  case object Scala_2_13 extends ScalaVersion("2.13")
  case object Scala_3 extends ScalaVersion("3")
  
  private val pattern = """^\d+\.\d+$"""
  def fromString(s: String): ScalaVersion = s match {
    case "2.13" => Scala_2_13
    case "3" | "3.X" | "3.x" => Scala_3
    case _ if s.startsWith("3.") && s.matches(pattern) => Scala_3
    case _ if !pattern.matches(s) => throw ConfigError(s"Invalid Scala version: $s")
    case _ => throw ConfigError(s"Unsupported Scala version: $s")
  } 
}
