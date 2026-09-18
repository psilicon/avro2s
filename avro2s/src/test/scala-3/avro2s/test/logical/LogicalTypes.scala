/** GENERATED CODE */

package avro2s.test.logical

import scala.annotation.switch

case class LogicalTypes(var _uuid: java.util.UUID, var _date: java.time.LocalDate, var _time_millis: java.time.LocalTime, var _time_micros: java.time.LocalTime, var _timestamp_millis: java.time.Instant, var _timestamp_micros: java.time.Instant, var _local_timestamp_millis: java.time.LocalDateTime, var _local_timestamp_micros: java.time.LocalDateTime) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(LogicalTypes.$default$0, LogicalTypes.$default$1, LogicalTypes.$default$2, LogicalTypes.$default$2, LogicalTypes.$default$3, LogicalTypes.$default$4, LogicalTypes.$default$5, LogicalTypes.$default$6)

  override def getSchema: org.apache.avro.Schema = LogicalTypes.SCHEMA$

  override def getSpecificData(): org.apache.avro.specific.SpecificData = LogicalTypes.MODEL$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _uuid.asInstanceOf[AnyRef]
      case 1 => _date.asInstanceOf[AnyRef]
      case 2 => _time_millis.asInstanceOf[AnyRef]
      case 3 => _time_micros.asInstanceOf[AnyRef]
      case 4 => _timestamp_millis.asInstanceOf[AnyRef]
      case 5 => _timestamp_micros.asInstanceOf[AnyRef]
      case 6 => _local_timestamp_millis.asInstanceOf[AnyRef]
      case 7 => _local_timestamp_micros.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._uuid = {
        value.asInstanceOf[java.util.UUID]
      }
      case 1 => this._date = {
        value.asInstanceOf[java.time.LocalDate]
      }
      case 2 => this._time_millis = {
        value.asInstanceOf[java.time.LocalTime]
      }
      case 3 => this._time_micros = {
        value.asInstanceOf[java.time.LocalTime]
      }
      case 4 => this._timestamp_millis = {
        value.asInstanceOf[java.time.Instant]
      }
      case 5 => this._timestamp_micros = {
        value.asInstanceOf[java.time.Instant]
      }
      case 6 => this._local_timestamp_millis = {
        value.asInstanceOf[java.time.LocalDateTime]
      }
      case 7 => this._local_timestamp_micros = {
        value.asInstanceOf[java.time.LocalDateTime]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def getConversion(field: Int): org.apache.avro.Conversion[?] = {
    (field: @switch) match {
      case 0 => LogicalTypes.$UUIDConversion
      case 1 => LogicalTypes.$DateConversion
      case 2 => LogicalTypes.$TimeMillisConversion
      case 3 => LogicalTypes.$TimeMicrosConversion
      case 4 => LogicalTypes.$TimestampMillisConversion
      case 5 => LogicalTypes.$TimestampMicrosConversion
      case 6 => LogicalTypes.$LocalTimestampMillisConversion
      case 7 => LogicalTypes.$LocalTimestampMicrosConversion
      case _ => null
    }
  }

  override protected def hasCustomCoders(): Boolean = true
  override def customEncode(out$: _root_.org.apache.avro.io.Encoder): Unit = encode$0(this, out$)
  override def customDecode(in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = decodeRecord$0(this, in$)

  private def encode$0(value$: _root_.avro2s.test.logical.LogicalTypes, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`_uuid`, out$)
    encode$2(value$.`_date`, out$)
    encode$3(value$.`_time_millis`, out$)
    encode$4(value$.`_time_micros`, out$)
    encode$5(value$.`_timestamp_millis`, out$)
    encode$6(value$.`_timestamp_micros`, out$)
    encode$7(value$.`_local_timestamp_millis`, out$)
    encode$8(value$.`_local_timestamp_micros`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.logical.LogicalTypes): _root_.avro2s.test.logical.LogicalTypes = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.logical.LogicalTypes() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.logical.LogicalTypes, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_uuid` = decode$1(in$)
      value$.`_date` = decode$2(in$)
      value$.`_time_millis` = decode$3(in$)
      value$.`_time_micros` = decode$4(in$)
      value$.`_timestamp_millis` = decode$5(in$)
      value$.`_timestamp_micros` = decode$6(in$)
      value$.`_local_timestamp_millis` = decode$7(in$)
      value$.`_local_timestamp_micros` = decode$8(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_uuid` = decode$1(in$)
          case 1 => value$.`_date` = decode$2(in$)
          case 2 => value$.`_time_millis` = decode$3(in$)
          case 3 => value$.`_time_micros` = decode$4(in$)
          case 4 => value$.`_timestamp_millis` = decode$5(in$)
          case 5 => value$.`_timestamp_micros` = decode$6(in$)
          case 6 => value$.`_local_timestamp_millis` = decode$7(in$)
          case 7 => value$.`_local_timestamp_micros` = decode$8(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$1(value$: java.util.UUID, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.LogicalTypes.customConversion$1.toCharSequence(value$, _root_.avro2s.test.logical.LogicalTypes.customSchema$1, _root_.avro2s.test.logical.LogicalTypes.customSchema$1.getLogicalType)
    out$.writeString(raw$)
  }

  private def decode$1(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.util.UUID = {
    _root_.avro2s.test.logical.LogicalTypes.customConversion$1.fromCharSequence(in$.readString(), _root_.avro2s.test.logical.LogicalTypes.customSchema$1, _root_.avro2s.test.logical.LogicalTypes.customSchema$1.getLogicalType)
  }

  private def encode$2(value$: java.time.LocalDate, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.LogicalTypes.customConversion$2.toInt(value$, _root_.avro2s.test.logical.LogicalTypes.customSchema$2, _root_.avro2s.test.logical.LogicalTypes.customSchema$2.getLogicalType)
    out$.writeInt(raw$)
  }

  private def decode$2(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.LocalDate = {
    _root_.avro2s.test.logical.LogicalTypes.customConversion$2.fromInt(in$.readInt(), _root_.avro2s.test.logical.LogicalTypes.customSchema$2, _root_.avro2s.test.logical.LogicalTypes.customSchema$2.getLogicalType)
  }

  private def encode$3(value$: java.time.LocalTime, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.LogicalTypes.customConversion$3.toInt(value$, _root_.avro2s.test.logical.LogicalTypes.customSchema$3, _root_.avro2s.test.logical.LogicalTypes.customSchema$3.getLogicalType)
    out$.writeInt(raw$)
  }

  private def decode$3(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.LocalTime = {
    _root_.avro2s.test.logical.LogicalTypes.customConversion$3.fromInt(in$.readInt(), _root_.avro2s.test.logical.LogicalTypes.customSchema$3, _root_.avro2s.test.logical.LogicalTypes.customSchema$3.getLogicalType)
  }

  private def encode$4(value$: java.time.LocalTime, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.LogicalTypes.customConversion$4.toLong(value$, _root_.avro2s.test.logical.LogicalTypes.customSchema$4, _root_.avro2s.test.logical.LogicalTypes.customSchema$4.getLogicalType)
    out$.writeLong(raw$)
  }

  private def decode$4(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.LocalTime = {
    _root_.avro2s.test.logical.LogicalTypes.customConversion$4.fromLong(in$.readLong(), _root_.avro2s.test.logical.LogicalTypes.customSchema$4, _root_.avro2s.test.logical.LogicalTypes.customSchema$4.getLogicalType)
  }

  private def encode$5(value$: java.time.Instant, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.LogicalTypes.customConversion$5.toLong(value$, _root_.avro2s.test.logical.LogicalTypes.customSchema$5, _root_.avro2s.test.logical.LogicalTypes.customSchema$5.getLogicalType)
    out$.writeLong(raw$)
  }

  private def decode$5(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.Instant = {
    _root_.avro2s.test.logical.LogicalTypes.customConversion$5.fromLong(in$.readLong(), _root_.avro2s.test.logical.LogicalTypes.customSchema$5, _root_.avro2s.test.logical.LogicalTypes.customSchema$5.getLogicalType)
  }

  private def encode$6(value$: java.time.Instant, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.LogicalTypes.customConversion$6.toLong(value$, _root_.avro2s.test.logical.LogicalTypes.customSchema$6, _root_.avro2s.test.logical.LogicalTypes.customSchema$6.getLogicalType)
    out$.writeLong(raw$)
  }

  private def decode$6(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.Instant = {
    _root_.avro2s.test.logical.LogicalTypes.customConversion$6.fromLong(in$.readLong(), _root_.avro2s.test.logical.LogicalTypes.customSchema$6, _root_.avro2s.test.logical.LogicalTypes.customSchema$6.getLogicalType)
  }

  private def encode$7(value$: java.time.LocalDateTime, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.LogicalTypes.customConversion$7.toLong(value$, _root_.avro2s.test.logical.LogicalTypes.customSchema$7, _root_.avro2s.test.logical.LogicalTypes.customSchema$7.getLogicalType)
    out$.writeLong(raw$)
  }

  private def decode$7(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.LocalDateTime = {
    _root_.avro2s.test.logical.LogicalTypes.customConversion$7.fromLong(in$.readLong(), _root_.avro2s.test.logical.LogicalTypes.customSchema$7, _root_.avro2s.test.logical.LogicalTypes.customSchema$7.getLogicalType)
  }

  private def encode$8(value$: java.time.LocalDateTime, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    val raw$ = _root_.avro2s.test.logical.LogicalTypes.customConversion$8.toLong(value$, _root_.avro2s.test.logical.LogicalTypes.customSchema$8, _root_.avro2s.test.logical.LogicalTypes.customSchema$8.getLogicalType)
    out$.writeLong(raw$)
  }

  private def decode$8(in$: _root_.org.apache.avro.io.ResolvingDecoder): java.time.LocalDateTime = {
    _root_.avro2s.test.logical.LogicalTypes.customConversion$8.fromLong(in$.readLong(), _root_.avro2s.test.logical.LogicalTypes.customSchema$8, _root_.avro2s.test.logical.LogicalTypes.customSchema$8.getLogicalType)
  }
}

object LogicalTypes {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"LogicalTypes","namespace":"avro2s.test.logical","fields":[{"name":"_uuid","type":{"type":"string","logicalType":"uuid"}},{"name":"_date","type":{"type":"int","logicalType":"date"}},{"name":"_time_millis","type":{"type":"int","logicalType":"time-millis"}},{"name":"_time_micros","type":{"type":"long","logicalType":"time-micros"}},{"name":"_timestamp_millis","type":{"type":"long","logicalType":"timestamp-millis"}},{"name":"_timestamp_micros","type":{"type":"long","logicalType":"timestamp-micros"}},{"name":"_local_timestamp_millis","type":{"type":"long","logicalType":"local-timestamp-millis"}},{"name":"_local_timestamp_micros","type":{"type":"long","logicalType":"local-timestamp-micros"}}]}""")
  val $UUIDConversion: org.apache.avro.Conversion[?] = new org.apache.avro.Conversions.UUIDConversion()
  val $DateConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.DateConversion()
  val $TimeMillisConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.TimeMillisConversion()
  val $TimeMicrosConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.TimeMicrosConversion()
  val $TimestampMillisConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.TimestampMillisConversion()
  val $TimestampMicrosConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.TimestampMicrosConversion()
  val $LocalTimestampMillisConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.LocalTimestampMillisConversion()
  val $LocalTimestampMicrosConversion: org.apache.avro.Conversion[?] = new org.apache.avro.data.TimeConversions.LocalTimestampMicrosConversion()
  val MODEL$: org.apache.avro.specific.SpecificData = {
    val model = new org.apache.avro.specific.SpecificData()
    model.addLogicalTypeConversion($UUIDConversion)
    model.addLogicalTypeConversion($DateConversion)
    model.addLogicalTypeConversion($TimeMillisConversion)
    model.addLogicalTypeConversion($TimeMicrosConversion)
    model.addLogicalTypeConversion($TimestampMillisConversion)
    model.addLogicalTypeConversion($TimestampMicrosConversion)
    model.addLogicalTypeConversion($LocalTimestampMillisConversion)
    model.addLogicalTypeConversion($LocalTimestampMicrosConversion)
    model
  }
  private val customSchema$1: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(0).schema()
  private val customConversion$1 = new _root_.org.apache.avro.Conversions.UUIDConversion()
  private val customSchema$2: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(1).schema()
  private val customConversion$2 = new _root_.org.apache.avro.data.TimeConversions.DateConversion()
  private val customSchema$3: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(2).schema()
  private val customConversion$3 = new _root_.org.apache.avro.data.TimeConversions.TimeMillisConversion()
  private val customSchema$4: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(3).schema()
  private val customConversion$4 = new _root_.org.apache.avro.data.TimeConversions.TimeMicrosConversion()
  private val customSchema$5: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(4).schema()
  private val customConversion$5 = new _root_.org.apache.avro.data.TimeConversions.TimestampMillisConversion()
  private val customSchema$6: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(5).schema()
  private val customConversion$6 = new _root_.org.apache.avro.data.TimeConversions.TimestampMicrosConversion()
  private val customSchema$7: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(6).schema()
  private val customConversion$7 = new _root_.org.apache.avro.data.TimeConversions.LocalTimestampMillisConversion()
  private val customSchema$8: _root_.org.apache.avro.Schema = SCHEMA$.getFields.get(7).schema()
  private val customConversion$8 = new _root_.org.apache.avro.data.TimeConversions.LocalTimestampMicrosConversion()
  private val $default$0: java.util.UUID = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")
  private val $default$1: java.time.LocalDate = java.time.LocalDate.ofEpochDay(0)
  private val $default$2: java.time.LocalTime = java.time.LocalTime.ofNanoOfDay(0)
  private val $default$3: java.time.Instant = java.time.Instant.ofEpochMilli(0)
  private val $default$4: java.time.Instant = java.time.Instant.ofEpochSecond(0, 0)
  private val $default$5: java.time.LocalDateTime = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(0), java.time.ZoneId.of("UTC"))
  private val $default$6: java.time.LocalDateTime = java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(0, 0), java.time.ZoneId.of("UTC"))
}