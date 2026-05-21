/** GENERATED CODE */

package avro2s.test.enums

import scala.annotation.switch

case class EnumSpec(var _enum: avro2s.test.enums.Suit, var _optional_enum: Option[avro2s.test.enums.Suit], var _name: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(null, None, "")

  override def getSchema: org.apache.avro.Schema = EnumSpec.SCHEMA$

  override def getSpecificData(): org.apache.avro.specific.SpecificData = EnumSpec.MODEL$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _enum.asInstanceOf[AnyRef]
      case 1 => _optional_enum match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 2 => _name.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._enum = value.asInstanceOf[avro2s.test.enums.Suit]
      case 1 => this._optional_enum = {
        value match {
          case null => None
          case x: avro2s.test.enums.Suit => Some(x)
        }
      }
      case 2 => this._name = value.toString.asInstanceOf[String]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object EnumSpec {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"EnumSpec","namespace":"avro2s.test.enums","fields":[{"name":"_enum","type":{"type":"enum","name":"Suit","symbols":["SPADES","HEARTS","DIAMONDS","CLUBS"]}},{"name":"_optional_enum","type":["null","Suit"],"default":null},{"name":"_name","type":"string"}]}""")
  val MODEL$: org.apache.avro.specific.SpecificData = {
    val model = new avro2s.generated.ScalaSpecificData()
    model
  }
}