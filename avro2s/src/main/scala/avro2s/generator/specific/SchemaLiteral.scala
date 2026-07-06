package avro2s.generator.specific

private[specific] object SchemaLiteral {
  private val MaxLiteralBytes = 65000
  private val tq = "\"\"\""

  def parseExpression(schemaJson: String): String = {
    val chunks = splitLiteral(schemaJson)
    if (chunks.size == 1)
      s"new org.apache.avro.Schema.Parser().parse($tq$schemaJson$tq)"
    else {
      val chunkLiterals = chunks
        .map(c => s"    $tq$c$tq")
        .mkString(",\n")
      s"new org.apache.avro.Schema.Parser().parse(Array(\n$chunkLiterals).mkString)"
    }
  }

  private def splitLiteral(value: String): List[String] = {
    val chunks = List.newBuilder[String]
    var start = 0
    var offset = 0
    var bytes = 0
    while (offset < value.length) {
      val point = value.codePointAt(offset)
      val width =
        if (point >= 1 && point <= 0x7f) 1
        else if (point <= 0x7ff) 2
        else if (point <= 0xffff) 3
        else 6
      if (bytes + width > MaxLiteralBytes) {
        chunks += value.substring(start, offset)
        start = offset
        bytes = 0
      }
      bytes += width
      offset += Character.charCount(point)
    }
    chunks += value.substring(start)
    chunks.result()
  }
}
