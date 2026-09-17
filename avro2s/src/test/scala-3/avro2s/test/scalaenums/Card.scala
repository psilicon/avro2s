/** GENERATED CODE */

package avro2s.test.scalaenums

import scala.annotation.switch

case class Card(var suit: avro2s.test.scalaenums.Suit, var trump: Option[avro2s.test.scalaenums.Suit], var history: List[avro2s.test.scalaenums.Suit], var byPlayer: Map[String, avro2s.test.scalaenums.Suit], var maybeHistory: List[Option[avro2s.test.scalaenums.Suit]], var kw: avro2s.test.scalaenums.Kw, var maybeKw: Option[avro2s.test.scalaenums.Kw], var cp: Option[avro2s.test.scalaenums.Suit | String]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(null, None, List.empty, Map.empty, List.empty, null, None, None)

  override def getSchema: org.apache.avro.Schema = Card.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _root_.avro2s.test.scalaenums.Suit.toAvroSymbol$(suit).asInstanceOf[AnyRef]
      case 1 => trump match {
        case Some(x: avro2s.test.scalaenums.Suit) => _root_.avro2s.test.scalaenums.Suit.toAvroSymbol$(x).asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 2 => history match {
        case array =>
          {
            def toJavaArray$(input$: List[avro2s.test.scalaenums.Suit]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  _root_.avro2s.test.scalaenums.Suit.toAvroSymbol$(element$)
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
            _root_.avro2s.test.scalaenums.Suit.toAvroSymbol$(kvp._2).asInstanceOf[AnyRef]
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 4 => maybeHistory match {
        case array =>
          {
            def toJavaArray$(input$: List[Option[avro2s.test.scalaenums.Suit]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case Some(x: avro2s.test.scalaenums.Suit) => _root_.avro2s.test.scalaenums.Suit.toAvroSymbol$(x).asInstanceOf[AnyRef]
                    case None => null.asInstanceOf[AnyRef]
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 5 => _root_.avro2s.test.scalaenums.Kw.toAvroSymbol$(kw).asInstanceOf[AnyRef]
      case 6 => maybeKw match {
        case Some(x: avro2s.test.scalaenums.Kw) => _root_.avro2s.test.scalaenums.Kw.toAvroSymbol$(x).asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 7 => cp match {
        case Some(x: avro2s.test.scalaenums.Suit) => _root_.avro2s.test.scalaenums.Suit.toAvroSymbol$(x).asInstanceOf[AnyRef]
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.suit = {
        value match { case x: _root_.avro2s.test.scalaenums.Suit => x; case x => _root_.avro2s.test.scalaenums.Suit.fromAvroSymbol(x.toString) }
      }
      case 1 => this.trump = {
        value match {
          case null => None
          case x: avro2s.test.scalaenums.Suit => Option(x.asInstanceOf[avro2s.test.scalaenums.Suit])
          case x: org.apache.avro.generic.GenericEnumSymbol[_] if x.getSchema.getFullName == "avro2s.test.scalaenums.Suit" => Option(_root_.avro2s.test.scalaenums.Suit.fromAvroSymbol(x.toString).asInstanceOf[avro2s.test.scalaenums.Suit])
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 2 => this.history = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match { case x: _root_.avro2s.test.scalaenums.Suit => x; case x => _root_.avro2s.test.scalaenums.Suit.fromAvroSymbol(x.toString) }
        }).toList
      }
      case 3 => this.byPlayer = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, avro2s.test.scalaenums.Suit] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match { case x: _root_.avro2s.test.scalaenums.Suit => x; case x => _root_.avro2s.test.scalaenums.Suit.fromAvroSymbol(x.toString) }
            })
          }.toMap
        }
      }
      case 4 => this.maybeHistory = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case null => None
            case x: avro2s.test.scalaenums.Suit => Option(x.asInstanceOf[avro2s.test.scalaenums.Suit])
            case x: org.apache.avro.generic.GenericEnumSymbol[_] if x.getSchema.getFullName == "avro2s.test.scalaenums.Suit" => Option(_root_.avro2s.test.scalaenums.Suit.fromAvroSymbol(x.toString).asInstanceOf[avro2s.test.scalaenums.Suit])
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case 5 => this.kw = {
        value match { case x: _root_.avro2s.test.scalaenums.Kw => x; case x => _root_.avro2s.test.scalaenums.Kw.fromAvroSymbol(x.toString) }
      }
      case 6 => this.maybeKw = {
        value match {
          case null => None
          case x: avro2s.test.scalaenums.Kw => Option(x.asInstanceOf[avro2s.test.scalaenums.Kw])
          case x: org.apache.avro.generic.GenericEnumSymbol[_] if x.getSchema.getFullName == "avro2s.test.scalaenums.Kw" => Option(_root_.avro2s.test.scalaenums.Kw.fromAvroSymbol(x.toString).asInstanceOf[avro2s.test.scalaenums.Kw])
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 7 => this.cp = {
        value match {
          case null => None
          case x: avro2s.test.scalaenums.Suit => Option(x.asInstanceOf[avro2s.test.scalaenums.Suit | String])
          case x: org.apache.avro.generic.GenericEnumSymbol[_] if x.getSchema.getFullName == "avro2s.test.scalaenums.Suit" => Option(_root_.avro2s.test.scalaenums.Suit.fromAvroSymbol(x.toString).asInstanceOf[avro2s.test.scalaenums.Suit | String])
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object Card {
  @scala.annotation.static val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Card","namespace":"avro2s.test.scalaenums","fields":[{"name":"suit","type":{"type":"enum","name":"Suit","doc":"The suit of a playing card.","symbols":["SPADES","HEARTS","DIAMONDS","CLUBS"]}},{"name":"trump","type":["null","Suit"],"default":null},{"name":"history","type":{"type":"array","items":"Suit"}},{"name":"byPlayer","type":{"type":"map","values":"Suit"}},{"name":"maybeHistory","type":{"type":"array","items":["null","Suit"]}},{"name":"kw","type":{"type":"enum","name":"Kw","symbols":["new","type","given","NORMAL"]}},{"name":"maybeKw","type":["null","Kw"],"default":null},{"name":"cp","type":["null","Suit","string"],"default":null}]}""")
}