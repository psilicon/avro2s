/** GENERATED CODE */

package avro2s.test.unions


sealed abstract class Enum1(val value: String, val ordinal: Int) extends org.apache.avro.generic.GenericEnumSymbol[Enum1] {
  override def getSchema: org.apache.avro.Schema = Enum1.SCHEMA$
  override def compareTo(that: Enum1): Int = this.ordinal.compareTo(that.ordinal)
}

object Enum1 {
  case object sym1 extends Enum1("sym1", 0)
  case object sym2 extends Enum1("sym2", 1)

  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"Enum1\",\"namespace\":\"avro2s.test.unions\",\"symbols\":[\"sym1\",\"sym2\"]}")

  def getClassSchema: org.apache.avro.Schema = SCHEMA$

  def fromString(value: String): Enum1 = value match {
    case "sym1" => sym1
    case "sym2" => sym2
    case other => throw new IllegalArgumentException(s"Unknown enum value: $other")
  }

  def valueOf(value: String): Enum1 = fromString(value)

  val values: Seq[Enum1] = Seq(sym1, sym2)
}