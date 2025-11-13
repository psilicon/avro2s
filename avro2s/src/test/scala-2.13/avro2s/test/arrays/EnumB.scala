/** GENERATED CODE */

package avro2s.test.arrays


sealed abstract class EnumB(val value: String, val ordinal: Int) extends org.apache.avro.generic.GenericEnumSymbol[EnumB] {
  override def getSchema: org.apache.avro.Schema = EnumB.SCHEMA$
  override def compareTo(that: EnumB): Int = this.ordinal.compareTo(that.ordinal)
}

object EnumB {
  case object A extends EnumB("A", 0)
  case object B extends EnumB("B", 1)
  case object C extends EnumB("C", 2)

  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"EnumB\",\"namespace\":\"avro2s.test.arrays\",\"symbols\":[\"A\",\"B\",\"C\"]}")

  def getClassSchema: org.apache.avro.Schema = SCHEMA$

  def fromString(value: String): EnumB = value match {
    case "A" => A
    case "B" => B
    case "C" => C
    case other => throw new IllegalArgumentException(s"Unknown enum value: $other")
  }

  def valueOf(value: String): EnumB = fromString(value)

  val values: Seq[EnumB] = Seq(A, B, C)
}