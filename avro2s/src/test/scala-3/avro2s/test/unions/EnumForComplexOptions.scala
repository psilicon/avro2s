/** GENERATED CODE */

package avro2s.test.unions


enum EnumForComplexOptions extends org.apache.avro.generic.GenericEnumSymbol[EnumForComplexOptions] {
  case A, B, C

  override def getSchema: org.apache.avro.Schema = EnumForComplexOptions.SCHEMA$
  override def compareTo(that: EnumForComplexOptions): Int = this.ordinal.compareTo(that.ordinal)
}

object EnumForComplexOptions {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"EnumForComplexOptions\",\"namespace\":\"avro2s.test.unions\",\"symbols\":[\"A\",\"B\",\"C\"]}")

  def getClassSchema: org.apache.avro.Schema = SCHEMA$

  def fromString(value: String): EnumForComplexOptions = valueOf(value)
}