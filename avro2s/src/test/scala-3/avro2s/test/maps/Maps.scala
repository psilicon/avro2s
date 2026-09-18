/** GENERATED CODE */

package avro2s.test.maps

import scala.annotation.switch

case class Maps(var _map_of_maps: Map[String, Map[String, String]], var _map_of_union: Map[String, String | Int], var _map_of_union_of_map_of_union: Map[String, Option[String | Long | Boolean | Map[String, Map[String, Option[String | Long | Boolean | Double]]]]], var _map_of_arrays: Map[String, List[String]], var _map_of_arrays_of_maps: Map[String, List[Map[String, Boolean]]], var _map_of_map_of_union: Map[String, Map[String, Option[String | Long | Boolean | Double]]], var _map_of_map_of_arrays: Map[String, Map[String, List[String]]], var _map_of_fixed: Map[String, avro2s.test.maps.Fixed], var _map_of_enum: Map[String, avro2s.test.maps.Enum], var _map_of_record: Map[String, avro2s.test.maps.Record], var _map_of_union_of_record: Map[String, Option[avro2s.test.maps.Record | Int]], var _map_of_bytes: Map[String, Array[Byte]], var _map_of_string: Map[String, String], var _map_of_int: Map[String, Int], var _map_of_long: Map[String, Long], var _map_of_float: Map[String, Float], var _map_of_double: Map[String, Double], var _map_of_boolean: Map[String, Boolean], var _map_of_null: Map[String, scala.Null], var _map_of_union_of_array: Map[String, Option[List[String] | Int]]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty)

  override def getSchema: org.apache.avro.Schema = Maps.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_maps.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_maps.foreach { kvp =>
          val key = kvp._1
          val value = {
            val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = kvp._2.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
            kvp._2.foreach { kvp =>
              val key = kvp._1
              val value = {
                kvp._2.asInstanceOf[AnyRef]
              }
              map.put(key, value)
            }
            map
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 1 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_union.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_union.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case x: String => x.asInstanceOf[AnyRef]
              case x: Int => x.asInstanceOf[AnyRef]
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 2 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_union_of_map_of_union.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_union_of_map_of_union.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case Some(x: String) => x.asInstanceOf[AnyRef]
              case Some(x: Long) => x.asInstanceOf[AnyRef]
              case Some(x: Boolean) => x.asInstanceOf[AnyRef]
              case Some(x: Map[String, Map[String, Option[String | Long | Boolean | Double]]]) =>
                val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = x.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
                x.foreach { kvp =>
                  val key = kvp._1
                  val value = {
                    val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = kvp._2.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
                    kvp._2.foreach { kvp =>
                      val key = kvp._1
                      val value = {
                        kvp._2 match {
                          case Some(x: String) => x.asInstanceOf[AnyRef]
                          case Some(x: Long) => x.asInstanceOf[AnyRef]
                          case Some(x: Boolean) => x.asInstanceOf[AnyRef]
                          case Some(x: Double) => x.asInstanceOf[AnyRef]
                          case None => null.asInstanceOf[AnyRef]
                        }
                      }
                      map.put(key, value)
                    }
                    map
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
      case 3 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_arrays.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_arrays.foreach { kvp =>
          val key = kvp._1
          val value = {
            if (kvp._2.isEmpty) new java.util.ArrayList[String](0) else new java.util.ArrayList[String](scala.jdk.CollectionConverters.SeqHasAsJava(kvp._2).asJava)
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 4 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_arrays_of_maps.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_arrays_of_maps.foreach { kvp =>
          val key = kvp._1
          val value = {
            {
              def toJavaArray$(input$: List[Map[String, Boolean]]): java.util.ArrayList[AnyRef] = {
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
              toJavaArray$(kvp._2)
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 5 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_map_of_union.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_map_of_union.foreach { kvp =>
          val key = kvp._1
          val value = {
            val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = kvp._2.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
            kvp._2.foreach { kvp =>
              val key = kvp._1
              val value = {
                kvp._2 match {
                  case Some(x: String) => x.asInstanceOf[AnyRef]
                  case Some(x: Long) => x.asInstanceOf[AnyRef]
                  case Some(x: Boolean) => x.asInstanceOf[AnyRef]
                  case Some(x: Double) => x.asInstanceOf[AnyRef]
                  case None => null.asInstanceOf[AnyRef]
                }
              }
              map.put(key, value)
            }
            map
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 6 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_map_of_arrays.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_map_of_arrays.foreach { kvp =>
          val key = kvp._1
          val value = {
            val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = kvp._2.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
            kvp._2.foreach { kvp =>
              val key = kvp._1
              val value = {
                if (kvp._2.isEmpty) new java.util.ArrayList[String](0) else new java.util.ArrayList[String](scala.jdk.CollectionConverters.SeqHasAsJava(kvp._2).asJava)
              }
              map.put(key, value)
            }
            map
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 7 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_fixed.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_fixed.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2.asInstanceOf[AnyRef]
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 8 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_enum.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_enum.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2.asInstanceOf[AnyRef]
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 9 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_record.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_record.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2.asInstanceOf[AnyRef]
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 10 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_union_of_record.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_union_of_record.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case Some(x: avro2s.test.maps.Record) => x.asInstanceOf[AnyRef]
              case Some(x: Int) => x.asInstanceOf[AnyRef]
              case None => null.asInstanceOf[AnyRef]
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 11 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_bytes.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_bytes.foreach { kvp =>
          val key = kvp._1
          val value = {
            java.nio.ByteBuffer.wrap(kvp._2)
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 12 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_string.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_string.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2.asInstanceOf[AnyRef]
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 13 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_int.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_int.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2.asInstanceOf[AnyRef]
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 14 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_long.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_long.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2.asInstanceOf[AnyRef]
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 15 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_float.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_float.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2.asInstanceOf[AnyRef]
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 16 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_double.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_double.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2.asInstanceOf[AnyRef]
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 17 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_boolean.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_boolean.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2.asInstanceOf[AnyRef]
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 18 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_null.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_null.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2.asInstanceOf[AnyRef]
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 19 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_union_of_array.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_union_of_array.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case Some(x: List[String]) =>
                if (x.isEmpty) new java.util.ArrayList[String](0) else new java.util.ArrayList[String](scala.jdk.CollectionConverters.SeqHasAsJava(x).asJava)
              case Some(x: Int) => x.asInstanceOf[AnyRef]
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
      case 0 => this._map_of_maps = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Map[String, String]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
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
            })
          }.toMap
        }
      }
      case 1 => this._map_of_union = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String | Int] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case x: org.apache.avro.util.Utf8 => x.toString
                case x: Int => x
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            })
          }.toMap
        }
      }
      case 2 => this._map_of_union_of_map_of_union = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[String | Long | Boolean | Map[String, Map[String, Option[String | Long | Boolean | Double]]]]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case x: org.apache.avro.util.Utf8 => Option(x.toString)
                case x: Long => Option(x)
                case x: Boolean => Option(x)
                case map: java.util.Map[?,?] =>
                  Option(if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Map[String, Option[String | Long | Boolean | Double]]] else {
                    scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                      val key = kvp._1.toString
                      val value = kvp._2
                      (key, {
                        val map = value.asInstanceOf[java.util.Map[?,?]]
                        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[String | Long | Boolean | Double]] else {
                          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                            val key = kvp._1.toString
                            val value = kvp._2
                            (key, {
                              value match {
                                case x: org.apache.avro.util.Utf8 => Option(x.toString)
                                case x: Long => Option(x)
                                case x: Boolean => Option(x)
                                case x: Double => Option(x)
                                case null => None
                                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                              }
                            })
                          }.toMap
                        }
                      })
                    }.toMap
                  })
                case null => None
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            })
          }.toMap
        }
      }
      case 3 => this._map_of_arrays = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, List[String]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              val array = value.asInstanceOf[java.util.List[?]]
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value.toString
              }).toList
            })
          }.toMap
        }
      }
      case 4 => this._map_of_arrays_of_maps = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, List[Map[String, Boolean]]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              val array = value.asInstanceOf[java.util.List[?]]
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                val map = value.asInstanceOf[java.util.Map[?,?]]
                if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Boolean] else {
                  scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                    val key = kvp._1.toString
                    val value = kvp._2
                    (key, {
                      value.asInstanceOf[Boolean]
                    })
                  }.toMap
                }
              }).toList
            })
          }.toMap
        }
      }
      case 5 => this._map_of_map_of_union = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Map[String, Option[String | Long | Boolean | Double]]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              val map = value.asInstanceOf[java.util.Map[?,?]]
              if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[String | Long | Boolean | Double]] else {
                scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                  val key = kvp._1.toString
                  val value = kvp._2
                  (key, {
                    value match {
                      case x: org.apache.avro.util.Utf8 => Option(x.toString)
                      case x: Long => Option(x)
                      case x: Boolean => Option(x)
                      case x: Double => Option(x)
                      case null => None
                      case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                    }
                  })
                }.toMap
              }
            })
          }.toMap
        }
      }
      case 6 => this._map_of_map_of_arrays = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Map[String, List[String]]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              val map = value.asInstanceOf[java.util.Map[?,?]]
              if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, List[String]] else {
                scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                  val key = kvp._1.toString
                  val value = kvp._2
                  (key, {
                    val array = value.asInstanceOf[java.util.List[?]]
                    scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                      value.toString
                    }).toList
                  })
                }.toMap
              }
            })
          }.toMap
        }
      }
      case 7 => this._map_of_fixed = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, avro2s.test.maps.Fixed] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value.asInstanceOf[avro2s.test.maps.Fixed]
            })
          }.toMap
        }
      }
      case 8 => this._map_of_enum = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, avro2s.test.maps.Enum] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value.asInstanceOf[avro2s.test.maps.Enum]
            })
          }.toMap
        }
      }
      case 9 => this._map_of_record = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, avro2s.test.maps.Record] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value.asInstanceOf[avro2s.test.maps.Record]
            })
          }.toMap
        }
      }
      case 10 => this._map_of_union_of_record = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[avro2s.test.maps.Record | Int]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case x: avro2s.test.maps.Record => Option(x.asInstanceOf[avro2s.test.maps.Record | Int])
                case x: Int => Option(x)
                case null => None
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            })
          }.toMap
        }
      }
      case 11 => this._map_of_bytes = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Array[Byte]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              val buffer = value.asInstanceOf[java.nio.ByteBuffer]
              val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); array
            })
          }.toMap
        }
      }
      case 12 => this._map_of_string = {
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
      }
      case 13 => this._map_of_int = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Int] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value.asInstanceOf[Int]
            })
          }.toMap
        }
      }
      case 14 => this._map_of_long = {
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
      case 15 => this._map_of_float = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Float] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value.asInstanceOf[Float]
            })
          }.toMap
        }
      }
      case 16 => this._map_of_double = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Double] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value.asInstanceOf[Double]
            })
          }.toMap
        }
      }
      case 17 => this._map_of_boolean = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Boolean] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value.asInstanceOf[Boolean]
            })
          }.toMap
        }
      }
      case 18 => this._map_of_null = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, scala.Null] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value.asInstanceOf[scala.Null]
            })
          }.toMap
        }
      }
      case 19 => this._map_of_union_of_array = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[List[String] | Int]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case array: java.util.List[?] =>
                  Option(scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                    value.toString
                  }).toList)
                case x: Int => Option(x)
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

  private def encode$0(value$: _root_.avro2s.test.maps.Maps, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`_map_of_maps`, out$)
    encode$4(value$.`_map_of_union`, out$)
    encode$8(value$.`_map_of_union_of_map_of_union`, out$)
    encode$22(value$.`_map_of_arrays`, out$)
    encode$25(value$.`_map_of_arrays_of_maps`, out$)
    encode$29(value$.`_map_of_map_of_union`, out$)
    encode$37(value$.`_map_of_map_of_arrays`, out$)
    encode$41(value$.`_map_of_fixed`, out$)
    encode$43(value$.`_map_of_enum`, out$)
    encode$45(value$.`_map_of_record`, out$)
    encode$48(value$.`_map_of_union_of_record`, out$)
    encode$52(value$.`_map_of_bytes`, out$)
    encode$54(value$.`_map_of_string`, out$)
    encode$56(value$.`_map_of_int`, out$)
    encode$58(value$.`_map_of_long`, out$)
    encode$60(value$.`_map_of_float`, out$)
    encode$62(value$.`_map_of_double`, out$)
    encode$64(value$.`_map_of_boolean`, out$)
    encode$66(value$.`_map_of_null`, out$)
    encode$68(value$.`_map_of_union_of_array`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.maps.Maps): _root_.avro2s.test.maps.Maps = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.maps.Maps() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.maps.Maps, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_map_of_maps` = decode$1(in$)
      value$.`_map_of_union` = decode$4(in$)
      value$.`_map_of_union_of_map_of_union` = decode$8(in$)
      value$.`_map_of_arrays` = decode$22(in$)
      value$.`_map_of_arrays_of_maps` = decode$25(in$)
      value$.`_map_of_map_of_union` = decode$29(in$)
      value$.`_map_of_map_of_arrays` = decode$37(in$)
      value$.`_map_of_fixed` = decode$41(in$)
      value$.`_map_of_enum` = decode$43(in$)
      value$.`_map_of_record` = decode$45(in$)
      value$.`_map_of_union_of_record` = decode$48(in$)
      value$.`_map_of_bytes` = decode$52(in$)
      value$.`_map_of_string` = decode$54(in$)
      value$.`_map_of_int` = decode$56(in$)
      value$.`_map_of_long` = decode$58(in$)
      value$.`_map_of_float` = decode$60(in$)
      value$.`_map_of_double` = decode$62(in$)
      value$.`_map_of_boolean` = decode$64(in$)
      value$.`_map_of_null` = decode$66(in$)
      value$.`_map_of_union_of_array` = decode$68(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_map_of_maps` = decode$1(in$)
          case 1 => value$.`_map_of_union` = decode$4(in$)
          case 2 => value$.`_map_of_union_of_map_of_union` = decode$8(in$)
          case 3 => value$.`_map_of_arrays` = decode$22(in$)
          case 4 => value$.`_map_of_arrays_of_maps` = decode$25(in$)
          case 5 => value$.`_map_of_map_of_union` = decode$29(in$)
          case 6 => value$.`_map_of_map_of_arrays` = decode$37(in$)
          case 7 => value$.`_map_of_fixed` = decode$41(in$)
          case 8 => value$.`_map_of_enum` = decode$43(in$)
          case 9 => value$.`_map_of_record` = decode$45(in$)
          case 10 => value$.`_map_of_union_of_record` = decode$48(in$)
          case 11 => value$.`_map_of_bytes` = decode$52(in$)
          case 12 => value$.`_map_of_string` = decode$54(in$)
          case 13 => value$.`_map_of_int` = decode$56(in$)
          case 14 => value$.`_map_of_long` = decode$58(in$)
          case 15 => value$.`_map_of_float` = decode$60(in$)
          case 16 => value$.`_map_of_double` = decode$62(in$)
          case 17 => value$.`_map_of_boolean` = decode$64(in$)
          case 18 => value$.`_map_of_null` = decode$66(in$)
          case 19 => value$.`_map_of_union_of_array` = decode$68(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$1(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$1(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]]
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

  private def encode$2(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$3(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$2(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$3(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
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

  private def encode$4(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String | _root_.scala.Int], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$5(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$4(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String | _root_.scala.Int] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.java.lang.String | _root_.scala.Int]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$5(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$5(value$: _root_.java.lang.String | _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.java.lang.String @unchecked) =>
        out$.writeIndex(0)
        encode$6(branch$, out$)
      case branch$: (_root_.scala.Int @unchecked) =>
        out$.writeIndex(1)
        encode$7(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$5(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String | _root_.scala.Int = {
    in$.readIndex() match {
      case 0 => decode$6(in$)
      case 1 => decode$7(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$6(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$6(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$7(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$7(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$8(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$9(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$8(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]]]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]]]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$9(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$9(value$: _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$10(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$11(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Boolean @unchecked)) =>
        out$.writeIndex(2)
        encode$12(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]] @unchecked)) =>
        out$.writeIndex(3)
        encode$13(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(4)
        encode$21(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$9(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]]] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$10(in$))
      case 1 => _root_.scala.Some(decode$11(in$))
      case 2 => _root_.scala.Some(decode$12(in$))
      case 3 => _root_.scala.Some(decode$13(in$))
      case 4 => { decode$21(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$10(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$10(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$11(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$11(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$12(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$12(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$13(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$14(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$13(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$14(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$14(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$15(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$14(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$15(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$15(value$: _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$16(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$17(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Boolean @unchecked)) =>
        out$.writeIndex(2)
        encode$18(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Double @unchecked)) =>
        out$.writeIndex(3)
        encode$19(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(4)
        encode$20(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$15(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$16(in$))
      case 1 => _root_.scala.Some(decode$17(in$))
      case 2 => _root_.scala.Some(decode$18(in$))
      case 3 => _root_.scala.Some(decode$19(in$))
      case 4 => { decode$20(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$16(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$16(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$17(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$17(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$18(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$18(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$19(value$: _root_.scala.Double, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeDouble(value$)
  }

  private def decode$19(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double = {
    in$.readDouble()
  }

  private def encode$20(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$20(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$21(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$21(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$22(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[_root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$22(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[_root_.java.lang.String]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.List[_root_.java.lang.String]]
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

  private def encode$23(value$: _root_.scala.List[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$24(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$23(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.java.lang.String] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$24(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$24(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$24(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$25(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Boolean]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$26(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$25(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Boolean]]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Boolean]]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$26(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$26(value$: _root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Boolean]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$26(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Boolean]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Boolean]]
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

  private def encode$27(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Boolean], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$28(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$27(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Boolean] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Boolean]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$28(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$28(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$28(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$29(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$29(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]]
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

  private def encode$30(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$30(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]
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

  private def encode$31(value$: _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$32(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$33(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Boolean @unchecked)) =>
        out$.writeIndex(2)
        encode$34(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Double @unchecked)) =>
        out$.writeIndex(3)
        encode$35(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(4)
        encode$36(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$31(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$32(in$))
      case 1 => _root_.scala.Some(decode$33(in$))
      case 2 => _root_.scala.Some(decode$34(in$))
      case 3 => _root_.scala.Some(decode$35(in$))
      case 4 => { decode$36(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$32(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$32(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$33(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$33(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$34(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$34(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$35(value$: _root_.scala.Double, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeDouble(value$)
  }

  private def decode$35(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double = {
    in$.readDouble()
  }

  private def encode$36(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$36(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$37(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[_root_.java.lang.String]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$37(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[_root_.java.lang.String]]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[_root_.java.lang.String]]]
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

  private def encode$38(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[_root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$39(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$38(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[_root_.java.lang.String]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.List[_root_.java.lang.String]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$39(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$39(value$: _root_.scala.List[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$39(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.java.lang.String] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.java.lang.String]
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

  private def encode$40(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$40(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$41(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.avro2s.test.maps.Fixed], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$41(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.avro2s.test.maps.Fixed] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.avro2s.test.maps.Fixed]
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

  private def encode$42(value$: _root_.avro2s.test.maps.Fixed, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFixed(value$.bytes(), 0, 2)
  }

  private def decode$42(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.maps.Fixed = {
    val result$ = new _root_.avro2s.test.maps.Fixed()
    in$.readFixed(result$.bytes())
    result$
  }

  private def encode$43(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.avro2s.test.maps.Enum], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$43(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.avro2s.test.maps.Enum] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.avro2s.test.maps.Enum]
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

  private def encode$44(value$: _root_.avro2s.test.maps.Enum, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeEnum(value$.ordinal())
  }

  private def decode$44(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.maps.Enum = {
    _root_.avro2s.test.maps.Maps.customEnum$44(in$.readEnum())
  }

  private def encode$45(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.avro2s.test.maps.Record], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$45(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.avro2s.test.maps.Record] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.avro2s.test.maps.Record]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$46(in$, null)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$46(value$: _root_.avro2s.test.maps.Record, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$47(value$.`a`, out$)
  }

  private def decode$46(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.maps.Record): _root_.avro2s.test.maps.Record = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.maps.Record() else reuse$
    decodeRecord$46(result$, in$)
    result$
  }

  private def decodeRecord$46(value$: _root_.avro2s.test.maps.Record, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`a` = decode$47(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`a` = decode$47(in$)
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

  private def encode$48(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.maps.Record | _root_.scala.Int]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$49(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$48(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.maps.Record | _root_.scala.Int]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Option[_root_.avro2s.test.maps.Record | _root_.scala.Int]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$49(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$49(value$: _root_.scala.Option[_root_.avro2s.test.maps.Record | _root_.scala.Int], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.avro2s.test.maps.Record @unchecked)) =>
        out$.writeIndex(0)
        encode$46(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Int @unchecked)) =>
        out$.writeIndex(1)
        encode$50(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(2)
        encode$51(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$49(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.avro2s.test.maps.Record | _root_.scala.Int] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$46(in$, null))
      case 1 => _root_.scala.Some(decode$50(in$))
      case 2 => { decode$51(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$50(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$50(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$51(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$51(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$52(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Array[_root_.scala.Byte]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$53(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$52(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Array[_root_.scala.Byte]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Array[_root_.scala.Byte]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$53(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$53(value$: _root_.scala.Array[_root_.scala.Byte], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBytes(value$)
  }

  private def decode$53(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Array[_root_.scala.Byte] = {
    val buffer$ = in$.readBytes(null)
    if (buffer$.hasArray && buffer$.arrayOffset() == 0 && buffer$.position() == 0 && buffer$.remaining() == buffer$.array().length) buffer$.array()
    else {
      val bytes$ = new _root_.scala.Array[Byte](buffer$.remaining())
      buffer$.get(bytes$)
      bytes$
    }
  }

  private def encode$54(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$55(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$54(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$55(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$55(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$55(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$56(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Int], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$57(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$56(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Int] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Int]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$57(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$57(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$57(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$58(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Long], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$59(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$58(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Long] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Long]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$59(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$59(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$59(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$60(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Float], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$61(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$60(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Float] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Float]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$61(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$61(value$: _root_.scala.Float, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFloat(value$)
  }

  private def decode$61(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Float = {
    in$.readFloat()
  }

  private def encode$62(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Double], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$63(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$62(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Double] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Double]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$63(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$63(value$: _root_.scala.Double, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeDouble(value$)
  }

  private def decode$63(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double = {
    in$.readDouble()
  }

  private def encode$64(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Boolean], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$65(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$64(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Boolean] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Boolean]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$65(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$65(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$65(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$66(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Null], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$67(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$66(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Null] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Null]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$67(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$67(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$67(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$68(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.scala.List[_root_.java.lang.String] | _root_.scala.Int]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$69(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$68(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.scala.List[_root_.java.lang.String] | _root_.scala.Int]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Option[_root_.scala.List[_root_.java.lang.String] | _root_.scala.Int]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$69(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$69(value$: _root_.scala.Option[_root_.scala.List[_root_.java.lang.String] | _root_.scala.Int], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.scala.List[_root_.java.lang.String] @unchecked)) =>
        out$.writeIndex(0)
        encode$70(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Int @unchecked)) =>
        out$.writeIndex(1)
        encode$72(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(2)
        encode$73(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$69(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.List[_root_.java.lang.String] | _root_.scala.Int] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$70(in$))
      case 1 => _root_.scala.Some(decode$72(in$))
      case 2 => { decode$73(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$70(value$: _root_.scala.List[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$71(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$70(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.java.lang.String] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$71(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$71(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$71(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$72(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$72(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$73(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$73(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }
}

object Maps {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Maps","namespace":"avro2s.test.maps","fields":[{"name":"_map_of_maps","type":{"type":"map","values":{"type":"map","values":"string","default":{}},"default":{}}},{"name":"_map_of_union","type":{"type":"map","values":["string","int"],"default":{}}},{"name":"_map_of_union_of_map_of_union","type":{"type":"map","values":["string","long","boolean",{"type":"map","values":{"type":"map","values":["string","long","boolean","double","null"]}},"null"]}},{"name":"_map_of_arrays","type":{"type":"map","values":{"type":"array","items":"string"}}},{"name":"_map_of_arrays_of_maps","type":{"type":"map","values":{"type":"array","items":{"type":"map","values":"boolean"}}}},{"name":"_map_of_map_of_union","type":{"type":"map","values":{"type":"map","values":["string","long","boolean","double","null"]}}},{"name":"_map_of_map_of_arrays","type":{"type":"map","values":{"type":"map","values":{"type":"array","items":"string"}}}},{"name":"_map_of_fixed","type":{"type":"map","values":{"type":"fixed","name":"Fixed","size":2}}},{"name":"_map_of_enum","type":{"type":"map","values":{"type":"enum","name":"Enum","symbols":["A","B","C"]}}},{"name":"_map_of_record","type":{"type":"map","values":{"type":"record","name":"Record","fields":[{"name":"a","type":"string"}]}}},{"name":"_map_of_union_of_record","type":{"type":"map","values":["Record","int","null"],"default":{}}},{"name":"_map_of_bytes","type":{"type":"map","values":"bytes"}},{"name":"_map_of_string","type":{"type":"map","values":"string"}},{"name":"_map_of_int","type":{"type":"map","values":"int"}},{"name":"_map_of_long","type":{"type":"map","values":"long"}},{"name":"_map_of_float","type":{"type":"map","values":"float"}},{"name":"_map_of_double","type":{"type":"map","values":"double"}},{"name":"_map_of_boolean","type":{"type":"map","values":"boolean"}},{"name":"_map_of_null","type":{"type":"map","values":"null"}},{"name":"_map_of_union_of_array","type":{"type":"map","values":[{"type":"array","items":"string"},"int","null"]}}]}""")
  private val customSchema$44: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(8).schema().getValueType
  private val customEnum$44: _root_.scala.Array[_root_.avro2s.test.maps.Enum] = {
    val result$ = new _root_.scala.Array[_root_.avro2s.test.maps.Enum](customSchema$44.getEnumSymbols.size())
    var i$ = 0
    while (i$ < result$.length) {
      result$(i$) = _root_.avro2s.test.maps.Enum.valueOf(customSchema$44.getEnumSymbols.get(i$))
      i$ += 1
    }
    result$
  }
}