/** GENERATED CODE */

package avro2s.test.unions

import scala.annotation.switch

case class OptionsWithNullAsSecondType(var _simple: Option[String], var _optional_array: Option[List[Boolean]], var _array_of_options: List[Option[String]], var _map_of_options: Map[String, Option[String]]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(None, None, List.empty, Map.empty)

  override def getSchema: org.apache.avro.Schema = OptionsWithNullAsSecondType.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _simple match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 1 => _optional_array match {
        case Some(x: List[Boolean]) =>
          if (x.isEmpty) new java.util.ArrayList[Boolean](0) else new java.util.ArrayList[Boolean](scala.jdk.CollectionConverters.SeqHasAsJava(x).asJava)
        case None => null.asInstanceOf[AnyRef]
      }
      case 2 => _array_of_options match {
        case array =>
          {
            def toJavaArray$(input$: List[Option[String]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case Some(x: String) => x.asInstanceOf[AnyRef]
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
      case 3 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_options.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_options.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case Some(x: String) => x.asInstanceOf[AnyRef]
              case None => null.asInstanceOf[AnyRef]
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._simple = {
        value match {
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case null => None
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 1 => this._optional_array = {
        value match {
          case array: java.util.List[?] =>
            Option(scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value.asInstanceOf[Boolean]
            }).toList)
          case null => None
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 2 => this._array_of_options = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case x: org.apache.avro.util.Utf8 => Option(x.toString)
            case null => None
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case 3 => this._map_of_options = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[String]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case x: org.apache.avro.util.Utf8 => Option(x.toString)
                case null => None
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            })
          }.toMap
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override protected def hasCustomCoders(): Boolean = true
  override def customEncode(out$: _root_.org.apache.avro.io.Encoder): Unit = encode$0(this, out$)
  override def customDecode(in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = decodeRecord$0(this, in$)

  private def encode$0(value$: _root_.avro2s.test.unions.OptionsWithNullAsSecondType, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`_simple`, out$)
    encode$4(value$.`_optional_array`, out$)
    encode$8(value$.`_array_of_options`, out$)
    encode$12(value$.`_map_of_options`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.unions.OptionsWithNullAsSecondType): _root_.avro2s.test.unions.OptionsWithNullAsSecondType = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.unions.OptionsWithNullAsSecondType() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.unions.OptionsWithNullAsSecondType, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_simple` = decode$1(in$)
      value$.`_optional_array` = decode$4(in$)
      value$.`_array_of_options` = decode$8(in$)
      value$.`_map_of_options` = decode$12(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_simple` = decode$1(in$)
          case 1 => value$.`_optional_array` = decode$4(in$)
          case 2 => value$.`_array_of_options` = decode$8(in$)
          case 3 => value$.`_map_of_options` = decode$12(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$1(value$: _root_.scala.Option[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$2(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(1)
        encode$3(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$1(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$2(in$))
      case 1 => { decode$3(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$2(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$2(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$3(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$3(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$4(value$: _root_.scala.Option[_root_.scala.List[_root_.scala.Boolean]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.scala.List[_root_.scala.Boolean] @unchecked)) =>
        out$.writeIndex(0)
        encode$5(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(1)
        encode$7(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$4(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.List[_root_.scala.Boolean]] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$5(in$))
      case 1 => { decode$7(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$5(value$: _root_.scala.List[_root_.scala.Boolean], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$6(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$5(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Boolean] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Boolean]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$6(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$6(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$6(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$7(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$7(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$8(value$: _root_.scala.List[_root_.scala.Option[_root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$9(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$8(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Option[_root_.java.lang.String]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Option[_root_.java.lang.String]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$9(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$9(value$: _root_.scala.Option[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$10(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(1)
        encode$11(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$9(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$10(in$))
      case 1 => { decode$11(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$10(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$10(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$11(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$11(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$12(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$13(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$12(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$13(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$13(value$: _root_.scala.Option[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$14(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(1)
        encode$15(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$13(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$14(in$))
      case 1 => { decode$15(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$14(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$14(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$15(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$15(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }
}

object OptionsWithNullAsSecondType {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"OptionsWithNullAsSecondType","namespace":"avro2s.test.unions","fields":[{"name":"_simple","type":["string","null"]},{"name":"_optional_array","type":[{"type":"array","items":"boolean"},"null"]},{"name":"_array_of_options","type":{"type":"array","items":["string","null"]}},{"name":"_map_of_options","type":{"type":"map","values":["string","null"]}}]}""")
}