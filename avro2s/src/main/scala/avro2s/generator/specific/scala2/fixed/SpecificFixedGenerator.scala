package avro2s.generator.specific.scala2.fixed

import avro2s.generator.{FunctionalPrinter, GeneratedCode}

object SpecificFixedGenerator {
  val dollar = "$"

  def schemaToScala2Fixed(schema: org.apache.avro.Schema, namespace: Option[String]): GeneratedCode = {
    val name = schema.getName
    val printer = new FunctionalPrinter()
    val ns = Option(schema.getNamespace).orElse(namespace)
    val nsString = ns.getOrElse("")

    val code = printer
      .add("/** GENERATED CODE */")
      .newline
      .when(ns.isDefined)(_.add(s"package $nsString"))
      .newline
      .add(s"case class $name() extends org.apache.avro.specific.SpecificFixed {")
      .indent
      .add(s"override def getSchema: org.apache.avro.Schema = $name.SCHEMA$dollar")
      .add("override def readExternal(in: java.io.ObjectInput): Unit = {")
      .indent
      .add(s"$nsString.$name.READER$$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))")
      .add("()")
      .outdent
      .add("}")
      .add("override def writeExternal(out: java.io.ObjectOutput): Unit = {")
      .indent
      .add(s"$nsString.$name.WRITER$$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))")
      .outdent
      .add("}")
      .outdent
      .add("}")
      .newline
      .add(s"object $name {")
      .indent
      .add(s"""val SCHEMA$$ = new org.apache.avro.Schema.Parser().parse(\"\"\"${schema.toString}\"\"\")""")
      .add(s"val READER$$ = new org.apache.avro.specific.SpecificDatumReader[$name]($name.SCHEMA$$)")
      .add(s"val WRITER$$ = new org.apache.avro.specific.SpecificDatumWriter[$name]($name.SCHEMA$$)")
      .add(s"def apply(data: Array[Byte]): $name = {")
      .indent
      .add(s"val fixed = new $nsString.$name()")
      .add(s"fixed.bytes(data)")
      .add(s"fixed")
      .outdent
      .add("}")
      .outdent
      .add("}")

    GeneratedCode(s"${ns.map(_.replace(".", "/") + "/").getOrElse("") + name}.scala", code.result())
  }
}
