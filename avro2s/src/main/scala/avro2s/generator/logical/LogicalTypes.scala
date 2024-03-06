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
  }
  
  abstract class LogicalType(val name: String, val associatedTypes: Set[Type]) {
    def toType(value: String, schema: Schema): String

    def fromType(value: String, schema: Schema): String

    def getType(schema: Schema): String

    def validate(schema: Schema): Boolean = true
  }

  case object Decimal extends LogicalType("decimal", Set(BYTES, FIXED)) {
    private val dollar = "$"
    private def toTypeFromBytes(value: String): String =
      s"val schema = getSchema.getFields().get(field$dollar).schema(); val decimalType = schema.getLogicalType().asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromBytes($value, schema, decimalType))"

    private def toTypeFromFixed(value: String, schema: Schema): String =
      s"val schema = getSchema.getFields().get(field$dollar).schema(); val decimalType = schema.getLogicalType().asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromFixed($value.asInstanceOf[${schema.getFullName}], schema, decimalType))"

    override def toType(value: String, schema: Schema): String = schema.getType match {
      case BYTES => toTypeFromBytes(value)
      case FIXED => toTypeFromFixed(value, schema)
      case _ => throw new IllegalArgumentException(s"Unsupported type for decimal: ${schema.getType}")
    }

    private def fromTypeToBytes(value: String): String =
      s"val schema = getSchema.getFields().get(field$dollar).schema(); val decimalType = schema.getLogicalType().asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val scaledValue = $value.setScale(scale); val bigDecimal = scaledValue.bigDecimal; LogicalTypes.decimalConversion.toBytes(bigDecimal, schema, decimalType)"

    private def fromTypeToFixed(value: String): String =
      s"val schema = getSchema.getFields().get(field$dollar).schema(); val decimalType = schema.getLogicalType().asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val bigDecimal = $value.bigDecimal.setScale(scale); LogicalTypes.decimalConversion.toFixed(bigDecimal, schema, decimalType)"

    override def fromType(value: String, schema: Schema): String = schema.getType match {
      case BYTES => fromTypeToBytes(value)
      case FIXED => fromTypeToFixed(value)
      case _ => throw new IllegalArgumentException(s"Unsupported type for decimal: ${schema.getType}")
    }

    override def getType(schema: Schema): String = "BigDecimal"
  }

  case object UUID extends LogicalType("uuid", Set(STRING)) {
    override def toType(value: String, schema: Schema): String = s"java.util.UUID.fromString($value)"

    override def fromType(value: String, schema: Schema): String = s"$value.toString"

    override def getType(schema: Schema): String = "java.util.UUID"
  }

  case object Date extends LogicalType("date", Set(INT)) {
    override def toType(value: String, schema: Schema): String = s"java.time.LocalDate.ofEpochDay($value)"

    override def fromType(value: String, schema: Schema): String = s"$value.toEpochDay"

    override def getType(schema: Schema): String = "java.time.LocalDate"
  }

  case object TimeMillisecondPrecision extends LogicalType("time-millis", Set(INT)) {
    override def toType(value: String, schema: Schema): String = s"java.time.LocalTime.ofNanoOfDay($value.toLong * 1000000)"

    override def fromType(value: String, schema: Schema): String = s"$value.toNanoOfDay / 1000000"

    override def getType(schema: Schema): String = "java.time.LocalTime"
  }

  case object TimeMicrosecondPrecision extends LogicalType("time-micros", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"java.time.LocalTime.ofNanoOfDay($value * 1000)"

    override def fromType(value: String, schema: Schema): String = s"$value.toNanoOfDay / 1000"

    override def getType(schema: Schema): String = "java.time.LocalTime"
  }

  case object TimestampMillisecondPrecision extends LogicalType("timestamp-millis", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"java.time.Instant.ofEpochMilli($value)"

    override def fromType(value: String, schema: Schema): String = s"$value.toEpochMilli"

    override def getType(schema: Schema): String = "java.time.Instant"
  }

  case object TimestampMicrosecondPrecision extends LogicalType("timestamp-micros", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"java.time.Instant.ofEpochSecond($value / 1000000, ($value % 1000000) * 1000)"

    override def fromType(value: String, schema: Schema): String = s"($value.getEpochSecond * 1000000) + ($value.getNano / 1000)"

    override def getType(schema: Schema): String = "java.time.Instant"
  }

  case object LocalTimestampMillisecondPrecision extends LogicalType("local-timestamp-millis", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli($value), java.time.ZoneId.systemDefault())"

    override def fromType(value: String, schema: Schema): String = s"$value.atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli"

    override def getType(schema: Schema): String = "java.time.LocalDateTime"
  }

  case object LocalTimestampMicrosecondPrecision extends LogicalType("local-timestamp-micros", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond($value / 1000000, ($value % 1000000) * 1000), java.time.ZoneId.systemDefault())"

    override def fromType(value: String, schema: Schema): String = s"$value.atZone(java.time.ZoneId.systemDefault()).toInstant().getEpochSecond * 1000000 + $value.atZone(java.time.ZoneId.systemDefault()).toInstant().getNano / 1000"

    override def getType(schema: Schema): String = "java.time.LocalDateTime"
  }

  // TODO: Implement duration
  case object Duration extends LogicalType("duration", Set(FIXED)) {
    override def toType(value: String, schema: Schema): String = ???

    override def fromType(value: String, schema: Schema): String = ???

    override def getType(schema: Schema): String = ???

    override def validate(schema: Schema): Boolean = schema.getFixedSize == 12
  }

  private val supportedLogicalTypes: List[LogicalType] = List(
    Decimal,
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