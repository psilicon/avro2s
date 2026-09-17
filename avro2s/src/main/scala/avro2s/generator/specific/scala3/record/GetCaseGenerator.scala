package avro2s.generator.specific.scala3.record

import avro2s.generator.FunctionalPrinter
import avro2s.generator.logical.LogicalTypes.LogicalTypeConverter
import avro2s.generator.specific.ScalaEnumSupport
import avro2s.generator.specific.scala3.FieldOps._
import org.apache.avro.Schema
import org.apache.avro.Schema.Type._

/**
 * NOTE: This features code that is not stack safe, based on the expectation that deeply nested schemas are unlikely, and that build tools
 * can adjust the stack size, if needed, when running code generation, without impacting applications. This may be improved in the future.
 */
private[avro2s] class GetCaseGenerator(ltc: LogicalTypeConverter, scalaEnums: Boolean) {
  val typeHelpers = new TypeHelpers(ltc)

  import typeHelpers._
  import typeHelpers.TypeUnion._

  def printFieldCase(printer: FunctionalPrinter, index: Int, field: Schema.Field): FunctionalPrinter = {
    field.schema().getType match {
      case UNION => printUnionCase(printer, index, field)
      case MAP => printMapCase(printer, index, field)
      case ARRAY => printArrayCase(printer, index, field)
      case BYTES => printByteCase(printer, index, field)
      case _ => printDefaultCase(printer, index, field)
    }
  }

  private def printUnionCase(printer: FunctionalPrinter, index: Int, field: Schema.Field): FunctionalPrinter =
    printer
      .add(s"case $index => ${field.safeName} match {")
      .indent
      .call(printUnionPatternMatch(_, TypeUnion(schemas(field.schema()))))
      .outdent
      .add("}")

  private def printMapCase(printer: FunctionalPrinter, index: Int, field: Schema.Field): FunctionalPrinter = {
    printer
      .add(s"case $index => {")
      .indent
      .add("val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]")
      .add(s"${field.safeName}.foreach { kvp =>")
      .indent
      .add("val key = kvp._1")
      .add(s"val value = {")
      .indent
      .call(printMapValue(_, field.schema().getValueType, "kvp._2"))
      .outdent
      .add("}")
      .add("map.put(key, value)")
      .outdent
      .add("}")
      .add("map")
      .outdent
      .add("}.asInstanceOf[AnyRef]")
  }

  private def printArrayCase(printer: FunctionalPrinter, index: Int, field: Schema.Field): FunctionalPrinter =
    printer
      .add(s"case $index => ${field.safeName} match {")
      .indent
      .add("case array =>")
      .indent
      .call(printArrayValue(_, field.schema(), "array"))
      .outdent
      .add("}")
      .outdent

  private def printByteCase(printer: FunctionalPrinter, index: Int, field: Schema.Field): FunctionalPrinter =
    printer
      .add(s"case $index => ${ltc.fromTypeWithFallback(field.schema(), field.safeName, s"java.nio.ByteBuffer.wrap(${field.safeName})")}.asInstanceOf[AnyRef]")

  private def printDefaultCase(printer: FunctionalPrinter, index: Int, field: Schema.Field): FunctionalPrinter =
    if (scalaEnums && field.schema().getType == ENUM) {
      printer.add(s"case $index => ${ScalaEnumSupport.wrapExpression(field.safeName, field.schema())}.asInstanceOf[AnyRef]")
    } else if (ltc.logicalTypeInUse(field.schema())) {
      printer.add(s"case $index => ${field.safeName}.asInstanceOf[AnyRef]")
    } else {
      printer.add(s"case $index => ${ltc.fromType(field.schema(), s"${field.safeName}")}.asInstanceOf[AnyRef]")
    }

  private def printArrayValue(printer: FunctionalPrinter, schema: Schema, input: String): FunctionalPrinter = {
    val element = schema.getElementType
    val needsConversion = element.getType match {
      case UNION | ARRAY | MAP => true
      case BYTES => !ltc.logicalTypeInUse(element)
      case ENUM => scalaEnums
      case _ => false
    }
    if (!needsConversion) {
      val elementType = schemaToScalaType(element, useLogical = true)
      // Avro clears collections returned by get when reusing records, so return a detached mutable copy.
      printer.add(s"new java.util.ArrayList[$elementType](scala.jdk.CollectionConverters.SeqHasAsJava($input).asJava)")
    } else {
      printer
        .add("scala.jdk.CollectionConverters.BufferHasAsJava({")
        .indent
        .call(printer => {
          element.getType match {
            case UNION =>
              printer
                .add(s"$input.iterator.map {")
                .indent
                .call(printUnionPatternMatch(_, TypeUnion(schemas(element))))
            case ARRAY =>
              printer
                .add(s"$input.iterator.map { array =>")
                .indent
                .call(printArrayValue(_, element, "array"))
            case MAP =>
              printer
                .add(s"$input.iterator.map { m =>")
                .indent
                .call(printMapValue(_, element, "m"))
            case BYTES =>
              printer
                .add(s"$input.iterator.map { bytes =>")
                .indent
                .add("java.nio.ByteBuffer.wrap(bytes)")
            case ENUM =>
              printer
                .add(s"$input.iterator.map { x =>")
                .indent
                .add(s"${ScalaEnumSupport.wrapExpression("x", element)}.asInstanceOf[AnyRef]")
            case _ => throw new IllegalStateException(s"Unexpected array element requiring conversion: $element")
          }
        })
        .outdent
        .add("}")
        .outdent
        .add("}.toBuffer).asJava")
    }
  }

  private def printMapValue(printer: FunctionalPrinter, schema: Schema, input: String): FunctionalPrinter = {
    schema.getType match {
      case MAP =>
        printer
          .add("val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]")
          .add(s"$input.foreach { kvp =>")
          .indent
          .add("val key = kvp._1")
          .add(s"val value = {")
          .indent
          .call(printMapValue(_, schema.getValueType, "kvp._2"))
          .outdent
          .add("}")
          .add("map.put(key, value)")
          .outdent
          .add("}")
          .add("map")
      case UNION =>
        printer
          .add(s"$input match {")
          .indent
          .call(printUnionPatternMatch(_, TypeUnion(schemas(schema))))
          .outdent
          .add("}")
      case ARRAY =>
        printer
          .call(printArrayValue(_, schema, input))
      case BYTES if !ltc.logicalTypeInUse(schema) =>
        printer
          .add(s"java.nio.ByteBuffer.wrap($input)")
      case ENUM if scalaEnums =>
        printer
          .add(s"${ScalaEnumSupport.wrapExpression(input, schema)}.asInstanceOf[AnyRef]")
      case _ =>
        printer
          .add(s"$input.asInstanceOf[AnyRef]")
    }
  }

  private def printUnionPatternMatch(printer: FunctionalPrinter, union: TypeUnion): FunctionalPrinter = {
    def x(schema: Schema): String = {
      schema.getType match {
        case MAP => s"\n${printMapValue(new FunctionalPrinter(indentLevel = 1), schema, "x").result()}"
        case UNION => s"\n${printUnionPatternMatch(new FunctionalPrinter(indentLevel = 1), TypeUnion(schemas(schema))).result()}"
        case ARRAY => s"\n${printArrayValue(new FunctionalPrinter(indentLevel = 1), schema, "x").result()}"
        case BYTES if !ltc.logicalTypeInUse(schema) => s"\njava.nio.ByteBuffer.wrap(x).asInstanceOf[AnyRef]"
        case ENUM if scalaEnums => s"${ScalaEnumSupport.wrapExpression("x", schema)}.asInstanceOf[AnyRef]"
        case _ => s"x.asInstanceOf[AnyRef]"
      }
    }

    if (union.hasNull)
      printer
        .add(union.noNulls.map(t => s"case Some(x: ${schemaToScalaType(t, true)}) => ${x(t)}"): _*)
        .add("case None => null.asInstanceOf[AnyRef]")
    else
      printer.add(union.noNulls.map(t => s"case x: ${schemaToScalaType(t, true)} => ${x(t)}"): _*)
  }
}
