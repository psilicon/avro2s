package avro2s.generator.specific

private[specific] object SchemaLiteral {
  private val MaxLiteralSize = 65000
  private val tq = "\"\"\""

  def parseExpression(schemaJson: String): String =
    if (schemaJson.length <= MaxLiteralSize)
      s"new org.apache.avro.SchemaParser().parse($tq$schemaJson$tq).mainSchema()"
    else {
      val chunks = schemaJson.grouped(MaxLiteralSize).toList
      val chunkLiterals = chunks
        .map(c => s"    $tq$c$tq")
        .mkString(",\n")
      s"new org.apache.avro.SchemaParser().parse(Array(\n$chunkLiterals).mkString).mainSchema()"
    }
}
