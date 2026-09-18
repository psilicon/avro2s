/** GENERATED CODE */

package avro2s.test.records

import scala.annotation.switch

case class EmptyRecords(var _string: String, var _empty_record: avro2s.test.records.EmptyRecord, var _int: Int) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("", new avro2s.test.records.EmptyRecord(), 0)

  override def getSchema: org.apache.avro.Schema = EmptyRecords.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _string.asInstanceOf[AnyRef]
      case 1 => _empty_record.asInstanceOf[AnyRef]
      case 2 => _int.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._string = {
        value.toString.asInstanceOf[String]
      }
      case 1 => this._empty_record = {
        value.asInstanceOf[avro2s.test.records.EmptyRecord]
      }
      case 2 => this._int = {
        value.asInstanceOf[Int]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override protected def hasCustomCoders(): Boolean = true
  override def customEncode(out$: _root_.org.apache.avro.io.Encoder): Unit = encode$0(this, out$)
  override def customDecode(in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = decodeRecord$0(this, in$)

  private def encode$0(value$: _root_.avro2s.test.records.EmptyRecords, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`_string`, out$)
    encode$2(value$.`_empty_record`, out$)
    encode$3(value$.`_int`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.records.EmptyRecords): _root_.avro2s.test.records.EmptyRecords = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.records.EmptyRecords() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.records.EmptyRecords, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$1(in$)
      value$.`_empty_record` = decode$2(in$, value$.`_empty_record`)
      value$.`_int` = decode$3(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$1(in$)
          case 1 => value$.`_empty_record` = decode$2(in$, value$.`_empty_record`)
          case 2 => value$.`_int` = decode$3(in$)
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

  private def encode$2(value$: _root_.avro2s.test.records.EmptyRecord, out$: _root_.org.apache.avro.io.Encoder): Unit = {
  }

  private def decode$2(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.records.EmptyRecord): _root_.avro2s.test.records.EmptyRecord = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.records.EmptyRecord() else reuse$
    decodeRecord$2(result$, in$)
    result$
  }

  private def decodeRecord$2(value$: _root_.avro2s.test.records.EmptyRecord, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$3(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$3(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }
}

object EmptyRecords {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"EmptyRecords","namespace":"avro2s.test.records","fields":[{"name":"_string","type":"string"},{"name":"_empty_record","type":{"type":"record","name":"EmptyRecord","fields":[]}},{"name":"_int","type":"int"}]}""")
}