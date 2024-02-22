/** GENERATED CODE */

package avro2s.test.unions

import org.apache.avro.AvroRuntimeException

import scala.annotation.switch

case class Optionals(var simple: Option[String], var optionalArray: Option[List[Boolean]], var arrayOfOptions: List[Option[String]]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(null, null, null)

  override def getSchema: org.apache.avro.Schema = Optionals.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => simple match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 1 => optionalArray match {
        case None => null
        case Some(x) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map { x =>x.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
      }
      case 2 => arrayOfOptions match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map {
              case None => null
              case Some(x) => x.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => value match {
        case null => this.simple = None
        case x => this.simple = Some(x.toString.asInstanceOf[String])
      }
      case 1 => value match {
        case null => this.optionalArray = None
        case x: java.util.List[_] => this.optionalArray = Some({
          x match {
            case array: java.util.List[_] =>
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value.asInstanceOf[Boolean]
              }).toList
            }
        }.toList)
      }
      case 2 => this.arrayOfOptions = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case null => None
                case x => Some(x.toString.asInstanceOf[String])
              }
            }).toList
          }
      }
    }
  }
}

object Optionals {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Optionals","namespace":"avro2s.test.unions","fields":[{"name":"simple","type":["string","null"]},{"name":"optionalArray","type":[{"type":"array","items":"boolean"},"null"]},{"name":"arrayOfOptions","type":{"type":"array","items":["null","string"]}}]}""")
}
