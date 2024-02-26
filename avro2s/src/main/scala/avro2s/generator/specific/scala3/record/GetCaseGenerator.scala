package avro2s.generator.specific.scala3.record

import avro2s.generator.FunctionalPrinter
import avro2s.generator.specific.scala3.FieldOps._
import avro2s.generator.specific.scala3.record.TypeHelpers.UnionRepresentation.{OptionRepresentation, TypeUnionRepresentation}
import avro2s.generator.specific.scala3.record.TypeHelpers.{UnionRepresentation, schemaToScalaType, schemas, unionSchemasToType}
import org.apache.avro.Schema
import org.apache.avro.Schema.Type._

/**
 * NOTE: This features code that is not stack safe, based on the expectation that deeply nested schemas are unlikely, and that build tools
 * can adjust the stack size, if needed, when running code generation, without impacting applications. This may be improved in the future.
 */
private[avro2s] object GetCaseGenerator {
  def printFieldCase(printer: FunctionalPrinter, index: Int, field: Schema.Field): FunctionalPrinter = {
    field.schema().getType match {
      case UNION =>
        printer
          .add(s"case $index => ${field.safeName} match {")
          .indent
          .call(printUnionPatternMatch(_, unionSchemasToType(schemas(field.schema()))))
          .outdent
          .add("}")
      case BYTES =>
        printer
          .add(s"case $index => java.nio.ByteBuffer.wrap(${field.safeName}).asInstanceOf[AnyRef]")
      case MAP => printMapCase(printer, index, field)
      case ARRAY => printArrayCase(printer, index, field)
      case _ =>
        printer
          .add(s"case $index => ${field.safeName}.asInstanceOf[AnyRef]")
    }
  }

  private def printArrayCase(printer: FunctionalPrinter, index: Int, field: Schema.Field): FunctionalPrinter =
    printer
      .add(s"case $index => ${field.safeName} match {")
      .indent
      .add("case array =>")
      .indent
      .call(printArrayValue(_, field.schema()))
      .outdent
      .add("}")
      .outdent

  private def printArrayValue(printer: FunctionalPrinter, schema: Schema, valueName: Option[String] = None): FunctionalPrinter = {
    val value = valueName.getOrElse("array")
    schema.getElementType.getType match {
      case UNION =>
        printer
          .add("scala.jdk.CollectionConverters.BufferHasAsJava({")
          .indent
          .add(s"$value.map {")
          .indent
          .call(printUnionPatternMatch(_, unionSchemasToType(schemas(schema.getElementType))))
          .outdent
          .add("}")
          .outdent
          .add("}.toBuffer).asJava")
      case ARRAY =>
        printer
          .add("scala.jdk.CollectionConverters.BufferHasAsJava({")
          .indent
          .add(s"$value.map { array =>")
          .indent
          .call(printArrayValue(_, schema.getElementType))
          .outdent
          .add("}")
          .outdent
          .add("}.toBuffer).asJava")
      case MAP =>
        printer
          .add("scala.jdk.CollectionConverters.BufferHasAsJava({")
          .indent
          .add(s"$value.map { m =>")
          .indent
          .call(printMapValue(_, schema.getElementType, Some("m")))
          .outdent
          .add("}")
          .outdent
          .add("}.toBuffer).asJava")
      case BYTES =>
        printer
          .add("scala.jdk.CollectionConverters.BufferHasAsJava({")
          .indent
          .add(s"$value.map { bytes =>")
          .indent
          .add("java.nio.ByteBuffer.wrap(bytes)")
          .outdent
          .add("}")
          .outdent
          .add("}.toBuffer).asJava")
      case _ =>
        printer
          .add("scala.jdk.CollectionConverters.BufferHasAsJava({")
          .indent
          .add(s"$value.map { x =>")
          .indent
          .add("x.asInstanceOf[AnyRef]")
          .outdent
          .add("}")
          .outdent
          .add("}.toBuffer).asJava")
    }
  }

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
      .call(printMapValue(_, field.schema().getValueType))
      .outdent
      .add("}")
      .add("map.put(key, value)")
      .outdent
      .add("}")
      .add("map")
      .outdent
      .add("}.asInstanceOf[AnyRef]")
  }

  private def printMapValue(printer: FunctionalPrinter, schema: Schema, valueName: Option[String] = None): FunctionalPrinter = {
    val value = valueName.getOrElse("kvp._2")
    schema.getType match {
      case MAP =>
        printer
          .add("val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]")
          .add(s"$value.foreach { kvp =>")
          .indent
          .add("val key = kvp._1")
          .add(s"val value = {")
          .indent
          .call(printMapValue(_, schema.getValueType))
          .outdent
          .add("}")
          .add("map.put(key, value)")
          .outdent
          .add("}")
          .add("map")
      case UNION =>
        printer
          .add(s"$value match {")
          .indent
          .call(printUnionPatternMatch(_, unionSchemasToType(schemas(schema))))
          .outdent
          .add("}")
      case ARRAY =>
        printer
          .call(printArrayValue(_, schema, Some("kvp._2")))
      case BYTES =>
        printer
          .add(s"java.nio.ByteBuffer.wrap($value)")
      case _ =>
        printer
          .add(value)
    }
  }

  private def printUnionPatternMatch(printer: FunctionalPrinter, union: UnionRepresentation): FunctionalPrinter = {
    def x(schema: Schema): String = {
      schema.getType match {
        case MAP => s"\n${printMapValue(new FunctionalPrinter(indentLevel = 1), schema, Some("x")).result()}"
        case UNION => s"\n${printUnionPatternMatch(new FunctionalPrinter(indentLevel = 1), unionSchemasToType(schemas(schema))).result()}"
        case ARRAY if schema.getElementType.isUnion => s"\nscala.jdk.CollectionConverters.BufferHasAsJava({\n  x.map {${x(schema.getElementType)}\n  }\n}.toBuffer).asJava.asInstanceOf[AnyRef]"
        case ARRAY => s"\nscala.jdk.CollectionConverters.BufferHasAsJava({\n  x.map { x =>${x(schema.getElementType)}\n  }\n}.toBuffer).asJava.asInstanceOf[AnyRef]"
        case BYTES => s"\njava.nio.ByteBuffer.wrap(x).asInstanceOf[AnyRef]"
        case _ => "x.asInstanceOf[AnyRef]"
      }
    }

    union match {
      case TypeUnionRepresentation(types) =>
        printer.add({
          types.map {
            case t if t.getType != NULL => s"case x: ${schemaToScalaType(t)} => ${x(t)}"
            case _ => s"case null => null.asInstanceOf[AnyRef]"
          } :+ "case _ => throw new AvroRuntimeException(\"Invalid value\")"
        }.mkString("\n"))
      case OptionRepresentation(schema) =>
        printer.add(
          s"""case None => null
             |case Some(x) => ${x(schema)}""".stripMargin)
    }
  }
}
