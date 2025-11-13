/** GENERATED CODE */

package avro2s.test.maps


sealed abstract class Enum(val value: String, val ordinal: Int) extends org.apache.avro.generic.GenericEnumSymbol[Enum] {
  override def getSchema: org.apache.avro.Schema = Enum.SCHEMA$
  override def compareTo(that: Enum): Int = this.ordinal.compareTo(that.ordinal)
}

object Enum {
  case object A extends Enum("A", 0)
  case object B extends Enum("B", 1)
  case object C extends Enum("C", 2)

  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"Enum\",\"namespace\":\"avro2s.test.maps\",\"symbols\":[\"A\",\"B\",\"C\"]}")

  def getClassSchema: org.apache.avro.Schema = SCHEMA$

  def fromString(value: String): Enum = value match {
    case "A" => A
    case "B" => B
    case "C" => C
    case other => throw new IllegalArgumentException(s"Unknown enum value: $other")
  }

  def valueOf(value: String): Enum = fromString(value)

  val values: Seq[Enum] = Seq(A, B, C)
}