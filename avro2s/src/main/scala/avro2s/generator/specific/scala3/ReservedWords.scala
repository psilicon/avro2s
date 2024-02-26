package avro2s.generator.specific.scala3

import avro2s.generator.specific.scala2

private[avro2s] object ReservedWords {
  /*
   * I haven't found a complete list so I'm using scala 2 reserved words plus those mentioned in the migration guide:
   * https://docs.scala-lang.org/scala3/guides/migration/incompat-syntactic.html#restricted-keywords
   */
  def set: Set[String] = scala2.ReservedWords.set ++ Set(
    "enum", "export", "given", "then"
  )
}
