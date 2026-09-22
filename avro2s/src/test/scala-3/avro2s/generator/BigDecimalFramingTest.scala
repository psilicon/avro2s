package avro2s.generator

import org.apache.avro.Conversions
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

/**
 * big-decimal is framed as a miniature Avro record inside the outer bytes field: the unscaled
 * two's-complement bytes as an Avro `bytes` (zigzag varint length, then the bytes) followed by the
 * scale as a zigzag varint int. Generated code writes and reads that framing itself rather than
 * calling Avro's BigDecimalConversion, so Avro's conversion is the oracle for both directions.
 *
 * The values below are chosen to move every part of the framing: a scale past 63 and past 8191
 * forces a multi-byte varint, a negative scale forces the zigzag sign bit, and an unscaled value
 * over 63 bytes forces a multi-byte length.
 */
class BigDecimalFramingTest extends AnyFunSuite with Matchers {
  private val index = 12
  private val schema = avro2s.test.logical.LogicalMatrixDirect.SCHEMA$.getFields.get(index).schema()
  private val conversion = new Conversions.BigDecimalConversion()

  private val values = List(
    java.math.BigDecimal.ZERO,
    java.math.BigDecimal.ONE,
    new java.math.BigDecimal("1.5"),
    new java.math.BigDecimal("1.50"),
    new java.math.BigDecimal("1.500"),
    new java.math.BigDecimal("-0.5"),
    new java.math.BigDecimal("-12345678901234567890.123456789"),
    new java.math.BigDecimal(java.math.BigInteger.valueOf(123L), -3),            // negative scale
    new java.math.BigDecimal(java.math.BigInteger.ONE, 100),                     // 2-byte scale varint
    new java.math.BigDecimal(java.math.BigInteger.ONE, 100000),                  // 3-byte scale varint
    new java.math.BigDecimal(java.math.BigInteger.ONE, -100000),                 // negative, multi-byte
    new java.math.BigDecimal(new java.math.BigInteger("9" * 200), 7),            // >63 unscaled bytes
    new java.math.BigDecimal(java.math.BigInteger.valueOf(Long.MaxValue), 0),
    new java.math.BigDecimal(java.math.BigInteger.valueOf(Long.MinValue), 18))

  private def ours(value: java.math.BigDecimal): java.nio.ByteBuffer = {
    val record = new avro2s.test.logical.LogicalMatrixDirect()
    record._big_decimal = value
    record.get(index).asInstanceOf[java.nio.ByteBuffer]
  }

  private def theirs(value: java.math.BigDecimal): java.nio.ByteBuffer =
    conversion.toBytes(value, schema, schema.getLogicalType)

  private def bytesOf(buffer: java.nio.ByteBuffer): Array[Byte] = {
    val copy = buffer.duplicate()
    val array = new Array[Byte](copy.remaining)
    copy.get(array)
    array
  }

  private def decodedBy(record: avro2s.test.logical.LogicalMatrixDirect): java.math.BigDecimal =
    record._big_decimal

  test("our encoding is byte-identical to Avro's own conversion") {
    values.foreach { value =>
      withClue(s"value $value: ") { bytesOf(ours(value)) shouldBe bytesOf(theirs(value)) }
    }
  }

  test("our decoding agrees with Avro's own conversion on Avro's own bytes") {
    values.foreach { value =>
      withClue(s"value $value: ") {
        val record = new avro2s.test.logical.LogicalMatrixDirect()
        record.put(index, theirs(value))
        decodedBy(record) shouldBe conversion.fromBytes(theirs(value), schema, schema.getLogicalType)
        decodedBy(record) shouldBe value
      }
    }
  }

  test("scale is preserved, so trailing zeroes stay distinct") {
    values.foreach { value =>
      val record = new avro2s.test.logical.LogicalMatrixDirect()
      record.put(index, ours(value))
      withClue(s"value $value: ") { decodedBy(record).scale shouldBe value.scale }
    }
  }

  test("put does not consume the caller's buffer") {
    // Avro hands put the very buffer the previous record's get returned, so a decoder that moves
    // the position corrupts whatever reads it next.
    values.foreach { value =>
      val buffer = ours(value)
      val before = buffer.position()
      val record = new avro2s.test.logical.LogicalMatrixDirect()
      record.put(index, buffer)
      withClue(s"value $value: ") {
        buffer.position() shouldBe before
        decodedBy(record) shouldBe value
      }
    }
  }

  test("a buffer with a non-zero arrayOffset or no array at all still decodes") {
    // Avro's own fromBytes reads through array(), which ignores arrayOffset and throws outright on
    // a read-only buffer. Absolute gets handle both.
    values.foreach { value =>
      val encoded = bytesOf(ours(value))

      val padded = java.nio.ByteBuffer.allocate(encoded.length + 8)
      padded.position(8)
      padded.put(encoded)
      padded.position(8)
      val sliced = padded.slice()

      val readOnly = java.nio.ByteBuffer.wrap(encoded).asReadOnlyBuffer()

      val direct = java.nio.ByteBuffer.allocateDirect(encoded.length)
      direct.put(encoded)
      (direct: java.nio.Buffer).flip()

      List("slice" -> sliced, "read-only" -> readOnly, "direct" -> direct).foreach {
        case (shape, buffer) =>
          val record = new avro2s.test.logical.LogicalMatrixDirect()
          record.put(index, buffer)
          withClue(s"value $value as $shape: ") { decodedBy(record) shouldBe value }
      }
    }
  }
}
