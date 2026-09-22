package avro2s.benchmarks

import org.apache.avro.Schema
import org.apache.avro.generic.GenericData

import java.nio.ByteBuffer
import scala.util.Random

/**
 * Builds Avro's own in-memory representation of a datum for any schema.
 *
 * Values are deliberately generic rather than model-specific: writing them with a plain
 * GenericDatumWriter produces the wire bytes without involving any generated code, so the
 * generated reader has something independent to decode. Logical types are ignored here for
 * the same reason - the base type is what appears on the wire.
 *
 * Generation is seeded per record, so every arm of a comparison measures identical values.
 */
object GenericValues {
  def record(schema: Schema, size: Int): GenericData.Record =
    value(schema, new Random(seedFor(schema)), size, depth = 0).asInstanceOf[GenericData.Record]

  // A stable seed keeps values identical across runs, JVMs and the revisions being compared,
  // while still differing between schemas. It must come from the simple name, never the full
  // name: the namespace is exactly what differs between the arms of a comparison, so seeding on
  // it would hand each arm different data - different union branches above all - and the two
  // would no longer be measuring the same work.
  private def seedFor(schema: Schema): Long = schema.getName.hashCode.toLong

  // Nested collections multiply out, so only the outermost level uses the requested size.
  private def sizeAt(size: Int, depth: Int): Int =
    if (depth == 0) size else math.max(1, size / 4)

  private def text(random: Random, length: Int): String = {
    val builder = new java.lang.StringBuilder(length)
    var index = 0
    while (index < length) {
      builder.append(('a' + random.nextInt(26)).toChar)
      index += 1
    }
    builder.toString
  }

  private val millisPerDay = 86400000
  // Roughly fifty years either side of the epoch: wide enough to be representative, narrow
  // enough that no unit overflows java.time.
  private val millisRange = 1_600_000_000_000L

  private def logicalInt(logicalType: String, random: Random): Int = logicalType match {
    case "time-millis" => random.nextInt(millisPerDay)
    case "date" => random.nextInt(40000) - 20000
    case _ => random.nextInt(millisPerDay)
  }

  private def logicalLong(logicalType: String, random: Random): Long = {
    def within(bound: Long): Long = math.floorMod(random.nextLong(), bound)
    logicalType match {
      case "time-micros" => within(millisPerDay.toLong * 1000L)
      case "time-nanos" => within(millisPerDay.toLong * 1000000L)
      case "timestamp-micros" | "local-timestamp-micros" => within(millisRange * 1000L) - (millisRange * 1000L / 2)
      // Scaled like micros above. Left at millisRange these landed within about 800 seconds of the
      // epoch, so they zigzag-encoded to two or three bytes instead of the eight or nine a real
      // nanosecond timestamp needs, and the benchmark measured an unrepresentatively cheap encode.
      case "timestamp-nanos" | "local-timestamp-nanos" => within(millisRange * 1000000L) - (millisRange * 1000000L / 2)
      case _ => within(millisRange) - (millisRange / 2)
    }
  }

  private def isUuid(schema: Schema): Boolean =
    schema.getLogicalType != null && schema.getLogicalType.getName == "uuid"

  private def logicalName(schema: Schema): String =
    if (schema.getLogicalType == null) "" else schema.getLogicalType.getName

  private val bigDecimalConversion = new org.apache.avro.Conversions.BigDecimalConversion()

  private def value(schema: Schema, random: Random, size: Int, depth: Int): AnyRef = {
    import Schema.Type._
    schema.getType match {
      case RECORD =>
        val result = new GenericData.Record(schema)
        val fields = schema.getFields.iterator()
        while (fields.hasNext) {
          val field = fields.next()
          result.put(field.pos(), value(field.schema(), random, size, depth))
        }
        result
      case ARRAY =>
        val count = sizeAt(size, depth)
        val result = new java.util.ArrayList[AnyRef](count)
        var index = 0
        while (index < count) {
          result.add(value(schema.getElementType, random, size, depth + 1))
          index += 1
        }
        result
      case MAP =>
        val count = sizeAt(size, depth)
        val result = new java.util.HashMap[String, AnyRef]()
        var index = 0
        while (index < count) {
          result.put(s"key_$index", value(schema.getValueType, random, size, depth + 1))
          index += 1
        }
        result
      case UNION =>
        val branches = schema.getTypes
        value(branches.get(random.nextInt(branches.size())), random, size, depth)
      case ENUM =>
        val symbols = schema.getEnumSymbols
        new GenericData.EnumSymbol(schema, symbols.get(random.nextInt(symbols.size())))
      // A decimal on a fixed is an unscaled two's-complement integer sign-extended to the full
      // width, and it has to fit the declared precision - random bytes give an arbitrary 16-byte
      // integer, which is ~39 digits and rejected by Avro. Bounding it also makes the padding path
      // this shape is meant to measure actually run.
      case FIXED if logicalName(schema) == "decimal" =>
        val precision = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal].getPrecision
        val bound = math.pow(10, math.min(precision, 18).toDouble).toLong
        val unscaled = java.math.BigInteger.valueOf(random.nextLong() % bound).toByteArray
        val padded = new Array[Byte](schema.getFixedSize)
        java.util.Arrays.fill(padded, if (unscaled(0) < 0) 0xFF.toByte else 0x00.toByte)
        System.arraycopy(unscaled, 0, padded, padded.length - unscaled.length, unscaled.length)
        new GenericData.Fixed(schema, padded)
      case FIXED =>
        val bytes = new Array[Byte](schema.getFixedSize)
        random.nextBytes(bytes)
        new GenericData.Fixed(schema, bytes)
      // A decimal on bytes carries the unscaled value in minimal two's-complement form, so
      // arbitrary bytes would not survive a round trip through BigInteger.
      case BYTES if logicalName(schema) == "decimal" =>
        ByteBuffer.wrap(java.math.BigInteger.valueOf(random.nextLong() % 1000000000000000L).toByteArray)
      // big-decimal is Avro's own encoding of scale plus unscaled value; only Avro can write it.
      case BYTES if logicalName(schema) == "big-decimal" =>
        bigDecimalConversion.toBytes(
          new java.math.BigDecimal(java.math.BigInteger.valueOf(random.nextLong() % 1000000000000000L), 4),
          schema, schema.getLogicalType)
      case BYTES =>
        val bytes = new Array[Byte](math.max(0, size))
        random.nextBytes(bytes)
        ByteBuffer.wrap(bytes)
      // The uuid logical type is the one case where an arbitrary string is not a legal value:
      // Avro's own conversion parses it on read.
      case STRING if isUuid(schema) => new java.util.UUID(random.nextLong(), random.nextLong()).toString
      case STRING => text(random, math.max(4, size))
      // An int or long carrying a logical type is not free to be any value: Avro's conversions
      // reject a time outside a day, and a wild timestamp overflows java.time on read.
      case INT if schema.getLogicalType != null => Int.box(logicalInt(schema.getLogicalType.getName, random))
      case LONG if schema.getLogicalType != null => Long.box(logicalLong(schema.getLogicalType.getName, random))
      case INT => Int.box(random.nextInt())
      // Values beyond the JVM's small-integer cache, so boxing costs are measured honestly.
      case LONG => Long.box(random.nextInt().toLong + 1024L)
      case FLOAT => Float.box(random.nextFloat())
      case DOUBLE => Double.box(random.nextDouble())
      case BOOLEAN => Boolean.box(random.nextBoolean())
      case NULL => null
      case other => sys.error(s"Unsupported benchmark schema type: $other")
    }
  }
}
