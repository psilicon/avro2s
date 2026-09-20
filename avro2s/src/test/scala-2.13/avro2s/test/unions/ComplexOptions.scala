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
              case None => null
              case Some(x) => x.asInstanceOf[AnyRef]
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
              case None => null
              case Some(x) =>
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
              case None => null
              case Some(x) =>
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
                    case None => null
                    case Some(x) => x.asInstanceOf[AnyRef]
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
                    case None => null
                    case Some(x) =>
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
                    case None => null
                    case Some(x) =>
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
                        case None => null
                        case Some(x) => x.asInstanceOf[AnyRef]
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
                      case None => null
                      case Some(x) => x.asInstanceOf[AnyRef]
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
              case None => null
              case Some(x) =>
              java.nio.ByteBuffer.wrap(x).asInstanceOf[AnyRef]
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
              case None => null
              case Some(x) => x.asInstanceOf[AnyRef]
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
              case None => null
              case Some(x) => x.asInstanceOf[AnyRef]
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
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[avro2s.test.unions.RecordForComplexOptions]] else {
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value match {
                    case null => None
                    case x: avro2s.test.unions.RecordForComplexOptions => Some(x)
                  }
                })
              }.toMap
            }
          }
        }
      }
      case 1 => this._map_of_option_of_map = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[Map[String, String]]] else {
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value match {
                    case null => None
                    case map: java.util.Map[_,_] => Some{
                      if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String] else {
                        scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                          val key = kvp._1.toString
                          val value = kvp._2
                          (key, {
                            value.toString
                          })
                        }.toMap
                      }
                    }
                  }
                })
              }.toMap
            }
          }
        }
      }
      case 2 => this._map_of_option_of_array = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[List[String]]] else {
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value match {
                    case null => None
                    case x: java.util.List[_] => Some({
                      x match {
                        case array: java.util.List[_] =>
                          scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                            value.toString
                          }).toList
                        }
                    }.toList)
                  }
                })
              }.toMap
            }
          }
        }
      }
      case 3 => this._array_of_option_of_record = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case null => None
                case x: avro2s.test.unions.RecordForComplexOptions => Some(x)
              }
            }).toList
          }
      }
      case 4 => this._array_of_option_of_map = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case null => None
                case map: java.util.Map[_,_] => Some{
                  if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String] else {
                    scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                      val key = kvp._1.toString
                      val value = kvp._2
                      (key, {
                        value.toString
                      })
                    }.toMap
                  }
                }
              }
            }).toList
          }
      }
      case 5 => this._array_of_option_of_array = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case null => None
                case x: java.util.List[_] => Some({
                  x match {
                    case array: java.util.List[_] =>
                      scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                        value.toString
                      }).toList
                    }
                }.toList)
              }
            }).toList
          }
      }
      case 6 => this._array_of_map_of_option_of_record = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case map: java.util.Map[_,_] => {
                  if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[avro2s.test.unions.RecordForComplexOptions]] else {
                    scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                      val key = kvp._1.toString
                      val value = kvp._2
                      (key, {
                        value match {
                          case null => None
                          case x: avro2s.test.unions.RecordForComplexOptions => Some(x)
                        }
                      })
                    }.toMap
                  }
                }
              }
            }).toList
          }
      }
      case 7 => this._map_of_array_of_option_of_record = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, List[Option[avro2s.test.unions.RecordForComplexOptions]]] else {
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value match {
                    case array: java.util.List[_] =>
                      scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                        value match {
                          case null => None
                          case x: avro2s.test.unions.RecordForComplexOptions => Some(x)
                        }
                      }).toList
                    }
                })
              }.toMap
            }
          }
        }
      }
      case 8 => this._map_of_option_of_bytes = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[Array[Byte]]] else {
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value match {
                    case null => None
                    case x: java.nio.ByteBuffer => Some(x.array())
                  }
                })
              }.toMap
            }
          }
        }
      }
      case 9 => this._map_of_option_of_fixed = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[avro2s.test.unions.FixedForComplexOptions]] else {
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value match {
                    case null => None
                    case x: avro2s.test.unions.FixedForComplexOptions => Some(x)
                  }
                })
              }.toMap
            }
          }
        }
      }
      case 10 => this._map_of_option_of_enum = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[avro2s.test.unions.EnumForComplexOptions]] else {
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value match {
                    case null => None
                    case x: avro2s.test.unions.EnumForComplexOptions => Some(x)
                  }
                })
              }.toMap
            }
          }
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object ComplexOptions {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"ComplexOptions","namespace":"avro2s.test.unions","fields":[{"name":"_map_of_option_of_record","type":{"type":"map","values":["null",{"type":"record","name":"RecordForComplexOptions","fields":[{"name":"field1","type":"string"}]}]}},{"name":"_map_of_option_of_map","type":{"type":"map","values":["null",{"type":"map","values":"string"}]}},{"name":"_map_of_option_of_array","type":{"type":"map","values":["null",{"type":"array","items":"string"}]}},{"name":"_array_of_option_of_record","type":{"type":"array","items":["null","RecordForComplexOptions"]}},{"name":"_array_of_option_of_map","type":{"type":"array","items":["null",{"type":"map","values":"string"}]}},{"name":"_array_of_option_of_array","type":{"type":"array","items":["null",{"type":"array","items":"string"}]}},{"name":"_array_of_map_of_option_of_record","type":{"type":"array","items":{"type":"map","values":["null","RecordForComplexOptions"]}}},{"name":"_map_of_array_of_option_of_record","type":{"type":"map","values":{"type":"array","items":["null","RecordForComplexOptions"]}}},{"name":"_map_of_option_of_bytes","type":{"type":"map","values":["null","bytes"]}},{"name":"_map_of_option_of_fixed","type":{"type":"map","values":["null",{"type":"fixed","name":"FixedForComplexOptions","size":16}]}},{"name":"_map_of_option_of_enum","type":{"type":"map","values":["null",{"type":"enum","name":"EnumForComplexOptions","symbols":["A","B","C"]}]}}]}""")
}