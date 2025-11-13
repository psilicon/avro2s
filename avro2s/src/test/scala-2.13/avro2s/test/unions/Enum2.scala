/** GENERATED CODE */

package avro2s.test.unions


sealed abstract class Enum2(val value: String, val ordinal: Int) extends org.apache.avro.generic.GenericEnumSymbol[Enum2] {
  override def getSchema: org.apache.avro.Schema = Enum2.SCHEMA$
  override def compareTo(that: Enum2): Int = this.ordinal.compareTo(that.ordinal)
}

object Enum2 {
  case object sym3 extends Enum2("sym3", 0)
  case object sym4 extends Enum2("sym4", 1)

  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"Enum2\",\"namespace\":\"avro2s.test.unions\",\"symbols\":[\"sym3\",\"sym4\"]}")

  def getClassSchema: org.apache.avro.Schema = SCHEMA$

  def fromString(value: String): Enum2 = value match {
    case "sym3" => sym3
    case "sym4" => sym4
    case other => throw new IllegalArgumentException(s"Unknown enum value: $other")
  }

  def valueOf(value: String): Enum2 = fromString(value)

  val values: Seq[Enum2] = Seq(sym3, sym4)
}