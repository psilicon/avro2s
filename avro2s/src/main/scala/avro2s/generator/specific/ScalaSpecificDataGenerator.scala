package avro2s.generator.specific

import avro2s.generator.{FunctionalPrinter, GeneratedCode}

/**
 * Generator for the ScalaSpecificData class that handles Scala enum deserialization.
 * This class is generated as part of the user's codebase when Scala enums are configured,
 * avoiding a runtime dependency on avro2s.
 */
private[avro2s] object ScalaSpecificDataGenerator {
  
  val Namespace = "avro2s.generated"
  val ClassName = "ScalaSpecificData"
  val FullClassName = s"$Namespace.$ClassName"

  def generate(): GeneratedCode = {
    val printer = new FunctionalPrinter()

    val code = printer
      .add("/** GENERATED CODE */")
      .newline
      .add(s"package $Namespace")
      .newline
      .add("import org.apache.avro.Schema")
      .add("import org.apache.avro.specific.SpecificData")
      .newline
      .add("/**")
      .add(" * Custom SpecificData implementation that handles Scala enums (both sealed ADTs and Scala 3 enums)")
      .add(" * in addition to standard Java enums.")
      .add(" *")
      .add(" * This class overrides the createEnum method to support Scala enums that have a companion object")
      .add(" * with a fromString method.")
      .add(" */")
      .add(s"class $ClassName extends SpecificData {")
      .indent
      .newline
      .add("override def createEnum(symbol: String, schema: Schema): AnyRef = {")
      .indent
      .add("try {")
      .indent
      .add("val enumClass = getClass(schema)")
      .newline
      .add("// Try to get the companion object's fromString method for Scala enums")
      .add("val companionClassName = enumClass.getName + \"$\"")
      .add("try {")
      .indent
      .add("val companionClass = Class.forName(companionClassName, true, enumClass.getClassLoader)")
      .add("val companionModule = companionClass.getField(\"MODULE$\").get(null)")
      .add("val fromStringMethod = companionClass.getMethod(\"fromString\", classOf[String])")
      .add("fromStringMethod.invoke(companionModule, symbol).asInstanceOf[AnyRef]")
      .outdent
      .add("} catch {")
      .indent
      .add("case _: ClassNotFoundException | _: NoSuchMethodException | _: NoSuchFieldException =>")
      .indent
      .add("// If companion object or fromString method not found, fall back to Java enum")
      .add("super.createEnum(symbol, schema)")
      .outdent
      .outdent
      .add("}")
      .outdent
      .add("} catch {")
      .indent
      .add("case e: Exception =>")
      .indent
      .add("throw new org.apache.avro.AvroRuntimeException(s\"Failed to create enum for symbol: $symbol\", e)")
      .outdent
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

    GeneratedCode(s"${Namespace.replace(".", "/")}/$ClassName.scala", code.result())
  }
}

