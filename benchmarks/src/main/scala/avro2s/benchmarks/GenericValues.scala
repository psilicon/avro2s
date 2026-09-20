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

  // A stable seed derived from the schema's name keeps values identical across runs, JVMs and
  // the revisions being compared, while still differing between schemas.
  private def seedFor(schema: Schema): Long = schema.getFullName.hashCode.toLong

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

  private def isUuid(schema: Schema): Boolean =
    schema.getLogicalType != null && schema.getLogicalType.getName == "uuid"

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
      case FIXED =>
        val bytes = new Array[Byte](schema.getFixedSize)
        random.nextBytes(bytes)
        new GenericData.Fixed(schema, bytes)
      case BYTES =>
        val bytes = new Array[Byte](math.max(0, size))
        random.nextBytes(bytes)
        ByteBuffer.wrap(bytes)
      // The uuid logical type is the one case where an arbitrary string is not a legal value:
      // Avro's own conversion parses it on read.
      case STRING if isUuid(schema) => new java.util.UUID(random.nextLong(), random.nextLong()).toString
      case STRING => text(random, math.max(4, size))
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
