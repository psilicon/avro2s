import java.io.{ByteArrayInputStream, ByteArrayOutputStream, File}
import java.net.URLClassLoader
import org.apache.avro.Schema
import org.apache.avro.file.{DataFileStream, DataFileWriter}
import org.apache.avro.io.{DecoderFactory, EncoderFactory}
import org.apache.avro.specific.{SpecificData, SpecificDatumReader, SpecificDatumWriter, SpecificRecordBase}
import scala.jdk.CollectionConverters._

/** Uses the official Java compiler's records without renaming their Avro schemas. */
final class OfficialAvro(property: String = "avro2s.test.officialClasses") extends AutoCloseable {
  private val directory = new File(sys.props(property))
  private val loader = new URLClassLoader(Array(directory.toURI.toURL), getClass.getClassLoader) {
    override def loadClass(name: String, resolve: Boolean): Class[?] = synchronized {
      if (!name.startsWith("example.")) super.loadClass(name, resolve)
      else {
        val existing = findLoadedClass(name)
        val cls = if (existing == null) findClass(name) else existing
        if (resolve) resolveClass(cls)
        cls
      }
    }
  }

  private def emptyRecord(fullName: String): SpecificRecordBase = {
    val cls = loader.loadClass(fullName)
    assert(cls.getClassLoader eq loader, "official record resolved to the Scala implementation")
    cls.getConstructor().newInstance().asInstanceOf[SpecificRecordBase]
  }

  def schema(fullName: String): Schema = emptyRecord(fullName).getSchema

  private def model(schema: Schema): SpecificData = {
    val record = emptyRecord(schema.getFullName)
    assert(record.getSchema == schema, "Java and Scala schemas differ")
    val data = new SpecificData(loader)
    record.getSpecificData.getConversions.asScala.foreach(data.addLogicalTypeConversion)
    data.setCustomCoders(false)
    data.setFastReaderEnabled(false)
    data
  }

  def read(schema: Schema, bytes: Array[Byte], format: String = "binary",
           writer: Schema = null, reuse: SpecificRecordBase = null): SpecificRecordBase = {
    val writerSchema = if (writer == null) schema else writer
    val reader = new SpecificDatumReader[SpecificRecordBase](writerSchema, schema, model(schema))
    val result = format match {
      case "container" =>
        val stream = new DataFileStream[SpecificRecordBase](new ByteArrayInputStream(bytes), reader)
        try {
          val value = stream.next(reuse)
          assert(!stream.hasNext)
          value
        } finally stream.close()
      case "json" => reader.read(reuse, DecoderFactory.get().jsonDecoder(writerSchema, new ByteArrayInputStream(bytes)))
      case _ => reader.read(reuse, DecoderFactory.get().binaryDecoder(bytes, null))
    }
    assert(result.getClass.getClassLoader eq loader, "Java read returned an avro2s record")
    result
  }

  def write(value: SpecificRecordBase, format: String = "binary"): Array[Byte] = {
    assert(value.getClass.getClassLoader eq loader, "Java writer received an avro2s record")
    val writer = new SpecificDatumWriter[SpecificRecordBase](value.getSchema, model(value.getSchema))
    val output = new ByteArrayOutputStream()
    if (format == "container") {
      val stream = new DataFileWriter[SpecificRecordBase](writer)
      try { stream.create(value.getSchema, output); stream.append(value) } finally stream.close()
    } else {
      val encoder = format match {
        case "json" => EncoderFactory.get().jsonEncoder(value.getSchema, output)
        case "blocking" => new EncoderFactory().configureBlockSize(64).blockingBinaryEncoder(output, null)
        case _ => EncoderFactory.get().binaryEncoder(output, null)
      }
      writer.write(value, encoder)
      encoder.flush()
    }
    output.toByteArray
  }

  override def close(): Unit = loader.close()
}
