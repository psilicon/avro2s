package avro2s.generator

import avro2s.error.Error.ConfigError

sealed trait EnumType

object EnumType {
  case object JavaEnum extends EnumType
  case object ScalaEnum extends EnumType

  def fromString(value: String): EnumType = value match {
    case "java" => JavaEnum
    case "scala" => ScalaEnum
    case other => throw ConfigError(s"Invalid avro2s enum type: $other (expected java or scala)")
  }
}
