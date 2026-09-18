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

  override protected def hasCustomCoders(): Boolean = true
  override def customEncode(out$: _root_.org.apache.avro.io.Encoder): Unit = encode$0(this, out$)
  override def customDecode(in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = decodeRecord$0(this, in$)

  private def encode$0(value$: _root_.avro2s.test.scalaenums.Card, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`suit`, out$)
    encode$2(value$.`trump`, out$)
    encode$4(value$.`history`, out$)
    encode$5(value$.`byPlayer`, out$)
    encode$6(value$.`maybeHistory`, out$)
    encode$9(value$.`kw`, out$)
    encode$10(value$.`maybeKw`, out$)
    encode$12(value$.`cp`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.scalaenums.Card): _root_.avro2s.test.scalaenums.Card = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.scalaenums.Card() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.scalaenums.Card, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`suit` = decode$1(in$)
      value$.`trump` = decode$2(in$)
      value$.`history` = decode$4(in$)
      value$.`byPlayer` = decode$5(in$)
      value$.`maybeHistory` = decode$6(in$)
      value$.`kw` = decode$9(in$)
      value$.`maybeKw` = decode$10(in$)
      value$.`cp` = decode$12(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`suit` = decode$1(in$)
          case 1 => value$.`trump` = decode$2(in$)
          case 2 => value$.`history` = decode$4(in$)
          case 3 => value$.`byPlayer` = decode$5(in$)
          case 4 => value$.`maybeHistory` = decode$6(in$)
          case 5 => value$.`kw` = decode$9(in$)
          case 6 => value$.`maybeKw` = decode$10(in$)
          case 7 => value$.`cp` = decode$12(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$1(value$: _root_.avro2s.test.scalaenums.Suit, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeEnum(_root_.avro2s.test.scalaenums.Card.customSchema$1.getEnumOrdinal(value$.toString))
  }

  private def decode$1(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.scalaenums.Suit = {
    _root_.avro2s.test.scalaenums.Card.customEnum$1(in$.readEnum())
  }

  private def encode$2(value$: _root_.scala.Option[_root_.avro2s.test.scalaenums.Suit], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$3(null, out$)
      case _root_.scala.Some(branch$: (_root_.avro2s.test.scalaenums.Suit @unchecked)) =>
        out$.writeIndex(1)
        encode$1(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$2(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.avro2s.test.scalaenums.Suit] = {
    in$.readIndex() match {
      case 0 => { decode$3(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$1(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$3(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$3(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$4(value$: _root_.scala.List[_root_.avro2s.test.scalaenums.Suit], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$1(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$4(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.avro2s.test.scalaenums.Suit] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.avro2s.test.scalaenums.Suit]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$1(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$5(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.avro2s.test.scalaenums.Suit], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$1(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$5(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.avro2s.test.scalaenums.Suit] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.avro2s.test.scalaenums.Suit]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$1(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$6(value$: _root_.scala.List[_root_.scala.Option[_root_.avro2s.test.scalaenums.Suit]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$7(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$6(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Option[_root_.avro2s.test.scalaenums.Suit]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Option[_root_.avro2s.test.scalaenums.Suit]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$7(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$7(value$: _root_.scala.Option[_root_.avro2s.test.scalaenums.Suit], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$8(null, out$)
      case _root_.scala.Some(branch$: (_root_.avro2s.test.scalaenums.Suit @unchecked)) =>
        out$.writeIndex(1)
        encode$1(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$7(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.avro2s.test.scalaenums.Suit] = {
    in$.readIndex() match {
      case 0 => { decode$8(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$1(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$8(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$8(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$9(value$: _root_.avro2s.test.scalaenums.Kw, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeEnum(_root_.avro2s.test.scalaenums.Card.customSchema$9.getEnumOrdinal(value$.toString))
  }

  private def decode$9(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.scalaenums.Kw = {
    _root_.avro2s.test.scalaenums.Card.customEnum$9(in$.readEnum())
  }

  private def encode$10(value$: _root_.scala.Option[_root_.avro2s.test.scalaenums.Kw], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$11(null, out$)
      case _root_.scala.Some(branch$: (_root_.avro2s.test.scalaenums.Kw @unchecked)) =>
        out$.writeIndex(1)
        encode$9(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$10(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.avro2s.test.scalaenums.Kw] = {
    in$.readIndex() match {
      case 0 => { decode$11(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$9(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$11(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$11(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$12(value$: _root_.scala.Option[_root_.avro2s.test.scalaenums.Suit | _root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$13(null, out$)
      case _root_.scala.Some(branch$: (_root_.avro2s.test.scalaenums.Suit @unchecked)) =>
        out$.writeIndex(1)
        encode$1(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(2)
        encode$14(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$12(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.avro2s.test.scalaenums.Suit | _root_.java.lang.String] = {
    in$.readIndex() match {
      case 0 => { decode$13(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$1(in$))
      case 2 => _root_.scala.Some(decode$14(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$13(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$13(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$14(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$14(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }
}

object Card {
  @scala.annotation.static val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Card","namespace":"avro2s.test.scalaenums","fields":[{"name":"suit","type":{"type":"enum","name":"Suit","doc":"The suit of a playing card.","symbols":["SPADES","HEARTS","DIAMONDS","CLUBS"]}},{"name":"trump","type":["null","Suit"],"default":null},{"name":"history","type":{"type":"array","items":"Suit"}},{"name":"byPlayer","type":{"type":"map","values":"Suit"}},{"name":"maybeHistory","type":{"type":"array","items":["null","Suit"]}},{"name":"kw","type":{"type":"enum","name":"Kw","symbols":["new","type","given","NORMAL"]}},{"name":"maybeKw","type":["null","Kw"],"default":null},{"name":"cp","type":["null","Suit","string"],"default":null}]}""")
  private val customSchema$1: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(0).schema()
  private val customEnum$1: _root_.scala.Array[_root_.avro2s.test.scalaenums.Suit] = {
    val result$ = new _root_.scala.Array[_root_.avro2s.test.scalaenums.Suit](customSchema$1.getEnumSymbols.size())
    var i$ = 0
    while (i$ < result$.length) {
      result$(i$) = _root_.avro2s.test.scalaenums.Suit.fromAvroSymbol(customSchema$1.getEnumSymbols.get(i$))
      i$ += 1
    }
    result$
  }
  private val customSchema$9: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(5).schema()
  private val customEnum$9: _root_.scala.Array[_root_.avro2s.test.scalaenums.Kw] = {
    val result$ = new _root_.scala.Array[_root_.avro2s.test.scalaenums.Kw](customSchema$9.getEnumSymbols.size())
    var i$ = 0
    while (i$ < result$.length) {
      result$(i$) = _root_.avro2s.test.scalaenums.Kw.fromAvroSymbol(customSchema$9.getEnumSymbols.get(i$))
      i$ += 1
    }
    result$
  }
}