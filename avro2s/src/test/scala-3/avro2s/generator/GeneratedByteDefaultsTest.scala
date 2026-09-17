package avro2s.generator

import avro2s.serialization.SerializationHelpers.{deserialize, serialize}
import avro2s.test.spec.{AvroSpec, Suit}
import avro2s.test.unions.Unions
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import java.nio.ByteBuffer

class GeneratedByteDefaultsTest extends AnyFunSuite with Matchers {
  test("no-arg records share empty byte defaults in direct fields and unions") {
    val first = new AvroSpec()
    val second = new AvroSpec()
    val union = new Unions()
    val field = union.getSchema.getField("_union_of_bytes").pos()

    first._bytes.length shouldBe 0
    first._bytes should be theSameInstanceAs Array.emptyByteArray
    second._bytes should be theSameInstanceAs first._bytes
    union.get(field).asInstanceOf[ByteBuffer].array() should be theSameInstanceAs first._bytes
  }

  test("assigning byte values leaves other records' empty defaults unchanged") {
    val first = new AvroSpec()
    val second = new AvroSpec()
    val data = Array[Byte](1, 2, 3)
    first._bytes = data

    first._bytes should be theSameInstanceAs data
    second._bytes should be theSameInstanceAs Array.emptyByteArray
    second._bytes.length shouldBe 0

    first.put(first.getSchema.getField("_bytes").pos(), ByteBuffer.wrap(Array[Byte](4, 5)))
    first._bytes.toSeq shouldBe Seq[Byte](4, 5)
    data.toSeq shouldBe Seq[Byte](1, 2, 3)
    second._bytes.length shouldBe 0
  }

  test("shared empty defaults preserve bytes on the wire and populated round-trips") {
    val direct = new AvroSpec()
    direct._enum = Suit.SPADES
    val emptyWire = serialize(direct).toSeq
    direct._bytes = new Array[Byte](0)
    serialize(direct).toSeq shouldBe emptyWire
    deserialize[AvroSpec](serialize(direct), direct.getSchema)._bytes.length shouldBe 0

    direct._bytes = Array[Byte](1, -2, 3)
    deserialize[AvroSpec](serialize(direct), direct.getSchema)._bytes.toSeq shouldBe direct._bytes.toSeq

    val union = new Unions()
    val field = union.getSchema.getField("_union_of_bytes").pos()
    val emptyUnionWire = serialize(union).toSeq
    union.put(field, ByteBuffer.wrap(new Array[Byte](0)))
    serialize(union).toSeq shouldBe emptyUnionWire

    union.put(field, ByteBuffer.wrap(Array[Byte](4, -5, 6)))
    val decoded = deserialize[Unions](serialize(union), union.getSchema)
    decoded.get(field).asInstanceOf[ByteBuffer].array().toSeq shouldBe Seq[Byte](4, -5, 6)
  }
}
