package avro2s.generator.logical

import org.apache.avro.Schema
import org.apache.avro.Schema.Type
import org.apache.avro.Schema.Type._

private[avro2s] object LogicalTypes {
  case class LogicalTypeConverter(logicalTypeMap: Map[LogicalTypeKey, LogicalType]) {
    def toType(schema: Schema, value: String): String = toTypeWithFallback(schema, value, value)
    
    def toTypeWithFallback(schema: Schema, value: String, fallback: String): String = {
      Option(schema.getLogicalType).map { logicalType =>
        val schemaType = schema.getType
        val logicalTypeName = logicalType.getName
        val key = LogicalTypeKey(schemaType, logicalTypeName)
        logicalTypeMap.get(key) match {
          case Some(lt) if lt.validate(schema) => s"{${lt.toType(value, schema)}}"
          case _ => fallback
        }
      }.getOrElse(fallback)
    }

    def fromType(schema: Schema, value: String): String = fromTypeWithFallback(schema, value, value)
    
    def fromTypeWithFallback(schema: Schema, value: String, fallback: String): String = {
      Option(schema.getLogicalType).map { logicalType =>
        val schemaType = schema.getType
        val logicalTypeName = logicalType.getName
        val key = LogicalTypeKey(schemaType, logicalTypeName)
        logicalTypeMap.get(key) match {
          case Some(lt) if lt.validate(schema) => s"{${lt.fromType(value, schema)}}"
          case _ => fallback
        }
      }.getOrElse(fallback)
    }

    def getType(schema: Schema, default: String): String = {
      Option(schema.getLogicalType).map { logicalType =>
        val schemaType = schema.getType
        val logicalTypeName = logicalType.getName
        val key = LogicalTypeKey(schemaType, logicalTypeName)
        logicalTypeMap.get(key) match {
          case Some(lt) if lt.validate(schema) => lt.getType(schema)
          case _ => default
        }
      }.getOrElse(default)
    }
    
    def logicalTypeInUse(schema: Schema): Boolean = Option(schema.getLogicalType).exists { logicalType =>
      val schemaType = schema.getType
      val logicalTypeName = logicalType.getName
      val key = LogicalTypeKey(schemaType, logicalTypeName)
      logicalTypeMap.get(key).exists(_.validate(schema))
    }
    
    def getDefault(schema: Schema): String = Option(schema.getLogicalType).map { logicalType =>
      val schemaType = schema.getType
      val logicalTypeName = logicalType.getName
      val key = LogicalTypeKey(schemaType, logicalTypeName)
      logicalTypeMap.get(key) match {
        case Some(lt) if lt.validate(schema) => lt.defaultValue(schema)
        case _ => "null"
      }
    }.getOrElse("null")
  }
  
  abstract class LogicalType(val name: String, val associatedTypes: Set[Type]) {
    def toType(value: String, schema: Schema): String

    def fromType(value: String, schema: Schema): String

    def getType(schema: Schema): String

    def validate(schema: Schema): Boolean = true
    
    def defaultValue(schema: Schema): String
  }

  case object UUID extends LogicalType("uuid", Set(STRING)) {
    override def toType(value: String, schema: Schema): String = s"java.util.UUID.fromString($value)"

    override def fromType(value: String, schema: Schema): String = s"$value.toString"

    override def getType(schema: Schema): String = "java.util.UUID"

    override def defaultValue(schema: Schema): String = "java.util.UUID.fromString(\"00000000-0000-0000-0000-000000000000\")"
  }

  case object Date extends LogicalType("date", Set(INT)) {
    override def toType(value: String, schema: Schema): String = s"java.time.LocalDate.ofEpochDay($value)"

    override def fromType(value: String, schema: Schema): String = s"$value.toEpochDay.toInt"

    override def getType(schema: Schema): String = "java.time.LocalDate"

    override def defaultValue(schema: Schema): String = "java.time.LocalDate.ofEpochDay(0)"
  }

  case object TimeMillisecondPrecision extends LogicalType("time-millis", Set(INT)) {
    override def toType(value: String, schema: Schema): String = s"java.time.LocalTime.ofNanoOfDay($value * 1000000L)"

    override def fromType(value: String, schema: Schema): String = s"($value.toNanoOfDay / 1000000L).toInt"

    override def getType(schema: Schema): String = "java.time.LocalTime"

    override def defaultValue(schema: Schema): String = "java.time.LocalTime.ofNanoOfDay(0)"
  }

  case object TimeMicrosecondPrecision extends LogicalType("time-micros", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"java.time.LocalTime.ofNanoOfDay($value * 1000L)"

    override def fromType(value: String, schema: Schema): String = s"$value.toNanoOfDay / 1000L"

    override def getType(schema: Schema): String = "java.time.LocalTime"

    override def defaultValue(schema: Schema): String = "java.time.LocalTime.ofNanoOfDay(0)"
  }

  case object TimestampMillisecondPrecision extends LogicalType("timestamp-millis", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"java.time.Instant.ofEpochMilli($value)"

    override def fromType(value: String, schema: Schema): String = s"$value.toEpochMilli"

    override def getType(schema: Schema): String = "java.time.Instant"

    override def defaultValue(schema: Schema): String = "java.time.Instant.ofEpochMilli(0)"
  }

  case object TimestampMicrosecondPrecision extends LogicalType("timestamp-micros", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"java.time.Instant.ofEpochSecond($value / 1000000L, ($value % 1000000L) * 1000L)"

    override def fromType(value: String, schema: Schema): String = s"($value.getEpochSecond * 1000000L) + ($value.getNano / 1000L)"

    override def getType(schema: Schema): String = "java.time.Instant"

    override def defaultValue(schema: Schema): String = "java.time.Instant.ofEpochSecond(0, 0)"
  }

  case object LocalTimestampMillisecondPrecision extends LogicalType("local-timestamp-millis", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"""java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli($value), java.time.ZoneId.of("UTC"))"""

    override def fromType(value: String, schema: Schema): String = s"""$value.atZone(java.time.ZoneId.of("UTC")).toInstant.toEpochMilli"""

    override def getType(schema: Schema): String = "java.time.LocalDateTime"

    override def defaultValue(schema: Schema): String = "java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(0), java.time.ZoneId.of(\"UTC\"))"
  }

  case object LocalTimestampMicrosecondPrecision extends LogicalType("local-timestamp-micros", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"""java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond($value / 1000000L, ($value % 1000000L) * 1000L), java.time.ZoneId.of("UTC"))"""

    override def fromType(value: String, schema: Schema): String = s"""$value.atZone(java.time.ZoneId.of("UTC")).toInstant.getEpochSecond * 1000000L + $value.atZone(java.time.ZoneId.of("UTC")).toInstant.getNano / 1000L"""

    override def getType(schema: Schema): String = "java.time.LocalDateTime"

    override def defaultValue(schema: Schema): String = "java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(0, 0), java.time.ZoneId.of(\"UTC\"))"
  }

  // TODO: implement decimal
  case object Decimal extends LogicalType("decimal", Set(BYTES, FIXED)) {
    override def toType(value: String, schema: Schema): String = ???

    override def fromType(value: String, schema: Schema): String = ???

    override def getType(schema: Schema): String = ???

    override def defaultValue(schema: Schema): String = ???
  }

  // TODO: Implement duration
  case object Duration extends LogicalType("duration", Set(FIXED)) {
    override def toType(value: String, schema: Schema): String = ???

    override def fromType(value: String, schema: Schema): String = ???

    override def getType(schema: Schema): String = ???

    override def validate(schema: Schema): Boolean = schema.getFixedSize == 12

    override def defaultValue(schema: Schema): String = ???
  }

  private val supportedLogicalTypes: List[LogicalType] = List(
    UUID,
    Date,
    TimeMillisecondPrecision,
    TimeMicrosecondPrecision,
    TimestampMillisecondPrecision,
    TimestampMicrosecondPrecision,
    LocalTimestampMillisecondPrecision,
    LocalTimestampMicrosecondPrecision
  )

  case class LogicalTypeKey(schemaType: Type, logicalTypeName: String)

  val logicalTypeMap: Map[LogicalTypeKey, LogicalType] = supportedLogicalTypes
    .flatMap { lt =>
      lt.associatedTypes.map { at =>
        LogicalTypeKey(at, lt.name) -> lt
      }
    }.toMap
}