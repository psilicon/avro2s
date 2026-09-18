/** GENERATED CODE */

package avro2s.test.logical

import scala.annotation.switch

case class ComplexLogicalTypes(var _map: Map[String, java.util.UUID], var _map_alt: Map[String, java.time.LocalDate], var _array: List[java.time.LocalDate], var _union: Int | java.time.Instant, var _option: Option[java.util.UUID], var _option_alt: Option[java.time.LocalDate], var _map_union: Map[String, Int | java.time.Instant], var _map_option: Map[String, Option[java.time.Instant]], var _map_array: Map[String, List[java.time.LocalDate]], var _union_map: Int | Map[String, java.util.UUID], var _union_map_alt: Int | Map[String, java.time.LocalDate], var _union_array: Int | List[java.time.LocalDate], var _array_map: List[Map[String, java.util.UUID]], var _array_map_alt: List[Map[String, java.time.LocalDate]], var _array_union: List[Int | java.time.Instant], var _array_option: List[Option[java.util.UUID]], var _array_option_alt: List[Option[java.time.LocalDate]]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(Map.empty, Map.empty, List.empty, 0, None, None, Map.empty, Map.empty, Map.empty, 0, 0, 0, List.empty, List.empty, List.empty, List.empty, List.empty)

  override def getSchema: org.apache.avro.Schema = ComplexLogicalTypes.SCHEMA$

  override def getSpecificData(): org.apache.avro.specific.SpecificData = ComplexLogicalTypes.MODEL$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => {
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
      case 1 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_alt.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_alt.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2.asInstanceOf[AnyRef]
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 2 => _array match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[java.time.LocalDate](0) else new java.util.ArrayList[java.time.LocalDate](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 3 => _union match {
        case x: Int => x.asInstanceOf[AnyRef]
        case x: java.time.Instant => x.asInstanceOf[AnyRef]
      }
      case 4 => _option match {
        case Some(x: java.util.UUID) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 5 => _option_alt match {
        case Some(x: java.time.LocalDate) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 6 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_union.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_union.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case x: Int => x.asInstanceOf[AnyRef]
              case x: java.time.Instant => x.asInstanceOf[AnyRef]
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 7 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_option.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_option.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case Some(x: java.time.Instant) => x.asInstanceOf[AnyRef]
              case None => null.asInstanceOf[AnyRef]
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 8 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_array.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_array.foreach { kvp =>
          val key = kvp._1
          val value = {
            if (kvp._2.isEmpty) new java.util.ArrayList[java.time.LocalDate](0) else new java.util.ArrayList[java.time.LocalDate](scala.jdk.CollectionConverters.SeqHasAsJava(kvp._2).asJava)
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 9 => _union_map match {
        case x: Int => x.asInstanceOf[AnyRef]
        case x: Map[String, java.util.UUID] =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = x.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              kvp._2.asInstanceOf[AnyRef]
            }
            map.put(key, value)
          }
          map
      }
      case 10 => _union_map_alt match {
        case x: Int => x.asInstanceOf[AnyRef]
        case x: Map[String, java.time.LocalDate] =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = x.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              kvp._2.asInstanceOf[AnyRef]
            }
            map.put(key, value)
          }
          map
      }
      case 11 => _union_array match {
        case x: Int => x.asInstanceOf[AnyRef]
        case x: List[java.time.LocalDate] =>
          if (x.isEmpty) new java.util.ArrayList[java.time.LocalDate](0) else new java.util.ArrayList[java.time.LocalDate](scala.jdk.CollectionConverters.SeqHasAsJava(x).asJava)
      }
      case 12 => _array_map match {
        case array =>
          {
            def toJavaArray$(input$: List[Map[String, java.util.UUID]]): java.util.ArrayList[AnyRef] = {
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
      case 13 => _array_map_alt match {
        case array =>
          {
            def toJavaArray$(input$: List[Map[String, java.time.LocalDate]]): java.util.ArrayList[AnyRef] = {
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
      case 14 => _array_union match {
        case array =>
          {
            def toJavaArray$(input$: List[Int | java.time.Instant]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case x: Int => x.asInstanceOf[AnyRef]
                    case x: java.time.Instant => x.asInstanceOf[AnyRef]
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 15 => _array_option match {
        case array =>
          {
            def toJavaArray$(input$: List[Option[java.util.UUID]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case Some(x: java.util.UUID) => x.asInstanceOf[AnyRef]
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
      case 16 => _array_option_alt match {
        case array =>
          {
            def toJavaArray$(input$: List[Option[java.time.LocalDate]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case Some(x: java.time.LocalDate) => x.asInstanceOf[AnyRef]
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
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._map = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, java.util.UUID] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value.asInstanceOf[java.util.UUID]
            })
          }.toMap
        }
      }
      case 1 => this._map_alt = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, java.time.LocalDate] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value.asInstanceOf[java.time.LocalDate]
            })
          }.toMap
        }
      }
      case 2 => this._array = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[java.time.LocalDate]
        }).toList
      }
      case 3 => this._union = {
        value match {
          case x: Int => x
          case x: java.time.Instant => x
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 4 => this._option = {
        value match {
          case null => None
          case x: java.util.UUID => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 5 => this._option_alt = {
        value match {
          case null => None
          case x: java.time.LocalDate => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 6 => this._map_union = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Int | java.time.Instant] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case x: Int => x
                case x: java.time.Instant => x
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            })
          }.toMap
        }
      }
      case 7 => this._map_option = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[java.time.Instant]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case null => None
                case x: java.time.Instant => Option(x)
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            })
          }.toMap
        }
      }
      case 8 => this._map_array = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, List[java.time.LocalDate]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              val array = value.asInstanceOf[java.util.List[?]]
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value.asInstanceOf[java.time.LocalDate]
              }).toList
            })
          }.toMap
        }
      }
      case 9 => this._union_map = {
        value match {
          case x: Int => x
          case map: java.util.Map[?,?] =>
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, java.util.UUID] else {
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value.asInstanceOf[java.util.UUID]
                })
              }.toMap
            }
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 10 => this._union_map_alt = {
        value match {
          case x: Int => x
          case map: java.util.Map[?,?] =>
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, java.time.LocalDate] else {
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value.asInstanceOf[java.time.LocalDate]
                })
              }.toMap
            }
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 11 => this._union_array = {
        value match {
          case x: Int => x
          case array: java.util.List[?] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value.asInstanceOf[java.time.LocalDate]
            }).toList
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 12 => this._array_map = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          val map = value.asInstanceOf[java.util.Map[?,?]]
          if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, java.util.UUID] else {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value.asInstanceOf[java.util.UUID]
              })
            }.toMap
          }
        }).toList
      }
      case 13 => this._array_map_alt = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          val map = value.asInstanceOf[java.util.Map[?,?]]
          if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, java.time.LocalDate] else {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value.asInstanceOf[java.time.LocalDate]
              })
            }.toMap
          }
        }).toList
      }
      case 14 => this._array_union = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case x: Int => x
            case x: java.time.Instant => x
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case 15 => this._array_option = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case null => None
            case x: java.util.UUID => Option(x)
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case 16 => this._array_option_alt = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case null => None
            case x: java.time.LocalDate => Option(x)
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

  private def encode$0(value$: _root_.avro2s.test.logical.ComplexLogicalTypes, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`_map`, out$)
    encode$3(value$.`_map_alt`, out$)
    encode$5(value$.`_array`, out$)
    encode$7(value$.`_union`, out$)
    encode$10(value$.`_option`, out$)
    encode$13(value$.`_option_alt`, out$)
    encode$16(value$.`_map_union`, out$)
    encode$20(value$.`_map_option`, out$)
    encode$24(value$.`_map_array`, out$)
    encode$27(value$.`_union_map`, out$)
    encode$31(value$.`_union_map_alt`, out$)
    encode$35(value$.`_union_array`, out$)
    encode$39(value$.`_array_map`, out$)
    encode$42(value$.`_array_map_alt`, out$)
    encode$45(value$.`_array_union`, out$)
    encode$49(value$.`_array_option`, out$)
    encode$53(value$.`_array_option_alt`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.logical.ComplexLogicalTypes): _root_.avro2s.test.logical.ComplexLogicalTypes = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.logical.ComplexLogicalTypes() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.logical.ComplexLogicalTypes, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_map` = decode$1(in$)
      value$.`_map_alt` = decode$3(in$)
      value$.`_array` = decode$5(in$)
      value$.`_union` = decode$7(in$)
      value$.`_option` = decode$10(in$)
      value$.`_option_alt` = decode$13(in$)
      value$.`_map_union` = decode$16(in$)
      value$.`_map_option` = decode$20(in$)
      value$.`_map_array` = decode$24(in$)
      value$.`_union_map` = decode$27(in$)
      value$.`_union_map_alt` = decode$31(in$)
      value$.`_union_array` = decode$35(in$)
      value$.`_array_map` = decode$39(in$)
      value$.`_array_map_alt` = decode$42(in$)
      value$.`_array_union` = decode$45(in$)
      value$.`_array_option` = decode$49(in$)
      value$.`_array_option_alt` = decode$53(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_map` = decode$1(in$)
          case 1 => value$.`_map_alt` = decode$3(in$)
          case 2 => value$.`_array` = decode$5(in$)
          case 3 => value$.`_union` = decode$7(in$)
          case 4 => value$.`_option` = decode$10(in$)
          case 5 => value$.`_option_alt` = decode$13(in$)
          case 6 => value$.`_map_union` = decode$16(in$)
          case 7 => value$.`_map_option` = decode$20(in$)
          case 8 => value$.`_map_array` = decode$24(in$)
          case 9 => value$.`_union_map` = decode$27(in$)
          case 10 => value$.`_union_map_alt` = decode$31(in$)
          case 11 => value$.`_union_array` = decode$35(in$)
          case 12 => value$.`_array_map` = decode$39(in$)
          case 13 => value$.`_array_map_alt` = decode$42(in$)
          case 14 => value$.`_array_union` = decode$45(in$)
          case 15 => value$.`_array_option` = decode$49(in$)
          case 16 => value$.`_array_option_alt` = decode$53(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$1(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, java.util.UUID], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$1(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, java.util.UUID] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, java.util.UUID]
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

  private def encode$2(value$: java.util.UUID, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$2.toCharSequence(value$, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$2, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$2.getLogicalType)
    out$.writeString(raw$)
  }

  private def decode$2(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.util.UUID = {
    _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$2.fromCharSequence(in$.readString(), _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$2, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$2.getLogicalType)
  }

  private def encode$3(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, java.time.LocalDate], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$4(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$3(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, java.time.LocalDate] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, java.time.LocalDate]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$4(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$4(value$: java.time.LocalDate, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$4.toInt(value$, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$4, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$4.getLogicalType)
    out$.writeInt(raw$)
  }

  private def decode$4(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.LocalDate = {
    _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$4.fromInt(in$.readInt(), _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$4, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$4.getLogicalType)
  }

  private def encode$5(value$: _root_.scala.List[java.time.LocalDate], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$5(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[java.time.LocalDate] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[java.time.LocalDate]
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

  private def encode$6(value$: java.time.LocalDate, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$6.toInt(value$, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$6, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$6.getLogicalType)
    out$.writeInt(raw$)
  }

  private def decode$6(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.LocalDate = {
    _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$6.fromInt(in$.readInt(), _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$6, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$6.getLogicalType)
  }

  private def encode$7(value$: _root_.scala.Int | java.time.Instant, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.scala.Int @unchecked) =>
        out$.writeIndex(0)
        encode$8(branch$, out$)
      case branch$: (java.time.Instant @unchecked) =>
        out$.writeIndex(1)
        encode$9(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$7(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int | java.time.Instant = {
    in$.readIndex() match {
      case 0 => decode$8(in$)
      case 1 => decode$9(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$8(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$8(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$9(value$: java.time.Instant, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$9.toLong(value$, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$9, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$9.getLogicalType)
    out$.writeLong(raw$)
  }

  private def decode$9(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.Instant = {
    _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$9.fromLong(in$.readLong(), _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$9, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$9.getLogicalType)
  }

  private def encode$10(value$: _root_.scala.Option[java.util.UUID], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$11(null, out$)
      case _root_.scala.Some(branch$: (java.util.UUID @unchecked)) =>
        out$.writeIndex(1)
        encode$12(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$10(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[java.util.UUID] = {
    in$.readIndex() match {
      case 0 => { decode$11(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$12(in$))
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

  private def encode$12(value$: java.util.UUID, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$12.toCharSequence(value$, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$12, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$12.getLogicalType)
    out$.writeString(raw$)
  }

  private def decode$12(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.util.UUID = {
    _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$12.fromCharSequence(in$.readString(), _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$12, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$12.getLogicalType)
  }

  private def encode$13(value$: _root_.scala.Option[java.time.LocalDate], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$14(null, out$)
      case _root_.scala.Some(branch$: (java.time.LocalDate @unchecked)) =>
        out$.writeIndex(1)
        encode$15(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$13(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[java.time.LocalDate] = {
    in$.readIndex() match {
      case 0 => { decode$14(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$15(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$14(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$14(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$15(value$: java.time.LocalDate, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$15.toInt(value$, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$15, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$15.getLogicalType)
    out$.writeInt(raw$)
  }

  private def decode$15(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.LocalDate = {
    _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$15.fromInt(in$.readInt(), _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$15, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$15.getLogicalType)
  }

  private def encode$16(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Int | java.time.Instant], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$17(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$16(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Int | java.time.Instant] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Int | java.time.Instant]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$17(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$17(value$: _root_.scala.Int | java.time.Instant, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.scala.Int @unchecked) =>
        out$.writeIndex(0)
        encode$18(branch$, out$)
      case branch$: (java.time.Instant @unchecked) =>
        out$.writeIndex(1)
        encode$19(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$17(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int | java.time.Instant = {
    in$.readIndex() match {
      case 0 => decode$18(in$)
      case 1 => decode$19(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$18(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$18(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$19(value$: java.time.Instant, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$19.toLong(value$, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$19, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$19.getLogicalType)
    out$.writeLong(raw$)
  }

  private def decode$19(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.Instant = {
    _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$19.fromLong(in$.readLong(), _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$19, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$19.getLogicalType)
  }

  private def encode$20(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[java.time.Instant]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$21(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$20(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[java.time.Instant]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Option[java.time.Instant]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$21(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$21(value$: _root_.scala.Option[java.time.Instant], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$22(null, out$)
      case _root_.scala.Some(branch$: (java.time.Instant @unchecked)) =>
        out$.writeIndex(1)
        encode$23(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$21(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[java.time.Instant] = {
    in$.readIndex() match {
      case 0 => { decode$22(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$23(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$22(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$22(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$23(value$: java.time.Instant, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$23.toLong(value$, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$23, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$23.getLogicalType)
    out$.writeLong(raw$)
  }

  private def decode$23(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.Instant = {
    _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$23.fromLong(in$.readLong(), _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$23, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$23.getLogicalType)
  }

  private def encode$24(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[java.time.LocalDate]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$25(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$24(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[java.time.LocalDate]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.List[java.time.LocalDate]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$25(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$25(value$: _root_.scala.List[java.time.LocalDate], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$26(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$25(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[java.time.LocalDate] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[java.time.LocalDate]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$26(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$26(value$: java.time.LocalDate, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$26.toInt(value$, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$26, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$26.getLogicalType)
    out$.writeInt(raw$)
  }

  private def decode$26(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.LocalDate = {
    _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$26.fromInt(in$.readInt(), _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$26, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$26.getLogicalType)
  }

  private def encode$27(value$: _root_.scala.Int | _root_.scala.collection.immutable.Map[_root_.java.lang.String, java.util.UUID], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.scala.Int @unchecked) =>
        out$.writeIndex(0)
        encode$28(branch$, out$)
      case branch$: (_root_.scala.collection.immutable.Map[_root_.java.lang.String, java.util.UUID] @unchecked) =>
        out$.writeIndex(1)
        encode$29(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$27(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int | _root_.scala.collection.immutable.Map[_root_.java.lang.String, java.util.UUID] = {
    in$.readIndex() match {
      case 0 => decode$28(in$)
      case 1 => decode$29(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$28(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$28(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$29(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, java.util.UUID], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$30(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$29(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, java.util.UUID] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, java.util.UUID]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$30(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$30(value$: java.util.UUID, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$30.toCharSequence(value$, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$30, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$30.getLogicalType)
    out$.writeString(raw$)
  }

  private def decode$30(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.util.UUID = {
    _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$30.fromCharSequence(in$.readString(), _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$30, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$30.getLogicalType)
  }

  private def encode$31(value$: _root_.scala.Int | _root_.scala.collection.immutable.Map[_root_.java.lang.String, java.time.LocalDate], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.scala.Int @unchecked) =>
        out$.writeIndex(0)
        encode$32(branch$, out$)
      case branch$: (_root_.scala.collection.immutable.Map[_root_.java.lang.String, java.time.LocalDate] @unchecked) =>
        out$.writeIndex(1)
        encode$33(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$31(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int | _root_.scala.collection.immutable.Map[_root_.java.lang.String, java.time.LocalDate] = {
    in$.readIndex() match {
      case 0 => decode$32(in$)
      case 1 => decode$33(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$32(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$32(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$33(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, java.time.LocalDate], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$33(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, java.time.LocalDate] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, java.time.LocalDate]
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

  private def encode$34(value$: java.time.LocalDate, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$34.toInt(value$, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$34, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$34.getLogicalType)
    out$.writeInt(raw$)
  }

  private def decode$34(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.LocalDate = {
    _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$34.fromInt(in$.readInt(), _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$34, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$34.getLogicalType)
  }

  private def encode$35(value$: _root_.scala.Int | _root_.scala.List[java.time.LocalDate], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.scala.Int @unchecked) =>
        out$.writeIndex(0)
        encode$36(branch$, out$)
      case branch$: (_root_.scala.List[java.time.LocalDate] @unchecked) =>
        out$.writeIndex(1)
        encode$37(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$35(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int | _root_.scala.List[java.time.LocalDate] = {
    in$.readIndex() match {
      case 0 => decode$36(in$)
      case 1 => decode$37(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$36(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$36(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$37(value$: _root_.scala.List[java.time.LocalDate], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$38(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$37(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[java.time.LocalDate] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[java.time.LocalDate]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$38(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$38(value$: java.time.LocalDate, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$38.toInt(value$, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$38, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$38.getLogicalType)
    out$.writeInt(raw$)
  }

  private def decode$38(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.LocalDate = {
    _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$38.fromInt(in$.readInt(), _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$38, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$38.getLogicalType)
  }

  private def encode$39(value$: _root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, java.util.UUID]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$40(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$39(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, java.util.UUID]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.collection.immutable.Map[_root_.java.lang.String, java.util.UUID]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$40(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$40(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, java.util.UUID], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$41(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$40(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, java.util.UUID] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, java.util.UUID]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$41(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$41(value$: java.util.UUID, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$41.toCharSequence(value$, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$41, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$41.getLogicalType)
    out$.writeString(raw$)
  }

  private def decode$41(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.util.UUID = {
    _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$41.fromCharSequence(in$.readString(), _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$41, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$41.getLogicalType)
  }

  private def encode$42(value$: _root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, java.time.LocalDate]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$42(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, java.time.LocalDate]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.collection.immutable.Map[_root_.java.lang.String, java.time.LocalDate]]
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

  private def encode$43(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, java.time.LocalDate], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$44(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$43(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, java.time.LocalDate] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, java.time.LocalDate]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$44(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$44(value$: java.time.LocalDate, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$44.toInt(value$, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$44, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$44.getLogicalType)
    out$.writeInt(raw$)
  }

  private def decode$44(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.LocalDate = {
    _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$44.fromInt(in$.readInt(), _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$44, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$44.getLogicalType)
  }

  private def encode$45(value$: _root_.scala.List[_root_.scala.Int | java.time.Instant], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$46(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$45(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Int | java.time.Instant] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Int | java.time.Instant]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$46(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$46(value$: _root_.scala.Int | java.time.Instant, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.scala.Int @unchecked) =>
        out$.writeIndex(0)
        encode$47(branch$, out$)
      case branch$: (java.time.Instant @unchecked) =>
        out$.writeIndex(1)
        encode$48(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$46(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int | java.time.Instant = {
    in$.readIndex() match {
      case 0 => decode$47(in$)
      case 1 => decode$48(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$47(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$47(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$48(value$: java.time.Instant, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$48.toLong(value$, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$48, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$48.getLogicalType)
    out$.writeLong(raw$)
  }

  private def decode$48(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.Instant = {
    _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$48.fromLong(in$.readLong(), _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$48, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$48.getLogicalType)
  }

  private def encode$49(value$: _root_.scala.List[_root_.scala.Option[java.util.UUID]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$50(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$49(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Option[java.util.UUID]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Option[java.util.UUID]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$50(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$50(value$: _root_.scala.Option[java.util.UUID], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$51(null, out$)
      case _root_.scala.Some(branch$: (java.util.UUID @unchecked)) =>
        out$.writeIndex(1)
        encode$52(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$50(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[java.util.UUID] = {
    in$.readIndex() match {
      case 0 => { decode$51(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$52(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$51(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$51(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$52(value$: java.util.UUID, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$52.toCharSequence(value$, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$52, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$52.getLogicalType)
    out$.writeString(raw$)
  }

  private def decode$52(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.util.UUID = {
    _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$52.fromCharSequence(in$.readString(), _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$52, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$52.getLogicalType)
  }

  private def encode$53(value$: _root_.scala.List[_root_.scala.Option[java.time.LocalDate]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$54(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$53(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Option[java.time.LocalDate]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Option[java.time.LocalDate]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$54(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$54(value$: _root_.scala.Option[java.time.LocalDate], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$55(null, out$)
      case _root_.scala.Some(branch$: (java.time.LocalDate @unchecked)) =>
        out$.writeIndex(1)
        encode$56(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$54(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[java.time.LocalDate] = {
    in$.readIndex() match {
      case 0 => { decode$55(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$56(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$55(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$55(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$56(value$: java.time.LocalDate, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$56.toInt(value$, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$56, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$56.getLogicalType)
    out$.writeInt(raw$)
  }

  private def decode$56(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.LocalDate = {
    _root_.avro2s.test.logical.ComplexLogicalTypes.customConversion$56.fromInt(in$.readInt(), _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$56, _root_.avro2s.test.logical.ComplexLogicalTypes.customSchema$56.getLogicalType)
  }
}

object ComplexLogicalTypes {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"ComplexLogicalTypes","namespace":"avro2s.test.logical","fields":[{"name":"_map","type":{"type":"map","values":{"type":"string","logicalType":"uuid"}}},{"name":"_map_alt","type":{"type":"map","values":{"type":"int","logicalType":"date"}}},{"name":"_array","type":{"type":"array","items":{"type":"int","logicalType":"date"}}},{"name":"_union","type":["int",{"type":"long","logicalType":"timestamp-millis"}]},{"name":"_option","type":["null",{"type":"string","logicalType":"uuid"}]},{"name":"_option_alt","type":["null",{"type":"int","logicalType":"date"}]},{"name":"_map_union","type":{"type":"map","values":["int",{"type":"long","logicalType":"timestamp-millis"}]}},{"name":"_map_option","type":{"type":"map","values":["null",{"type":"long","logicalType":"timestamp-millis"}]}},{"name":"_map_array","type":{"type":"map","values":{"type":"array","items":{"type":"int","logicalType":"date"}}}},{"name":"_union_map","type":["int",{"type":"map","values":{"type":"string","logicalType":"uuid"}}]},{"name":"_union_map_alt","type":["int",{"type":"map","values":{"type":"int","logicalType":"date"}}]},{"name":"_union_array","type":["int",{"type":"array","items":{"type":"int","logicalType":"date"}}]},{"name":"_array_map","type":{"type":"array","items":{"type":"map","values":{"type":"string","logicalType":"uuid"}}}},{"name":"_array_map_alt","type":{"type":"array","items":{"type":"map","values":{"type":"int","logicalType":"date"}}}},{"name":"_array_union","type":{"type":"array","items":["int",{"type":"long","logicalType":"timestamp-millis"}]}},{"name":"_array_option","type":{"type":"array","items":["null",{"type":"string","logicalType":"uuid"}]}},{"name":"_array_option_alt","type":{"type":"array","items":["null",{"type":"int","logicalType":"date"}]}}]}""")
  val $UUIDConversion: org.apache.avro.Conversion[?] = new org.apache.avro.Conversions.UUIDConversion()
  val $DateConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.DateConversion()
  val $TimestampMillisConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.TimestampMillisConversion()
  val MODEL$: org.apache.avro.specific.SpecificData = {
    val model = new org.apache.avro.specific.SpecificData()
    model.addLogicalTypeConversion($UUIDConversion)
    model.addLogicalTypeConversion($DateConversion)
    model.addLogicalTypeConversion($TimestampMillisConversion)
    model
  }
  private val customSchema$2: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(0).schema().getValueType
  private val customConversion$2 = new _root_.org.apache.avro.Conversions.UUIDConversion()
  private val customSchema$4: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(1).schema().getValueType
  private val customConversion$4 = new _root_.org.apache.avro.data.TimeConversions.DateConversion()
  private val customSchema$6: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(2).schema().getElementType
  private val customConversion$6 = new _root_.org.apache.avro.data.TimeConversions.DateConversion()
  private val customSchema$9: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(3).schema().getTypes.get(1)
  private val customConversion$9 = new _root_.org.apache.avro.data.TimeConversions.TimestampMillisConversion()
  private val customSchema$12: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(4).schema().getTypes.get(1)
  private val customConversion$12 = new _root_.org.apache.avro.Conversions.UUIDConversion()
  private val customSchema$15: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(5).schema().getTypes.get(1)
  private val customConversion$15 = new _root_.org.apache.avro.data.TimeConversions.DateConversion()
  private val customSchema$19: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(6).schema().getValueType.getTypes.get(1)
  private val customConversion$19 = new _root_.org.apache.avro.data.TimeConversions.TimestampMillisConversion()
  private val customSchema$23: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(7).schema().getValueType.getTypes.get(1)
  private val customConversion$23 = new _root_.org.apache.avro.data.TimeConversions.TimestampMillisConversion()
  private val customSchema$26: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(8).schema().getValueType.getElementType
  private val customConversion$26 = new _root_.org.apache.avro.data.TimeConversions.DateConversion()
  private val customSchema$30: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(9).schema().getTypes.get(1).getValueType
  private val customConversion$30 = new _root_.org.apache.avro.Conversions.UUIDConversion()
  private val customSchema$34: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(10).schema().getTypes.get(1).getValueType
  private val customConversion$34 = new _root_.org.apache.avro.data.TimeConversions.DateConversion()
  private val customSchema$38: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(11).schema().getTypes.get(1).getElementType
  private val customConversion$38 = new _root_.org.apache.avro.data.TimeConversions.DateConversion()
  private val customSchema$41: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(12).schema().getElementType.getValueType
  private val customConversion$41 = new _root_.org.apache.avro.Conversions.UUIDConversion()
  private val customSchema$44: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(13).schema().getElementType.getValueType
  private val customConversion$44 = new _root_.org.apache.avro.data.TimeConversions.DateConversion()
  private val customSchema$48: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(14).schema().getElementType.getTypes.get(1)
  private val customConversion$48 = new _root_.org.apache.avro.data.TimeConversions.TimestampMillisConversion()
  private val customSchema$52: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(15).schema().getElementType.getTypes.get(1)
  private val customConversion$52 = new _root_.org.apache.avro.Conversions.UUIDConversion()
  private val customSchema$56: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(16).schema().getElementType.getTypes.get(1)
  private val customConversion$56 = new _root_.org.apache.avro.data.TimeConversions.DateConversion()
}