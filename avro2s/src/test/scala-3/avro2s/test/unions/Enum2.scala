/** GENERATED CODE */

package avro2s.test.unions


enum Enum2 extends org.apache.avro.generic.GenericEnumSymbol[Enum2] {
  case sym3, sym4

  override def getSchema: org.apache.avro.Schema = Enum2.SCHEMA$
  override def compareTo(that: Enum2): Int = this.ordinal.compareTo(that.ordinal)
}

object Enum2 {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"Enum2\",\"namespace\":\"avro2s.test.unions\",\"symbols\":[\"sym3\",\"sym4\"]}")

  def getClassSchema: org.apache.avro.Schema = SCHEMA$

  def fromString(value: String): Enum2 = valueOf(value)
}