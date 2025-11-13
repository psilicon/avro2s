package avro2s.serialization

import avro2s.specific.ScalaSpecificData
import org.apache.avro.Schema
import org.apache.avro.io.{BinaryDecoder, BinaryEncoder, DecoderFactory, EncoderFactory}
import org.apache.avro.specific.{SpecificDatumReader, SpecificDatumWriter, SpecificRecordBase}

import java.io.ByteArrayOutputStream

object SerializationHelpers {
  private val scalaSpecificData = ScalaSpecificData.get()
  
  def serialize[T <: SpecificRecordBase](data: T): Array[Byte] = {
    val writer = new SpecificDatumWriter[T](data.getSchema, scalaSpecificData)
    val out = new ByteArrayOutputStream()
    val encoder: BinaryEncoder = EncoderFactory.get().binaryEncoder(out, null)

    writer.write(data, encoder)
    encoder.flush()
    out.close()
    out.toByteArray
  }

  def deserialize[T <: SpecificRecordBase](bytes: Array[Byte], schema: Schema): T = {
    val reader = new SpecificDatumReader[T](schema, schema, scalaSpecificData)
    val decoder: BinaryDecoder = DecoderFactory.get().binaryDecoder(bytes, null)
    reader.read(null.asInstanceOf[T], decoder)
  }
}
