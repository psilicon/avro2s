package avro2s.generator

import avro2s.serialization.SerializationHelpers._
import avro2s.test.scalaenums.{Card, Kw, Suit}
import org.apache.avro.generic.GenericEnumSymbol
import org.apache.avro.specific.{SpecificData, SpecificDatumReader}
import org.apache.avro.io.DecoderFactory
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class EnumSerializationTest extends AnyFunSuite with Matchers {
  private def card = new Card(
    Suit.DIAMONDS,
    Some(Suit.CLUBS),
    List(Suit.SPADES, Suit.HEARTS),
    Map("p1" -> Suit.HEARTS),
    List(Some(Suit.SPADES), None),
    Kw.`new`,
    Some(Kw.`type`),
    None
  )

  test("no JVM class exists at the schema fullname (name-dodge holds)") {
    a[ClassNotFoundException] should be thrownBy Class.forName("avro2s.test.scalaenums.Suit")
    Suit.SPADES.getClass.getName should startWith("avro2s.test.scalaenums.internal.Suit")
  }

  test("the enum is a plain Scala 3 enum with no Avro or Java-enum API") {
    (Suit.SPADES: Any) should not be a[java.lang.Enum[?]]
    (Suit.SPADES: Any) should not be a[Comparable[?]]
    (Suit.SPADES: Any) shouldBe a[scala.reflect.Enum]
    Suit.values.length shouldBe 4
    Suit.valueOf("HEARTS") shouldBe Suit.HEARTS
    Suit.fromOrdinal(2) shouldBe Suit.DIAMONDS
  }

  test("keyword symbols keep raw names") {
    Kw.`new`.toString shouldBe "new"
    Kw.`type`.toString shouldBe "type"
  }

  test("round-trip through STOCK writer and STOCK default reader") {
    val back = deserialize[Card](serialize(card), Card.SCHEMA$)
    back shouldBe card
    back.suit should be theSameInstanceAs Suit.DIAMONDS
    back.kw should be theSameInstanceAs Kw.`new`
  }

  test("enum getters share immutable wrappers across records and containers") {
    val c = card
    val other = card
    Suit.values.foreach { symbol =>
      c.suit = symbol
      other.suit = symbol
      c.trump = Some(symbol)
      c.history = List(symbol, symbol)
      c.byPlayer = Map("p1" -> symbol)
      c.maybeHistory = List(Some(symbol), None)
      c.cp = Some(symbol)

      val wrapped = c.get(0).asInstanceOf[GenericEnumSymbol[?]]
      wrapped.getSchema should be theSameInstanceAs Suit.SCHEMA$
      wrapped.toString shouldBe symbol.toString
      c.get(0) should be theSameInstanceAs wrapped
      other.get(0) should be theSameInstanceAs wrapped
      c.get(1) should be theSameInstanceAs wrapped
      val history = c.get(2).asInstanceOf[java.util.List[AnyRef]]
      history.get(0) should be theSameInstanceAs wrapped
      history.get(1) should be theSameInstanceAs wrapped
      c.get(3).asInstanceOf[java.util.Map[String, AnyRef]].get("p1") should be theSameInstanceAs wrapped
      val maybeHistory = c.get(4).asInstanceOf[java.util.List[AnyRef]]
      maybeHistory.get(0) should be theSameInstanceAs wrapped
      maybeHistory.get(1) shouldBe null
      c.get(7) should be theSameInstanceAs wrapped

      deserialize[Card](serialize(c), Card.SCHEMA$) shouldBe c
    }
  }

  test("cached enum getters preserve null values") {
    val c = card
    c.suit = null
    c.trump = None
    c.history = List(null)
    c.byPlayer = Map("p1" -> null)
    c.maybeHistory = List(None)

    c.get(0) shouldBe null
    c.get(1) shouldBe null
    c.get(2).asInstanceOf[java.util.List[AnyRef]].get(0) shouldBe null
    c.get(3).asInstanceOf[java.util.Map[String, AnyRef]].get("p1") shouldBe null
    c.get(4).asInstanceOf[java.util.List[AnyRef]].get(0) shouldBe null
  }

  test("round-trip with None union branches") {
    val c = card
    c.trump = None
    c.maybeKw = None
    val back = deserialize[Card](serialize(c), Card.SCHEMA$)
    back.trump shouldBe None
    back.maybeKw shouldBe None
  }

  test("remaining keyword and plain symbols round-trip") {
    val c = card
    c.kw = Kw.`given`
    c.maybeKw = Some(Kw.NORMAL)
    val back = deserialize[Card](serialize(c), Card.SCHEMA$)
    back.kw should be theSameInstanceAs Kw.`given`
    back.maybeKw.get should be theSameInstanceAs Kw.NORMAL
  }

  test("multi-type union with enum round-trips both branches") {
    val c1 = card
    c1.cp = Some(Suit.CLUBS)
    val b1 = deserialize[Card](serialize(c1), Card.SCHEMA$)
    b1.cp shouldBe c1.cp
    b1.cp.get should be theSameInstanceAs Suit.CLUBS

    val c2 = card
    c2.cp = Some("wild card")
    val b2 = deserialize[Card](serialize(c2), Card.SCHEMA$)
    b2.cp shouldBe c2.cp
  }

  test("class-based reader constructor works via @static SCHEMA$") {
    val bytes = serialize(card)
    val reader = new SpecificDatumReader[Card](classOf[Card])
    val back = reader.read(null.asInstanceOf[Card], DecoderFactory.get().binaryDecoder(bytes, null))
    back shouldBe card
  }

  test("Confluent-style schema lookup from record class works") {
    SpecificData.get().getSchema(classOf[Card]).getFullName shouldBe "avro2s.test.scalaenums.Card"
  }
}
