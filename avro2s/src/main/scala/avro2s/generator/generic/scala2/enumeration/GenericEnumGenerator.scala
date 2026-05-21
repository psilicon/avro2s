package avro2s.generator.generic.scala2.enumeration

import avro2s.generator.{FunctionalPrinter, GeneratedCode}
import org.apache.commons.text.StringEscapeUtils

import scala.jdk.CollectionConverters._

private[avro2s] object GenericEnumGenerator {
  def schemaToScala2Enum(schema: org.apache.avro.Schema, namespace: Option[String]): GeneratedCode = {
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
      .add(s"sealed abstract class $name(val value: String, val ordinal: Int) extends org.apache.avro.generic.GenericEnumSymbol[$name] {")
      .indent
      .add(s"override def getSchema: org.apache.avro.Schema = $name.SCHEMA$$")
      .add(s"override def compareTo(that: $name): Int = this.ordinal.compareTo(that.ordinal)")
      .outdent
      .add("}")
      .newline
      .add(s"object $name {")
      .indent
      .print(enumSymbols.zipWithIndex) { (p, symbolWithIndex) =>
        val (symbol, index) = symbolWithIndex
        p.add(s"""case object $symbol extends $name("$symbol", $index)""")
      }
      .newline
      .add(s"""val SCHEMA$$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse(\"${StringEscapeUtils.escapeJava(schema.toString)}\")""")
      .newline
      .add(s"def fromString(value: String): $name = value match {")
      .indent
      .print(enumSymbols) { (p, symbol) =>
        p.add(s"""case "$symbol" => $symbol""")
      }
      .add(s"""case other => throw new IllegalArgumentException(s"Unknown enum value: $$other")""")
      .outdent
      .add("}")
      .newline
      .add(s"def valueOf(value: String): $name = fromString(value)")
      .newline
      .add(s"val values: Seq[$name] = Seq(${enumSymbols.mkString(", ")})")
      .outdent
      .add("}")

    GeneratedCode(s"${ns.map(_.replace(".", "/") + "/").getOrElse("")}$name.scala", code.result())
  }
}
