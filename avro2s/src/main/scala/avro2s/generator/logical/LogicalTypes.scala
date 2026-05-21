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
    
    def avroAutoConverts(schema: Schema): Boolean = Option(schema.getLogicalType).exists { logicalType =>
      val key = LogicalTypeKey(schema.getType, logicalType.getName)
      logicalTypeMap.get(key).exists(lt => lt.validate(schema) && lt.avroAutoConverts)
    }

    def logicalTypeInUse(schema: Schema): Boolean = Option(schema.getLogicalType).exists { logicalType =>
      val schemaType = schema.getType
      val logicalTypeName = logicalType.getName
      val key = LogicalTypeKey(schemaType, logicalTypeName)
      logicalTypeMap.get(key).exists(_.validate(schema))
    }

    def getConversionClass(schema: Schema): Option[String] = {
      Option(schema.getLogicalType).flatMap { logicalType =>
        val key = LogicalTypeKey(schema.getType, logicalType.getName)
        logicalTypeMap.get(key).filter(_.validate(schema)).map(_.conversionClass).filter(_.nonEmpty)
      }
    }

    /** Recursively collects all distinct conversion class names referenced within a schema,
     *  including those nested inside MAP values, ARRAY items, and UNION branches.
     */
    def collectConversionClasses(schema: Schema): List[String] = {
      import scala.jdk.CollectionConverters._
      schema.getType match {
        case Schema.Type.MAP   => collectConversionClasses(schema.getValueType)
        case Schema.Type.ARRAY => collectConversionClasses(schema.getElementType)
        case Schema.Type.UNION => schema.getTypes.asScala.toList.flatMap(collectConversionClasses)
        case _                 => getConversionClass(schema).toList
      }
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

    def conversionClass: String

    /** True if Avro automatically converts this BYTES-backed type to the target Scala type
     *  before calling put(), meaning put() receives the target type directly rather than a ByteBuffer.
     */
    def avroAutoConverts: Boolean = false
  }

  case object UUID extends LogicalType("uuid", Set(STRING)) {
    override def toType(value: String, schema: Schema): String = s"java.util.UUID.fromString($value)"

    override def fromType(value: String, schema: Schema): String = s"$value.toString"

    override def getType(schema: Schema): String = "java.util.UUID"

    override def defaultValue(schema: Schema): String = "java.util.UUID.fromString(\"00000000-0000-0000-0000-000000000000\")"

    override def conversionClass: String = "org.apache.avro.Conversions.UUIDConversion"
  }

  case object Date extends LogicalType("date", Set(INT)) {
    override def toType(value: String, schema: Schema): String = s"java.time.LocalDate.ofEpochDay($value)"

    override def fromType(value: String, schema: Schema): String = s"$value.toEpochDay.toInt"

    override def getType(schema: Schema): String = "java.time.LocalDate"

    override def defaultValue(schema: Schema): String = "java.time.LocalDate.ofEpochDay(0)"

    override def conversionClass: String = "org.apache.avro.data.TimeConversions.DateConversion"
  }

  case object TimeMillisecondPrecision extends LogicalType("time-millis", Set(INT)) {
    override def toType(value: String, schema: Schema): String = s"java.time.LocalTime.ofNanoOfDay($value * 1000000L)"

    override def fromType(value: String, schema: Schema): String = s"($value.toNanoOfDay / 1000000L).toInt"

    override def getType(schema: Schema): String = "java.time.LocalTime"

    override def defaultValue(schema: Schema): String = "java.time.LocalTime.ofNanoOfDay(0)"

    override def conversionClass: String = "org.apache.avro.data.TimeConversions.TimeMillisConversion"
  }

  case object TimeMicrosecondPrecision extends LogicalType("time-micros", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"java.time.LocalTime.ofNanoOfDay($value * 1000L)"

    override def fromType(value: String, schema: Schema): String = s"$value.toNanoOfDay / 1000L"

    override def getType(schema: Schema): String = "java.time.LocalTime"

    override def defaultValue(schema: Schema): String = "java.time.LocalTime.ofNanoOfDay(0)"

    override def conversionClass: String = "org.apache.avro.data.TimeConversions.TimeMicrosConversion"
  }

  case object TimestampMillisecondPrecision extends LogicalType("timestamp-millis", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"java.time.Instant.ofEpochMilli($value)"

    override def fromType(value: String, schema: Schema): String = s"$value.toEpochMilli"

    override def getType(schema: Schema): String = "java.time.Instant"

    override def defaultValue(schema: Schema): String = "java.time.Instant.ofEpochMilli(0)"

    override def conversionClass: String = "org.apache.avro.data.TimeConversions.TimestampMillisConversion"
  }

  case object TimestampMicrosecondPrecision extends LogicalType("timestamp-micros", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"java.time.Instant.ofEpochSecond($value / 1000000L, ($value % 1000000L) * 1000L)"

    override def fromType(value: String, schema: Schema): String = s"($value.getEpochSecond * 1000000L) + ($value.getNano / 1000L)"

    override def getType(schema: Schema): String = "java.time.Instant"

    override def defaultValue(schema: Schema): String = "java.time.Instant.ofEpochSecond(0, 0)"

    override def conversionClass: String = "org.apache.avro.data.TimeConversions.TimestampMicrosConversion"
  }

  case object LocalTimestampMillisecondPrecision extends LogicalType("local-timestamp-millis", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"""java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli($value), java.time.ZoneId.of("UTC"))"""

    override def fromType(value: String, schema: Schema): String = s"""$value.atZone(java.time.ZoneId.of("UTC")).toInstant.toEpochMilli"""

    override def getType(schema: Schema): String = "java.time.LocalDateTime"

    override def defaultValue(schema: Schema): String = "java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(0), java.time.ZoneId.of(\"UTC\"))"

    override def conversionClass: String = "org.apache.avro.data.TimeConversions.LocalTimestampMillisConversion"
  }

  case object LocalTimestampMicrosecondPrecision extends LogicalType("local-timestamp-micros", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"""java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond($value / 1000000L, ($value % 1000000L) * 1000L), java.time.ZoneId.of("UTC"))"""

    override def fromType(value: String, schema: Schema): String = s"""$value.atZone(java.time.ZoneId.of("UTC")).toInstant.getEpochSecond * 1000000L + $value.atZone(java.time.ZoneId.of("UTC")).toInstant.getNano / 1000L"""

    override def getType(schema: Schema): String = "java.time.LocalDateTime"

    override def defaultValue(schema: Schema): String = "java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(0, 0), java.time.ZoneId.of(\"UTC\"))"

    override def conversionClass: String = "org.apache.avro.data.TimeConversions.LocalTimestampMicrosConversion"
  }

  case object TimestampNanosecondPrecision extends LogicalType("timestamp-nanos", Set(LONG)) {
    override def toType(value: String, schema: Schema): String =
      s"java.time.Instant.ofEpochSecond($value / 1_000_000_000L, $value % 1_000_000_000L)"

    override def fromType(value: String, schema: Schema): String =
      s"$value.getEpochSecond * 1_000_000_000L + $value.getNano"

    override def getType(schema: Schema): String = "java.time.Instant"

    override def defaultValue(schema: Schema): String = "java.time.Instant.ofEpochSecond(0L, 0L)"

    override def conversionClass: String = "org.apache.avro.data.TimeConversions.TimestampNanosConversion"
  }

  case object LocalTimestampNanosecondPrecision extends LogicalType("local-timestamp-nanos", Set(LONG)) {
    override def toType(value: String, schema: Schema): String =
      s"java.time.LocalDateTime.ofEpochSecond($value / 1_000_000_000L, ($value % 1_000_000_000L).toInt, java.time.ZoneOffset.UTC)"

    override def fromType(value: String, schema: Schema): String =
      s"$value.toEpochSecond(java.time.ZoneOffset.UTC) * 1_000_000_000L + $value.getNano"

    override def getType(schema: Schema): String = "java.time.LocalDateTime"

    override def defaultValue(schema: Schema): String =
      "java.time.LocalDateTime.ofEpochSecond(0L, 0, java.time.ZoneOffset.UTC)"

    override def conversionClass: String = "org.apache.avro.data.TimeConversions.LocalTimestampNanosConversion"
  }

  case object Decimal extends LogicalType("decimal", Set(BYTES, FIXED)) {
    override def toType(value: String, schema: Schema): String = {
      val scale = Option(schema.getLogicalType)
        .collect { case d: org.apache.avro.LogicalTypes.Decimal => d }
        .map(_.getScale)
        .getOrElse(0)
      if (schema.getType == FIXED)
        s"scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger($value.asInstanceOf[org.apache.avro.generic.GenericFixed].bytes()), $scale))"
      else
        s"scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger($value.array()), $scale))"
    }

    override def fromType(value: String, schema: Schema): String = {
      val scale = Option(schema.getLogicalType)
        .collect { case d: org.apache.avro.LogicalTypes.Decimal => d }
        .map(_.getScale)
        .getOrElse(0)
      if (schema.getType == FIXED) {
        val fixedSize = schema.getFixedSize
        val fullName = schema.getFullName
        s"""val unscaled = $value.setScale($scale).bigDecimal.unscaledValue().toByteArray; if (unscaled.length > $fixedSize) throw new ArithmeticException("Decimal value does not fit in " + $fixedSize + " bytes: requires " + unscaled.length + " bytes"); val padded = new Array[Byte]($fixedSize); val fillByte: Byte = if (unscaled.length > 0 && unscaled(0) < 0) 0xFF.toByte else 0x00.toByte; java.util.Arrays.fill(padded, fillByte); System.arraycopy(unscaled, 0, padded, $fixedSize - unscaled.length, unscaled.length); val result = new $fullName(); result.bytes(padded); result"""
      } else
        s"java.nio.ByteBuffer.wrap($value.setScale($scale).bigDecimal.unscaledValue().toByteArray)"
    }

    override def getType(schema: Schema): String = "scala.math.BigDecimal"

    override def defaultValue(schema: Schema): String = "scala.math.BigDecimal(0)"

    override def conversionClass: String = ""

    override def validate(schema: Schema): Boolean =
      Option(schema.getLogicalType).exists(_.isInstanceOf[org.apache.avro.LogicalTypes.Decimal])
  }

  case object AvroJavaBigDecimal extends LogicalType("big-decimal", Set(BYTES)) {
    override def toType(value: String, schema: Schema): String =
      s"$value.asInstanceOf[java.math.BigDecimal]"

    override def fromType(value: String, schema: Schema): String =
      s"new org.apache.avro.Conversions.BigDecimalConversion().toBytes($value, null, null)"

    override def getType(schema: Schema): String = "java.math.BigDecimal"

    override def defaultValue(schema: Schema): String = "java.math.BigDecimal.ZERO"

    override def validate(schema: Schema): Boolean = schema.getType == BYTES

    override def conversionClass: String = ""

    override def avroAutoConverts: Boolean = true
  }

  case object Duration extends LogicalType("duration", Set(FIXED)) {
    override def toType(value: String, schema: Schema): String =
      s"$value.asInstanceOf[org.apache.avro.util.TimePeriod]"

    override def fromType(value: String, schema: Schema): String = {
      val fullName = schema.getFullName
      s"new org.apache.avro.Conversions.DurationConversion().toFixed($value, $fullName.SCHEMA$$, $fullName.SCHEMA$$.getLogicalType)"
    }

    override def getType(schema: Schema): String = "org.apache.avro.util.TimePeriod"

    override def validate(schema: Schema): Boolean = schema.getFixedSize == 12

    override def defaultValue(schema: Schema): String = "org.apache.avro.util.TimePeriod.of(0L, 0L, 0L)"

    override def conversionClass: String = ""

    override def avroAutoConverts: Boolean = true
  }

  private val supportedLogicalTypes: List[LogicalType] = List(
    UUID,
    Date,
    TimeMillisecondPrecision,
    TimeMicrosecondPrecision,
    TimestampMillisecondPrecision,
    TimestampMicrosecondPrecision,
    LocalTimestampMillisecondPrecision,
    LocalTimestampMicrosecondPrecision,
    TimestampNanosecondPrecision,
    LocalTimestampNanosecondPrecision,
    Decimal,
    Duration,
    AvroJavaBigDecimal
  )

  case class LogicalTypeKey(schemaType: Type, logicalTypeName: String)

  val logicalTypeMap: Map[LogicalTypeKey, LogicalType] = supportedLogicalTypes
    .flatMap { lt =>
      lt.associatedTypes.map { at =>
        LogicalTypeKey(at, lt.name) -> lt
      }
    }.toMap
}