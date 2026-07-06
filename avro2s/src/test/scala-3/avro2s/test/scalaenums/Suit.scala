/** GENERATED CODE */

package avro2s.test.scalaenums.internal {
  enum Suit {
    case SPADES, HEARTS, DIAMONDS, CLUBS
  }

  object Suit {
    val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"enum","name":"Suit","namespace":"avro2s.test.scalaenums","symbols":["SPADES","HEARTS","DIAMONDS","CLUBS"]}""")
  }
}

package avro2s.test.scalaenums {
  type Suit = avro2s.test.scalaenums.internal.Suit
  val Suit: avro2s.test.scalaenums.internal.Suit.type = avro2s.test.scalaenums.internal.Suit
}