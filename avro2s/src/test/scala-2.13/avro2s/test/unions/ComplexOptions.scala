/** GENERATED CODE */

package avro2s.test.unions

import scala.annotation.switch

case class ComplexOptions(var _map_of_option_of_record: Map[String, Option[avro2s.test.unions.RecordForComplexOptions]], var _map_of_option_of_map: Map[String, Option[Map[String, String]]], var _map_of_option_of_array: Map[String, Option[List[String]]], var _array_of_option_of_record: List[Option[avro2s.test.unions.RecordForComplexOptions]], var _array_of_option_of_map: List[Option[Map[String, String]]], var _array_of_option_of_array: List[Option[List[String]]], var _array_of_map_of_option_of_record: List[Map[String, Option[avro2s.test.unions.RecordForComplexOptions]]], var _map_of_array_of_option_of_record: Map[String, List[Option[avro2s.test.unions.RecordForComplexOptions]]], var _map_of_option_of_bytes: Map[String, Option[Array[Byte]]], var _map_of_option_of_fixed: Map[String, Option[avro2s.test.unions.FixedForComplexOptions]], var _map_of_option_of_enum: Map[String, Option[avro2s.test.unions.EnumForComplexOptions]]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(Map.empty, Map.empty, Map.empty, List.empty, List.empty, List.empty, List.empty, Map.empty, Map.empty, Map.empty, Map.empty)

  override def getSchema: org.apache.avro.Schema = ComplexOptions.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
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
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_option_of_map.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case None => null
              case Some(x) =>
                val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
                x.foreach { kvp =>
                  val key = kvp._1
                  val value = {
                    kvp._2
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
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_option_of_array.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case None => null
              case Some(x) =>
              scala.jdk.CollectionConverters.BufferHasAsJava({
                x.map { x =>x.asInstanceOf[AnyRef]
                }
              }.toBuffer).asJava.asInstanceOf[AnyRef]
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 3 => _array_of_option_of_record match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map {
              case None => null
              case Some(x) => x.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 4 => _array_of_option_of_map match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map {
              case None => null
              case Some(x) =>
                val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
                x.foreach { kvp =>
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
      case 5 => _array_of_option_of_array match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map {
              case None => null
              case Some(x) =>
              scala.jdk.CollectionConverters.BufferHasAsJava({
                x.map { x =>x.asInstanceOf[AnyRef]
                }
              }.toBuffer).asJava.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 6 => _array_of_map_of_option_of_record match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { m =>
              val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
              m.foreach { kvp =>
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
            }
          }.toBuffer).asJava
        }
      case 7 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_array_of_option_of_record.foreach { kvp =>
          val key = kvp._1
          val value = {
            scala.jdk.CollectionConverters.BufferHasAsJava({
              kvp._2.map {
                case None => null
                case Some(x) => x.asInstanceOf[AnyRef]
              }
            }.toBuffer).asJava
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 8 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
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
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
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
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
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
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case null => None
                  case x: avro2s.test.unions.RecordForComplexOptions => Some(x)
                }
              })
            }
          }
        }
      }
      case 1 => this._map_of_option_of_map = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case null => None
                  case map: java.util.Map[_,_] => Some{
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
      case 2 => this._map_of_option_of_array = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
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
                  scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                    val key = kvp._1.toString
                    val value = kvp._2
                    (key, {
                      value.toString
                    })
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
                  scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                    val key = kvp._1.toString
                    val value = kvp._2
                    (key, {
                      value match {
                        case null => None
                        case x: avro2s.test.unions.RecordForComplexOptions => Some(x)
                      }
                    })
                  }
                }
              }
            }).toList
          }
      }
      case 7 => this._map_of_array_of_option_of_record = {
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
                        case null => None
                        case x: avro2s.test.unions.RecordForComplexOptions => Some(x)
                      }
                    }).toList
                  }
              })
            }
          }
        }
      }
      case 8 => this._map_of_option_of_bytes = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case null => None
                  case x: java.nio.ByteBuffer => Some(x.array())
                }
              })
            }
          }
        }
      }
      case 9 => this._map_of_option_of_fixed = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case null => None
                  case x: avro2s.test.unions.FixedForComplexOptions => Some(x)
                }
              })
            }
          }
        }
      }
      case 10 => this._map_of_option_of_enum = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case null => None
                  case x: avro2s.test.unions.EnumForComplexOptions => Some(x)
                }
              })
            }
          }
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object ComplexOptions {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"ComplexOptions","namespace":"avro2s.test.unions","fields":[{"name":"_map_of_option_of_record","type":{"type":"map","values":["null",{"type":"record","name":"RecordForComplexOptions","fields":[{"name":"field1","type":"string"}]}]}},{"name":"_map_of_option_of_map","type":{"type":"map","values":["null",{"type":"map","values":"string"}]}},{"name":"_map_of_option_of_array","type":{"type":"map","values":["null",{"type":"array","items":"string"}]}},{"name":"_array_of_option_of_record","type":{"type":"array","items":["null","RecordForComplexOptions"]}},{"name":"_array_of_option_of_map","type":{"type":"array","items":["null",{"type":"map","values":"string"}]}},{"name":"_array_of_option_of_array","type":{"type":"array","items":["null",{"type":"array","items":"string"}]}},{"name":"_array_of_map_of_option_of_record","type":{"type":"array","items":{"type":"map","values":["null","RecordForComplexOptions"]}}},{"name":"_map_of_array_of_option_of_record","type":{"type":"map","values":{"type":"array","items":["null","RecordForComplexOptions"]}}},{"name":"_map_of_option_of_bytes","type":{"type":"map","values":["null","bytes"]}},{"name":"_map_of_option_of_fixed","type":{"type":"map","values":["null",{"type":"fixed","name":"FixedForComplexOptions","size":16}]}},{"name":"_map_of_option_of_enum","type":{"type":"map","values":["null",{"type":"enum","name":"EnumForComplexOptions","symbols":["A","B","C"]}]}}]}""")
}