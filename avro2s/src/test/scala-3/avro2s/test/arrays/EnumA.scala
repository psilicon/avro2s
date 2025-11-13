/** GENERATED CODE */

package avro2s.test.arrays


enum EnumA extends org.apache.avro.generic.GenericEnumSymbol[EnumA] {
  case A, B, C

  override def getSchema: org.apache.avro.Schema = EnumA.SCHEMA$
  override def compareTo(that: EnumA): Int = this.ordinal.compareTo(that.ordinal)
}

object EnumA {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"EnumA\",\"namespace\":\"avro2s.test.arrays\",\"symbols\":[\"A\",\"B\",\"C\"]}")

  def getClassSchema: org.apache.avro.Schema = SCHEMA$

  def fromString(value: String): EnumA = valueOf(value)
}