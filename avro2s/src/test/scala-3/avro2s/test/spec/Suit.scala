/** GENERATED CODE */

package avro2s.test.spec


enum Suit extends org.apache.avro.generic.GenericEnumSymbol[Suit] {
  case SPADES, HEARTS, DIAMONDS, CLUBS

  override def getSchema: org.apache.avro.Schema = Suit.SCHEMA$
  override def compareTo(that: Suit): Int = this.ordinal.compareTo(that.ordinal)
}

object Suit {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"Suit\",\"namespace\":\"avro2s.test.spec\",\"symbols\":[\"SPADES\",\"HEARTS\",\"DIAMONDS\",\"CLUBS\"]}")

  def getClassSchema: org.apache.avro.Schema = SCHEMA$

  def fromString(value: String): Suit = valueOf(value)
}