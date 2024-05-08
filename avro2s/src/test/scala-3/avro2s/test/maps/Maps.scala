/** GENERATED CODE */

package avro2s.test.maps

import org.apache.avro.AvroRuntimeException

import scala.annotation.switch

case class Maps(var _map_of_maps: Map[String, Map[String, String]], var _map_of_union: Map[String, String | Int], var _map_of_union_of_map_of_union: Map[String, String | Long | Boolean | Map[String, Map[String, String | Long | Boolean | Double | scala.Null]] | scala.Null], var _map_of_arrays: Map[String, List[String]], var _map_of_arrays_of_maps: Map[String, List[Map[String, Boolean]]], var _map_of_map_of_union: Map[String, Map[String, String | Long | Boolean | Double | scala.Null]], var _map_of_map_of_arrays: Map[String, Map[String, List[String]]], var _map_of_fixed: Map[String, avro2s.test.maps.Fixed], var _map_of_enum: Map[String, avro2s.test.maps.Enum], var _map_of_record: Map[String, avro2s.test.maps.Record], var _map_of_union_of_record: Map[String, avro2s.test.maps.Record | Int | scala.Null], var _map_of_bytes: Map[String, Array[Byte]], var _map_of_string: Map[String, String], var _map_of_int: Map[String, Int], var _map_of_long: Map[String, Long], var _map_of_float: Map[String, Float], var _map_of_double: Map[String, Double], var _map_of_boolean: Map[String, Boolean], var _map_of_null: Map[String, scala.Null], var _map_of_union_of_array: Map[String, List[String] | Int | scala.Null]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty)

  override def getSchema: org.apache.avro.Schema = Maps.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_maps.foreach { kvp =>
          val key = kvp._1
          val value = {
            val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
            kvp._2.foreach { kvp =>
              val key = kvp._1
              val value = {
                kvp._2
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
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
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
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_union_of_map_of_union.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case x: String => x.asInstanceOf[AnyRef]
              case x: Long => x.asInstanceOf[AnyRef]
              case x: Boolean => x.asInstanceOf[AnyRef]
              case x: Map[String, Map[String, String | Long | Boolean | Double | scala.Null]] =>
                val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
                x.foreach { kvp =>
                  val key = kvp._1
                  val value = {
                    val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
                    kvp._2.foreach { kvp =>
                      val key = kvp._1
                      val value = {
                        kvp._2 match {
                          case x: String => x.asInstanceOf[AnyRef]
                          case x: Long => x.asInstanceOf[AnyRef]
                          case x: Boolean => x.asInstanceOf[AnyRef]
                          case x: Double => x.asInstanceOf[AnyRef]
                          case null => null.asInstanceOf[AnyRef]
                        }
                      }
                      map.put(key, value)
                    }
                    map
                  }
                  map.put(key, value)
                }
                map
              case null => null.asInstanceOf[AnyRef]
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 3 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_arrays.foreach { kvp =>
          val key = kvp._1
          val value = {
            scala.jdk.CollectionConverters.BufferHasAsJava({
              kvp._2.map { x =>
                x.asInstanceOf[AnyRef]
              }
            }.toBuffer).asJava
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 4 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_arrays_of_maps.foreach { kvp =>
          val key = kvp._1
          val value = {
            scala.jdk.CollectionConverters.BufferHasAsJava({
              kvp._2.map { m =>
                val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
                m.foreach { kvp =>
                  val key = kvp._1
                  val value = {
                    kvp._2
                  }
                  map.put(key, value)
                }
                map
              }
            }.toBuffer).asJava
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 5 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_map_of_union.foreach { kvp =>
          val key = kvp._1
          val value = {
            val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
            kvp._2.foreach { kvp =>
              val key = kvp._1
              val value = {
                kvp._2 match {
                  case x: String => x.asInstanceOf[AnyRef]
                  case x: Long => x.asInstanceOf[AnyRef]
                  case x: Boolean => x.asInstanceOf[AnyRef]
                  case x: Double => x.asInstanceOf[AnyRef]
                  case null => null.asInstanceOf[AnyRef]
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
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_map_of_arrays.foreach { kvp =>
          val key = kvp._1
          val value = {
            val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
            kvp._2.foreach { kvp =>
              val key = kvp._1
              val value = {
                scala.jdk.CollectionConverters.BufferHasAsJava({
                  kvp._2.map { x =>
                    x.asInstanceOf[AnyRef]
                  }
                }.toBuffer).asJava
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
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_fixed.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 8 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_enum.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 9 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_record.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 10 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_union_of_record.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case x: avro2s.test.maps.Record => x.asInstanceOf[AnyRef]
              case x: Int => x.asInstanceOf[AnyRef]
              case null => null.asInstanceOf[AnyRef]
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 11 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
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
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_string.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 13 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_int.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 14 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_long.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 15 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_float.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 16 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_double.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 17 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_boolean.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 18 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_null.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 19 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_union_of_array.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case x: List[String] =>
              scala.jdk.CollectionConverters.BufferHasAsJava({
                x.map { x =>x.asInstanceOf[AnyRef]
                }
              }.toBuffer).asJava.asInstanceOf[AnyRef]
              case x: Int => x.asInstanceOf[AnyRef]
              case null => null.asInstanceOf[AnyRef]
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._map_of_maps = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case map: java.util.Map[_,_] => {
                    scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                      val key = kvp._1.toString
                      val value = kvp._2
                      (key, {
                        value.toString
                      })
                    }
                  }
                }
              })
            }
          }
        }
      }
      case 1 => this._map_of_union = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case x: org.apache.avro.util.Utf8 => x.toString
                  case x: Int => x
                  case _ => throw new AvroRuntimeException("Invalid value")
                }
              })
            }
          }
        }
      }
      case 2 => this._map_of_union_of_map_of_union = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case x: org.apache.avro.util.Utf8 => x.toString
                  case x: Long => x
                  case x: Boolean => x
                  case map: java.util.Map[_,_] =>
                    scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                      val key = kvp._1.toString
                      val value = kvp._2
                      (key, {
                        value match {
                          case map: java.util.Map[_,_] => {
                            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                              val key = kvp._1.toString
                              val value = kvp._2
                              (key, {
                                value match {
                                  case x: org.apache.avro.util.Utf8 => x.toString
                                  case x: Long => x
                                  case x: Boolean => x
                                  case x: Double => x
                                  case null => null
                                  case _ => throw new AvroRuntimeException("Invalid value")
                                }
                              })
                            }
                          }
                        }
                      })
                    }
                  case null => null
                  case _ => throw new AvroRuntimeException("Invalid value")
                }
              })
            }
          }
        }
      }
      case 3 => this._map_of_arrays = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case array: java.util.List[_] =>
                    scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                      value.toString
                    }).toList
                  }
              })
            }
          }
        }
      }
      case 4 => this._map_of_arrays_of_maps = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case array: java.util.List[_] =>
                    scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                      value match {
                        case map: java.util.Map[_,_] => {
                          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                            val key = kvp._1.toString
                            val value = kvp._2
                            (key, {
                              value.asInstanceOf[Boolean]
                            })
                          }
                        }
                      }
                    }).toList
                  }
              })
            }
          }
        }
      }
      case 5 => this._map_of_map_of_union = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case map: java.util.Map[_,_] => {
                    scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                      val key = kvp._1.toString
                      val value = kvp._2
                      (key, {
                        value match {
                          case x: org.apache.avro.util.Utf8 => x.toString
                          case x: Long => x
                          case x: Boolean => x
                          case x: Double => x
                          case null => null
                          case _ => throw new AvroRuntimeException("Invalid value")
                        }
                      })
                    }
                  }
                }
              })
            }
          }
        }
      }
      case 6 => this._map_of_map_of_arrays = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case map: java.util.Map[_,_] => {
                    scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                      val key = kvp._1.toString
                      val value = kvp._2
                      (key, {
                        value match {
                          case array: java.util.List[_] =>
                            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                              value.toString
                            }).toList
                          }
                      })
                    }
                  }
                }
              })
            }
          }
        }
      }
      case 7 => this._map_of_fixed = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value.asInstanceOf[avro2s.test.maps.Fixed]
              })
            }
          }
        }
      }
      case 8 => this._map_of_enum = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value.asInstanceOf[avro2s.test.maps.Enum]
              })
            }
          }
        }
      }
      case 9 => this._map_of_record = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value.asInstanceOf[avro2s.test.maps.Record]
              })
            }
          }
        }
      }
      case 10 => this._map_of_union_of_record = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case x: avro2s.test.maps.Record => x
                  case x: Int => x
                  case null => null
                  case _ => throw new AvroRuntimeException("Invalid value")
                }
              })
            }
          }
        }
      }
      case 11 => this._map_of_bytes = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case buffer: java.nio.ByteBuffer => val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); array
                  }
              })
            }
          }
        }
      }
      case 12 => this._map_of_string = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value.toString
              })
            }
          }
        }
      }
      case 13 => this._map_of_int = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value.asInstanceOf[Int]
              })
            }
          }
        }
      }
      case 14 => this._map_of_long = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value.asInstanceOf[Long]
              })
            }
          }
        }
      }
      case 15 => this._map_of_float = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value.asInstanceOf[Float]
              })
            }
          }
        }
      }
      case 16 => this._map_of_double = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value.asInstanceOf[Double]
              })
            }
          }
        }
      }
      case 17 => this._map_of_boolean = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value.asInstanceOf[Boolean]
              })
            }
          }
        }
      }
      case 18 => this._map_of_null = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value.asInstanceOf[scala.Null]
              })
            }
          }
        }
      }
      case 19 => this._map_of_union_of_array = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case x: java.util.List[_] => {
                    x match {
                      case array: java.util.List[_] =>
                        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                          value.toString
                        }).toList
                      }
                  }.toList
                  case x: Int => x
                  case null => null
                  case _ => throw new AvroRuntimeException("Invalid value")
                }
              })
            }
          }
        }
      }
    }
  }
}

object Maps {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Maps","namespace":"avro2s.test.maps","fields":[{"name":"_map_of_maps","type":{"type":"map","values":{"type":"map","values":"string","default":{}},"default":{}}},{"name":"_map_of_union","type":{"type":"map","values":["string","int"],"default":{}}},{"name":"_map_of_union_of_map_of_union","type":{"type":"map","values":["string","long","boolean",{"type":"map","values":{"type":"map","values":["string","long","boolean","double","null"]}},"null"]}},{"name":"_map_of_arrays","type":{"type":"map","values":{"type":"array","items":"string"}}},{"name":"_map_of_arrays_of_maps","type":{"type":"map","values":{"type":"array","items":{"type":"map","values":"boolean"}}}},{"name":"_map_of_map_of_union","type":{"type":"map","values":{"type":"map","values":["string","long","boolean","double","null"]}}},{"name":"_map_of_map_of_arrays","type":{"type":"map","values":{"type":"map","values":{"type":"array","items":"string"}}}},{"name":"_map_of_fixed","type":{"type":"map","values":{"type":"fixed","name":"Fixed","size":2}}},{"name":"_map_of_enum","type":{"type":"map","values":{"type":"enum","name":"Enum","symbols":["A","B","C"]}}},{"name":"_map_of_record","type":{"type":"map","values":{"type":"record","name":"Record","fields":[{"name":"a","type":"string"}]}}},{"name":"_map_of_union_of_record","type":{"type":"map","values":["Record","int","null"],"default":{}}},{"name":"_map_of_bytes","type":{"type":"map","values":"bytes"}},{"name":"_map_of_string","type":{"type":"map","values":"string"}},{"name":"_map_of_int","type":{"type":"map","values":"int"}},{"name":"_map_of_long","type":{"type":"map","values":"long"}},{"name":"_map_of_float","type":{"type":"map","values":"float"}},{"name":"_map_of_double","type":{"type":"map","values":"double"}},{"name":"_map_of_boolean","type":{"type":"map","values":"boolean"}},{"name":"_map_of_null","type":{"type":"map","values":"null"}},{"name":"_map_of_union_of_array","type":{"type":"map","values":[{"type":"array","items":"string"},"int","null"]}}]}""")
}