package avro2s.generator.specific.scala3.record

import avro2s.generator.{EnumType, FunctionalPrinter, GeneratorConfig}
import avro2s.generator.logical.LogicalTypes
import avro2s.generator.logical.LogicalTypes.LogicalTypeConverter
import org.apache.avro.Schema
import org.apache.avro.Schema.Type._

import scala.collection.mutable
import scala.jdk.CollectionConverters._

/** Generates only calls to Apache Avro and the standard library; no avro2s runtime is needed.
  * Helpers are shared within a record by schema identity, including recursive records. Keeping
  * collection loops in separate methods also avoids inflating the top-level coder methods.
  */
private[avro2s] final class CustomCoderGenerator(root: Schema, config: GeneratorConfig) {
  private val nativeEnums = config.enumType == EnumType.ScalaEnum
  private val ltc = LogicalTypeConverter(if (config.logicalTypesEnabled) LogicalTypes.logicalTypeMap else Map.empty)
  private val owner = s"_root_.${root.getFullName}"
  private val encoder = "_root_.org.apache.avro.io.Encoder"
  private val decoder = "_root_.org.apache.avro.io.ResolvingDecoder"
  private val nodes = mutable.ArrayBuffer.empty[(Schema, String)]
  private val ids = new java.util.IdentityHashMap[Schema, java.lang.Integer]()

  private def register(schema: Schema, path: String): Unit = {
    if (!ids.containsKey(schema)) {
      ids.put(schema, nodes.size)
      nodes += ((schema, path))
      schema.getType match {
        case RECORD => schema.getFields.asScala.foreach(f => register(f.schema(), s"$path.getFields.get(${f.pos()}).schema()"))
        case ARRAY => register(schema.getElementType, s"$path.getElementType")
        case MAP => register(schema.getValueType, s"$path.getValueType")
        case UNION => schema.getTypes.asScala.zipWithIndex.foreach { case (s, i) => register(s, s"$path.getTypes.get($i)") }
        case _ => ()
      }
    }
  }
  register(root, "SCHEMA$")

  private def id(schema: Schema): Int = ids.get(schema).intValue()
  private def encode(schema: Schema, value: String): String = s"encode$$${id(schema)}($value, out$$)"
  private def decode(schema: Schema, reuse: String = "null"): String =
    if (schema.getType == RECORD) s"decode$$${id(schema)}(in$$, $reuse)" else s"decode$$${id(schema)}(in$$)"
  private def fieldName(field: Schema.Field): String = s"`${field.name()}`"
  private def branches(schema: Schema): List[Schema] = schema.getTypes.asScala.toList
  private def option(schema: Schema): Boolean = {
    val ts = branches(schema)
    ts.exists(_.getType == NULL)
  }

  private def scalaType(schema: Schema): String = {
    val raw = schema.getType match {
      case RECORD | ENUM | FIXED => s"_root_.${schema.getFullName}"
      case ARRAY => s"_root_.scala.List[${scalaType(schema.getElementType)}]"
      case MAP => s"_root_.scala.collection.immutable.Map[_root_.java.lang.String, ${scalaType(schema.getValueType)}]"
      case UNION =>
        val ts = branches(schema)
        if (option(schema)) {
          val inner = ts.filterNot(_.getType == NULL).map(scalaType).mkString(" | ")
          s"_root_.scala.Option[$inner]"
        } else ts.map(scalaType).mkString(" | ")
      case BOOLEAN => "_root_.scala.Boolean"
      case INT => "_root_.scala.Int"
      case LONG => "_root_.scala.Long"
      case FLOAT => "_root_.scala.Float"
      case DOUBLE => "_root_.scala.Double"
      case STRING => "_root_.java.lang.String"
      case BYTES => "_root_.scala.Array[_root_.scala.Byte]"
      case NULL => "_root_.scala.Null"
    }
    ltc.getType(schema, raw)
  }

  def printMethods(p: FunctionalPrinter): FunctionalPrinter = {
    p.newline
      .add("override protected def hasCustomCoders(): Boolean = true")
      .add(s"override def customEncode(out$$: $encoder): Unit = ${encode(root, "this")}")
      .add(s"override def customDecode(in$$: $decoder): Unit = decodeRecord$$0(this, in$$)")
      .print(nodes.toList) { case (printer, (schema, _)) =>
        val n = id(schema)
        val reuseParameter = if (schema.getType == RECORD) s", reuse$$: ${scalaType(schema)}" else ""
        printer.newline
          .add(s"private def encode$$$n(value$$: ${scalaType(schema)}, out$$: $encoder): Unit = {")
          .indent.call(writeBody(_, schema)).outdent.add("}")
          .newline
          .add(s"private def decode$$$n(in$$: $decoder$reuseParameter): ${scalaType(schema)} = {")
          .indent.call(readBody(_, schema)).outdent.add("}")
          .when(schema.getType == RECORD)(printRecordDecoder(_, schema))
      }
  }

  def printCompanion(p: FunctionalPrinter): FunctionalPrinter = p.print(nodes.toList) { case (printer, (schema, path)) =>
    val n = id(schema)
    val withSchema = if (schema.getType == ENUM || ltc.logicalTypeInUse(schema))
      printer.add(s"private val customSchema$$$n: _root_.org.apache.avro.Schema = $path") else printer
    val withConversion = ltc.getConversionClass(schema).fold(withSchema) { cls =>
      withSchema.add(s"private val customConversion$$$n = new _root_.$cls()")
    }
    if (schema.getType != ENUM) withConversion
    else {
      val lookup = if (nativeEnums) "fromAvroSymbol" else "valueOf"
      withConversion
        .add(s"private val customEnum$$$n: _root_.scala.Array[${scalaType(schema)}] = {")
        .indent
        .add(s"val result$$ = new _root_.scala.Array[${scalaType(schema)}](customSchema$$$n.getEnumSymbols.size())")
        .add("var i$ = 0")
        .add("while (i$ < result$.length) {").indent
        .add(s"result$$(i$$) = _root_.${schema.getFullName}.$lookup(customSchema$$$n.getEnumSymbols.get(i$$))")
        .add("i$ += 1").outdent.add("}")
        .add("result$").outdent.add("}")
    }
  }

  private def conversionSuffix(schema: Schema): String = schema.getType match {
    case STRING => "CharSequence"
    case INT => "Int"
    case LONG => "Long"
    case other => throw new IllegalArgumentException(s"Unsupported custom coder logical storage: $other")
  }

  private def writeBody(p: FunctionalPrinter, schema: Schema): FunctionalPrinter = {
    val n = id(schema)
    val logical = ltc.logicalTypeInUse(schema)
    val value = if (logical) "raw$" else "value$"
    val start = if (logical) p.add(s"val raw$$ = $owner.customConversion$$$n.to${conversionSuffix(schema)}(value$$, $owner.customSchema$$$n, $owner.customSchema$$$n.getLogicalType)") else p
    schema.getType match {
      case NULL => start.add("out$.writeNull()")
      case BOOLEAN => start.add(s"out$$.writeBoolean($value)")
      case INT => start.add(s"out$$.writeInt($value)")
      case LONG => start.add(s"out$$.writeLong($value)")
      case FLOAT => start.add(s"out$$.writeFloat($value)")
      case DOUBLE => start.add(s"out$$.writeDouble($value)")
      case STRING => start.add(s"out$$.writeString($value)")
      case BYTES => start.add("out$.writeBytes(value$)")
      case FIXED => start.add(s"out$$.writeFixed(value$$.bytes(), 0, ${schema.getFixedSize})")
      case ENUM => start.add(if (nativeEnums) s"out$$.writeEnum($owner.customSchema$$$n.getEnumOrdinal(value$$.toString))" else "out$.writeEnum(value$.ordinal())")
      case RECORD => start.print(schema.getFields.asScala.toList) { (printer, field) =>
        printer.add(encode(field.schema(), s"value$$.${fieldName(field)}"))
      }
      case ARRAY => start
        .add("out$.writeArrayStart()", "out$.setItemCount(value$.size.toLong)", "var remaining$ = value$")
        .add("while (remaining$.nonEmpty) {").indent
        .add("out$.startItem()", encode(schema.getElementType, "remaining$.head"), "remaining$ = remaining$.tail")
        .outdent.add("}", "out$.writeArrayEnd()")
      case MAP => start
        .add("out$.writeMapStart()", "out$.setItemCount(value$.size.toLong)", "val entries$ = value$.iterator")
        .add("while (entries$.hasNext) {").indent
        .add("val entry$ = entries$.next()", "out$.startItem()", "out$.writeString(entry$._1)", encode(schema.getValueType, "entry$._2"))
        .outdent.add("}", "out$.writeMapEnd()")
      case UNION => printUnionWriter(start, schema)
    }
  }

  private def readBody(p: FunctionalPrinter, schema: Schema): FunctionalPrinter = {
    val n = id(schema)
    if (ltc.logicalTypeInUse(schema)) {
      val read = schema.getType match {
        case STRING => "in$.readString()"
        case INT => "in$.readInt()"
        case LONG => "in$.readLong()"
        case other => throw new IllegalArgumentException(s"Unsupported custom coder logical storage: $other")
      }
      return p.add(s"$owner.customConversion$$$n.from${conversionSuffix(schema)}($read, $owner.customSchema$$$n, $owner.customSchema$$$n.getLogicalType)")
    }
    schema.getType match {
      case NULL => p.add("in$.readNull()", "null")
      case BOOLEAN => p.add("in$.readBoolean()")
      case INT => p.add("in$.readInt()")
      case LONG => p.add("in$.readLong()")
      case FLOAT => p.add("in$.readFloat()")
      case DOUBLE => p.add("in$.readDouble()")
      case STRING => p.add("in$.readString()")
      case BYTES => p.add("val buffer$ = in$.readBytes(null)")
        .add("if (buffer$.hasArray && buffer$.arrayOffset() == 0 && buffer$.position() == 0 && buffer$.remaining() == buffer$.array().length) buffer$.array()")
        .add("else {").indent
        .add("val bytes$ = new _root_.scala.Array[Byte](buffer$.remaining())", "buffer$.get(bytes$)", "bytes$")
        .outdent.add("}")
      case FIXED => p.add(s"val result$$ = new ${scalaType(schema)}()", "in$.readFixed(result$.bytes())", "result$")
      case ENUM => p.add(s"$owner.customEnum$$$n(in$$.readEnum())")
      case RECORD => p.add(s"val result$$ = if (reuse$$ == null) new ${scalaType(schema)}() else reuse$$", s"decodeRecord$$$n(result$$, in$$)", "result$")
      case ARRAY | MAP =>
        val array = schema.getType == ARRAY
        val element = if (array) schema.getElementType else schema.getValueType
        val builder = if (array) s"_root_.scala.List.newBuilder[${scalaType(element)}]"
          else s"_root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, ${scalaType(element)}]"
        val kind = if (array) "Array" else "Map"
        val empty = if (array) "_root_.scala.Nil" else "_root_.scala.collection.immutable.Map.empty"
        p.add(s"var count$$ = in$$.read${kind}Start()", s"if (count$$ == 0L) $empty else {").indent
          .add(s"val result$$ = $builder", "while (count$ != 0L) {").indent
          .add("while (count$ > 0L) {").indent
          .when(!array)(_.add("val key$ = in$.readString()"))
          .add(if (array) s"result$$ += ${decode(element)}" else s"result$$ += ((key$$, ${decode(element)}))")
          .add("count$ -= 1L").outdent.add("}")
          .add(s"count$$ = in$$.${kind.toLowerCase}Next()")
          .outdent.add("}", "result$.result()").outdent.add("}")
      case UNION =>
        p.add("in$.readIndex() match {").indent
          .print(branches(schema).zipWithIndex) { case (printer, (branch, index)) =>
            val result = if (option(schema)) {
              if (branch.getType == NULL) s"{ ${decode(branch)}; _root_.scala.None }" else s"_root_.scala.Some(${decode(branch)})"
            } else decode(branch)
            printer.add(s"case $index => $result")
          }
          .add("case index$ => throw new _root_.org.apache.avro.AvroTypeException(\"Invalid union index: \" + index$)")
          .outdent.add("}")
    }
  }

  private def printUnionWriter(p: FunctionalPrinter, schema: Schema): FunctionalPrinter = {
    // Avro allows only one array/map branch, so erased collection type tests are sufficient.
    // Widen the scrutinee to retain an explicit rejection of invalid null values.
    p.add("(value$: Any) match {").indent
      .print(branches(schema).zipWithIndex) { case (printer, (branch, index)) =>
        val pattern = if (option(schema)) {
          if (branch.getType == NULL) "_root_.scala.None"
          else s"_root_.scala.Some(branch$$: (${scalaType(branch)} @unchecked))"
        } else s"branch$$: (${scalaType(branch)} @unchecked)"
        val value = if (branch.getType == NULL) "null" else "branch$"
        printer.add(s"case $pattern =>").indent
          .add(s"out$$.writeIndex($index)", encode(branch, value)).outdent
      }
      .add("case _ => throw new _root_.org.apache.avro.AvroTypeException(\"Invalid union value\")")
      .outdent.add("}")
  }

  private def printRecordDecoder(p: FunctionalPrinter, schema: Schema): FunctionalPrinter = {
    val fields = schema.getFields.asScala.toList
    def assign(field: Schema.Field): String = s"value$$.${fieldName(field)} = ${decode(field.schema(), s"value$$.${fieldName(field)}")}"
    p.newline
      .add(s"private def decodeRecord$$${id(schema)}(value$$: ${scalaType(schema)}, in$$: $decoder): Unit = {")
      .indent.add("val order$ = in$.readFieldOrderIfDiff()")
      .add("if (order$ == null) {").indent
      .print(fields)((printer, field) => printer.add(assign(field)))
      .outdent.add("} else {").indent
      .add("var i$ = 0", "while (i$ < order$.length) {").indent
      .add("(order$(i$).pos(): @_root_.scala.annotation.switch) match {").indent
      .print(fields)((printer, field) => printer.add(s"case ${field.pos()} => ${assign(field)}"))
      .add("case index$ => throw new _root_.org.apache.avro.AvroTypeException(\"Invalid field index: \" + index$)")
      .outdent.add("}", "i$ += 1").outdent.add("}").outdent.add("}").outdent.add("}")
  }
}
