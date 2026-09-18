/** GENERATED CODE */

package avro2s.test.spec

import scala.annotation.switch

case class AvroSpec(var _null: scala.Null, var _boolean: Boolean, var _int: Int, var _long: Long, var _float: Float, var _double: Double, var _bytes: Array[Byte], var _string: String, var _enum: avro2s.test.spec.Suit, var _array: List[String], var _map: Map[String, Long], var _union_nullable: Option[String], var _union_other: String | Int, var _fixed: avro2s.test.spec.md5) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(null, false, 0, 0, 0, 0, _root_.scala.Array.emptyByteArray, "", null, List.empty, Map.empty, None, "", new avro2s.test.spec.md5())

  override def getSchema: org.apache.avro.Schema = AvroSpec.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _null.asInstanceOf[AnyRef]
      case 1 => _boolean.asInstanceOf[AnyRef]
      case 2 => _int.asInstanceOf[AnyRef]
      case 3 => _long.asInstanceOf[AnyRef]
      case 4 => _float.asInstanceOf[AnyRef]
      case 5 => _double.asInstanceOf[AnyRef]
      case 6 => java.nio.ByteBuffer.wrap(_bytes).asInstanceOf[AnyRef]
      case 7 => _string.asInstanceOf[AnyRef]
      case 8 => _enum.asInstanceOf[AnyRef]
      case 9 => _array match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[String](0) else new java.util.ArrayList[String](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 10 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2.asInstanceOf[AnyRef]
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 11 => _union_nullable match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 12 => _union_other match {
        case x: String => x.asInstanceOf[AnyRef]
        case x: Int => x.asInstanceOf[AnyRef]
      }
      case 13 => _fixed.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._null = {
        value.asInstanceOf[scala.Null]
      }
      case 1 => this._boolean = {
        value.asInstanceOf[Boolean]
      }
      case 2 => this._int = {
        value.asInstanceOf[Int]
      }
      case 3 => this._long = {
        value.asInstanceOf[Long]
      }
      case 4 => this._float = {
        value.asInstanceOf[Float]
      }
      case 5 => this._double = {
        value.asInstanceOf[Double]
      }
      case 6 => this._bytes = {
        val buffer = value.asInstanceOf[java.nio.ByteBuffer]
        val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); array
      }
      case 7 => this._string = {
        value.toString.asInstanceOf[String]
      }
      case 8 => this._enum = {
        value.asInstanceOf[avro2s.test.spec.Suit]
      }
      case 9 => this._array = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.toString
        }).toList
      }
      case 10 => this._map = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Long] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value.asInstanceOf[Long]
            })
          }.toMap
        }
      }
      case 11 => this._union_nullable = {
        value match {
          case null => None
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 12 => this._union_other = {
        value match {
          case x: org.apache.avro.util.Utf8 => x.toString
          case x: Int => x
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 13 => this._fixed = {
        value.asInstanceOf[avro2s.test.spec.md5]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override protected def hasCustomCoders(): Boolean = true
  override def customEncode(out$: _root_.org.apache.avro.io.Encoder): Unit = encode$0(this, out$)
  override def customDecode(in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = decodeRecord$0(this, in$)

  private def encode$0(value$: _root_.avro2s.test.spec.AvroSpec, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`_null`, out$)
    encode$2(value$.`_boolean`, out$)
    encode$3(value$.`_int`, out$)
    encode$4(value$.`_long`, out$)
    encode$5(value$.`_float`, out$)
    encode$6(value$.`_double`, out$)
    encode$7(value$.`_bytes`, out$)
    encode$8(value$.`_string`, out$)
    encode$9(value$.`_enum`, out$)
    encode$10(value$.`_array`, out$)
    encode$12(value$.`_map`, out$)
    encode$14(value$.`_union_nullable`, out$)
    encode$17(value$.`_union_other`, out$)
    encode$20(value$.`_fixed`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.spec.AvroSpec): _root_.avro2s.test.spec.AvroSpec = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.spec.AvroSpec() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.spec.AvroSpec, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_null` = decode$1(in$)
      value$.`_boolean` = decode$2(in$)
      value$.`_int` = decode$3(in$)
      value$.`_long` = decode$4(in$)
      value$.`_float` = decode$5(in$)
      value$.`_double` = decode$6(in$)
      value$.`_bytes` = decode$7(in$)
      value$.`_string` = decode$8(in$)
      value$.`_enum` = decode$9(in$)
      value$.`_array` = decode$10(in$)
      value$.`_map` = decode$12(in$)
      value$.`_union_nullable` = decode$14(in$)
      value$.`_union_other` = decode$17(in$)
      value$.`_fixed` = decode$20(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_null` = decode$1(in$)
          case 1 => value$.`_boolean` = decode$2(in$)
          case 2 => value$.`_int` = decode$3(in$)
          case 3 => value$.`_long` = decode$4(in$)
          case 4 => value$.`_float` = decode$5(in$)
          case 5 => value$.`_double` = decode$6(in$)
          case 6 => value$.`_bytes` = decode$7(in$)
          case 7 => value$.`_string` = decode$8(in$)
          case 8 => value$.`_enum` = decode$9(in$)
          case 9 => value$.`_array` = decode$10(in$)
          case 10 => value$.`_map` = decode$12(in$)
          case 11 => value$.`_union_nullable` = decode$14(in$)
          case 12 => value$.`_union_other` = decode$17(in$)
          case 13 => value$.`_fixed` = decode$20(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$1(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$1(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$2(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$2(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$3(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$3(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$4(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$4(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$5(value$: _root_.scala.Float, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFloat(value$)
  }

  private def decode$5(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Float = {
    in$.readFloat()
  }

  private def encode$6(value$: _root_.scala.Double, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeDouble(value$)
  }

  private def decode$6(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double = {
    in$.readDouble()
  }

  private def encode$7(value$: _root_.scala.Array[_root_.scala.Byte], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBytes(value$)
  }

  private def decode$7(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Array[_root_.scala.Byte] = {
    val buffer$ = in$.readBytes(null)
    if (buffer$.hasArray && buffer$.arrayOffset() == 0 && buffer$.position() == 0 && buffer$.remaining() == buffer$.array().length) buffer$.array()
    else {
      val bytes$ = new _root_.scala.Array[Byte](buffer$.remaining())
      buffer$.get(bytes$)
      bytes$
    }
  }

  private def encode$8(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$8(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$9(value$: _root_.avro2s.test.spec.Suit, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeEnum(value$.ordinal())
  }

  private def decode$9(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.spec.Suit = {
    _root_.avro2s.test.spec.AvroSpec.customEnum$9(in$.readEnum())
  }

  private def encode$10(value$: _root_.scala.List[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$11(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$10(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.java.lang.String] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$11(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$11(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$11(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$12(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Long], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$12(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Long] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Long]
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

  private def encode$13(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$13(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$14(value$: _root_.scala.Option[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$15(null, out$)
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(1)
        encode$16(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$14(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String] = {
    in$.readIndex() match {
      case 0 => { decode$15(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$16(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$15(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$15(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$16(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$16(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$17(value$: _root_.java.lang.String | _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.java.lang.String @unchecked) =>
        out$.writeIndex(0)
        encode$18(branch$, out$)
      case branch$: (_root_.scala.Int @unchecked) =>
        out$.writeIndex(1)
        encode$19(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$17(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String | _root_.scala.Int = {
    in$.readIndex() match {
      case 0 => decode$18(in$)
      case 1 => decode$19(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$18(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$18(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$19(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$19(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$20(value$: _root_.avro2s.test.spec.md5, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFixed(value$.bytes(), 0, 16)
  }

  private def decode$20(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.spec.md5 = {
    val result$ = new _root_.avro2s.test.spec.md5()
    in$.readFixed(result$.bytes())
    result$
  }
}

object AvroSpec {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"AvroSpec","namespace":"avro2s.test.spec","fields":[{"name":"_null","type":"null"},{"name":"_boolean","type":"boolean"},{"name":"_int","type":"int"},{"name":"_long","type":"long"},{"name":"_float","type":"float"},{"name":"_double","type":"double"},{"name":"_bytes","type":"bytes"},{"name":"_string","type":"string"},{"name":"_enum","type":{"type":"enum","name":"Suit","symbols":["SPADES","HEARTS","DIAMONDS","CLUBS"]}},{"name":"_array","type":{"type":"array","items":"string","default":[]}},{"name":"_map","type":{"type":"map","values":"long","default":{}}},{"name":"_union_nullable","type":["null","string"],"default":null},{"name":"_union_other","type":["string","int"]},{"name":"_fixed","type":{"type":"fixed","name":"md5","size":16}}]}""")
  private val customSchema$9: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(8).schema()
  private val customEnum$9: _root_.scala.Array[_root_.avro2s.test.spec.Suit] = {
    val result$ = new _root_.scala.Array[_root_.avro2s.test.spec.Suit](customSchema$9.getEnumSymbols.size())
    var i$ = 0
    while (i$ < result$.length) {
      result$(i$) = _root_.avro2s.test.spec.Suit.valueOf(customSchema$9.getEnumSymbols.get(i$))
      i$ += 1
    }
    result$
  }
}