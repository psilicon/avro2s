/** GENERATED CODE */

package avro2s.test.javastring

import org.apache.avro.AvroRuntimeException

import scala.annotation.switch
import shapeless.{:+:, CNil, Coproduct, Inl, Inr}

/**
 * Strings carrying avro.java.string: String, which makes the reader hand put() a java.lang.String rather than a Utf8.
 *
 * @param optional_name Exercises the two-branch option path.
 * @param name_or_count Exercises the multi-branch union path.
 * @param names Exercises a union nested in an array.
 * @param lookup Exercises a union nested in a map.
 */
case class JavaStrings(var optional_name: Option[String], var name_or_count: String :+: Int :+: CNil, var names: List[String :+: Int :+: CNil], var lookup: Map[String, String :+: Int :+: CNil]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(None, Inl(""), List.empty, Map.empty)

  override def getSchema: org.apache.avro.Schema = JavaStrings.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => optional_name match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 1 => name_or_count match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 2 => names match {
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
      case 3 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = lookup.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        lookup.foreach { kvp =>
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
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.optional_name = {
        value match {
          case null => None
          case x: java.lang.CharSequence => Some(x.toString)
        }
      }
      case 1 => this.name_or_count = {
        value match {
          case x: java.lang.CharSequence => Coproduct[String :+: Int :+: CNil](x.toString)
          case x: Int => Coproduct[String :+: Int :+: CNil](x)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 2 => this.names = {
        value match {
          case array: java.util.List[_] =>
            val builder$ = List.newBuilder[String :+: Int :+: CNil]
            val iterator$ = array.iterator
            while (iterator$.hasNext) {
              val value = iterator$.next
              builder$ += {
                value match {
                  case x: java.lang.CharSequence => Coproduct[String :+: Int :+: CNil](x.toString)
                  case x: Int => Coproduct[String :+: Int :+: CNil](x)
                  case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                }
              }
            }
            builder$.result()
          }
      }
      case 3 => this.lookup = {
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
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object JavaStrings {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"JavaStrings","namespace":"avro2s.test.javastring","doc":"Strings carrying avro.java.string: String, which makes the reader hand put() a java.lang.String rather than a Utf8.","fields":[{"name":"optional_name","type":["null",{"type":"string","avro.java.string":"String"}],"doc":"Exercises the two-branch option path."},{"name":"name_or_count","type":[{"type":"string","avro.java.string":"String"},"int"],"doc":"Exercises the multi-branch union path."},{"name":"names","type":{"type":"array","items":[{"type":"string","avro.java.string":"String"},"int"]},"doc":"Exercises a union nested in an array."},{"name":"lookup","type":{"type":"map","values":[{"type":"string","avro.java.string":"String"},"int"]},"doc":"Exercises a union nested in a map."}]}""")
}