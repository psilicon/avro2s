package avro2s.generator

import avro2s.serialization.SerializationHelpers.serialize
import avro2s.test.arrays.{Record => ArrayRecord}
import org.apache.avro.generic.{GenericDatumReader, GenericRecord}
import org.apache.avro.io.{DecoderFactory, Encoder, ResolvingDecoder}
import org.apache.avro.specific.SpecificDatumReader
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class CustomCoderRuntimeTest extends AnyFunSuite with Matchers {
  test("stock Avro constructors exercise the selected runtime path on regenerated fixtures") {
    var encodes = 0
    var decodes = 0
    var gets = 0
    var puts = 0
    val record = new ArrayRecord("custom-coder coverage", 1234) {
      override def customEncode(out: Encoder): Unit = {
        encodes += 1
        super.customEncode(out)
      }
      override def customDecode(in: ResolvingDecoder): Unit = {
        decodes += 1
        super.customDecode(in)
      }
      override def get(index: Int): AnyRef = {
        gets += 1
        super.get(index)
      }
      override def put(index: Int, value: Any): Unit = {
        puts += 1
        super.put(index, value)
      }
    }
    val custom = record.getSpecificData.useCustomCoders()
    val fast = record.getSpecificData.isFastReaderEnabled
    val expectedCustom = sys.props.getOrElse("avro2s.test.expectedCustomCoders", "true").toBoolean
    // Fail if the build silently stops exercising customDecode (e.g. fast reader enabled).
    custom shouldBe expectedCustom
    fast shouldBe !expectedCustom
    val bytes = serialize(record)
    encodes shouldBe (if (custom) 1 else 0)
    gets shouldBe (if (custom) 0 else 2)

    val generic = new GenericDatumReader[GenericRecord](record.getSchema)
      .read(null, DecoderFactory.get().binaryDecoder(bytes, null))
    generic.get("_string").toString shouldBe "custom-coder coverage"
    generic.get("_int").asInstanceOf[Integer].intValue() shouldBe 1234

    record._string = "reused"
    record._int = -1
    val reader = new SpecificDatumReader[ArrayRecord](record.getSchema)
    reader.read(record, DecoderFactory.get().binaryDecoder(bytes, null)) should be theSameInstanceAs record
    decodes shouldBe (if (custom && !fast) 1 else 0)
    puts shouldBe (if (custom && !fast) 0 else 2)
    record._string shouldBe "custom-coder coverage"
    record._int shouldBe 1234
  }
}
