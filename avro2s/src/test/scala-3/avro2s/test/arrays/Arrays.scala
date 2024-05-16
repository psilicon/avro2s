/** GENERATED CODE */

package avro2s.test.arrays

import scala.annotation.switch

case class Arrays(var _array_of_arrays: List[List[String]], var _array_of_maps: List[Map[String, String]], var _array_of_unions: List[String | Int], var _array_of_records: List[avro2s.test.arrays.Record], var _array_of_union_of_records: List[avro2s.test.arrays.Record1 | avro2s.test.arrays.Record2 | Int], var _array_of_enums: List[avro2s.test.arrays.Enum], var _array_of_fixed: List[avro2s.test.arrays.Fixed], var _array_of_bytes: List[Array[Byte]], var _array_of_strings: List[String], var _array_of_ints: List[Int], var _array_of_longs: List[Long], var _array_of_floats: List[Float], var _array_of_doubles: List[Double], var _array_of_booleans: List[Boolean]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty)

  override def getSchema: org.apache.avro.Schema = Arrays.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _array_of_arrays match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { array =>
              scala.jdk.CollectionConverters.BufferHasAsJava({
                array.map { x =>
                  x.asInstanceOf[AnyRef]
                }
              }.toBuffer).asJava
            }
          }.toBuffer).asJava
        }
      case 1 => _array_of_maps match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { m =>
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
      case 2 => _array_of_unions match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map {
              case x: String => x.asInstanceOf[AnyRef]
              case x: Int => x.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 3 => _array_of_records match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { x =>
              x.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 4 => _array_of_union_of_records match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map {
              case x: avro2s.test.arrays.Record1 => x.asInstanceOf[AnyRef]
              case x: avro2s.test.arrays.Record2 => x.asInstanceOf[AnyRef]
              case x: Int => x.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 5 => _array_of_enums match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { x =>
              x.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 6 => _array_of_fixed match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { x =>
              x.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 7 => _array_of_bytes match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { bytes =>
              java.nio.ByteBuffer.wrap(bytes)
            }
          }.toBuffer).asJava
        }
      case 8 => _array_of_strings match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { x =>
              x.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 9 => _array_of_ints match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { x =>
              x.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 10 => _array_of_longs match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { x =>
              x.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 11 => _array_of_floats match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { x =>
              x.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 12 => _array_of_doubles match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { x =>
              x.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 13 => _array_of_booleans match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { x =>
              x.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._array_of_arrays = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          val array = value.asInstanceOf[java.util.List[?]]
          scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
            value.toString
          }).toList
        }).toList
      }
      case 1 => this._array_of_maps = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          val map = value.asInstanceOf[java.util.Map[?,?]]
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value.toString
            })
          }
        }).toList
      }
      case 2 => this._array_of_unions = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case x: org.apache.avro.util.Utf8 => x.toString
            case x: Int => x
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case 3 => this._array_of_records = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[avro2s.test.arrays.Record]
        }).toList
      }
      case 4 => this._array_of_union_of_records = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case x: avro2s.test.arrays.Record1 => x
            case x: avro2s.test.arrays.Record2 => x
            case x: Int => x
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case 5 => this._array_of_enums = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[avro2s.test.arrays.Enum]
        }).toList
      }
      case 6 => this._array_of_fixed = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[avro2s.test.arrays.Fixed]
        }).toList
      }
      case 7 => this._array_of_bytes = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          val buffer = value.asInstanceOf[java.nio.ByteBuffer]
          val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); array
        }).toList
      }
      case 8 => this._array_of_strings = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.toString
        }).toList
      }
      case 9 => this._array_of_ints = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[Int]
        }).toList
      }
      case 10 => this._array_of_longs = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[Long]
        }).toList
      }
      case 11 => this._array_of_floats = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[Float]
        }).toList
      }
      case 12 => this._array_of_doubles = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[Double]
        }).toList
      }
      case 13 => this._array_of_booleans = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[Boolean]
        }).toList
      }
    }
  }
}

object Arrays {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Arrays","namespace":"avro2s.test.arrays","fields":[{"name":"_array_of_arrays","type":{"type":"array","items":{"type":"array","items":"string","default":[]},"default":[]}},{"name":"_array_of_maps","type":{"type":"array","items":{"type":"map","values":"string","default":{}},"default":[]}},{"name":"_array_of_unions","type":{"type":"array","items":["string","int"],"default":[]}},{"name":"_array_of_records","type":{"type":"array","items":{"type":"record","name":"Record","fields":[{"name":"_string","type":"string"},{"name":"_int","type":"int"}]},"default":[]}},{"name":"_array_of_union_of_records","type":{"type":"array","items":[{"type":"record","name":"Record1","fields":[{"name":"_string","type":"string"},{"name":"_int","type":"int"}]},{"type":"record","name":"Record2","fields":[{"name":"_string","type":"string"},{"name":"_int","type":"int"}]},"int"],"default":[]}},{"name":"_array_of_enums","type":{"type":"array","items":{"type":"enum","name":"Enum","symbols":["A","B","C"]},"default":[]}},{"name":"_array_of_fixed","type":{"type":"array","items":{"type":"fixed","name":"Fixed","size":2},"default":[]}},{"name":"_array_of_bytes","type":{"type":"array","items":"bytes","default":[]}},{"name":"_array_of_strings","type":{"type":"array","items":"string","default":[]}},{"name":"_array_of_ints","type":{"type":"array","items":"int","default":[]}},{"name":"_array_of_longs","type":{"type":"array","items":"long","default":[]}},{"name":"_array_of_floats","type":{"type":"array","items":"float","default":[]}},{"name":"_array_of_doubles","type":{"type":"array","items":"double","default":[]}},{"name":"_array_of_booleans","type":{"type":"array","items":"boolean","default":[]}}]}""")
}