/** GENERATED CODE */

package avro2s.test.unions

import org.apache.avro.AvroRuntimeException

import scala.annotation.switch
import shapeless.{:+:, CNil, Coproduct, Inl, Inr}

case class Optionals(var _simple: String :+: scala.Null :+: CNil, var _optional_array: List[Boolean] :+: scala.Null :+: CNil, var _array_of_options: List[Option[String]]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(null, null, null)

  override def getSchema: org.apache.avro.Schema = Optionals.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _simple match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 1 => _optional_array match {
        case Inl(x) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map { x =>x.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
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
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => value match {
        case x: org.apache.avro.util.Utf8 => this._simple = Coproduct[String :+: scala.Null :+: CNil](x.toString)
        case x @ null => this._simple = Coproduct[String :+: scala.Null :+: CNil](x)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 1 => value match {
        case x: java.util.List[_] => this._optional_array = Coproduct[List[Boolean] :+: scala.Null :+: CNil]({
          x match {
            case array: java.util.List[_] =>
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value.asInstanceOf[Boolean]
              }).toList
            }
        }.toList)
        case x @ null => this._optional_array = Coproduct[List[Boolean] :+: scala.Null :+: CNil](x)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 2 => this._array_of_options = {
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
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Optionals","namespace":"avro2s.test.unions","fields":[{"name":"_simple","type":["string","null"]},{"name":"_optional_array","type":[{"type":"array","items":"boolean"},"null"]},{"name":"_array_of_options","type":{"type":"array","items":["null","string"]}}]}""")
}