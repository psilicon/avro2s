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
      case 0 => _root_.avro2s.test.adtenums.Suit.toAvroSymbol$(suit).asInstanceOf[AnyRef]
      case 1 => trump match {
        case None => null
        case Some(x) => _root_.avro2s.test.adtenums.Suit.toAvroSymbol$(x).asInstanceOf[AnyRef]
      }
      case 2 => history match {
        case array =>
          {
            def toJavaArray$(input$: List[avro2s.test.adtenums.Suit]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  _root_.avro2s.test.adtenums.Suit.toAvroSymbol$(element$)
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 3 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = byPlayer.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        byPlayer.foreach { kvp =>
          val key = kvp._1
          val value = {
            _root_.avro2s.test.adtenums.Suit.toAvroSymbol$(kvp._2).asInstanceOf[AnyRef]
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 4 => maybeHistory match {
        case array =>
          {
            def toJavaArray$(input$: List[Option[avro2s.test.adtenums.Suit]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case None => null
                    case Some(x) => _root_.avro2s.test.adtenums.Suit.toAvroSymbol$(x).asInstanceOf[AnyRef]
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 5 => _root_.avro2s.test.adtenums.Kw.toAvroSymbol$(kw).asInstanceOf[AnyRef]
      case 6 => maybeKw match {
        case None => null
        case Some(x) => _root_.avro2s.test.adtenums.Kw.toAvroSymbol$(x).asInstanceOf[AnyRef]
      }
      case 7 => cp match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => _root_.avro2s.test.adtenums.Suit.toAvroSymbol$(x).asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.suit = value match { case x: _root_.avro2s.test.adtenums.Suit => x; case x => _root_.avro2s.test.adtenums.Suit.fromAvroSymbol(x.toString) }
      case 1 => this.trump = {
        value match {
          case null => None
          case x: avro2s.test.adtenums.Suit => Some(x)
          case x: org.apache.avro.generic.GenericEnumSymbol[_] => Some(_root_.avro2s.test.adtenums.Suit.fromAvroSymbol(x.toString))
        }
      }
      case 2 => this.history = {
        value match {
          case array: java.util.List[_] =>
            val builder$ = List.newBuilder[avro2s.test.adtenums.Suit]
            val iterator$ = array.iterator
            while (iterator$.hasNext) {
              val value = iterator$.next
              builder$ += {
                value match { case x: _root_.avro2s.test.adtenums.Suit => x; case x => _root_.avro2s.test.adtenums.Suit.fromAvroSymbol(x.toString) }
              }
            }
            builder$.result()
          }
      }
      case 3 => this.byPlayer = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, avro2s.test.adtenums.Suit] else {
              val builder$ = Map.newBuilder[String, avro2s.test.adtenums.Suit]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value match { case x: _root_.avro2s.test.adtenums.Suit => x; case x => _root_.avro2s.test.adtenums.Suit.fromAvroSymbol(x.toString) }
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 4 => this.maybeHistory = {
        value match {
          case array: java.util.List[_] =>
            val builder$ = List.newBuilder[Option[avro2s.test.adtenums.Suit]]
            val iterator$ = array.iterator
            while (iterator$.hasNext) {
              val value = iterator$.next
              builder$ += {
                value match {
                  case null => None
                  case x: avro2s.test.adtenums.Suit => Some(x)
                  case x: org.apache.avro.generic.GenericEnumSymbol[_] => Some(_root_.avro2s.test.adtenums.Suit.fromAvroSymbol(x.toString))
                }
              }
            }
            builder$.result()
          }
      }
      case 5 => this.kw = value match { case x: _root_.avro2s.test.adtenums.Kw => x; case x => _root_.avro2s.test.adtenums.Kw.fromAvroSymbol(x.toString) }
      case 6 => this.maybeKw = {
        value match {
          case null => None
          case x: avro2s.test.adtenums.Kw => Some(x)
          case x: org.apache.avro.generic.GenericEnumSymbol[_] => Some(_root_.avro2s.test.adtenums.Kw.fromAvroSymbol(x.toString))
        }
      }
      case 7 => this.cp = {
        value match {
          case x @ null => Coproduct[scala.Null :+: avro2s.test.adtenums.Suit :+: String :+: CNil](x)
          case x: avro2s.test.adtenums.Suit => Coproduct[scala.Null :+: avro2s.test.adtenums.Suit :+: String :+: CNil](x)
          case x: org.apache.avro.generic.GenericEnumSymbol[_] if x.getSchema.getFullName == "avro2s.test.adtenums.Suit" => Coproduct[scala.Null :+: avro2s.test.adtenums.Suit :+: String :+: CNil](_root_.avro2s.test.adtenums.Suit.fromAvroSymbol(x.toString))
          case x: java.lang.CharSequence => Coproduct[scala.Null :+: avro2s.test.adtenums.Suit :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object Card {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Card","namespace":"avro2s.test.adtenums","fields":[{"name":"suit","type":{"type":"enum","name":"Suit","doc":"The suit of a playing card.","symbols":["SPADES","HEARTS","DIAMONDS","CLUBS"]}},{"name":"trump","type":["null","Suit"],"default":null},{"name":"history","type":{"type":"array","items":"Suit"}},{"name":"byPlayer","type":{"type":"map","values":"Suit"}},{"name":"maybeHistory","type":{"type":"array","items":["null","Suit"]}},{"name":"kw","type":{"type":"enum","name":"Kw","symbols":["new","type","lazy","NORMAL"]}},{"name":"maybeKw","type":["null","Kw"],"default":null},{"name":"cp","type":["null","Suit","string"],"default":null}]}""")
}