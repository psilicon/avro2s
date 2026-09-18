/** GENERATED CODE */

package avro2s.test.records

import scala.annotation.switch

case class EmptyRecord() extends org.apache.avro.specific.SpecificRecordBase {

  override def getSchema: org.apache.avro.Schema = EmptyRecord.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override protected def hasCustomCoders(): Boolean = true
  override def customEncode(out$: _root_.org.apache.avro.io.Encoder): Unit = encode$0(this, out$)
  override def customDecode(in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = decodeRecord$0(this, in$)

  private def encode$0(value$: _root_.avro2s.test.records.EmptyRecord, out$: _root_.org.apache.avro.io.Encoder): Unit = {
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.records.EmptyRecord): _root_.avro2s.test.records.EmptyRecord = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.records.EmptyRecord() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.records.EmptyRecord, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
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
}

object EmptyRecord {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"EmptyRecord","namespace":"avro2s.test.records","fields":[]}""")
}