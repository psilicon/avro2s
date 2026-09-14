package avro2s.generator.specific.scala2.enumeration

import avro2s.generator.{FunctionalPrinter, GeneratedCode, Scaladoc}

private[avro2s] object PackageObjectGenerator {
  def forNamespace(namespace: String, enumSchemas: List[org.apache.avro.Schema]): GeneratedCode = {
    val segments = namespace.split('.').toList
    val parent = segments.init.mkString(".")
    val leaf = segments.last

    val printer = new FunctionalPrinter()
      .add("/** GENERATED CODE */")
      .newline

    val withParent = if (parent.nonEmpty) printer.add(s"package $parent").newline else printer

    val code = withParent
      .add(s"package object $leaf {")
      .indent
      .print(enumSchemas.sortBy(_.getName)) { (p, s) =>
        val name = s.getName
        p
          .call(Scaladoc.print(_, s.getDoc))
          .add(s"type $name = _root_.$namespace.internal.$name")
          .call(Scaladoc.print(_, s.getDoc))
          .add(s"val $name: _root_.$namespace.internal.$name.type = _root_.$namespace.internal.$name")
      }
      .outdent
      .add("}")

    GeneratedCode(s"${namespace.replace(".", "/")}/package.scala", code.result())
  }
}
