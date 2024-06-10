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
              case Some(x: avro2s.test.unions.RecordForComplexOptions) => x.asInstanceOf[AnyRef]
              case None => null.asInstanceOf[AnyRef]
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
              case Some(x: Map[String, String]) =>
                val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
                x.foreach { kvp =>
                  val key = kvp._1
                  val value = {
                    kvp._2
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
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_option_of_array.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case Some(x: List[String]) =>
              scala.jdk.CollectionConverters.BufferHasAsJava({
                x.map { x =>x.asInstanceOf[AnyRef]
                }
              }.toBuffer).asJava.asInstanceOf[AnyRef]
              case None => null.asInstanceOf[AnyRef]
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
              case Some(x: avro2s.test.unions.RecordForComplexOptions) => x.asInstanceOf[AnyRef]
              case None => null.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 4 => _array_of_option_of_map match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map {
              case Some(x: Map[String, String]) =>
                val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
                x.foreach { kvp =>
                  val key = kvp._1
                  val value = {
                    kvp._2
                  }
                  map.put(key, value)
                }
                map
              case None => null.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 5 => _array_of_option_of_array match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map {
              case Some(x: List[String]) =>
              scala.jdk.CollectionConverters.BufferHasAsJava({
                x.map { x =>x.asInstanceOf[AnyRef]
                }
              }.toBuffer).asJava.asInstanceOf[AnyRef]
              case None => null.asInstanceOf[AnyRef]
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
                    case Some(x: avro2s.test.unions.RecordForComplexOptions) => x.asInstanceOf[AnyRef]
                    case None => null.asInstanceOf[AnyRef]
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
                case Some(x: avro2s.test.unions.RecordForComplexOptions) => x.asInstanceOf[AnyRef]
                case None => null.asInstanceOf[AnyRef]
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
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
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
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
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
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._map_of_option_of_record = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
          val key = kvp._1.toString
          val value = kvp._2
          (key, {
            value match {
              case null => None
              case x: avro2s.test.unions.RecordForComplexOptions => Option(x.asInstanceOf[avro2s.test.unions.RecordForComplexOptions])
              case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
            }
          })
        }
      }
      case 1 => this._map_of_option_of_map = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
          val key = kvp._1.toString
          val value = kvp._2
          (key, {
            value match {
              case null => None
              case map: java.util.Map[?,?] =>
                Option(scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                  val key = kvp._1.toString
                  val value = kvp._2
                  (key, {
                    value.toString
                  })
                })
              case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
            }
          })
        }
      }
      case 2 => this._map_of_option_of_array = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
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
              Option(scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value.toString
                })
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
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case null => None
                case x: avro2s.test.unions.RecordForComplexOptions => Option(x.asInstanceOf[avro2s.test.unions.RecordForComplexOptions])
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            })
          }
        }).toList
      }
      case 7 => this._map_of_array_of_option_of_record = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
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
        }
      }
      case 8 => this._map_of_option_of_bytes = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
          val key = kvp._1.toString
          val value = kvp._2
          (key, {
            value match {
              case null => None
              case x: java.nio.ByteBuffer => Option(x.array())
              case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
            }
          })
        }
      }
      case 9 => this._map_of_option_of_fixed = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
          val key = kvp._1.toString
          val value = kvp._2
          (key, {
            value match {
              case null => None
              case x: avro2s.test.unions.FixedForComplexOptions => Option(x.asInstanceOf[avro2s.test.unions.FixedForComplexOptions])
              case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
            }
          })
        }
      }
      case 10 => this._map_of_option_of_enum = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
          val key = kvp._1.toString
          val value = kvp._2
          (key, {
            value match {
              case null => None
              case x: avro2s.test.unions.EnumForComplexOptions => Option(x.asInstanceOf[avro2s.test.unions.EnumForComplexOptions])
              case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
            }
          })
        }
      }
    }
  }
}

object ComplexOptions {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"ComplexOptions","namespace":"avro2s.test.unions","fields":[{"name":"_map_of_option_of_record","type":{"type":"map","values":["null",{"type":"record","name":"RecordForComplexOptions","fields":[{"name":"field1","type":"string"}]}]}},{"name":"_map_of_option_of_map","type":{"type":"map","values":["null",{"type":"map","values":"string"}]}},{"name":"_map_of_option_of_array","type":{"type":"map","values":["null",{"type":"array","items":"string"}]}},{"name":"_array_of_option_of_record","type":{"type":"array","items":["null","RecordForComplexOptions"]}},{"name":"_array_of_option_of_map","type":{"type":"array","items":["null",{"type":"map","values":"string"}]}},{"name":"_array_of_option_of_array","type":{"type":"array","items":["null",{"type":"array","items":"string"}]}},{"name":"_array_of_map_of_option_of_record","type":{"type":"array","items":{"type":"map","values":["null","RecordForComplexOptions"]}}},{"name":"_map_of_array_of_option_of_record","type":{"type":"map","values":{"type":"array","items":["null","RecordForComplexOptions"]}}},{"name":"_map_of_option_of_bytes","type":{"type":"map","values":["null","bytes"]}},{"name":"_map_of_option_of_fixed","type":{"type":"map","values":["null",{"type":"fixed","name":"FixedForComplexOptions","size":16}]}},{"name":"_map_of_option_of_enum","type":{"type":"map","values":["null",{"type":"enum","name":"EnumForComplexOptions","symbols":["A","B","C"]}]}}]}""")
}