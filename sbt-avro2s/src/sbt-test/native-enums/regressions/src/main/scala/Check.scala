import example._
import org.apache.avro.io.{DecoderFactory, EncoderFactory}
import org.apache.avro.generic.{GenericData, GenericDatumReader, GenericDatumWriter, GenericRecord}
import org.apache.avro.specific.{SpecificData, SpecificDatumReader, SpecificDatumWriter, SpecificRecord}

import java.io.ByteArrayOutputStream

object Check extends App {
  def roundTrip[A <: SpecificRecord](record: A): A = {
    val output = new ByteArrayOutputStream()
    val encoder = EncoderFactory.get().binaryEncoder(output, null)
    new SpecificDatumWriter[A](record.getSchema).write(record, encoder)
    encoder.flush()
    val decoder = DecoderFactory.get().binaryDecoder(output.toByteArray, null)
    new SpecificDatumReader[A](record.getSchema).read(null.asInstanceOf[A], decoder)
  }

  assert(roundTrip(Card(Suit.HEARTS)).suit eq Suit.HEARTS)
  assert(roundTrip(Paint(Color.RED)).color eq Color.RED)
  assert(Collision.valueOf("value") eq Collision.value)
  assert(Collision.valueOf("List") eq Collision.List)
  assert(Collision.values.toList == List(Collision.value, Collision.List))
  assert(LargeAscii.SCHEMA$.getDoc == "x" * 70000)
  assert(LargeUnicode.SCHEMA$.getDoc == "界" * 22000)
  assert(LargeSupplementary.SCHEMA$.getDoc == "😀" * 11000)
  assert(LargeAscii.fromAvroSymbol("Array") eq LargeAscii.Array)
  assert(LargeAscii.fromAvroSymbol("org") eq LargeAscii.org)
  assert(cards.cards.Repeated.fromAvroSymbol("A") eq cards.cards.Repeated.A)

  assert(Empty.values.isEmpty)
  assert(roundTrip(EmptyRecord(None)).empty.isEmpty)
  try {
    Empty.fromAvroSymbol("anything")
    sys.error("An empty enum must reject every symbol")
  } catch { case _: org.apache.avro.AvroRuntimeException => () }

  EnumWireChecks.check(new SpecificDatumReader[SymbolsRecord](SymbolsRecord.SCHEMA$))
  EnumWireChecks.check(new SpecificDatumReader[SymbolsRecord](SymbolsRecord.SCHEMA$, SymbolsRecord.SCHEMA$, new SpecificData()))
  assert(Symbols.fromAvroSymbol("values") eq Symbols.values$avro)
  assert(Symbols.fromAvroSymbol("toString") eq Symbols.toString$avro)
  assert(Symbols.fromAvroSymbol("_") eq Symbols._$avro)
  try {
    Symbols.fromAvroSymbol("values$avro")
    sys.error("A Scala case name must not be accepted as an Avro symbol")
  } catch { case _: org.apache.avro.AvroRuntimeException => () }
}

object EnumWireChecks {
  // Decode a generic writer's original Avro symbols, then read generated output
  // with a generic reader. This detects matching bugs hidden by a self-round-trip.
  def check(reader: SpecificDatumReader[SymbolsRecord]): Unit = {
    val schema = SymbolsRecord.SCHEMA$
    val symbols = Symbols.SCHEMA$.getEnumSymbols
    val iterator = symbols.iterator()
    while (iterator.hasNext) {
      val symbol = iterator.next()
      val enumValue = new GenericData.EnumSymbol(Symbols.SCHEMA$, symbol)
      val record = new GenericData.Record(schema)
      record.put("symbol", enumValue)
      record.put("optional", enumValue)
      record.put("array", java.util.Arrays.asList(enumValue))
      record.put("mapping", java.util.Collections.singletonMap("key", enumValue))
      record.put("optionalArray", java.util.Arrays.asList(enumValue, null))
      record.put("union", enumValue)
      val output = new ByteArrayOutputStream()
      val encoder = EncoderFactory.get().binaryEncoder(output, null)
      new GenericDatumWriter[GenericRecord](schema).write(record, encoder)
      encoder.flush()

      val decoded = reader.read(null, DecoderFactory.get().binaryDecoder(output.toByteArray, null))
      val expected = Symbols.fromAvroSymbol(symbol)
      assert(decoded.symbol eq expected, symbol)
      assert(decoded.optional.contains(expected), symbol)
      assert(decoded.array == List(expected), symbol)
      assert(decoded.mapping == Map("key" -> expected), symbol)
      assert(decoded.optionalArray == List(Some(expected), None), symbol)
      assert(expected.toString == symbol, symbol)

      val encodedOutput = new ByteArrayOutputStream()
      val encodedEncoder = EncoderFactory.get().binaryEncoder(encodedOutput, null)
      new SpecificDatumWriter[SymbolsRecord](schema).write(decoded, encodedEncoder)
      encodedEncoder.flush()
      val generic = new GenericDatumReader[GenericRecord](schema).read(null,
        DecoderFactory.get().binaryDecoder(encodedOutput.toByteArray, null))
      assert(generic == record, symbol)
    }
  }
}
