/** GENERATED CODE */

package avro2s.test.arrays

import org.apache.avro.AvroRuntimeException

import scala.annotation.switch
import shapeless.{:+:, CNil, Coproduct, Inl, Inr}

case class Arrays(var _array_of_arrays: List[List[String]], var _array_of_maps: List[Map[String, String]], var _array_of_unions: List[String :+: Int :+: CNil], var _array_of_records: List[avro2s.test.arrays.Record], var _array_of_union_of_records: List[avro2s.test.arrays.Record1 :+: avro2s.test.arrays.Record2 :+: Int :+: CNil], var _array_of_enums: List[avro2s.test.arrays.Enum], var _array_of_fixed: List[avro2s.test.arrays.Fixed], var _array_of_bytes: List[Array[Byte]], var _array_of_strings: List[String], var _array_of_ints: List[Int], var _array_of_longs: List[Long], var _array_of_floats: List[Float], var _array_of_doubles: List[Double], var _array_of_booleans: List[Boolean], var _array_of_union_of_only_records: List[avro2s.test.arrays.RecordA :+: avro2s.test.arrays.RecordB :+: CNil], var _array_of_union_of_only_enums: List[avro2s.test.arrays.EnumA :+: avro2s.test.arrays.EnumB :+: CNil], var _array_of_union_of_only_fixed: List[avro2s.test.arrays.FixedA :+: avro2s.test.arrays.FixedB :+: CNil]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty)

  override def getSchema: org.apache.avro.Schema = Arrays.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _array_of_arrays match {
        case array =>
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
            toJavaArray$(array)
          }
        }
      case 1 => _array_of_maps match {
        case array =>
          {
            def toJavaArray$(input$: List[Map[String, String]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any](_root_.scala.math.max(16, _root_.scala.math.ceil(element$.size / 0.75d).toInt))
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
      case 2 => _array_of_unions match {
        case array =>
          {
            def toJavaArray$(input$: List[String :+: Int :+: CNil]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case Inl(x) => x.asInstanceOf[AnyRef]
                    case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
                    case _ => throw new AvroRuntimeException("Invalid value")
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 3 => _array_of_records match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[avro2s.test.arrays.Record](0) else new java.util.ArrayList[avro2s.test.arrays.Record](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 4 => _array_of_union_of_records match {
        case array =>
          {
            def toJavaArray$(input$: List[avro2s.test.arrays.Record1 :+: avro2s.test.arrays.Record2 :+: Int :+: CNil]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case Inl(x) => x.asInstanceOf[AnyRef]
                    case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
                    case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
                    case _ => throw new AvroRuntimeException("Invalid value")
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 5 => _array_of_enums match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[avro2s.test.arrays.Enum](0) else new java.util.ArrayList[avro2s.test.arrays.Enum](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 6 => _array_of_fixed match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[avro2s.test.arrays.Fixed](0) else new java.util.ArrayList[avro2s.test.arrays.Fixed](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 7 => _array_of_bytes match {
        case array =>
          {
            def toJavaArray$(input$: List[Array[Byte]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  java.nio.ByteBuffer.wrap(element$)
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 8 => _array_of_strings match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[String](0) else new java.util.ArrayList[String](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 9 => _array_of_ints match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[Int](0) else new java.util.ArrayList[Int](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 10 => _array_of_longs match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[Long](0) else new java.util.ArrayList[Long](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 11 => _array_of_floats match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[Float](0) else new java.util.ArrayList[Float](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 12 => _array_of_doubles match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[Double](0) else new java.util.ArrayList[Double](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 13 => _array_of_booleans match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[Boolean](0) else new java.util.ArrayList[Boolean](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 14 => _array_of_union_of_only_records match {
        case array =>
          {
            def toJavaArray$(input$: List[avro2s.test.arrays.RecordA :+: avro2s.test.arrays.RecordB :+: CNil]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case Inl(x) => x.asInstanceOf[AnyRef]
                    case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
                    case _ => throw new AvroRuntimeException("Invalid value")
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 15 => _array_of_union_of_only_enums match {
        case array =>
          {
            def toJavaArray$(input$: List[avro2s.test.arrays.EnumA :+: avro2s.test.arrays.EnumB :+: CNil]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case Inl(x) => x.asInstanceOf[AnyRef]
                    case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
                    case _ => throw new AvroRuntimeException("Invalid value")
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 16 => _array_of_union_of_only_fixed match {
        case array =>
          {
            def toJavaArray$(input$: List[avro2s.test.arrays.FixedA :+: avro2s.test.arrays.FixedB :+: CNil]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case Inl(x) => x.asInstanceOf[AnyRef]
                    case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
                    case _ => throw new AvroRuntimeException("Invalid value")
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
      case 0 => this._array_of_arrays = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case array: java.util.List[_] =>
                  scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                    value.toString
                  }).toList
                }
            }).toList
          }
      }
      case 1 => this._array_of_maps = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case map: java.util.Map[_,_] => {
                  scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                    val key = kvp._1.toString
                    val value = kvp._2
                    (key, {
                      value.toString
                    })
                  }.toMap
                }
              }
            }).toList
          }
      }
      case 2 => this._array_of_unions = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Int :+: CNil](x.toString)
                case x: Int => Coproduct[String :+: Int :+: CNil](x)
                case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            }).toList
          }
      }
      case 3 => this._array_of_records = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value.asInstanceOf[avro2s.test.arrays.Record]
            }).toList
          }
      }
      case 4 => this._array_of_union_of_records = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case x: avro2s.test.arrays.Record1 => Coproduct[avro2s.test.arrays.Record1 :+: avro2s.test.arrays.Record2 :+: Int :+: CNil](x)
                case x: avro2s.test.arrays.Record2 => Coproduct[avro2s.test.arrays.Record1 :+: avro2s.test.arrays.Record2 :+: Int :+: CNil](x)
                case x: Int => Coproduct[avro2s.test.arrays.Record1 :+: avro2s.test.arrays.Record2 :+: Int :+: CNil](x)
                case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            }).toList
          }
      }
      case 5 => this._array_of_enums = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value.asInstanceOf[avro2s.test.arrays.Enum]
            }).toList
          }
      }
      case 6 => this._array_of_fixed = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value.asInstanceOf[avro2s.test.arrays.Fixed]
            }).toList
          }
      }
      case 7 => this._array_of_bytes = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case buffer: java.nio.ByteBuffer => val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); array
              }
            }).toList
          }
      }
      case 8 => this._array_of_strings = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value.toString
            }).toList
          }
      }
      case 9 => this._array_of_ints = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value.asInstanceOf[Int]
            }).toList
          }
      }
      case 10 => this._array_of_longs = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value.asInstanceOf[Long]
            }).toList
          }
      }
      case 11 => this._array_of_floats = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value.asInstanceOf[Float]
            }).toList
          }
      }
      case 12 => this._array_of_doubles = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value.asInstanceOf[Double]
            }).toList
          }
      }
      case 13 => this._array_of_booleans = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value.asInstanceOf[Boolean]
            }).toList
          }
      }
      case 14 => this._array_of_union_of_only_records = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case x: avro2s.test.arrays.RecordA => Coproduct[avro2s.test.arrays.RecordA :+: avro2s.test.arrays.RecordB :+: CNil](x)
                case x: avro2s.test.arrays.RecordB => Coproduct[avro2s.test.arrays.RecordA :+: avro2s.test.arrays.RecordB :+: CNil](x)
                case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            }).toList
          }
      }
      case 15 => this._array_of_union_of_only_enums = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case x: avro2s.test.arrays.EnumA => Coproduct[avro2s.test.arrays.EnumA :+: avro2s.test.arrays.EnumB :+: CNil](x)
                case x: avro2s.test.arrays.EnumB => Coproduct[avro2s.test.arrays.EnumA :+: avro2s.test.arrays.EnumB :+: CNil](x)
                case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            }).toList
          }
      }
      case 16 => this._array_of_union_of_only_fixed = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case x: avro2s.test.arrays.FixedA => Coproduct[avro2s.test.arrays.FixedA :+: avro2s.test.arrays.FixedB :+: CNil](x)
                case x: avro2s.test.arrays.FixedB => Coproduct[avro2s.test.arrays.FixedA :+: avro2s.test.arrays.FixedB :+: CNil](x)
                case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            }).toList
          }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object Arrays {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Arrays","namespace":"avro2s.test.arrays","fields":[{"name":"_array_of_arrays","type":{"type":"array","items":{"type":"array","items":"string","default":[]},"default":[]}},{"name":"_array_of_maps","type":{"type":"array","items":{"type":"map","values":"string","default":{}},"default":[]}},{"name":"_array_of_unions","type":{"type":"array","items":["string","int"],"default":[]}},{"name":"_array_of_records","type":{"type":"array","items":{"type":"record","name":"Record","fields":[{"name":"_string","type":"string"},{"name":"_int","type":"int"}]},"default":[]}},{"name":"_array_of_union_of_records","type":{"type":"array","items":[{"type":"record","name":"Record1","fields":[{"name":"_string","type":"string"},{"name":"_int","type":"int"}]},{"type":"record","name":"Record2","fields":[{"name":"_string","type":"string"},{"name":"_int","type":"int"}]},"int"],"default":[]}},{"name":"_array_of_enums","type":{"type":"array","items":{"type":"enum","name":"Enum","symbols":["A","B","C"]},"default":[]}},{"name":"_array_of_fixed","type":{"type":"array","items":{"type":"fixed","name":"Fixed","size":2},"default":[]}},{"name":"_array_of_bytes","type":{"type":"array","items":"bytes","default":[]}},{"name":"_array_of_strings","type":{"type":"array","items":"string","default":[]}},{"name":"_array_of_ints","type":{"type":"array","items":"int","default":[]}},{"name":"_array_of_longs","type":{"type":"array","items":"long","default":[]}},{"name":"_array_of_floats","type":{"type":"array","items":"float","default":[]}},{"name":"_array_of_doubles","type":{"type":"array","items":"double","default":[]}},{"name":"_array_of_booleans","type":{"type":"array","items":"boolean","default":[]}},{"name":"_array_of_union_of_only_records","type":{"type":"array","items":[{"type":"record","name":"RecordA","fields":[{"name":"_string","type":"string"}]},{"type":"record","name":"RecordB","fields":[{"name":"_string","type":"string"}]}],"default":[]}},{"name":"_array_of_union_of_only_enums","type":{"type":"array","items":[{"type":"enum","name":"EnumA","symbols":["A","B","C"]},{"type":"enum","name":"EnumB","symbols":["A","B","C"]}],"default":[]}},{"name":"_array_of_union_of_only_fixed","type":{"type":"array","items":[{"type":"fixed","name":"FixedA","size":2},{"type":"fixed","name":"FixedB","size":2}],"default":[]}}]}""")
}