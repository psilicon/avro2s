package avro2s.generator

/**
 * Enum type configuration for generated code.
 * - JavaEnum: Generates standard Java enums (default, compatible with all Avro tooling)
 * - ScalaADT: Generates Scala 2 sealed trait with case objects
 * - Scala3Enum: Generates Scala 3 native enums
 */
sealed trait EnumType

object EnumType {
  case object JavaEnum extends EnumType
  case object ScalaADT extends EnumType
  case object Scala3Enum extends EnumType
}

