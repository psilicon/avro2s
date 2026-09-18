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
case class DocumentedRecord(var `type`: String, var `given`: String, var id: avro2s.test.docs.DocumentedFixed, var state: avro2s.test.docs.DocumentedEnum, var blank: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("", "", new avro2s.test.docs.DocumentedFixed(), null, "")

  override def getSchema: org.apache.avro.Schema = DocumentedRecord.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => `type`.asInstanceOf[AnyRef]
      case 1 => `given`.asInstanceOf[AnyRef]
      case 2 => id.asInstanceOf[AnyRef]
      case 3 => state.asInstanceOf[AnyRef]
      case 4 => blank.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.`type` = {
        value.toString.asInstanceOf[String]
      }
      case 1 => this.`given` = {
        value.toString.asInstanceOf[String]
      }
      case 2 => this.id = {
        value.asInstanceOf[avro2s.test.docs.DocumentedFixed]
      }
      case 3 => this.state = {
        value.asInstanceOf[avro2s.test.docs.DocumentedEnum]
      }
      case 4 => this.blank = {
        value.toString.asInstanceOf[String]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override protected def hasCustomCoders(): Boolean = true
  override def customEncode(out$: _root_.org.apache.avro.io.Encoder): Unit = encode$0(this, out$)
  override def customDecode(in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = decodeRecord$0(this, in$)

  private def encode$0(value$: _root_.avro2s.test.docs.DocumentedRecord, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`type`, out$)
    encode$2(value$.`given`, out$)
    encode$3(value$.`id`, out$)
    encode$4(value$.`state`, out$)
    encode$5(value$.`blank`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.docs.DocumentedRecord): _root_.avro2s.test.docs.DocumentedRecord = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.docs.DocumentedRecord() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.docs.DocumentedRecord, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`type` = decode$1(in$)
      value$.`given` = decode$2(in$)
      value$.`id` = decode$3(in$)
      value$.`state` = decode$4(in$)
      value$.`blank` = decode$5(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`type` = decode$1(in$)
          case 1 => value$.`given` = decode$2(in$)
          case 2 => value$.`id` = decode$3(in$)
          case 3 => value$.`state` = decode$4(in$)
          case 4 => value$.`blank` = decode$5(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$1(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$1(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$2(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$2(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$3(value$: _root_.avro2s.test.docs.DocumentedFixed, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFixed(value$.bytes(), 0, 4)
  }

  private def decode$3(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.docs.DocumentedFixed = {
    val result$ = new _root_.avro2s.test.docs.DocumentedFixed()
    in$.readFixed(result$.bytes())
    result$
  }

  private def encode$4(value$: _root_.avro2s.test.docs.DocumentedEnum, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeEnum(value$.ordinal())
  }

  private def decode$4(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.docs.DocumentedEnum = {
    _root_.avro2s.test.docs.DocumentedRecord.customEnum$4(in$.readEnum())
  }

  private def encode$5(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$5(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }
}

object DocumentedRecord {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"DocumentedRecord","namespace":"avro2s.test.docs","doc":"A documented record.\r\nSecond line with café and 日本語.\r\n\r\nLiteral /* opening and */ closing delimiters.","fields":[{"name":"type","type":"string","doc":"The record category.\nMay contain /* or */."},{"name":"given","type":"string","doc":"A Scala 3 keyword."},{"name":"id","type":{"type":"fixed","name":"DocumentedFixed","doc":"A four-byte identifier.","size":4},"doc":"The identifier."},{"name":"state","type":{"type":"enum","name":"DocumentedEnum","doc":"Available states.","symbols":["ON","OFF"]}},{"name":"blank","type":"string","doc":" \t\r\n "}]}""")
  private val customSchema$4: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(3).schema()
  private val customEnum$4: _root_.scala.Array[_root_.avro2s.test.docs.DocumentedEnum] = {
    val result$ = new _root_.scala.Array[_root_.avro2s.test.docs.DocumentedEnum](customSchema$4.getEnumSymbols.size())
    var i$ = 0
    while (i$ < result$.length) {
      result$(i$) = _root_.avro2s.test.docs.DocumentedEnum.valueOf(customSchema$4.getEnumSymbols.get(i$))
      i$ += 1
    }
    result$
  }
}