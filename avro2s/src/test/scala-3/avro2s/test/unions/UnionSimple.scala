/** GENERATED CODE */

package avro2s.test.unions

import org.apache.avro.AvroRuntimeException

import scala.annotation.switch

case class UnionSimple(var moo: String | Long | Boolean | Map[String, Double | Int] | scala.Null) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(null)

  override def getSchema: org.apache.avro.Schema = UnionSimple.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => moo match {
        case x: String => x.asInstanceOf[AnyRef]
        case x: Long => x.asInstanceOf[AnyRef]
        case x: Boolean => x.asInstanceOf[AnyRef]
        case x: Map[String, Double | Int] =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              kvp._2 match {
                case x: Double => x.asInstanceOf[AnyRef]
                case x: Int => x.asInstanceOf[AnyRef]
                case _ => throw new AvroRuntimeException("Invalid value")
              }
            }
            map.put(key, value)
          }
          map
        case null => null.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => value match {
        case x: org.apache.avro.util.Utf8 => this.moo = x.toString
        case x: Long => this.moo = x
        case x: Boolean => this.moo = x
        case map: java.util.Map[_,_] => this.moo = {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case x: Double => x
                case x: Int => x
                case _ => throw new AvroRuntimeException("Invalid value")
              }
            })
          }
        }
        case null => this.moo = null
        case _ => throw new AvroRuntimeException("Invalid value")
      }
    }
  }
}

object UnionSimple {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"UnionSimple","namespace":"avro2s.test.unions","fields":[{"name":"moo","type":["string","long","boolean",{"type":"map","values":["double","int"]},"null"]}]}""")
}
