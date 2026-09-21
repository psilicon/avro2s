/** GENERATED CODE */

package avro2s.test.maps

import org.apache.avro.AvroRuntimeException

import scala.annotation.switch
import shapeless.{:+:, CNil, Coproduct, Inl, Inr}

case class Maps(var _map_of_maps: Map[String, Map[String, String]], var _map_of_union: Map[String, String :+: Int :+: CNil], var _map_of_union_of_map_of_union: Map[String, String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil], var _map_of_arrays: Map[String, List[String]], var _map_of_arrays_of_maps: Map[String, List[Map[String, Boolean]]], var _map_of_map_of_union: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]], var _map_of_map_of_arrays: Map[String, Map[String, List[String]]], var _map_of_fixed: Map[String, avro2s.test.maps.Fixed], var _map_of_enum: Map[String, avro2s.test.maps.Enum], var _map_of_record: Map[String, avro2s.test.maps.Record], var _map_of_union_of_record: Map[String, avro2s.test.maps.Record :+: Int :+: scala.Null :+: CNil], var _map_of_bytes: Map[String, Array[Byte]], var _map_of_string: Map[String, String], var _map_of_int: Map[String, Int], var _map_of_long: Map[String, Long], var _map_of_float: Map[String, Float], var _map_of_double: Map[String, Double], var _map_of_boolean: Map[String, Boolean], var _map_of_null: Map[String, scala.Null], var _map_of_union_of_array: Map[String, List[String] :+: Int :+: scala.Null :+: CNil]) extends org.apache.avro.specific.SpecificRecordBase {
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
              case Inl(x) => x.asInstanceOf[AnyRef]
              case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
              case _ => throw new AvroRuntimeException("Invalid value")
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
              case Inl(x) => x.asInstanceOf[AnyRef]
              case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
              case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
              case Inr(Inr(Inr(Inl(x)))) =>
                val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = x.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
                x.foreach { kvp =>
                  val key = kvp._1
                  val value = {
                    val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = kvp._2.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
                    kvp._2.foreach { kvp =>
                      val key = kvp._1
                      val value = {
                        kvp._2 match {
                          case Inl(x) => x.asInstanceOf[AnyRef]
                          case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
                          case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
                          case Inr(Inr(Inr(Inl(x)))) => x.asInstanceOf[AnyRef]
                          case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
                          case _ => throw new AvroRuntimeException("Invalid value")
                        }
                      }
                      map.put(key, value)
                    }
                    map
                  }
                  map.put(key, value)
                }
                map
              case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
              case _ => throw new AvroRuntimeException("Invalid value")
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
                  case Inl(x) => x.asInstanceOf[AnyRef]
                  case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
                  case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
                  case Inr(Inr(Inr(Inl(x)))) => x.asInstanceOf[AnyRef]
                  case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
                  case _ => throw new AvroRuntimeException("Invalid value")
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
              case Inl(x) => x.asInstanceOf[AnyRef]
              case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
              case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
              case _ => throw new AvroRuntimeException("Invalid value")
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
              case Inl(x) =>
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
              case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
              case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
              case _ => throw new AvroRuntimeException("Invalid value")
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
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Map[String, String]] else {
              val builder$ = Map.newBuilder[String, Map[String, String]]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value match {
                    case map: java.util.Map[_,_] => {
                      if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String] else {
                        val builder$ = Map.newBuilder[String, String]
                        val iterator$ = map.entrySet.iterator
                        while (iterator$.hasNext) {
                          val entry$ = iterator$.next
                          val key = entry$.getKey.toString
                          val value = entry$.getValue
                          builder$ += ((key, {
                            value.toString
                          }))
                        }
                        builder$.result()
                      }
                    }
                  }
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 1 => this._map_of_union = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String :+: Int :+: CNil] else {
              val builder$ = Map.newBuilder[String, String :+: Int :+: CNil]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value match {
                    case x: java.lang.CharSequence => Coproduct[String :+: Int :+: CNil](x.toString)
                    case x: Int => Coproduct[String :+: Int :+: CNil](x)
                    case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                  }
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 2 => this._map_of_union_of_map_of_union = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil] else {
              val builder$ = Map.newBuilder[String, String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value match {
                    case x: java.lang.CharSequence => Coproduct[String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x.toString)
                    case x: Long => Coproduct[String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x)
                    case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x)
                    case map: java.util.Map[_,_] => Coproduct[String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil]{
                      if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] else {
                        val builder$ = Map.newBuilder[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]]
                        val iterator$ = map.entrySet.iterator
                        while (iterator$.hasNext) {
                          val entry$ = iterator$.next
                          val key = entry$.getKey.toString
                          val value = entry$.getValue
                          builder$ += ((key, {
                            value match {
                              case map: java.util.Map[_,_] => {
                                if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil] else {
                                  val builder$ = Map.newBuilder[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]
                                  val iterator$ = map.entrySet.iterator
                                  while (iterator$.hasNext) {
                                    val entry$ = iterator$.next
                                    val key = entry$.getKey.toString
                                    val value = entry$.getValue
                                    builder$ += ((key, {
                                      value match {
                                        case x: java.lang.CharSequence => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x.toString)
                                        case x: Long => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                                        case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                                        case x: Double => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                                        case x @ null => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                                        case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                                      }
                                    }))
                                  }
                                  builder$.result()
                                }
                              }
                            }
                          }))
                        }
                        builder$.result()
                      }
                    }
                    case x @ null => Coproduct[String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x)
                    case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                  }
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 3 => this._map_of_arrays = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, List[String]] else {
              val builder$ = Map.newBuilder[String, List[String]]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value match {
                    case array: java.util.List[_] =>
                      val builder$ = List.newBuilder[String]
                      val iterator$ = array.iterator
                      while (iterator$.hasNext) {
                        val value = iterator$.next
                        builder$ += {
                          value.toString
                        }
                      }
                      builder$.result()
                    }
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 4 => this._map_of_arrays_of_maps = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, List[Map[String, Boolean]]] else {
              val builder$ = Map.newBuilder[String, List[Map[String, Boolean]]]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value match {
                    case array: java.util.List[_] =>
                      val builder$ = List.newBuilder[Map[String, Boolean]]
                      val iterator$ = array.iterator
                      while (iterator$.hasNext) {
                        val value = iterator$.next
                        builder$ += {
                          value match {
                            case map: java.util.Map[_,_] => {
                              if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Boolean] else {
                                val builder$ = Map.newBuilder[String, Boolean]
                                val iterator$ = map.entrySet.iterator
                                while (iterator$.hasNext) {
                                  val entry$ = iterator$.next
                                  val key = entry$.getKey.toString
                                  val value = entry$.getValue
                                  builder$ += ((key, {
                                    value.asInstanceOf[Boolean]
                                  }))
                                }
                                builder$.result()
                              }
                            }
                          }
                        }
                      }
                      builder$.result()
                    }
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 5 => this._map_of_map_of_union = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] else {
              val builder$ = Map.newBuilder[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value match {
                    case map: java.util.Map[_,_] => {
                      if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil] else {
                        val builder$ = Map.newBuilder[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]
                        val iterator$ = map.entrySet.iterator
                        while (iterator$.hasNext) {
                          val entry$ = iterator$.next
                          val key = entry$.getKey.toString
                          val value = entry$.getValue
                          builder$ += ((key, {
                            value match {
                              case x: java.lang.CharSequence => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x.toString)
                              case x: Long => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                              case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                              case x: Double => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                              case x @ null => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                              case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                            }
                          }))
                        }
                        builder$.result()
                      }
                    }
                  }
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 6 => this._map_of_map_of_arrays = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Map[String, List[String]]] else {
              val builder$ = Map.newBuilder[String, Map[String, List[String]]]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value match {
                    case map: java.util.Map[_,_] => {
                      if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, List[String]] else {
                        val builder$ = Map.newBuilder[String, List[String]]
                        val iterator$ = map.entrySet.iterator
                        while (iterator$.hasNext) {
                          val entry$ = iterator$.next
                          val key = entry$.getKey.toString
                          val value = entry$.getValue
                          builder$ += ((key, {
                            value match {
                              case array: java.util.List[_] =>
                                val builder$ = List.newBuilder[String]
                                val iterator$ = array.iterator
                                while (iterator$.hasNext) {
                                  val value = iterator$.next
                                  builder$ += {
                                    value.toString
                                  }
                                }
                                builder$.result()
                              }
                          }))
                        }
                        builder$.result()
                      }
                    }
                  }
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 7 => this._map_of_fixed = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, avro2s.test.maps.Fixed] else {
              val builder$ = Map.newBuilder[String, avro2s.test.maps.Fixed]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value.asInstanceOf[avro2s.test.maps.Fixed]
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 8 => this._map_of_enum = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, avro2s.test.maps.Enum] else {
              val builder$ = Map.newBuilder[String, avro2s.test.maps.Enum]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value.asInstanceOf[avro2s.test.maps.Enum]
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 9 => this._map_of_record = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, avro2s.test.maps.Record] else {
              val builder$ = Map.newBuilder[String, avro2s.test.maps.Record]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value.asInstanceOf[avro2s.test.maps.Record]
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 10 => this._map_of_union_of_record = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, avro2s.test.maps.Record :+: Int :+: scala.Null :+: CNil] else {
              val builder$ = Map.newBuilder[String, avro2s.test.maps.Record :+: Int :+: scala.Null :+: CNil]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value match {
                    case x: avro2s.test.maps.Record => Coproduct[avro2s.test.maps.Record :+: Int :+: scala.Null :+: CNil](x)
                    case x: Int => Coproduct[avro2s.test.maps.Record :+: Int :+: scala.Null :+: CNil](x)
                    case x @ null => Coproduct[avro2s.test.maps.Record :+: Int :+: scala.Null :+: CNil](x)
                    case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                  }
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 11 => this._map_of_bytes = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Array[Byte]] else {
              val builder$ = Map.newBuilder[String, Array[Byte]]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value match {
                    case buffer: java.nio.ByteBuffer => val start$ = buffer.position(); val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); (buffer: java.nio.Buffer).position(start$); array
                  }
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 12 => this._map_of_string = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String] else {
              val builder$ = Map.newBuilder[String, String]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value.toString
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 13 => this._map_of_int = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Int] else {
              val builder$ = Map.newBuilder[String, Int]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value.asInstanceOf[Int]
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 14 => this._map_of_long = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Long] else {
              val builder$ = Map.newBuilder[String, Long]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value.asInstanceOf[Long]
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 15 => this._map_of_float = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Float] else {
              val builder$ = Map.newBuilder[String, Float]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value.asInstanceOf[Float]
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 16 => this._map_of_double = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Double] else {
              val builder$ = Map.newBuilder[String, Double]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value.asInstanceOf[Double]
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 17 => this._map_of_boolean = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Boolean] else {
              val builder$ = Map.newBuilder[String, Boolean]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value.asInstanceOf[Boolean]
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 18 => this._map_of_null = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, scala.Null] else {
              val builder$ = Map.newBuilder[String, scala.Null]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value.asInstanceOf[scala.Null]
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 19 => this._map_of_union_of_array = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, List[String] :+: Int :+: scala.Null :+: CNil] else {
              val builder$ = Map.newBuilder[String, List[String] :+: Int :+: scala.Null :+: CNil]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  value match {
                    case x: java.util.List[_] => Coproduct[List[String] :+: Int :+: scala.Null :+: CNil]({
                      x match {
                        case array: java.util.List[_] =>
                          val builder$ = List.newBuilder[String]
                          val iterator$ = array.iterator
                          while (iterator$.hasNext) {
                            val value = iterator$.next
                            builder$ += {
                              value.toString
                            }
                          }
                          builder$.result()
                        }
                    })
                    case x: Int => Coproduct[List[String] :+: Int :+: scala.Null :+: CNil](x)
                    case x @ null => Coproduct[List[String] :+: Int :+: scala.Null :+: CNil](x)
                    case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                  }
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object Maps {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Maps","namespace":"avro2s.test.maps","fields":[{"name":"_map_of_maps","type":{"type":"map","values":{"type":"map","values":"string","default":{}},"default":{}}},{"name":"_map_of_union","type":{"type":"map","values":["string","int"],"default":{}}},{"name":"_map_of_union_of_map_of_union","type":{"type":"map","values":["string","long","boolean",{"type":"map","values":{"type":"map","values":["string","long","boolean","double","null"]}},"null"]}},{"name":"_map_of_arrays","type":{"type":"map","values":{"type":"array","items":"string"}}},{"name":"_map_of_arrays_of_maps","type":{"type":"map","values":{"type":"array","items":{"type":"map","values":"boolean"}}}},{"name":"_map_of_map_of_union","type":{"type":"map","values":{"type":"map","values":["string","long","boolean","double","null"]}}},{"name":"_map_of_map_of_arrays","type":{"type":"map","values":{"type":"map","values":{"type":"array","items":"string"}}}},{"name":"_map_of_fixed","type":{"type":"map","values":{"type":"fixed","name":"Fixed","size":2}}},{"name":"_map_of_enum","type":{"type":"map","values":{"type":"enum","name":"Enum","symbols":["A","B","C"]}}},{"name":"_map_of_record","type":{"type":"map","values":{"type":"record","name":"Record","fields":[{"name":"a","type":"string"}]}}},{"name":"_map_of_union_of_record","type":{"type":"map","values":["Record","int","null"],"default":{}}},{"name":"_map_of_bytes","type":{"type":"map","values":"bytes"}},{"name":"_map_of_string","type":{"type":"map","values":"string"}},{"name":"_map_of_int","type":{"type":"map","values":"int"}},{"name":"_map_of_long","type":{"type":"map","values":"long"}},{"name":"_map_of_float","type":{"type":"map","values":"float"}},{"name":"_map_of_double","type":{"type":"map","values":"double"}},{"name":"_map_of_boolean","type":{"type":"map","values":"boolean"}},{"name":"_map_of_null","type":{"type":"map","values":"null"}},{"name":"_map_of_union_of_array","type":{"type":"map","values":[{"type":"array","items":"string"},"int","null"]}}]}""")
}