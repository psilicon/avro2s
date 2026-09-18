/** GENERATED CODE */

package avro2s.test.unions

import scala.annotation.switch

case class ComplexOptions(var _map_of_option_of_record: Map[String, Option[avro2s.test.unions.RecordForComplexOptions]], var _map_of_option_of_map: Map[String, Option[Map[String, String]]], var _map_of_option_of_array: Map[String, Option[List[String]]], var _array_of_option_of_record: List[Option[avro2s.test.unions.RecordForComplexOptions]], var _array_of_option_of_map: List[Option[Map[String, String]]], var _array_of_option_of_array: List[Option[List[String]]], var _array_of_map_of_option_of_record: List[Map[String, Option[avro2s.test.unions.RecordForComplexOptions]]], var _map_of_array_of_option_of_record: Map[String, List[Option[avro2s.test.unions.RecordForComplexOptions]]], var _map_of_option_of_bytes: Map[String, Option[Array[Byte]]], var _map_of_option_of_fixed: Map[String, Option[avro2s.test.unions.FixedForComplexOptions]], var _map_of_option_of_enum: Map[String, Option[avro2s.test.unions.EnumForComplexOptions]]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(Map.empty, Map.empty, Map.empty, List.empty, List.empty, List.empty, List.empty, Map.empty, Map.empty, Map.empty, Map.empty)

  override def getSchema: org.apache.avro.Schema = ComplexOptions.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_option_of_record.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_option_of_record.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case Some(x: avro2s.test.unions.RecordForComplexOptions) => x.asInstanceOf[AnyRef]
              case None => null.asInstanceOf[AnyRef]
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 1 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_option_of_map.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_option_of_map.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case Some(x: Map[String, String]) =>
                val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = x.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
                x.foreach { kvp =>
                  val key = kvp._1
                  val value = {
                    kvp._2.asInstanceOf[AnyRef]
                  }
                  map.put(key, value)
                }
                map
              case None => null.asInstanceOf[AnyRef]
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 2 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_option_of_array.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_option_of_array.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case Some(x: List[String]) =>
                if (x.isEmpty) new java.util.ArrayList[String](0) else new java.util.ArrayList[String](scala.jdk.CollectionConverters.SeqHasAsJava(x).asJava)
              case None => null.asInstanceOf[AnyRef]
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 3 => _array_of_option_of_record match {
        case array =>
          {
            def toJavaArray$(input$: List[Option[avro2s.test.unions.RecordForComplexOptions]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case Some(x: avro2s.test.unions.RecordForComplexOptions) => x.asInstanceOf[AnyRef]
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
      case 4 => _array_of_option_of_map match {
        case array =>
          {
            def toJavaArray$(input$: List[Option[Map[String, String]]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case Some(x: Map[String, String]) =>
                      val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = x.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
                      x.foreach { kvp =>
                        val key = kvp._1
                        val value = {
                          kvp._2.asInstanceOf[AnyRef]
                        }
                        map.put(key, value)
                      }
                      map
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
      case 5 => _array_of_option_of_array match {
        case array =>
          {
            def toJavaArray$(input$: List[Option[List[String]]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case Some(x: List[String]) =>
                      if (x.isEmpty) new java.util.ArrayList[String](0) else new java.util.ArrayList[String](scala.jdk.CollectionConverters.SeqHasAsJava(x).asJava)
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
      case 6 => _array_of_map_of_option_of_record match {
        case array =>
          {
            def toJavaArray$(input$: List[Map[String, Option[avro2s.test.unions.RecordForComplexOptions]]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = element$.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
                  element$.foreach { kvp =>
                    val key = kvp._1
                    val value = {
                      kvp._2 match {
                        case Some(x: avro2s.test.unions.RecordForComplexOptions) => x.asInstanceOf[AnyRef]
                        case None => null.asInstanceOf[AnyRef]
                      }
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
      case 7 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_array_of_option_of_record.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_array_of_option_of_record.foreach { kvp =>
          val key = kvp._1
          val value = {
            {
              def toJavaArray$(input$: List[Option[avro2s.test.unions.RecordForComplexOptions]]): java.util.ArrayList[AnyRef] = {
                var remaining$ = input$
                val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
                while (remaining$.nonEmpty) {
                  val element$ = remaining$.head
                  result$.add({
                    element$ match {
                      case Some(x: avro2s.test.unions.RecordForComplexOptions) => x.asInstanceOf[AnyRef]
                      case None => null.asInstanceOf[AnyRef]
                    }
                  })
                  remaining$ = remaining$.tail
                }
                result$
              }
              toJavaArray$(kvp._2)
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 8 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_option_of_bytes.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_option_of_bytes.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case Some(x: Array[Byte]) =>
              java.nio.ByteBuffer.wrap(x).asInstanceOf[AnyRef]
              case None => null.asInstanceOf[AnyRef]
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 9 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_option_of_fixed.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_option_of_fixed.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case Some(x: avro2s.test.unions.FixedForComplexOptions) => x.asInstanceOf[AnyRef]
              case None => null.asInstanceOf[AnyRef]
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 10 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_option_of_enum.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_option_of_enum.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case Some(x: avro2s.test.unions.EnumForComplexOptions) => x.asInstanceOf[AnyRef]
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
      case 0 => this._map_of_option_of_record = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[avro2s.test.unions.RecordForComplexOptions]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case null => None
                case x: avro2s.test.unions.RecordForComplexOptions => Option(x.asInstanceOf[avro2s.test.unions.RecordForComplexOptions])
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            })
          }.toMap
        }
      }
      case 1 => this._map_of_option_of_map = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[Map[String, String]]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case null => None
                case map: java.util.Map[?,?] =>
                  Option(if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String] else {
                    scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                      val key = kvp._1.toString
                      val value = kvp._2
                      (key, {
                        value.toString
                      })
                    }.toMap
                  })
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            })
          }.toMap
        }
      }
      case 2 => this._map_of_option_of_array = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[List[String]]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case null => None
                case array: java.util.List[?] =>
                  Option(scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                    value.toString
                  }).toList)
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            })
          }.toMap
        }
      }
      case 3 => this._array_of_option_of_record = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case null => None
            case x: avro2s.test.unions.RecordForComplexOptions => Option(x.asInstanceOf[avro2s.test.unions.RecordForComplexOptions])
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case 4 => this._array_of_option_of_map = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case null => None
            case map: java.util.Map[?,?] =>
              Option(if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String] else {
                scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                  val key = kvp._1.toString
                  val value = kvp._2
                  (key, {
                    value.toString
                  })
                }.toMap
              })
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case 5 => this._array_of_option_of_array = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case null => None
            case array: java.util.List[?] =>
              Option(scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value.toString
              }).toList)
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case 6 => this._array_of_map_of_option_of_record = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          val map = value.asInstanceOf[java.util.Map[?,?]]
          if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[avro2s.test.unions.RecordForComplexOptions]] else {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case null => None
                  case x: avro2s.test.unions.RecordForComplexOptions => Option(x.asInstanceOf[avro2s.test.unions.RecordForComplexOptions])
                  case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                }
              })
            }.toMap
          }
        }).toList
      }
      case 7 => this._map_of_array_of_option_of_record = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, List[Option[avro2s.test.unions.RecordForComplexOptions]]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              val array = value.asInstanceOf[java.util.List[?]]
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value match {
                  case null => None
                  case x: avro2s.test.unions.RecordForComplexOptions => Option(x.asInstanceOf[avro2s.test.unions.RecordForComplexOptions])
                  case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                }
              }).toList
            })
          }.toMap
        }
      }
      case 8 => this._map_of_option_of_bytes = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[Array[Byte]]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case null => None
                case x: java.nio.ByteBuffer => Option(x.array())
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            })
          }.toMap
        }
      }
      case 9 => this._map_of_option_of_fixed = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[avro2s.test.unions.FixedForComplexOptions]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case null => None
                case x: avro2s.test.unions.FixedForComplexOptions => Option(x.asInstanceOf[avro2s.test.unions.FixedForComplexOptions])
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            })
          }.toMap
        }
      }
      case 10 => this._map_of_option_of_enum = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[avro2s.test.unions.EnumForComplexOptions]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case null => None
                case x: avro2s.test.unions.EnumForComplexOptions => Option(x.asInstanceOf[avro2s.test.unions.EnumForComplexOptions])
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

  private def encode$0(value$: _root_.avro2s.test.unions.ComplexOptions, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`_map_of_option_of_record`, out$)
    encode$6(value$.`_map_of_option_of_map`, out$)
    encode$11(value$.`_map_of_option_of_array`, out$)
    encode$16(value$.`_array_of_option_of_record`, out$)
    encode$19(value$.`_array_of_option_of_map`, out$)
    encode$24(value$.`_array_of_option_of_array`, out$)
    encode$29(value$.`_array_of_map_of_option_of_record`, out$)
    encode$33(value$.`_map_of_array_of_option_of_record`, out$)
    encode$37(value$.`_map_of_option_of_bytes`, out$)
    encode$41(value$.`_map_of_option_of_fixed`, out$)
    encode$45(value$.`_map_of_option_of_enum`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.unions.ComplexOptions): _root_.avro2s.test.unions.ComplexOptions = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.unions.ComplexOptions() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.unions.ComplexOptions, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_map_of_option_of_record` = decode$1(in$)
      value$.`_map_of_option_of_map` = decode$6(in$)
      value$.`_map_of_option_of_array` = decode$11(in$)
      value$.`_array_of_option_of_record` = decode$16(in$)
      value$.`_array_of_option_of_map` = decode$19(in$)
      value$.`_array_of_option_of_array` = decode$24(in$)
      value$.`_array_of_map_of_option_of_record` = decode$29(in$)
      value$.`_map_of_array_of_option_of_record` = decode$33(in$)
      value$.`_map_of_option_of_bytes` = decode$37(in$)
      value$.`_map_of_option_of_fixed` = decode$41(in$)
      value$.`_map_of_option_of_enum` = decode$45(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_map_of_option_of_record` = decode$1(in$)
          case 1 => value$.`_map_of_option_of_map` = decode$6(in$)
          case 2 => value$.`_map_of_option_of_array` = decode$11(in$)
          case 3 => value$.`_array_of_option_of_record` = decode$16(in$)
          case 4 => value$.`_array_of_option_of_map` = decode$19(in$)
          case 5 => value$.`_array_of_option_of_array` = decode$24(in$)
          case 6 => value$.`_array_of_map_of_option_of_record` = decode$29(in$)
          case 7 => value$.`_map_of_array_of_option_of_record` = decode$33(in$)
          case 8 => value$.`_map_of_option_of_bytes` = decode$37(in$)
          case 9 => value$.`_map_of_option_of_fixed` = decode$41(in$)
          case 10 => value$.`_map_of_option_of_enum` = decode$45(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$1(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$2(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$1(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$2(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$2(value$: _root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$3(null, out$)
      case _root_.scala.Some(branch$: (_root_.avro2s.test.unions.RecordForComplexOptions @unchecked)) =>
        out$.writeIndex(1)
        encode$4(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$2(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions] = {
    in$.readIndex() match {
      case 0 => { decode$3(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$4(in$, null))
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

  private def encode$4(value$: _root_.avro2s.test.unions.RecordForComplexOptions, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$5(value$.`field1`, out$)
  }

  private def decode$4(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.unions.RecordForComplexOptions): _root_.avro2s.test.unions.RecordForComplexOptions = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.unions.RecordForComplexOptions() else reuse$
    decodeRecord$4(result$, in$)
    result$
  }

  private def decodeRecord$4(value$: _root_.avro2s.test.unions.RecordForComplexOptions, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`field1` = decode$5(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`field1` = decode$5(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$5(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$5(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$6(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$7(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$6(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$7(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$7(value$: _root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$8(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String] @unchecked)) =>
        out$.writeIndex(1)
        encode$9(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$7(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]] = {
    in$.readIndex() match {
      case 0 => { decode$8(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$9(in$))
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

  private def encode$9(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$10(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$9(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$10(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$10(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$10(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$11(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.scala.List[_root_.java.lang.String]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$12(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$11(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.scala.List[_root_.java.lang.String]]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Option[_root_.scala.List[_root_.java.lang.String]]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$12(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$12(value$: _root_.scala.Option[_root_.scala.List[_root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$13(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.List[_root_.java.lang.String] @unchecked)) =>
        out$.writeIndex(1)
        encode$14(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$12(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.List[_root_.java.lang.String]] = {
    in$.readIndex() match {
      case 0 => { decode$13(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$14(in$))
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

  private def encode$14(value$: _root_.scala.List[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$15(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$14(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.java.lang.String] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$15(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$15(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$15(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$16(value$: _root_.scala.List[_root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$17(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$16(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$17(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$17(value$: _root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$18(null, out$)
      case _root_.scala.Some(branch$: (_root_.avro2s.test.unions.RecordForComplexOptions @unchecked)) =>
        out$.writeIndex(1)
        encode$4(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$17(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions] = {
    in$.readIndex() match {
      case 0 => { decode$18(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$4(in$, null))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$18(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$18(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$19(value$: _root_.scala.List[_root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$20(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$19(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$20(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$20(value$: _root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$21(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String] @unchecked)) =>
        out$.writeIndex(1)
        encode$22(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$20(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]] = {
    in$.readIndex() match {
      case 0 => { decode$21(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$22(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$21(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$21(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$22(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$23(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$22(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$23(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$23(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$23(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$24(value$: _root_.scala.List[_root_.scala.Option[_root_.scala.List[_root_.java.lang.String]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$24(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Option[_root_.scala.List[_root_.java.lang.String]]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Option[_root_.scala.List[_root_.java.lang.String]]]
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

  private def encode$25(value$: _root_.scala.Option[_root_.scala.List[_root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$26(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.List[_root_.java.lang.String] @unchecked)) =>
        out$.writeIndex(1)
        encode$27(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$25(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.List[_root_.java.lang.String]] = {
    in$.readIndex() match {
      case 0 => { decode$26(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$27(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$26(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$26(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$27(value$: _root_.scala.List[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$28(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$27(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.java.lang.String] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$28(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$28(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$28(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$29(value$: _root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$30(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$29(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$30(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$30(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$31(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$30(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$31(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$31(value$: _root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$32(null, out$)
      case _root_.scala.Some(branch$: (_root_.avro2s.test.unions.RecordForComplexOptions @unchecked)) =>
        out$.writeIndex(1)
        encode$4(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$31(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions] = {
    in$.readIndex() match {
      case 0 => { decode$32(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$4(in$, null))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$32(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$32(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$33(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[_root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$34(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$33(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[_root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.List[_root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$34(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$34(value$: _root_.scala.List[_root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$34(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions]]
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

  private def encode$35(value$: _root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$36(null, out$)
      case _root_.scala.Some(branch$: (_root_.avro2s.test.unions.RecordForComplexOptions @unchecked)) =>
        out$.writeIndex(1)
        encode$4(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$35(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.avro2s.test.unions.RecordForComplexOptions] = {
    in$.readIndex() match {
      case 0 => { decode$36(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$4(in$, null))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$36(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$36(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$37(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.scala.Array[_root_.scala.Byte]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$38(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$37(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.scala.Array[_root_.scala.Byte]]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Option[_root_.scala.Array[_root_.scala.Byte]]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$38(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$38(value$: _root_.scala.Option[_root_.scala.Array[_root_.scala.Byte]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$39(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Array[_root_.scala.Byte] @unchecked)) =>
        out$.writeIndex(1)
        encode$40(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$38(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.Array[_root_.scala.Byte]] = {
    in$.readIndex() match {
      case 0 => { decode$39(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$40(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$39(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$39(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$40(value$: _root_.scala.Array[_root_.scala.Byte], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBytes(value$)
  }

  private def decode$40(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Array[_root_.scala.Byte] = {
    val buffer$ = in$.readBytes(null)
    if (buffer$.hasArray && buffer$.arrayOffset() == 0 && buffer$.position() == 0 && buffer$.remaining() == buffer$.array().length) buffer$.array()
    else {
      val bytes$ = new _root_.scala.Array[Byte](buffer$.remaining())
      buffer$.get(bytes$)
      bytes$
    }
  }

  private def encode$41(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.unions.FixedForComplexOptions]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$42(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$41(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.unions.FixedForComplexOptions]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.unions.FixedForComplexOptions]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$42(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$42(value$: _root_.scala.Option[_root_.avro2s.test.unions.FixedForComplexOptions], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$43(null, out$)
      case _root_.scala.Some(branch$: (_root_.avro2s.test.unions.FixedForComplexOptions @unchecked)) =>
        out$.writeIndex(1)
        encode$44(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$42(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.avro2s.test.unions.FixedForComplexOptions] = {
    in$.readIndex() match {
      case 0 => { decode$43(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$44(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$43(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$43(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$44(value$: _root_.avro2s.test.unions.FixedForComplexOptions, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFixed(value$.bytes(), 0, 16)
  }

  private def decode$44(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.unions.FixedForComplexOptions = {
    val result$ = new _root_.avro2s.test.unions.FixedForComplexOptions()
    in$.readFixed(result$.bytes())
    result$
  }

  private def encode$45(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.unions.EnumForComplexOptions]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$46(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$45(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.unions.EnumForComplexOptions]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.unions.EnumForComplexOptions]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$46(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$46(value$: _root_.scala.Option[_root_.avro2s.test.unions.EnumForComplexOptions], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$47(null, out$)
      case _root_.scala.Some(branch$: (_root_.avro2s.test.unions.EnumForComplexOptions @unchecked)) =>
        out$.writeIndex(1)
        encode$48(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$46(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.avro2s.test.unions.EnumForComplexOptions] = {
    in$.readIndex() match {
      case 0 => { decode$47(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$48(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$47(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$47(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$48(value$: _root_.avro2s.test.unions.EnumForComplexOptions, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeEnum(value$.ordinal())
  }

  private def decode$48(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.unions.EnumForComplexOptions = {
    _root_.avro2s.test.unions.ComplexOptions.customEnum$48(in$.readEnum())
  }
}

object ComplexOptions {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"ComplexOptions","namespace":"avro2s.test.unions","fields":[{"name":"_map_of_option_of_record","type":{"type":"map","values":["null",{"type":"record","name":"RecordForComplexOptions","fields":[{"name":"field1","type":"string"}]}]}},{"name":"_map_of_option_of_map","type":{"type":"map","values":["null",{"type":"map","values":"string"}]}},{"name":"_map_of_option_of_array","type":{"type":"map","values":["null",{"type":"array","items":"string"}]}},{"name":"_array_of_option_of_record","type":{"type":"array","items":["null","RecordForComplexOptions"]}},{"name":"_array_of_option_of_map","type":{"type":"array","items":["null",{"type":"map","values":"string"}]}},{"name":"_array_of_option_of_array","type":{"type":"array","items":["null",{"type":"array","items":"string"}]}},{"name":"_array_of_map_of_option_of_record","type":{"type":"array","items":{"type":"map","values":["null","RecordForComplexOptions"]}}},{"name":"_map_of_array_of_option_of_record","type":{"type":"map","values":{"type":"array","items":["null","RecordForComplexOptions"]}}},{"name":"_map_of_option_of_bytes","type":{"type":"map","values":["null","bytes"]}},{"name":"_map_of_option_of_fixed","type":{"type":"map","values":["null",{"type":"fixed","name":"FixedForComplexOptions","size":16}]}},{"name":"_map_of_option_of_enum","type":{"type":"map","values":["null",{"type":"enum","name":"EnumForComplexOptions","symbols":["A","B","C"]}]}}]}""")
  private val customSchema$48: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(10).schema().getValueType.getTypes.get(1)
  private val customEnum$48: _root_.scala.Array[_root_.avro2s.test.unions.EnumForComplexOptions] = {
    val result$ = new _root_.scala.Array[_root_.avro2s.test.unions.EnumForComplexOptions](customSchema$48.getEnumSymbols.size())
    var i$ = 0
    while (i$ < result$.length) {
      result$(i$) = _root_.avro2s.test.unions.EnumForComplexOptions.valueOf(customSchema$48.getEnumSymbols.get(i$))
      i$ += 1
    }
    result$
  }
}