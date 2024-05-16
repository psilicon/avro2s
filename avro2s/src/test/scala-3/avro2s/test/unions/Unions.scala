/** GENERATED CODE */

package avro2s.test.unions

import scala.annotation.switch

case class Unions(var _union_of_map_of_union: Option[String | Long | Boolean | Map[String, Map[String, Option[String | Long | Boolean | Double]]]], var _union_of_map_of_option: Option[String | Long | Boolean | Map[String, Option[String]]], var _union_of_array_of_option: Option[String | Long | Boolean | List[Option[String]]], var _union_of_array_of_union: Option[String | Long | Boolean | List[Option[String | Long | Boolean | Double | Array[Byte]]]], var _union_of_array_of_array: Option[String | Long | Boolean | List[List[Option[String | Long | Boolean | Double]]]], var _union_of_records: Option[String | Long | Boolean | avro2s.test.unions.Record1 | avro2s.test.unions.Record2], var _union_of_enum: Option[String | Long | Boolean | avro2s.test.unions.Enum1], var _union_of_fixed: Option[String | Long | Boolean | avro2s.test.unions.Fixed1], var _union_of_string: Option[String | Long], var _union_of_int: Int | String, var _union_of_long: Long | String, var _union_of_float: Float | String, var _union_of_double: Double | String, var _union_of_boolean: Boolean | String, var _union_of_bytes: Array[Byte] | String, var _optional_record: Option[avro2s.test.unions.Record3], var _optional_enum: Option[avro2s.test.unions.Enum2], var _optional_fixed: Option[avro2s.test.unions.Fixed2], var _optional_string: Option[String], var _optional_int: Option[Int], var _optional_long: Option[Long], var _optional_float: Option[Float], var _optional_double: Option[Double], var _optional_boolean: Option[Boolean], var _optional_bytes: Option[Array[Byte]], var _optional_map: Option[Map[String, String]], var _optional_array: Option[List[String]], var _optional_map_of_array: Option[Map[String, List[String]]], var _optional_array_of_map: Option[List[Map[String, String]]], var _optional_map_of_map: Option[Map[String, Map[String, String]]], var _optional_array_of_array: Option[List[List[String]]], var _optional_map_of_union: Option[Map[String, Option[String | Long | Boolean | Double]]], var _optional_array_of_union: Option[List[Option[String | Long | Boolean | Double]]]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(None, None, None, None, None, None, None, None, None, 0, 0, 0, 0, false, Array[Byte](), None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None)

  override def getSchema: org.apache.avro.Schema = Unions.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _union_of_map_of_union match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case Some(x: Long) => x.asInstanceOf[AnyRef]
        case Some(x: Boolean) => x.asInstanceOf[AnyRef]
        case Some(x: Map[String, Map[String, Option[String | Long | Boolean | Double]]]) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
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
      case 1 => _union_of_map_of_option match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case Some(x: Long) => x.asInstanceOf[AnyRef]
        case Some(x: Boolean) => x.asInstanceOf[AnyRef]
        case Some(x: Map[String, Option[String]]) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
          x.foreach { kvp =>
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
        case None => null.asInstanceOf[AnyRef]
      }
      case 2 => _union_of_array_of_option match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case Some(x: Long) => x.asInstanceOf[AnyRef]
        case Some(x: Boolean) => x.asInstanceOf[AnyRef]
        case Some(x: List[Option[String]]) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map {
          case None => null
          case Some(x) => x.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 3 => _union_of_array_of_union match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case Some(x: Long) => x.asInstanceOf[AnyRef]
        case Some(x: Boolean) => x.asInstanceOf[AnyRef]
        case Some(x: List[Option[String | Long | Boolean | Double | Array[Byte]]]) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map {
          case Some(x: String) => x.asInstanceOf[AnyRef]
          case Some(x: Long) => x.asInstanceOf[AnyRef]
          case Some(x: Boolean) => x.asInstanceOf[AnyRef]
          case Some(x: Double) => x.asInstanceOf[AnyRef]
          case Some(x: Array[Byte]) =>
          java.nio.ByteBuffer.wrap(x).asInstanceOf[AnyRef]
          case None => null.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 4 => _union_of_array_of_array match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case Some(x: Long) => x.asInstanceOf[AnyRef]
        case Some(x: Boolean) => x.asInstanceOf[AnyRef]
        case Some(x: List[List[Option[String | Long | Boolean | Double]]]) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map { x =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map {
          case Some(x: String) => x.asInstanceOf[AnyRef]
          case Some(x: Long) => x.asInstanceOf[AnyRef]
          case Some(x: Boolean) => x.asInstanceOf[AnyRef]
          case Some(x: Double) => x.asInstanceOf[AnyRef]
          case None => null.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 5 => _union_of_records match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case Some(x: Long) => x.asInstanceOf[AnyRef]
        case Some(x: Boolean) => x.asInstanceOf[AnyRef]
        case Some(x: avro2s.test.unions.Record1) => x.asInstanceOf[AnyRef]
        case Some(x: avro2s.test.unions.Record2) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 6 => _union_of_enum match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case Some(x: Long) => x.asInstanceOf[AnyRef]
        case Some(x: Boolean) => x.asInstanceOf[AnyRef]
        case Some(x: avro2s.test.unions.Enum1) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 7 => _union_of_fixed match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case Some(x: Long) => x.asInstanceOf[AnyRef]
        case Some(x: Boolean) => x.asInstanceOf[AnyRef]
        case Some(x: avro2s.test.unions.Fixed1) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 8 => _union_of_string match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case Some(x: Long) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 9 => _union_of_int match {
        case x: Int => x.asInstanceOf[AnyRef]
        case x: String => x.asInstanceOf[AnyRef]
      }
      case 10 => _union_of_long match {
        case x: Long => x.asInstanceOf[AnyRef]
        case x: String => x.asInstanceOf[AnyRef]
      }
      case 11 => _union_of_float match {
        case x: Float => x.asInstanceOf[AnyRef]
        case x: String => x.asInstanceOf[AnyRef]
      }
      case 12 => _union_of_double match {
        case x: Double => x.asInstanceOf[AnyRef]
        case x: String => x.asInstanceOf[AnyRef]
      }
      case 13 => _union_of_boolean match {
        case x: Boolean => x.asInstanceOf[AnyRef]
        case x: String => x.asInstanceOf[AnyRef]
      }
      case 14 => _union_of_bytes match {
        case x: Array[Byte] =>
        java.nio.ByteBuffer.wrap(x).asInstanceOf[AnyRef]
        case x: String => x.asInstanceOf[AnyRef]
      }
      case 15 => _optional_record match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 16 => _optional_enum match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 17 => _optional_fixed match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 18 => _optional_string match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 19 => _optional_int match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 20 => _optional_long match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 21 => _optional_float match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 22 => _optional_double match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 23 => _optional_boolean match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 24 => _optional_bytes match {
        case None => null
        case Some(x) =>
        java.nio.ByteBuffer.wrap(x).asInstanceOf[AnyRef]
      }
      case 25 => _optional_map match {
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
      case 26 => _optional_array match {
        case None => null
        case Some(x) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map { x =>x.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
      }
      case 27 => _optional_map_of_array match {
        case None => null
        case Some(x) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
          x.foreach { kvp =>
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
      case 28 => _optional_array_of_map match {
        case None => null
        case Some(x) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map { x =>
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
        }.toBuffer).asJava.asInstanceOf[AnyRef]
      }
      case 29 => _optional_map_of_map match {
        case None => null
        case Some(x) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
          x.foreach { kvp =>
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
      }
      case 30 => _optional_array_of_array match {
        case None => null
        case Some(x) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map { x =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map { x =>x.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
      }
      case 31 => _optional_map_of_union match {
        case None => null
        case Some(x) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
          x.foreach { kvp =>
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
      case 32 => _optional_array_of_union match {
        case None => null
        case Some(x) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map {
          case Some(x: String) => x.asInstanceOf[AnyRef]
          case Some(x: Long) => x.asInstanceOf[AnyRef]
          case Some(x: Boolean) => x.asInstanceOf[AnyRef]
          case Some(x: Double) => x.asInstanceOf[AnyRef]
          case None => null.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
      }
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._union_of_map_of_union = {
        value match {
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case x: Long => Option(x)
          case x: Boolean => Option(x)
          case map: java.util.Map[?,?] =>
            Option(scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                val map = value.asInstanceOf[java.util.Map[?,?]]
                scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                  val key = kvp._1.toString
                  val value = kvp._2
                  (key, {
                    value match {
                      case x: org.apache.avro.util.Utf8 => Option(x.toString)
                      case x: Long => Option(x)
                      case x: Boolean => Option(x)
                      case x: Double => Option(x)
                      case null => Option(null)
                      case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                    }
                  })
                }
              })
            })
          case null => Option(null)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 1 => this._union_of_map_of_option = {
        value match {
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case x: Long => Option(x)
          case x: Boolean => Option(x)
          case map: java.util.Map[?,?] =>
            Option(scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case null => None
                  case x: org.apache.avro.util.Utf8 => Some(x.toString)
                }
              })
            })
          case null => Option(null)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 2 => this._union_of_array_of_option = {
        value match {
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case x: Long => Option(x)
          case x: Boolean => Option(x)
          case array: java.util.List[?] =>
            Option(scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case null => None
                case x: org.apache.avro.util.Utf8 => Some(x.toString)
              }
            }).toList)
          case null => Option(null)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 3 => this._union_of_array_of_union = {
        value match {
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case x: Long => Option(x)
          case x: Boolean => Option(x)
          case array: java.util.List[?] =>
            Option(scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case x: org.apache.avro.util.Utf8 => Option(x.toString)
                case x: Long => Option(x)
                case x: Boolean => Option(x)
                case x: Double => Option(x)
                case x: java.nio.ByteBuffer => Option(x.array())
                case null => Option(null)
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            }).toList)
          case null => Option(null)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 4 => this._union_of_array_of_array = {
        value match {
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case x: Long => Option(x)
          case x: Boolean => Option(x)
          case array: java.util.List[?] =>
            Option(scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              val array = value.asInstanceOf[java.util.List[?]]
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value match {
                  case x: org.apache.avro.util.Utf8 => Option(x.toString)
                  case x: Long => Option(x)
                  case x: Boolean => Option(x)
                  case x: Double => Option(x)
                  case null => Option(null)
                  case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                }
              }).toList
            }).toList)
          case null => Option(null)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 5 => this._union_of_records = {
        value match {
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case x: Long => Option(x)
          case x: Boolean => Option(x)
          case x: avro2s.test.unions.Record1 => Option(x)
          case x: avro2s.test.unions.Record2 => Option(x)
          case null => Option(null)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 6 => this._union_of_enum = {
        value match {
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case x: Long => Option(x)
          case x: Boolean => Option(x)
          case x: avro2s.test.unions.Enum1 => Option(x)
          case null => Option(null)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 7 => this._union_of_fixed = {
        value match {
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case x: Long => Option(x)
          case x: Boolean => Option(x)
          case x: avro2s.test.unions.Fixed1 => Option(x)
          case null => Option(null)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 8 => this._union_of_string = {
        value match {
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case x: Long => Option(x)
          case null => Option(null)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 9 => this._union_of_int = {
        value match {
          case x: Int => x
          case x: org.apache.avro.util.Utf8 => x.toString
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 10 => this._union_of_long = {
        value match {
          case x: Long => x
          case x: org.apache.avro.util.Utf8 => x.toString
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 11 => this._union_of_float = {
        value match {
          case x: Float => x
          case x: org.apache.avro.util.Utf8 => x.toString
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 12 => this._union_of_double = {
        value match {
          case x: Double => x
          case x: org.apache.avro.util.Utf8 => x.toString
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 13 => this._union_of_boolean = {
        value match {
          case x: Boolean => x
          case x: org.apache.avro.util.Utf8 => x.toString
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 14 => this._union_of_bytes = {
        value match {
          case x: java.nio.ByteBuffer => x.array()
          case x: org.apache.avro.util.Utf8 => x.toString
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 15 => this._optional_record = {
        value match {
          case null => None
          case x: avro2s.test.unions.Record3 => Some(x)
        }
      }
      case 16 => this._optional_enum = {
        value match {
          case null => None
          case x: avro2s.test.unions.Enum2 => Some(x)
        }
      }
      case 17 => this._optional_fixed = {
        value match {
          case null => None
          case x: avro2s.test.unions.Fixed2 => Some(x)
        }
      }
      case 18 => this._optional_string = {
        value match {
          case null => None
          case x: org.apache.avro.util.Utf8 => Some(x.toString)
        }
      }
      case 19 => this._optional_int = {
        value match {
          case null => None
          case x: Int => Some(x)
        }
      }
      case 20 => this._optional_long = {
        value match {
          case null => None
          case x: Long => Some(x)
        }
      }
      case 21 => this._optional_float = {
        value match {
          case null => None
          case x: Float => Some(x)
        }
      }
      case 22 => this._optional_double = {
        value match {
          case null => None
          case x: Double => Some(x)
        }
      }
      case 23 => this._optional_boolean = {
        value match {
          case null => None
          case x: Boolean => Some(x)
        }
      }
      case 24 => this._optional_bytes = {
        value match {
          case null => None
          case x: java.nio.ByteBuffer => Some(x.array())
        }
      }
      case 25 => this._optional_map = {
        value match {
          case null => None
          case map: java.util.Map[?,?] =>
            Some(scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value.toString
              })
            })
        }
      }
      case 26 => this._optional_array = {
        value match {
          case null => None
          case array: java.util.List[?] =>
            Some(scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value.toString
            }).toList)
        }
      }
      case 27 => this._optional_map_of_array = {
        value match {
          case null => None
          case map: java.util.Map[?,?] =>
            Some(scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                val array = value.asInstanceOf[java.util.List[?]]
                scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                  value.toString
                }).toList
              })
            })
        }
      }
      case 28 => this._optional_array_of_map = {
        value match {
          case null => None
          case array: java.util.List[?] =>
            Some(scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              val map = value.asInstanceOf[java.util.Map[?,?]]
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value.toString
                })
              }
            }).toList)
        }
      }
      case 29 => this._optional_map_of_map = {
        value match {
          case null => None
          case map: java.util.Map[?,?] =>
            Some(scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                val map = value.asInstanceOf[java.util.Map[?,?]]
                scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                  val key = kvp._1.toString
                  val value = kvp._2
                  (key, {
                    value.toString
                  })
                }
              })
            })
        }
      }
      case 30 => this._optional_array_of_array = {
        value match {
          case null => None
          case array: java.util.List[?] =>
            Some(scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              val array = value.asInstanceOf[java.util.List[?]]
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value.toString
              }).toList
            }).toList)
        }
      }
      case 31 => this._optional_map_of_union = {
        value match {
          case null => None
          case map: java.util.Map[?,?] =>
            Some(scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case x: org.apache.avro.util.Utf8 => Option(x.toString)
                  case x: Long => Option(x)
                  case x: Boolean => Option(x)
                  case x: Double => Option(x)
                  case null => Option(null)
                  case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                }
              })
            })
        }
      }
      case 32 => this._optional_array_of_union = {
        value match {
          case null => None
          case array: java.util.List[?] =>
            Some(scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case x: org.apache.avro.util.Utf8 => Option(x.toString)
                case x: Long => Option(x)
                case x: Boolean => Option(x)
                case x: Double => Option(x)
                case null => Option(null)
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            }).toList)
        }
      }
    }
  }
}

object Unions {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Unions","namespace":"avro2s.test.unions","fields":[{"name":"_union_of_map_of_union","type":["string","long","boolean",{"type":"map","values":{"type":"map","values":["string","long","boolean","double","null"]}},"null"]},{"name":"_union_of_map_of_option","type":["string","long","boolean",{"type":"map","values":["null","string"]},"null"]},{"name":"_union_of_array_of_option","type":["string","long","boolean",{"type":"array","items":["null","string"]},"null"]},{"name":"_union_of_array_of_union","type":["string","long","boolean",{"type":"array","items":["string","long","boolean","double","bytes","null"]},"null"]},{"name":"_union_of_array_of_array","type":["string","long","boolean",{"type":"array","items":{"type":"array","items":["string","long","boolean","double","null"]}},"null"]},{"name":"_union_of_records","type":["string","long","boolean",{"type":"record","name":"Record1","fields":[{"name":"field1","type":"string"}]},{"type":"record","name":"Record2","fields":[{"name":"field2","type":"long"}]},"null"]},{"name":"_union_of_enum","type":["string","long","boolean",{"type":"enum","name":"Enum1","symbols":["sym1","sym2"]},"null"]},{"name":"_union_of_fixed","type":["string","long","boolean",{"type":"fixed","name":"Fixed1","size":1},"null"]},{"name":"_union_of_string","type":["string","long","null"]},{"name":"_union_of_int","type":["int","string"]},{"name":"_union_of_long","type":["long","string"]},{"name":"_union_of_float","type":["float","string"]},{"name":"_union_of_double","type":["double","string"]},{"name":"_union_of_boolean","type":["boolean","string"]},{"name":"_union_of_bytes","type":["bytes","string"]},{"name":"_optional_record","type":["null",{"type":"record","name":"Record3","fields":[{"name":"field3","type":"string"}]}]},{"name":"_optional_enum","type":["null",{"type":"enum","name":"Enum2","symbols":["sym3","sym4"]}]},{"name":"_optional_fixed","type":["null",{"type":"fixed","name":"Fixed2","size":1}]},{"name":"_optional_string","type":["null","string"]},{"name":"_optional_int","type":["null","int"]},{"name":"_optional_long","type":["null","long"]},{"name":"_optional_float","type":["null","float"]},{"name":"_optional_double","type":["null","double"]},{"name":"_optional_boolean","type":["null","boolean"]},{"name":"_optional_bytes","type":["null","bytes"]},{"name":"_optional_map","type":["null",{"type":"map","values":"string"}]},{"name":"_optional_array","type":["null",{"type":"array","items":"string"}]},{"name":"_optional_map_of_array","type":["null",{"type":"map","values":{"type":"array","items":"string"}}]},{"name":"_optional_array_of_map","type":["null",{"type":"array","items":{"type":"map","values":"string"}}]},{"name":"_optional_map_of_map","type":["null",{"type":"map","values":{"type":"map","values":"string"}}]},{"name":"_optional_array_of_array","type":["null",{"type":"array","items":{"type":"array","items":"string"}}]},{"name":"_optional_map_of_union","type":["null",{"type":"map","values":["string","long","boolean","double","null"]}]},{"name":"_optional_array_of_union","type":["null",{"type":"array","items":["string","long","boolean","double","null"]}]}]}""")
}