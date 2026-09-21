package avro2s.generator

import avro2s.test.logical.LogicalTypes
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import java.nio.ByteBuffer

/**
 * A decimal reaches put as a ByteBuffer, and the generated code reads the bytes out of it. Nothing
 * guarantees that buffer is a plain heap buffer positioned at zero: it can be a slice with a
 * non-zero array offset, read-only, or direct, and a caller may still want it afterwards.
 */
class DecimalBufferShapeTest extends AnyFunSuite with Matchers {
  private val expected = scala.math.BigDecimal("12.34")
  private val decimalIndex = 10

  private def encoded: Array[Byte] = {
    val record = new LogicalTypes()
    record._decimal = expected
    val buffer = record.get(decimalIndex).asInstanceOf[ByteBuffer]
    val bytes = new Array[Byte](buffer.remaining)
    buffer.get(bytes)
    bytes
  }

  private def readBack(buffer: ByteBuffer): scala.math.BigDecimal = {
    val record = new LogicalTypes()
    record.put(decimalIndex, buffer)
    record._decimal
  }

  test("a decimal decodes from a heap buffer") {
    readBack(ByteBuffer.wrap(encoded)) shouldBe expected
  }

  test("a decimal decodes from a slice with a non-zero array offset") {
    val bytes = encoded
    val backing = ByteBuffer.allocate(bytes.length + 3)
    backing.position(3)
    backing.put(bytes)
    backing.position(3)
    readBack(backing.slice()) shouldBe expected
  }

  test("a decimal decodes from a read-only buffer") {
    readBack(ByteBuffer.wrap(encoded).asReadOnlyBuffer()) shouldBe expected
  }

  test("a decimal decodes from a direct buffer") {
    val bytes = encoded
    val direct = ByteBuffer.allocateDirect(bytes.length)
    direct.put(bytes)
    direct.flip()
    readBack(direct) shouldBe expected
  }

  test("put leaves the caller's buffer unconsumed") {
    val buffer = ByteBuffer.wrap(encoded)
    readBack(buffer) shouldBe expected
    buffer.position() shouldBe 0
  }
}
