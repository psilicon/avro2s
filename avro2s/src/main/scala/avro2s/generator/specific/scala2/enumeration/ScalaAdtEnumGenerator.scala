package avro2s.generator.specific.scala2.enumeration

import avro2s.generator.specific.{ScalaEnumSupport, SchemaLiteral}
import avro2s.generator.specific.scala2.ReservedWords
import avro2s.generator.{FunctionalPrinter, GeneratedCode}

import scala.jdk.CollectionConverters._

private[avro2s] object ScalaAdtEnumGenerator {
  def schemaToScala2Adt(schema: org.apache.avro.Schema): GeneratedCode = {
    ScalaEnumSupport.validateSymbols(schema, Set("values", "valueOf"))
    val name = schema.getName
    val ns = Option(schema.getNamespace).filter(_.nonEmpty).get
    val symbols = schema.getEnumSymbols.asScala.toList
    val dollar = "$"
    val enumType = s"_root_.$ns.internal.$name"
    def caseReference(symbol: String): String = s"$enumType.${caseName(symbol)}"

    val code = new FunctionalPrinter()
      .add("/** GENERATED CODE */")
      .newline
      .add(s"package $ns.internal")
      .newline
      .add(s"sealed trait $name extends _root_.scala.Product with _root_.scala.Serializable")
      .newline
      .add(s"object $name {")
      .indent
      .print(symbols) { (p, s) => p.add(s"case object ${caseName(s)} extends $name") }
      .newline
      .add(s"val values: _root_.scala.List[$enumType] = _root_.scala.List(${symbols.map(caseReference).mkString(", ")})")
      .newline
      .add(s"val SCHEMA$dollar: org.apache.avro.Schema = ${SchemaLiteral.parseExpression(schema.toString)}")
      .newline
      .add(s"def valueOf(value: _root_.java.lang.String): $enumType = value match {")
      .indent
      .print(symbols) { (p, s) => p.add(s"""case "$s" => ${caseReference(s)}""") }
      .add(s"""case other => throw new org.apache.avro.AvroRuntimeException("No enum symbol " + other + " in $ns.$name")""")
      .outdent
      .add("}")
      .outdent
      .add("}")

    GeneratedCode(s"${ns.replace(".", "/")}/internal/$name.scala", code.result())
  }

  private def caseName(symbol: String): String =
    if (ReservedWords.set.contains(symbol)) s"`$symbol`" else symbol
}
