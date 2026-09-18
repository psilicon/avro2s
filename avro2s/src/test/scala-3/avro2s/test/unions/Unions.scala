/** GENERATED CODE */

package avro2s.test.unions

import scala.annotation.switch

case class Unions(var _union_of_map_of_union: Option[String | Long | Boolean | Map[String, Map[String, Option[String | Long | Boolean | Double]]]], var _union_of_map_of_option: Option[String | Long | Boolean | Map[String, Option[String]]], var _union_of_array_of_option: Option[String | Long | Boolean | List[Option[String]]], var _union_of_array_of_union: Option[String | Long | Boolean | List[Option[String | Long | Boolean | Double | Array[Byte]]]], var _union_of_array_of_array: Option[String | Long | Boolean | List[List[Option[String | Long | Boolean | Double]]]], var _union_of_records: Option[String | Long | Boolean | avro2s.test.unions.Record1 | avro2s.test.unions.Record2], var _union_of_enum: Option[String | Long | Boolean | avro2s.test.unions.Enum1], var _union_of_fixed: Option[String | Long | Boolean | avro2s.test.unions.Fixed1], var _union_of_string: Option[String | Long], var _union_of_int: Int | String, var _union_of_long: Long | String, var _union_of_float: Float | String, var _union_of_double: Double | String, var _union_of_boolean: Boolean | String, var _union_of_bytes: Array[Byte] | String, var _optional_record: Option[avro2s.test.unions.Record3], var _optional_enum: Option[avro2s.test.unions.Enum2], var _optional_fixed: Option[avro2s.test.unions.Fixed2], var _optional_string: Option[String], var _optional_int: Option[Int], var _optional_long: Option[Long], var _optional_float: Option[Float], var _optional_double: Option[Double], var _optional_boolean: Option[Boolean], var _optional_bytes: Option[Array[Byte]], var _optional_map: Option[Map[String, String]], var _optional_array: Option[List[String]], var _optional_map_of_array: Option[Map[String, List[String]]], var _optional_array_of_map: Option[List[Map[String, String]]], var _optional_map_of_map: Option[Map[String, Map[String, String]]], var _optional_array_of_array: Option[List[List[String]]], var _optional_map_of_union: Option[Map[String, Option[String | Long | Boolean | Double]]], var _optional_array_of_union: Option[List[Option[String | Long | Boolean | Double]]]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(None, None, None, None, None, None, None, None, None, 0, 0, 0, 0, false, _root_.scala.Array.emptyByteArray, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None)

  override def getSchema: org.apache.avro.Schema = Unions.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _union_of_map_of_union match {
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
      case 1 => _union_of_map_of_option match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case Some(x: Long) => x.asInstanceOf[AnyRef]
        case Some(x: Boolean) => x.asInstanceOf[AnyRef]
        case Some(x: Map[String, Option[String]]) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = x.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              kvp._2 match {
                case Some(x: String) => x.asInstanceOf[AnyRef]
                case None => null.asInstanceOf[AnyRef]
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
          {
            def toJavaArray$(input$: List[Option[String]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case Some(x: String) => x.asInstanceOf[AnyRef]
                    case None => null.asInstanceOf[AnyRef]
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(x)
          }
        case None => null.asInstanceOf[AnyRef]
      }
      case 3 => _union_of_array_of_union match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case Some(x: Long) => x.asInstanceOf[AnyRef]
        case Some(x: Boolean) => x.asInstanceOf[AnyRef]
        case Some(x: List[Option[String | Long | Boolean | Double | Array[Byte]]]) =>
          {
            def toJavaArray$(input$: List[Option[String | Long | Boolean | Double | Array[Byte]]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case Some(x: String) => x.asInstanceOf[AnyRef]
                    case Some(x: Long) => x.asInstanceOf[AnyRef]
                    case Some(x: Boolean) => x.asInstanceOf[AnyRef]
                    case Some(x: Double) => x.asInstanceOf[AnyRef]
                    case Some(x: Array[Byte]) =>
                    java.nio.ByteBuffer.wrap(x).asInstanceOf[AnyRef]
                    case None => null.asInstanceOf[AnyRef]
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(x)
          }
        case None => null.asInstanceOf[AnyRef]
      }
      case 4 => _union_of_array_of_array match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case Some(x: Long) => x.asInstanceOf[AnyRef]
        case Some(x: Boolean) => x.asInstanceOf[AnyRef]
        case Some(x: List[List[Option[String | Long | Boolean | Double]]]) =>
          {
            def toJavaArray$(input$: List[List[Option[String | Long | Boolean | Double]]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  {
                    def toJavaArray$(input$: List[Option[String | Long | Boolean | Double]]): java.util.ArrayList[AnyRef] = {
                      var remaining$ = input$
                      val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
                      while (remaining$.nonEmpty) {
                        val element$ = remaining$.head
                        result$.add({
                          element$ match {
                            case Some(x: String) => x.asInstanceOf[AnyRef]
                            case Some(x: Long) => x.asInstanceOf[AnyRef]
                            case Some(x: Boolean) => x.asInstanceOf[AnyRef]
                            case Some(x: Double) => x.asInstanceOf[AnyRef]
                            case None => null.asInstanceOf[AnyRef]
                          }
                        })
                        remaining$ = remaining$.tail
                      }
                      result$
                    }
                    toJavaArray$(element$)
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(x)
          }
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
        case Some(x: avro2s.test.unions.Record3) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 16 => _optional_enum match {
        case Some(x: avro2s.test.unions.Enum2) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 17 => _optional_fixed match {
        case Some(x: avro2s.test.unions.Fixed2) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 18 => _optional_string match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 19 => _optional_int match {
        case Some(x: Int) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 20 => _optional_long match {
        case Some(x: Long) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 21 => _optional_float match {
        case Some(x: Float) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 22 => _optional_double match {
        case Some(x: Double) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 23 => _optional_boolean match {
        case Some(x: Boolean) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 24 => _optional_bytes match {
        case Some(x: Array[Byte]) =>
        java.nio.ByteBuffer.wrap(x).asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 25 => _optional_map match {
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
      case 26 => _optional_array match {
        case Some(x: List[String]) =>
          if (x.isEmpty) new java.util.ArrayList[String](0) else new java.util.ArrayList[String](scala.jdk.CollectionConverters.SeqHasAsJava(x).asJava)
        case None => null.asInstanceOf[AnyRef]
      }
      case 27 => _optional_map_of_array match {
        case Some(x: Map[String, List[String]]) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = x.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              if (kvp._2.isEmpty) new java.util.ArrayList[String](0) else new java.util.ArrayList[String](scala.jdk.CollectionConverters.SeqHasAsJava(kvp._2).asJava)
            }
            map.put(key, value)
          }
          map
        case None => null.asInstanceOf[AnyRef]
      }
      case 28 => _optional_array_of_map match {
        case Some(x: List[Map[String, String]]) =>
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
            toJavaArray$(x)
          }
        case None => null.asInstanceOf[AnyRef]
      }
      case 29 => _optional_map_of_map match {
        case Some(x: Map[String, Map[String, String]]) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = x.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
          x.foreach { kvp =>
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
        case None => null.asInstanceOf[AnyRef]
      }
      case 30 => _optional_array_of_array match {
        case Some(x: List[List[String]]) =>
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
            toJavaArray$(x)
          }
        case None => null.asInstanceOf[AnyRef]
      }
      case 31 => _optional_map_of_union match {
        case Some(x: Map[String, Option[String | Long | Boolean | Double]]) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = x.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
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
        case None => null.asInstanceOf[AnyRef]
      }
      case 32 => _optional_array_of_union match {
        case Some(x: List[Option[String | Long | Boolean | Double]]) =>
          {
            def toJavaArray$(input$: List[Option[String | Long | Boolean | Double]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case Some(x: String) => x.asInstanceOf[AnyRef]
                    case Some(x: Long) => x.asInstanceOf[AnyRef]
                    case Some(x: Boolean) => x.asInstanceOf[AnyRef]
                    case Some(x: Double) => x.asInstanceOf[AnyRef]
                    case None => null.asInstanceOf[AnyRef]
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(x)
          }
        case None => null.asInstanceOf[AnyRef]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
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
      }
      case 1 => this._union_of_map_of_option = {
        value match {
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case x: Long => Option(x)
          case x: Boolean => Option(x)
          case map: java.util.Map[?,?] =>
            Option(if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[String]] else {
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value match {
                    case null => None
                    case x: org.apache.avro.util.Utf8 => Option(x.toString)
                    case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                  }
                })
              }.toMap
            })
          case null => None
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
                case x: org.apache.avro.util.Utf8 => Option(x.toString)
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            }).toList)
          case null => None
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
                case null => None
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            }).toList)
          case null => None
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
                  case null => None
                  case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                }
              }).toList
            }).toList)
          case null => None
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 5 => this._union_of_records = {
        value match {
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case x: Long => Option(x)
          case x: Boolean => Option(x)
          case x: avro2s.test.unions.Record1 => Option(x.asInstanceOf[String | Long | Boolean | avro2s.test.unions.Record1 | avro2s.test.unions.Record2])
          case x: avro2s.test.unions.Record2 => Option(x.asInstanceOf[String | Long | Boolean | avro2s.test.unions.Record1 | avro2s.test.unions.Record2])
          case null => None
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 6 => this._union_of_enum = {
        value match {
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case x: Long => Option(x)
          case x: Boolean => Option(x)
          case x: avro2s.test.unions.Enum1 => Option(x.asInstanceOf[String | Long | Boolean | avro2s.test.unions.Enum1])
          case null => None
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 7 => this._union_of_fixed = {
        value match {
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case x: Long => Option(x)
          case x: Boolean => Option(x)
          case x: avro2s.test.unions.Fixed1 => Option(x.asInstanceOf[String | Long | Boolean | avro2s.test.unions.Fixed1])
          case null => None
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 8 => this._union_of_string = {
        value match {
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case x: Long => Option(x)
          case null => None
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
          case x: avro2s.test.unions.Record3 => Option(x.asInstanceOf[avro2s.test.unions.Record3])
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 16 => this._optional_enum = {
        value match {
          case null => None
          case x: avro2s.test.unions.Enum2 => Option(x.asInstanceOf[avro2s.test.unions.Enum2])
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 17 => this._optional_fixed = {
        value match {
          case null => None
          case x: avro2s.test.unions.Fixed2 => Option(x.asInstanceOf[avro2s.test.unions.Fixed2])
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 18 => this._optional_string = {
        value match {
          case null => None
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 19 => this._optional_int = {
        value match {
          case null => None
          case x: Int => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 20 => this._optional_long = {
        value match {
          case null => None
          case x: Long => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 21 => this._optional_float = {
        value match {
          case null => None
          case x: Float => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 22 => this._optional_double = {
        value match {
          case null => None
          case x: Double => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 23 => this._optional_boolean = {
        value match {
          case null => None
          case x: Boolean => Option(x)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 24 => this._optional_bytes = {
        value match {
          case null => None
          case x: java.nio.ByteBuffer => Option(x.array())
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 25 => this._optional_map = {
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
      }
      case 26 => this._optional_array = {
        value match {
          case null => None
          case array: java.util.List[?] =>
            Option(scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value.toString
            }).toList)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 27 => this._optional_map_of_array = {
        value match {
          case null => None
          case map: java.util.Map[?,?] =>
            Option(if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, List[String]] else {
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
            })
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 28 => this._optional_array_of_map = {
        value match {
          case null => None
          case array: java.util.List[?] =>
            Option(scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
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
            }).toList)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 29 => this._optional_map_of_map = {
        value match {
          case null => None
          case map: java.util.Map[?,?] =>
            Option(if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Map[String, String]] else {
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
            })
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 30 => this._optional_array_of_array = {
        value match {
          case null => None
          case array: java.util.List[?] =>
            Option(scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              val array = value.asInstanceOf[java.util.List[?]]
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value.toString
              }).toList
            }).toList)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 31 => this._optional_map_of_union = {
        value match {
          case null => None
          case map: java.util.Map[?,?] =>
            Option(if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[String | Long | Boolean | Double]] else {
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
            })
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 32 => this._optional_array_of_union = {
        value match {
          case null => None
          case array: java.util.List[?] =>
            Option(scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case x: org.apache.avro.util.Utf8 => Option(x.toString)
                case x: Long => Option(x)
                case x: Boolean => Option(x)
                case x: Double => Option(x)
                case null => None
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            }).toList)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override protected def hasCustomCoders(): Boolean = true
  override def customEncode(out$: _root_.org.apache.avro.io.Encoder): Unit = encode$0(this, out$)
  override def customDecode(in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = decodeRecord$0(this, in$)

  private def encode$0(value$: _root_.avro2s.test.unions.Unions, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`_union_of_map_of_union`, out$)
    encode$14(value$.`_union_of_map_of_option`, out$)
    encode$23(value$.`_union_of_array_of_option`, out$)
    encode$32(value$.`_union_of_array_of_union`, out$)
    encode$45(value$.`_union_of_array_of_array`, out$)
    encode$58(value$.`_union_of_records`, out$)
    encode$67(value$.`_union_of_enum`, out$)
    encode$73(value$.`_union_of_fixed`, out$)
    encode$79(value$.`_union_of_string`, out$)
    encode$83(value$.`_union_of_int`, out$)
    encode$86(value$.`_union_of_long`, out$)
    encode$89(value$.`_union_of_float`, out$)
    encode$92(value$.`_union_of_double`, out$)
    encode$95(value$.`_union_of_boolean`, out$)
    encode$98(value$.`_union_of_bytes`, out$)
    encode$101(value$.`_optional_record`, out$)
    encode$105(value$.`_optional_enum`, out$)
    encode$108(value$.`_optional_fixed`, out$)
    encode$111(value$.`_optional_string`, out$)
    encode$114(value$.`_optional_int`, out$)
    encode$117(value$.`_optional_long`, out$)
    encode$120(value$.`_optional_float`, out$)
    encode$123(value$.`_optional_double`, out$)
    encode$126(value$.`_optional_boolean`, out$)
    encode$129(value$.`_optional_bytes`, out$)
    encode$132(value$.`_optional_map`, out$)
    encode$136(value$.`_optional_array`, out$)
    encode$140(value$.`_optional_map_of_array`, out$)
    encode$145(value$.`_optional_array_of_map`, out$)
    encode$150(value$.`_optional_map_of_map`, out$)
    encode$155(value$.`_optional_array_of_array`, out$)
    encode$160(value$.`_optional_map_of_union`, out$)
    encode$169(value$.`_optional_array_of_union`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.unions.Unions): _root_.avro2s.test.unions.Unions = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.unions.Unions() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.unions.Unions, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_union_of_map_of_union` = decode$1(in$)
      value$.`_union_of_map_of_option` = decode$14(in$)
      value$.`_union_of_array_of_option` = decode$23(in$)
      value$.`_union_of_array_of_union` = decode$32(in$)
      value$.`_union_of_array_of_array` = decode$45(in$)
      value$.`_union_of_records` = decode$58(in$)
      value$.`_union_of_enum` = decode$67(in$)
      value$.`_union_of_fixed` = decode$73(in$)
      value$.`_union_of_string` = decode$79(in$)
      value$.`_union_of_int` = decode$83(in$)
      value$.`_union_of_long` = decode$86(in$)
      value$.`_union_of_float` = decode$89(in$)
      value$.`_union_of_double` = decode$92(in$)
      value$.`_union_of_boolean` = decode$95(in$)
      value$.`_union_of_bytes` = decode$98(in$)
      value$.`_optional_record` = decode$101(in$)
      value$.`_optional_enum` = decode$105(in$)
      value$.`_optional_fixed` = decode$108(in$)
      value$.`_optional_string` = decode$111(in$)
      value$.`_optional_int` = decode$114(in$)
      value$.`_optional_long` = decode$117(in$)
      value$.`_optional_float` = decode$120(in$)
      value$.`_optional_double` = decode$123(in$)
      value$.`_optional_boolean` = decode$126(in$)
      value$.`_optional_bytes` = decode$129(in$)
      value$.`_optional_map` = decode$132(in$)
      value$.`_optional_array` = decode$136(in$)
      value$.`_optional_map_of_array` = decode$140(in$)
      value$.`_optional_array_of_map` = decode$145(in$)
      value$.`_optional_map_of_map` = decode$150(in$)
      value$.`_optional_array_of_array` = decode$155(in$)
      value$.`_optional_map_of_union` = decode$160(in$)
      value$.`_optional_array_of_union` = decode$169(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_union_of_map_of_union` = decode$1(in$)
          case 1 => value$.`_union_of_map_of_option` = decode$14(in$)
          case 2 => value$.`_union_of_array_of_option` = decode$23(in$)
          case 3 => value$.`_union_of_array_of_union` = decode$32(in$)
          case 4 => value$.`_union_of_array_of_array` = decode$45(in$)
          case 5 => value$.`_union_of_records` = decode$58(in$)
          case 6 => value$.`_union_of_enum` = decode$67(in$)
          case 7 => value$.`_union_of_fixed` = decode$73(in$)
          case 8 => value$.`_union_of_string` = decode$79(in$)
          case 9 => value$.`_union_of_int` = decode$83(in$)
          case 10 => value$.`_union_of_long` = decode$86(in$)
          case 11 => value$.`_union_of_float` = decode$89(in$)
          case 12 => value$.`_union_of_double` = decode$92(in$)
          case 13 => value$.`_union_of_boolean` = decode$95(in$)
          case 14 => value$.`_union_of_bytes` = decode$98(in$)
          case 15 => value$.`_optional_record` = decode$101(in$)
          case 16 => value$.`_optional_enum` = decode$105(in$)
          case 17 => value$.`_optional_fixed` = decode$108(in$)
          case 18 => value$.`_optional_string` = decode$111(in$)
          case 19 => value$.`_optional_int` = decode$114(in$)
          case 20 => value$.`_optional_long` = decode$117(in$)
          case 21 => value$.`_optional_float` = decode$120(in$)
          case 22 => value$.`_optional_double` = decode$123(in$)
          case 23 => value$.`_optional_boolean` = decode$126(in$)
          case 24 => value$.`_optional_bytes` = decode$129(in$)
          case 25 => value$.`_optional_map` = decode$132(in$)
          case 26 => value$.`_optional_array` = decode$136(in$)
          case 27 => value$.`_optional_map_of_array` = decode$140(in$)
          case 28 => value$.`_optional_array_of_map` = decode$145(in$)
          case 29 => value$.`_optional_map_of_map` = decode$150(in$)
          case 30 => value$.`_optional_array_of_array` = decode$155(in$)
          case 31 => value$.`_optional_map_of_union` = decode$160(in$)
          case 32 => value$.`_optional_array_of_union` = decode$169(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$1(value$: _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$2(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$3(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Boolean @unchecked)) =>
        out$.writeIndex(2)
        encode$4(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]] @unchecked)) =>
        out$.writeIndex(3)
        encode$5(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(4)
        encode$13(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$1(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]]] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$2(in$))
      case 1 => _root_.scala.Some(decode$3(in$))
      case 2 => _root_.scala.Some(decode$4(in$))
      case 3 => _root_.scala.Some(decode$5(in$))
      case 4 => { decode$13(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$2(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$2(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$3(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$3(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$4(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$4(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$5(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$5(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]]
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

  private def encode$6(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$6(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]
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

  private def encode$7(value$: _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$8(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$9(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Boolean @unchecked)) =>
        out$.writeIndex(2)
        encode$10(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Double @unchecked)) =>
        out$.writeIndex(3)
        encode$11(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(4)
        encode$12(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$7(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$8(in$))
      case 1 => _root_.scala.Some(decode$9(in$))
      case 2 => _root_.scala.Some(decode$10(in$))
      case 3 => _root_.scala.Some(decode$11(in$))
      case 4 => { decode$12(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$8(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$8(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$9(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$9(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$10(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$10(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$11(value$: _root_.scala.Double, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeDouble(value$)
  }

  private def decode$11(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double = {
    in$.readDouble()
  }

  private def encode$12(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$12(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$13(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$13(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$14(value$: _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$15(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$16(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Boolean @unchecked)) =>
        out$.writeIndex(2)
        encode$17(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String]] @unchecked)) =>
        out$.writeIndex(3)
        encode$18(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(4)
        encode$22(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$14(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String]]] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$15(in$))
      case 1 => _root_.scala.Some(decode$16(in$))
      case 2 => _root_.scala.Some(decode$17(in$))
      case 3 => _root_.scala.Some(decode$18(in$))
      case 4 => { decode$22(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$15(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$15(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$16(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$16(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$17(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$17(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$18(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$19(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$18(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$19(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$19(value$: _root_.scala.Option[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$20(null, out$)
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(1)
        encode$21(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$19(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String] = {
    in$.readIndex() match {
      case 0 => { decode$20(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$21(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$20(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$20(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$21(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$21(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$22(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$22(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$23(value$: _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.List[_root_.scala.Option[_root_.java.lang.String]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$24(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$25(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Boolean @unchecked)) =>
        out$.writeIndex(2)
        encode$26(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.List[_root_.scala.Option[_root_.java.lang.String]] @unchecked)) =>
        out$.writeIndex(3)
        encode$27(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(4)
        encode$31(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$23(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.List[_root_.scala.Option[_root_.java.lang.String]]] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$24(in$))
      case 1 => _root_.scala.Some(decode$25(in$))
      case 2 => _root_.scala.Some(decode$26(in$))
      case 3 => _root_.scala.Some(decode$27(in$))
      case 4 => { decode$31(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$24(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$24(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$25(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$25(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$26(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$26(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$27(value$: _root_.scala.List[_root_.scala.Option[_root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$27(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Option[_root_.java.lang.String]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Option[_root_.java.lang.String]]
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

  private def encode$28(value$: _root_.scala.Option[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$29(null, out$)
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(1)
        encode$30(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$28(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String] = {
    in$.readIndex() match {
      case 0 => { decode$29(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$30(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$29(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$29(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$30(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$30(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$31(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$31(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$32(value$: _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double | _root_.scala.Array[_root_.scala.Byte]]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$33(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$34(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Boolean @unchecked)) =>
        out$.writeIndex(2)
        encode$35(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double | _root_.scala.Array[_root_.scala.Byte]]] @unchecked)) =>
        out$.writeIndex(3)
        encode$36(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(4)
        encode$44(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$32(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double | _root_.scala.Array[_root_.scala.Byte]]]] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$33(in$))
      case 1 => _root_.scala.Some(decode$34(in$))
      case 2 => _root_.scala.Some(decode$35(in$))
      case 3 => _root_.scala.Some(decode$36(in$))
      case 4 => { decode$44(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$33(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$33(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$34(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$34(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$35(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$35(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$36(value$: _root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double | _root_.scala.Array[_root_.scala.Byte]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$36(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double | _root_.scala.Array[_root_.scala.Byte]]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double | _root_.scala.Array[_root_.scala.Byte]]]
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

  private def encode$37(value$: _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double | _root_.scala.Array[_root_.scala.Byte]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$38(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$39(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Boolean @unchecked)) =>
        out$.writeIndex(2)
        encode$40(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Double @unchecked)) =>
        out$.writeIndex(3)
        encode$41(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Array[_root_.scala.Byte] @unchecked)) =>
        out$.writeIndex(4)
        encode$42(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(5)
        encode$43(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$37(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double | _root_.scala.Array[_root_.scala.Byte]] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$38(in$))
      case 1 => _root_.scala.Some(decode$39(in$))
      case 2 => _root_.scala.Some(decode$40(in$))
      case 3 => _root_.scala.Some(decode$41(in$))
      case 4 => _root_.scala.Some(decode$42(in$))
      case 5 => { decode$43(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$38(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$38(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$39(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$39(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$40(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$40(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$41(value$: _root_.scala.Double, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeDouble(value$)
  }

  private def decode$41(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double = {
    in$.readDouble()
  }

  private def encode$42(value$: _root_.scala.Array[_root_.scala.Byte], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBytes(value$)
  }

  private def decode$42(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Array[_root_.scala.Byte] = {
    val buffer$ = in$.readBytes(null)
    if (buffer$.hasArray && buffer$.arrayOffset() == 0 && buffer$.position() == 0 && buffer$.remaining() == buffer$.array().length) buffer$.array()
    else {
      val bytes$ = new _root_.scala.Array[Byte](buffer$.remaining())
      buffer$.get(bytes$)
      bytes$
    }
  }

  private def encode$43(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$43(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$44(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$44(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$45(value$: _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.List[_root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$46(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$47(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Boolean @unchecked)) =>
        out$.writeIndex(2)
        encode$48(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.List[_root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]] @unchecked)) =>
        out$.writeIndex(3)
        encode$49(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(4)
        encode$57(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$45(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.List[_root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]]] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$46(in$))
      case 1 => _root_.scala.Some(decode$47(in$))
      case 2 => _root_.scala.Some(decode$48(in$))
      case 3 => _root_.scala.Some(decode$49(in$))
      case 4 => { decode$57(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$46(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$46(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$47(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$47(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$48(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$48(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$49(value$: _root_.scala.List[_root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
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

  private def decode$49(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]]
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

  private def encode$50(value$: _root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$51(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$50(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$51(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$51(value$: _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$52(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$53(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Boolean @unchecked)) =>
        out$.writeIndex(2)
        encode$54(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Double @unchecked)) =>
        out$.writeIndex(3)
        encode$55(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(4)
        encode$56(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$51(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$52(in$))
      case 1 => _root_.scala.Some(decode$53(in$))
      case 2 => _root_.scala.Some(decode$54(in$))
      case 3 => _root_.scala.Some(decode$55(in$))
      case 4 => { decode$56(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$52(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$52(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$53(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$53(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$54(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$54(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$55(value$: _root_.scala.Double, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeDouble(value$)
  }

  private def decode$55(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double = {
    in$.readDouble()
  }

  private def encode$56(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$56(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$57(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$57(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$58(value$: _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.avro2s.test.unions.Record1 | _root_.avro2s.test.unions.Record2], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$59(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$60(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Boolean @unchecked)) =>
        out$.writeIndex(2)
        encode$61(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.avro2s.test.unions.Record1 @unchecked)) =>
        out$.writeIndex(3)
        encode$62(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.avro2s.test.unions.Record2 @unchecked)) =>
        out$.writeIndex(4)
        encode$64(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(5)
        encode$66(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$58(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.avro2s.test.unions.Record1 | _root_.avro2s.test.unions.Record2] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$59(in$))
      case 1 => _root_.scala.Some(decode$60(in$))
      case 2 => _root_.scala.Some(decode$61(in$))
      case 3 => _root_.scala.Some(decode$62(in$, null))
      case 4 => _root_.scala.Some(decode$64(in$, null))
      case 5 => { decode$66(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$59(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$59(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$60(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$60(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$61(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$61(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$62(value$: _root_.avro2s.test.unions.Record1, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$63(value$.`field1`, out$)
  }

  private def decode$62(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.unions.Record1): _root_.avro2s.test.unions.Record1 = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.unions.Record1() else reuse$
    decodeRecord$62(result$, in$)
    result$
  }

  private def decodeRecord$62(value$: _root_.avro2s.test.unions.Record1, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`field1` = decode$63(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`field1` = decode$63(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$63(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$63(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$64(value$: _root_.avro2s.test.unions.Record2, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$65(value$.`field2`, out$)
  }

  private def decode$64(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.unions.Record2): _root_.avro2s.test.unions.Record2 = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.unions.Record2() else reuse$
    decodeRecord$64(result$, in$)
    result$
  }

  private def decodeRecord$64(value$: _root_.avro2s.test.unions.Record2, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`field2` = decode$65(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`field2` = decode$65(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$65(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$65(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$66(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$66(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$67(value$: _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.avro2s.test.unions.Enum1], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$68(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$69(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Boolean @unchecked)) =>
        out$.writeIndex(2)
        encode$70(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.avro2s.test.unions.Enum1 @unchecked)) =>
        out$.writeIndex(3)
        encode$71(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(4)
        encode$72(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$67(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.avro2s.test.unions.Enum1] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$68(in$))
      case 1 => _root_.scala.Some(decode$69(in$))
      case 2 => _root_.scala.Some(decode$70(in$))
      case 3 => _root_.scala.Some(decode$71(in$))
      case 4 => { decode$72(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$68(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$68(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$69(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$69(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$70(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$70(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$71(value$: _root_.avro2s.test.unions.Enum1, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeEnum(value$.ordinal())
  }

  private def decode$71(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.unions.Enum1 = {
    _root_.avro2s.test.unions.Unions.customEnum$71(in$.readEnum())
  }

  private def encode$72(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$72(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$73(value$: _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.avro2s.test.unions.Fixed1], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$74(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$75(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Boolean @unchecked)) =>
        out$.writeIndex(2)
        encode$76(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.avro2s.test.unions.Fixed1 @unchecked)) =>
        out$.writeIndex(3)
        encode$77(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(4)
        encode$78(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$73(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.avro2s.test.unions.Fixed1] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$74(in$))
      case 1 => _root_.scala.Some(decode$75(in$))
      case 2 => _root_.scala.Some(decode$76(in$))
      case 3 => _root_.scala.Some(decode$77(in$))
      case 4 => { decode$78(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$74(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$74(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$75(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$75(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$76(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$76(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$77(value$: _root_.avro2s.test.unions.Fixed1, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFixed(value$.bytes(), 0, 1)
  }

  private def decode$77(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.unions.Fixed1 = {
    val result$ = new _root_.avro2s.test.unions.Fixed1()
    in$.readFixed(result$.bytes())
    result$
  }

  private def encode$78(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$78(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$79(value$: _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$80(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$81(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(2)
        encode$82(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$79(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$80(in$))
      case 1 => _root_.scala.Some(decode$81(in$))
      case 2 => { decode$82(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$80(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$80(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$81(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$81(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$82(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$82(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$83(value$: _root_.scala.Int | _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.scala.Int @unchecked) =>
        out$.writeIndex(0)
        encode$84(branch$, out$)
      case branch$: (_root_.java.lang.String @unchecked) =>
        out$.writeIndex(1)
        encode$85(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$83(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int | _root_.java.lang.String = {
    in$.readIndex() match {
      case 0 => decode$84(in$)
      case 1 => decode$85(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$84(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$84(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$85(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$85(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$86(value$: _root_.scala.Long | _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.scala.Long @unchecked) =>
        out$.writeIndex(0)
        encode$87(branch$, out$)
      case branch$: (_root_.java.lang.String @unchecked) =>
        out$.writeIndex(1)
        encode$88(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$86(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long | _root_.java.lang.String = {
    in$.readIndex() match {
      case 0 => decode$87(in$)
      case 1 => decode$88(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$87(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$87(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$88(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$88(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$89(value$: _root_.scala.Float | _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.scala.Float @unchecked) =>
        out$.writeIndex(0)
        encode$90(branch$, out$)
      case branch$: (_root_.java.lang.String @unchecked) =>
        out$.writeIndex(1)
        encode$91(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$89(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Float | _root_.java.lang.String = {
    in$.readIndex() match {
      case 0 => decode$90(in$)
      case 1 => decode$91(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$90(value$: _root_.scala.Float, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFloat(value$)
  }

  private def decode$90(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Float = {
    in$.readFloat()
  }

  private def encode$91(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$91(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$92(value$: _root_.scala.Double | _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.scala.Double @unchecked) =>
        out$.writeIndex(0)
        encode$93(branch$, out$)
      case branch$: (_root_.java.lang.String @unchecked) =>
        out$.writeIndex(1)
        encode$94(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$92(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double | _root_.java.lang.String = {
    in$.readIndex() match {
      case 0 => decode$93(in$)
      case 1 => decode$94(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$93(value$: _root_.scala.Double, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeDouble(value$)
  }

  private def decode$93(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double = {
    in$.readDouble()
  }

  private def encode$94(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$94(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$95(value$: _root_.scala.Boolean | _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.scala.Boolean @unchecked) =>
        out$.writeIndex(0)
        encode$96(branch$, out$)
      case branch$: (_root_.java.lang.String @unchecked) =>
        out$.writeIndex(1)
        encode$97(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$95(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean | _root_.java.lang.String = {
    in$.readIndex() match {
      case 0 => decode$96(in$)
      case 1 => decode$97(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$96(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$96(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$97(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$97(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$98(value$: _root_.scala.Array[_root_.scala.Byte] | _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.scala.Array[_root_.scala.Byte] @unchecked) =>
        out$.writeIndex(0)
        encode$99(branch$, out$)
      case branch$: (_root_.java.lang.String @unchecked) =>
        out$.writeIndex(1)
        encode$100(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$98(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Array[_root_.scala.Byte] | _root_.java.lang.String = {
    in$.readIndex() match {
      case 0 => decode$99(in$)
      case 1 => decode$100(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$99(value$: _root_.scala.Array[_root_.scala.Byte], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBytes(value$)
  }

  private def decode$99(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Array[_root_.scala.Byte] = {
    val buffer$ = in$.readBytes(null)
    if (buffer$.hasArray && buffer$.arrayOffset() == 0 && buffer$.position() == 0 && buffer$.remaining() == buffer$.array().length) buffer$.array()
    else {
      val bytes$ = new _root_.scala.Array[Byte](buffer$.remaining())
      buffer$.get(bytes$)
      bytes$
    }
  }

  private def encode$100(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$100(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$101(value$: _root_.scala.Option[_root_.avro2s.test.unions.Record3], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$102(null, out$)
      case _root_.scala.Some(branch$: (_root_.avro2s.test.unions.Record3 @unchecked)) =>
        out$.writeIndex(1)
        encode$103(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$101(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.avro2s.test.unions.Record3] = {
    in$.readIndex() match {
      case 0 => { decode$102(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$103(in$, null))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$102(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$102(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$103(value$: _root_.avro2s.test.unions.Record3, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$104(value$.`field3`, out$)
  }

  private def decode$103(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.unions.Record3): _root_.avro2s.test.unions.Record3 = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.unions.Record3() else reuse$
    decodeRecord$103(result$, in$)
    result$
  }

  private def decodeRecord$103(value$: _root_.avro2s.test.unions.Record3, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`field3` = decode$104(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`field3` = decode$104(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$104(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$104(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$105(value$: _root_.scala.Option[_root_.avro2s.test.unions.Enum2], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$106(null, out$)
      case _root_.scala.Some(branch$: (_root_.avro2s.test.unions.Enum2 @unchecked)) =>
        out$.writeIndex(1)
        encode$107(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$105(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.avro2s.test.unions.Enum2] = {
    in$.readIndex() match {
      case 0 => { decode$106(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$107(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$106(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$106(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$107(value$: _root_.avro2s.test.unions.Enum2, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeEnum(value$.ordinal())
  }

  private def decode$107(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.unions.Enum2 = {
    _root_.avro2s.test.unions.Unions.customEnum$107(in$.readEnum())
  }

  private def encode$108(value$: _root_.scala.Option[_root_.avro2s.test.unions.Fixed2], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$109(null, out$)
      case _root_.scala.Some(branch$: (_root_.avro2s.test.unions.Fixed2 @unchecked)) =>
        out$.writeIndex(1)
        encode$110(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$108(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.avro2s.test.unions.Fixed2] = {
    in$.readIndex() match {
      case 0 => { decode$109(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$110(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$109(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$109(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$110(value$: _root_.avro2s.test.unions.Fixed2, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFixed(value$.bytes(), 0, 1)
  }

  private def decode$110(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.unions.Fixed2 = {
    val result$ = new _root_.avro2s.test.unions.Fixed2()
    in$.readFixed(result$.bytes())
    result$
  }

  private def encode$111(value$: _root_.scala.Option[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$112(null, out$)
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(1)
        encode$113(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$111(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String] = {
    in$.readIndex() match {
      case 0 => { decode$112(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$113(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$112(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$112(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$113(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$113(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$114(value$: _root_.scala.Option[_root_.scala.Int], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$115(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Int @unchecked)) =>
        out$.writeIndex(1)
        encode$116(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$114(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.Int] = {
    in$.readIndex() match {
      case 0 => { decode$115(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$116(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$115(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$115(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$116(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$116(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$117(value$: _root_.scala.Option[_root_.scala.Long], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$118(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$119(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$117(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.Long] = {
    in$.readIndex() match {
      case 0 => { decode$118(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$119(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$118(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$118(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$119(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$119(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$120(value$: _root_.scala.Option[_root_.scala.Float], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$121(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Float @unchecked)) =>
        out$.writeIndex(1)
        encode$122(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$120(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.Float] = {
    in$.readIndex() match {
      case 0 => { decode$121(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$122(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$121(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$121(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$122(value$: _root_.scala.Float, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFloat(value$)
  }

  private def decode$122(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Float = {
    in$.readFloat()
  }

  private def encode$123(value$: _root_.scala.Option[_root_.scala.Double], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$124(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Double @unchecked)) =>
        out$.writeIndex(1)
        encode$125(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$123(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.Double] = {
    in$.readIndex() match {
      case 0 => { decode$124(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$125(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$124(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$124(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$125(value$: _root_.scala.Double, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeDouble(value$)
  }

  private def decode$125(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double = {
    in$.readDouble()
  }

  private def encode$126(value$: _root_.scala.Option[_root_.scala.Boolean], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$127(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Boolean @unchecked)) =>
        out$.writeIndex(1)
        encode$128(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$126(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.Boolean] = {
    in$.readIndex() match {
      case 0 => { decode$127(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$128(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$127(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$127(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$128(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$128(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$129(value$: _root_.scala.Option[_root_.scala.Array[_root_.scala.Byte]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$130(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Array[_root_.scala.Byte] @unchecked)) =>
        out$.writeIndex(1)
        encode$131(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$129(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.Array[_root_.scala.Byte]] = {
    in$.readIndex() match {
      case 0 => { decode$130(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$131(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$130(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$130(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$131(value$: _root_.scala.Array[_root_.scala.Byte], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBytes(value$)
  }

  private def decode$131(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Array[_root_.scala.Byte] = {
    val buffer$ = in$.readBytes(null)
    if (buffer$.hasArray && buffer$.arrayOffset() == 0 && buffer$.position() == 0 && buffer$.remaining() == buffer$.array().length) buffer$.array()
    else {
      val bytes$ = new _root_.scala.Array[Byte](buffer$.remaining())
      buffer$.get(bytes$)
      bytes$
    }
  }

  private def encode$132(value$: _root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$133(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String] @unchecked)) =>
        out$.writeIndex(1)
        encode$134(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$132(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]] = {
    in$.readIndex() match {
      case 0 => { decode$133(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$134(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$133(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$133(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$134(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$135(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$134(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$135(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$135(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$135(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$136(value$: _root_.scala.Option[_root_.scala.List[_root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$137(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.List[_root_.java.lang.String] @unchecked)) =>
        out$.writeIndex(1)
        encode$138(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$136(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.List[_root_.java.lang.String]] = {
    in$.readIndex() match {
      case 0 => { decode$137(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$138(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$137(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$137(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$138(value$: _root_.scala.List[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$139(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$138(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.java.lang.String] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$139(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$139(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$139(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$140(value$: _root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[_root_.java.lang.String]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$141(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[_root_.java.lang.String]] @unchecked)) =>
        out$.writeIndex(1)
        encode$142(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$140(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[_root_.java.lang.String]]] = {
    in$.readIndex() match {
      case 0 => { decode$141(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$142(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$141(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$141(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$142(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[_root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$143(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$142(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.List[_root_.java.lang.String]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.List[_root_.java.lang.String]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$143(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$143(value$: _root_.scala.List[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$144(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$143(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.java.lang.String] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$144(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$144(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$144(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$145(value$: _root_.scala.Option[_root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$146(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]] @unchecked)) =>
        out$.writeIndex(1)
        encode$147(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$145(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]]] = {
    in$.readIndex() match {
      case 0 => { decode$146(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$147(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$146(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$146(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$147(value$: _root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$148(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$147(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$148(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$148(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$149(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$148(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$149(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$149(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$149(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$150(value$: _root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$151(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]] @unchecked)) =>
        out$.writeIndex(1)
        encode$152(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$150(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]]] = {
    in$.readIndex() match {
      case 0 => { decode$151(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$152(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$151(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$151(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$152(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$153(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$152(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$153(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$153(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$154(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$153(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.java.lang.String] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$154(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$154(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$154(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$155(value$: _root_.scala.Option[_root_.scala.List[_root_.scala.List[_root_.java.lang.String]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$156(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.List[_root_.scala.List[_root_.java.lang.String]] @unchecked)) =>
        out$.writeIndex(1)
        encode$157(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$155(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.List[_root_.scala.List[_root_.java.lang.String]]] = {
    in$.readIndex() match {
      case 0 => { decode$156(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$157(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$156(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$156(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$157(value$: _root_.scala.List[_root_.scala.List[_root_.java.lang.String]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$158(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$157(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.List[_root_.java.lang.String]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.List[_root_.java.lang.String]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$158(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$158(value$: _root_.scala.List[_root_.java.lang.String], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$159(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$158(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.java.lang.String] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.java.lang.String]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$159(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$159(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$159(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$160(value$: _root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$161(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]] @unchecked)) =>
        out$.writeIndex(1)
        encode$162(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$160(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]] = {
    in$.readIndex() match {
      case 0 => { decode$161(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$162(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$161(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$161(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$162(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$163(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$162(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$163(in$)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$163(value$: _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$164(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$165(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Boolean @unchecked)) =>
        out$.writeIndex(2)
        encode$166(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Double @unchecked)) =>
        out$.writeIndex(3)
        encode$167(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(4)
        encode$168(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$163(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$164(in$))
      case 1 => _root_.scala.Some(decode$165(in$))
      case 2 => _root_.scala.Some(decode$166(in$))
      case 3 => _root_.scala.Some(decode$167(in$))
      case 4 => { decode$168(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$164(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$164(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$165(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$165(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$166(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$166(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$167(value$: _root_.scala.Double, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeDouble(value$)
  }

  private def decode$167(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double = {
    in$.readDouble()
  }

  private def encode$168(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$168(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$169(value$: _root_.scala.Option[_root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.None =>
        out$.writeIndex(0)
        encode$170(null, out$)
      case _root_.scala.Some(branch$: (_root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]] @unchecked)) =>
        out$.writeIndex(1)
        encode$171(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$169(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]] = {
    in$.readIndex() match {
      case 0 => { decode$170(in$); _root_.scala.None }
      case 1 => _root_.scala.Some(decode$171(in$))
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$170(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$170(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$171(value$: _root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$172(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$171(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double]]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$172(in$)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$172(value$: _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case _root_.scala.Some(branch$: (_root_.java.lang.String @unchecked)) =>
        out$.writeIndex(0)
        encode$173(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Long @unchecked)) =>
        out$.writeIndex(1)
        encode$174(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Boolean @unchecked)) =>
        out$.writeIndex(2)
        encode$175(branch$, out$)
      case _root_.scala.Some(branch$: (_root_.scala.Double @unchecked)) =>
        out$.writeIndex(3)
        encode$176(branch$, out$)
      case _root_.scala.None =>
        out$.writeIndex(4)
        encode$177(null, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$172(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Option[_root_.java.lang.String | _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Double] = {
    in$.readIndex() match {
      case 0 => _root_.scala.Some(decode$173(in$))
      case 1 => _root_.scala.Some(decode$174(in$))
      case 2 => _root_.scala.Some(decode$175(in$))
      case 3 => _root_.scala.Some(decode$176(in$))
      case 4 => { decode$177(in$); _root_.scala.None }
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$173(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$173(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$174(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$174(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$175(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$175(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$176(value$: _root_.scala.Double, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeDouble(value$)
  }

  private def decode$176(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double = {
    in$.readDouble()
  }

  private def encode$177(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$177(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }
}

object Unions {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Unions","namespace":"avro2s.test.unions","fields":[{"name":"_union_of_map_of_union","type":["string","long","boolean",{"type":"map","values":{"type":"map","values":["string","long","boolean","double","null"]}},"null"]},{"name":"_union_of_map_of_option","type":["string","long","boolean",{"type":"map","values":["null","string"]},"null"]},{"name":"_union_of_array_of_option","type":["string","long","boolean",{"type":"array","items":["null","string"]},"null"]},{"name":"_union_of_array_of_union","type":["string","long","boolean",{"type":"array","items":["string","long","boolean","double","bytes","null"]},"null"]},{"name":"_union_of_array_of_array","type":["string","long","boolean",{"type":"array","items":{"type":"array","items":["string","long","boolean","double","null"]}},"null"]},{"name":"_union_of_records","type":["string","long","boolean",{"type":"record","name":"Record1","fields":[{"name":"field1","type":"string"}]},{"type":"record","name":"Record2","fields":[{"name":"field2","type":"long"}]},"null"]},{"name":"_union_of_enum","type":["string","long","boolean",{"type":"enum","name":"Enum1","symbols":["sym1","sym2"]},"null"]},{"name":"_union_of_fixed","type":["string","long","boolean",{"type":"fixed","name":"Fixed1","size":1},"null"]},{"name":"_union_of_string","type":["string","long","null"]},{"name":"_union_of_int","type":["int","string"]},{"name":"_union_of_long","type":["long","string"]},{"name":"_union_of_float","type":["float","string"]},{"name":"_union_of_double","type":["double","string"]},{"name":"_union_of_boolean","type":["boolean","string"]},{"name":"_union_of_bytes","type":["bytes","string"]},{"name":"_optional_record","type":["null",{"type":"record","name":"Record3","fields":[{"name":"field3","type":"string"}]}]},{"name":"_optional_enum","type":["null",{"type":"enum","name":"Enum2","symbols":["sym3","sym4"]}]},{"name":"_optional_fixed","type":["null",{"type":"fixed","name":"Fixed2","size":1}]},{"name":"_optional_string","type":["null","string"]},{"name":"_optional_int","type":["null","int"]},{"name":"_optional_long","type":["null","long"]},{"name":"_optional_float","type":["null","float"]},{"name":"_optional_double","type":["null","double"]},{"name":"_optional_boolean","type":["null","boolean"]},{"name":"_optional_bytes","type":["null","bytes"]},{"name":"_optional_map","type":["null",{"type":"map","values":"string"}]},{"name":"_optional_array","type":["null",{"type":"array","items":"string"}]},{"name":"_optional_map_of_array","type":["null",{"type":"map","values":{"type":"array","items":"string"}}]},{"name":"_optional_array_of_map","type":["null",{"type":"array","items":{"type":"map","values":"string"}}]},{"name":"_optional_map_of_map","type":["null",{"type":"map","values":{"type":"map","values":"string"}}]},{"name":"_optional_array_of_array","type":["null",{"type":"array","items":{"type":"array","items":"string"}}]},{"name":"_optional_map_of_union","type":["null",{"type":"map","values":["string","long","boolean","double","null"]}]},{"name":"_optional_array_of_union","type":["null",{"type":"array","items":["string","long","boolean","double","null"]}]}]}""")
  private val customSchema$71: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(6).schema().getTypes.get(3)
  private val customEnum$71: _root_.scala.Array[_root_.avro2s.test.unions.Enum1] = {
    val result$ = new _root_.scala.Array[_root_.avro2s.test.unions.Enum1](customSchema$71.getEnumSymbols.size())
    var i$ = 0
    while (i$ < result$.length) {
      result$(i$) = _root_.avro2s.test.unions.Enum1.valueOf(customSchema$71.getEnumSymbols.get(i$))
      i$ += 1
    }
    result$
  }
  private val customSchema$107: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(16).schema().getTypes.get(1)
  private val customEnum$107: _root_.scala.Array[_root_.avro2s.test.unions.Enum2] = {
    val result$ = new _root_.scala.Array[_root_.avro2s.test.unions.Enum2](customSchema$107.getEnumSymbols.size())
    var i$ = 0
    while (i$ < result$.length) {
      result$(i$) = _root_.avro2s.test.unions.Enum2.valueOf(customSchema$107.getEnumSymbols.get(i$))
      i$ += 1
    }
    result$
  }
}