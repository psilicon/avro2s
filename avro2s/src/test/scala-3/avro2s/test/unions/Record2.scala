/** GENERATED CODE */

package avro2s.test.unions

import scala.annotation.switch

case class Record2(var field2: Long) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(0)

  override def getSchema: org.apache.avro.Schema = Record2.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => field2.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.field2 = {
        value.asInstanceOf[Long]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override protected def hasCustomCoders(): Boolean = true
  override def customEncode(out$: _root_.org.apache.avro.io.Encoder): Unit = encode$0(this, out$)
  override def customDecode(in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = decodeRecord$0(this, in$)

  private def encode$0(value$: _root_.avro2s.test.unions.Record2, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`field2`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.unions.Record2): _root_.avro2s.test.unions.Record2 = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.unions.Record2() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.unions.Record2, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`field2` = decode$1(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`field2` = decode$1(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$1(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$1(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }
}

object Record2 {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Record2","namespace":"avro2s.test.unions","fields":[{"name":"field2","type":"long"}]}""")
}