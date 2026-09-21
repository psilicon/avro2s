package avro2s.generator

import avro2s.serialization.SerializationHelpers._
import org.apache.avro.AvroTypeException
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

/**
 * Avro's DecimalConversion rejects a value whose precision exceeds the schema's before encoding it.
 * avro2s converts decimals itself, so without the same check it writes records Avro would refuse -
 * readable by avro2s, rejected by every other Avro implementation.
 */
class DecimalPrecisionTest extends AnyFunSuite with Matchers {
  test("a bytes decimal within the declared precision is written") {
    // precision 10, scale 2
    val record = new avro2s.test.logical.LogicalTypes()
    record._decimal = scala.math.BigDecimal("12345678.90")
    noException should be thrownBy serialize(record)
  }

  test("a bytes decimal exceeding the declared precision is rejected") {
    val record = new avro2s.test.logical.LogicalTypes()
    record._decimal = scala.math.BigDecimal("123456789.01")
    an[AvroTypeException] should be thrownBy serialize(record)
  }

  test("a fixed decimal exceeding the declared precision is rejected") {
    // precision 4, scale 2
    val record = avro2s.test.logical.LogicalFixedDecimal(_decimal_fixed = scala.math.BigDecimal("123.45"))
    an[AvroTypeException] should be thrownBy serialize(record)
  }
}
