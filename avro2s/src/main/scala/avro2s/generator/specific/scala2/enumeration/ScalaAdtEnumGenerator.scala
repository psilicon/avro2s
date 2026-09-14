package avro2s.generator.specific.scala2.enumeration

import avro2s.generator.specific.{ScalaEnumSupport, SchemaLiteral}
import avro2s.generator.specific.scala2.ReservedWords
import avro2s.generator.{FunctionalPrinter, GeneratedCode, Scaladoc}

import scala.jdk.CollectionConverters._

private[avro2s] object ScalaAdtEnumGenerator {
  def schemaToScala2Adt(schema: org.apache.avro.Schema): GeneratedCode = {
    val name = schema.getName
    val ns = Option(schema.getNamespace).filter(_.nonEmpty).get
    val symbols = schema.getEnumSymbols.asScala.toList
    val dollar = "$"
    val enumType = ScalaEnumSupport.internalType(schema)
    def caseReference(symbol: String): String = s"$enumType.${caseName(symbol)}"

    val code = new FunctionalPrinter()
      .add("/** GENERATED CODE */")
      .newline
      .add(s"package $ns.internal")
      .newline
      .call(Scaladoc.print(_, schema.getDoc))
      .add(s"sealed trait $name extends _root_.scala.Product with _root_.scala.Serializable")
      .newline
      .add(s"object $name {")
      .indent
      .print(symbols) { (p, s) =>
        p.add(s"""case object ${caseName(s)} extends $enumType { override def toString: _root_.java.lang.String = "$s" }""")
      }
      .newline
      .add(s"val values: _root_.scala.List[$enumType] = _root_.scala.List(${symbols.map(caseReference).mkString(", ")})")
      .newline
      .add(s"val SCHEMA$dollar: _root_.org.apache.avro.Schema = ${SchemaLiteral.parseExpression(schema.toString)}")
      .newline
      .call(ScalaEnumSupport.printFromAvroSymbol(_, schema, caseName))
      .newline
      .add(s"def valueOf(value: _root_.java.lang.String): $enumType = fromAvroSymbol(value)")
      .outdent
      .add("}")

    GeneratedCode(s"${ns.replace(".", "/")}/internal/$name.scala", code.result())
  }

  private def caseName(symbol: String): String =
    ScalaEnumSupport.caseName(symbol, ReservedWords.set, Set.empty)
}
