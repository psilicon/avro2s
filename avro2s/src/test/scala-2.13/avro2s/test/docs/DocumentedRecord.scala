/** GENERATED CODE */

package avro2s.test.docs

import scala.annotation.switch

/**
 * A documented record.
 * Second line with café and 日本語.
 *
 * Literal /&#42; opening and &#42;/ closing delimiters.
 *
 * @param type The record category.
 *   May contain /&#42; or &#42;/.
 * @param given A Scala 3 keyword.
 * @param id The identifier.
 */
case class DocumentedRecord(var `type`: String, var given: String, var id: avro2s.test.docs.DocumentedFixed, var state: avro2s.test.docs.DocumentedEnum, var blank: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("", "", new avro2s.test.docs.DocumentedFixed(), null, "")

  override def getSchema: org.apache.avro.Schema = DocumentedRecord.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => `type`.asInstanceOf[AnyRef]
      case 1 => given.asInstanceOf[AnyRef]
      case 2 => id.asInstanceOf[AnyRef]
      case 3 => state.asInstanceOf[AnyRef]
      case 4 => blank.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.`type` = value.toString.asInstanceOf[String]
      case 1 => this.given = value.toString.asInstanceOf[String]
      case 2 => this.id = value.asInstanceOf[avro2s.test.docs.DocumentedFixed]
      case 3 => this.state = value.asInstanceOf[avro2s.test.docs.DocumentedEnum]
      case 4 => this.blank = value.toString.asInstanceOf[String]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object DocumentedRecord {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"DocumentedRecord","namespace":"avro2s.test.docs","doc":"A documented record.\r\nSecond line with café and 日本語.\r\n\r\nLiteral /* opening and */ closing delimiters.","fields":[{"name":"type","type":"string","doc":"The record category.\nMay contain /* or */."},{"name":"given","type":"string","doc":"A Scala 3 keyword."},{"name":"id","type":{"type":"fixed","name":"DocumentedFixed","doc":"A four-byte identifier.","size":4},"doc":"The identifier."},{"name":"state","type":{"type":"enum","name":"DocumentedEnum","doc":"Available states.","symbols":["ON","OFF"]}},{"name":"blank","type":"string","doc":" \t\r\n "}]}""")
}