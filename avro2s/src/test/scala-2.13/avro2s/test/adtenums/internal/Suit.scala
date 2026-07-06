/** GENERATED CODE */

package avro2s.test.adtenums.internal

sealed trait Suit extends _root_.scala.Product with _root_.scala.Serializable

object Suit {
  case object SPADES extends Suit
  case object HEARTS extends Suit
  case object DIAMONDS extends Suit
  case object CLUBS extends Suit

  val values: _root_.scala.List[_root_.avro2s.test.adtenums.internal.Suit] = _root_.scala.List(_root_.avro2s.test.adtenums.internal.Suit.SPADES, _root_.avro2s.test.adtenums.internal.Suit.HEARTS, _root_.avro2s.test.adtenums.internal.Suit.DIAMONDS, _root_.avro2s.test.adtenums.internal.Suit.CLUBS)

  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"enum","name":"Suit","namespace":"avro2s.test.adtenums","symbols":["SPADES","HEARTS","DIAMONDS","CLUBS"]}""")

  def valueOf(value: _root_.java.lang.String): _root_.avro2s.test.adtenums.internal.Suit = value match {
    case "SPADES" => _root_.avro2s.test.adtenums.internal.Suit.SPADES
    case "HEARTS" => _root_.avro2s.test.adtenums.internal.Suit.HEARTS
    case "DIAMONDS" => _root_.avro2s.test.adtenums.internal.Suit.DIAMONDS
    case "CLUBS" => _root_.avro2s.test.adtenums.internal.Suit.CLUBS
    case other => throw new org.apache.avro.AvroRuntimeException("No enum symbol " + other + " in avro2s.test.adtenums.Suit")
  }
}