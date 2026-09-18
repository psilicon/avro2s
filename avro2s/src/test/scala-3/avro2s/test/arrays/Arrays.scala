/** GENERATED CODE */

package avro2s.test.arrays

import scala.annotation.switch

case class Arrays(var _array_of_arrays: List[List[String]], var _array_of_maps: List[Map[String, String]], var _array_of_unions: List[String | Int], var _array_of_records: List[avro2s.test.arrays.Record], var _array_of_union_of_records: List[avro2s.test.arrays.Record1 | avro2s.test.arrays.Record2 | Int], var _array_of_enums: List[avro2s.test.arrays.Enum], var _array_of_fixed: List[avro2s.test.arrays.Fixed], var _array_of_bytes: List[Array[Byte]], var _array_of_strings: List[String], var _array_of_ints: List[Int], var _array_of_longs: List[Long], var _array_of_floats: List[Float], var _array_of_doubles: List[Double], var _array_of_booleans: List[Boolean], var _array_of_union_of_only_records: List[avro2s.test.arrays.RecordA | avro2s.test.arrays.RecordB], var _array_of_union_of_only_enums: List[avro2s.test.arrays.EnumA | avro2s.test.arrays.EnumB], var _array_of_union_of_only_fixed: List[avro2s.test.arrays.FixedA | avro2s.test.arrays.FixedB]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty)

  override def getSchema: org.apache.avro.Schema = Arrays.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _array_of_arrays match {
        case array =>
          {
            def toJavaArray$(input$: List[List[String]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  if (element$.isEmpty) new java.util.ArrayList[String](0) else new java.util.ArrayList[String](scala.jdk.CollectionConverters.SeqHasAsJava(element$).asJava)
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 1 => _array_of_maps match {
        case array =>
          {
            def toJavaArray$(input$: List[Map[String, String]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = element$.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
                  element$.foreach { kvp =>
                    val key = kvp._1
                    val value = {
                      kvp._2.asInstanceOf[AnyRef]
                    }
                    map.put(key, value)
                  }
                  map
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 2 => _array_of_unions match {
        case array =>
          {
            def toJavaArray$(input$: List[String | Int]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case x: String => x.asInstanceOf[AnyRef]
                    case x: Int => x.asInstanceOf[AnyRef]
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 3 => _array_of_records match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[avro2s.test.arrays.Record](0) else new java.util.ArrayList[avro2s.test.arrays.Record](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 4 => _array_of_union_of_records match {
        case array =>
          {
            def toJavaArray$(input$: List[avro2s.test.arrays.Record1 | avro2s.test.arrays.Record2 | Int]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case x: avro2s.test.arrays.Record1 => x.asInstanceOf[AnyRef]
                    case x: avro2s.test.arrays.Record2 => x.asInstanceOf[AnyRef]
                    case x: Int => x.asInstanceOf[AnyRef]
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 5 => _array_of_enums match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[avro2s.test.arrays.Enum](0) else new java.util.ArrayList[avro2s.test.arrays.Enum](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 6 => _array_of_fixed match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[avro2s.test.arrays.Fixed](0) else new java.util.ArrayList[avro2s.test.arrays.Fixed](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 7 => _array_of_bytes match {
        case array =>
          {
            def toJavaArray$(input$: List[Array[Byte]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  java.nio.ByteBuffer.wrap(element$)
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 8 => _array_of_strings match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[String](0) else new java.util.ArrayList[String](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 9 => _array_of_ints match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[Int](0) else new java.util.ArrayList[Int](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 10 => _array_of_longs match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[Long](0) else new java.util.ArrayList[Long](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 11 => _array_of_floats match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[Float](0) else new java.util.ArrayList[Float](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 12 => _array_of_doubles match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[Double](0) else new java.util.ArrayList[Double](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 13 => _array_of_booleans match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[Boolean](0) else new java.util.ArrayList[Boolean](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 14 => _array_of_union_of_only_records match {
        case array =>
          {
            def toJavaArray$(input$: List[avro2s.test.arrays.RecordA | avro2s.test.arrays.RecordB]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case x: avro2s.test.arrays.RecordA => x.asInstanceOf[AnyRef]
                    case x: avro2s.test.arrays.RecordB => x.asInstanceOf[AnyRef]
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 15 => _array_of_union_of_only_enums match {
        case array =>
          {
            def toJavaArray$(input$: List[avro2s.test.arrays.EnumA | avro2s.test.arrays.EnumB]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case x: avro2s.test.arrays.EnumA => x.asInstanceOf[AnyRef]
                    case x: avro2s.test.arrays.EnumB => x.asInstanceOf[AnyRef]
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 16 => _array_of_union_of_only_fixed match {
        case array =>
          {
            def toJavaArray$(input$: List[avro2s.test.arrays.FixedA | avro2s.test.arrays.FixedB]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case x: avro2s.test.arrays.FixedA => x.asInstanceOf[AnyRef]
                    case x: avro2s.test.arrays.FixedB => x.asInstanceOf[AnyRef]
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._array_of_arrays = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          val array = value.asInstanceOf[java.util.List[?]]
          scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
            value.toString
          }).toList
        }).toList
      }
      case 1 => this._array_of_maps = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          val map = value.asInstanceOf[java.util.Map[?,?]]
          if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String] else {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value.toString
              })
            }.toMap
          }
        }).toList
      }
      case 2 => this._array_of_unions = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case x: org.apache.avro.util.Utf8 => x.toString
            case x: Int => x
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case 3 => this._array_of_records = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[avro2s.test.arrays.Record]
        }).toList
      }
      case 4 => this._array_of_union_of_records = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case x: avro2s.test.arrays.Record1 => x.asInstanceOf[avro2s.test.arrays.Record1 | avro2s.test.arrays.Record2 | Int]
            case x: avro2s.test.arrays.Record2 => x.asInstanceOf[avro2s.test.arrays.Record1 | avro2s.test.arrays.Record2 | Int]
            case x: Int => x
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case 5 => this._array_of_enums = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[avro2s.test.arrays.Enum]
        }).toList
      }
      case 6 => this._array_of_fixed = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[avro2s.test.arrays.Fixed]
        }).toList
      }
      case 7 => this._array_of_bytes = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          val buffer = value.asInstanceOf[java.nio.ByteBuffer]
          val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); array
        }).toList
      }
      case 8 => this._array_of_strings = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.toString
        }).toList
      }
      case 9 => this._array_of_ints = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[Int]
        }).toList
      }
      case 10 => this._array_of_longs = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[Long]
        }).toList
      }
      case 11 => this._array_of_floats = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[Float]
        }).toList
      }
      case 12 => this._array_of_doubles = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[Double]
        }).toList
      }
      case 13 => this._array_of_booleans = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[Boolean]
        }).toList
      }
      case 14 => this._array_of_union_of_only_records = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case x: avro2s.test.arrays.RecordA => x.asInstanceOf[avro2s.test.arrays.RecordA | avro2s.test.arrays.RecordB]
            case x: avro2s.test.arrays.RecordB => x.asInstanceOf[avro2s.test.arrays.RecordA | avro2s.test.arrays.RecordB]
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case 15 => this._array_of_union_of_only_enums = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case x: avro2s.test.arrays.EnumA => x.asInstanceOf[avro2s.test.arrays.EnumA | avro2s.test.arrays.EnumB]
            case x: avro2s.test.arrays.EnumB => x.asInstanceOf[avro2s.test.arrays.EnumA | avro2s.test.arrays.EnumB]
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case 16 => this._array_of_union_of_only_fixed = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case x: avro2s.test.arrays.FixedA => x.asInstanceOf[avro2s.test.arrays.FixedA | avro2s.test.arrays.FixedB]
            case x: avro2s.test.arrays.FixedB => x.asInstanceOf[avro2s.test.arrays.FixedA | avro2s.test.arrays.FixedB]
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override protected def hasCustomCoders(): Boolean = true
  override def customEncode(out$: _root_.org.apache.avro.io.Encoder): Unit = encode$0(this, out$)
  override def customDecode(in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = decodeRecord$0(this, in$)

  private def encode$0(value$: _root_.avro2s.test.arrays.Arrays, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`_array_of_arrays`, out$)
    encode$4(value$.`_array_of_maps`, out$)
    encode$7(value$.`_array_of_unions`, out$)
    encode$11(value$.`_array_of_records`, out$)
    encode$15(value$.`_array_of_union_of_records`, out$)
    encode$24(value$.`_array_of_enums`, out$)
    encode$26(value$.`_array_of_fixed`, out$)
    encode$28(value$.`_array_of_bytes`, out$)
    encode$30(value$.`_array_of_strings`, out$)
    encode$32(value$.`_array_of_ints`, out$)
    encode$34(value$.`_array_of_longs`, out$)
    encode$36(value$.`_array_of_floats`, out$)
    encode$38(value$.`_array_of_doubles`, out$)
    encode$40(value$.`_array_of_booleans`, out$)
    encode$42(value$.`_array_of_union_of_only_records`, out$)
    encode$48(value$.`_array_of_union_of_only_enums`, out$)
    encode$52(value$.`_array_of_union_of_only_fixed`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.arrays.Arrays): _root_.avro2s.test.arrays.Arrays = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.arrays.Arrays() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.arrays.Arrays, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_array_of_arrays` = decode$1(in$)
      value$.`_array_of_maps` = decode$4(in$)
      value$.`_array_of_unions` = decode$7(in$)
      value$.`_array_of_records` = decode$11(in$)
      value$.`_array_of_union_of_records` = decode$15(in$)
      value$.`_array_of_enums` = decode$24(in$)
      value$.`_array_of_fixed` = decode$26(in$)
      value$.`_array_of_bytes` = decode$28(in$)
      value$.`_array_of_strings` = decode$30(in$)
      value$.`_array_of_ints` = decode$32(in$)
      value$.`_array_of_longs` = decode$34(in$)
      value$.`_array_of_floats` = decode$36(in$)
      value$.`_array_of_doubles` = decode$38(in$)
      value$.`_array_of_booleans` = decode$40(in$)
      value$.`_array_of_union_of_only_records` = decode$42(in$)
      value$.`_array_of_union_of_only_enums` = decode$48(in$)
      value$.`_array_of_union_of_only_fixed` = decode$52(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_array_of_arrays` = decode$1(in$)
          case 1 => value$.`_array_of_maps` = decode$4(in$)
          case 2 => value$.`_array_of_unions` = decode$7(in$)
          case 3 => value$.`_array_of_records` = decode$11(in$)
          case 4 => value$.`_array_of_union_of_records` = decode$15(in$)
          case 5 => value$.`_array_of_enums` = decode$24(in$)
          case 6 => value$.`_array_of_fixed` = decode$26(in$)
          case 7 => value$.`_array_of_bytes` = decode$28(in$)
          case 8 => value$.`_array_of_strings` = decode$30(in$)
          case 9 => value$.`_array_of_ints` = decode$32(in$)
          case 10 => value$.`_array_of_longs` = decode$34(in$)
          case 11 => value$.`_array_of_floats` = decode$36(in$)
          case 12 => value$.`_array_of_doubles` = decode$38(in$)
          case 13 => value$.`_array_of_booleans` = decode$40(in$)
          case 14 => value$.`_array_of_union_of_only_records` = decode$42(in$)
          case 15 => value$.`_array_of_union_of_only_enums` = decode$48(in$)
          case 16 => value$.`_array_of_union_of_only_fixed` = decode$52(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$1(value$: _root_.scala.List[_root_.scala.List[_root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$2(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$1(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.List[_root_.java.lang.String]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.List[_root_.java.lang.String]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$2(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$2(value$: _root_.scala.List[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$3(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$2(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.java.lang.String] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$3(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$3(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$3(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$4(value$: _root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$5(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$4(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$5(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$5(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$6(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$5(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$6(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$6(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$6(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$7(value$: _root_.scala.List[_root_.java.lang.String | _root_.scala.Int], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$8(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$7(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.java.lang.String | _root_.scala.Int] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.java.lang.String | _root_.scala.Int]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$8(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$8(value$: _root_.java.lang.String | _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.java.lang.String @unchecked) =>
        out$.writeIndex(0)
        encode$9(branch$, out$)
      case branch$: (_root_.scala.Int @unchecked) =>
        out$.writeIndex(1)
        encode$10(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$8(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String | _root_.scala.Int = {
    in$.readIndex() match {
      case 0 => decode$9(in$)
      case 1 => decode$10(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$9(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$9(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$10(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$10(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$11(value$: _root_.scala.List[_root_.avro2s.test.arrays.Record], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$12(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$11(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.avro2s.test.arrays.Record] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.avro2s.test.arrays.Record]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$12(in$, null)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$12(value$: _root_.avro2s.test.arrays.Record, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$13(value$.`_string`, out$)
    encode$14(value$.`_int`, out$)
  }

  private def decode$12(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.arrays.Record): _root_.avro2s.test.arrays.Record = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.arrays.Record() else reuse$
    decodeRecord$12(result$, in$)
    result$
  }

  private def decodeRecord$12(value$: _root_.avro2s.test.arrays.Record, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$13(in$)
      value$.`_int` = decode$14(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$13(in$)
          case 1 => value$.`_int` = decode$14(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$13(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$13(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$14(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$14(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$15(value$: _root_.scala.List[_root_.avro2s.test.arrays.Record1 | _root_.avro2s.test.arrays.Record2 | _root_.scala.Int], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$16(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$15(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.avro2s.test.arrays.Record1 | _root_.avro2s.test.arrays.Record2 | _root_.scala.Int] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.avro2s.test.arrays.Record1 | _root_.avro2s.test.arrays.Record2 | _root_.scala.Int]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$16(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$16(value$: _root_.avro2s.test.arrays.Record1 | _root_.avro2s.test.arrays.Record2 | _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.avro2s.test.arrays.Record1 @unchecked) =>
        out$.writeIndex(0)
        encode$17(branch$, out$)
      case branch$: (_root_.avro2s.test.arrays.Record2 @unchecked) =>
        out$.writeIndex(1)
        encode$20(branch$, out$)
      case branch$: (_root_.scala.Int @unchecked) =>
        out$.writeIndex(2)
        encode$23(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$16(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.arrays.Record1 | _root_.avro2s.test.arrays.Record2 | _root_.scala.Int = {
    in$.readIndex() match {
      case 0 => decode$17(in$, null)
      case 1 => decode$20(in$, null)
      case 2 => decode$23(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$17(value$: _root_.avro2s.test.arrays.Record1, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$18(value$.`_string`, out$)
    encode$19(value$.`_int`, out$)
  }

  private def decode$17(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.arrays.Record1): _root_.avro2s.test.arrays.Record1 = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.arrays.Record1() else reuse$
    decodeRecord$17(result$, in$)
    result$
  }

  private def decodeRecord$17(value$: _root_.avro2s.test.arrays.Record1, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$18(in$)
      value$.`_int` = decode$19(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$18(in$)
          case 1 => value$.`_int` = decode$19(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
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

  private def encode$20(value$: _root_.avro2s.test.arrays.Record2, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$21(value$.`_string`, out$)
    encode$22(value$.`_int`, out$)
  }

  private def decode$20(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.arrays.Record2): _root_.avro2s.test.arrays.Record2 = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.arrays.Record2() else reuse$
    decodeRecord$20(result$, in$)
    result$
  }

  private def decodeRecord$20(value$: _root_.avro2s.test.arrays.Record2, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$21(in$)
      value$.`_int` = decode$22(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$21(in$)
          case 1 => value$.`_int` = decode$22(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$21(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$21(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$22(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$22(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$23(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$23(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$24(value$: _root_.scala.List[_root_.avro2s.test.arrays.Enum], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$25(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$24(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.avro2s.test.arrays.Enum] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.avro2s.test.arrays.Enum]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$25(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$25(value$: _root_.avro2s.test.arrays.Enum, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeEnum(value$.ordinal())
  }

  private def decode$25(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.arrays.Enum = {
    _root_.avro2s.test.arrays.Arrays.customEnum$25(in$.readEnum())
  }

  private def encode$26(value$: _root_.scala.List[_root_.avro2s.test.arrays.Fixed], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$27(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$26(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.avro2s.test.arrays.Fixed] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.avro2s.test.arrays.Fixed]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$27(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$27(value$: _root_.avro2s.test.arrays.Fixed, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFixed(value$.bytes(), 0, 2)
  }

  private def decode$27(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.arrays.Fixed = {
    val result$ = new _root_.avro2s.test.arrays.Fixed()
    in$.readFixed(result$.bytes())
    result$
  }

  private def encode$28(value$: _root_.scala.List[_root_.scala.Array[_root_.scala.Byte]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$29(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$28(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Array[_root_.scala.Byte]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Array[_root_.scala.Byte]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$29(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$29(value$: _root_.scala.Array[_root_.scala.Byte], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBytes(value$)
  }

  private def decode$29(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Array[_root_.scala.Byte] = {
    val buffer$ = in$.readBytes(null)
    if (buffer$.hasArray && buffer$.arrayOffset() == 0 && buffer$.position() == 0 && buffer$.remaining() == buffer$.array().length) buffer$.array()
    else {
      val bytes$ = new _root_.scala.Array[Byte](buffer$.remaining())
      buffer$.get(bytes$)
      bytes$
    }
  }

  private def encode$30(value$: _root_.scala.List[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$31(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$30(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.java.lang.String] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$31(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$31(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$31(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$32(value$: _root_.scala.List[_root_.scala.Int], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$33(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$32(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Int] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Int]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$33(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$33(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$33(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$34(value$: _root_.scala.List[_root_.scala.Long], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$35(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$34(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Long] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Long]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$35(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$35(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$35(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$36(value$: _root_.scala.List[_root_.scala.Float], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$37(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$36(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Float] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Float]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$37(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$37(value$: _root_.scala.Float, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFloat(value$)
  }

  private def decode$37(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Float = {
    in$.readFloat()
  }

  private def encode$38(value$: _root_.scala.List[_root_.scala.Double], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$39(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$38(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Double] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Double]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$39(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$39(value$: _root_.scala.Double, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeDouble(value$)
  }

  private def decode$39(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double = {
    in$.readDouble()
  }

  private def encode$40(value$: _root_.scala.List[_root_.scala.Boolean], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$41(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$40(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Boolean] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Boolean]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$41(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$41(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$41(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$42(value$: _root_.scala.List[_root_.avro2s.test.arrays.RecordA | _root_.avro2s.test.arrays.RecordB], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$43(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$42(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.avro2s.test.arrays.RecordA | _root_.avro2s.test.arrays.RecordB] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.avro2s.test.arrays.RecordA | _root_.avro2s.test.arrays.RecordB]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$43(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$43(value$: _root_.avro2s.test.arrays.RecordA | _root_.avro2s.test.arrays.RecordB, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.avro2s.test.arrays.RecordA @unchecked) =>
        out$.writeIndex(0)
        encode$44(branch$, out$)
      case branch$: (_root_.avro2s.test.arrays.RecordB @unchecked) =>
        out$.writeIndex(1)
        encode$46(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$43(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.arrays.RecordA | _root_.avro2s.test.arrays.RecordB = {
    in$.readIndex() match {
      case 0 => decode$44(in$, null)
      case 1 => decode$46(in$, null)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$44(value$: _root_.avro2s.test.arrays.RecordA, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$45(value$.`_string`, out$)
  }

  private def decode$44(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.arrays.RecordA): _root_.avro2s.test.arrays.RecordA = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.arrays.RecordA() else reuse$
    decodeRecord$44(result$, in$)
    result$
  }

  private def decodeRecord$44(value$: _root_.avro2s.test.arrays.RecordA, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$45(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$45(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$45(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$45(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$46(value$: _root_.avro2s.test.arrays.RecordB, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$47(value$.`_string`, out$)
  }

  private def decode$46(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.arrays.RecordB): _root_.avro2s.test.arrays.RecordB = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.arrays.RecordB() else reuse$
    decodeRecord$46(result$, in$)
    result$
  }

  private def decodeRecord$46(value$: _root_.avro2s.test.arrays.RecordB, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$47(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$47(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$47(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$47(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$48(value$: _root_.scala.List[_root_.avro2s.test.arrays.EnumA | _root_.avro2s.test.arrays.EnumB], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$49(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$48(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.avro2s.test.arrays.EnumA | _root_.avro2s.test.arrays.EnumB] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.avro2s.test.arrays.EnumA | _root_.avro2s.test.arrays.EnumB]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$49(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$49(value$: _root_.avro2s.test.arrays.EnumA | _root_.avro2s.test.arrays.EnumB, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.avro2s.test.arrays.EnumA @unchecked) =>
        out$.writeIndex(0)
        encode$50(branch$, out$)
      case branch$: (_root_.avro2s.test.arrays.EnumB @unchecked) =>
        out$.writeIndex(1)
        encode$51(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$49(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.arrays.EnumA | _root_.avro2s.test.arrays.EnumB = {
    in$.readIndex() match {
      case 0 => decode$50(in$)
      case 1 => decode$51(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$50(value$: _root_.avro2s.test.arrays.EnumA, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeEnum(value$.ordinal())
  }

  private def decode$50(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.arrays.EnumA = {
    _root_.avro2s.test.arrays.Arrays.customEnum$50(in$.readEnum())
  }

  private def encode$51(value$: _root_.avro2s.test.arrays.EnumB, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeEnum(value$.ordinal())
  }

  private def decode$51(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.arrays.EnumB = {
    _root_.avro2s.test.arrays.Arrays.customEnum$51(in$.readEnum())
  }

  private def encode$52(value$: _root_.scala.List[_root_.avro2s.test.arrays.FixedA | _root_.avro2s.test.arrays.FixedB], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$53(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$52(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.avro2s.test.arrays.FixedA | _root_.avro2s.test.arrays.FixedB] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.avro2s.test.arrays.FixedA | _root_.avro2s.test.arrays.FixedB]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$53(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$53(value$: _root_.avro2s.test.arrays.FixedA | _root_.avro2s.test.arrays.FixedB, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.avro2s.test.arrays.FixedA @unchecked) =>
        out$.writeIndex(0)
        encode$54(branch$, out$)
      case branch$: (_root_.avro2s.test.arrays.FixedB @unchecked) =>
        out$.writeIndex(1)
        encode$55(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$53(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.arrays.FixedA | _root_.avro2s.test.arrays.FixedB = {
    in$.readIndex() match {
      case 0 => decode$54(in$)
      case 1 => decode$55(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$54(value$: _root_.avro2s.test.arrays.FixedA, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFixed(value$.bytes(), 0, 2)
  }

  private def decode$54(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.arrays.FixedA = {
    val result$ = new _root_.avro2s.test.arrays.FixedA()
    in$.readFixed(result$.bytes())
    result$
  }

  private def encode$55(value$: _root_.avro2s.test.arrays.FixedB, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFixed(value$.bytes(), 0, 2)
  }

  private def decode$55(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.arrays.FixedB = {
    val result$ = new _root_.avro2s.test.arrays.FixedB()
    in$.readFixed(result$.bytes())
    result$
  }
}

object Arrays {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Arrays","namespace":"avro2s.test.arrays","fields":[{"name":"_array_of_arrays","type":{"type":"array","items":{"type":"array","items":"string","default":[]},"default":[]}},{"name":"_array_of_maps","type":{"type":"array","items":{"type":"map","values":"string","default":{}},"default":[]}},{"name":"_array_of_unions","type":{"type":"array","items":["string","int"],"default":[]}},{"name":"_array_of_records","type":{"type":"array","items":{"type":"record","name":"Record","fields":[{"name":"_string","type":"string"},{"name":"_int","type":"int"}]},"default":[]}},{"name":"_array_of_union_of_records","type":{"type":"array","items":[{"type":"record","name":"Record1","fields":[{"name":"_string","type":"string"},{"name":"_int","type":"int"}]},{"type":"record","name":"Record2","fields":[{"name":"_string","type":"string"},{"name":"_int","type":"int"}]},"int"],"default":[]}},{"name":"_array_of_enums","type":{"type":"array","items":{"type":"enum","name":"Enum","symbols":["A","B","C"]},"default":[]}},{"name":"_array_of_fixed","type":{"type":"array","items":{"type":"fixed","name":"Fixed","size":2},"default":[]}},{"name":"_array_of_bytes","type":{"type":"array","items":"bytes","default":[]}},{"name":"_array_of_strings","type":{"type":"array","items":"string","default":[]}},{"name":"_array_of_ints","type":{"type":"array","items":"int","default":[]}},{"name":"_array_of_longs","type":{"type":"array","items":"long","default":[]}},{"name":"_array_of_floats","type":{"type":"array","items":"float","default":[]}},{"name":"_array_of_doubles","type":{"type":"array","items":"double","default":[]}},{"name":"_array_of_booleans","type":{"type":"array","items":"boolean","default":[]}},{"name":"_array_of_union_of_only_records","type":{"type":"array","items":[{"type":"record","name":"RecordA","fields":[{"name":"_string","type":"string"}]},{"type":"record","name":"RecordB","fields":[{"name":"_string","type":"string"}]}],"default":[]}},{"name":"_array_of_union_of_only_enums","type":{"type":"array","items":[{"type":"enum","name":"EnumA","symbols":["A","B","C"]},{"type":"enum","name":"EnumB","symbols":["A","B","C"]}],"default":[]}},{"name":"_array_of_union_of_only_fixed","type":{"type":"array","items":[{"type":"fixed","name":"FixedA","size":2},{"type":"fixed","name":"FixedB","size":2}],"default":[]}}]}""")
  private val customSchema$25: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(5).schema().getElementType
  private val customEnum$25: _root_.scala.Array[_root_.avro2s.test.arrays.Enum] = {
    val result$ = new _root_.scala.Array[_root_.avro2s.test.arrays.Enum](customSchema$25.getEnumSymbols.size())
    var i$ = 0
    while (i$ < result$.length) {
      result$(i$) = _root_.avro2s.test.arrays.Enum.valueOf(customSchema$25.getEnumSymbols.get(i$))
      i$ += 1
    }
    result$
  }
  private val customSchema$50: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(15).schema().getElementType.getTypes.get(0)
  private val customEnum$50: _root_.scala.Array[_root_.avro2s.test.arrays.EnumA] = {
    val result$ = new _root_.scala.Array[_root_.avro2s.test.arrays.EnumA](customSchema$50.getEnumSymbols.size())
    var i$ = 0
    while (i$ < result$.length) {
      result$(i$) = _root_.avro2s.test.arrays.EnumA.valueOf(customSchema$50.getEnumSymbols.get(i$))
      i$ += 1
    }
    result$
  }
  private val customSchema$51: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(15).schema().getElementType.getTypes.get(1)
  private val customEnum$51: _root_.scala.Array[_root_.avro2s.test.arrays.EnumB] = {
    val result$ = new _root_.scala.Array[_root_.avro2s.test.arrays.EnumB](customSchema$51.getEnumSymbols.size())
    var i$ = 0
    while (i$ < result$.length) {
      result$(i$) = _root_.avro2s.test.arrays.EnumB.valueOf(customSchema$51.getEnumSymbols.get(i$))
      i$ += 1
    }
    result$
  }
}