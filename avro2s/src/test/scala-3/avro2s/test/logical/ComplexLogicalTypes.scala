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
          {
            def toJavaArray$(input$: List[AnyRef]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](input$.size)
              while (remaining$.nonEmpty) {
                result$.add(remaining$.head)
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array.asInstanceOf[List[AnyRef]])
          }
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
            {
              def toJavaArray$(input$: List[AnyRef]): java.util.ArrayList[AnyRef] = {
                var remaining$ = input$
                val result$ = new java.util.ArrayList[AnyRef](input$.size)
                while (remaining$.nonEmpty) {
                  result$.add(remaining$.head)
                  remaining$ = remaining$.tail
                }
                result$
              }
              toJavaArray$(kvp._2.asInstanceOf[List[AnyRef]])
            }
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
          {
            def toJavaArray$(input$: List[AnyRef]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](input$.size)
              while (remaining$.nonEmpty) {
                result$.add(remaining$.head)
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(x.asInstanceOf[List[AnyRef]])
          }
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
}