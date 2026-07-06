import example._
import org.apache.avro.io.{DecoderFactory, EncoderFactory}
import org.apache.avro.specific.{SpecificDatumReader, SpecificDatumWriter, SpecificRecord}

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
}
