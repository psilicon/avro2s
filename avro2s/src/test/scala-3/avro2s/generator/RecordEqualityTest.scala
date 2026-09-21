package avro2s.generator

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

/**
 * Generated records emit neither equals nor hashCode, so both come from SpecificRecordBase, which
 * defers to GenericData.compare and GenericData.hashCode walking the fields through get(i). That
 * is what gives byte arrays content equality rather than the reference equality a field-wise
 * equals would produce, and it is what makes a logical value compare on its encoded form. These
 * tests pin that, so a future attempt to hand-roll equals for speed has to preserve it.
 */
class RecordEqualityTest extends AnyFunSuite with Matchers {
  private def withBytes(content: Array[Byte]): avro2s.test.spec.AvroSpec = {
    val record = new avro2s.test.spec.AvroSpec()
    record._bytes = content
    record
  }

  test("byte array fields compare by content, not by reference") {
    val left = withBytes(Array[Byte](1, 2, 3))
    val right = withBytes(Array[Byte](1, 2, 3))
    (left._bytes eq right._bytes) shouldBe false
    left shouldBe right
    left.hashCode shouldBe right.hashCode
  }

  test("byte array fields of differing content are unequal") {
    withBytes(Array[Byte](1, 2, 3)) should not be withBytes(Array[Byte](1, 2, 4))
  }

  private def logical(decimal: String): avro2s.test.logical.LogicalTypes = {
    val record = new avro2s.test.logical.LogicalTypes()
    record._uuid = java.util.UUID.fromString("f81d4fae-7dec-11d0-a765-00a0c91e6bf6")
    record._timestamp_millis = java.time.Instant.ofEpochMilli(1700000000123L)
    record._decimal = scala.math.BigDecimal(decimal)
    record
  }

  test("logical fields compare by value") {
    logical("12.34") shouldBe logical("12.34")
    logical("12.34").hashCode shouldBe logical("12.34").hashCode
    logical("12.34") should not be logical("12.35")
  }

  test("a decimal compares on its encoded form, so trailing scale does not matter") {
    // Both are written at the schema's scale of 2, so they are the same value on the wire.
    logical("12.3") shouldBe logical("12.30")
  }
  test("hashCode reaches a decimal that sits early enough to be hashed") {
    // The logical test above does NOT exercise its decimal: Avro's HashCodeCalculator spends a
    // budget of 10 units and _decimal is field 10, so hashing stops before it. LogicalFixedDecimal
    // holds its decimal at field 0, so this one genuinely covers the conversion.
    def fixedDecimal(value: String) =
      avro2s.test.logical.LogicalFixedDecimal(_decimal_fixed = scala.math.BigDecimal(value))

    fixedDecimal("12.34").hashCode shouldBe fixedDecimal("12.34").hashCode
    fixedDecimal("12.34") shouldBe fixedDecimal("12.34")
    fixedDecimal("12.34") should not be fixedDecimal("12.35")
  }

  test("a decimal that cannot be encoded makes the record unprintable") {
    // Documented rather than desirable: get is the encoding path, and SpecificRecordBase routes
    // toString, equals and hashCode through get, so a value that cannot be written cannot be shown
    // either. Pinned so the behaviour is a decision rather than a surprise.
    val invalid = avro2s.test.logical.LogicalFixedDecimal(_decimal_fixed = scala.math.BigDecimal("12.345"))
    an[org.apache.avro.AvroTypeException] should be thrownBy invalid.toString
    an[org.apache.avro.AvroTypeException] should be thrownBy invalid.hashCode
  }
}
