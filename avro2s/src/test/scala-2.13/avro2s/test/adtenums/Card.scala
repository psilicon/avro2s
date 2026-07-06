/** GENERATED CODE */

package avro2s.test.adtenums

import org.apache.avro.AvroRuntimeException

import scala.annotation.switch
import shapeless.{:+:, CNil, Coproduct, Inl, Inr}

case class Card(var suit: avro2s.test.adtenums.Suit, var trump: Option[avro2s.test.adtenums.Suit], var history: List[avro2s.test.adtenums.Suit], var byPlayer: Map[String, avro2s.test.adtenums.Suit], var maybeHistory: List[Option[avro2s.test.adtenums.Suit]], var kw: avro2s.test.adtenums.Kw, var maybeKw: Option[avro2s.test.adtenums.Kw], var cp: scala.Null :+: avro2s.test.adtenums.Suit :+: String :+: CNil) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(null, None, List.empty, Map.empty, List.empty, null, None, Inl(null))

  override def getSchema: org.apache.avro.Schema = Card.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => (if (suit == null) null else new org.apache.avro.generic.GenericData.EnumSymbol(avro2s.test.adtenums.Suit.SCHEMA$, suit.toString)).asInstanceOf[AnyRef]
      case 1 => trump match {
        case None => null
        case Some(x) => (if (x == null) null else new org.apache.avro.generic.GenericData.EnumSymbol(avro2s.test.adtenums.Suit.SCHEMA$, x.toString)).asInstanceOf[AnyRef]
      }
      case 2 => history match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { x =>
              (if (x == null) null else new org.apache.avro.generic.GenericData.EnumSymbol(avro2s.test.adtenums.Suit.SCHEMA$, x.toString)).asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 3 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        byPlayer.foreach { kvp =>
          val key = kvp._1
          val value = {
            (if (kvp._2 == null) null else new org.apache.avro.generic.GenericData.EnumSymbol(avro2s.test.adtenums.Suit.SCHEMA$, kvp._2.toString)).asInstanceOf[AnyRef]
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 4 => maybeHistory match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map {
              case None => null
              case Some(x) => (if (x == null) null else new org.apache.avro.generic.GenericData.EnumSymbol(avro2s.test.adtenums.Suit.SCHEMA$, x.toString)).asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 5 => (if (kw == null) null else new org.apache.avro.generic.GenericData.EnumSymbol(avro2s.test.adtenums.Kw.SCHEMA$, kw.toString)).asInstanceOf[AnyRef]
      case 6 => maybeKw match {
        case None => null
        case Some(x) => (if (x == null) null else new org.apache.avro.generic.GenericData.EnumSymbol(avro2s.test.adtenums.Kw.SCHEMA$, x.toString)).asInstanceOf[AnyRef]
      }
      case 7 => cp match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => (if (x == null) null else new org.apache.avro.generic.GenericData.EnumSymbol(avro2s.test.adtenums.Suit.SCHEMA$, x.toString)).asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.suit = value match { case x: avro2s.test.adtenums.Suit => x; case x => avro2s.test.adtenums.Suit.valueOf(x.toString) }
      case 1 => this.trump = {
        value match {
          case null => None
          case x: avro2s.test.adtenums.Suit => Some(x)
          case x: org.apache.avro.generic.GenericEnumSymbol[_] => Some(avro2s.test.adtenums.Suit.valueOf(x.toString))
        }
      }
      case 2 => this.history = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match { case x: avro2s.test.adtenums.Suit => x; case x => avro2s.test.adtenums.Suit.valueOf(x.toString) }
            }).toList
          }
      }
      case 3 => this.byPlayer = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match { case x: avro2s.test.adtenums.Suit => x; case x => avro2s.test.adtenums.Suit.valueOf(x.toString) }
              })
            }
          }
        }
      }
      case 4 => this.maybeHistory = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case null => None
                case x: avro2s.test.adtenums.Suit => Some(x)
                case x: org.apache.avro.generic.GenericEnumSymbol[_] => Some(avro2s.test.adtenums.Suit.valueOf(x.toString))
              }
            }).toList
          }
      }
      case 5 => this.kw = value match { case x: avro2s.test.adtenums.Kw => x; case x => avro2s.test.adtenums.Kw.valueOf(x.toString) }
      case 6 => this.maybeKw = {
        value match {
          case null => None
          case x: avro2s.test.adtenums.Kw => Some(x)
          case x: org.apache.avro.generic.GenericEnumSymbol[_] => Some(avro2s.test.adtenums.Kw.valueOf(x.toString))
        }
      }
      case 7 => this.cp = {
        value match {
          case x @ null => Coproduct[scala.Null :+: avro2s.test.adtenums.Suit :+: String :+: CNil](x)
          case x: avro2s.test.adtenums.Suit => Coproduct[scala.Null :+: avro2s.test.adtenums.Suit :+: String :+: CNil](x)
          case x: org.apache.avro.generic.GenericEnumSymbol[_] if x.getSchema.getFullName == "avro2s.test.adtenums.Suit" => Coproduct[scala.Null :+: avro2s.test.adtenums.Suit :+: String :+: CNil](avro2s.test.adtenums.Suit.valueOf(x.toString))
          case x: org.apache.avro.util.Utf8 => Coproduct[scala.Null :+: avro2s.test.adtenums.Suit :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object Card {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Card","namespace":"avro2s.test.adtenums","fields":[{"name":"suit","type":{"type":"enum","name":"Suit","symbols":["SPADES","HEARTS","DIAMONDS","CLUBS"]}},{"name":"trump","type":["null","Suit"],"default":null},{"name":"history","type":{"type":"array","items":"Suit"}},{"name":"byPlayer","type":{"type":"map","values":"Suit"}},{"name":"maybeHistory","type":{"type":"array","items":["null","Suit"]}},{"name":"kw","type":{"type":"enum","name":"Kw","symbols":["new","type","lazy","NORMAL"]}},{"name":"maybeKw","type":["null","Kw"],"default":null},{"name":"cp","type":["null","Suit","string"],"default":null}]}""")
}