package avro2s.generator

import avro2s.serialization.SerializationHelpers._
import org.apache.avro.AvroTypeException
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

/** Regressions for the issues an adversarial review of this branch turned up. */
class ReviewRegressionTest extends AnyFunSuite with Matchers {

  test("a schema whose field names collide with generated locals round-trips") {
    // CollidingNames names fields after every local the decimal, duration and collection
    // conversions declare. The stronger guard is that it compiles at all - it is regenerated on
    // every build - but it has to work too.
    val record = new avro2s.test.logical.CollidingNames()
    record.decimal = scala.math.BigDecimal("12.34")
    record.padded = scala.math.BigDecimal("56.78")
    record.result = scala.math.BigDecimal("-9.01")
    record.period = org.apache.avro.util.TimePeriod.of(1L, 2L, 3L)
    record.iterator = List(scala.math.BigDecimal("1.23"))
    record.entry = Map("k" -> scala.math.BigDecimal("4.56"))

    val result = deserialize[avro2s.test.logical.CollidingNames](serialize(record), record.getSchema)
    result.decimal shouldBe record.decimal
    result.padded shouldBe record.padded
    result.result shouldBe record.result
    result.period shouldBe record.period
    result.iterator shouldBe record.iterator
    result.entry shouldBe record.entry
  }

  private def withNanos(seconds: Long): avro2s.test.logical.LogicalTypes = {
    val record = new avro2s.test.logical.LogicalTypes()
    record._timestamp_nanos = java.time.Instant.ofEpochSecond(seconds, 0)
    record
  }

  test("a nanos timestamp beyond the representable range is refused, not wrapped") {
    // Stock Avro uses multiplyExact/addExact here. The corrected conversion has to keep that, or a
    // timestamp past roughly year 2262 silently wraps to a negative instant on the wire.
    val beyond = Long.MaxValue / 1000000000L + 1
    an[ArithmeticException] should be thrownBy serialize(withNanos(beyond))
  }

  test("a nanos timestamp just inside the range still works") {
    val inside = Long.MaxValue / 1000000000L - 1
    noException should be thrownBy serialize(withNanos(inside))
  }

  test("a null duration is accepted by put rather than raising a MatchError") {
    // put used to be a plain cast, which null survives. Accepting either a TimePeriod or a raw
    // fixed turned it into a match, and a match without a null case throws.
    val record = new avro2s.test.logical.LogicalDuration()
    noException should be thrownBy record.put(0, null)
    record._duration shouldBe null
  }

  test("both ways a decimal can fail to fit raise the same exception type") {
    // Avro raises AvroTypeException for a scale that would round and for a precision that
    // overflows. avro2s used to raise ArithmeticException for the first, so a caller catching the
    // Avro type caught only half of them.
    val tooMuchScale = new avro2s.test.logical.LogicalTypes()
    tooMuchScale._decimal = scala.math.BigDecimal("12.345")
    an[AvroTypeException] should be thrownBy serialize(tooMuchScale)

    val tooMuchPrecision = new avro2s.test.logical.LogicalTypes()
    tooMuchPrecision._decimal = scala.math.BigDecimal("123456789.01")
    an[AvroTypeException] should be thrownBy serialize(tooMuchPrecision)
  }
}
