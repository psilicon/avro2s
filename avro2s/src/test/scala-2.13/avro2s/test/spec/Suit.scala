/** GENERATED CODE */

package avro2s.test.spec


sealed abstract class Suit(val value: String, val ordinal: Int) extends org.apache.avro.generic.GenericEnumSymbol[Suit] {
  override def getSchema: org.apache.avro.Schema = Suit.SCHEMA$
  override def compareTo(that: Suit): Int = this.ordinal.compareTo(that.ordinal)
}

object Suit {
  case object SPADES extends Suit("SPADES", 0)
  case object HEARTS extends Suit("HEARTS", 1)
  case object DIAMONDS extends Suit("DIAMONDS", 2)
  case object CLUBS extends Suit("CLUBS", 3)

  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"Suit\",\"namespace\":\"avro2s.test.spec\",\"symbols\":[\"SPADES\",\"HEARTS\",\"DIAMONDS\",\"CLUBS\"]}")

  def getClassSchema: org.apache.avro.Schema = SCHEMA$

  def fromString(value: String): Suit = value match {
    case "SPADES" => SPADES
    case "HEARTS" => HEARTS
    case "DIAMONDS" => DIAMONDS
    case "CLUBS" => CLUBS
    case other => throw new IllegalArgumentException(s"Unknown enum value: $other")
  }

  def valueOf(value: String): Suit = fromString(value)

  val values: Seq[Suit] = Seq(SPADES, HEARTS, DIAMONDS, CLUBS)
}