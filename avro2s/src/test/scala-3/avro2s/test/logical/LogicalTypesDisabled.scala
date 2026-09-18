/** GENERATED CODE */

package avro2s.test.logical

import scala.annotation.switch

case class LogicalTypesDisabled(var _uuid: String, var _date: Int, var _time_millis: Int, var _time_micros: Long, var _timestamp_millis: Long, var _timestamp_micros: Long, var _local_timestamp_millis: Long, var _local_timestamp_micros: Long) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("", 0, 0, 0, 0, 0, 0, 0)

  override def getSchema: org.apache.avro.Schema = LogicalTypesDisabled.SCHEMA$

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
        value.toString.asInstanceOf[String]
      }
      case 1 => this._date = {
        value.asInstanceOf[Int]
      }
      case 2 => this._time_millis = {
        value.asInstanceOf[Int]
      }
      case 3 => this._time_micros = {
        value.asInstanceOf[Long]
      }
      case 4 => this._timestamp_millis = {
        value.asInstanceOf[Long]
      }
      case 5 => this._timestamp_micros = {
        value.asInstanceOf[Long]
      }
      case 6 => this._local_timestamp_millis = {
        value.asInstanceOf[Long]
      }
      case 7 => this._local_timestamp_micros = {
        value.asInstanceOf[Long]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override protected def hasCustomCoders(): Boolean = true
  override def customEncode(out$: _root_.org.apache.avro.io.Encoder): Unit = encode$0(this, out$)
  override def customDecode(in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = decodeRecord$0(this, in$)

  private def encode$0(value$: _root_.avro2s.test.logical.LogicalTypesDisabled, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`_uuid`, out$)
    encode$2(value$.`_date`, out$)
    encode$3(value$.`_time_millis`, out$)
    encode$4(value$.`_time_micros`, out$)
    encode$5(value$.`_timestamp_millis`, out$)
    encode$6(value$.`_timestamp_micros`, out$)
    encode$7(value$.`_local_timestamp_millis`, out$)
    encode$8(value$.`_local_timestamp_micros`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.logical.LogicalTypesDisabled): _root_.avro2s.test.logical.LogicalTypesDisabled = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.logical.LogicalTypesDisabled() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.logical.LogicalTypesDisabled, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
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

  private def encode$1(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$1(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$2(value$: _root_.scala.Int, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeInt(value$)
  }

  private def decode$2(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Int = {
    in$.readInt()
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

  private def encode$5(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$5(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$6(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$6(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$7(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$7(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }

  private def encode$8(value$: _root_.scala.Long, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeLong(value$)
  }

  private def decode$8(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.Long = {
    in$.readLong()
  }
}

object LogicalTypesDisabled {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"LogicalTypesDisabled","namespace":"avro2s.test.logical","fields":[{"name":"_uuid","type":{"type":"string","logicalType":"uuid"}},{"name":"_date","type":{"type":"int","logicalType":"date"}},{"name":"_time_millis","type":{"type":"int","logicalType":"time-millis"}},{"name":"_time_micros","type":{"type":"long","logicalType":"time-micros"}},{"name":"_timestamp_millis","type":{"type":"long","logicalType":"timestamp-millis"}},{"name":"_timestamp_micros","type":{"type":"long","logicalType":"timestamp-micros"}},{"name":"_local_timestamp_millis","type":{"type":"long","logicalType":"local-timestamp-millis"}},{"name":"_local_timestamp_micros","type":{"type":"long","logicalType":"local-timestamp-micros"}}]}""")
}