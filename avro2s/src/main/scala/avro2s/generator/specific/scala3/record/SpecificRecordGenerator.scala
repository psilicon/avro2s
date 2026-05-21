package avro2s.generator.specific.scala3.record

import avro2s.generator.logical.LogicalTypes
import avro2s.generator.logical.LogicalTypes.LogicalTypeConverter
import avro2s.generator.specific.scala3.FieldOps._
import avro2s.generator.specific.{ScalaSpecificDataGenerator, SchemaLiteral}
import avro2s.generator.{EnumType, FunctionalPrinter, GeneratedCode, GeneratorConfig}
import org.apache.avro.Schema
import org.apache.avro.Schema.Type._

import scala.jdk.CollectionConverters._

private[avro2s] class SpecificRecordGenerator(generatorConfig: GeneratorConfig) {
  private val dollar = "$"
  private val ltc = LogicalTypeConverter(if (generatorConfig.logicalTypesEnabled) LogicalTypes.logicalTypeMap else Map.empty)
  private val getCaseGenerator = new GetCaseGenerator(ltc)
  private val putCaseGenerator = new PutCaseGenerator(ltc)
  private val typeHelpers = new TypeHelpers(ltc)
  import typeHelpers._

  private val usesScalaEnums: Boolean = generatorConfig.enumType match {
    case Some(EnumType.ScalaADT) | Some(EnumType.Scala3Enum) => true
    case _ => false
  }

  def schemaToScala3Record(schema: Schema, namespace: Option[String]): GeneratedCode = {
    val name = schema.getName
    val fields = schema.getFields.asScala.toList
    val ns = Option(schema.getNamespace).orElse(namespace)
    val nsString = ns.getOrElse("")
    val distinctConversions =
      if (!generatorConfig.logicalTypesEnabled) Nil
      else fields.flatMap(f => ltc.collectConversionClasses(f.schema())).distinct
    val recordHasEnum = usesScalaEnums && recordReferencesEnum(schema)
    val needsModel = distinctConversions.nonEmpty || recordHasEnum

    val functionalPrinter = new FunctionalPrinter()

    val code = functionalPrinter
      .add("/** GENERATED CODE */")
      .newline
      .when(ns.isDefined)(_.add(s"package $nsString"))
      .newline
      .add("import scala.annotation.switch")
      .newline
      .add(s"case class $name(${fieldsToParams(fields)}) extends org.apache.avro.specific.SpecificRecordBase {")
      .indent
      .when(schema.getFields.toArray.length > 0)(_.add(toThis(fields)))
      .newline
      .add(s"override def getSchema: org.apache.avro.Schema = $name.SCHEMA$dollar")
      .when(needsModel)(_.newline.add(s"override def getSpecificData(): org.apache.avro.specific.SpecificData = $name.MODEL$dollar"))
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
      .add(s"val SCHEMA$dollar: org.apache.avro.Schema = ${SchemaLiteral.parseExpression(schema.toString)}")
      .call(printModelInfrastructure(_, distinctConversions, recordHasEnum))
      .outdent
      .add("}")

    GeneratedCode(s"${ns.map(_.replace(".", "/") + "/").getOrElse("") + name}.scala", code.result())
  }

  private def recordReferencesEnum(schema: Schema): Boolean = {
    def refs(s: Schema): Boolean = s.getType match {
      case ENUM => true
      case UNION => s.getTypes.asScala.exists(refs)
      case ARRAY => refs(s.getElementType)
      case MAP => refs(s.getValueType)
      case _ => false
    }
    schema.getFields.asScala.exists(f => refs(f.schema()))
  }

  private def printGetConversion(printer: FunctionalPrinter, name: String, fields: List[Schema.Field]): FunctionalPrinter = {
    if (!generatorConfig.logicalTypesEnabled) printer
    else {
      val hasAnyConversion = fields.exists(f => ltc.logicalTypeInUse(f.schema()))
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

  private def printModelInfrastructure(printer: FunctionalPrinter, distinctConversions: List[String], recordHasEnum: Boolean): FunctionalPrinter = {
    if (distinctConversions.isEmpty && !recordHasEnum) printer
    else {
      val baseCtor =
        if (recordHasEnum) s"new ${ScalaSpecificDataGenerator.FullClassName}()"
        else "new org.apache.avro.specific.SpecificData()"

      val withVals = distinctConversions.foldLeft(printer) { (p, cls) =>
        val shortName = cls.split('.').last
        p.add(s"val $dollar$shortName: org.apache.avro.Conversion[?] = new $cls()")
      }

      val modelBlock = withVals
        .add(s"val MODEL$dollar: org.apache.avro.specific.SpecificData = {")
        .indent
        .add(s"val model = $baseCtor")

      val withConversions = distinctConversions.foldLeft(modelBlock) { (p, cls) =>
        val shortName = cls.split('.').last
        p.add(s"model.addLogicalTypeConversion($dollar$shortName)")
      }

      withConversions
        .add("model")
        .outdent
        .add("}")
    }
  }

  private def fieldsToParams(fields: List[Schema.Field]): String = {
    fields.map { field =>
      s"var ${field.safeName}: ${schemaToScalaType(field.schema, true)}"
    }.mkString(", ")
  }

  private def toThis(fields: List[Schema.Field]): String = {
    def defaultForType(schema: Schema): String = schema.getType match {
      case INT | LONG | FLOAT | DOUBLE => "0"
      case BOOLEAN => "false"
      case STRING => "\"\""
      case BYTES => "Array[Byte]()"
      case RECORD | FIXED => s"new ${schema.getFullName}()"
      case ARRAY => "List.empty"
      case MAP => "Map.empty"
      case UNION =>
        val types = schema.getTypes.asScala.toList
        if (!types.exists(_.getType == NULL)) logical(schema).getOrElse(defaultForType(types.head))
        else "None"
      case _ => "null"
    }

    def logical(schema: Schema): Option[String] = {
      if (ltc.logicalTypeInUse(schema)) {
        Some(ltc.getDefault(schema))
      } else None
    }

    s"def this() = this(${fields.map(f => logical(f.schema()).getOrElse(defaultForType(f.schema()))).mkString(", ")})"
  }
}
