package avro2s.generator.specific.scala2.record

import avro2s.generator.logical.LogicalTypes
import avro2s.generator.logical.LogicalTypes.LogicalTypeConverter
import avro2s.generator.specific.scala2.FieldOps._
import avro2s.generator.{FunctionalPrinter, GeneratedCode, GeneratorConfig}
import avro2s.schema.RecordInspector
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

  def schemaToScala2Record(schema: Schema, namespace: Option[String]): GeneratedCode = {
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
      .when(RecordInspector.containsNonOptionUnion(schema))(_.add("import org.apache.avro.AvroRuntimeException").newline)
      .add("import scala.annotation.switch")
      .when(RecordInspector.containsNonOptionUnion(schema))(_.add("import shapeless.{:+:, CNil, Coproduct, Inl, Inr}"))
      .newline
      .add(s"case class $name(${fieldsToParams(fields)}) extends org.apache.avro.specific.SpecificRecordBase {")
      .indent
      .when(schema.getFields.toArray.length > 0)(_.add(toThis(fields)))
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
      .print(fields) { (printer, field) =>
        putCaseGenerator.printFieldCase(printer, fields.indexOf(field), field)
      }
      .add("case _ => throw new org.apache.avro.AvroRuntimeException(\"Bad index\")")
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
    def defaultForSchema(schema: Schema): String = schema.getType match {
      case INT | LONG | FLOAT | DOUBLE => "0"
      case BOOLEAN => "false"
      case STRING => "\"\""
      case BYTES => "Array[Byte]()"
      case RECORD | FIXED => s"new ${schema.getFullName}()"
      case ARRAY => "List.empty"
      case MAP => "Map.empty"
      case UNION if !schema.getTypes.asScala.toList.exists(_.getType == NULL) || schema.getTypes.size() > 2 =>
        val s = schema.getTypes.asScala.toList.head
        s"Inl(${logical(s).getOrElse(defaultForSchema(s))})"
      case UNION => "None"
      case _ => "null"
    }
    
    def logical(schema: Schema): Option[String] = {
      if (ltc.logicalTypeInUse(schema)) {
        Some(ltc.getDefault(schema))
      } else None
    }
    
    s"def this() = this(${
      fields.map { f =>
        logical(f.schema()).getOrElse(defaultForSchema(f.schema()))
      }.mkString(", ")
    })"
  }
}
