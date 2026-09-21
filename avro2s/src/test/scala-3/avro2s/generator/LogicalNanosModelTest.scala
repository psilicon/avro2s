package avro2s.generator

import avro2s.serialization.SerializationHelpers._
import avro2s.test.logical._
import org.apache.avro.generic.{GenericData, GenericDatumReader, GenericRecord}
import org.apache.avro.io.DecoderFactory
import org.apache.avro.specific.SpecificData
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import scala.jdk.CollectionConverters._

/**
 * Nanosecond precision before the epoch, in nested positions.
 *
 * Avro's own TimestampNanosConversion.toLong is wrong for instants with a negative epoch second and
 * a non-zero nano: it adjusts by `nanos - 1_000_000` where the second it borrowed is 1_000_000_000,
 * leaving the encoded value ~0.999s out. avro2s registers a corrected subclass, but a nested
 * logical type is converted against the reader's model rather than getConversion(pos), so the
 * correction only takes effect if Avro actually finds MODEL$ - which needs it to be a static field.
 *
 * The matrix fixture cannot cover this: every instant in it is post-epoch, and the buggy branch is
 * only reachable with a negative second.
 */
class LogicalNanosModelTest extends AnyFunSuite with Matchers {
  private val instant = java.time.Instant.ofEpochSecond(-1500000000L, 123456789)
  private val localDateTime = java.time.LocalDateTime.ofEpochSecond(-1500000000L, 123456789, java.time.ZoneOffset.UTC)

  test("MODEL$ is reachable by Avro's reflective lookup") {
    // The whole point of the @static annotation: without it this silently returns SpecificData.get().
    SpecificData.getForClass(classOf[LogicalMatrixArrays]) should be theSameInstanceAs LogicalMatrixArrays.MODEL$
    SpecificData.getForClass(classOf[LogicalMatrixArrays]) should not be theSameInstanceAs(SpecificData.get())
  }

  test("pre-epoch nanos round-trips inside an array") {
    val record = new LogicalMatrixArrays()
    record._timestamp_nanos = List(instant)
    record._local_timestamp_nanos = List(localDateTime)

    val result = deserialize[LogicalMatrixArrays](serialize(record), record.getSchema)
    result._timestamp_nanos shouldBe List(instant)
    result._local_timestamp_nanos shouldBe List(localDateTime)
  }

  test("pre-epoch nanos round-trips inside a map") {
    val record = new LogicalMatrixMaps()
    record._timestamp_nanos = Map("k" -> instant)
    record._local_timestamp_nanos = Map("k" -> localDateTime)

    val result = deserialize[LogicalMatrixMaps](serialize(record), record.getSchema)
    result._timestamp_nanos shouldBe Map("k" -> instant)
    result._local_timestamp_nanos shouldBe Map("k" -> localDateTime)
  }

  test("pre-epoch nanos round-trips inside a union") {
    val record = new LogicalMatrixUnions()
    record._timestamp_nanos = Some(instant)
    record._local_timestamp_nanos = Some(localDateTime)

    val result = deserialize[LogicalMatrixUnions](serialize(record), record.getSchema)
    result._timestamp_nanos shouldBe Some(instant)
    result._local_timestamp_nanos shouldBe Some(localDateTime)
  }

  test("pre-epoch nanos are written as true epoch nanos, not round-tripped through a shared error") {
    // A round-trip cannot distinguish a correct conversion from one that is wrong symmetrically, so
    // assert the encoded value directly by reading it back with a model that has no conversions.
    val record = new LogicalMatrixArrays()
    record._timestamp_nanos = List(instant)
    record._local_timestamp_nanos = List(localDateTime)

    val schema = record.getSchema
    val reader = new GenericDatumReader[GenericRecord](schema, schema, new GenericData())
    val raw = reader.read(null, DecoderFactory.get().binaryDecoder(serialize(record), null))

    def firstLong(field: String): Long =
      raw.get(field).asInstanceOf[java.util.Collection[Any]].asScala.head.asInstanceOf[Long]

    firstLong("_timestamp_nanos") shouldBe instant.getEpochSecond * 1000000000L + instant.getNano
    firstLong("_local_timestamp_nanos") shouldBe
      localDateTime.toEpochSecond(java.time.ZoneOffset.UTC) * 1000000000L + localDateTime.getNano
  }
}
