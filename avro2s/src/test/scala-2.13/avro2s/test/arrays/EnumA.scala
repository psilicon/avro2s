/** GENERATED CODE */

package avro2s.test.arrays


sealed abstract class EnumA(val value: String, val ordinal: Int) extends org.apache.avro.generic.GenericEnumSymbol[EnumA] {
  override def getSchema: org.apache.avro.Schema = EnumA.SCHEMA$
  override def compareTo(that: EnumA): Int = this.ordinal.compareTo(that.ordinal)
}

object EnumA {
  case object A extends EnumA("A", 0)
  case object B extends EnumA("B", 1)
  case object C extends EnumA("C", 2)

  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"EnumA\",\"namespace\":\"avro2s.test.arrays\",\"symbols\":[\"A\",\"B\",\"C\"]}")

  def getClassSchema: org.apache.avro.Schema = SCHEMA$

  def fromString(value: String): EnumA = value match {
    case "A" => A
    case "B" => B
    case "C" => C
    case other => throw new IllegalArgumentException(s"Unknown enum value: $other")
  }

  def valueOf(value: String): EnumA = fromString(value)

  val values: Seq[EnumA] = Seq(A, B, C)
}