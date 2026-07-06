package avro2s.generator.specific.scala3.enumeration

import avro2s.generator.specific.{ScalaEnumSupport, SchemaLiteral}
import avro2s.generator.specific.scala3.ReservedWords
import avro2s.generator.{FunctionalPrinter, GeneratedCode}

import scala.jdk.CollectionConverters._

private[avro2s] object Scala3EnumGenerator {
  def schemaToScala3Enum(schema: org.apache.avro.Schema): GeneratedCode = {
    ScalaEnumSupport.validateSymbols(schema, Set("values", "valueOf", "fromOrdinal"))
    val name = schema.getName
    val ns = Option(schema.getNamespace).filter(_.nonEmpty).get
    val cases = schema.getEnumSymbols.asScala.map(caseName).mkString(", ")
    val dollar = "$"

    val code = new FunctionalPrinter()
      .add("/** GENERATED CODE */")
      .newline
      .add(s"package $ns.internal {")
      .indent
      .add(s"enum $name {")
      .indent
      .add(s"case $cases")
      .outdent
      .add("}")
      .newline
      .add(s"object $name {")
      .indent
      .add(s"val SCHEMA$dollar: org.apache.avro.Schema = ${SchemaLiteral.parseExpression(schema.toString)}")
      .outdent
      .add("}")
      .outdent
      .add("}")
      .newline
      .add(s"package $ns {")
      .indent
      .add(s"type $name = $ns.internal.$name")
      .add(s"val $name: $ns.internal.$name.type = $ns.internal.$name")
      .outdent
      .add("}")

    GeneratedCode(s"${ns.replace(".", "/")}/$name.scala", code.result())
  }

  private def caseName(symbol: String): String =
    if (ReservedWords.set.contains(symbol)) s"`$symbol`" else symbol
}
