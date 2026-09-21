/** GENERATED CODE */

package avro2s.test.logical

import scala.annotation.switch

case class ComplexLogicalTypesDisabled(var _map: Map[String, String], var _array: List[Int], var _union: Int | Long, var _option: Option[String], var _map_union: Map[String, Int | Long], var _map_array: Map[String, List[Int]], var _union_map: Int | Map[String, String], var _union_array: Int | List[Int], var _array_map: List[Map[String, String]], var _array_union: List[Int | Long], var _array_option: List[Option[String]]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(Map.empty, List.empty, 0, None, Map.empty, Map.empty, 0, 0, List.empty, List.empty, List.empty)

  override def getSchema: org.apache.avro.Schema = ComplexLogicalTypesDisabled.SCHEMA$

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
      case 1 => _array match {
        case array =>
          {
            def toJavaArray$(input$: List[AnyRef]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = if (input$.isEmpty) new java.util.ArrayList[AnyRef]() else new java.util.ArrayList[AnyRef](input$.size)
              while (remaining$.nonEmpty) {
                result$.add(remaining$.head)
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array.asInstanceOf[List[AnyRef]])
          }
        }
      case 2 => _union match {
        case x: Int => x.asInstanceOf[AnyRef]
        case x: Long => x.asInstanceOf[AnyRef]
      }
      case 3 => _option match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 4 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_union.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_union.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case x: Int => x.asInstanceOf[AnyRef]
              case x: Long => x.asInstanceOf[AnyRef]
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 5 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_array.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_array.foreach { kvp =>
          val key = kvp._1
          val value = {
            {
              def toJavaArray$(input$: List[AnyRef]): java.util.ArrayList[AnyRef] = {
                var remaining$ = input$
                val result$ = if (input$.isEmpty) new java.util.ArrayList[AnyRef]() else new java.util.ArrayList[AnyRef](input$.size)
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
      case 6 => _union_map match {
        case x: Int => x.asInstanceOf[AnyRef]
        case x: Map[String, String] =>
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
      case 7 => _union_array match {
        case x: Int => x.asInstanceOf[AnyRef]
        case x: List[Int] =>
          {
            def toJavaArray$(input$: List[AnyRef]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = if (input$.isEmpty) new java.util.ArrayList[AnyRef]() else new java.util.ArrayList[AnyRef](input$.size)
              while (remaining$.nonEmpty) {
                result$.add(remaining$.head)
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(x.asInstanceOf[List[AnyRef]])
          }
      }
      case 8 => _array_map match {
        case array =>
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
            toJavaArray$(array)
          }
        }
      case 9 => _array_union match {
        case array =>
          {
            def toJavaArray$(input$: List[Int | Long]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case x: Int => x.asInstanceOf[AnyRef]
                    case x: Long => x.asInstanceOf[AnyRef]
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 10 => _array_option match {
        case array =>
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
      case 1 => this._array = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[Int]
        }).toList
      }
      case 2 => this._union = {
        value match {
          case x: Int => x
          case x: Long => x
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 3 => this._option = {
        value match {
          case null => None
          case x: java.lang.CharSequence => Option(x.toString)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 4 => this._map_union = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Int | Long] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case x: Int => x
                case x: Long => x
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            })
          }.toMap
        }
      }
      case 5 => this._map_array = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, List[Int]] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              val array = value.asInstanceOf[java.util.List[?]]
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value.asInstanceOf[Int]
              }).toList
            })
          }.toMap
        }
      }
      case 6 => this._union_map = {
        value match {
          case x: Int => x
          case map: java.util.Map[?,?] =>
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String] else {
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value.toString
                })
              }.toMap
            }
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 7 => this._union_array = {
        value match {
          case x: Int => x
          case array: java.util.List[?] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value.asInstanceOf[Int]
            }).toList
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 8 => this._array_map = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
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
        }).toList
      }
      case 9 => this._array_union = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case x: Int => x
            case x: Long => x
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case 10 => this._array_option = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case null => None
            case x: java.lang.CharSequence => Option(x.toString)
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object ComplexLogicalTypesDisabled {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"ComplexLogicalTypesDisabled","namespace":"avro2s.test.logical","fields":[{"name":"_map","type":{"type":"map","values":{"type":"string","logicalType":"uuid"}}},{"name":"_array","type":{"type":"array","items":{"type":"int","logicalType":"date"}}},{"name":"_union","type":["int",{"type":"long","logicalType":"timestamp-millis"}]},{"name":"_option","type":["null",{"type":"string","logicalType":"uuid"}]},{"name":"_map_union","type":{"type":"map","values":["int",{"type":"long","logicalType":"timestamp-millis"}]}},{"name":"_map_array","type":{"type":"map","values":{"type":"array","items":{"type":"int","logicalType":"date"}}}},{"name":"_union_map","type":["int",{"type":"map","values":{"type":"string","logicalType":"uuid"}}]},{"name":"_union_array","type":["int",{"type":"array","items":{"type":"int","logicalType":"date"}}]},{"name":"_array_map","type":{"type":"array","items":{"type":"map","values":{"type":"string","logicalType":"uuid"}}}},{"name":"_array_union","type":{"type":"array","items":["int",{"type":"long","logicalType":"timestamp-millis"}]}},{"name":"_array_option","type":{"type":"array","items":["null",{"type":"string","logicalType":"uuid"}]}}]}""")
}