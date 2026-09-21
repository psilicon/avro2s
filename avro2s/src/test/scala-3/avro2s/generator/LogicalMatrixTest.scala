package avro2s.generator

import avro2s.generator.logical.LogicalTypes
import avro2s.serialization.SerializationHelpers._
import avro2s.test.logical._
import org.apache.avro.Schema
import org.apache.avro.io.DecoderFactory
import org.apache.avro.specific.SpecificDatumReader
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import scala.jdk.CollectionConverters._

/**
 * Every supported logical type crossed with every position it can occupy. Nested positions are the
 * point: getConversion(pos) only covers top-level fields, so a logical type inside an array, map or
 * union is handled by the generated code or by MODEL$, and those paths are easy to get wrong
 * independently of the top-level one.
 */
class LogicalMatrixTest extends AnyFunSuite with Matchers {
  private def populated: LogicalMatrix =
  LogicalMatrix(
    LogicalMatrixDirect(
    java.util.UUID.fromString("f81d4fae-7dec-11d0-a765-00a0c91e6bf6"),
    java.time.LocalDate.ofEpochDay(19000),
    java.time.LocalTime.of(23, 59, 59, 999000000),
    java.time.LocalTime.of(23, 59, 59, 999999000),
    java.time.Instant.ofEpochMilli(1700000000123L),
    java.time.Instant.ofEpochSecond(1700000000L, 123456000),
    java.time.Instant.ofEpochSecond(1700000000L, 123456789),
    java.time.LocalDateTime.ofEpochSecond(1700000000L, 123000000, java.time.ZoneOffset.UTC),
    java.time.LocalDateTime.ofEpochSecond(1700000000L, 123456000, java.time.ZoneOffset.UTC),
    java.time.LocalDateTime.ofEpochSecond(1700000000L, 123456789, java.time.ZoneOffset.UTC),
    scala.math.BigDecimal("12345.67"),
    scala.math.BigDecimal("1234567.8901"),
    new java.math.BigDecimal("12345.6789"),
    org.apache.avro.util.TimePeriod.of(1L, 2L, 3L)),
    LogicalMatrixArrays(
    List(java.util.UUID.fromString("f81d4fae-7dec-11d0-a765-00a0c91e6bf6")),
    List(java.time.LocalDate.ofEpochDay(19000)),
    List(java.time.LocalTime.of(23, 59, 59, 999000000)),
    List(java.time.LocalTime.of(23, 59, 59, 999999000)),
    List(java.time.Instant.ofEpochMilli(1700000000123L)),
    List(java.time.Instant.ofEpochSecond(1700000000L, 123456000)),
    List(java.time.Instant.ofEpochSecond(1700000000L, 123456789)),
    List(java.time.LocalDateTime.ofEpochSecond(1700000000L, 123000000, java.time.ZoneOffset.UTC)),
    List(java.time.LocalDateTime.ofEpochSecond(1700000000L, 123456000, java.time.ZoneOffset.UTC)),
    List(java.time.LocalDateTime.ofEpochSecond(1700000000L, 123456789, java.time.ZoneOffset.UTC)),
    List(scala.math.BigDecimal("12345.67")),
    List(scala.math.BigDecimal("1234567.8901")),
    List(new java.math.BigDecimal("12345.6789")),
    List(org.apache.avro.util.TimePeriod.of(1L, 2L, 3L))),
    LogicalMatrixMaps(
    Map("k" -> java.util.UUID.fromString("f81d4fae-7dec-11d0-a765-00a0c91e6bf6")),
    Map("k" -> java.time.LocalDate.ofEpochDay(19000)),
    Map("k" -> java.time.LocalTime.of(23, 59, 59, 999000000)),
    Map("k" -> java.time.LocalTime.of(23, 59, 59, 999999000)),
    Map("k" -> java.time.Instant.ofEpochMilli(1700000000123L)),
    Map("k" -> java.time.Instant.ofEpochSecond(1700000000L, 123456000)),
    Map("k" -> java.time.Instant.ofEpochSecond(1700000000L, 123456789)),
    Map("k" -> java.time.LocalDateTime.ofEpochSecond(1700000000L, 123000000, java.time.ZoneOffset.UTC)),
    Map("k" -> java.time.LocalDateTime.ofEpochSecond(1700000000L, 123456000, java.time.ZoneOffset.UTC)),
    Map("k" -> java.time.LocalDateTime.ofEpochSecond(1700000000L, 123456789, java.time.ZoneOffset.UTC)),
    Map("k" -> scala.math.BigDecimal("12345.67")),
    Map("k" -> scala.math.BigDecimal("1234567.8901")),
    Map("k" -> new java.math.BigDecimal("12345.6789")),
    Map("k" -> org.apache.avro.util.TimePeriod.of(1L, 2L, 3L))),
    LogicalMatrixOptions(
    Some(java.util.UUID.fromString("f81d4fae-7dec-11d0-a765-00a0c91e6bf6")),
    Some(java.time.LocalDate.ofEpochDay(19000)),
    Some(java.time.LocalTime.of(23, 59, 59, 999000000)),
    Some(java.time.LocalTime.of(23, 59, 59, 999999000)),
    Some(java.time.Instant.ofEpochMilli(1700000000123L)),
    Some(java.time.Instant.ofEpochSecond(1700000000L, 123456000)),
    Some(java.time.Instant.ofEpochSecond(1700000000L, 123456789)),
    Some(java.time.LocalDateTime.ofEpochSecond(1700000000L, 123000000, java.time.ZoneOffset.UTC)),
    Some(java.time.LocalDateTime.ofEpochSecond(1700000000L, 123456000, java.time.ZoneOffset.UTC)),
    Some(java.time.LocalDateTime.ofEpochSecond(1700000000L, 123456789, java.time.ZoneOffset.UTC)),
    Some(scala.math.BigDecimal("12345.67")),
    Some(scala.math.BigDecimal("1234567.8901")),
    Some(new java.math.BigDecimal("12345.6789")),
    Some(org.apache.avro.util.TimePeriod.of(1L, 2L, 3L))),
    LogicalMatrixUnions(
    Some(java.util.UUID.fromString("f81d4fae-7dec-11d0-a765-00a0c91e6bf6")),
    Some(java.time.LocalDate.ofEpochDay(19000)),
    Some(java.time.LocalTime.of(23, 59, 59, 999000000)),
    Some(java.time.LocalTime.of(23, 59, 59, 999999000)),
    Some(java.time.Instant.ofEpochMilli(1700000000123L)),
    Some(java.time.Instant.ofEpochSecond(1700000000L, 123456000)),
    Some(java.time.Instant.ofEpochSecond(1700000000L, 123456789)),
    Some(java.time.LocalDateTime.ofEpochSecond(1700000000L, 123000000, java.time.ZoneOffset.UTC)),
    Some(java.time.LocalDateTime.ofEpochSecond(1700000000L, 123456000, java.time.ZoneOffset.UTC)),
    Some(java.time.LocalDateTime.ofEpochSecond(1700000000L, 123456789, java.time.ZoneOffset.UTC)),
    Some(scala.math.BigDecimal("12345.67")),
    Some(scala.math.BigDecimal("1234567.8901")),
    Some(new java.math.BigDecimal("12345.6789")),
    Some(org.apache.avro.util.TimePeriod.of(1L, 2L, 3L))),
    LogicalMatrixArraysOfMaps(
    List(Map("k" -> java.util.UUID.fromString("f81d4fae-7dec-11d0-a765-00a0c91e6bf6"))),
    List(Map("k" -> java.time.LocalDate.ofEpochDay(19000))),
    List(Map("k" -> java.time.LocalTime.of(23, 59, 59, 999000000))),
    List(Map("k" -> java.time.LocalTime.of(23, 59, 59, 999999000))),
    List(Map("k" -> java.time.Instant.ofEpochMilli(1700000000123L))),
    List(Map("k" -> java.time.Instant.ofEpochSecond(1700000000L, 123456000))),
    List(Map("k" -> java.time.Instant.ofEpochSecond(1700000000L, 123456789))),
    List(Map("k" -> java.time.LocalDateTime.ofEpochSecond(1700000000L, 123000000, java.time.ZoneOffset.UTC))),
    List(Map("k" -> java.time.LocalDateTime.ofEpochSecond(1700000000L, 123456000, java.time.ZoneOffset.UTC))),
    List(Map("k" -> java.time.LocalDateTime.ofEpochSecond(1700000000L, 123456789, java.time.ZoneOffset.UTC))),
    List(Map("k" -> scala.math.BigDecimal("12345.67"))),
    List(Map("k" -> scala.math.BigDecimal("1234567.8901"))),
    List(Map("k" -> new java.math.BigDecimal("12345.6789"))),
    List(Map("k" -> org.apache.avro.util.TimePeriod.of(1L, 2L, 3L)))),
    LogicalMatrixMapsOfArrays(
    Map("k" -> List(java.util.UUID.fromString("f81d4fae-7dec-11d0-a765-00a0c91e6bf6"))),
    Map("k" -> List(java.time.LocalDate.ofEpochDay(19000))),
    Map("k" -> List(java.time.LocalTime.of(23, 59, 59, 999000000))),
    Map("k" -> List(java.time.LocalTime.of(23, 59, 59, 999999000))),
    Map("k" -> List(java.time.Instant.ofEpochMilli(1700000000123L))),
    Map("k" -> List(java.time.Instant.ofEpochSecond(1700000000L, 123456000))),
    Map("k" -> List(java.time.Instant.ofEpochSecond(1700000000L, 123456789))),
    Map("k" -> List(java.time.LocalDateTime.ofEpochSecond(1700000000L, 123000000, java.time.ZoneOffset.UTC))),
    Map("k" -> List(java.time.LocalDateTime.ofEpochSecond(1700000000L, 123456000, java.time.ZoneOffset.UTC))),
    Map("k" -> List(java.time.LocalDateTime.ofEpochSecond(1700000000L, 123456789, java.time.ZoneOffset.UTC))),
    Map("k" -> List(scala.math.BigDecimal("12345.67"))),
    Map("k" -> List(scala.math.BigDecimal("1234567.8901"))),
    Map("k" -> List(new java.math.BigDecimal("12345.6789"))),
    Map("k" -> List(org.apache.avro.util.TimePeriod.of(1L, 2L, 3L)))))

  private def edges: LogicalMatrix =
  LogicalMatrix(
    LogicalMatrixDirect(
    java.util.UUID.fromString("00000000-0000-0000-0000-000000000000"),
    java.time.LocalDate.ofEpochDay(-12345),
    java.time.LocalTime.ofNanoOfDay(0),
    java.time.LocalTime.ofNanoOfDay(0),
    java.time.Instant.ofEpochMilli(-1500L),
    java.time.Instant.ofEpochSecond(-2L, 500000000),
    java.time.Instant.ofEpochSecond(-1L, 500000000),
    java.time.LocalDateTime.ofEpochSecond(-2L, 500000000, java.time.ZoneOffset.UTC),
    java.time.LocalDateTime.ofEpochSecond(-2L, 500000000, java.time.ZoneOffset.UTC),
    java.time.LocalDateTime.ofEpochSecond(-1L, 500000000, java.time.ZoneOffset.UTC),
    scala.math.BigDecimal("-9999.99"),
    scala.math.BigDecimal("-0.0001"),
    new java.math.BigDecimal("-0.5"),
    org.apache.avro.util.TimePeriod.of(0L, 0L, 0L)),
    LogicalMatrixArrays(
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty),
    LogicalMatrixMaps(
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty),
    LogicalMatrixOptions(
    None,
    None,
    None,
    None,
    None,
    None,
    None,
    None,
    None,
    None,
    None,
    None,
    None,
    None),
    LogicalMatrixUnions(
    Some(7),
    Some("alt"),
    Some("alt"),
    Some("alt"),
    Some("alt"),
    Some("alt"),
    Some("alt"),
    Some("alt"),
    Some("alt"),
    Some("alt"),
    Some("alt"),
    Some("alt"),
    Some("alt"),
    Some("alt")),
    LogicalMatrixArraysOfMaps(
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty,
    List.empty),
    LogicalMatrixMapsOfArrays(
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty,
    Map.empty))


  // Edge values driven into every nested position. The `edges` fixture above deliberately uses
  // empty containers and absent options, which means an edge value never reaches an array, map,
  // option or union - and a nested logical type is converted against the model rather than
  // getConversion(pos), so that is exactly where conversions diverge. Pre-epoch nanos went
  // undetected for precisely this reason.
  private val edgeUuid: java.util.UUID = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")
  private val edgeDate: java.time.LocalDate = java.time.LocalDate.ofEpochDay(-12345)
  private val edgeTimeMillis: java.time.LocalTime = java.time.LocalTime.ofNanoOfDay(0)
  private val edgeTimeMicros: java.time.LocalTime = java.time.LocalTime.ofNanoOfDay(0)
  private val edgeTsMillis: java.time.Instant = java.time.Instant.ofEpochMilli(-1500L)
  private val edgeTsMicros: java.time.Instant = java.time.Instant.ofEpochSecond(-2L, 500000000)
  private val edgeTsNanos: java.time.Instant = java.time.Instant.ofEpochSecond(-1L, 500000000)
  private val edgeLtsMillis: java.time.LocalDateTime = java.time.LocalDateTime.ofEpochSecond(-2L, 500000000, java.time.ZoneOffset.UTC)
  private val edgeLtsMicros: java.time.LocalDateTime = java.time.LocalDateTime.ofEpochSecond(-2L, 500000000, java.time.ZoneOffset.UTC)
  private val edgeLtsNanos: java.time.LocalDateTime = java.time.LocalDateTime.ofEpochSecond(-1L, 500000000, java.time.ZoneOffset.UTC)
  private val edgeDecBytes: scala.math.BigDecimal = scala.math.BigDecimal("-9999.99")
  private val edgeDecFixed: scala.math.BigDecimal = scala.math.BigDecimal("-0.0001")
  private val edgeBigDec: java.math.BigDecimal = new java.math.BigDecimal("-0.5")
  private val edgeDuration: org.apache.avro.util.TimePeriod = org.apache.avro.util.TimePeriod.of(0L, 0L, 0L)

  private def nestedEdges: LogicalMatrix =
  LogicalMatrix(
    LogicalMatrixDirect(
      edgeUuid,
      edgeDate,
      edgeTimeMillis,
      edgeTimeMicros,
      edgeTsMillis,
      edgeTsMicros,
      edgeTsNanos,
      edgeLtsMillis,
      edgeLtsMicros,
      edgeLtsNanos,
      edgeDecBytes,
      edgeDecFixed,
      edgeBigDec,
      edgeDuration),
    LogicalMatrixArrays(
      List(edgeUuid),
      List(edgeDate),
      List(edgeTimeMillis),
      List(edgeTimeMicros),
      List(edgeTsMillis),
      List(edgeTsMicros),
      List(edgeTsNanos),
      List(edgeLtsMillis),
      List(edgeLtsMicros),
      List(edgeLtsNanos),
      List(edgeDecBytes),
      List(edgeDecFixed),
      List(edgeBigDec),
      List(edgeDuration)),
    LogicalMatrixMaps(
      Map("k" -> edgeUuid),
      Map("k" -> edgeDate),
      Map("k" -> edgeTimeMillis),
      Map("k" -> edgeTimeMicros),
      Map("k" -> edgeTsMillis),
      Map("k" -> edgeTsMicros),
      Map("k" -> edgeTsNanos),
      Map("k" -> edgeLtsMillis),
      Map("k" -> edgeLtsMicros),
      Map("k" -> edgeLtsNanos),
      Map("k" -> edgeDecBytes),
      Map("k" -> edgeDecFixed),
      Map("k" -> edgeBigDec),
      Map("k" -> edgeDuration)),
    LogicalMatrixOptions(
      Some(edgeUuid),
      Some(edgeDate),
      Some(edgeTimeMillis),
      Some(edgeTimeMicros),
      Some(edgeTsMillis),
      Some(edgeTsMicros),
      Some(edgeTsNanos),
      Some(edgeLtsMillis),
      Some(edgeLtsMicros),
      Some(edgeLtsNanos),
      Some(edgeDecBytes),
      Some(edgeDecFixed),
      Some(edgeBigDec),
      Some(edgeDuration)),
    LogicalMatrixUnions(
      Some(edgeUuid),
      Some(edgeDate),
      Some(edgeTimeMillis),
      Some(edgeTimeMicros),
      Some(edgeTsMillis),
      Some(edgeTsMicros),
      Some(edgeTsNanos),
      Some(edgeLtsMillis),
      Some(edgeLtsMicros),
      Some(edgeLtsNanos),
      Some(edgeDecBytes),
      Some(edgeDecFixed),
      Some(edgeBigDec),
      Some(edgeDuration)),
    LogicalMatrixArraysOfMaps(
      List(Map("k" -> edgeUuid)),
      List(Map("k" -> edgeDate)),
      List(Map("k" -> edgeTimeMillis)),
      List(Map("k" -> edgeTimeMicros)),
      List(Map("k" -> edgeTsMillis)),
      List(Map("k" -> edgeTsMicros)),
      List(Map("k" -> edgeTsNanos)),
      List(Map("k" -> edgeLtsMillis)),
      List(Map("k" -> edgeLtsMicros)),
      List(Map("k" -> edgeLtsNanos)),
      List(Map("k" -> edgeDecBytes)),
      List(Map("k" -> edgeDecFixed)),
      List(Map("k" -> edgeBigDec)),
      List(Map("k" -> edgeDuration))),
    LogicalMatrixMapsOfArrays(
      Map("k" -> List(edgeUuid)),
      Map("k" -> List(edgeDate)),
      Map("k" -> List(edgeTimeMillis)),
      Map("k" -> List(edgeTimeMicros)),
      Map("k" -> List(edgeTsMillis)),
      Map("k" -> List(edgeTsMicros)),
      Map("k" -> List(edgeTsNanos)),
      Map("k" -> List(edgeLtsMillis)),
      Map("k" -> List(edgeLtsMicros)),
      Map("k" -> List(edgeLtsNanos)),
      Map("k" -> List(edgeDecBytes)),
      Map("k" -> List(edgeDecFixed)),
      Map("k" -> List(edgeBigDec)),
      Map("k" -> List(edgeDuration))))

  test("every logical type round-trips at its edges in every nested position") {
    deserialize[LogicalMatrix](serialize(nestedEdges), LogicalMatrix.SCHEMA$) shouldBe nestedEdges
  }

  test("every logical type round-trips in every position") {
    deserialize[LogicalMatrix](serialize(populated), LogicalMatrix.SCHEMA$) shouldBe populated
  }

  test("every logical type round-trips at its edges, with empty containers and absent options") {
    deserialize[LogicalMatrix](serialize(edges), LogicalMatrix.SCHEMA$) shouldBe edges
  }

  test("a record read into a reused instance is not contaminated by the previous one") {
    // Avro fetches the old field value by calling get(pos) on the record being reused, and hands
    // that buffer back to the decoder. A shorter value narrows the limit but keeps the longer
    // backing array, so anything reading the whole array instead of remaining() decodes stale
    // trailing bytes - silently, and as a different number. DataFileReader reuses by default.
    val reader = new SpecificDatumReader[LogicalMatrix](LogicalMatrix.SCHEMA$)
    val first = reader.read(null.asInstanceOf[LogicalMatrix],
      DecoderFactory.get().binaryDecoder(serialize(populated), null))
    first shouldBe populated
    val second = reader.read(first, DecoderFactory.get().binaryDecoder(serialize(edges), null))
    second shouldBe edges
  }

  test("a shorter decimal read after a longer one keeps its own value") {
    // The narrow case the reuse bug actually turned on: the second value's unscaled form is far
    // shorter than the first's, so a stale read is numerically obvious rather than subtle.
    val reader = new SpecificDatumReader[LogicalMatrixDirect](LogicalMatrixDirect.SCHEMA$)
    def withDecimals(bytes: String, fixed: String): LogicalMatrixDirect = {
      val record = populated._direct
      record._decimal_bytes = scala.math.BigDecimal(bytes)
      record._decimal_fixed = scala.math.BigDecimal(fixed)
      record
    }
    val wide = serialize(withDecimals("99999999.99", "12345678.9012"))
    val narrow = serialize(withDecimals("0.01", "0.0001"))

    val first = reader.read(null.asInstanceOf[LogicalMatrixDirect], DecoderFactory.get().binaryDecoder(wide, null))
    first._decimal_bytes shouldBe scala.math.BigDecimal("99999999.99")
    val second = reader.read(first, DecoderFactory.get().binaryDecoder(narrow, null))
    second._decimal_bytes shouldBe scala.math.BigDecimal("0.01")
    second._decimal_fixed shouldBe scala.math.BigDecimal("0.0001")
  }

  test("the matrix covers every supported logical type in every position") {
    // Guards the matrix itself: adding a logical type without extending the schema fails here
    // rather than silently going untested.
    def logicalNames(schema: Schema): Set[String] = schema.getType match {
      case Schema.Type.RECORD => schema.getFields.asScala.flatMap(f => logicalNames(f.schema())).toSet
      case Schema.Type.ARRAY => logicalNames(schema.getElementType)
      case Schema.Type.MAP => logicalNames(schema.getValueType)
      case Schema.Type.UNION => schema.getTypes.asScala.flatMap(logicalNames).toSet
      case _ => Option(schema.getLogicalType).map(_.getName).toSet
    }

    val supported = LogicalTypes.logicalTypeMap.keySet.map(_.logicalTypeName)
    val contexts = LogicalMatrix.SCHEMA$.getFields.asScala.toList
    contexts.size shouldBe 7
    contexts.foreach { context =>
      withClue(s"context ${context.name}: ") {
        logicalNames(context.schema()) shouldBe supported
      }
    }
  }
}
