/** GENERATED CODE */

package avro2s.test.logical

import scala.annotation.switch

/**
 * Field names that collide with the locals the generated conversions declare. Avro forbids '$' in a name, so a generated local carrying that suffix can never be shadowed by a field; this record exists to keep it that way.
 */
case class CollidingNames(var decimal: scala.math.BigDecimal, var unscaled: scala.math.BigDecimal, var width: scala.math.BigDecimal, var encoded: scala.math.BigDecimal, var rest: scala.math.BigDecimal, var at: scala.math.BigDecimal, var buffer: scala.math.BigDecimal, var length: scala.math.BigDecimal, var offset: scala.math.BigDecimal, var padded: scala.math.BigDecimal, var result: scala.math.BigDecimal, var raw: scala.math.BigDecimal, var sign: scala.math.BigDecimal, var first: scala.math.BigDecimal, var period: org.apache.avro.util.TimePeriod, var word: org.apache.avro.util.TimePeriod, var builder: List[java.time.Instant], var iterator: List[scala.math.BigDecimal], var entry: Map[String, scala.math.BigDecimal], var value: Map[String, java.time.Instant], var key: List[String], var index: Array[Byte], var bytes: Array[Byte]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(CollidingNames.$default$0, CollidingNames.$default$0, CollidingNames.$default$0, CollidingNames.$default$0, CollidingNames.$default$0, CollidingNames.$default$0, CollidingNames.$default$0, CollidingNames.$default$0, CollidingNames.$default$0, CollidingNames.$default$0, CollidingNames.$default$0, CollidingNames.$default$0, CollidingNames.$default$0, CollidingNames.$default$0, CollidingNames.$default$1, CollidingNames.$default$1, List.empty, List.empty, Map.empty, Map.empty, List.empty, _root_.scala.Array.emptyByteArray, _root_.scala.Array.emptyByteArray)

  override def getSchema: org.apache.avro.Schema = CollidingNames.SCHEMA$

  override def getSpecificData(): org.apache.avro.specific.SpecificData = CollidingNames.MODEL$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => {val decimal$ = (try decimal.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + decimal.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; val encoded$ = new Array[Byte](width$); var rest$ = unscaled$; var at$ = width$ - 1; while (at$ >= 0) { encoded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$) } else java.nio.ByteBuffer.wrap(decimal$.unscaledValue().toByteArray)}.asInstanceOf[AnyRef]
      case 1 => {val decimal$ = (try unscaled.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + unscaled.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; val encoded$ = new Array[Byte](width$); var rest$ = unscaled$; var at$ = width$ - 1; while (at$ >= 0) { encoded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$) } else java.nio.ByteBuffer.wrap(decimal$.unscaledValue().toByteArray)}.asInstanceOf[AnyRef]
      case 2 => {val decimal$ = (try width.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + width.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; val encoded$ = new Array[Byte](width$); var rest$ = unscaled$; var at$ = width$ - 1; while (at$ >= 0) { encoded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$) } else java.nio.ByteBuffer.wrap(decimal$.unscaledValue().toByteArray)}.asInstanceOf[AnyRef]
      case 3 => {val decimal$ = (try encoded.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + encoded.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; val encoded$ = new Array[Byte](width$); var rest$ = unscaled$; var at$ = width$ - 1; while (at$ >= 0) { encoded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$) } else java.nio.ByteBuffer.wrap(decimal$.unscaledValue().toByteArray)}.asInstanceOf[AnyRef]
      case 4 => {val decimal$ = (try rest.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + rest.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; val encoded$ = new Array[Byte](width$); var rest$ = unscaled$; var at$ = width$ - 1; while (at$ >= 0) { encoded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$) } else java.nio.ByteBuffer.wrap(decimal$.unscaledValue().toByteArray)}.asInstanceOf[AnyRef]
      case 5 => {val decimal$ = (try at.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + at.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; val encoded$ = new Array[Byte](width$); var rest$ = unscaled$; var at$ = width$ - 1; while (at$ >= 0) { encoded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$) } else java.nio.ByteBuffer.wrap(decimal$.unscaledValue().toByteArray)}.asInstanceOf[AnyRef]
      case 6 => {val decimal$ = (try buffer.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + buffer.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; val encoded$ = new Array[Byte](width$); var rest$ = unscaled$; var at$ = width$ - 1; while (at$ >= 0) { encoded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$) } else java.nio.ByteBuffer.wrap(decimal$.unscaledValue().toByteArray)}.asInstanceOf[AnyRef]
      case 7 => {val decimal$ = (try length.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + length.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; val encoded$ = new Array[Byte](width$); var rest$ = unscaled$; var at$ = width$ - 1; while (at$ >= 0) { encoded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$) } else java.nio.ByteBuffer.wrap(decimal$.unscaledValue().toByteArray)}.asInstanceOf[AnyRef]
      case 8 => {val decimal$ = (try offset.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + offset.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; val encoded$ = new Array[Byte](width$); var rest$ = unscaled$; var at$ = width$ - 1; while (at$ >= 0) { encoded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$) } else java.nio.ByteBuffer.wrap(decimal$.unscaledValue().toByteArray)}.asInstanceOf[AnyRef]
      case 9 => {val decimal$ = (try padded.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + padded.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); val padded$ = new Array[Byte](8); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; if (width$ > 8) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 8 + " bytes"); if (unscaled$ < 0) java.util.Arrays.fill(padded$, 0, 8 - width$, 0xFF.toByte); var rest$ = unscaled$; var at$ = 8 - 1; while (at$ >= 8 - width$) { padded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 } } else { val unscaled$ = decimal$.unscaledValue().toByteArray; if (unscaled$.length > 8) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 8 + " bytes"); if (unscaled$(0) < 0) java.util.Arrays.fill(padded$, 0, 8 - unscaled$.length, 0xFF.toByte); System.arraycopy(unscaled$, 0, padded$, 8 - unscaled$.length, unscaled$.length) }; val result$ = new avro2s.test.logical.CollidePadded(); result$.bytes(padded$); result$}.asInstanceOf[AnyRef]
      case 10 => {val decimal$ = (try result.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + result.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); val padded$ = new Array[Byte](8); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; if (width$ > 8) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 8 + " bytes"); if (unscaled$ < 0) java.util.Arrays.fill(padded$, 0, 8 - width$, 0xFF.toByte); var rest$ = unscaled$; var at$ = 8 - 1; while (at$ >= 8 - width$) { padded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 } } else { val unscaled$ = decimal$.unscaledValue().toByteArray; if (unscaled$.length > 8) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 8 + " bytes"); if (unscaled$(0) < 0) java.util.Arrays.fill(padded$, 0, 8 - unscaled$.length, 0xFF.toByte); System.arraycopy(unscaled$, 0, padded$, 8 - unscaled$.length, unscaled$.length) }; val result$ = new avro2s.test.logical.CollideResult(); result$.bytes(padded$); result$}.asInstanceOf[AnyRef]
      case 11 => {val decimal$ = (try raw.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + raw.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); val padded$ = new Array[Byte](8); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; if (width$ > 8) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 8 + " bytes"); if (unscaled$ < 0) java.util.Arrays.fill(padded$, 0, 8 - width$, 0xFF.toByte); var rest$ = unscaled$; var at$ = 8 - 1; while (at$ >= 8 - width$) { padded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 } } else { val unscaled$ = decimal$.unscaledValue().toByteArray; if (unscaled$.length > 8) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 8 + " bytes"); if (unscaled$(0) < 0) java.util.Arrays.fill(padded$, 0, 8 - unscaled$.length, 0xFF.toByte); System.arraycopy(unscaled$, 0, padded$, 8 - unscaled$.length, unscaled$.length) }; val result$ = new avro2s.test.logical.CollideRaw(); result$.bytes(padded$); result$}.asInstanceOf[AnyRef]
      case 12 => {val decimal$ = (try sign.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + sign.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); val padded$ = new Array[Byte](8); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; if (width$ > 8) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 8 + " bytes"); if (unscaled$ < 0) java.util.Arrays.fill(padded$, 0, 8 - width$, 0xFF.toByte); var rest$ = unscaled$; var at$ = 8 - 1; while (at$ >= 8 - width$) { padded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 } } else { val unscaled$ = decimal$.unscaledValue().toByteArray; if (unscaled$.length > 8) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 8 + " bytes"); if (unscaled$(0) < 0) java.util.Arrays.fill(padded$, 0, 8 - unscaled$.length, 0xFF.toByte); System.arraycopy(unscaled$, 0, padded$, 8 - unscaled$.length, unscaled$.length) }; val result$ = new avro2s.test.logical.CollideSign(); result$.bytes(padded$); result$}.asInstanceOf[AnyRef]
      case 13 => {val decimal$ = (try first.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + first.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); val padded$ = new Array[Byte](8); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; if (width$ > 8) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 8 + " bytes"); if (unscaled$ < 0) java.util.Arrays.fill(padded$, 0, 8 - width$, 0xFF.toByte); var rest$ = unscaled$; var at$ = 8 - 1; while (at$ >= 8 - width$) { padded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 } } else { val unscaled$ = decimal$.unscaledValue().toByteArray; if (unscaled$.length > 8) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 8 + " bytes"); if (unscaled$(0) < 0) java.util.Arrays.fill(padded$, 0, 8 - unscaled$.length, 0xFF.toByte); System.arraycopy(unscaled$, 0, padded$, 8 - unscaled$.length, unscaled$.length) }; val result$ = new avro2s.test.logical.CollideFirst(); result$.bytes(padded$); result$}.asInstanceOf[AnyRef]
      case 14 => {{ val period$ = period; val result$ = new avro2s.test.logical.CollidePeriod(); val bytes$ = result$.bytes(); var word$ = period$.getMonths.toInt; bytes$(0) = word$.toByte; bytes$(1) = (word$ >>> 8).toByte; bytes$(2) = (word$ >>> 16).toByte; bytes$(3) = (word$ >>> 24).toByte; word$ = period$.getDays.toInt; bytes$(4) = word$.toByte; bytes$(5) = (word$ >>> 8).toByte; bytes$(6) = (word$ >>> 16).toByte; bytes$(7) = (word$ >>> 24).toByte; word$ = period$.getMillis.toInt; bytes$(8) = word$.toByte; bytes$(9) = (word$ >>> 8).toByte; bytes$(10) = (word$ >>> 16).toByte; bytes$(11) = (word$ >>> 24).toByte; result$ }}.asInstanceOf[AnyRef]
      case 15 => {{ val period$ = word; val result$ = new avro2s.test.logical.CollideWord(); val bytes$ = result$.bytes(); var word$ = period$.getMonths.toInt; bytes$(0) = word$.toByte; bytes$(1) = (word$ >>> 8).toByte; bytes$(2) = (word$ >>> 16).toByte; bytes$(3) = (word$ >>> 24).toByte; word$ = period$.getDays.toInt; bytes$(4) = word$.toByte; bytes$(5) = (word$ >>> 8).toByte; bytes$(6) = (word$ >>> 16).toByte; bytes$(7) = (word$ >>> 24).toByte; word$ = period$.getMillis.toInt; bytes$(8) = word$.toByte; bytes$(9) = (word$ >>> 8).toByte; bytes$(10) = (word$ >>> 16).toByte; bytes$(11) = (word$ >>> 24).toByte; result$ }}.asInstanceOf[AnyRef]
      case 16 => builder match {
        case array =>
          {
            def toJavaArray$(input$: List[java.time.Instant]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  {element$.toEpochMilli}.asInstanceOf[AnyRef]
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 17 => iterator match {
        case array =>
          {
            def toJavaArray$(input$: List[scala.math.BigDecimal]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  {val decimal$ = (try element$.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + element$.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; val encoded$ = new Array[Byte](width$); var rest$ = unscaled$; var at$ = width$ - 1; while (at$ >= 0) { encoded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$) } else java.nio.ByteBuffer.wrap(decimal$.unscaledValue().toByteArray)}
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 18 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = entry.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        entry.foreach { kvp =>
          val key = kvp._1
          val value = {
            {val decimal$ = (try kvp._2.setScale(2).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + kvp._2.scale + " as scale 2") }); if (decimal$.precision > 10) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 10"); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(2).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; val encoded$ = new Array[Byte](width$); var rest$ = unscaled$; var at$ = width$ - 1; while (at$ >= 0) { encoded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$) } else java.nio.ByteBuffer.wrap(decimal$.unscaledValue().toByteArray)}
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 19 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = value.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        value.foreach { kvp =>
          val key = kvp._1
          val value = {
            {kvp._2.toEpochMilli}
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 20 => key match {
        case array =>
          {
            def toJavaArray$(input$: List[AnyRef]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = if (input$.isEmpty) new java.util.ArrayList[AnyRef]() else new java.util.ArrayList[AnyRef](input$.size)
              while (remaining$.nonEmpty) {
                result$.add(remaining$.head)
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array.asInstanceOf[List[AnyRef]])
          }
        }
      case 21 => java.nio.ByteBuffer.wrap(index).asInstanceOf[AnyRef]
      case 22 => java.nio.ByteBuffer.wrap(bytes).asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.decimal = { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => scala.math.BigDecimal(converted$); case encoded$: java.nio.ByteBuffer => {{ val buffer$ = encoded$; val length$ = buffer$.remaining; if (length$ >= 1 && length$ <= 8) { val offset$ = buffer$.position(); var unscaled$ = if (buffer$.get(offset$) < 0) -1L else 0L; var index$ = 0; while (index$ < length$) { unscaled$ = (unscaled$ << 8) | (buffer$.get(offset$ + index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else { val offset$ = buffer$.position(); val bytes$ = new Array[Byte](length$); buffer$.get(bytes$); (buffer$: java.nio.Buffer).position(offset$); scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$), 2)) } }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode decimal from " + other$.getClass.getName) } }
      case 1 => this.unscaled = { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => scala.math.BigDecimal(converted$); case encoded$: java.nio.ByteBuffer => {{ val buffer$ = encoded$; val length$ = buffer$.remaining; if (length$ >= 1 && length$ <= 8) { val offset$ = buffer$.position(); var unscaled$ = if (buffer$.get(offset$) < 0) -1L else 0L; var index$ = 0; while (index$ < length$) { unscaled$ = (unscaled$ << 8) | (buffer$.get(offset$ + index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else { val offset$ = buffer$.position(); val bytes$ = new Array[Byte](length$); buffer$.get(bytes$); (buffer$: java.nio.Buffer).position(offset$); scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$), 2)) } }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode decimal from " + other$.getClass.getName) } }
      case 2 => this.width = { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => scala.math.BigDecimal(converted$); case encoded$: java.nio.ByteBuffer => {{ val buffer$ = encoded$; val length$ = buffer$.remaining; if (length$ >= 1 && length$ <= 8) { val offset$ = buffer$.position(); var unscaled$ = if (buffer$.get(offset$) < 0) -1L else 0L; var index$ = 0; while (index$ < length$) { unscaled$ = (unscaled$ << 8) | (buffer$.get(offset$ + index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else { val offset$ = buffer$.position(); val bytes$ = new Array[Byte](length$); buffer$.get(bytes$); (buffer$: java.nio.Buffer).position(offset$); scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$), 2)) } }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode decimal from " + other$.getClass.getName) } }
      case 3 => this.encoded = { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => scala.math.BigDecimal(converted$); case encoded$: java.nio.ByteBuffer => {{ val buffer$ = encoded$; val length$ = buffer$.remaining; if (length$ >= 1 && length$ <= 8) { val offset$ = buffer$.position(); var unscaled$ = if (buffer$.get(offset$) < 0) -1L else 0L; var index$ = 0; while (index$ < length$) { unscaled$ = (unscaled$ << 8) | (buffer$.get(offset$ + index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else { val offset$ = buffer$.position(); val bytes$ = new Array[Byte](length$); buffer$.get(bytes$); (buffer$: java.nio.Buffer).position(offset$); scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$), 2)) } }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode decimal from " + other$.getClass.getName) } }
      case 4 => this.rest = { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => scala.math.BigDecimal(converted$); case encoded$: java.nio.ByteBuffer => {{ val buffer$ = encoded$; val length$ = buffer$.remaining; if (length$ >= 1 && length$ <= 8) { val offset$ = buffer$.position(); var unscaled$ = if (buffer$.get(offset$) < 0) -1L else 0L; var index$ = 0; while (index$ < length$) { unscaled$ = (unscaled$ << 8) | (buffer$.get(offset$ + index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else { val offset$ = buffer$.position(); val bytes$ = new Array[Byte](length$); buffer$.get(bytes$); (buffer$: java.nio.Buffer).position(offset$); scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$), 2)) } }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode decimal from " + other$.getClass.getName) } }
      case 5 => this.at = { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => scala.math.BigDecimal(converted$); case encoded$: java.nio.ByteBuffer => {{ val buffer$ = encoded$; val length$ = buffer$.remaining; if (length$ >= 1 && length$ <= 8) { val offset$ = buffer$.position(); var unscaled$ = if (buffer$.get(offset$) < 0) -1L else 0L; var index$ = 0; while (index$ < length$) { unscaled$ = (unscaled$ << 8) | (buffer$.get(offset$ + index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else { val offset$ = buffer$.position(); val bytes$ = new Array[Byte](length$); buffer$.get(bytes$); (buffer$: java.nio.Buffer).position(offset$); scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$), 2)) } }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode decimal from " + other$.getClass.getName) } }
      case 6 => this.buffer = { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => scala.math.BigDecimal(converted$); case encoded$: java.nio.ByteBuffer => {{ val buffer$ = encoded$; val length$ = buffer$.remaining; if (length$ >= 1 && length$ <= 8) { val offset$ = buffer$.position(); var unscaled$ = if (buffer$.get(offset$) < 0) -1L else 0L; var index$ = 0; while (index$ < length$) { unscaled$ = (unscaled$ << 8) | (buffer$.get(offset$ + index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else { val offset$ = buffer$.position(); val bytes$ = new Array[Byte](length$); buffer$.get(bytes$); (buffer$: java.nio.Buffer).position(offset$); scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$), 2)) } }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode decimal from " + other$.getClass.getName) } }
      case 7 => this.length = { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => scala.math.BigDecimal(converted$); case encoded$: java.nio.ByteBuffer => {{ val buffer$ = encoded$; val length$ = buffer$.remaining; if (length$ >= 1 && length$ <= 8) { val offset$ = buffer$.position(); var unscaled$ = if (buffer$.get(offset$) < 0) -1L else 0L; var index$ = 0; while (index$ < length$) { unscaled$ = (unscaled$ << 8) | (buffer$.get(offset$ + index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else { val offset$ = buffer$.position(); val bytes$ = new Array[Byte](length$); buffer$.get(bytes$); (buffer$: java.nio.Buffer).position(offset$); scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$), 2)) } }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode decimal from " + other$.getClass.getName) } }
      case 8 => this.offset = { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => scala.math.BigDecimal(converted$); case encoded$: java.nio.ByteBuffer => {{ val buffer$ = encoded$; val length$ = buffer$.remaining; if (length$ >= 1 && length$ <= 8) { val offset$ = buffer$.position(); var unscaled$ = if (buffer$.get(offset$) < 0) -1L else 0L; var index$ = 0; while (index$ < length$) { unscaled$ = (unscaled$ << 8) | (buffer$.get(offset$ + index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else { val offset$ = buffer$.position(); val bytes$ = new Array[Byte](length$); buffer$.get(bytes$); (buffer$: java.nio.Buffer).position(offset$); scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$), 2)) } }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode decimal from " + other$.getClass.getName) } }
      case 9 => this.padded = { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => scala.math.BigDecimal(converted$); case encoded$: org.apache.avro.generic.GenericFixed => {{ val raw$ = encoded$.bytes(); val sign$ = if (raw$(0) < 0) -1L else 0L; val signByte$ = sign$.toByte; var first$ = 0; while (first$ < raw$.length - 1 && raw$(first$) == signByte$ && ((raw$(first$ + 1) < 0) == (signByte$ < 0))) first$ += 1; if (raw$.length - first$ <= 8) { var unscaled$ = sign$; var index$ = first$; while (index$ < raw$.length) { unscaled$ = (unscaled$ << 8) | (raw$(index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(raw$), 2)) }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode decimal from " + other$.getClass.getName) } }
      case 10 => this.result = { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => scala.math.BigDecimal(converted$); case encoded$: org.apache.avro.generic.GenericFixed => {{ val raw$ = encoded$.bytes(); val sign$ = if (raw$(0) < 0) -1L else 0L; val signByte$ = sign$.toByte; var first$ = 0; while (first$ < raw$.length - 1 && raw$(first$) == signByte$ && ((raw$(first$ + 1) < 0) == (signByte$ < 0))) first$ += 1; if (raw$.length - first$ <= 8) { var unscaled$ = sign$; var index$ = first$; while (index$ < raw$.length) { unscaled$ = (unscaled$ << 8) | (raw$(index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(raw$), 2)) }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode decimal from " + other$.getClass.getName) } }
      case 11 => this.raw = { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => scala.math.BigDecimal(converted$); case encoded$: org.apache.avro.generic.GenericFixed => {{ val raw$ = encoded$.bytes(); val sign$ = if (raw$(0) < 0) -1L else 0L; val signByte$ = sign$.toByte; var first$ = 0; while (first$ < raw$.length - 1 && raw$(first$) == signByte$ && ((raw$(first$ + 1) < 0) == (signByte$ < 0))) first$ += 1; if (raw$.length - first$ <= 8) { var unscaled$ = sign$; var index$ = first$; while (index$ < raw$.length) { unscaled$ = (unscaled$ << 8) | (raw$(index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(raw$), 2)) }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode decimal from " + other$.getClass.getName) } }
      case 12 => this.sign = { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => scala.math.BigDecimal(converted$); case encoded$: org.apache.avro.generic.GenericFixed => {{ val raw$ = encoded$.bytes(); val sign$ = if (raw$(0) < 0) -1L else 0L; val signByte$ = sign$.toByte; var first$ = 0; while (first$ < raw$.length - 1 && raw$(first$) == signByte$ && ((raw$(first$ + 1) < 0) == (signByte$ < 0))) first$ += 1; if (raw$.length - first$ <= 8) { var unscaled$ = sign$; var index$ = first$; while (index$ < raw$.length) { unscaled$ = (unscaled$ << 8) | (raw$(index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(raw$), 2)) }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode decimal from " + other$.getClass.getName) } }
      case 13 => this.first = { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => scala.math.BigDecimal(converted$); case encoded$: org.apache.avro.generic.GenericFixed => {{ val raw$ = encoded$.bytes(); val sign$ = if (raw$(0) < 0) -1L else 0L; val signByte$ = sign$.toByte; var first$ = 0; while (first$ < raw$.length - 1 && raw$(first$) == signByte$ && ((raw$(first$ + 1) < 0) == (signByte$ < 0))) first$ += 1; if (raw$.length - first$ <= 8) { var unscaled$ = sign$; var index$ = first$; while (index$ < raw$.length) { unscaled$ = (unscaled$ << 8) | (raw$(index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(raw$), 2)) }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode decimal from " + other$.getClass.getName) } }
      case 14 => this.period = { val in$: Any = value; in$ match { case null => null; case converted$: org.apache.avro.util.TimePeriod => converted$; case encoded$: org.apache.avro.generic.GenericFixed => {{ val bytes$ = encoded$.bytes(); org.apache.avro.util.TimePeriod.of(((bytes$(0) & 0xFFL) | ((bytes$(1) & 0xFFL) << 8) | ((bytes$(2) & 0xFFL) << 16) | ((bytes$(3) & 0xFFL) << 24)), ((bytes$(4) & 0xFFL) | ((bytes$(5) & 0xFFL) << 8) | ((bytes$(6) & 0xFFL) << 16) | ((bytes$(7) & 0xFFL) << 24)), ((bytes$(8) & 0xFFL) | ((bytes$(9) & 0xFFL) << 8) | ((bytes$(10) & 0xFFL) << 16) | ((bytes$(11) & 0xFFL) << 24))) }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode duration from " + other$.getClass.getName) } }
      case 15 => this.word = { val in$: Any = value; in$ match { case null => null; case converted$: org.apache.avro.util.TimePeriod => converted$; case encoded$: org.apache.avro.generic.GenericFixed => {{ val bytes$ = encoded$.bytes(); org.apache.avro.util.TimePeriod.of(((bytes$(0) & 0xFFL) | ((bytes$(1) & 0xFFL) << 8) | ((bytes$(2) & 0xFFL) << 16) | ((bytes$(3) & 0xFFL) << 24)), ((bytes$(4) & 0xFFL) | ((bytes$(5) & 0xFFL) << 8) | ((bytes$(6) & 0xFFL) << 16) | ((bytes$(7) & 0xFFL) << 24)), ((bytes$(8) & 0xFFL) | ((bytes$(9) & 0xFFL) << 8) | ((bytes$(10) & 0xFFL) << 16) | ((bytes$(11) & 0xFFL) << 24))) }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode duration from " + other$.getClass.getName) } }
      case 16 => this.builder = {
        value match {
          case array: java.util.List[_] =>
            val builder$ = List.newBuilder[java.time.Instant]
            val iterator$ = array.iterator
            while (iterator$.hasNext) {
              val value = iterator$.next
              builder$ += {
                { val in$: Any = value; in$ match { case null => null; case converted$: java.time.Instant => converted$; case encoded$: Long => {java.time.Instant.ofEpochMilli(encoded$)}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode timestamp-millis from " + other$.getClass.getName) } }
              }
            }
            builder$.result()
          }
      }
      case 17 => this.iterator = {
        value match {
          case array: java.util.List[_] =>
            val builder$ = List.newBuilder[scala.math.BigDecimal]
            val iterator$ = array.iterator
            while (iterator$.hasNext) {
              val value = iterator$.next
              builder$ += {
                { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => scala.math.BigDecimal(converted$); case encoded$: java.nio.ByteBuffer => {{ val buffer$ = encoded$; val length$ = buffer$.remaining; if (length$ >= 1 && length$ <= 8) { val offset$ = buffer$.position(); var unscaled$ = if (buffer$.get(offset$) < 0) -1L else 0L; var index$ = 0; while (index$ < length$) { unscaled$ = (unscaled$ << 8) | (buffer$.get(offset$ + index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else { val offset$ = buffer$.position(); val bytes$ = new Array[Byte](length$); buffer$.get(bytes$); (buffer$: java.nio.Buffer).position(offset$); scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$), 2)) } }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode decimal from " + other$.getClass.getName) } }
              }
            }
            builder$.result()
          }
      }
      case 18 => this.entry = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, scala.math.BigDecimal] else {
              val builder$ = Map.newBuilder[String, scala.math.BigDecimal]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => scala.math.BigDecimal(converted$); case encoded$: java.nio.ByteBuffer => {{ val buffer$ = encoded$; val length$ = buffer$.remaining; if (length$ >= 1 && length$ <= 8) { val offset$ = buffer$.position(); var unscaled$ = if (buffer$.get(offset$) < 0) -1L else 0L; var index$ = 0; while (index$ < length$) { unscaled$ = (unscaled$ << 8) | (buffer$.get(offset$ + index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 2)) } else { val offset$ = buffer$.position(); val bytes$ = new Array[Byte](length$); buffer$.get(bytes$); (buffer$: java.nio.Buffer).position(offset$); scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$), 2)) } }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode decimal from " + other$.getClass.getName) } }
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 19 => this.value = {
        value match {
          case map: java.util.Map[_,_] => {
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, java.time.Instant] else {
              val builder$ = Map.newBuilder[String, java.time.Instant]
              val iterator$ = map.entrySet.iterator
              while (iterator$.hasNext) {
                val entry$ = iterator$.next
                val key = entry$.getKey.toString
                val value = entry$.getValue
                builder$ += ((key, {
                  { val in$: Any = value; in$ match { case null => null; case converted$: java.time.Instant => converted$; case encoded$: Long => {java.time.Instant.ofEpochMilli(encoded$)}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode timestamp-millis from " + other$.getClass.getName) } }
                }))
              }
              builder$.result()
            }
          }
        }
      }
      case 20 => this.key = {
        value match {
          case array: java.util.List[_] =>
            val builder$ = List.newBuilder[String]
            val iterator$ = array.iterator
            while (iterator$.hasNext) {
              val value = iterator$.next
              builder$ += {
                value.toString
              }
            }
            builder$.result()
          }
      }
      case 21 => this.index = {
        value match {
          case buffer: java.nio.ByteBuffer => val start$ = buffer.position(); val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); (buffer: java.nio.Buffer).position(start$); array
        }
      }
      case 22 => this.bytes = {
        value match {
          case buffer: java.nio.ByteBuffer => val start$ = buffer.position(); val array = Array.ofDim[Byte](buffer.remaining()); buffer.get(array); (buffer: java.nio.Buffer).position(start$); array
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object CollidingNames {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"CollidingNames","namespace":"avro2s.test.logical","doc":"Field names that collide with the locals the generated conversions declare. Avro forbids '$' in a name, so a generated local carrying that suffix can never be shadowed by a field; this record exists to keep it that way.","fields":[{"name":"decimal","type":{"type":"bytes","logicalType":"decimal","precision":10,"scale":2}},{"name":"unscaled","type":{"type":"bytes","logicalType":"decimal","precision":10,"scale":2}},{"name":"width","type":{"type":"bytes","logicalType":"decimal","precision":10,"scale":2}},{"name":"encoded","type":{"type":"bytes","logicalType":"decimal","precision":10,"scale":2}},{"name":"rest","type":{"type":"bytes","logicalType":"decimal","precision":10,"scale":2}},{"name":"at","type":{"type":"bytes","logicalType":"decimal","precision":10,"scale":2}},{"name":"buffer","type":{"type":"bytes","logicalType":"decimal","precision":10,"scale":2}},{"name":"length","type":{"type":"bytes","logicalType":"decimal","precision":10,"scale":2}},{"name":"offset","type":{"type":"bytes","logicalType":"decimal","precision":10,"scale":2}},{"name":"padded","type":{"type":"fixed","name":"CollidePadded","size":8,"logicalType":"decimal","precision":10,"scale":2}},{"name":"result","type":{"type":"fixed","name":"CollideResult","size":8,"logicalType":"decimal","precision":10,"scale":2}},{"name":"raw","type":{"type":"fixed","name":"CollideRaw","size":8,"logicalType":"decimal","precision":10,"scale":2}},{"name":"sign","type":{"type":"fixed","name":"CollideSign","size":8,"logicalType":"decimal","precision":10,"scale":2}},{"name":"first","type":{"type":"fixed","name":"CollideFirst","size":8,"logicalType":"decimal","precision":10,"scale":2}},{"name":"period","type":{"type":"fixed","name":"CollidePeriod","size":12,"logicalType":"duration"}},{"name":"word","type":{"type":"fixed","name":"CollideWord","size":12,"logicalType":"duration"}},{"name":"builder","type":{"type":"array","items":{"type":"long","logicalType":"timestamp-millis"}}},{"name":"iterator","type":{"type":"array","items":{"type":"bytes","logicalType":"decimal","precision":10,"scale":2}}},{"name":"entry","type":{"type":"map","values":{"type":"bytes","logicalType":"decimal","precision":10,"scale":2}}},{"name":"value","type":{"type":"map","values":{"type":"long","logicalType":"timestamp-millis"}}},{"name":"key","type":{"type":"array","items":"string"}},{"name":"index","type":"bytes"},{"name":"bytes","type":"bytes"}]}""")
  val $DurationConversion: org.apache.avro.Conversion[_] = new org.apache.avro.Conversions.DurationConversion()
  val $TimestampMillisConversion: org.apache.avro.Conversion[_] = new org.apache.avro.data.TimeConversions.TimestampMillisConversion()
  val MODEL$: org.apache.avro.specific.SpecificData = {
    val model = new org.apache.avro.specific.SpecificData()
    model.addLogicalTypeConversion($DurationConversion)
    model.addLogicalTypeConversion($TimestampMillisConversion)
    model
  }
  private val $default$0: scala.math.BigDecimal = scala.math.BigDecimal(0)
  private val $default$1: org.apache.avro.util.TimePeriod = org.apache.avro.util.TimePeriod.of(0L, 0L, 0L)
}