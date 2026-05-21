package avro2s.generator

sealed trait EnumType

object EnumType {
  case object ScalaADT extends EnumType
  case object Scala3Enum extends EnumType
}
