/** GENERATED CODE */

package avro2s.test.arrays

import scala.annotation.switch

case class Record(var _string: String, var _int: Int) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("", 0)

  override def getSchema: org.apache.avro.Schema = Record.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _string.asInstanceOf[AnyRef]
      case 1 => _int.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._string = {
        value.toString.asInstanceOf[String]
      }
      case 1 => this._int = {
        value.asInstanceOf[Int]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object Record {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Record","namespace":"avro2s.test.arrays","fields":[{"name":"_string","type":"string"},{"name":"_int","type":"int"}]}""")
}