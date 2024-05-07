/** GENERATED CODE */

package avro2s.test.unions

import scala.annotation.switch

case class OptionsWithNullAsSecondType(var _simple: Option[String], var _optional_array: Option[List[Boolean]], var _array_of_options: List[Option[String]], var _map_of_options: Map[String, Option[String]]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(None, None, List.empty, Map.empty)

  override def getSchema: org.apache.avro.Schema = OptionsWithNullAsSecondType.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _simple match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 1 => _optional_array match {
        case None => null
        case Some(x) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map { x =>x.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
      }
      case 2 => _array_of_options match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map {
              case None => null
              case Some(x) => x.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 3 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_options.foreach { kvp =>
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
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => value match {
        case null => this._simple = None
        case x: org.apache.avro.util.Utf8 => this._simple = Some(x.toString.asInstanceOf[String])
      }
      case 1 => value match {
        case null => this._optional_array = None
        case x: java.util.List[_] => this._optional_array = Some({
          x match {
            case array: java.util.List[_] =>
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value.asInstanceOf[Boolean]
              }).toList
            }
        }.toList)
      }
      case 2 => this._array_of_options = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case null => None
                case x: org.apache.avro.util.Utf8 => Some(x.toString.asInstanceOf[String])
              }
            }).toList
          }
      }
      case 3 => this._map_of_options = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case null => None
                  case x: org.apache.avro.util.Utf8 => Some(x.toString.asInstanceOf[String])
                }
              })
            }
          }
        }
      }
    }
  }
}

object OptionsWithNullAsSecondType {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"OptionsWithNullAsSecondType","namespace":"avro2s.test.unions","fields":[{"name":"_simple","type":["string","null"]},{"name":"_optional_array","type":[{"type":"array","items":"boolean"},"null"]},{"name":"_array_of_options","type":{"type":"array","items":["string","null"]}},{"name":"_map_of_options","type":{"type":"map","values":["string","null"]}}]}""")
}