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
      case FIXED => printFixedCase(printer, index, field)
      case _ => printDefaultCase(printer, index, field)
    }
  }

  private def printFixedCase(printer: FunctionalPrinter, index: Int, field: Schema.Field): FunctionalPrinter =
    if (ltc.logicalTypeInUse(field.schema())) {
      printer.add(s"case $index => ${ltc.fromType(field.schema(), field.safeName)}.asInstanceOf[AnyRef]")
    } else {
      printer.add(s"case $index => ${field.safeName}.asInstanceOf[AnyRef]")
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
      .add(s"val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any](${mapCapacity(field.safeName)})")
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
    val elementType = schemaToScalaType(element, useLogical = true)
    if (!needsConversion) {
      // Copying straight into the backing array allocates once. Going through asJava instead
      // costs a wrapper, its iterator, an Object[] from toArray and a second Arrays.copyOf,
      // because ArrayList only skips the copy for another ArrayList.
      // AnyRef keeps the elements' existing boxes, so a List[Long] is not unboxed and reboxed.
      return printer
        .add("{")
        .indent
        .add("def toJavaArray$(input$: List[AnyRef]): java.util.ArrayList[AnyRef] = {")
        .indent
        .add("var remaining$ = input$")
        // Avro reuses the collection this returns when it decodes into a record, clearing it
        // but keeping its capacity. Sizing an empty list to 0 therefore leaves a read growing
        // the backing array from nothing on every field. The no-arg constructor allocates
        // nothing here and gives a reused list room, so writes of empty arrays stay free.
        .add("val result$ = if (input$.isEmpty) new java.util.ArrayList[AnyRef]() else new java.util.ArrayList[AnyRef](input$.size)")
        .add("while (remaining$.nonEmpty) {")
        .indent
        .add("result$.add(remaining$.head)")
        .add("remaining$ = remaining$.tail")
        .outdent
        .add("}")
        .add("result$")
        .outdent
        .add("}")
        .add(s"toJavaArray$$($input.asInstanceOf[List[AnyRef]])")
        .outdent
        .add("}")
    }
    // Avro clears collections returned by get when reusing records, so return a detached mutable copy.
    // A capture-free local method keeps collection loops out of the record's get method for the JIT.
    // List is safe to hardcode here and above: TypeHelpers maps every Avro array to List, so head
    // and tail are O(1). size is O(n) on a List, so both loops traverse twice in exchange for
    // sizing the backing array exactly once and never growing it.
    printer
      .add("{")
      .indent
      .add(s"def toJavaArray$$(input$$: List[$elementType]): java.util.ArrayList[AnyRef] = {")
      .indent
      .add("var remaining$ = input$")
      .add("val result$ = new java.util.ArrayList[AnyRef](remaining$.size)")
      .add("while (remaining$.nonEmpty) {")
      .indent
      .add("val element$ = remaining$.head")
      .add("result$.add({")
      .indent
      .call { printer =>
        element.getType match {
          case UNION =>
            printer
              .add("element$ match {")
              .indent
              .call(printUnionPatternMatch(_, TypeUnion(schemas(element))))
              .outdent
              .add("}")
          case ARRAY => printer.call(printArrayValue(_, element, "element$"))
          case MAP => printer.call(printMapValue(_, element, "element$"))
          case BYTES if !ltc.logicalTypeInUse(element) => printer.add("java.nio.ByteBuffer.wrap(element$)")
          case ENUM if scalaEnums => printer.add(ScalaEnumSupport.wrapExpression("element$", element))
          case _ => printer.add("element$")
        }
      }
      .outdent
      .add("})")
      .add("remaining$ = remaining$.tail")
      .outdent
      .add("}")
      .add("result$")
      .outdent
      .add("}")
      .add(s"toJavaArray$$($input)")
      .outdent
      .add("}")
  }

  private def printMapValue(printer: FunctionalPrinter, schema: Schema, input: String): FunctionalPrinter = {
    schema.getType match {
      case MAP =>
        printer
          .add(s"val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any](${mapCapacity(input)})")
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

  // Keep small maps on an integer-only fast path, using HashMap's default load factor above 12 entries.
  // Double.toInt saturates for very large sizes instead of overflowing to a negative capacity.
  private def mapCapacity(input: String): String =
    s"{ val size$$ = $input.size; if (size$$ <= 12) 16 else _root_.scala.math.ceil(size$$ / 0.75d).toInt }"

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
