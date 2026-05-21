package avro2s.generator.specific

import avro2s.generator.{FunctionalPrinter, GeneratedCode}
import org.apache.avro.Schema

private[avro2s] object ScalaSpecificDataGenerator {

  val Namespace = "avro2s.generated"
  val ClassName = "ScalaSpecificData"
  val FullClassName = s"$Namespace.$ClassName"

  def generate(enumSchemas: List[Schema]): GeneratedCode = {
    val printer = new FunctionalPrinter()
      .add("/** GENERATED CODE */")
      .newline
      .add(s"package $Namespace")
      .newline
      .add("import org.apache.avro.Schema")
      .add("import org.apache.avro.specific.SpecificData")
      .newline
      .add(s"class $ClassName extends SpecificData {")
      .indent
      .add("override def createEnum(symbol: String, schema: Schema): AnyRef = {")
      .indent
      .add("schema.getFullName match {")
      .indent

    val withCases = enumSchemas.foldLeft(printer) { (p, s) =>
      val fqn = s.getFullName
      p.add(s"""case "$fqn" => $fqn.fromString(symbol)""")
    }

    val code = withCases
      .add("case _ => super.createEnum(symbol, schema)")
      .outdent
      .add("}")
      .outdent
      .add("}")
      .outdent
      .add("}")
      .newline
      .add(s"object $ClassName {")
      .indent
      .add(s"private val instance = new $ClassName()")
      .newline
      .add(s"def get(): $ClassName = instance")
      .outdent
      .add("}")

    GeneratedCode(s"avro2s/generated/$ClassName.scala", code.result())
  }
}
