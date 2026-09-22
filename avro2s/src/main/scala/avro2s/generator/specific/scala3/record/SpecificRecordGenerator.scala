package avro2s.generator.specific.scala3.record

import avro2s.generator.logical.LogicalTypes
import avro2s.generator.logical.LogicalTypes.LogicalTypeConverter
import avro2s.generator.specific.scala3.FieldOps._
import avro2s.generator.specific.SchemaLiteral
import avro2s.generator.{FunctionalPrinter, GeneratedCode, GeneratorConfig, Scaladoc}
import org.apache.avro.Schema
import org.apache.avro.Schema.Type._

import scala.jdk.CollectionConverters._

private[avro2s] class SpecificRecordGenerator(generatorConfig: GeneratorConfig) {
  private val dollar = "$"
  private val ltc = LogicalTypeConverter(if (generatorConfig.logicalTypesEnabled) LogicalTypes.logicalTypeMap else Map.empty)
  private val scalaEnums = generatorConfig.enumType == avro2s.generator.EnumType.ScalaEnum
  private val getCaseGenerator = new GetCaseGenerator(ltc, scalaEnums)
  private val putCaseGenerator = new PutCaseGenerator(ltc, scalaEnums)
  private val typeHelpers = new TypeHelpers(ltc)
  import typeHelpers._

  def schemaToScala3Record(schema: Schema, namespace: Option[String]): GeneratedCode = {
    val name = schema.getName
    val fields = schema.getFields.asScala.toList
    val ns = Option(schema.getNamespace).orElse(namespace)
    val nsString = ns.getOrElse("")
    // A model is emitted for any record using a logical type, and it registers nothing: generated
    // code converts in get and accepts either shape in put, so a conversion here would only decide
    // which arm of put runs. Leaving it out is not the same as emitting an empty one - with no
    // MODEL$, getSpecificData falls back to SpecificData.get(), which carries Avro's own.
    val usesLogicalTypes =
      generatorConfig.logicalTypesEnabled && fields.exists(f => ltc.usesLogicalType(f.schema()))
    val (constructor, defaultValues) = toThis(name, fields)

    val functionalPrinter = new FunctionalPrinter()

    val code = functionalPrinter
      .add("/** GENERATED CODE */")
      .newline
      .when(ns.isDefined)(_.add(s"package $nsString"))
      .newline
      .add("import scala.annotation.switch")
      .newline
      .call(Scaladoc.print(_, schema.getDoc, fields.map(f => f.name() -> f.doc())))
      .add(s"case class $name(${fieldsToParams(fields)}) extends org.apache.avro.specific.SpecificRecordBase {")
      .indent
      .when(fields.nonEmpty)(_.add(constructor))
      .newline
      .add(s"override def getSchema: org.apache.avro.Schema = $name.SCHEMA$dollar")
      .when(usesLogicalTypes)(_.newline.add(s"override def getSpecificData(): org.apache.avro.specific.SpecificData = $name.MODEL$dollar"))
      .newline
      .add("override def get(field$: Int): AnyRef = {")
      .indent
      .add("(field$: @switch) match {")
      .indent
      .print(fields.zipWithIndex) { case (printer, (field, idx)) =>
        getCaseGenerator.printFieldCase(printer, idx, field)
      }
      .add("case _ => throw new org.apache.avro.AvroRuntimeException(\"Bad index\")")
      .outdent
      .add("}")
      .outdent
      .add("}")
      .newline
      .add("override def put(field$: Int, value: Any): Unit = {")
      .indent
      .add("(field$: @switch) match {")
      .indent
      .print(fields.zipWithIndex) { case (printer, (field, idx)) =>
        putCaseGenerator.printFieldCase(printer, idx, field)
      }
      .add("case _ => throw new org.apache.avro.AvroRuntimeException(\"Bad index\")")
      .outdent
      .add("}")
      .outdent
      .add("}")
      .call(printGetConversion(_, name, fields))
      .outdent
      .add("}")
      .newline
      .add(s"object $name {")
      .indent
      .call(printConversionInfrastructure(_, usesLogicalTypes))
      .add(s"${if (scalaEnums) "@scala.annotation.static " else ""}val SCHEMA$dollar: org.apache.avro.Schema = ${SchemaLiteral.parseExpression(schema.toString)}")
      .add(defaultValues: _*)
      .outdent
      .add("}")

    GeneratedCode(s"${ns.map(_.replace(".", "/") + "/").getOrElse("") + name}.scala", code.result())
  }

  private def printGetConversion(printer: FunctionalPrinter, name: String, fields: List[Schema.Field]): FunctionalPrinter = {
    if (!generatorConfig.logicalTypesEnabled) printer
    else {
      val hasAnyConversion = fields.exists(f => ltc.getConversionClass(f.schema()).isDefined)
      if (!hasAnyConversion) printer
      else printer
        .newline
        .add("override def getConversion(field: Int): org.apache.avro.Conversion[?] = {")
        .indent
        .add("(field: @switch) match {")
        .indent
        .print(fields.zipWithIndex) { case (p, (field, idx)) =>
          ltc.getConversionClass(field.schema()) match {
            case Some(cls) =>
              val shortName = cls.split('.').last
              p.add(s"case $idx => $name.$dollar$shortName")
            case None =>
              p.add(s"case $idx => null")
          }
        }
        .add("case _ => null")
        .outdent
        .add("}")
        .outdent
        .add("}")
    }
  }

  private def printConversionInfrastructure(printer: FunctionalPrinter, usesLogicalTypes: Boolean): FunctionalPrinter =
    if (!usesLogicalTypes) printer
    // Kept a plain SpecificData rather than a subclass: FastReaderBuilder.isSupportedData tests
    // getClass equality, and a subclass silently drops every reader onto Avro's slow path.
    else printer.add(s"@scala.annotation.static val MODEL$dollar: org.apache.avro.specific.SpecificData = " +
      "new org.apache.avro.specific.SpecificData()")

  private def fieldsToParams(fields: List[Schema.Field]): String = {
    fields.map { field =>
      s"var ${field.safeName}: ${schemaToScalaType(field.schema, true)}"
    }.mkString(", ")
  }

  private def toThis(name: String, fields: List[Schema.Field]): (String, List[String]) = {
    val cachedDefaults = scala.collection.mutable.LinkedHashMap.empty[(String, String), String]

    def defaultForType(schema: Schema): String = schema.getType match {
      case INT | LONG | FLOAT | DOUBLE => "0"
      case BOOLEAN => "false"
      case STRING => "\"\""
      case BYTES => "_root_.scala.Array.emptyByteArray"
      case RECORD | FIXED => s"new ${schema.getFullName}()"
      case ARRAY => "List.empty"
      case MAP => "Map.empty"
      case UNION =>
        val types = schema.getTypes.asScala.toList
        if (!types.exists(_.getType == NULL)) logical(types.head).getOrElse(defaultForType(types.head))
        else "None"
      case _ => "null"
    }

    def logical(schema: Schema): Option[String] = {
      if (ltc.logicalTypeInUse(schema)) {
        val value = ltc.getDefault(schema)
        val scalaType = ltc.getType(schema, "")
        // Only immutable logical values may be shared by different record instances.
        Some(scalaType match {
          case "java.util.UUID" | "java.time.LocalDate" | "java.time.LocalTime" | "java.time.Instant" | "java.time.LocalDateTime" |
               "scala.math.BigDecimal" | "java.math.BigDecimal" | "org.apache.avro.util.TimePeriod" =>
            val member = cachedDefaults.getOrElseUpdate((scalaType, value), s"${dollar}default$dollar${cachedDefaults.size}")
            s"$name.$member"
          case _ => value
        })
      } else None
    }

    val constructor = s"def this() = this(${fields.map(f => logical(f.schema()).getOrElse(defaultForType(f.schema()))).mkString(", ")})"
    val defaultValues = cachedDefaults.iterator.map { case ((scalaType, value), member) =>
      s"private val $member: $scalaType = $value"
    }.toList
    (constructor, defaultValues)
  }
}
