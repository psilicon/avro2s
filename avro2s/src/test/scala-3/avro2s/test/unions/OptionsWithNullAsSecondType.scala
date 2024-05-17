/** GENERATED CODE */

package avro2s.test.unions

import scala.annotation.switch

case class OptionsWithNullAsSecondType(var _simple: Option[String], var _optional_array: Option[List[Boolean]], var _array_of_options: List[Option[String]], var _map_of_options: Map[String, Option[String]]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(None, None, List.empty, Map.empty)

  override def getSchema: org.apache.avro.Schema = OptionsWithNullAsSecondType.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _simple match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 1 => _optional_array match {
        case Some(x: List[Boolean]) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map { x =>x.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 2 => _array_of_options match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map {
              case Some(x: String) => x.asInstanceOf[AnyRef]
              case None => null.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 3 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_options.foreach { kvp =>
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
      }.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._simple = {
        value match {
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case null => None
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 1 => this._optional_array = {
        value match {
          case array: java.util.List[?] =>
            Option(scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value.asInstanceOf[Boolean]
            }).toList)
          case null => None
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 2 => this._array_of_options = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case x: org.apache.avro.util.Utf8 => Option(x.toString)
            case null => None
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case 3 => this._map_of_options = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
          val key = kvp._1.toString
          val value = kvp._2
          (key, {
            value match {
              case x: org.apache.avro.util.Utf8 => Option(x.toString)
              case null => None
              case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
            }
          })
        }
      }
    }
  }
}

object OptionsWithNullAsSecondType {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"OptionsWithNullAsSecondType","namespace":"avro2s.test.unions","fields":[{"name":"_simple","type":["string","null"]},{"name":"_optional_array","type":[{"type":"array","items":"boolean"},"null"]},{"name":"_array_of_options","type":{"type":"array","items":["string","null"]}},{"name":"_map_of_options","type":{"type":"map","values":["string","null"]}}]}""")
}