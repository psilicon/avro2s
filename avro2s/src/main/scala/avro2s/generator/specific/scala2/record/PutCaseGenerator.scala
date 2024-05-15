package avro2s.generator.specific.scala2.record

import avro2s.generator.FunctionalPrinter
import avro2s.generator.logical.LogicalTypes.LogicalTypeConverter
import avro2s.generator.specific.scala2.FieldOps._
import avro2s.generator.specific.scala2.record.UnionRepresentation.{CoproductRepresentation, OptionRepresentation, UnionRepresentation}
import org.apache.avro.Schema
import org.apache.avro.Schema.Type
import org.apache.avro.Schema.Type._

import scala.util.Try

/**
 * NOTE: This features code that is not stack safe, based on the expectation that deeply nested schemas are unlikely, and that build tools
 * can adjust the stack size, if needed, when running code generation, without impacting applications. This may be improved in the future.
 */
private[avro2s] class PutCaseGenerator(ltc: LogicalTypeConverter) {
  private val typeHelpers = new TypeHelpers(ltc)

  import typeHelpers._

  def printFieldCase(printer: FunctionalPrinter, index: Int, field: Schema.Field): FunctionalPrinter = {
    field.schema().getType match {
      case UNION =>
        printer
          .add(s"case $index => this.${field.safeName} = {")
          .indent
          .call(matchUnion(_, "value", field.schema()))
          .outdent
          .add("}")
      case BYTES =>
        printer
          .add(s"case $index => this.${field.safeName} = {")
          .indent
          .call(matchBytes(_, "value", field.schema()))
          .outdent
          .add("}")
      case MAP =>
        printer
          .add(s"case $index => this.${field.safeName} = {")
          .indent
          .call(matchMap(_, "value", field.schema()))
          .outdent
          .add("}")
      case ARRAY =>
        printer
          .add(s"case $index => this.${field.safeName} = {")
          .indent
          .call(matchArray(_, "value", field.schema()))
          .outdent
          .add("}")
      case FIXED =>
        val fallback = s"${toStringConverter("value", field.schema())}.asInstanceOf[${schemaToScalaType(field.schema, false)}]"
        val value = s"${toStringConverter("value", field.schema())}"
        printer
          .add(s"case $index => this.${field.safeName} = ${ltc.toTypeWithFallback(field.schema(), value, fallback)}")
      case _ =>
        val value = s"${toStringConverter("value", field.schema())}.asInstanceOf[${schemaToScalaType(field.schema, false)}]"
        printer
          .add(s"case $index => this.${field.safeName} = ${ltc.toType(field.schema(), value)}")
    }
  }

  private def matchUnion(printer: FunctionalPrinter, matchTarget: String, schema: Schema): FunctionalPrinter = {
    val union = unionSchemasToType(schemas(schema))
    printer
      .add(s"$matchTarget match {")
      .indent
      .call(matchUnionInner(_, union))
      .outdent
      .add("}")
  }

  private def matchBytes(printer: FunctionalPrinter, matchTarget: String, schema: Schema): FunctionalPrinter = {
    printer
      .add(s"$matchTarget match {")
      .indent
      .add(s"case buffer: java.nio.ByteBuffer => ${ltc.toTypeWithFallback(schema, "buffer", "val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); array")}")
      .outdent
      .add("}")
  }

  private def matchMap(printer: FunctionalPrinter, matchTarget: String, schema: Schema): FunctionalPrinter = {
    printer
      .add(s"$matchTarget match {")
      .indent
      .add(s"case map: java.util.Map[_,_] => {")
      .indent
      .call(printMapValue(_, schema))
      .outdent
      .add("}")
      .outdent
      .add("}")
  }

  private def matchArray(printer: FunctionalPrinter, matchTarget: String, schema: Schema): FunctionalPrinter = {
    printer
      .add(s"$matchTarget match {")
      .indent
      .add("case array: java.util.List[_] =>")
      .indent
      .add("scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>")
      .indent
      .call(printArrayValue(_, "value", schema.getElementType))
      .outdent
      .add("}).toList")
      .outdent
      .add("}")
      .outdent
  }

  private def printArrayValue(printer: FunctionalPrinter, valueName: String, schema: Schema): FunctionalPrinter = {
    schema.getType match {
      case UNION =>
        printer
          .call(matchUnion(_, valueName, schema))
      case MAP => matchMap(printer, valueName, schema)
      case ARRAY => matchArray(printer, valueName, schema)
      case BYTES =>
        printer
          .add(s"$valueName match {")
          .indent
          .add(s"case buffer: java.nio.ByteBuffer => ${ltc.toTypeWithFallback(schema, "buffer", "val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); array")}")
          .outdent
          .add("}")
      case _ =>
        printer
          .add(ltc.toType(schema, typeCast(valueName, schema)))
    }
  }

  private def printMapValue(functionalPrinter: FunctionalPrinter, schema: Schema): FunctionalPrinter = {
    functionalPrinter
      .add("scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>")
      .indent
      .add("val key = kvp._1.toString")
      .add("val value = kvp._2")
      .add(s"(key, {")
      .indent
      .call(printMapValueInner(_, schema.getValueType))
      .outdent
      .add("})")
      .outdent
      .add("}")
  }

  private def printMapValueInner(printer: FunctionalPrinter, schema: Schema): FunctionalPrinter = {
    schema.getType match {
      case UNION =>
        printer
          .call(matchUnion(_, "value", schema))
      case MAP => matchMap(printer, "value", schema)
      case ARRAY =>
        printer
          .call(matchArray(_, "value", schema))
      case BYTES =>
        printer
          .call(matchBytes(_, "value", schema))
      case _ =>
        printer
          .add(ltc.toType(schema, typeCast("value", schema)))
    }
  }

  private def matchUnionInner(printer: FunctionalPrinter, union: UnionRepresentation): FunctionalPrinter = {
    union match {
      case CoproductRepresentation(types) => printer.add({
        types.map { t =>
          t.getType match {
            case RECORD | ENUM => s"case x: ${t.getFullName} => Coproduct[${union.asString(typeHelpers)}](x)"
            case MAP =>
              new FunctionalPrinter()
                .add(s"case map: java.util.Map[_,_] => Coproduct[${union.asString(typeHelpers)}]{")
                .indent
                .call(printMapValue(_, t))
                .outdent
                .add("}")
                .result()
            case FIXED => s"case x: ${t.getFullName} => Coproduct[${union.asString(typeHelpers)}](${ltc.toType(t, "x")})"
            case BYTES => s"case x: java.nio.ByteBuffer => Coproduct[${union.asString(typeHelpers)}](${ltc.toTypeWithFallback(t, "x", "x.array()")})"
            case ARRAY =>
              new FunctionalPrinter()
                .add(s"case x: java.util.List[_] => Coproduct[${union.asString(typeHelpers)}]({")
                .indent
                .call(printArrayValue(_, "x", t))
                .outdent
                .add("}.toList)")
                .result()
            case _ =>
              val typeName = simpleTypeToScalaReceiveType(t.getType)
              val x = toStringConverter("x", t)
              val `case` = if (t.getType == Type.NULL) "x @ null" else s"x: $typeName"
              s"case ${`case`} => Coproduct[${union.asString(typeHelpers)}](${ltc.toType(t, x)})"
          }
        } :+ "case _ => throw new AvroRuntimeException(\"Invalid value\")"
      }.mkString("\n"))
      case OptionRepresentation(schema) =>
        val nullCasePrinter = printer.add("case null => None")
        schema.getType match {
          case MAP =>
            nullCasePrinter
              .add("case map: java.util.Map[_,_] => Some{")
              .indent
              .call(printMapValue(_, schema))
              .outdent
              .add("}")
          case ARRAY =>
            nullCasePrinter
              .add("case x: java.util.List[_] => Some({")
              .indent
              .call(printArrayValue(_, "x", schema))
              .outdent
              .add("}.toList)")
          case BYTES =>
            nullCasePrinter
              .add(s"case x: java.nio.ByteBuffer => Some(${ltc.toTypeWithFallback(schema, "x", "x.array()")})")
          case RECORD | ENUM =>
            nullCasePrinter
              .add(s"case x: ${schema.getFullName} => Some(x)")
          case FIXED =>
            nullCasePrinter
              .add(s"case x: ${schema.getFullName} => Some(${ltc.toType(schema, "x")})")
          case _ =>
            val x = toStringConverter("x", schema)
            val xCase = Try(s"x: ${simpleTypeToScalaReceiveType(schema.getType)}").getOrElse("x")
            nullCasePrinter
              .add(s"case $xCase => Some(${ltc.toType(schema, x)})")
        }
    }
  }
}
