/** GENERATED CODE */

package avro2s.test.spec

import org.apache.avro.AvroRuntimeException

import scala.annotation.switch

case class AvroSpec(var _null: scala.Null, var _boolean: Boolean, var _int: Int, var _long: Long, var _float: Float, var _double: Double, var _bytes: Array[Byte], var _string: String, var _enum: avro2s.test.spec.Suit, var _array: List[String], var _map: Map[String, Long], var _union_nullable: Option[String], var _union_other: String | Int, var _fixed: avro2s.test.spec.md5) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(null, false, 0, 0, 0, 0, null, null, null, null, null, null, null, null)

  override def getSchema: org.apache.avro.Schema = AvroSpec.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _null.asInstanceOf[AnyRef]
      case 1 => _boolean.asInstanceOf[AnyRef]
      case 2 => _int.asInstanceOf[AnyRef]
      case 3 => _long.asInstanceOf[AnyRef]
      case 4 => _float.asInstanceOf[AnyRef]
      case 5 => _double.asInstanceOf[AnyRef]
      case 6 => java.nio.ByteBuffer.wrap(_bytes).asInstanceOf[AnyRef]
      case 7 => _string.asInstanceOf[AnyRef]
      case 8 => _enum.asInstanceOf[AnyRef]
      case 9 => _array match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { x =>
              x.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 10 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 11 => _union_nullable match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 12 => _union_other match {
        case x: String => x.asInstanceOf[AnyRef]
        case x: Int => x.asInstanceOf[AnyRef]
      }
      case 13 => _fixed.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._null = value.asInstanceOf[scala.Null]
      case 1 => this._boolean = value.asInstanceOf[Boolean]
      case 2 => this._int = value.asInstanceOf[Int]
      case 3 => this._long = value.asInstanceOf[Long]
      case 4 => this._float = value.asInstanceOf[Float]
      case 5 => this._double = value.asInstanceOf[Double]
      case 6 => this._bytes = value match {
        case buffer: java.nio.ByteBuffer =>
          val array = Array.ofDim[Byte](buffer.remaining())
          buffer.get(array)
          array
        }
      case 7 => this._string = value.toString.asInstanceOf[String]
      case 8 => this._enum = value.asInstanceOf[avro2s.test.spec.Suit]
      case 9 => this._array = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value.toString
            }).toList
          }
      }
      case 10 => this._map = {
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
      case 11 => value match {
        case null => this._union_nullable = None
        case x => this._union_nullable = Some(x.toString.asInstanceOf[String])
      }
      case 12 => value match {
        case x: org.apache.avro.util.Utf8 => this._union_other = x.toString
        case x: Int => this._union_other = x
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 13 => this._fixed = value.asInstanceOf[avro2s.test.spec.md5]
    }
  }
}

object AvroSpec {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"AvroSpec","namespace":"avro2s.test.spec","fields":[{"name":"_null","type":"null"},{"name":"_boolean","type":"boolean"},{"name":"_int","type":"int"},{"name":"_long","type":"long"},{"name":"_float","type":"float"},{"name":"_double","type":"double"},{"name":"_bytes","type":"bytes"},{"name":"_string","type":"string"},{"name":"_enum","type":{"type":"enum","name":"Suit","symbols":["SPADES","HEARTS","DIAMONDS","CLUBS"]}},{"name":"_array","type":{"type":"array","items":"string","default":[]}},{"name":"_map","type":{"type":"map","values":"long","default":{}}},{"name":"_union_nullable","type":["null","string"],"default":null},{"name":"_union_other","type":["string","int"]},{"name":"_fixed","type":{"type":"fixed","name":"md5","size":16}}]}""")
}