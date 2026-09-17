package avro2s.generator.specific

import avro2s.generator.FunctionalPrinter
import org.apache.avro.Schema

import scala.jdk.CollectionConverters._

private[avro2s] object ScalaEnumSupport {
  private val reservedCaseNames = Set(
    "values", "valueOf", "fromAvroSymbol", "toString", "hashCode", "getClass",
    "notify", "notifyAll", "wait", "clone", "finalize", "asInstanceOf", "isInstanceOf", "_"
  )

  def caseName(symbol: String, keywords: Set[String], extraMembers: Set[String]): String =
    // '$' is not legal in an Avro symbol, so this cannot collide with authored names.
    if (reservedCaseNames.contains(symbol) || extraMembers.contains(symbol)) symbol + "$avro"
    else if (keywords.contains(symbol)) s"`$symbol`"
    else symbol

  def internalType(schema: Schema): String = s"_root_.${schema.getNamespace}.internal.${schema.getName}"

  def printFromAvroSymbol(printer: FunctionalPrinter, schema: Schema, caseName: String => String): FunctionalPrinter =
    printer
      .add(s"def fromAvroSymbol(value: _root_.java.lang.String): ${internalType(schema)} = value match {")
      .indent
      .print(schema.getEnumSymbols.asScala.toList) { (p, symbol) =>
        p.add(s"""case "$symbol" => ${internalType(schema)}.${caseName(symbol)}""")
      }
      .add(s"""case other => throw new _root_.org.apache.avro.AvroRuntimeException("No enum symbol " + other + " in ${schema.getFullName}")""")
      .outdent
      .add("}")

  def printAvroSymbolCache(printer: FunctionalPrinter, schema: Schema): FunctionalPrinter = {
    // EnumSymbol is immutable; '$' keeps cache members distinct from authored symbols.
    val symbolType = "_root_.org.apache.avro.generic.GenericData.EnumSymbol"
    val symbols = schema.getEnumSymbols.asScala.toList.zipWithIndex
    printer
      .print(symbols) { case (p, (symbol, index)) =>
        p.add(s"""private val avroSymbol$$$index: $symbolType = new $symbolType(SCHEMA$$, "$symbol")""")
      }
      .when(symbols.nonEmpty)(_.newline)
      .add(s"def toAvroSymbol$$(value: ${internalType(schema)}): $symbolType = {")
      .indent
      .add("if (value == null) null")
      .add("else value.toString match {")
      .indent
      .print(symbols) { case (p, (symbol, index)) =>
        p.add(s"""case "$symbol" => avroSymbol$$$index""")
      }
      .add(s"""case other => throw new _root_.org.apache.avro.AvroRuntimeException("No enum symbol " + other + " in ${schema.getFullName}")""")
      .outdent
      .add("}")
      .outdent
      .add("}")
  }

  def wrapExpression(input: String, schema: Schema): String =
    s"_root_.${schema.getFullName}.toAvroSymbol$$($input)"

  def putConversion(input: String, schema: Schema): String =
    s"$input match { case x: _root_.${schema.getFullName} => x; case x => _root_.${schema.getFullName}.fromAvroSymbol(x.toString) }"
}
