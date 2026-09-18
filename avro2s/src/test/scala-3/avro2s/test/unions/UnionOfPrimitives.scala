/** GENERATED CODE */

package avro2s.test.unions

import scala.annotation.switch

case class UnionOfPrimitives(var _primitives: Long | Boolean | Int) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(0)

  override def getSchema: org.apache.avro.Schema = UnionOfPrimitives.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _primitives match {
        case x: Long => x.asInstanceOf[AnyRef]
        case x: Boolean => x.asInstanceOf[AnyRef]
        case x: Int => x.asInstanceOf[AnyRef]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._primitives = {
        value match {
          case x: Long => x
          case x: Boolean => x
          case x: Int => x
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override protected def hasCustomCoders(): Boolean = true
  override def customEncode(out$: _root_.org.apache.avro.io.Encoder): Unit = encode$0(this, out$)
  override def customDecode(in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = decodeRecord$0(this, in$)

  private def encode$0(value$: _root_.avro2s.test.unions.UnionOfPrimitives, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`_primitives`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.unions.UnionOfPrimitives): _root_.avro2s.test.unions.UnionOfPrimitives = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.unions.UnionOfPrimitives() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.unions.UnionOfPrimitives, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_primitives` = decode$1(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_primitives` = decode$1(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$1(value$: _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.scala.Long @unchecked) =>
        out$.writeIndex(0)
        encode$2(branch$, out$)
      case branch$: (_root_.scala.Boolean @unchecked) =>
        out$.writeIndex(1)
        encode$3(branch$, out$)
      case branch$: (_root_.scala.Int @unchecked) =>
        out$.writeIndex(2)
        encode$4(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$1(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long | _root_.scala.Boolean | _root_.scala.Int = {
    in$.readIndex() match {
      case 0 => decode$2(in$)
      case 1 => decode$3(in$)
      case 2 => decode$4(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$2(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$2(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$3(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$3(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$4(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$4(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }
}

object UnionOfPrimitives {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"UnionOfPrimitives","namespace":"avro2s.test.unions","fields":[{"name":"_primitives","type":["long","boolean","int"]}]}""")
}