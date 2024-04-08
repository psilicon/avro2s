/** GENERATED CODE */

package avro2s.test.logical

import scala.annotation.switch

case class LogicalTypes(var _uuid: java.util.UUID, var _date: java.time.LocalDate, var _time_millis: java.time.LocalTime, var _time_micros: java.time.LocalTime, var _timestamp_millis: java.time.Instant, var _timestamp_micros: java.time.Instant, var _local_timestamp_millis: java.time.LocalDateTime, var _local_timestamp_micros: java.time.LocalDateTime) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(java.util.UUID.fromString("00000000-0000-0000-0000-000000000000"), java.time.LocalDate.ofEpochDay(0), java.time.LocalTime.ofNanoOfDay(0), java.time.LocalTime.ofNanoOfDay(0), java.time.Instant.ofEpochMilli(0), java.time.Instant.ofEpochSecond(0, 0), java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(0), java.time.ZoneId.of("UTC")), java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(0, 0), java.time.ZoneId.of("UTC")))

  override def getSchema: org.apache.avro.Schema = LogicalTypes.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => {_uuid.toString}.asInstanceOf[AnyRef]
      case 1 => {_date.toEpochDay}.asInstanceOf[AnyRef]
      case 2 => {_time_millis.toNanoOfDay / 1000000L}.asInstanceOf[AnyRef]
      case 3 => {_time_micros.toNanoOfDay / 1000L}.asInstanceOf[AnyRef]
      case 4 => {_timestamp_millis.toEpochMilli}.asInstanceOf[AnyRef]
      case 5 => {(_timestamp_micros.getEpochSecond * 1000000L) + (_timestamp_micros.getNano / 1000L)}.asInstanceOf[AnyRef]
      case 6 => {_local_timestamp_millis.atZone(java.time.ZoneId.of("UTC")).toInstant.toEpochMilli}.asInstanceOf[AnyRef]
      case 7 => {_local_timestamp_micros.atZone(java.time.ZoneId.of("UTC")).toInstant.getEpochSecond * 1000000L + _local_timestamp_micros.atZone(java.time.ZoneId.of("UTC")).toInstant.getNano / 1000L}.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._uuid = {java.util.UUID.fromString(value.toString.asInstanceOf[String])}
      case 1 => this._date = {java.time.LocalDate.ofEpochDay(value.asInstanceOf[Int])}
      case 2 => this._time_millis = {java.time.LocalTime.ofNanoOfDay(value.asInstanceOf[Int] * 1000000L)}
      case 3 => this._time_micros = {java.time.LocalTime.ofNanoOfDay(value.asInstanceOf[Long] * 1000L)}
      case 4 => this._timestamp_millis = {java.time.Instant.ofEpochMilli(value.asInstanceOf[Long])}
      case 5 => this._timestamp_micros = {java.time.Instant.ofEpochSecond(value.asInstanceOf[Long] / 1000000L, (value.asInstanceOf[Long] % 1000000L) * 1000L)}
      case 6 => this._local_timestamp_millis = {java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(value.asInstanceOf[Long]), java.time.ZoneId.of("UTC"))}
      case 7 => this._local_timestamp_micros = {java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(value.asInstanceOf[Long] / 1000000L, (value.asInstanceOf[Long] % 1000000L) * 1000L), java.time.ZoneId.of("UTC"))}
    }
  }
}

object LogicalTypes {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"LogicalTypes","namespace":"avro2s.test.logical","fields":[{"name":"_uuid","type":{"type":"string","logicalType":"uuid"}},{"name":"_date","type":{"type":"int","logicalType":"date"}},{"name":"_time_millis","type":{"type":"int","logicalType":"time-millis"}},{"name":"_time_micros","type":{"type":"long","logicalType":"time-micros"}},{"name":"_timestamp_millis","type":{"type":"long","logicalType":"timestamp-millis"}},{"name":"_timestamp_micros","type":{"type":"long","logicalType":"timestamp-micros"}},{"name":"_local_timestamp_millis","type":{"type":"long","logicalType":"local-timestamp-millis"}},{"name":"_local_timestamp_micros","type":{"type":"long","logicalType":"local-timestamp-micros"}}]}""")
}