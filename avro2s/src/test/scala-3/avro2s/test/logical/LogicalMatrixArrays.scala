/** GENERATED CODE */

package avro2s.test.logical

import scala.annotation.switch

/**
 * Every supported logical type in the arrays position.
 */
case class LogicalMatrixArrays(var _uuid: List[java.util.UUID], var _date: List[java.time.LocalDate], var _time_millis: List[java.time.LocalTime], var _time_micros: List[java.time.LocalTime], var _timestamp_millis: List[java.time.Instant], var _timestamp_micros: List[java.time.Instant], var _timestamp_nanos: List[java.time.Instant], var _local_timestamp_millis: List[java.time.LocalDateTime], var _local_timestamp_micros: List[java.time.LocalDateTime], var _local_timestamp_nanos: List[java.time.LocalDateTime], var _decimal_bytes: List[scala.math.BigDecimal], var _decimal_fixed: List[scala.math.BigDecimal], var _big_decimal: List[java.math.BigDecimal], var _duration: List[org.apache.avro.util.TimePeriod]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, List.empty)

  override def getSchema: org.apache.avro.Schema = LogicalMatrixArrays.SCHEMA$

  override def getSpecificData(): org.apache.avro.specific.SpecificData = LogicalMatrixArrays.MODEL$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _uuid match {
        case array =>
          {
            def toJavaArray$(input$: List[java.util.UUID]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  {element$.toString}
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 1 => _date match {
        case array =>
          {
            def toJavaArray$(input$: List[java.time.LocalDate]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  {element$.toEpochDay.toInt}.asInstanceOf[AnyRef]
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 2 => _time_millis match {
        case array =>
          {
            def toJavaArray$(input$: List[java.time.LocalTime]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  {(element$.toNanoOfDay / 1000000L).toInt}.asInstanceOf[AnyRef]
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 3 => _time_micros match {
        case array =>
          {
            def toJavaArray$(input$: List[java.time.LocalTime]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  {element$.toNanoOfDay / 1000L}.asInstanceOf[AnyRef]
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 4 => _timestamp_millis match {
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
      case 5 => _timestamp_micros match {
        case array =>
          {
            def toJavaArray$(input$: List[java.time.Instant]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  {(element$.getEpochSecond * 1000000L) + (element$.getNano / 1000L)}.asInstanceOf[AnyRef]
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 6 => _timestamp_nanos match {
        case array =>
          {
            def toJavaArray$(input$: List[java.time.Instant]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  {java.lang.Math.addExact(java.lang.Math.multiplyExact(element$.getEpochSecond, 1000000000L), element$.getNano.toLong)}.asInstanceOf[AnyRef]
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 7 => _local_timestamp_millis match {
        case array =>
          {
            def toJavaArray$(input$: List[java.time.LocalDateTime]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  {element$.atZone(java.time.ZoneId.of("UTC")).toInstant.toEpochMilli}.asInstanceOf[AnyRef]
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 8 => _local_timestamp_micros match {
        case array =>
          {
            def toJavaArray$(input$: List[java.time.LocalDateTime]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  {element$.atZone(java.time.ZoneId.of("UTC")).toInstant.getEpochSecond * 1000000L + element$.atZone(java.time.ZoneId.of("UTC")).toInstant.getNano / 1000L}.asInstanceOf[AnyRef]
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 9 => _local_timestamp_nanos match {
        case array =>
          {
            def toJavaArray$(input$: List[java.time.LocalDateTime]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  {java.lang.Math.addExact(java.lang.Math.multiplyExact(element$.toEpochSecond(java.time.ZoneOffset.UTC), 1000000000L), element$.getNano.toLong)}.asInstanceOf[AnyRef]
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 10 => _decimal_bytes match {
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
      case 11 => _decimal_fixed match {
        case array =>
          {
            def toJavaArray$(input$: List[scala.math.BigDecimal]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  {val decimal$ = (try element$.setScale(4).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + element$.scale + " as scale 4") }); if (decimal$.precision > 20) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$.precision + " as max precision 20"); val padded$ = new Array[Byte](16); if (decimal$.precision <= 18) { val unscaled$ = decimal$.movePointRight(4).longValueExact(); val width$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$ < 0) ~unscaled$ else unscaled$)) / 8 + 1; if (width$ > 16) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 16 + " bytes"); if (unscaled$ < 0) java.util.Arrays.fill(padded$, 0, 16 - width$, 0xFF.toByte); var rest$ = unscaled$; var at$ = 16 - 1; while (at$ >= 16 - width$) { padded$(at$) = (rest$ & 0xFFL).toByte; rest$ >>= 8; at$ -= 1 } } else { val unscaled$ = decimal$.unscaledValue().toByteArray; if (unscaled$.length > 16) throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + 16 + " bytes"); if (unscaled$(0) < 0) java.util.Arrays.fill(padded$, 0, 16 - unscaled$.length, 0xFF.toByte); System.arraycopy(unscaled$, 0, padded$, 16 - unscaled$.length, unscaled$.length) }; val result$ = new avro2s.test.logical.MatrixDecimalFixed(); result$.bytes(padded$); result$}
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 12 => _big_decimal match {
        case array =>
          {
            def toJavaArray$(input$: List[java.math.BigDecimal]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  {{ val decimal$ = element$; val unscaled$ = decimal$.unscaledValue().toByteArray(); val zigzagLength$ = (unscaled$.length << 1) ^ (unscaled$.length >> 31); val zigzagScale$ = (decimal$.scale << 1) ^ (decimal$.scale >> 31); var width$ = 1; var measure$ = zigzagLength$ >>> 7; while (measure$ != 0) { width$ += 1; measure$ >>>= 7 }; var scaleWidth$ = 1; measure$ = zigzagScale$ >>> 7; while (measure$ != 0) { scaleWidth$ += 1; measure$ >>>= 7 }; val encoded$ = new Array[Byte](width$ + unscaled$.length + scaleWidth$); var at$ = 0; var word$ = zigzagLength$; while ((word$ & ~0x7F) != 0) { encoded$(at$) = ((word$ | 0x80) & 0xFF).toByte; word$ >>>= 7; at$ += 1 }; encoded$(at$) = word$.toByte; at$ += 1; java.lang.System.arraycopy(unscaled$, 0, encoded$, at$, unscaled$.length); at$ += unscaled$.length; word$ = zigzagScale$; while ((word$ & ~0x7F) != 0) { encoded$(at$) = ((word$ | 0x80) & 0xFF).toByte; word$ >>>= 7; at$ += 1 }; encoded$(at$) = word$.toByte; java.nio.ByteBuffer.wrap(encoded$) }}
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case 13 => _duration match {
        case array =>
          {
            def toJavaArray$(input$: List[org.apache.avro.util.TimePeriod]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  {{ val period$ = element$; val result$ = new avro2s.test.logical.MatrixDurationFixed(); val bytes$ = result$.bytes(); var word$ = period$.getMonths.toInt; bytes$(0) = word$.toByte; bytes$(1) = (word$ >>> 8).toByte; bytes$(2) = (word$ >>> 16).toByte; bytes$(3) = (word$ >>> 24).toByte; word$ = period$.getDays.toInt; bytes$(4) = word$.toByte; bytes$(5) = (word$ >>> 8).toByte; bytes$(6) = (word$ >>> 16).toByte; bytes$(7) = (word$ >>> 24).toByte; word$ = period$.getMillis.toInt; bytes$(8) = word$.toByte; bytes$(9) = (word$ >>> 8).toByte; bytes$(10) = (word$ >>> 16).toByte; bytes$(11) = (word$ >>> 24).toByte; result$ }}
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(array)
          }
        }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._uuid = {
        val array = value.asInstanceOf[java.util.List[?]]
        {
          val builder$ = List.newBuilder[java.util.UUID]
          val iterator$ = array.iterator
          while (iterator$.hasNext) {
            val value = iterator$.next
            builder$ += {
              { val in$: Any = value; in$ match { case null => null; case converted$: java.util.UUID => converted$; case encoded$: CharSequence => {java.util.UUID.fromString(encoded$.toString)}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode uuid from " + other$.getClass.getName) } }
            }
          }
          builder$.result()
        }
      }
      case 1 => this._date = {
        val array = value.asInstanceOf[java.util.List[?]]
        {
          val builder$ = List.newBuilder[java.time.LocalDate]
          val iterator$ = array.iterator
          while (iterator$.hasNext) {
            val value = iterator$.next
            builder$ += {
              { val in$: Any = value; in$ match { case null => null; case converted$: java.time.LocalDate => converted$; case encoded$: Int => {java.time.LocalDate.ofEpochDay(encoded$)}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode date from " + other$.getClass.getName) } }
            }
          }
          builder$.result()
        }
      }
      case 2 => this._time_millis = {
        val array = value.asInstanceOf[java.util.List[?]]
        {
          val builder$ = List.newBuilder[java.time.LocalTime]
          val iterator$ = array.iterator
          while (iterator$.hasNext) {
            val value = iterator$.next
            builder$ += {
              { val in$: Any = value; in$ match { case null => null; case converted$: java.time.LocalTime => converted$; case encoded$: Int => {java.time.LocalTime.ofNanoOfDay(encoded$ * 1000000L)}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode time-millis from " + other$.getClass.getName) } }
            }
          }
          builder$.result()
        }
      }
      case 3 => this._time_micros = {
        val array = value.asInstanceOf[java.util.List[?]]
        {
          val builder$ = List.newBuilder[java.time.LocalTime]
          val iterator$ = array.iterator
          while (iterator$.hasNext) {
            val value = iterator$.next
            builder$ += {
              { val in$: Any = value; in$ match { case null => null; case converted$: java.time.LocalTime => converted$; case encoded$: Long => {java.time.LocalTime.ofNanoOfDay(encoded$ * 1000L)}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode time-micros from " + other$.getClass.getName) } }
            }
          }
          builder$.result()
        }
      }
      case 4 => this._timestamp_millis = {
        val array = value.asInstanceOf[java.util.List[?]]
        {
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
      case 5 => this._timestamp_micros = {
        val array = value.asInstanceOf[java.util.List[?]]
        {
          val builder$ = List.newBuilder[java.time.Instant]
          val iterator$ = array.iterator
          while (iterator$.hasNext) {
            val value = iterator$.next
            builder$ += {
              { val in$: Any = value; in$ match { case null => null; case converted$: java.time.Instant => converted$; case encoded$: Long => {java.time.Instant.ofEpochSecond(encoded$ / 1000000L, (encoded$ % 1000000L) * 1000L)}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode timestamp-micros from " + other$.getClass.getName) } }
            }
          }
          builder$.result()
        }
      }
      case 6 => this._timestamp_nanos = {
        val array = value.asInstanceOf[java.util.List[?]]
        {
          val builder$ = List.newBuilder[java.time.Instant]
          val iterator$ = array.iterator
          while (iterator$.hasNext) {
            val value = iterator$.next
            builder$ += {
              { val in$: Any = value; in$ match { case null => null; case converted$: java.time.Instant => converted$; case encoded$: Long => {java.time.Instant.ofEpochSecond(java.lang.Math.floorDiv(encoded$, 1000000000L), java.lang.Math.floorMod(encoded$, 1000000000L))}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode timestamp-nanos from " + other$.getClass.getName) } }
            }
          }
          builder$.result()
        }
      }
      case 7 => this._local_timestamp_millis = {
        val array = value.asInstanceOf[java.util.List[?]]
        {
          val builder$ = List.newBuilder[java.time.LocalDateTime]
          val iterator$ = array.iterator
          while (iterator$.hasNext) {
            val value = iterator$.next
            builder$ += {
              { val in$: Any = value; in$ match { case null => null; case converted$: java.time.LocalDateTime => converted$; case encoded$: Long => {java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(encoded$), java.time.ZoneId.of("UTC"))}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode local-timestamp-millis from " + other$.getClass.getName) } }
            }
          }
          builder$.result()
        }
      }
      case 8 => this._local_timestamp_micros = {
        val array = value.asInstanceOf[java.util.List[?]]
        {
          val builder$ = List.newBuilder[java.time.LocalDateTime]
          val iterator$ = array.iterator
          while (iterator$.hasNext) {
            val value = iterator$.next
            builder$ += {
              { val in$: Any = value; in$ match { case null => null; case converted$: java.time.LocalDateTime => converted$; case encoded$: Long => {java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(encoded$ / 1000000L, (encoded$ % 1000000L) * 1000L), java.time.ZoneId.of("UTC"))}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode local-timestamp-micros from " + other$.getClass.getName) } }
            }
          }
          builder$.result()
        }
      }
      case 9 => this._local_timestamp_nanos = {
        val array = value.asInstanceOf[java.util.List[?]]
        {
          val builder$ = List.newBuilder[java.time.LocalDateTime]
          val iterator$ = array.iterator
          while (iterator$.hasNext) {
            val value = iterator$.next
            builder$ += {
              { val in$: Any = value; in$ match { case null => null; case converted$: java.time.LocalDateTime => converted$; case encoded$: Long => {java.time.LocalDateTime.ofEpochSecond(java.lang.Math.floorDiv(encoded$, 1000000000L), java.lang.Math.floorMod(encoded$, 1000000000L).toInt, java.time.ZoneOffset.UTC)}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode local-timestamp-nanos from " + other$.getClass.getName) } }
            }
          }
          builder$.result()
        }
      }
      case 10 => this._decimal_bytes = {
        val array = value.asInstanceOf[java.util.List[?]]
        {
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
      case 11 => this._decimal_fixed = {
        val array = value.asInstanceOf[java.util.List[?]]
        {
          val builder$ = List.newBuilder[scala.math.BigDecimal]
          val iterator$ = array.iterator
          while (iterator$.hasNext) {
            val value = iterator$.next
            builder$ += {
              { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => scala.math.BigDecimal(converted$); case encoded$: org.apache.avro.generic.GenericFixed => {{ val raw$ = encoded$.bytes(); val sign$ = if (raw$(0) < 0) -1L else 0L; val signByte$ = sign$.toByte; var first$ = 0; while (first$ < raw$.length - 1 && raw$(first$) == signByte$ && ((raw$(first$ + 1) < 0) == (signByte$ < 0))) first$ += 1; if (raw$.length - first$ <= 8) { var unscaled$ = sign$; var index$ = first$; while (index$ < raw$.length) { unscaled$ = (unscaled$ << 8) | (raw$(index$) & 0xFFL); index$ += 1 }; scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$, 4)) } else scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(raw$), 4)) }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode decimal from " + other$.getClass.getName) } }
            }
          }
          builder$.result()
        }
      }
      case 12 => this._big_decimal = {
        val array = value.asInstanceOf[java.util.List[?]]
        {
          val builder$ = List.newBuilder[java.math.BigDecimal]
          val iterator$ = array.iterator
          while (iterator$.hasNext) {
            val value = iterator$.next
            builder$ += {
              { val in$: Any = value; in$ match { case null => null; case converted$: java.math.BigDecimal => converted$; case encoded$: java.nio.ByteBuffer => {{ val buffer$ = encoded$; var at$ = buffer$.position(); val length$ = { var shift$ = 0; var word$ = 0; var more$ = true; while (more$) { val chunk$ = buffer$.get(at$) & 0xFF; at$ += 1; word$ |= (chunk$ & 0x7F) << shift$; shift$ += 7; more$ = (chunk$ & 0x80) != 0 }; (word$ >>> 1) ^ -(word$ & 1) }; val unscaled$ = new Array[Byte](length$); var index$ = 0; while (index$ < length$) { unscaled$(index$) = buffer$.get(at$ + index$); index$ += 1 }; at$ += length$; val scale$ = { var shift$ = 0; var word$ = 0; var more$ = true; while (more$) { val chunk$ = buffer$.get(at$) & 0xFF; at$ += 1; word$ |= (chunk$ & 0x7F) << shift$; shift$ += 7; more$ = (chunk$ & 0x80) != 0 }; (word$ >>> 1) ^ -(word$ & 1) }; new java.math.BigDecimal(new java.math.BigInteger(unscaled$), scale$) }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode big-decimal from " + other$.getClass.getName) } }
            }
          }
          builder$.result()
        }
      }
      case 13 => this._duration = {
        val array = value.asInstanceOf[java.util.List[?]]
        {
          val builder$ = List.newBuilder[org.apache.avro.util.TimePeriod]
          val iterator$ = array.iterator
          while (iterator$.hasNext) {
            val value = iterator$.next
            builder$ += {
              { val in$: Any = value; in$ match { case null => null; case converted$: org.apache.avro.util.TimePeriod => converted$; case encoded$: org.apache.avro.generic.GenericFixed => {{ val bytes$ = encoded$.bytes(); org.apache.avro.util.TimePeriod.of(((bytes$(0) & 0xFFL) | ((bytes$(1) & 0xFFL) << 8) | ((bytes$(2) & 0xFFL) << 16) | ((bytes$(3) & 0xFFL) << 24)), ((bytes$(4) & 0xFFL) | ((bytes$(5) & 0xFFL) << 8) | ((bytes$(6) & 0xFFL) << 16) | ((bytes$(7) & 0xFFL) << 24)), ((bytes$(8) & 0xFFL) | ((bytes$(9) & 0xFFL) << 8) | ((bytes$(10) & 0xFFL) << 16) | ((bytes$(11) & 0xFFL) << 24))) }}; case other$ => throw new org.apache.avro.AvroRuntimeException("Cannot decode duration from " + other$.getClass.getName) } }
            }
          }
          builder$.result()
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object LogicalMatrixArrays {
  @scala.annotation.static val MODEL$: org.apache.avro.specific.SpecificData = new org.apache.avro.specific.SpecificData()
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"LogicalMatrixArrays","namespace":"avro2s.test.logical","doc":"Every supported logical type in the arrays position.","fields":[{"name":"_uuid","type":{"type":"array","items":{"type":"string","logicalType":"uuid"}}},{"name":"_date","type":{"type":"array","items":{"type":"int","logicalType":"date"}}},{"name":"_time_millis","type":{"type":"array","items":{"type":"int","logicalType":"time-millis"}}},{"name":"_time_micros","type":{"type":"array","items":{"type":"long","logicalType":"time-micros"}}},{"name":"_timestamp_millis","type":{"type":"array","items":{"type":"long","logicalType":"timestamp-millis"}}},{"name":"_timestamp_micros","type":{"type":"array","items":{"type":"long","logicalType":"timestamp-micros"}}},{"name":"_timestamp_nanos","type":{"type":"array","items":{"type":"long","logicalType":"timestamp-nanos"}}},{"name":"_local_timestamp_millis","type":{"type":"array","items":{"type":"long","logicalType":"local-timestamp-millis"}}},{"name":"_local_timestamp_micros","type":{"type":"array","items":{"type":"long","logicalType":"local-timestamp-micros"}}},{"name":"_local_timestamp_nanos","type":{"type":"array","items":{"type":"long","logicalType":"local-timestamp-nanos"}}},{"name":"_decimal_bytes","type":{"type":"array","items":{"type":"bytes","logicalType":"decimal","precision":10,"scale":2}}},{"name":"_decimal_fixed","type":{"type":"array","items":{"type":"fixed","name":"MatrixDecimalFixed","size":16,"logicalType":"decimal","precision":20,"scale":4}}},{"name":"_big_decimal","type":{"type":"array","items":{"type":"bytes","logicalType":"big-decimal"}}},{"name":"_duration","type":{"type":"array","items":{"type":"fixed","name":"MatrixDurationFixed","size":12,"logicalType":"duration"}}}]}""")
}