package avro2s.generator

/** Renders Avro documentation as source comments, omitting absent or blank docs. */
private[avro2s] object Scaladoc {
  def print(
    printer: FunctionalPrinter,
    doc: String,
    params: List[(String, String)] = Nil
  ): FunctionalPrinter = {
    val description = lines(doc)
    val parameters = params.flatMap { case (name, fieldDoc) =>
      lines(fieldDoc) match {
        case head :: tail => s"@param $name $head" :: tail.map("  " + _)
        case Nil => Nil
      }
    }
    val content = description :::
      (if (description.nonEmpty && parameters.nonEmpty) List("") else Nil) ::: parameters

    if (content.isEmpty) printer
    else printer.add("/**").print(content) { (p, line) =>
      p.add(if (line.isEmpty) " *" else s" * $line")
    }.add(" */")
  }

  private def lines(doc: String): List[String] =
    Option(doc).filter(_.trim.nonEmpty).map { text =>
      // Escape backslashes too: Unicode escapes are processed before source comments.
      text.replace("\\", "&#92;")
        .replace("/*", "/&#42;")
        .replace("*/", "&#42;/")
        .replace("\r\n", "\n").replace('\r', '\n')
        .split("\n", -1).toList
    }.getOrElse(Nil)
}
