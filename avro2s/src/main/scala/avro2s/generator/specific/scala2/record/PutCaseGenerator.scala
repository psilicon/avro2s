package avro2s.generator.specific.scala2.record

import avro2s.generator.FunctionalPrinter
import avro2s.generator.logical.LogicalTypes.LogicalTypeConverter
import avro2s.generator.specific.scala2.FieldOps._
import avro2s.generator.specific.scala2.record.UnionRepresentation.{CoproductRepresentation, OptionRepresentation, UnionRepresentation}
import org.apache.avro.Schema
import org.apache.avro.Schema.Type
import org.apache.avro.Schema.Type.{ARRAY, BYTES, ENUM, FIXED, MAP, RECORD, UNION}

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
          .add(s"case $index => value match {")
          .indent
          .call(printUnionPatternMatch(_, field.name, unionSchemasToType(schemas(field.schema()))))
          .outdent
          .add("}")
      case BYTES =>
        printer
          .add(s"case $index => this.${field.safeName} = value match {")
          .indent
          .add("case buffer: java.nio.ByteBuffer => val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); array")
          .outdent
          .add("}")
      case MAP =>
        printMapCase(printer, index, field)
      case ARRAY =>
        printArrayCase(printer, index, field)
      case FIXED =>
        val value = s"${toStringConverter("value", field.schema())}.asInstanceOf[${schemaToScalaType(field.schema, false)}]"
        printer
          .add(s"case $index => this.${field.safeName} = $value")
      case _ =>
        val value = s"${toStringConverter("value", field.schema())}.asInstanceOf[${schemaToScalaType(field.schema, false)}]"
        printer
          .add(s"case $index => this.${field.safeName} = $value")
    }
  }

  private def printArrayCase(printer: FunctionalPrinter, index: Int, field: Schema.Field): FunctionalPrinter =
    printer
      .add(s"case $index => this.${field.safeName} = {")
      .indent
      .call(printArrayValueOuter(_, field.schema()))
      .outdent
      .add("}")

  private def printArrayValueOuter(printer: FunctionalPrinter, schema: Schema, valueName: Option[String] = None): FunctionalPrinter = {
    val value = valueName.getOrElse("value")
    printer
      .add(s"$value match {")
      .indent
      .add("case array: java.util.List[_] =>")
      .indent
      .add("scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>")
      .indent
      .call(printArrayValueInner(_, schema.getElementType))
      .outdent
      .add("}).toList")
      .outdent
      .add("}")
      .outdent
  }

  private def printArrayValueInner(printer: FunctionalPrinter, schema: Schema, valueName: Option[String] = None): FunctionalPrinter = {
    val value = valueName.getOrElse("value")
    schema.getType match {
      case UNION =>
        printer
          .add(s"$value match {")
          .indent
          .call(printUnionValue(_, unionSchemasToType(schemas(schema))))
          .outdent
          .add("}")
      case MAP => printMapValueOuter(printer, schema)
      case ARRAY => printArrayValueOuter(printer, schema, Some(value))
      case BYTES =>
        printer
          .add(s"$value match {")
          .indent
          .add("case buffer: java.nio.ByteBuffer => val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); array")
          .outdent
          .add("}")
      case _ =>
        printer
          .add(typeCast(value, schema))
    }
  }

  private def printMapCase(printer: FunctionalPrinter, index: Int, field: Schema.Field): FunctionalPrinter =
    printer
      .add(s"case $index => this.${field.safeName} = {")
      .indent
      .call(printMapValueOuter(_, field.schema()))
      .outdent
      .add("}")

  private def printMapValueOuter(printer: FunctionalPrinter, schema: Schema): FunctionalPrinter =
    printer
      .add("value match {")
      .indent
      .add("case map: java.util.Map[_,_] => {")
      .indent
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
      .outdent
      .add("}")
      .outdent
      .add("}")

  private def printMapValueInner(printer: FunctionalPrinter, schema: Schema): FunctionalPrinter = {
    schema.getType match {
      case UNION =>
        printer
          .add("value match {")
          .indent
          .call(printUnionValue(_, unionSchemasToType(schemas(schema))))
          .outdent
          .add("}")
      case MAP => printMapValueOuter(printer, schema)
      case ARRAY =>
        printer
          .add("value match {")
          .indent
          .add("case array: java.util.List[_] =>")
          .indent
          .add("scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>")
          .indent
          .call(printArrayValueInner(_, schema.getElementType))
          .outdent
          .add("}).toList")
          .outdent
          .add("}")
          .outdent
      case BYTES =>
        printer
          .add("value match {")
          .indent
          .add("case buffer: java.nio.ByteBuffer => val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); array")
          .outdent
          .add("}")
      case _ =>
        printer
          .add(typeCast("value", schema))
    }
  }

  private def printUnionPatternMatch(printer: FunctionalPrinter, fieldName: String, union: UnionRepresentation): FunctionalPrinter = {
    union match {
      case CoproductRepresentation(types) => printer.add({
        types.map { t =>
          val newPrinter = new FunctionalPrinter()
          t.getType match {
            case MAP =>
              newPrinter
                .call(printUnionMapPatternMatch(_, fieldName, t, union))
                .result()
            case ARRAY =>
              newPrinter
                .add(s"case x: java.util.List[_] => this.$fieldName = Coproduct[${union.asString(typeHelpers)}]({")
                .indent
                .call(printArrayValueInner(_, t, Some("x")))
                .outdent
                .add("}.toList)")
                .result()
            case BYTES =>
              newPrinter
                .add(s"case x: java.nio.ByteBuffer => this.$fieldName = Coproduct[${union.asString(typeHelpers)}](x.array())")
                .result()
            case RECORD | ENUM =>
              newPrinter
                .add(s"case x: ${t.getFullName} => this.$fieldName = Coproduct[${union.asString(typeHelpers)}](x)")
                .result()
            case FIXED =>
              newPrinter
                .add(s"case x: ${t.getFullName} => this.$fieldName = Coproduct[${union.asString(typeHelpers)}](x)")
                .result()
            case _ =>
              val typeName = simpleTypeToScalaReceiveType(t.getType)
              val x = toStringConverter("x", t)
              val `case` = if (t.getType == Type.NULL) "x @ null" else s"x: $typeName"
              newPrinter
                .add(s"case ${`case`} => this.$fieldName = Coproduct[${union.asString(typeHelpers)}](x)")
                .result()
          }
        } :+ "case _ => throw new AvroRuntimeException(\"Invalid value\")"
      }.mkString("\n"))
      case OptionRepresentation(schema) =>
        printer
          .add(s"case null => this.$fieldName = None")
          .call { printer =>
            schema.getType match {
              case MAP => printOptionMapPatternMatch(printer, fieldName, schema)
              case ARRAY =>
                printer
                  .add(s"case x: java.util.List[_] => this.$fieldName = Some({")
                  .indent
                  .call(printArrayValueInner(_, schema, Some("x")))
                  .outdent
                  .add("}.toList)")
              case BYTES =>
                printer
                  .add(s"case x: java.nio.ByteBuffer => this.$fieldName = Some(x.array())")
              case RECORD | ENUM =>
                printer
                  .add(s"case x: ${schema.getFullName} => this.$fieldName = Some(x)")
              case FIXED =>
                printer
                  .add(s"case x: ${schema.getFullName} => this.$fieldName = Some(x)")
              case _ =>
                val x = toStringConverter("x", schema)
                printer
                  .add(s"case x => this.$fieldName = Some(x.asInstanceOf[${schemaToScalaType(schema, true)}])")
            }
          }
    }
  }

  private def printUnionValue(printer: FunctionalPrinter, union: UnionRepresentation): FunctionalPrinter = {
    union match {
      case CoproductRepresentation(types) => printer.add({
        types.map { t =>
          if (t.getType == RECORD) s"case x: ${t.getFullName} => Coproduct[${union.asString(typeHelpers)}](x)"
          else if (t.getType == MAP) printUnionMapValue(new FunctionalPrinter(), t, union).result()
          else if (t.getType == FIXED) s"case x: ${t.getFullName} => Coproduct[${union.asString(typeHelpers)}](x)"
          else {
            val typeName = simpleTypeToScalaReceiveType(t.getType)
            val x = toStringConverter("x", t)
            val `case` = if (t.getType == Type.NULL) "x @ null" else s"x: $typeName"
            s"case ${`case`} => Coproduct[${union.asString(typeHelpers)}](x)"
          }
        } :+ "case _ => throw new AvroRuntimeException(\"Invalid value\")"
      }.mkString("\n"))
      case OptionRepresentation(schema) =>
        val value = toStringConverter("x", schema)
        printer.add(
          s"""case null => None
             |case x => Some($value.asInstanceOf[${schemaToScalaType(schema, true)}])""".stripMargin
        )
    }
  }

  private def printUnionMapPatternMatch(functionalPrinter: FunctionalPrinter, fieldName: String, schema: Schema, union: UnionRepresentation): FunctionalPrinter = {
    functionalPrinter
      .add(s"case map: java.util.Map[_,_] => this.$fieldName = Coproduct[${union.asString(typeHelpers)}]({")
      .indent
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
      .outdent
      .add("})")
  }

  private def printOptionMapPatternMatch(functionalPrinter: FunctionalPrinter, fieldName: String, schema: Schema): FunctionalPrinter = {
    functionalPrinter
      .add(s"case map: java.util.Map[_,_] => this.$fieldName = Some({")
      .indent
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
      .outdent
      .add("})")
  }

  private def printUnionMapValue(functionalPrinter: FunctionalPrinter, schema: Schema, union: UnionRepresentation): FunctionalPrinter = {
    functionalPrinter
      .add(s"case map: java.util.Map[_,_] => Coproduct[${union.asString(typeHelpers)}]({")
      .indent
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
      .outdent
      .add("})")
  }
}
