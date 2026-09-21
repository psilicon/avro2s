package avro2s.generator

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import java.math.BigInteger
import java.nio.ByteBuffer

/**
 * A decimal on bytes is the unscaled value in minimal two's-complement form - exactly what
 * BigInteger.toByteArray produces, and what every other Avro implementation expects. avro2s
 * encodes narrow values straight from a Long instead of going through BigInteger, so the two must
 * agree byte for byte. A round-trip through avro2s alone cannot show that: a wrong encoding that
 * avro2s also decodes would pass while being unreadable everywhere else.
 */
class DecimalEncodingTest extends AnyFunSuite with Matchers {
  private val decimalIndex = 10
  private val scale = 2

  private def encoded(unscaled: Long): Array[Byte] = {
    val record = new avro2s.test.logical.LogicalTypes()
    record._decimal = scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled, scale))
    val buffer = record.get(decimalIndex).asInstanceOf[ByteBuffer]
    val bytes = new Array[Byte](buffer.remaining)
    buffer.get(bytes)
    bytes
  }

  // Sign and width boundaries: each is where the minimal encoding gains a byte.
  private val unscaledValues =
    List(0L, 1L, -1L, 127L, -128L, 128L, -129L, 32767L, -32768L, 32768L, -32769L, 9999999999L, -9999999999L)

  test("a narrow decimal encodes exactly as BigInteger.toByteArray would") {
    unscaledValues.foreach { unscaled =>
      withClue(s"unscaled $unscaled: ") {
        encoded(unscaled) shouldBe BigInteger.valueOf(unscaled).toByteArray
      }
    }
  }

  test("a narrow decimal survives a round trip through its own encoding") {
    unscaledValues.foreach { unscaled =>
      withClue(s"unscaled $unscaled: ") {
        val record = new avro2s.test.logical.LogicalTypes()
        record.put(decimalIndex, ByteBuffer.wrap(encoded(unscaled)))
        record._decimal shouldBe scala.math.BigDecimal(java.math.BigDecimal.valueOf(unscaled, scale))
      }
    }
  }
}
