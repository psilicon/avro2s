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
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
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
    }
  }
}

object LogicalTypesDisabled {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"LogicalTypesDisabled","namespace":"avro2s.test.logical","fields":[{"name":"_uuid","type":{"type":"string","logicalType":"uuid"}},{"name":"_date","type":{"type":"int","logicalType":"date"}},{"name":"_time_millis","type":{"type":"int","logicalType":"time-millis"}},{"name":"_time_micros","type":{"type":"long","logicalType":"time-micros"}},{"name":"_timestamp_millis","type":{"type":"long","logicalType":"timestamp-millis"}},{"name":"_timestamp_micros","type":{"type":"long","logicalType":"timestamp-micros"}},{"name":"_local_timestamp_millis","type":{"type":"long","logicalType":"local-timestamp-millis"}},{"name":"_local_timestamp_micros","type":{"type":"long","logicalType":"local-timestamp-micros"}}]}""")
}