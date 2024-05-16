package avro2s.generator.specific.scala3.record

import avro2s.generator.logical.LogicalTypes
import avro2s.generator.logical.LogicalTypes.LogicalTypeConverter
import avro2s.generator.specific.scala3.FieldOps._
import avro2s.generator.{FunctionalPrinter, GeneratedCode, GeneratorConfig}
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

  def schemaToScala3Record(schema: Schema, namespace: Option[String]): GeneratedCode = {
    val name = schema.getName
    val fields = schema.getFields.asScala.toList
    val ns = Option(schema.getNamespace).orElse(namespace)
    val nsString = ns.getOrElse("")

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
      .add(toThis(fields))
      .newline
      .add(s"override def getSchema: org.apache.avro.Schema = $name.SCHEMA$dollar")
      .newline
      .add("override def get(field$: Int): AnyRef = {")
      .indent
      .add("(field$: @switch) match {")
      .indent
      .print(fields) { (printer, field) =>
        getCaseGenerator.printFieldCase(printer, fields.indexOf(field), field)
      }
      .add("case _ => new org.apache.avro.AvroRuntimeException(\"Bad index\")")
      .outdent
      .add("}")
      .outdent
      .add("}")
      .newline
      .add("override def put(field$: Int, value: Any): Unit = {")
      .indent
      .add("(field$: @switch) match {")
      .indent
      .print(fields) { (printer, field) =>
        putCaseGenerator.printFieldCase(printer, fields.indexOf(field), field)
      }
      .outdent
      .add("}")
      .outdent
      .add("}")
      .outdent
      .add("}")
      .newline
      .add(s"object $name {")
      .indent
      .add(s"""val SCHEMA$dollar: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse(\"\"\"${schema.toString}\"\"\")""")
      .outdent
      .add("}")

    GeneratedCode(s"${ns.map(_.replace(".", "/") + "/").getOrElse("") + name}.scala", code.result())
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
