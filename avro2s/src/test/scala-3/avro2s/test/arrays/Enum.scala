/** GENERATED CODE */

package avro2s.test.arrays


enum Enum extends org.apache.avro.generic.GenericEnumSymbol[Enum] {
  case A, B, C

  override def getSchema: org.apache.avro.Schema = Enum.SCHEMA$
  override def compareTo(that: Enum): Int = this.ordinal.compareTo(that.ordinal)
}

object Enum {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"Enum\",\"namespace\":\"avro2s.test.arrays\",\"symbols\":[\"A\",\"B\",\"C\"]}")

  def getClassSchema: org.apache.avro.Schema = SCHEMA$

  def fromString(value: String): Enum = valueOf(value)
}