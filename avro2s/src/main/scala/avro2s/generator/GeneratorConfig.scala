package avro2s.generator

import avro2s.language.ScalaVersion

case class GeneratorConfig(
  targetScalaVersion: ScalaVersion,
  logicalTypesEnabled: Boolean,
  enumType: EnumType = EnumType.JavaEnum,
  customCodersEnabled: Boolean = false,
)
