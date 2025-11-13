/** GENERATED CODE */

package avro2s.test.unions


sealed abstract class EnumForComplexOptions(val value: String, val ordinal: Int) extends org.apache.avro.generic.GenericEnumSymbol[EnumForComplexOptions] {
  override def getSchema: org.apache.avro.Schema = EnumForComplexOptions.SCHEMA$
  override def compareTo(that: EnumForComplexOptions): Int = this.ordinal.compareTo(that.ordinal)
}

object EnumForComplexOptions {
  case object A extends EnumForComplexOptions("A", 0)
  case object B extends EnumForComplexOptions("B", 1)
  case object C extends EnumForComplexOptions("C", 2)

  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"EnumForComplexOptions\",\"namespace\":\"avro2s.test.unions\",\"symbols\":[\"A\",\"B\",\"C\"]}")

  def getClassSchema: org.apache.avro.Schema = SCHEMA$

  def fromString(value: String): EnumForComplexOptions = value match {
    case "A" => A
    case "B" => B
    case "C" => C
    case other => throw new IllegalArgumentException(s"Unknown enum value: $other")
  }

  def valueOf(value: String): EnumForComplexOptions = fromString(value)

  val values: Seq[EnumForComplexOptions] = Seq(A, B, C)
}