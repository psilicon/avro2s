/** GENERATED CODE */

package avro2s.test.javastring

import scala.annotation.switch

/**
 * Strings carrying avro.java.string: String, which makes the reader hand put() a java.lang.String rather than a Utf8.
 *
 * @param optional_name Exercises the two-branch option path.
 * @param name_or_count Exercises the multi-branch union path.
 * @param names Exercises a union nested in an array.
 * @param lookup Exercises a union nested in a map.
 */
case class JavaStrings(var optional_name: Option[String], var name_or_count: String | Int, var names: List[String | Int], var lookup: Map[String, String | Int]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(None, "", List.empty, Map.empty)

  override def getSchema: org.apache.avro.Schema = JavaStrings.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => optional_name match {
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 1 => name_or_count match {
        case x: String => x.asInstanceOf[AnyRef]
        case x: Int => x.asInstanceOf[AnyRef]
      }
      case 2 => names match {
        case array =>
          {
            def toJavaArray$(input$: List[String | Int]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case x: String => x.asInstanceOf[AnyRef]
                    case x: Int => x.asInstanceOf[AnyRef]
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
              case x: String => x.asInstanceOf[AnyRef]
              case x: Int => x.asInstanceOf[AnyRef]
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
          case x: java.lang.CharSequence => Option(x.toString)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 1 => this.name_or_count = {
        value match {
          case x: java.lang.CharSequence => x.toString
          case x: Int => x
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 2 => this.names = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case x: java.lang.CharSequence => x.toString
            case x: Int => x
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case 3 => this.lookup = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String | Int] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case x: java.lang.CharSequence => x.toString
                case x: Int => x
                case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
              }
            })
          }.toMap
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object JavaStrings {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"JavaStrings","namespace":"avro2s.test.javastring","doc":"Strings carrying avro.java.string: String, which makes the reader hand put() a java.lang.String rather than a Utf8.","fields":[{"name":"optional_name","type":["null",{"type":"string","avro.java.string":"String"}],"doc":"Exercises the two-branch option path."},{"name":"name_or_count","type":[{"type":"string","avro.java.string":"String"},"int"],"doc":"Exercises the multi-branch union path."},{"name":"names","type":{"type":"array","items":[{"type":"string","avro.java.string":"String"},"int"]},"doc":"Exercises a union nested in an array."},{"name":"lookup","type":{"type":"map","values":[{"type":"string","avro.java.string":"String"},"int"]},"doc":"Exercises a union nested in a map."}]}""")
}