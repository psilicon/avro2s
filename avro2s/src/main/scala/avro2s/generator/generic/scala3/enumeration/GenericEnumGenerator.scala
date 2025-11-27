package avro2s.generator.generic.scala3.enumeration

import avro2s.generator.{FunctionalPrinter, GeneratedCode}
import org.apache.commons.text.StringEscapeUtils

import scala.jdk.CollectionConverters._

private[avro2s] object GenericEnumGenerator {
  def schemaToScala3Enum(schema: org.apache.avro.Schema, namespace: Option[String]): GeneratedCode = {
    val name = schema.getName
    val enumSymbols = schema.getEnumSymbols.asScala
    val ns = Option(schema.getNamespace).orElse(namespace)
    val nsString = ns.getOrElse("")

    val printer = new FunctionalPrinter()

    val code = printer
      .add("/** GENERATED CODE */")
      .newline
      .when(ns.isDefined)(_.add(s"package $nsString").newline)
      .newline
      .add(s"enum $name extends org.apache.avro.generic.GenericEnumSymbol[$name] {")
      .indent
      .add(s"case ${enumSymbols.mkString(", ")}")
      .newline
      .add(s"override def getSchema: org.apache.avro.Schema = $name.SCHEMA$$")
      .add(s"override def compareTo(that: $name): Int = this.ordinal.compareTo(that.ordinal)")
      .outdent
      .add("}")
      .newline
      .add(s"object $name {")
      .indent
      .add(s"""val SCHEMA$$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse(\"${StringEscapeUtils.escapeJava(schema.toString)}\")""")
      .newline
      .add(s"def fromString(value: String): $name = valueOf(value)")
      .outdent
      .add("}")

    GeneratedCode(s"${ns.map(_.replace(".", "/") + "/").getOrElse("")}$name.scala", code.result())
  }
}

