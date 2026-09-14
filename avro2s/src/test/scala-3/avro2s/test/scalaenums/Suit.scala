/** GENERATED CODE */

package avro2s.test.scalaenums.internal {
  /**
   * The suit of a playing card.
   */
  enum Suit(private val symbol$: _root_.java.lang.String) {
    case SPADES extends _root_.avro2s.test.scalaenums.internal.Suit("SPADES")
    case HEARTS extends _root_.avro2s.test.scalaenums.internal.Suit("HEARTS")
    case DIAMONDS extends _root_.avro2s.test.scalaenums.internal.Suit("DIAMONDS")
    case CLUBS extends _root_.avro2s.test.scalaenums.internal.Suit("CLUBS")

    override def toString: _root_.java.lang.String = symbol$
  }

  object Suit {
    val SCHEMA$: _root_.org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"enum","name":"Suit","namespace":"avro2s.test.scalaenums","doc":"The suit of a playing card.","symbols":["SPADES","HEARTS","DIAMONDS","CLUBS"]}""")

    def fromAvroSymbol(value: _root_.java.lang.String): _root_.avro2s.test.scalaenums.internal.Suit = value match {
      case "SPADES" => _root_.avro2s.test.scalaenums.internal.Suit.SPADES
      case "HEARTS" => _root_.avro2s.test.scalaenums.internal.Suit.HEARTS
      case "DIAMONDS" => _root_.avro2s.test.scalaenums.internal.Suit.DIAMONDS
      case "CLUBS" => _root_.avro2s.test.scalaenums.internal.Suit.CLUBS
      case other => throw new _root_.org.apache.avro.AvroRuntimeException("No enum symbol " + other + " in avro2s.test.scalaenums.Suit")
    }
  }
}

package avro2s.test.scalaenums {
  /**
   * The suit of a playing card.
   */
  type Suit = _root_.avro2s.test.scalaenums.internal.Suit
  /**
   * The suit of a playing card.
   */
  val Suit: _root_.avro2s.test.scalaenums.internal.Suit.type = _root_.avro2s.test.scalaenums.internal.Suit
}