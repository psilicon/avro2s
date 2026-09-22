package avro2s.generator.logical

import org.apache.avro.Schema
import org.apache.avro.Schema.Type
import org.apache.avro.Schema.Type._

private[avro2s] object LogicalTypes {
  case class LogicalTypeConverter(logicalTypeMap: Map[LogicalTypeKey, LogicalType]) {
    /** The logical type a schema resolves to, when avro2s supports it and the schema is valid for it. */
    private def logicalTypeFor(schema: Schema): Option[LogicalType] =
      Option(schema.getLogicalType)
        .flatMap(logicalType => logicalTypeMap.get(LogicalTypeKey(schema.getType, logicalType.getName)))
        .filter(_.validate(schema))

    def toType(schema: Schema, value: String): String = toTypeWithFallback(schema, value, value)

    def toTypeWithFallback(schema: Schema, value: String, fallback: String): String =
      logicalTypeFor(schema).map(lt => s"{${lt.toType(value, schema)}}").getOrElse(fallback)

    def fromType(schema: Schema, value: String): String =
      logicalTypeFor(schema).map(lt => s"{${lt.fromType(value, schema)}}").getOrElse(value)

    /**
     * fromType for a position that has to hold an AnyRef - a java.util.List element, a Map value or
     * a union branch. A logical type sitting on an int or a long encodes to a primitive, which must
     * box; every other encoded form is already a reference.
     */
    def fromTypeBoxed(schema: Schema, value: String): String = {
      val encoded = fromType(schema, value)
      if (schema.getType == INT || schema.getType == LONG) s"$encoded.asInstanceOf[AnyRef]" else encoded
    }

    /**
     * put's accepting matcher. Whether the value was converted before put is called is decided by
     * the model in play, not by us: Avro looks a read conversion up by logical type name, so a
     * populated model converts whatever getConversion returns and an empty one converts nothing.
     * Both shapes therefore reach put, and they are always distinguishable - no logical type's
     * converted class is also its encoded class.
     *
     * fixedPattern names what a FIXED matches on. Inside a union that must be the concrete
     * generated class, since a union may legally hold two differently named fixeds and a
     * GenericFixed arm would swallow the sibling's values. Everywhere else there is a single
     * element type, so GenericFixed is both safe and what catches the GenericData.Fixed Avro
     * produces when the model cannot load the generated class.
     */
    def acceptEitherShape(schema: Schema, value: String, fixedPattern: Option[String] = None): String =
      logicalTypeFor(schema).map { logicalType =>
        // These four bindings wrap whatever toType emits, so none of them may share a name with a
        // local bound inside a toType - raw$ did collide with Decimal's, giving val raw$ = raw$...
        // encoded$ appears in Decimal's fromType, which is fine: fromType is the get side and is
        // never nested inside this matcher.
        //
        // A string arrives as Utf8 or String depending on the model, so it is matched as
        // CharSequence and handed on as a String.
        val bound = if (schema.getType == STRING) "encoded$.toString" else "encoded$"
        s"{ val in$$: Any = $value; in$$ match { " +
          // Every logical type maps to a reference type, so null is always assignable. put used to
          // be a plain cast, which null survived; a match without this arm would throw instead.
          s"case null => null; " +
          s"case converted$$: ${logicalType.convertedType(schema)} => ${logicalType.fromConverted("converted$", schema)}; " +
          s"case encoded$$: ${rawShapeOf(schema, fixedPattern)} => {${logicalType.toType(bound, schema)}}; " +
          s"case other$$ => throw new org.apache.avro.AvroRuntimeException(" +
          s"""\"Cannot decode ${logicalType.name} from \" + other$$.getClass.getName) } }"""
      }.getOrElse(value)

    /**
     * The same two shapes as acceptEitherShape, exposed separately for a union: there the incoming
     * value is already being matched, so the branch contributes two case arms rather than a match
     * of its own.
     */
    def convertedTypeFor(schema: Schema): Option[String] = logicalTypeFor(schema).map(_.convertedType(schema))

    def fromConvertedFor(schema: Schema, value: String): String =
      logicalTypeFor(schema).map(_.fromConverted(value, schema)).getOrElse(value)

    /** The runtime type of the value Avro hands put when nothing converted it on the way in. */
    def rawShapeOf(schema: Schema, fixedPattern: Option[String] = None): String = schema.getType match {
      case STRING => "CharSequence"
      case INT => "Int"
      case LONG => "Long"
      case BYTES => "java.nio.ByteBuffer"
      case FIXED => fixedPattern.getOrElse("org.apache.avro.generic.GenericFixed")
      case other => throw new IllegalStateException(s"No supported logical type sits on $other")
    }

    def getType(schema: Schema, default: String): String =
      logicalTypeFor(schema).map(_.getType(schema)).getOrElse(default)

    def getDefault(schema: Schema): String =
      logicalTypeFor(schema).map(_.defaultValue(schema)).getOrElse("null")

    def logicalTypeInUse(schema: Schema): Boolean = logicalTypeFor(schema).isDefined

    def conversionSite(schema: Schema): Option[ConversionSite] = logicalTypeFor(schema).map(_.conversionSite)

    /** Avro applies the conversion, so get returns the field untouched and put receives it converted. */
    def delegates(schema: Schema): Boolean = conversionSite(schema).contains(ConversionSite.Delegated)

    /**
     * The generated code converts, in get and in put. Such a conversion casts the value to whatever
     * it needs, so a caller must not pre-cast it to something narrower.
     */
    def selfConverts(schema: Schema): Boolean = conversionSite(schema).exists(_ != ConversionSite.Delegated)

    /** put may receive an already-converted value, because something converted it on the way in. */
    def putReceivesConverted(schema: Schema): Boolean = conversionSite(schema).exists(_ != ConversionSite.Generated)

    /** put may receive either shape, so it has to accept both. See ConversionSite.ModelOnly. */
    def putConversionIsOptional(schema: Schema): Boolean = conversionSite(schema).contains(ConversionSite.ModelOnly)

    /**
     * The conversion getConversion advertises to Avro. A self-converting type advertises nothing:
     * get already hands back the encoded form, and SpecificDatumWriter.writeField would apply an
     * advertised conversion to that value a second time.
     */
    def getConversionClass(schema: Schema): Option[String] =
      logicalTypeFor(schema).filterNot(_.selfConverting).flatMap(_.conversionClass)

    /** What the model must carry, which is not the same set - see collectConversionClasses. */
    private def registeredConversionClass(schema: Schema): Option[String] =
      logicalTypeFor(schema).flatMap(_.conversionClass)

    def helperConversionFor(schema: Schema): Option[String] = logicalTypeFor(schema).flatMap(_.helperConversion)

    /** The expression registering a conversion, given the class name a schema resolved to. */
    def conversionExpressionFor(conversionClass: String): String =
      logicalTypeMap.values.toList.distinct
        .collectFirst { case lt if lt.conversionClass.contains(conversionClass) => lt.conversionExpression }
        .flatten
        .getOrElse(s"new $conversionClass()")

    /**
     * Every conversion the record's model must carry, including those nested inside MAP values,
     * ARRAY items and UNION branches. A superset of what getConversion advertises: a ModelOnly
     * conversion is not advertised but still has to be registered, or the model stops applying it.
     */
    def collectConversionClasses(schema: Schema): List[String] = {
      import scala.jdk.CollectionConverters._
      // Nested records are included because the model is per-reader, not per-record: a logical type
      // sitting inside an array, map or union of a nested record is converted against the outermost
      // record's model. seen guards recursive schemas.
      def loop(s: Schema, seen: Set[String]): List[String] = s.getType match {
        case Schema.Type.MAP    => loop(s.getValueType, seen)
        case Schema.Type.ARRAY  => loop(s.getElementType, seen)
        case Schema.Type.UNION  => s.getTypes.asScala.toList.flatMap(loop(_, seen))
        case Schema.Type.RECORD =>
          if (seen(s.getFullName)) Nil
          else s.getFields.asScala.toList.flatMap(f => loop(f.schema(), seen + s.getFullName))
        case _                  => registeredConversionClass(s).orElse(helperConversionFor(s)).toList
      }
      loop(schema, Set.empty)
    }
  }

  /**
   * Where a logical type's conversion runs. Three states, and every code path that emits a logical
   * type has to agree with which one applies.
   */
  sealed trait ConversionSite

  object ConversionSite {
    /** avro2s converts, in the generated get and put. Nothing is registered with Avro. */
    case object Generated extends ConversionSite

    /** avro2s registers the conversion and returns it from getConversion, so Avro always applies it. */
    case object Delegated extends ConversionSite

    /**
     * The conversion is registered in the model but not returned from getConversion. Avro applies
     * it wherever the model is consulted - the fast reader, and every nested position - but not
     * where getConversion is, which is a top-level field on the slow reader. put therefore sees
     * the converted value on some paths and the raw encoded one on others, and must take either.
     */
    case object ModelOnly extends ConversionSite
  }

  abstract class LogicalType(val name: String, val associatedTypes: Set[Type]) {
    def toType(value: String, schema: Schema): String

    def fromType(value: String, schema: Schema): String

    def getType(schema: Schema): String

    def validate(schema: Schema): Boolean = true

    def defaultValue(schema: Schema): String

    /**
     * The Avro Conversion to delegate to, or None when avro2s must convert this type itself -
     * because Avro ships no usable conversion, or because its converted type disagrees with the
     * Scala type declared by getType.
     */
    def conversionClass: Option[String]

    /**
     * How to construct the registered conversion. Normally just the class, but a type whose Avro
     * conversion is wrong registers a corrected subclass instead.
     *
     * Declining to delegate does not stop a conversion happening on the way in: Avro looks a read
     * conversion up by logical type name against whichever model is in play, so a populated model
     * converts whatever getConversion returns. It does decide the way out, because Avro looks a
     * write conversion up by the datum's own class - see GenericDatumWriter.write.
     */
    def conversionExpression: Option[String] = conversionClass.map(cls => s"new $cls()")

    /**
     * An Avro Conversion the generated code calls itself, for a type avro2s does not delegate but
     * whose encoding is still best left to Avro. Registered in the model although getConversion
     * does not advertise it, and emitted once on the named type's companion so it is not allocated
     * on every call - which, inside a collection, means every element.
     */
    def helperConversion: Option[String] = None

    /**
     * The class Avro's own conversion produces for this logical type. put has to accept it
     * alongside the encoded form, because whether a conversion ran on the way in is decided by the
     * model in play rather than by us. Defaults to the Scala field type, which is what Avro
     * produces for every type whose conversion agrees with ours.
     */
    def convertedType(schema: Schema): String = getType(schema)

    /** Turns Avro's converted value into the Scala field type. Identity unless the two differ. */
    def fromConverted(value: String, schema: Schema): String = value

    /**
     * Migration flag: true once this type converts in the generated get and accepts either shape in
     * put. Removed once every type is switched over, at which point ConversionSite collapses too.
     */
    def selfConverting: Boolean = false

    /** Derived rather than declared, so the three states cannot contradict each other. */
    final def conversionSite: ConversionSite =
      if (selfConverting) ConversionSite.ModelOnly
      else if (conversionClass.isDefined) ConversionSite.Delegated
      else if (helperConversion.isDefined) ConversionSite.ModelOnly
      else ConversionSite.Generated
  }

  case object UUID extends LogicalType("uuid", Set(STRING)) {
    override def toType(value: String, schema: Schema): String = s"java.util.UUID.fromString($value)"

    override def fromType(value: String, schema: Schema): String = s"$value.toString"

    override def getType(schema: Schema): String = "java.util.UUID"

    override def defaultValue(schema: Schema): String = "java.util.UUID.fromString(\"00000000-0000-0000-0000-000000000000\")"

    override def conversionClass: Option[String] = Some("org.apache.avro.Conversions.UUIDConversion")

    override def selfConverting: Boolean = true
  }

  case object Date extends LogicalType("date", Set(INT)) {
    override def toType(value: String, schema: Schema): String = s"java.time.LocalDate.ofEpochDay($value)"

    override def fromType(value: String, schema: Schema): String = s"$value.toEpochDay.toInt"

    override def getType(schema: Schema): String = "java.time.LocalDate"

    override def defaultValue(schema: Schema): String = "java.time.LocalDate.ofEpochDay(0)"

    override def conversionClass: Option[String] = Some("org.apache.avro.data.TimeConversions.DateConversion")

    override def selfConverting: Boolean = true
  }

  case object TimeMillisecondPrecision extends LogicalType("time-millis", Set(INT)) {
    override def toType(value: String, schema: Schema): String = s"java.time.LocalTime.ofNanoOfDay($value * 1000000L)"

    override def fromType(value: String, schema: Schema): String = s"($value.toNanoOfDay / 1000000L).toInt"

    override def getType(schema: Schema): String = "java.time.LocalTime"

    override def defaultValue(schema: Schema): String = "java.time.LocalTime.ofNanoOfDay(0)"

    override def conversionClass: Option[String] = Some("org.apache.avro.data.TimeConversions.TimeMillisConversion")

    override def selfConverting: Boolean = true
  }

  case object TimeMicrosecondPrecision extends LogicalType("time-micros", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"java.time.LocalTime.ofNanoOfDay($value * 1000L)"

    override def fromType(value: String, schema: Schema): String = s"$value.toNanoOfDay / 1000L"

    override def getType(schema: Schema): String = "java.time.LocalTime"

    override def defaultValue(schema: Schema): String = "java.time.LocalTime.ofNanoOfDay(0)"

    override def conversionClass: Option[String] = Some("org.apache.avro.data.TimeConversions.TimeMicrosConversion")

    override def selfConverting: Boolean = true
  }

  case object TimestampMillisecondPrecision extends LogicalType("timestamp-millis", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"java.time.Instant.ofEpochMilli($value)"

    override def fromType(value: String, schema: Schema): String = s"$value.toEpochMilli"

    override def getType(schema: Schema): String = "java.time.Instant"

    override def defaultValue(schema: Schema): String = "java.time.Instant.ofEpochMilli(0)"

    override def conversionClass: Option[String] = Some("org.apache.avro.data.TimeConversions.TimestampMillisConversion")

    override def selfConverting: Boolean = true
  }

  case object TimestampMicrosecondPrecision extends LogicalType("timestamp-micros", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"java.time.Instant.ofEpochSecond($value / 1000000L, ($value % 1000000L) * 1000L)"

    override def fromType(value: String, schema: Schema): String = s"($value.getEpochSecond * 1000000L) + ($value.getNano / 1000L)"

    override def getType(schema: Schema): String = "java.time.Instant"

    override def defaultValue(schema: Schema): String = "java.time.Instant.ofEpochSecond(0, 0)"

    override def conversionClass: Option[String] = Some("org.apache.avro.data.TimeConversions.TimestampMicrosConversion")

    override def selfConverting: Boolean = true
  }

  case object LocalTimestampMillisecondPrecision extends LogicalType("local-timestamp-millis", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"""java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli($value), java.time.ZoneId.of("UTC"))"""

    override def fromType(value: String, schema: Schema): String = s"""$value.atZone(java.time.ZoneId.of("UTC")).toInstant.toEpochMilli"""

    override def getType(schema: Schema): String = "java.time.LocalDateTime"

    override def defaultValue(schema: Schema): String = "java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(0), java.time.ZoneId.of(\"UTC\"))"

    override def conversionClass: Option[String] = Some("org.apache.avro.data.TimeConversions.LocalTimestampMillisConversion")

    override def selfConverting: Boolean = true
  }

  case object LocalTimestampMicrosecondPrecision extends LogicalType("local-timestamp-micros", Set(LONG)) {
    override def toType(value: String, schema: Schema): String = s"""java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond($value / 1000000L, ($value % 1000000L) * 1000L), java.time.ZoneId.of("UTC"))"""

    override def fromType(value: String, schema: Schema): String = s"""$value.atZone(java.time.ZoneId.of("UTC")).toInstant.getEpochSecond * 1000000L + $value.atZone(java.time.ZoneId.of("UTC")).toInstant.getNano / 1000L"""

    override def getType(schema: Schema): String = "java.time.LocalDateTime"

    override def defaultValue(schema: Schema): String = "java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochSecond(0, 0), java.time.ZoneId.of(\"UTC\"))"

    override def conversionClass: Option[String] = Some("org.apache.avro.data.TimeConversions.LocalTimestampMicrosConversion")

    override def selfConverting: Boolean = true
  }

  case object TimestampNanosecondPrecision extends LogicalType("timestamp-nanos", Set(LONG)) {
    override def toType(value: String, schema: Schema): String =
      s"java.time.Instant.ofEpochSecond(java.lang.Math.floorDiv($value, 1000000000L), java.lang.Math.floorMod($value, 1000000000L))"

    override def fromType(value: String, schema: Schema): String =
      s"java.lang.Math.addExact(java.lang.Math.multiplyExact($value.getEpochSecond, 1000000000L), $value.getNano.toLong)"

    override def getType(schema: Schema): String = "java.time.Instant"

    override def defaultValue(schema: Schema): String = "java.time.Instant.ofEpochSecond(0L, 0L)"

    // Avro 1.12's TimestampNanosConversion is wrong before the epoch: its negative branch subtracts
    // 1000000L where it means 1000000000L, so 1969-12-31T23:59:59.500Z encodes to a positive number
    // and reads back as 1970-01-01T00:00:00.499Z - silently, and on the wrong side of the epoch.
    override def conversionClass: Option[String] = Some("org.apache.avro.data.TimeConversions.TimestampNanosConversion")

    override def conversionExpression: Option[String] = Some(
      "new org.apache.avro.data.TimeConversions.TimestampNanosConversion() { " +
        "override def fromLong(value: java.lang.Long, schema: org.apache.avro.Schema, logicalType: org.apache.avro.LogicalType): java.time.Instant = " +
        "java.time.Instant.ofEpochSecond(java.lang.Math.floorDiv(value.longValue, 1000000000L), java.lang.Math.floorMod(value.longValue, 1000000000L)); " +
        "override def toLong(value: java.time.Instant, schema: org.apache.avro.Schema, logicalType: org.apache.avro.LogicalType): java.lang.Long = " +
        "java.lang.Long.valueOf(java.lang.Math.addExact(java.lang.Math.multiplyExact(value.getEpochSecond, 1000000000L), value.getNano.toLong)) }")

    override def selfConverting: Boolean = true
  }

  case object LocalTimestampNanosecondPrecision extends LogicalType("local-timestamp-nanos", Set(LONG)) {
    // floorDiv/floorMod, not / and %: LocalDateTime.ofEpochSecond requires nanoOfSecond in
    // 0..999999999, and % yields a negative remainder for any pre-epoch value.
    override def toType(value: String, schema: Schema): String =
      s"java.time.LocalDateTime.ofEpochSecond(java.lang.Math.floorDiv($value, 1000000000L), java.lang.Math.floorMod($value, 1000000000L).toInt, java.time.ZoneOffset.UTC)"

    override def fromType(value: String, schema: Schema): String =
      s"java.lang.Math.addExact(java.lang.Math.multiplyExact($value.toEpochSecond(java.time.ZoneOffset.UTC), 1000000000L), $value.getNano.toLong)"

    override def getType(schema: Schema): String = "java.time.LocalDateTime"

    override def defaultValue(schema: Schema): String =
      "java.time.LocalDateTime.ofEpochSecond(0L, 0, java.time.ZoneOffset.UTC)"

    // Same pre-epoch defect as timestamp-nanos, corrected the same way.
    override def conversionClass: Option[String] = Some("org.apache.avro.data.TimeConversions.LocalTimestampNanosConversion")

    override def conversionExpression: Option[String] = Some(
      "new org.apache.avro.data.TimeConversions.LocalTimestampNanosConversion() { " +
        "override def fromLong(value: java.lang.Long, schema: org.apache.avro.Schema, logicalType: org.apache.avro.LogicalType): java.time.LocalDateTime = " +
        "java.time.LocalDateTime.ofEpochSecond(java.lang.Math.floorDiv(value.longValue, 1000000000L), java.lang.Math.floorMod(value.longValue, 1000000000L).toInt, java.time.ZoneOffset.UTC); " +
        "override def toLong(value: java.time.LocalDateTime, schema: org.apache.avro.Schema, logicalType: org.apache.avro.LogicalType): java.lang.Long = " +
        "java.lang.Long.valueOf(java.lang.Math.addExact(java.lang.Math.multiplyExact(value.toEpochSecond(java.time.ZoneOffset.UTC), 1000000000L), value.getNano.toLong)) }")

    override def selfConverting: Boolean = true
  }

  case object Decimal extends LogicalType("decimal", Set(BYTES, FIXED)) {
    override def toType(value: String, schema: Schema): String = {
      val scale = Option(schema.getLogicalType)
        .collect { case d: org.apache.avro.LogicalTypes.Decimal => d }
        .map(_.getScale)
        .getOrElse(0)
      if (schema.getType == FIXED)
        // A fixed is padded to its full width on the wire, so most of what arrives is sign
        // extension carrying no information - 1234 in a 16-byte fixed is fourteen zero bytes and
        // two of value. Dropping the redundant prefix usually leaves something that fits in a
        // Long, which skips the BigInteger and the int[] it holds. A leading byte is only
        // redundant when the next byte's top bit agrees with the sign; otherwise removing it would
        // flip the sign. Nothing here affects what is written.
        s"{ val raw$$ = $value.bytes(); " +
          s"val sign$$ = if (raw$$(0) < 0) -1L else 0L; val signByte$$ = sign$$.toByte; " +
          s"var first$$ = 0; " +
          s"while (first$$ < raw$$.length - 1 && raw$$(first$$) == signByte$$ && ((raw$$(first$$ + 1) < 0) == (signByte$$ < 0))) first$$ += 1; " +
          s"if (raw$$.length - first$$ <= 8) { " +
          s"var unscaled$$ = sign$$; var index$$ = first$$; " +
          s"while (index$$ < raw$$.length) { unscaled$$ = (unscaled$$ << 8) | (raw$$(index$$) & 0xFFL); index$$ += 1 }; " +
          s"scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$$, $scale)) " +
          s"} else scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(raw$$), $scale)) }"
      else
        // Two paths. An unscaled value of eight bytes or fewer fits in a Long, so it can be
        // accumulated straight out of the buffer and handed to BigDecimal.valueOf, which keeps the
        // compact long representation. That avoids the byte[] copy, the BigInteger and the int[]
        // BigInteger holds - three allocations of the four. Absolute gets are used, so the
        // caller's buffer is never touched and needs no position restore.
        //
        // The general path stays for wider values. It reads via remaining rather than array():
        // Avro hands put the very buffer get returned for the previous record, reusing it when the
        // new value is shorter. It narrows the limit but keeps the longer backing array, so
        // array() would read stale trailing bytes and silently decode a different number. array()
        // also ignores arrayOffset and throws on a read-only buffer. The position is restored so
        // put does not consume a buffer its caller still holds.
        //
        // A zero-length value is left to the general path, which throws on it as it always has.
        s"{ val buffer$$ = $value; val length$$ = buffer$$.remaining; " +
          s"if (length$$ >= 1 && length$$ <= 8) { " +
          s"val offset$$ = buffer$$.position(); " +
          s"var unscaled$$ = if (buffer$$.get(offset$$) < 0) -1L else 0L; " +
          s"var index$$ = 0; " +
          s"while (index$$ < length$$) { unscaled$$ = (unscaled$$ << 8) | (buffer$$.get(offset$$ + index$$) & 0xFFL); index$$ += 1 }; " +
          s"scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled$$, $scale)) " +
          s"} else { " +
          s"val offset$$ = buffer$$.position(); val bytes$$ = new Array[Byte](length$$); buffer$$.get(bytes$$); (buffer$$: java.nio.Buffer).position(offset$$); " +
          s"scala.math.BigDecimal(new java.math.BigDecimal(new java.math.BigInteger(bytes$$), $scale)) } }"
    }

    override def fromType(value: String, schema: Schema): String = {
      val decimalType = Option(schema.getLogicalType).collect { case d: org.apache.avro.LogicalTypes.Decimal => d }
      val scale = decimalType.map(_.getScale).getOrElse(0)
      val precision = decimalType.map(_.getPrecision).getOrElse(Int.MaxValue)
      // setScale without a rounding mode already rejects a value too precise for the scale. Avro
      // additionally rejects one too precise for the declared precision, and does so with an
      // AvroTypeException; without this check avro2s writes records Avro itself would refuse.
      val guard =
        s"""val decimal$$ = (try $value.setScale($scale).bigDecimal catch { case _: ArithmeticException => throw new org.apache.avro.AvroTypeException("Cannot encode decimal with scale " + $value.scale + " as scale $scale") }); if (decimal$$.precision > $precision) throw new org.apache.avro.AvroTypeException("Cannot encode decimal with precision " + decimal$$.precision + " as max precision $precision"); """
      if (schema.getType == FIXED) {
        val fixedSize = schema.getFixedSize
        val fullName = schema.getFullName
        // As for bytes, a value below 19 digits is written straight from a Long, which avoids the
        // BigInteger, its int[] and the intermediate array toByteArray returns. Only the
        // sign-extension prefix is filled, and only when the value is negative: a fresh array is
        // already zeroed, so filling all of it and then overwriting the tail was doing the work
        // twice.
        val overflow = s"""throw new org.apache.avro.AvroTypeException("Cannot encode decimal in " + $fixedSize + " bytes")"""
        guard + s"""val padded$$ = new Array[Byte]($fixedSize); if (decimal$$.precision <= 18) { val unscaled$$ = decimal$$.movePointRight($scale).longValueExact(); val width$$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$$ < 0) ~unscaled$$ else unscaled$$)) / 8 + 1; if (width$$ > $fixedSize) $overflow; if (unscaled$$ < 0) java.util.Arrays.fill(padded$$, 0, $fixedSize - width$$, 0xFF.toByte); var rest$$ = unscaled$$; var at$$ = $fixedSize - 1; while (at$$ >= $fixedSize - width$$) { padded$$(at$$) = (rest$$ & 0xFFL).toByte; rest$$ >>= 8; at$$ -= 1 } } else { val unscaled$$ = decimal$$.unscaledValue().toByteArray; if (unscaled$$.length > $fixedSize) $overflow; if (unscaled$$(0) < 0) java.util.Arrays.fill(padded$$, 0, $fixedSize - unscaled$$.length, 0xFF.toByte); System.arraycopy(unscaled$$, 0, padded$$, $fixedSize - unscaled$$.length, unscaled$$.length) }; val result$$ = new $fullName(); result$$.bytes(padded$$); result$$"""
      } else
        // unscaledValue() has to materialise a BigInteger, and every ordinary way of building a
        // decimal - the String constructor, valueOf, arithmetic - leaves it compact, so that cost
        // is paid on nearly every write. Below 19 digits the unscaled value fits in a Long and the
        // minimal two's-complement encoding can be written directly, which is the same byte
        // sequence BigInteger.toByteArray produces. movePointRight lands the unscaled value at
        // scale zero without inflating it.
        guard + s"""if (decimal$$.precision <= 18) { val unscaled$$ = decimal$$.movePointRight($scale).longValueExact(); val width$$ = (64 - java.lang.Long.numberOfLeadingZeros(if (unscaled$$ < 0) ~unscaled$$ else unscaled$$)) / 8 + 1; val encoded$$ = new Array[Byte](width$$); var rest$$ = unscaled$$; var at$$ = width$$ - 1; while (at$$ >= 0) { encoded$$(at$$) = (rest$$ & 0xFFL).toByte; rest$$ >>= 8; at$$ -= 1 }; java.nio.ByteBuffer.wrap(encoded$$) } else java.nio.ByteBuffer.wrap(decimal$$.unscaledValue().toByteArray)"""
    }

    override def getType(schema: Schema): String = "scala.math.BigDecimal"

    override def defaultValue(schema: Schema): String = "scala.math.BigDecimal(0)"

    // Not delegated. Avro's DecimalConversion is correct, but it produces java.math.BigDecimal
    // while getType above declares scala.math.BigDecimal, so Avro cannot be handed this field.
    override def conversionClass: Option[String] = None

    override def validate(schema: Schema): Boolean =
      Option(schema.getLogicalType).exists(_.isInstanceOf[org.apache.avro.LogicalTypes.Decimal])

    // Avro ships a DecimalConversion but SpecificData.get() deliberately does not register it, so
    // normally nothing converts and put sees the encoded form. A caller who registers it globally
    // used to break every decimal record; taking java.math.BigDecimal as the converted shape makes
    // that case work instead. The field is scala.math.BigDecimal, so it needs wrapping.
    override def convertedType(schema: Schema): String = "java.math.BigDecimal"

    override def fromConverted(value: String, schema: Schema): String = s"scala.math.BigDecimal($value)"

    override def selfConverting: Boolean = true
  }

  case object AvroJavaBigDecimal extends LogicalType("big-decimal", Set(BYTES)) {
    override def toType(value: String, schema: Schema): String =
      s"$value.asInstanceOf[java.math.BigDecimal]"

    override def fromType(value: String, schema: Schema): String =
      s"new org.apache.avro.Conversions.BigDecimalConversion().toBytes($value, null, null)"

    override def getType(schema: Schema): String = "java.math.BigDecimal"

    override def defaultValue(schema: Schema): String = "java.math.BigDecimal.ZERO"

    override def validate(schema: Schema): Boolean = schema.getType == BYTES

    override def conversionClass: Option[String] = Some("org.apache.avro.Conversions.BigDecimalConversion")
  }

  case object Duration extends LogicalType("duration", Set(FIXED)) {
    // The encoded form only. Accepting a TimePeriod as well is the converter's job now, since every
    // logical type needs the same two arms - see LogicalTypeConverter.acceptEitherShape.
    override def toType(value: String, schema: Schema): String = {
      // Read back the three words fromType writes, rather than calling Avro's fromFixed, which
      // wraps the array in a ByteBuffer and an IntBuffer view to do the same thing. Each word is
      // an unsigned 32-bit little-endian value, so it is masked into a Long rather than an Int.
      def word(offset: Int) =
        s"((bytes$$($offset) & 0xFFL) | ((bytes$$(${offset + 1}) & 0xFFL) << 8) | " +
          s"((bytes$$(${offset + 2}) & 0xFFL) << 16) | ((bytes$$(${offset + 3}) & 0xFFL) << 24))"
      s"{ val bytes$$ = $value.bytes(); " +
        s"org.apache.avro.util.TimePeriod.of(${word(0)}, ${word(4)}, ${word(8)}) }"
    }

    override def fromType(value: String, schema: Schema): String = {
      val fullName = schema.getFullName
      // Avro's toFixed allocates a ByteBuffer, an IntBuffer view over it, the array behind them
      // and a GenericData.Fixed - four objects to carry twelve bytes. The fixed this has to return
      // already owns a twelve-byte array from its constructor, so the three words are written
      // straight into it. The layout is Avro's own: months, days and milliseconds as unsigned
      // little-endian 32-bit words.
      def word(offset: Int) =
        s"bytes$$($offset) = word$$.toByte; bytes$$(${offset + 1}) = (word$$ >>> 8).toByte; " +
          s"bytes$$(${offset + 2}) = (word$$ >>> 16).toByte; bytes$$(${offset + 3}) = (word$$ >>> 24).toByte; "
      s"{ val period$$ = $value; val result$$ = new $fullName(); val bytes$$ = result$$.bytes(); " +
        s"var word$$ = period$$.getMonths.toInt; " + word(0) +
        s"word$$ = period$$.getDays.toInt; " + word(4) +
        s"word$$ = period$$.getMillis.toInt; " + word(8) +
        s"result$$ }"
    }

    override def getType(schema: Schema): String = "org.apache.avro.util.TimePeriod"

    override def validate(schema: Schema): Boolean = schema.getFixedSize == 12

    override def defaultValue(schema: Schema): String = "org.apache.avro.util.TimePeriod.of(0L, 0L, 0L)"

    // Not delegated, despite Avro's DurationConversion being correct and its converted type
    // matching. Delegating means get returns the TimePeriod, and SpecificRecordBase.equals compares
    // through GenericData.compare, which casts to Comparable - TimePeriod is only a TemporalAmount.
    // Every record holding a duration would lose equals. Converting here keeps get returning the
    // fixed, which compares fine.
    override def conversionClass: Option[String] = None


    override def helperConversion: Option[String] = Some("org.apache.avro.Conversions.DurationConversion")
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