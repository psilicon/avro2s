package avro2s.generator.specific.scala3.record

import avro2s.generator.FunctionalPrinter
import avro2s.generator.logical.LogicalTypes.LogicalTypeConverter
import avro2s.generator.specific.ScalaEnumSupport
import avro2s.generator.specific.scala3.FieldOps._
import org.apache.avro.Schema
import org.apache.avro.Schema.Type
import org.apache.avro.Schema.Type._

/**
 * NOTE: This features code that is not stack safe, based on the expectation that deeply nested schemas are unlikely, and that build tools
 * can adjust the stack size, if needed, when running code generation, without impacting applications. This may be improved in the future.
 */
private[avro2s] class PutCaseGenerator(ltc: LogicalTypeConverter, scalaEnums: Boolean) {
  private val dollar = "$"
  val typeHelpers = new TypeHelpers(ltc)

  import typeHelpers._
  import typeHelpers.TypeUnion._

  def printFieldCase(printer: FunctionalPrinter, index: Int, field: Schema.Field): FunctionalPrinter = {
    printer
      .add(s"case $index => this.${field.safeName} = {")
      .indent
      .call { printer =>
        field.schema().getType match {
          case UNION =>
            printer.call(asUnion(_, "value", field.schema()))
          case BYTES | FIXED if ltc.putConversionIsOptional(field.schema()) =>
            printer.add(ltc.toType(field.schema(), "value"))
          case BYTES | FIXED if ltc.putReceivesConverted(field.schema()) =>
            printer.add(s"value.asInstanceOf[${ltc.getType(field.schema(), schemaToScalaType(field.schema(), false))}]")
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
    val union = TypeUnion(schemas(schema))
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
      .add(s"${ltc.toTypeWithFallback(schema, "buffer", "val start$ = buffer.position(); val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); (buffer: java.nio.Buffer).position(start$); array")}")
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
    if (scalaEnums && schema.getType == ENUM) {
      printer.add(ScalaEnumSupport.putConversion(input, schema))
    } else if (ltc.putReceivesConverted(schema)) {
      printer.add(s"$input.asInstanceOf[${ltc.getType(schema, schemaToScalaType(schema, false))}]")
    } else {
      val value = s"${toStringConverter(input, schema)}.asInstanceOf[${schemaToScalaType(schema, false)}]"
      printer.add(s"${ltc.toType(schema, value)}")
    }
  }

  // Built by a loop rather than through CollectionConverters: asScala.map(...).toList allocates a
  // wrapper, a Scala iterator adapter and a lazy map iterator before a single element is read, and
  // none of them outlive the call. The Java iterator is kept so a list that is not RandomAccess is
  // still walked in linear time.
  private def assignArray(printer: FunctionalPrinter, input: String, schema: Schema): FunctionalPrinter = {
    printer
      .add("{")
      .indent
      .add(s"val builder$dollar = List.newBuilder[${schemaToScalaType(schema.getElementType, true)}]")
      .add(s"val iterator$dollar = $input.iterator")
      .add(s"while (iterator$dollar.hasNext) {")
      .indent
      .add(s"val value = iterator$dollar.next")
      .add(s"builder$dollar += {")
      .indent
      .call(assignArrayInner(_, "value", schema.getElementType))
      .outdent
      .add("}")
      .outdent
      .add("}")
      .add(s"builder$dollar.result()")
      .outdent
      .add("}")
  }

  private def assignArrayInner(printer: FunctionalPrinter, input: String, schema: Schema): FunctionalPrinter = {
    schema.getType match {
      case UNION =>
        printer
          .call(asUnion(_, input, schema))
      case MAP => asMap(printer, input, schema)
      case ARRAY => asArray(printer, input, schema)
      case BYTES | FIXED if ltc.putReceivesConverted(schema) =>
        printer.add(s"$input.asInstanceOf[${ltc.getType(schema, schemaToScalaType(schema, false))}]")
      case BYTES =>
        printer
          .call(asBytes(_, input, schema))
      case ENUM if scalaEnums =>
        printer.add(ScalaEnumSupport.putConversion(input, schema))
      case _ =>
        if (ltc.putReceivesConverted(schema)) {
          printer.add(s"$input.asInstanceOf[${ltc.getType(schema, schemaToScalaType(schema, false))}]")
        } else {
          printer.add(ltc.toType(schema, if (ltc.selfConverts(schema)) input else typeCast(input, schema)))
        }
    }
  }

  private def matchUnionType(printer: FunctionalPrinter, union: TypeUnion): FunctionalPrinter = {
    union match {
      case TypeUnion(types) => printer.add({
        types.flatMap { t =>
          t.getType match {
            case ENUM if scalaEnums => List(
              s"case x: ${t.getFullName} => ${union.toConstructString(s"x.asInstanceOf[${union.innerTypeStr(typeHelpers)}]")}",
              s"""case x: org.apache.avro.generic.GenericEnumSymbol[_] if x.getSchema.getFullName == "${t.getFullName}" => ${union.toConstructString(s"_root_.${t.getFullName}.fromAvroSymbol(x.toString).asInstanceOf[${union.innerTypeStr(typeHelpers)}]")}"""
            )
            case RECORD | ENUM => List(s"case x: ${t.getFullName} => ${union.toConstructString(s"x.asInstanceOf[${union.innerTypeStr(typeHelpers)}]")}")
            case FIXED if ltc.putReceivesConverted(t) => List(s"case x: ${ltc.getType(t, t.getFullName)} => ${union.toConstructString(s"x.asInstanceOf[${union.innerTypeStr(typeHelpers)}]")}")
            case FIXED => List(s"case x: ${t.getFullName} => ${union.toConstructString(s"${ltc.toType(t, "x")}.asInstanceOf[${union.innerTypeStr(typeHelpers)}]")}")
            case MAP =>
              List(new FunctionalPrinter()
                .add(s"case map: java.util.Map[?,?] =>")
                .indent
                .add(s"${union.toConstructString(assignMap(new FunctionalPrinter(), "map", t).result())}")
                .outdent
                .result())
            case BYTES if ltc.putReceivesConverted(t) => List(s"case x: ${ltc.getType(t, "java.nio.ByteBuffer")} => ${union.toConstructString("x")}")
            case BYTES => List(s"case x: java.nio.ByteBuffer => ${union.toConstructString(ltc.toTypeWithFallback(t, "x", "{ val start$ = x.position(); val bytes$ = new Array[Byte](x.remaining); x.get(bytes$); (x: java.nio.Buffer).position(start$); bytes$ }"))}")
            case ARRAY =>
              List(new FunctionalPrinter()
                .add(s"case array: java.util.List[?] =>")
                .indent
                .add(s"${union.toConstructString(assignArray(new FunctionalPrinter(), "array", t).result())}")
                .outdent
                .result())
            case _ =>
              if (ltc.putReceivesConverted(t)) {
                List(s"case x: ${ltc.getType(t, simpleTypeToScalaReceiveType(t.getType))} => ${union.toConstructString("x")}")
              } else {
                t.getType match {
                  case Type.STRING =>
                    List(s"case x: ${simpleTypeToScalaReceiveType(t.getType)} => ${union.toConstructString(ltc.toType(t, "x.toString"))}")
                  case Type.NULL => List(s"case null => None")
                  case _ =>
                    List(s"case x: ${simpleTypeToScalaReceiveType(t.getType)} => ${union.toConstructString(ltc.toType(t, "x"))}")
                }
              }
          }
        } :+ "case _ => throw new org.apache.avro.AvroRuntimeException(\"Unexpected type: \" + value.getClass.getName)"
      }: _*)
    }
  }

  private def assignMap(functionalPrinter: FunctionalPrinter, inputName: String, schema: Schema): FunctionalPrinter = {
    functionalPrinter
      .add(s"if ($inputName.isEmpty) _root_.scala.collection.immutable.Map.empty[String, ${schemaToScalaType(schema.getValueType, true)}] else {")
      .indent
      .add(s"val builder$dollar = Map.newBuilder[String, ${schemaToScalaType(schema.getValueType, true)}]")
      .add(s"val iterator$dollar = $inputName.entrySet.iterator")
      .add(s"while (iterator$dollar.hasNext) {")
      .indent
      .add(s"val entry$dollar = iterator$dollar.next")
      .add(s"val key = entry$dollar.getKey.toString")
      .add(s"val value = entry$dollar.getValue")
      .add(s"builder$dollar += ((key, {")
      .indent
      .call(assignMapInner(_, schema.getValueType))
      .outdent
      .add("}))")
      .outdent
      .add("}")
      .add(s"builder$dollar.result()")
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
      case BYTES | FIXED if ltc.putReceivesConverted(schema) =>
        printer.add(s"value.asInstanceOf[${ltc.getType(schema, schemaToScalaType(schema, false))}]")
      case BYTES =>
        printer
          .call(asBytes(_, "value", schema))
      case ENUM if scalaEnums =>
        printer.add(ScalaEnumSupport.putConversion("value", schema))
      case _ =>
        if (ltc.putReceivesConverted(schema)) {
          printer.add(s"value.asInstanceOf[${ltc.getType(schema, schemaToScalaType(schema, false))}]")
        } else {
          printer.add(ltc.toType(schema, if (ltc.selfConverts(schema)) "value" else typeCast("value", schema)))
        }
    }
  }
}
