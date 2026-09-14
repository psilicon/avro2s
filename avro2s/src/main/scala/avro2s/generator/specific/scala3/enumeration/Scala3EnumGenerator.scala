package avro2s.generator.specific.scala3.enumeration

import avro2s.generator.specific.{ScalaEnumSupport, SchemaLiteral}
import avro2s.generator.specific.scala3.ReservedWords
import avro2s.generator.{FunctionalPrinter, GeneratedCode, Scaladoc}

import scala.jdk.CollectionConverters._

private[avro2s] object Scala3EnumGenerator {
  def schemaToScala3Enum(schema: org.apache.avro.Schema): GeneratedCode = {
    val name = schema.getName
    val ns = Option(schema.getNamespace).filter(_.nonEmpty).get
    val symbols = schema.getEnumSymbols.asScala.toList
    val enumType = ScalaEnumSupport.internalType(schema)
    val dollar = "$"

    val code = new FunctionalPrinter()
      .add("/** GENERATED CODE */")
      .newline
      .add(s"package $ns.internal {")
      .indent
      .call(Scaladoc.print(_, schema.getDoc))
      .when(symbols.nonEmpty) { p =>
        p.add(s"enum $name(private val symbol$dollar: _root_.java.lang.String) {")
          .indent
          .print(symbols) { (p, symbol) =>
            p.add(s"""case ${caseName(symbol)} extends $enumType("$symbol")""")
          }
          .newline
          .add(s"override def toString: _root_.java.lang.String = symbol$dollar")
          .outdent
          .add("}")
      }
      .when(symbols.isEmpty)(_.add(s"sealed trait $name extends _root_.scala.Product with _root_.scala.Serializable"))
      .newline
      .add(s"object $name {")
      .indent
      .add(s"val SCHEMA$dollar: _root_.org.apache.avro.Schema = ${SchemaLiteral.parseExpression(schema.toString)}")
      .newline
      .call(ScalaEnumSupport.printFromAvroSymbol(_, schema, caseName))
      .when(symbols.isEmpty) { p =>
        p.newline
          .add(s"def values: _root_.scala.Array[$enumType] = _root_.scala.Array.empty[$enumType]")
          .add(s"def valueOf(value: _root_.java.lang.String): $enumType = fromAvroSymbol(value)")
          .add(s"def fromOrdinal(ordinal: _root_.scala.Int): $enumType =")
          .indent
          .add(s"""throw new _root_.java.util.NoSuchElementException("Empty enum ${schema.getFullName} has no ordinal " + ordinal)""")
          .outdent
      }
      .outdent
      .add("}")
      .outdent
      .add("}")
      .newline
      .add(s"package $ns {")
      .indent
      .call(Scaladoc.print(_, schema.getDoc))
      .add(s"type $name = $enumType")
      .call(Scaladoc.print(_, schema.getDoc))
      .add(s"val $name: $enumType.type = $enumType")
      .outdent
      .add("}")

    GeneratedCode(s"${ns.replace(".", "/")}/$name.scala", code.result())
  }

  private def caseName(symbol: String): String =
    ScalaEnumSupport.caseName(symbol, ReservedWords.set, Set("fromOrdinal"))
}
