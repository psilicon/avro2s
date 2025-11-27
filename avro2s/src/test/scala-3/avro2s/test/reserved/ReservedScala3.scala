/** GENERATED CODE */

package avro2s.test.reserved

import scala.annotation.switch

case class ReservedScala3(var `abstract`: scala.Null, var `case`: Boolean, var `catch`: Int, var `class`: Long, var `def`: Float, var `do`: Double, var `else`: Array[Byte], var `extends`: String, var `false`: scala.Null, var `final`: Boolean, var `finally`: Int, var `for`: Long, var `forSome`: Float, var `if`: Double, var `implicit`: Array[Byte], var `import`: String, var `lazy`: scala.Null, var `macro`: Boolean, var `match`: Int, var `new`: Long, var `null`: Float, var `object`: Double, var `override`: Array[Byte], var `package`: String, var `private`: scala.Null, var `protected`: Boolean, var `return`: Int, var `sealed`: Long, var `super`: Float, var `this`: Double, var `throw`: Array[Byte], var `trait`: String, var `try`: scala.Null, var `true`: Boolean, var `type`: Int, var `val`: Long, var `var`: Float, var `while`: Double, var `with`: Array[Byte], var `yield`: String, var `enum`: scala.Null, var `export`: Boolean, var `given`: Int, var `then`: Long) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(null, false, 0, 0, 0, 0, Array[Byte](), "", null, false, 0, 0, 0, 0, Array[Byte](), "", null, false, 0, 0, 0, 0, Array[Byte](), "", null, false, 0, 0, 0, 0, Array[Byte](), "", null, false, 0, 0, 0, 0, Array[Byte](), "", null, false, 0, 0)

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
}

object ReservedScala3 {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"ReservedScala3","namespace":"avro2s.test.reserved","fields":[{"name":"abstract","type":"null"},{"name":"case","type":"boolean"},{"name":"catch","type":"int"},{"name":"class","type":"long"},{"name":"def","type":"float"},{"name":"do","type":"double"},{"name":"else","type":"bytes"},{"name":"extends","type":"string"},{"name":"false","type":"null"},{"name":"final","type":"boolean"},{"name":"finally","type":"int"},{"name":"for","type":"long"},{"name":"forSome","type":"float"},{"name":"if","type":"double"},{"name":"implicit","type":"bytes"},{"name":"import","type":"string"},{"name":"lazy","type":"null"},{"name":"macro","type":"boolean"},{"name":"match","type":"int"},{"name":"new","type":"long"},{"name":"null","type":"float"},{"name":"object","type":"double"},{"name":"override","type":"bytes"},{"name":"package","type":"string"},{"name":"private","type":"null"},{"name":"protected","type":"boolean"},{"name":"return","type":"int"},{"name":"sealed","type":"long"},{"name":"super","type":"float"},{"name":"this","type":"double"},{"name":"throw","type":"bytes"},{"name":"trait","type":"string"},{"name":"try","type":"null"},{"name":"true","type":"boolean"},{"name":"type","type":"int"},{"name":"val","type":"long"},{"name":"var","type":"float"},{"name":"while","type":"double"},{"name":"with","type":"bytes"},{"name":"yield","type":"string"},{"name":"enum","type":"null"},{"name":"export","type":"boolean"},{"name":"given","type":"int"},{"name":"then","type":"long"}]}""")
}