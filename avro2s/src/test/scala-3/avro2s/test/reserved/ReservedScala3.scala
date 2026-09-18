/** GENERATED CODE */

package avro2s.test.reserved

import scala.annotation.switch

case class ReservedScala3(var `abstract`: scala.Null, var `case`: Boolean, var `catch`: Int, var `class`: Long, var `def`: Float, var `do`: Double, var `else`: Array[Byte], var `extends`: String, var `false`: scala.Null, var `final`: Boolean, var `finally`: Int, var `for`: Long, var `forSome`: Float, var `if`: Double, var `implicit`: Array[Byte], var `import`: String, var `lazy`: scala.Null, var `macro`: Boolean, var `match`: Int, var `new`: Long, var `null`: Float, var `object`: Double, var `override`: Array[Byte], var `package`: String, var `private`: scala.Null, var `protected`: Boolean, var `return`: Int, var `sealed`: Long, var `super`: Float, var `this`: Double, var `throw`: Array[Byte], var `trait`: String, var `try`: scala.Null, var `true`: Boolean, var `type`: Int, var `val`: Long, var `var`: Float, var `while`: Double, var `with`: Array[Byte], var `yield`: String, var `enum`: scala.Null, var `export`: Boolean, var `given`: Int, var `then`: Long) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(null, false, 0, 0, 0, 0, _root_.scala.Array.emptyByteArray, "", null, false, 0, 0, 0, 0, _root_.scala.Array.emptyByteArray, "", null, false, 0, 0, 0, 0, _root_.scala.Array.emptyByteArray, "", null, false, 0, 0, 0, 0, _root_.scala.Array.emptyByteArray, "", null, false, 0, 0, 0, 0, _root_.scala.Array.emptyByteArray, "", null, false, 0, 0)

  override def getSchema: org.apache.avro.Schema = ReservedScala3.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => `abstract`.asInstanceOf[AnyRef]
      case 1 => `case`.asInstanceOf[AnyRef]
      case 2 => `catch`.asInstanceOf[AnyRef]
      case 3 => `class`.asInstanceOf[AnyRef]
      case 4 => `def`.asInstanceOf[AnyRef]
      case 5 => `do`.asInstanceOf[AnyRef]
      case 6 => java.nio.ByteBuffer.wrap(`else`).asInstanceOf[AnyRef]
      case 7 => `extends`.asInstanceOf[AnyRef]
      case 8 => `false`.asInstanceOf[AnyRef]
      case 9 => `final`.asInstanceOf[AnyRef]
      case 10 => `finally`.asInstanceOf[AnyRef]
      case 11 => `for`.asInstanceOf[AnyRef]
      case 12 => `forSome`.asInstanceOf[AnyRef]
      case 13 => `if`.asInstanceOf[AnyRef]
      case 14 => java.nio.ByteBuffer.wrap(`implicit`).asInstanceOf[AnyRef]
      case 15 => `import`.asInstanceOf[AnyRef]
      case 16 => `lazy`.asInstanceOf[AnyRef]
      case 17 => `macro`.asInstanceOf[AnyRef]
      case 18 => `match`.asInstanceOf[AnyRef]
      case 19 => `new`.asInstanceOf[AnyRef]
      case 20 => `null`.asInstanceOf[AnyRef]
      case 21 => `object`.asInstanceOf[AnyRef]
      case 22 => java.nio.ByteBuffer.wrap(`override`).asInstanceOf[AnyRef]
      case 23 => `package`.asInstanceOf[AnyRef]
      case 24 => `private`.asInstanceOf[AnyRef]
      case 25 => `protected`.asInstanceOf[AnyRef]
      case 26 => `return`.asInstanceOf[AnyRef]
      case 27 => `sealed`.asInstanceOf[AnyRef]
      case 28 => `super`.asInstanceOf[AnyRef]
      case 29 => `this`.asInstanceOf[AnyRef]
      case 30 => java.nio.ByteBuffer.wrap(`throw`).asInstanceOf[AnyRef]
      case 31 => `trait`.asInstanceOf[AnyRef]
      case 32 => `try`.asInstanceOf[AnyRef]
      case 33 => `true`.asInstanceOf[AnyRef]
      case 34 => `type`.asInstanceOf[AnyRef]
      case 35 => `val`.asInstanceOf[AnyRef]
      case 36 => `var`.asInstanceOf[AnyRef]
      case 37 => `while`.asInstanceOf[AnyRef]
      case 38 => java.nio.ByteBuffer.wrap(`with`).asInstanceOf[AnyRef]
      case 39 => `yield`.asInstanceOf[AnyRef]
      case 40 => `enum`.asInstanceOf[AnyRef]
      case 41 => `export`.asInstanceOf[AnyRef]
      case 42 => `given`.asInstanceOf[AnyRef]
      case 43 => `then`.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.`abstract` = {
        value.asInstanceOf[scala.Null]
      }
      case 1 => this.`case` = {
        value.asInstanceOf[Boolean]
      }
      case 2 => this.`catch` = {
        value.asInstanceOf[Int]
      }
      case 3 => this.`class` = {
        value.asInstanceOf[Long]
      }
      case 4 => this.`def` = {
        value.asInstanceOf[Float]
      }
      case 5 => this.`do` = {
        value.asInstanceOf[Double]
      }
      case 6 => this.`else` = {
        val buffer = value.asInstanceOf[java.nio.ByteBuffer]
        val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); array
      }
      case 7 => this.`extends` = {
        value.toString.asInstanceOf[String]
      }
      case 8 => this.`false` = {
        value.asInstanceOf[scala.Null]
      }
      case 9 => this.`final` = {
        value.asInstanceOf[Boolean]
      }
      case 10 => this.`finally` = {
        value.asInstanceOf[Int]
      }
      case 11 => this.`for` = {
        value.asInstanceOf[Long]
      }
      case 12 => this.`forSome` = {
        value.asInstanceOf[Float]
      }
      case 13 => this.`if` = {
        value.asInstanceOf[Double]
      }
      case 14 => this.`implicit` = {
        val buffer = value.asInstanceOf[java.nio.ByteBuffer]
        val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); array
      }
      case 15 => this.`import` = {
        value.toString.asInstanceOf[String]
      }
      case 16 => this.`lazy` = {
        value.asInstanceOf[scala.Null]
      }
      case 17 => this.`macro` = {
        value.asInstanceOf[Boolean]
      }
      case 18 => this.`match` = {
        value.asInstanceOf[Int]
      }
      case 19 => this.`new` = {
        value.asInstanceOf[Long]
      }
      case 20 => this.`null` = {
        value.asInstanceOf[Float]
      }
      case 21 => this.`object` = {
        value.asInstanceOf[Double]
      }
      case 22 => this.`override` = {
        val buffer = value.asInstanceOf[java.nio.ByteBuffer]
        val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); array
      }
      case 23 => this.`package` = {
        value.toString.asInstanceOf[String]
      }
      case 24 => this.`private` = {
        value.asInstanceOf[scala.Null]
      }
      case 25 => this.`protected` = {
        value.asInstanceOf[Boolean]
      }
      case 26 => this.`return` = {
        value.asInstanceOf[Int]
      }
      case 27 => this.`sealed` = {
        value.asInstanceOf[Long]
      }
      case 28 => this.`super` = {
        value.asInstanceOf[Float]
      }
      case 29 => this.`this` = {
        value.asInstanceOf[Double]
      }
      case 30 => this.`throw` = {
        val buffer = value.asInstanceOf[java.nio.ByteBuffer]
        val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); array
      }
      case 31 => this.`trait` = {
        value.toString.asInstanceOf[String]
      }
      case 32 => this.`try` = {
        value.asInstanceOf[scala.Null]
      }
      case 33 => this.`true` = {
        value.asInstanceOf[Boolean]
      }
      case 34 => this.`type` = {
        value.asInstanceOf[Int]
      }
      case 35 => this.`val` = {
        value.asInstanceOf[Long]
      }
      case 36 => this.`var` = {
        value.asInstanceOf[Float]
      }
      case 37 => this.`while` = {
        value.asInstanceOf[Double]
      }
      case 38 => this.`with` = {
        val buffer = value.asInstanceOf[java.nio.ByteBuffer]
        val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); array
      }
      case 39 => this.`yield` = {
        value.toString.asInstanceOf[String]
      }
      case 40 => this.`enum` = {
        value.asInstanceOf[scala.Null]
      }
      case 41 => this.`export` = {
        value.asInstanceOf[Boolean]
      }
      case 42 => this.`given` = {
        value.asInstanceOf[Int]
      }
      case 43 => this.`then` = {
        value.asInstanceOf[Long]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override protected def hasCustomCoders(): Boolean = true
  override def customEncode(out$: _root_.org.apache.avro.io.Encoder): Unit = encode$0(this, out$)
  override def customDecode(in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = decodeRecord$0(this, in$)

  private def encode$0(value$: _root_.avro2s.test.reserved.ReservedScala3, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`abstract`, out$)
    encode$2(value$.`case`, out$)
    encode$3(value$.`catch`, out$)
    encode$4(value$.`class`, out$)
    encode$5(value$.`def`, out$)
    encode$6(value$.`do`, out$)
    encode$7(value$.`else`, out$)
    encode$8(value$.`extends`, out$)
    encode$9(value$.`false`, out$)
    encode$10(value$.`final`, out$)
    encode$11(value$.`finally`, out$)
    encode$12(value$.`for`, out$)
    encode$13(value$.`forSome`, out$)
    encode$14(value$.`if`, out$)
    encode$15(value$.`implicit`, out$)
    encode$16(value$.`import`, out$)
    encode$17(value$.`lazy`, out$)
    encode$18(value$.`macro`, out$)
    encode$19(value$.`match`, out$)
    encode$20(value$.`new`, out$)
    encode$21(value$.`null`, out$)
    encode$22(value$.`object`, out$)
    encode$23(value$.`override`, out$)
    encode$24(value$.`package`, out$)
    encode$25(value$.`private`, out$)
    encode$26(value$.`protected`, out$)
    encode$27(value$.`return`, out$)
    encode$28(value$.`sealed`, out$)
    encode$29(value$.`super`, out$)
    encode$30(value$.`this`, out$)
    encode$31(value$.`throw`, out$)
    encode$32(value$.`trait`, out$)
    encode$33(value$.`try`, out$)
    encode$34(value$.`true`, out$)
    encode$35(value$.`type`, out$)
    encode$36(value$.`val`, out$)
    encode$37(value$.`var`, out$)
    encode$38(value$.`while`, out$)
    encode$39(value$.`with`, out$)
    encode$40(value$.`yield`, out$)
    encode$41(value$.`enum`, out$)
    encode$42(value$.`export`, out$)
    encode$43(value$.`given`, out$)
    encode$44(value$.`then`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.reserved.ReservedScala3): _root_.avro2s.test.reserved.ReservedScala3 = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.reserved.ReservedScala3() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.reserved.ReservedScala3, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`abstract` = decode$1(in$)
      value$.`case` = decode$2(in$)
      value$.`catch` = decode$3(in$)
      value$.`class` = decode$4(in$)
      value$.`def` = decode$5(in$)
      value$.`do` = decode$6(in$)
      value$.`else` = decode$7(in$)
      value$.`extends` = decode$8(in$)
      value$.`false` = decode$9(in$)
      value$.`final` = decode$10(in$)
      value$.`finally` = decode$11(in$)
      value$.`for` = decode$12(in$)
      value$.`forSome` = decode$13(in$)
      value$.`if` = decode$14(in$)
      value$.`implicit` = decode$15(in$)
      value$.`import` = decode$16(in$)
      value$.`lazy` = decode$17(in$)
      value$.`macro` = decode$18(in$)
      value$.`match` = decode$19(in$)
      value$.`new` = decode$20(in$)
      value$.`null` = decode$21(in$)
      value$.`object` = decode$22(in$)
      value$.`override` = decode$23(in$)
      value$.`package` = decode$24(in$)
      value$.`private` = decode$25(in$)
      value$.`protected` = decode$26(in$)
      value$.`return` = decode$27(in$)
      value$.`sealed` = decode$28(in$)
      value$.`super` = decode$29(in$)
      value$.`this` = decode$30(in$)
      value$.`throw` = decode$31(in$)
      value$.`trait` = decode$32(in$)
      value$.`try` = decode$33(in$)
      value$.`true` = decode$34(in$)
      value$.`type` = decode$35(in$)
      value$.`val` = decode$36(in$)
      value$.`var` = decode$37(in$)
      value$.`while` = decode$38(in$)
      value$.`with` = decode$39(in$)
      value$.`yield` = decode$40(in$)
      value$.`enum` = decode$41(in$)
      value$.`export` = decode$42(in$)
      value$.`given` = decode$43(in$)
      value$.`then` = decode$44(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`abstract` = decode$1(in$)
          case 1 => value$.`case` = decode$2(in$)
          case 2 => value$.`catch` = decode$3(in$)
          case 3 => value$.`class` = decode$4(in$)
          case 4 => value$.`def` = decode$5(in$)
          case 5 => value$.`do` = decode$6(in$)
          case 6 => value$.`else` = decode$7(in$)
          case 7 => value$.`extends` = decode$8(in$)
          case 8 => value$.`false` = decode$9(in$)
          case 9 => value$.`final` = decode$10(in$)
          case 10 => value$.`finally` = decode$11(in$)
          case 11 => value$.`for` = decode$12(in$)
          case 12 => value$.`forSome` = decode$13(in$)
          case 13 => value$.`if` = decode$14(in$)
          case 14 => value$.`implicit` = decode$15(in$)
          case 15 => value$.`import` = decode$16(in$)
          case 16 => value$.`lazy` = decode$17(in$)
          case 17 => value$.`macro` = decode$18(in$)
          case 18 => value$.`match` = decode$19(in$)
          case 19 => value$.`new` = decode$20(in$)
          case 20 => value$.`null` = decode$21(in$)
          case 21 => value$.`object` = decode$22(in$)
          case 22 => value$.`override` = decode$23(in$)
          case 23 => value$.`package` = decode$24(in$)
          case 24 => value$.`private` = decode$25(in$)
          case 25 => value$.`protected` = decode$26(in$)
          case 26 => value$.`return` = decode$27(in$)
          case 27 => value$.`sealed` = decode$28(in$)
          case 28 => value$.`super` = decode$29(in$)
          case 29 => value$.`this` = decode$30(in$)
          case 30 => value$.`throw` = decode$31(in$)
          case 31 => value$.`trait` = decode$32(in$)
          case 32 => value$.`try` = decode$33(in$)
          case 33 => value$.`true` = decode$34(in$)
          case 34 => value$.`type` = decode$35(in$)
          case 35 => value$.`val` = decode$36(in$)
          case 36 => value$.`var` = decode$37(in$)
          case 37 => value$.`while` = decode$38(in$)
          case 38 => value$.`with` = decode$39(in$)
          case 39 => value$.`yield` = decode$40(in$)
          case 40 => value$.`enum` = decode$41(in$)
          case 41 => value$.`export` = decode$42(in$)
          case 42 => value$.`given` = decode$43(in$)
          case 43 => value$.`then` = decode$44(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$1(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$1(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$2(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$2(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$3(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$3(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$4(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$4(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$5(value$: _root_.scala.Float, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFloat(value$)
  }

  private def decode$5(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Float = {
    in$.readFloat()
  }

  private def encode$6(value$: _root_.scala.Double, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeDouble(value$)
  }

  private def decode$6(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double = {
    in$.readDouble()
  }

  private def encode$7(value$: _root_.scala.Array[_root_.scala.Byte], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBytes(value$)
  }

  private def decode$7(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Array[_root_.scala.Byte] = {
    val buffer$ = in$.readBytes(null)
    if (buffer$.hasArray && buffer$.arrayOffset() == 0 && buffer$.position() == 0 && buffer$.remaining() == buffer$.array().length) buffer$.array()
    else {
      val bytes$ = new _root_.scala.Array[Byte](buffer$.remaining())
      buffer$.get(bytes$)
      bytes$
    }
  }

  private def encode$8(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$8(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$9(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$9(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$10(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$10(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$11(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$11(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$12(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$12(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$13(value$: _root_.scala.Float, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFloat(value$)
  }

  private def decode$13(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Float = {
    in$.readFloat()
  }

  private def encode$14(value$: _root_.scala.Double, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeDouble(value$)
  }

  private def decode$14(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double = {
    in$.readDouble()
  }

  private def encode$15(value$: _root_.scala.Array[_root_.scala.Byte], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBytes(value$)
  }

  private def decode$15(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Array[_root_.scala.Byte] = {
    val buffer$ = in$.readBytes(null)
    if (buffer$.hasArray && buffer$.arrayOffset() == 0 && buffer$.position() == 0 && buffer$.remaining() == buffer$.array().length) buffer$.array()
    else {
      val bytes$ = new _root_.scala.Array[Byte](buffer$.remaining())
      buffer$.get(bytes$)
      bytes$
    }
  }

  private def encode$16(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$16(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$17(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$17(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$18(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$18(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$19(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$19(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$20(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$20(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$21(value$: _root_.scala.Float, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFloat(value$)
  }

  private def decode$21(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Float = {
    in$.readFloat()
  }

  private def encode$22(value$: _root_.scala.Double, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeDouble(value$)
  }

  private def decode$22(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double = {
    in$.readDouble()
  }

  private def encode$23(value$: _root_.scala.Array[_root_.scala.Byte], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBytes(value$)
  }

  private def decode$23(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Array[_root_.scala.Byte] = {
    val buffer$ = in$.readBytes(null)
    if (buffer$.hasArray && buffer$.arrayOffset() == 0 && buffer$.position() == 0 && buffer$.remaining() == buffer$.array().length) buffer$.array()
    else {
      val bytes$ = new _root_.scala.Array[Byte](buffer$.remaining())
      buffer$.get(bytes$)
      bytes$
    }
  }

  private def encode$24(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$24(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$25(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$25(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$26(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$26(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$27(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$27(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$28(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$28(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$29(value$: _root_.scala.Float, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFloat(value$)
  }

  private def decode$29(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Float = {
    in$.readFloat()
  }

  private def encode$30(value$: _root_.scala.Double, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeDouble(value$)
  }

  private def decode$30(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double = {
    in$.readDouble()
  }

  private def encode$31(value$: _root_.scala.Array[_root_.scala.Byte], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBytes(value$)
  }

  private def decode$31(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Array[_root_.scala.Byte] = {
    val buffer$ = in$.readBytes(null)
    if (buffer$.hasArray && buffer$.arrayOffset() == 0 && buffer$.position() == 0 && buffer$.remaining() == buffer$.array().length) buffer$.array()
    else {
      val bytes$ = new _root_.scala.Array[Byte](buffer$.remaining())
      buffer$.get(bytes$)
      bytes$
    }
  }

  private def encode$32(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$32(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$33(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$33(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$34(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$34(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$35(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$35(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$36(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$36(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$37(value$: _root_.scala.Float, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeFloat(value$)
  }

  private def decode$37(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Float = {
    in$.readFloat()
  }

  private def encode$38(value$: _root_.scala.Double, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeDouble(value$)
  }

  private def decode$38(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Double = {
    in$.readDouble()
  }

  private def encode$39(value$: _root_.scala.Array[_root_.scala.Byte], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBytes(value$)
  }

  private def decode$39(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Array[_root_.scala.Byte] = {
    val buffer$ = in$.readBytes(null)
    if (buffer$.hasArray && buffer$.arrayOffset() == 0 && buffer$.position() == 0 && buffer$.remaining() == buffer$.array().length) buffer$.array()
    else {
      val bytes$ = new _root_.scala.Array[Byte](buffer$.remaining())
      buffer$.get(bytes$)
      bytes$
    }
  }

  private def encode$40(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$40(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$41(value$: _root_.scala.Null, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeNull()
  }

  private def decode$41(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Null = {
    in$.readNull()
    null
  }

  private def encode$42(value$: _root_.scala.Boolean, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeBoolean(value$)
  }

  private def decode$42(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Boolean = {
    in$.readBoolean()
  }

  private def encode$43(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$43(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
  }

  private def encode$44(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$44(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }
}

object ReservedScala3 {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"ReservedScala3","namespace":"avro2s.test.reserved","fields":[{"name":"abstract","type":"null"},{"name":"case","type":"boolean"},{"name":"catch","type":"int"},{"name":"class","type":"long"},{"name":"def","type":"float"},{"name":"do","type":"double"},{"name":"else","type":"bytes"},{"name":"extends","type":"string"},{"name":"false","type":"null"},{"name":"final","type":"boolean"},{"name":"finally","type":"int"},{"name":"for","type":"long"},{"name":"forSome","type":"float"},{"name":"if","type":"double"},{"name":"implicit","type":"bytes"},{"name":"import","type":"string"},{"name":"lazy","type":"null"},{"name":"macro","type":"boolean"},{"name":"match","type":"int"},{"name":"new","type":"long"},{"name":"null","type":"float"},{"name":"object","type":"double"},{"name":"override","type":"bytes"},{"name":"package","type":"string"},{"name":"private","type":"null"},{"name":"protected","type":"boolean"},{"name":"return","type":"int"},{"name":"sealed","type":"long"},{"name":"super","type":"float"},{"name":"this","type":"double"},{"name":"throw","type":"bytes"},{"name":"trait","type":"string"},{"name":"try","type":"null"},{"name":"true","type":"boolean"},{"name":"type","type":"int"},{"name":"val","type":"long"},{"name":"var","type":"float"},{"name":"while","type":"double"},{"name":"with","type":"bytes"},{"name":"yield","type":"string"},{"name":"enum","type":"null"},{"name":"export","type":"boolean"},{"name":"given","type":"int"},{"name":"then","type":"long"}]}""")
}