package avro2s.generator.specific.scala3.record

import avro2s.generator.FunctionalPrinter
import avro2s.generator.logical.LogicalTypes.LogicalTypeConverter
import avro2s.generator.specific.scala3.FieldOps._
import org.apache.avro.Schema
import org.apache.avro.Schema.Type
import org.apache.avro.Schema.Type._

import scala.util.Try

/**
 * NOTE: This features code that is not stack safe, based on the expectation that deeply nested schemas are unlikely, and that build tools
 * can adjust the stack size, if needed, when running code generation, without impacting applications. This may be improved in the future.
 */
private[avro2s] class PutCaseGenerator(ltc: LogicalTypeConverter) {
  val typeHelpers = new TypeHelpers(ltc)

  import typeHelpers._
  import typeHelpers.UnionRepresentation._

  def printFieldCase(printer: FunctionalPrinter, index: Int, field: Schema.Field): FunctionalPrinter = {
    printer
      .add(s"case $index => this.${field.safeName} = {")
      .indent
      .call { printer =>
        field.schema().getType match {
          case UNION =>
            printer.call(asUnion(_, "value", field.schema()))
          case BYTES =>
            printer.call(asBytes(_, "value", field.schema()))
          case MAP =>
            printer.call(asMap(_, "value", field.schema()))
          case ARRAY =>
            printer.call(asArray(_, "value", field.schema()))
          case FIXED =>
            printer.call(asFixed(_, "value", field.schema()))
          case _ =>
            printer.call(asDefault(_, "value", field.schema()))
        }
      }
      .outdent
      .add("}")
  }

  private def asUnion(printer: FunctionalPrinter, input: String, schema: Schema): FunctionalPrinter = {
    val union = unionSchemasToType(schemas(schema))
    printer
      .add(s"$input match {")
      .indent
      .call(matchUnionType(_, union))
      .outdent
      .add("}")
  }

  private def asBytes(printer: FunctionalPrinter, input: String, schema: Schema): FunctionalPrinter = {
    printer
      .add(s"val buffer = $input.asInstanceOf[java.nio.ByteBuffer]")
      .add(s"${ltc.toTypeWithFallback(schema, "buffer", "val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); array")}")
  }

  private def asMap(printer: FunctionalPrinter, input: String, schema: Schema): FunctionalPrinter = {
    printer
      .add(s"val map = $input.asInstanceOf[java.util.Map[?,?]]")
      .call(assignMap(_, "map", schema))
  }

  private def asArray(printer: FunctionalPrinter, input: String, schema: Schema): FunctionalPrinter = {
    printer
      .add(s"val array = $input.asInstanceOf[java.util.List[?]]")
      .call(assignArray(_, "array", schema))
  }

  private def asFixed(printer: FunctionalPrinter, input: String, schema: Schema): FunctionalPrinter = {
    val fallback = s"${toStringConverter(input, schema)}.asInstanceOf[${schemaToScalaType(schema, false)}]"
    val value = s"${toStringConverter("value", schema)}"
    printer
      .add(s"${ltc.toTypeWithFallback(schema, value, fallback)}")
  }

  private def asDefault(printer: FunctionalPrinter, input: String, schema: Schema): FunctionalPrinter = {
    val value = s"${toStringConverter(input, schema)}.asInstanceOf[${schemaToScalaType(schema, false)}]"
    printer
      .add(s"${ltc.toType(schema, value)}")
  }

  private def assignArray(printer: FunctionalPrinter, input: String, schema: Schema): FunctionalPrinter = {
    printer
      .add(s"scala.jdk.CollectionConverters.IteratorHasAsScala($input.iterator).asScala.map({ value =>")
      .indent
      .call(assignArrayInner(_, "value", schema.getElementType))
      .outdent
      .add("}).toList")
  }

  private def assignArrayInner(printer: FunctionalPrinter, input: String, schema: Schema): FunctionalPrinter = {
    schema.getType match {
      case UNION =>
        printer
          .call(asUnion(_, input, schema))
      case MAP => asMap(printer, input, schema)
      case ARRAY => asArray(printer, input, schema)
      case BYTES =>
        printer
          .call(asBytes(_, input, schema))
      case _ =>
        printer
          .add(ltc.toType(schema, typeCast(input, schema)))
    }
  }

  private def matchUnionType(printer: FunctionalPrinter, union: UnionRepresentation): FunctionalPrinter = {
    union match {
      case TypeUnionRepresentation(types) => printer.add({
        types.map { t =>
          t.getType match {
            case RECORD | ENUM => s"case x: ${t.getFullName} => ${union.toConstructString("x")}"
            case FIXED => s"case x: ${t.getFullName} => ${union.toConstructString(ltc.toType(t, "x"))}"
            case MAP =>
              new FunctionalPrinter()
                .add(s"case map: java.util.Map[?,?] =>")
                .indent
                .add(s"${union.toConstructString(assignMap(new FunctionalPrinter(), "map", t).result())}")
                .outdent
                .result()
            case BYTES => s"case x: java.nio.ByteBuffer => ${union.toConstructString(ltc.toTypeWithFallback(t, "x", "x.array()"))}"
            case ARRAY =>
              new FunctionalPrinter()
                .add(s"case array: java.util.List[?] =>")
                .indent
                .add(s"${union.toConstructString(assignArray(new FunctionalPrinter(), "array", t).result())}")
                .outdent
                .result()
            case _ =>
              t.getType match {
                case Type.STRING => s"case x: org.apache.avro.util.Utf8 => ${union.toConstructString(ltc.toType(t, "x.toString"))}"
                case Type.NULL => s"case null => ${union.toConstructString("null")}"
                case _ => s"case x: ${simpleTypeToScalaReceiveType(t.getType)} => ${union.toConstructString(ltc.toType(t, "x"))}"
              }
          }
        } :+ "case _ => throw new org.apache.avro.AvroRuntimeException(\"Unexpected type: \" + value.getClass.getName)"
      }: _*)
      case union @ OptionRepresentation(schema) =>
        val nullCasePrinter = printer.add("case null => None")
        schema.getType match {
          case MAP =>
            nullCasePrinter
              .add(s"case map: java.util.Map[?,?] =>")
              .indent
              .add(s"${union.toConstructString(assignMap(new FunctionalPrinter(), "map", schema).result())}")
              .outdent
          case ARRAY =>
            nullCasePrinter
              .add(s"case array: java.util.List[?] =>")
              .indent
              .add(s"${union.toConstructString(assignArray(new FunctionalPrinter(), "array", schema).result())}")
              .outdent
          case BYTES =>
            nullCasePrinter
              .add(s"case x: java.nio.ByteBuffer => ${union.toConstructString(ltc.toTypeWithFallback(schema, "x", "x.array()"))}")
          case RECORD | ENUM =>
            nullCasePrinter
              .add(s"case x: ${schema.getFullName} => ${union.toConstructString("x")}")
          case FIXED =>
            nullCasePrinter
              .add(s"case x: ${schema.getFullName} => ${union.toConstructString(ltc.toType(schema, "x"))}")
          case _ =>
            val x = toStringConverter("x", schema)
            val xCase = Try(s"x: ${simpleTypeToScalaReceiveType(schema.getType)}").getOrElse("x")
            nullCasePrinter
              .add(s"case $xCase => ${union.toConstructString(ltc.toType(schema, x))}")
        }
    }
  }

  private def assignMap(functionalPrinter: FunctionalPrinter, inputName: String, schema: Schema): FunctionalPrinter = {
    functionalPrinter
      .add(s"scala.jdk.CollectionConverters.MapHasAsScala($inputName).asScala.toMap map { kvp =>")
      .indent
      .add("val key = kvp._1.toString")
      .add("val value = kvp._2")
      .add(s"(key, {")
      .indent
      .call(assignMapInner(_, schema.getValueType))
      .outdent
      .add("})")
      .outdent
      .add("}")
  }

  private def assignMapInner(printer: FunctionalPrinter, schema: Schema): FunctionalPrinter = {
    schema.getType match {
      case UNION =>
        printer
          .call(asUnion(_, "value", schema))
      case MAP => asMap(printer, "value", schema)
      case ARRAY =>
        printer
          .call(asArray(_, "value", schema))
      case BYTES =>
        printer
          .call(asBytes(_, "value", schema))
      case _ =>
        printer
          .add(ltc.toType(schema, typeCast("value", schema)))
    }
  }
}