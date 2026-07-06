package avro2s.generator.specific

import avro2s.error.Error.ConfigError
import org.apache.avro.Schema

import scala.jdk.CollectionConverters._

private[avro2s] object ScalaEnumSupport {
  def validateSymbols(schema: Schema, members: Set[String]): Unit = {
    val collisions = schema.getEnumSymbols.asScala.filter(members.contains)
    if (collisions.nonEmpty)
      throw ConfigError(s"Enum ${schema.getFullName} has symbols reserved by its Scala companion: ${collisions.mkString(", ")}")
  }

  def wrapExpression(input: String, schema: Schema): String =
    s"(if ($input == null) null else new org.apache.avro.generic.GenericData.EnumSymbol(${schema.getFullName}.SCHEMA$$, $input.toString))"

  def putConversion(input: String, schema: Schema): String =
    s"$input match { case x: ${schema.getFullName} => x; case x => ${schema.getFullName}.valueOf(x.toString) }"
}
