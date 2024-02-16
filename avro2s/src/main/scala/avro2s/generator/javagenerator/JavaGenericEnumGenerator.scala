package avro2s.generator.javagenerator

import avro2s.generator.{FunctionalPrinter, GeneratedCode}
import org.apache.commons.text.StringEscapeUtils

import scala.collection.compat._
import scala.jdk.CollectionConverters._

private[avro2s] object JavaGenericEnumGenerator {
  def schemaToJavaEnum(schema: org.apache.avro.Schema, namespace: Option[String]): GeneratedCode = {
    val name = schema.getName
    val enumSymbols = schema.getEnumSymbols.asScala
    val ns = Option(schema.getNamespace).orElse(namespace)
    val nsString = ns.getOrElse("")

    val printer = new FunctionalPrinter()

    val code = printer
      .add("/** GENERATED CODE */")
      .newline
      .when(ns.isDefined)(_.add(s"package $nsString;"))
      .newline
      .add(s"public enum $name implements org.apache.avro.generic.GenericEnumSymbol<$name> {")
      .indent
      .add(enumSymbols.mkString(", ") + ";")
      .newline
      .add(s"""public static final org.apache.avro.Schema SCHEMA$$ = new org.apache.avro.Schema.Parser().parse(\"${StringEscapeUtils.escapeJava(schema.toString)}\");""")
      .add(s"public static org.apache.avro.Schema getClassSchema() { return SCHEMA$$; }")
      .newline
      .add(s"@Override")
      .add(s"public org.apache.avro.Schema getSchema() { return SCHEMA$$; }")
      .outdent
      .add("}")

    GeneratedCode(s"${ns.map(_.replace(".", "/") + "/").getOrElse("") + name}.java", code.result())
  }
}
