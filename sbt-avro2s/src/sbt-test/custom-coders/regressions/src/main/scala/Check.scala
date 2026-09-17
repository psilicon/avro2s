import java.io.{ByteArrayInputStream, ByteArrayOutputStream}
import java.nio.ByteBuffer
import org.apache.avro.{AvroTypeException, Schema}
import org.apache.avro.file.{DataFileStream, DataFileWriter}
import org.apache.avro.generic.{GenericData, GenericDatumReader, GenericDatumWriter, GenericRecord}
import org.apache.avro.io.{DecoderFactory, Encoder, EncoderFactory}
import org.apache.avro.specific.{SpecificData, SpecificDatumReader, SpecificDatumWriter, SpecificRecordBase}
import scala.jdk.CollectionConverters._

object Check {
  def main(args: Array[String]): Unit = {
    val schema = example.All.SCHEMA$
    val generic = GenericData.get()

    def model(s: Schema, custom: Boolean): SpecificData = {
      val cls = Class.forName(s.getFullName)
      val record = cls.getConstructor().newInstance().asInstanceOf[SpecificRecordBase]
      val result = new SpecificData(cls.getClassLoader)
      // Copy only conversions actually requested by these generated fields. The global
      // SpecificData singleton also contains conversions when logical types are disabled.
      s.getFields.asScala.flatMap(f => Option(record.getConversion(f.pos()))).foreach(result.addLogicalTypeConversion)
      result.setCustomCoders(custom)
      result.setFastReaderEnabled(false)
      result
    }

    def sample(s: Schema, seed: Int, depth: Int = 0): AnyRef = {
      import Schema.Type._
      s.getType match {
        case NULL => null
        case BOOLEAN => Boolean.box(seed % 2 == 0)
        case INT => Int.box(if (Option(s.getLogicalType).exists(_.getName == "time-millis")) 12345 else -seed - 1)
        case LONG => Long.box(if (Option(s.getLogicalType).exists(_.getName == "time-micros")) 12345678L else -1000001L - seed)
        case FLOAT => Float.box(seed.toFloat + 0.5f)
        case DOUBLE => Double.box(-seed.toDouble - 0.25d)
        case STRING => if (Option(s.getLogicalType).exists(_.getName == "uuid")) "01234567-89ab-cdef-0123-456789abcdef" else "héllo-界-" + seed
        case BYTES => ByteBuffer.wrap(Array[Byte](seed.toByte, 0, -1))
        case FIXED => new GenericData.Fixed(s, Array.tabulate[Byte](s.getFixedSize)(i => (seed + i).toByte))
        case ENUM => new GenericData.EnumSymbol(s, s.getEnumSymbols.get(seed % s.getEnumSymbols.size()))
        case RECORD =>
          val result = new GenericData.Record(s)
          s.getFields.asScala.foreach(f => result.put(f.pos(), sample(f.schema(), seed + f.pos(), depth + 1)))
          result
        case ARRAY =>
          val result = new java.util.ArrayList[AnyRef]()
          if (depth < 6) (0 until seed % 4).foreach(i => result.add(sample(s.getElementType, seed + i, depth + 1)))
          result
        case MAP =>
          val result = new java.util.LinkedHashMap[String, AnyRef]()
          if (depth < 6) (0 until seed % 4).foreach(i => result.put("key-" + i, sample(s.getValueType, seed + i, depth + 1)))
          result
        case UNION =>
          val emptyEnum = s.getTypes.asScala.exists(t => t.getType == ENUM && t.getEnumSymbols.isEmpty)
          val index = if ((depth > 5 || emptyEnum) && s.getTypes.asScala.exists(_.getType == NULL)) s.getTypes.asScala.indexWhere(_.getType == NULL)
            else seed % s.getTypes.size()
          sample(s.getTypes.get(index), seed, depth + 1)
      }
    }

    def genericBytes(s: Schema, value: AnyRef, chunks: Boolean = false, blocking: Boolean = false): Array[Byte] = {
      val output = new ByteArrayOutputStream()
      val out = if (blocking) new EncoderFactory().configureBlockSize(64).blockingBinaryEncoder(output, null)
        else EncoderFactory.get().binaryEncoder(output, null)
      if (chunks) writeChunks(s, value, out) else new GenericDatumWriter[AnyRef](s).write(value, out)
      out.flush()
      output.toByteArray
    }

    // Multiple blocks at every collection level, including collections inside unions.
    def writeChunks(s: Schema, value: AnyRef, out: Encoder): Unit = {
      import Schema.Type._
      s.getType match {
        case RECORD => s.getFields.asScala.foreach(f => writeChunks(f.schema(), value.asInstanceOf[GenericRecord].get(f.pos()), out))
        case ARRAY =>
          out.writeArrayStart()
          value.asInstanceOf[java.util.List[AnyRef]].asScala.foreach { v =>
            out.setItemCount(1L); out.startItem(); writeChunks(s.getElementType, v, out)
          }
          out.writeArrayEnd()
        case MAP =>
          out.writeMapStart()
          value.asInstanceOf[java.util.Map[String, AnyRef]].asScala.foreach { case (key, v) =>
            // Duplicate map keys are legal on the wire; both readers must retain the last value.
            out.setItemCount(2L)
            out.startItem(); out.writeString(key); writeChunks(s.getValueType, v, out)
            out.startItem(); out.writeString(key); writeChunks(s.getValueType, v, out)
          }
          out.writeMapEnd()
        case UNION =>
          val index = generic.resolveUnion(s, value)
          out.writeIndex(index)
          writeChunks(s.getTypes.get(index), value, out)
        case _ => new GenericDatumWriter[AnyRef](s).write(value, out)
      }
    }

    def read(s: Schema, bytes: Array[Byte], custom: Boolean, reuse: SpecificRecordBase = null, writer: Schema = null): SpecificRecordBase = {
      val reader = new SpecificDatumReader[SpecificRecordBase](if (writer == null) s else writer, s, model(s, custom))
      reader.read(reuse, DecoderFactory.get().binaryDecoder(bytes, null))
    }

    def write(value: SpecificRecordBase, custom: Boolean): Array[Byte] = {
      val output = new ByteArrayOutputStream()
      val out = EncoderFactory.get().binaryEncoder(output, null)
      new SpecificDatumWriter[SpecificRecordBase](value.getSchema, model(value.getSchema, custom)).write(value, out)
      out.flush()
      output.toByteArray
    }

    def asGeneric(s: Schema, bytes: Array[Byte], writer: Schema = null): AnyRef =
      new GenericDatumReader[AnyRef](if (writer == null) s else writer, s).read(null, DecoderFactory.get().binaryDecoder(bytes, null))

    // Fail immediately if a supposedly custom path accidentally falls back to get/put.
    val guarded = new example.All() {
      override def get(index: Int): AnyRef = throw new AssertionError("custom write called get")
      override def put(index: Int, value: Any): Unit = throw new AssertionError("custom read called put")
    }
    for (seed <- 0 until 24; chunks <- List(false, true); blocking <- List(false, true)) {
      val input = sample(schema, seed)
      val bytes = genericBytes(schema, input, chunks, blocking)
      val expected = asGeneric(schema, bytes)
      val baseline = read(schema, bytes, custom = false)
      assert(asGeneric(schema, write(baseline, custom = true)) == expected, s"custom write seed=$seed")
      val decoded = read(schema, bytes, custom = true)
      assert(asGeneric(schema, write(decoded, custom = false)) == expected, s"custom read seed=$seed")
      val previousNode = guarded.node
      assert(read(schema, bytes, custom = true, reuse = guarded) eq guarded)
      assert(guarded.node eq previousNode, "direct nested record was not reused")
      assert(asGeneric(schema, write(guarded, custom = true)) == expected, s"custom reuse seed=$seed")
    }

    // Avro's independent fast reader bypasses customDecode; it must remain compatible.
    val fastModel = model(schema, true)
    fastModel.setFastReaderEnabled(true)
    val fastInput = genericBytes(schema, sample(schema, 5))
    val fastRead = new SpecificDatumReader[SpecificRecordBase](schema, schema, fastModel)
      .read(null, DecoderFactory.get().binaryDecoder(fastInput, null))
    assert(asGeneric(schema, write(fastRead, true)) == asGeneric(schema, fastInput))

    // JSON and object container files still use stock Apache Avro readers and writers.
    val value = read(schema, genericBytes(schema, sample(schema, 5)), custom = true)
    val jsonOutput = new ByteArrayOutputStream()
    val jsonEncoder = EncoderFactory.get().jsonEncoder(schema, jsonOutput)
    new SpecificDatumWriter[SpecificRecordBase](schema, model(schema, true)).write(value, jsonEncoder)
    jsonEncoder.flush()
    val jsonBytes = jsonOutput.toByteArray
    val jsonGeneric = new GenericDatumReader[AnyRef](schema).read(null, DecoderFactory.get().jsonDecoder(schema, new ByteArrayInputStream(jsonBytes)))
    assert(jsonGeneric == asGeneric(schema, write(value, false)))
    val jsonSpecific = new SpecificDatumReader[SpecificRecordBase](schema, schema, model(schema, true))
      .read(null, DecoderFactory.get().jsonDecoder(schema, new ByteArrayInputStream(jsonBytes)))
    assert(asGeneric(schema, write(jsonSpecific, false)) == jsonGeneric)
    val container = new ByteArrayOutputStream()
    val fileWriter = new DataFileWriter[SpecificRecordBase](new SpecificDatumWriter[SpecificRecordBase](schema, model(schema, true)))
    fileWriter.create(schema, container)
    fileWriter.append(value)
    fileWriter.close()
    val fileReader = new DataFileStream[AnyRef](new ByteArrayInputStream(container.toByteArray), new GenericDatumReader[AnyRef]())
    assert(fileReader.next() == asGeneric(schema, write(value, false)))
    assert(!fileReader.hasNext)
    fileReader.close()

    // ResolvingDecoder must handle aliases, reordering, removed fields, defaults, promotions,
    // union index remapping, nested resolution and enum symbol/default remapping.
    val evolved = example.Evolved.SCHEMA$
    val old = new Schema.Parser().parse("""{"type":"record","name":"Old","namespace":"example","fields":[
      {"name":"removed","type":{"type":"array","items":"string"}},
      {"name":"child","type":{"type":"record","name":"Child","fields":[{"name":"n","type":"int"}]}},
      {"name":"choice","type":["null","int","string"]},
      {"name":"number","type":"float"},
      {"name":"status","type":{"type":"enum","name":"Status","symbols":["A","B","OTHER"]}},
      {"name":"oldName","type":"int"},
      {"name":"trailing","type":"bytes"},
      {"name":"text","type":"bytes"},
      {"name":"payload","type":"string"}
    ]}""")
    for (seed <- 0 until 6) {
      val input = sample(old, seed).asInstanceOf[GenericRecord]
      // Bytes promoted to string must contain valid UTF-8.
      input.put("text", ByteBuffer.wrap("héllo-界".getBytes(java.nio.charset.StandardCharsets.UTF_8)))
      val bytes = genericBytes(old, input, chunks = true)
      val expected = asGeneric(evolved, bytes, old)
      for (custom <- List(false, true)) {
        val decoded = read(evolved, bytes, custom, writer = old)
        val actual = asGeneric(evolved, write(decoded, custom))
        assert(actual == expected, s"schema resolution seed=$seed custom=$custom: $actual != $expected")
      }
      // Several records in one stream catch incorrect draining/record boundaries.
      val stream = DecoderFactory.get().binaryDecoder(bytes ++ bytes, null)
      val reader = new SpecificDatumReader[SpecificRecordBase](old, evolved, model(evolved, true))
      (0 until 2).foreach(_ => assert(asGeneric(evolved, write(reader.read(null, stream), true)) == expected))
      assert(stream.isEnd)
    }
    val incompatible = new Schema.Parser().parse("""{"type":"record","name":"Old","namespace":"example","fields":[{"name":"oldName","type":"string"}]}""")
    try {
      read(evolved, genericBytes(incompatible, sample(incompatible, 1)), custom = true, writer = incompatible)
      sys.error("incompatible schema unexpectedly accepted")
    } catch { case _: AvroTypeException => () }
    val complete = genericBytes(schema, sample(schema, 1))
    try {
      read(schema, complete.take(complete.length / 2), custom = true)
      sys.error("truncated data unexpectedly accepted")
    } catch { case _: java.io.IOException => () }
    println("Custom coders: runtime independence, fallback, both wire directions, reuse, blocks, JSON, containers and schema evolution passed")
  }
}
