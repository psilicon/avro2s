package avro2s.generator.specific.scala2.record

import avro2s.generator.FunctionalPrinter
import avro2s.generator.logical.LogicalTypes.LogicalTypeConverter
import avro2s.generator.specific.ScalaEnumSupport
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
private[avro2s] class PutCaseGenerator(ltc: LogicalTypeConverter, scalaEnums: Boolean) {
  private val dollar = "$"
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
      case BYTES | FIXED if ltc.putConversionIsOptional(field.schema()) =>
        printer
          .add(s"case $index => this.${field.safeName} = ${ltc.toType(field.schema(), "value")}")
      case BYTES | FIXED if ltc.putReceivesConverted(field.schema()) =>
        printer
          .add(s"case $index => this.${field.safeName} = value.asInstanceOf[${ltc.getType(field.schema(), schemaToScalaType(field.schema, false))}]")
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
      case ENUM if scalaEnums =>
        printer
          .add(s"case $index => this.${field.safeName} = ${ScalaEnumSupport.putConversion("value", field.schema())}")
      case _ =>
        if (ltc.putReceivesConverted(field.schema())) {
          printer
            .add(s"case $index => this.${field.safeName} = value.asInstanceOf[${ltc.getType(field.schema(), schemaToScalaType(field.schema, false))}]")
        } else {
          val value = s"${toStringConverter("value", field.schema())}.asInstanceOf[${schemaToScalaType(field.schema, false)}]"
          printer
            .add(s"case $index => this.${field.safeName} = ${ltc.toType(field.schema(), value)}")
        }
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
      .add(s"case buffer: java.nio.ByteBuffer => ${ltc.toTypeWithFallback(schema, "buffer", "val start$ = buffer.position(); val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); (buffer: java.nio.Buffer).position(start$); array")}")
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
      // A loop rather than CollectionConverters: asScala.map(...).toList allocates a wrapper, a
      // Scala iterator adapter and a lazy map iterator before a single element is read, and none
      // of them outlive the call.
      .add(s"val builder$dollar = List.newBuilder[${schemaToScalaType(schema.getElementType, true)}]")
      .add(s"val iterator$dollar = array.iterator")
      .add(s"while (iterator$dollar.hasNext) {")
      .indent
      .add(s"val value = iterator$dollar.next")
      .add(s"builder$dollar += {")
      .indent
      .call(printArrayValue(_, "value", schema.getElementType))
      .outdent
      .add("}")
      .outdent
      .add("}")
      .add(s"builder$dollar.result()")
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
      case BYTES | FIXED if ltc.putReceivesConverted(schema) =>
        printer.add(s"$valueName.asInstanceOf[${ltc.getType(schema, schemaToScalaType(schema, false))}]")
      case BYTES =>
        printer
          .add(s"$valueName match {")
          .indent
          .add(s"case buffer: java.nio.ByteBuffer => ${ltc.toTypeWithFallback(schema, "buffer", "val start$ = buffer.position(); val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); (buffer: java.nio.Buffer).position(start$); array")}")
          .outdent
          .add("}")
      case ENUM if scalaEnums =>
        printer.add(ScalaEnumSupport.putConversion(valueName, schema))
      case _ =>
        if (ltc.putReceivesConverted(schema)) {
          printer.add(s"$valueName.asInstanceOf[${ltc.getType(schema, schemaToScalaType(schema, false))}]")
        } else {
          printer.add(ltc.toType(schema, if (ltc.selfConverts(schema)) valueName else typeCast(valueName, schema)))
        }
    }
  }

  private def printMapValue(functionalPrinter: FunctionalPrinter, schema: Schema): FunctionalPrinter = {
    functionalPrinter
      .add(s"if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, ${schemaToScalaType(schema.getValueType, true)}] else {")
      .indent
      .add(s"val builder$dollar = Map.newBuilder[String, ${schemaToScalaType(schema.getValueType, true)}]")
      .add(s"val iterator$dollar = map.entrySet.iterator")
      .add(s"while (iterator$dollar.hasNext) {")
      .indent
      .add(s"val entry$dollar = iterator$dollar.next")
      .add(s"val key = entry$dollar.getKey.toString")
      .add(s"val value = entry$dollar.getValue")
      .add(s"builder$dollar += ((key, {")
      .indent
      .call(printMapValueInner(_, schema.getValueType))
      .outdent
      .add("}))")
      .outdent
      .add("}")
      .add(s"builder$dollar.result()")
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
      case BYTES | FIXED if ltc.putReceivesConverted(schema) =>
        printer.add(s"value.asInstanceOf[${ltc.getType(schema, schemaToScalaType(schema, false))}]")
      case BYTES =>
        printer
          .call(matchBytes(_, "value", schema))
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

  private def matchUnionInner(printer: FunctionalPrinter, union: UnionRepresentation): FunctionalPrinter = {
    union match {
      case CoproductRepresentation(types) => printer.add({
        types.flatMap { t =>
          t.getType match {
            case ENUM if scalaEnums => List(
              s"case x: ${t.getFullName} => Coproduct[${union.asString(typeHelpers)}](x)",
              s"""case x: org.apache.avro.generic.GenericEnumSymbol[_] if x.getSchema.getFullName == "${t.getFullName}" => Coproduct[${union.asString(typeHelpers)}](_root_.${t.getFullName}.fromAvroSymbol(x.toString))"""
            )
            case RECORD | ENUM => List(s"case x: ${t.getFullName} => Coproduct[${union.asString(typeHelpers)}](x)")
            case MAP =>
              List(new FunctionalPrinter()
                .add(s"case map: java.util.Map[_,_] => Coproduct[${union.asString(typeHelpers)}]{")
                .indent
                .call(printMapValue(_, t))
                .outdent
                .add("}")
                .result())
            case FIXED if ltc.putReceivesConverted(t) => List(s"case x: ${ltc.getType(t, t.getFullName)} => Coproduct[${union.asString(typeHelpers)}](x)")
            case FIXED => List(s"case x: ${t.getFullName} => Coproduct[${union.asString(typeHelpers)}](${ltc.toType(t, "x")})")
            case BYTES if ltc.putReceivesConverted(t) => List(s"case x: ${ltc.getType(t, "java.nio.ByteBuffer")} => Coproduct[${union.asString(typeHelpers)}](x)")
            case BYTES => List(s"case x: java.nio.ByteBuffer => Coproduct[${union.asString(typeHelpers)}](${ltc.toTypeWithFallback(t, "x", "{ val start$ = x.position(); val bytes$ = new Array[Byte](x.remaining); x.get(bytes$); (x: java.nio.Buffer).position(start$); bytes$ }")})")
            case ARRAY =>
              List(new FunctionalPrinter()
                .add(s"case x: java.util.List[_] => Coproduct[${union.asString(typeHelpers)}]({")
                .indent
                .call(printArrayValue(_, "x", t))
                .outdent
                .add("})")
                .result())
            case _ =>
              if (ltc.putReceivesConverted(t)) {
                List(s"case x: ${ltc.getType(t, simpleTypeToScalaReceiveType(t.getType))} => Coproduct[${union.asString(typeHelpers)}](x)")
              } else {
                val typeName = simpleTypeToScalaReceiveType(t.getType)
                val x = toStringConverter("x", t)
                val `case` = if (t.getType == Type.NULL) "x @ null" else s"x: $typeName"
                List(s"case ${`case`} => Coproduct[${union.asString(typeHelpers)}](${ltc.toType(t, x)})")
              }
          }
        } :+ "case _ => throw new AvroRuntimeException(\"Unexpected type: \" + value.getClass.getName)"
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
              .add("})")
          case BYTES | FIXED if ltc.putReceivesConverted(schema) =>
            nullCasePrinter
              .add(s"case x: ${ltc.getType(schema, schemaToScalaType(schema, false))} => Some(x)")
          case BYTES =>
            nullCasePrinter
              .add(s"case x: java.nio.ByteBuffer => Some(${ltc.toTypeWithFallback(schema, "x", "{ val start$ = x.position(); val bytes$ = new Array[Byte](x.remaining); x.get(bytes$); (x: java.nio.Buffer).position(start$); bytes$ }")})")
          case ENUM if scalaEnums =>
            nullCasePrinter
              .add(s"case x: ${schema.getFullName} => Some(x)")
              .add(s"case x: org.apache.avro.generic.GenericEnumSymbol[_] => Some(_root_.${schema.getFullName}.fromAvroSymbol(x.toString))")
          case RECORD | ENUM =>
            nullCasePrinter
              .add(s"case x: ${schema.getFullName} => Some(x)")
          case FIXED =>
            nullCasePrinter
              .add(s"case x: ${schema.getFullName} => Some(${ltc.toType(schema, "x")})")
          case _ =>
            if (ltc.putReceivesConverted(schema)) {
              nullCasePrinter.add(s"case x: ${ltc.getType(schema, simpleTypeToScalaReceiveType(schema.getType))} => Some(x)")
            } else {
              val x = toStringConverter("x", schema)
              val xCase = Try(s"x: ${simpleTypeToScalaReceiveType(schema.getType)}").getOrElse("x")
              nullCasePrinter.add(s"case $xCase => Some(${ltc.toType(schema, x)})")
            }
        }
    }
  }
}
