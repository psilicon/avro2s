package avro2s.benchmarks

import org.apache.avro.Schema
import org.apache.avro.generic.{GenericDatumReader, GenericDatumWriter, GenericRecord}
import org.apache.avro.io.{BinaryDecoder, BinaryEncoder, DecoderFactory, EncoderFactory}
import org.apache.avro.specific.{SpecificData, SpecificDatumReader, SpecificDatumWriter, SpecificRecord, SpecificRecordBase}

import java.io.ByteArrayOutputStream

/**
 * One generated record under measurement.
 *
 * Everything here is expressed against SpecificRecord, never a generated class by name. That is
 * what lets a single benchmark run measure the working tree's models and another revision's
 * models side by side: the two arms differ only in which class is loaded.
 *
 * The record instance is produced by decoding bytes written from an independent GenericRecord,
 * so no generated code participates in building the value being measured.
 */
final class Workload(val name: String, val recordClass: Class[_ <: SpecificRecord], val schema: Schema, val size: Int) {
  private val genericValue: GenericRecord = GenericValues.record(schema, size)

  val record: SpecificRecord = Workload.decodeInto(recordClass, schema, Workload.encodeGeneric(schema, genericValue))
  private val model: SpecificData = record.asInstanceOf[SpecificRecordBase].getSpecificData

  val fieldCount: Int = schema.getFields.size()

  /** Exactly what get returns, so put is measured on the values it is really handed. */
  private val fieldValues: Array[AnyRef] = Array.tabulate(fieldCount)(record.get)
  private val scratch: SpecificRecord = recordClass.getDeclaredConstructor().newInstance()

  private val writer = new SpecificDatumWriter[SpecificRecord](schema, model)
  private val reader = new SpecificDatumReader[SpecificRecord](schema, schema, model)
  private val buffer = new ByteArrayOutputStream(1024)
  private var encoder: BinaryEncoder = null
  private var decoder: BinaryDecoder = null

  val payload: Array[Byte] = {
    buffer.reset()
    val target = EncoderFactory.get().binaryEncoder(buffer, null)
    writer.write(record, target)
    target.flush()
    buffer.toByteArray
  }

  /** The conversion work in the generated get, with no encoder involved. */
  def get(): AnyRef = {
    var result: AnyRef = null
    var index = 0
    while (index < fieldCount) {
      result = record.get(index)
      index += 1
    }
    result
  }

  /** The reverse conversion in the generated put, fed the values get produces. */
  def put(): SpecificRecord = {
    var index = 0
    while (index < fieldCount) {
      scratch.put(index, fieldValues(index))
      index += 1
    }
    scratch
  }

  /** Full encode through Avro's specific writer, which drives get for every field. */
  def encode(): Int = {
    buffer.reset()
    encoder = EncoderFactory.get().binaryEncoder(buffer, encoder)
    writer.write(record, encoder)
    encoder.flush()
    buffer.size()
  }

  /** Full decode through Avro's specific reader, which drives put for every field. */
  def decode(): SpecificRecord = {
    decoder = DecoderFactory.get().binaryDecoder(payload, decoder)
    reader.read(null, decoder)
  }

  /**
   * Re-encodes the decoded model and checks it against the independent generic datum it came
   * from. A benchmark whose workload fails this is measuring broken generated code.
   */
  def verify(): Unit = {
    val reencoded = {
      val output = new ByteArrayOutputStream(1024)
      val target = EncoderFactory.get().binaryEncoder(output, null)
      writer.write(decode(), target)
      target.flush()
      output.toByteArray
    }
    val actual = Workload.normalise(Workload.decodeGeneric(schema, reencoded))
    val expected = Workload.normalise(genericValue)
    if (actual != expected) {
      sys.error(s"Workload $name did not round-trip through the generated model:\n  expected $expected\n  actual   $actual")
    }
  }
}

object Workload {
  /** Collection and string size for benchmarks that do not vary size themselves. */
  val defaultSize = 16

  private def encodeGeneric(schema: Schema, value: GenericRecord): Array[Byte] = {
    val output = new ByteArrayOutputStream(1024)
    val encoder = EncoderFactory.get().binaryEncoder(output, null)
    new GenericDatumWriter[GenericRecord](schema).write(value, encoder)
    encoder.flush()
    output.toByteArray
  }

  /**
   * Reduces Avro's in-memory values to plain Scala structures for comparison.
   *
   * GenericData.Record equality cannot be used here: Avro compares records field by field with
   * GenericData.compare, which refuses to order maps. Normalising also settles the CharSequence
   * question, since a decoded string arrives as Utf8 on one side and String on the other, and
   * makes the comparison insensitive to map iteration order, which Avro does not preserve.
   */
  private[benchmarks] def normalise(value: Any): Any = value match {
    case null => null
    case record: GenericRecord =>
      val fields = record.getSchema.getFields
      (0 until fields.size()).map(index => fields.get(index).name() -> normalise(record.get(index))).toMap
    case symbol: org.apache.avro.generic.GenericEnumSymbol[_] => symbol.toString
    case fixed: org.apache.avro.generic.GenericFixed => fixed.bytes().toVector
    case buffer: java.nio.ByteBuffer =>
      val duplicate = buffer.duplicate()
      val bytes = new Array[Byte](duplicate.remaining())
      duplicate.get(bytes)
      bytes.toVector
    case bytes: Array[Byte] => bytes.toVector
    case map: java.util.Map[_, _] =>
      var result = Map.empty[String, Any]
      val entries = map.entrySet().iterator()
      while (entries.hasNext) {
        val entry = entries.next()
        result += (entry.getKey.toString -> normalise(entry.getValue))
      }
      result
    case collection: java.util.Collection[_] =>
      var result = Vector.empty[Any]
      val elements = collection.iterator()
      while (elements.hasNext) result = result :+ normalise(elements.next())
      result
    case text: CharSequence => text.toString
    case other => other
  }

  private def decodeGeneric(schema: Schema, payload: Array[Byte]): GenericRecord =
    new GenericDatumReader[GenericRecord](schema).read(null, DecoderFactory.get().binaryDecoder(payload, null))

  private def decodeInto(recordClass: Class[_ <: SpecificRecord], schema: Schema, payload: Array[Byte]): SpecificRecord = {
    val instance = recordClass.getDeclaredConstructor().newInstance()
    val model = instance.asInstanceOf[SpecificRecordBase].getSpecificData
    new SpecificDatumReader[SpecificRecord](schema, schema, model)
      .read(null, DecoderFactory.get().binaryDecoder(payload, null))
  }
}
