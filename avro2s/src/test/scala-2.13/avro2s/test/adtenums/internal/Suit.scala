/** GENERATED CODE */

package avro2s.test.adtenums.internal

/**
 * The suit of a playing card.
 */
sealed trait Suit extends _root_.scala.Product with _root_.scala.Serializable

object Suit {
  case object SPADES extends _root_.avro2s.test.adtenums.internal.Suit { override def toString: _root_.java.lang.String = "SPADES" }
  case object HEARTS extends _root_.avro2s.test.adtenums.internal.Suit { override def toString: _root_.java.lang.String = "HEARTS" }
  case object DIAMONDS extends _root_.avro2s.test.adtenums.internal.Suit { override def toString: _root_.java.lang.String = "DIAMONDS" }
  case object CLUBS extends _root_.avro2s.test.adtenums.internal.Suit { override def toString: _root_.java.lang.String = "CLUBS" }

  val values: _root_.scala.List[_root_.avro2s.test.adtenums.internal.Suit] = _root_.scala.List(_root_.avro2s.test.adtenums.internal.Suit.SPADES, _root_.avro2s.test.adtenums.internal.Suit.HEARTS, _root_.avro2s.test.adtenums.internal.Suit.DIAMONDS, _root_.avro2s.test.adtenums.internal.Suit.CLUBS)

  val SCHEMA$: _root_.org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"enum","name":"Suit","namespace":"avro2s.test.adtenums","doc":"The suit of a playing card.","symbols":["SPADES","HEARTS","DIAMONDS","CLUBS"]}""")

  private val avroSymbol$0: _root_.org.apache.avro.generic.GenericData.EnumSymbol = new _root_.org.apache.avro.generic.GenericData.EnumSymbol(SCHEMA$, "SPADES")
  private val avroSymbol$1: _root_.org.apache.avro.generic.GenericData.EnumSymbol = new _root_.org.apache.avro.generic.GenericData.EnumSymbol(SCHEMA$, "HEARTS")
  private val avroSymbol$2: _root_.org.apache.avro.generic.GenericData.EnumSymbol = new _root_.org.apache.avro.generic.GenericData.EnumSymbol(SCHEMA$, "DIAMONDS")
  private val avroSymbol$3: _root_.org.apache.avro.generic.GenericData.EnumSymbol = new _root_.org.apache.avro.generic.GenericData.EnumSymbol(SCHEMA$, "CLUBS")

  def toAvroSymbol$(value: _root_.avro2s.test.adtenums.internal.Suit): _root_.org.apache.avro.generic.GenericData.EnumSymbol = {
    if (value == null) null
    else value.toString match {
      case "SPADES" => avroSymbol$0
      case "HEARTS" => avroSymbol$1
      case "DIAMONDS" => avroSymbol$2
      case "CLUBS" => avroSymbol$3
      case other => throw new _root_.org.apache.avro.AvroRuntimeException("No enum symbol " + other + " in avro2s.test.adtenums.Suit")
    }
  }

  def fromAvroSymbol(value: _root_.java.lang.String): _root_.avro2s.test.adtenums.internal.Suit = value match {
    case "SPADES" => _root_.avro2s.test.adtenums.internal.Suit.SPADES
    case "HEARTS" => _root_.avro2s.test.adtenums.internal.Suit.HEARTS
    case "DIAMONDS" => _root_.avro2s.test.adtenums.internal.Suit.DIAMONDS
    case "CLUBS" => _root_.avro2s.test.adtenums.internal.Suit.CLUBS
    case other => throw new _root_.org.apache.avro.AvroRuntimeException("No enum symbol " + other + " in avro2s.test.adtenums.Suit")
  }

  def valueOf(value: _root_.java.lang.String): _root_.avro2s.test.adtenums.internal.Suit = fromAvroSymbol(value)
}