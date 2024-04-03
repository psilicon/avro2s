/** GENERATED CODE */

package avro2s.test.logical

import org.apache.avro
import org.apache.avro.Conversion

import scala.annotation.switch

case class Conversions(var _uuid: java.util.UUID, var _string: String, var _map_of_uuid: Map[String, java.util.UUID]) extends org.apache.avro.specific.SpecificRecordBase {
//case class Conversions(var _uuid: java.util.UUID, var _string: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(java.util.UUID.fromString("00000000-0000-0000-0000-000000000000"), "", Map.empty)
//  def this() = this(java.util.UUID.fromString("00000000-0000-0000-0000-000000000000"), "")

  override def getSchema: org.apache.avro.Schema = Conversions.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _uuid.asInstanceOf[AnyRef]
      case 1 => _string.asInstanceOf[AnyRef]
      case 2 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_of_uuid.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2
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
      case 0 => this._uuid = value.asInstanceOf[java.util.UUID]
      case 1 => this._string = value.toString.asInstanceOf[String]
      case 2 => this._map_of_uuid = {
        value match {
          case map: java.util.Map[_, _] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value.asInstanceOf[java.util.UUID]
              })
            }
          }
        }
      }
    }
  }
  
  override def getConversion(field: Int): Conversion[_] = {
    (field: @switch) match {
      case 0 => new org.apache.avro.Conversions.UUIDConversion
      case 1 => null
      case 2 => new org.apache.avro.Conversions.UUIDConversion
    }
  }
}

object Conversions {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Conversions","namespace":"avro2s.test.logical","fields":[{"name":"_uuid","type":{"type":"string","logicalType":"uuid"}},{"name":"_string","type":"string"},{"name":"_map_of_uuid","type":{"type":"map","values":{"type":"string","logicalType":"uuid"}}}]}""")
//  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Conversions","namespace":"avro2s.test.logical","fields":[{"name":"_uuid","type":{"type":"string","logicalType":"uuid"}},{"name":"_string","type":"string"}]}""")
}