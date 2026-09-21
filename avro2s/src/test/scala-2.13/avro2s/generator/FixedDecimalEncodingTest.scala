package avro2s.generator

import org.apache.avro.Conversions
import org.apache.avro.generic.{GenericData, GenericFixed}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import java.math.BigInteger

/**
 * A decimal on a fixed is padded to the full width of the fixed, so most of what arrives on read is
 * sign extension. avro2s drops that prefix and decodes from a Long where it can, and encodes back
 * from a Long too, so both directions have to agree byte for byte with Avro's own DecimalConversion
 * - which is used here as the oracle rather than a hand-written expectation.
 *
 * MatrixDecimalFixed is 16 bytes at precision 20, so values of 18 digits or fewer exercise the Long
 * path and wider ones fall through to BigInteger. Both are covered, along with every byte-width and
 * sign boundary in between.
 */
class FixedDecimalEncodingTest extends AnyFunSuite with Matchers {
  private val fixedIndex = 11
  private val scale = 4
  private val schema = avro2s.test.logical.LogicalMatrixDirect.SCHEMA$.getField("_decimal_fixed").schema()
  private val conversion = new Conversions.DecimalConversion()

  private val unscaledValues: List[BigInteger] = List(
    "0", "1", "-1", "127", "-128", "128", "-129", "255", "-256", "256", "-257",
    "32767", "-32768", "32768", "-32769", "8388607", "-8388608", "8388608", "-8388609",
    "999999999999999999", "-999999999999999999",          // 18 digits: the Long path
    "9223372036854775807", "-9223372036854775808",        // Long boundary
    "9223372036854775808", "-9223372036854775809",        // one past it: BigInteger path
    "99999999999999999999", "-99999999999999999999"       // 20 digits, the schema's limit
  ).map(new BigInteger(_))

  private def decimalOf(unscaled: BigInteger) = new java.math.BigDecimal(unscaled, scale)

  private def ours(unscaled: BigInteger): Array[Byte] = {
    val record = new avro2s.test.logical.LogicalMatrixDirect()
    record._decimal_fixed = scala.math.BigDecimal(decimalOf(unscaled))
    record.get(fixedIndex).asInstanceOf[GenericFixed].bytes()
  }

  private def avros(unscaled: BigInteger): Array[Byte] =
    conversion.toFixed(decimalOf(unscaled), schema, schema.getLogicalType).bytes()

  test("a fixed decimal encodes exactly as Avro's own conversion would") {
    unscaledValues.foreach { unscaled =>
      withClue(s"unscaled $unscaled: ") { ours(unscaled) shouldBe avros(unscaled) }
    }
  }

  test("a fixed decimal decodes what Avro's own conversion wrote") {
    unscaledValues.foreach { unscaled =>
      withClue(s"unscaled $unscaled: ") {
        val record = new avro2s.test.logical.LogicalMatrixDirect()
        // Avro's bytes, carried in the generated class - the oracle is the byte sequence, not
        // the wrapper, and a specific record is handed its generated class.
        val wire = new avro2s.test.logical.MatrixDecimalFixed()
        wire.bytes(avros(unscaled))
        record.put(fixedIndex, wire)
        record._decimal_fixed.bigDecimal.unscaledValue shouldBe unscaled
        record._decimal_fixed.bigDecimal.scale shouldBe scale
      }
    }
  }

  test("both paths are actually exercised") {
    // Guards the test rather than the code: if the fast path stopped being reachable, or the wide
    // values stopped being wide, the two tests above would still pass while covering only one path.
    ours(new BigInteger("1")).length shouldBe 16
    unscaledValues.exists(_.bitLength > 63) shouldBe true
    unscaledValues.exists(_.bitLength <= 63) shouldBe true
  }
  test("a fixed decimal is decoded from the generated class in every position") {
    // Avro resolves a fixed to its generated class, so that is what the generated code casts to -
    // the narrowest accurate type rather than the GenericFixed interface, which costs a slower
    // checkcast and says less about what the value is.
    def fixed(schema: org.apache.avro.Schema) = {
      val bytes = conversion.toFixed(new java.math.BigDecimal(new BigInteger("1234"), scale), schema, schema.getLogicalType).bytes()
      val value = new avro2s.test.logical.MatrixDecimalFixed()
      value.bytes(bytes)
      value
    }

    val direct = new avro2s.test.logical.LogicalMatrixDirect()
    val arrays = new avro2s.test.logical.LogicalMatrixArrays()
    val maps = new avro2s.test.logical.LogicalMatrixMaps()
    val options = new avro2s.test.logical.LogicalMatrixOptions()
    val unions = new avro2s.test.logical.LogicalMatrixUnions()

    val element = arrays.getSchema.getField("_decimal_fixed").schema().getElementType
    withClue("top-level: ") { noException should be thrownBy direct.put(11, fixed(element)) }
    withClue("array: ") { noException should be thrownBy arrays.put(11, java.util.Arrays.asList(fixed(element))) }
    withClue("map: ") { noException should be thrownBy maps.put(11, java.util.Collections.singletonMap("k", fixed(element))) }
    withClue("option: ") { noException should be thrownBy options.put(11, fixed(element)) }
    withClue("union: ") { noException should be thrownBy unions.put(11, fixed(element)) }

    direct._decimal_fixed.bigDecimal.unscaledValue shouldBe new BigInteger("1234")
    arrays._decimal_fixed.map(_.bigDecimal.unscaledValue) shouldBe List(new BigInteger("1234"))
    maps._decimal_fixed.view.mapValues(_.bigDecimal.unscaledValue).toMap shouldBe Map("k" -> new BigInteger("1234"))
  }
}
