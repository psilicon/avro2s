package avro2s.generator

import avro2s.serialization.SerializationHelpers._
import avro2s.test.adtenums.{Card, Kw, Suit}
import org.apache.avro.generic.GenericEnumSymbol
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import shapeless.{:+:, CNil, Coproduct}

class AdtEnumSerializationTest extends AnyFunSuite with Matchers {
  type CpUnion = scala.Null :+: Suit :+: String :+: CNil

  private def card = new Card(
    Suit.DIAMONDS,
    Some(Suit.CLUBS),
    List(Suit.SPADES, Suit.HEARTS),
    Map("p1" -> Suit.HEARTS),
    List(Some(Suit.SPADES), None),
    Kw.`new`,
    Some(Kw.`type`),
    Coproduct[CpUnion](null: Null)
  )

  test("no JVM class exists at the schema fullname (name-dodge holds)") {
    a[ClassNotFoundException] should be thrownBy Class.forName("avro2s.test.adtenums.Suit")
    Suit.SPADES.getClass.getName should startWith("avro2s.test.adtenums.internal.Suit")
  }

  test("the ADT carries no Avro API") {
    (Suit.SPADES: Any) should not be a[org.apache.avro.generic.GenericEnumSymbol[_]]
    (Suit.SPADES: Any) should not be a[java.lang.Enum[_]]
    Suit.values should have length 4
    Suit.valueOf("HEARTS") shouldBe Suit.HEARTS
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
      c.cp = Coproduct[CpUnion](symbol)

      val wrapped = c.get(0).asInstanceOf[GenericEnumSymbol[_]]
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
    c.trump = Some(null)
    c.history = List(null)
    c.byPlayer = Map("p1" -> null)
    c.maybeHistory = List(Some(null))

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
    c.kw = Kw.`lazy`
    c.maybeKw = Some(Kw.NORMAL)
    val back = deserialize[Card](serialize(c), Card.SCHEMA$)
    back.kw should be theSameInstanceAs Kw.`lazy`
    back.maybeKw.get should be theSameInstanceAs Kw.NORMAL
  }

  test("multi-type union with enum round-trips both branches") {
    val c1 = card
    c1.cp = Coproduct[CpUnion](Suit.CLUBS)
    val b1 = deserialize[Card](serialize(c1), Card.SCHEMA$)
    b1.cp shouldBe c1.cp
    b1.cp.select[Suit].get should be theSameInstanceAs Suit.CLUBS

    val c2 = card
    c2.cp = Coproduct[CpUnion]("wild card")
    val b2 = deserialize[Card](serialize(c2), Card.SCHEMA$)
    b2.cp shouldBe c2.cp
    b2.cp.select[String] shouldBe Some("wild card")
  }
}
