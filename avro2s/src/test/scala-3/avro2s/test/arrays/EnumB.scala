/** GENERATED CODE */

package avro2s.test.arrays


enum EnumB extends org.apache.avro.generic.GenericEnumSymbol[EnumB] {
  case A, B, C

  override def getSchema: org.apache.avro.Schema = EnumB.SCHEMA$
  override def compareTo(that: EnumB): Int = this.ordinal.compareTo(that.ordinal)
}

object EnumB {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"EnumB\",\"namespace\":\"avro2s.test.arrays\",\"symbols\":[\"A\",\"B\",\"C\"]}")

  def getClassSchema: org.apache.avro.Schema = SCHEMA$

  def fromString(value: String): EnumB = valueOf(value)
}