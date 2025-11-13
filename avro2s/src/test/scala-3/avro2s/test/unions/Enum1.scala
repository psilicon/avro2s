/** GENERATED CODE */

package avro2s.test.unions


enum Enum1 extends org.apache.avro.generic.GenericEnumSymbol[Enum1] {
  case sym1, sym2

  override def getSchema: org.apache.avro.Schema = Enum1.SCHEMA$
  override def compareTo(that: Enum1): Int = this.ordinal.compareTo(that.ordinal)
}

object Enum1 {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"Enum1\",\"namespace\":\"avro2s.test.unions\",\"symbols\":[\"sym1\",\"sym2\"]}")

  def getClassSchema: org.apache.avro.Schema = SCHEMA$

  def fromString(value: String): Enum1 = valueOf(value)
}