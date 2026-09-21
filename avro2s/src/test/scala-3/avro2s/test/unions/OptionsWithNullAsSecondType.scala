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
        case None => null.asInstanceOf[AnyRef]
      }
      case 2 => _array_of_options match {
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
      case 3 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_options.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
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
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._simple = {
        value match {
          case x: java.lang.CharSequence => Option(x.toString)
          case null => None
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 1 => this._optional_array = {
        value match {
          case array: java.util.List[?] =>
            Option({
              val builder$ = List.newBuilder[Boolean]
              val iterator$ = array.iterator
              while (iterator$.hasNext) {
                val value = iterator$.next
                builder$ += {
                  value.asInstanceOf[Boolean]
                }
              }
              builder$.result()
            })
          case null => None
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 2 => this._array_of_options = {
        val array = value.asInstanceOf[java.util.List[?]]
        {
          val builder$ = List.newBuilder[Option[String]]
          val iterator$ = array.iterator
          while (iterator$.hasNext) {
            val value = iterator$.next
            builder$ += {
              value match {
                case x: java.lang.CharSequence => Option(x.toString)
                case null => None
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            }
          }
          builder$.result()
        }
      }
      case 3 => this._map_of_options = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[String]] else {
          val builder$ = Map.newBuilder[String, Option[String]]
          val iterator$ = map.entrySet.iterator
          while (iterator$.hasNext) {
            val entry$ = iterator$.next
            val key = entry$.getKey.toString
            val value = entry$.getValue
            builder$ += ((key, {
              value match {
                case x: java.lang.CharSequence => Option(x.toString)
                case null => None
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            }))
          }
          builder$.result()
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object OptionsWithNullAsSecondType {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"OptionsWithNullAsSecondType","namespace":"avro2s.test.unions","fields":[{"name":"_simple","type":["string","null"]},{"name":"_optional_array","type":[{"type":"array","items":"boolean"},"null"]},{"name":"_array_of_options","type":{"type":"array","items":["string","null"]}},{"name":"_map_of_options","type":{"type":"map","values":["string","null"]}}]}""")
}