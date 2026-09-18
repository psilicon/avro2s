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
    val official = new OfficialAvro
    val legacy = new OfficialAvro("avro2s.test.legacyClasses")
    try check(official, legacy)
    finally { legacy.close(); official.close() }
  }

  private def check(official: OfficialAvro, legacy: OfficialAvro): Unit = {
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
          if (depth < 6) (0 until seed % 4).foreach(i => result.put(List("", "clé-界", "🚀")(i), sample(s.getValueType, seed + i, depth + 1)))
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
            val first = if (s.getValueType.getType == LONG) Long.box(v.asInstanceOf[java.lang.Long].longValue() + 1) else v
            out.startItem(); out.writeString(key); writeChunks(s.getValueType, first, out)
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

    def read(s: Schema, bytes: Array[Byte], custom: Boolean, reuse: SpecificRecordBase = null,
             writer: Schema = null, format: String = "binary"): SpecificRecordBase = {
      val writerSchema = if (writer == null) s else writer
      val reader = new SpecificDatumReader[SpecificRecordBase](writerSchema, s, model(s, custom))
      format match {
        case "container" =>
          val stream = new DataFileStream[SpecificRecordBase](new ByteArrayInputStream(bytes), reader)
          try { val value = stream.next(reuse); assert(!stream.hasNext); value } finally stream.close()
        case "json" => reader.read(reuse, DecoderFactory.get().jsonDecoder(writerSchema, new ByteArrayInputStream(bytes)))
        case _ => reader.read(reuse, DecoderFactory.get().binaryDecoder(bytes, null))
      }
    }

    def write(value: SpecificRecordBase, custom: Boolean, format: String = "binary"): Array[Byte] = {
      val output = new ByteArrayOutputStream()
      val writer = new SpecificDatumWriter[SpecificRecordBase](value.getSchema, model(value.getSchema, custom))
      if (format == "container") {
        val stream = new DataFileWriter[SpecificRecordBase](writer)
        try { stream.create(value.getSchema, output); stream.append(value) } finally stream.close()
      } else {
        val out = format match {
          case "json" => EncoderFactory.get().jsonEncoder(value.getSchema, output)
          case "blocking" => new EncoderFactory().configureBlockSize(64).blockingBinaryEncoder(output, null)
          case _ => EncoderFactory.get().binaryEncoder(output, null)
        }
        writer.write(value, out)
        out.flush()
      }
      output.toByteArray
    }

    def asGeneric(s: Schema, bytes: Array[Byte], writer: Schema = null): AnyRef =
      new GenericDatumReader[AnyRef](if (writer == null) s else writer, s).read(null, DecoderFactory.get().binaryDecoder(bytes, null))

    def javaRoundTrips(s: Schema, seedBytes: Array[Byte], format: String,
                       reuse: SpecificRecordBase = null): Unit = {
      val expected = asGeneric(s, seedBytes)
      val javaInput = official.read(s, seedBytes)
      // Populate each implementation independently of the other's custom decoder.
      val scalaInput = read(s, seedBytes, custom = false)

      // avro2s custom encoder -> official generated Java record -> avro2s custom decoder.
      val javaResult = official.read(s, write(scalaInput, custom = true, format = format), format)
      // Java GenericData.Array.equals cannot resolve nested UUID values. Compare
      // independent raw Avro values instead, also ignoring JVM representation differences.
      val javaActual = asGeneric(s, official.write(javaResult))
      assert(javaActual == expected, s"Scala -> Java ${s.getName}/$format: $javaActual != $expected")
      val scalaBack = read(s, official.write(javaResult, format), custom = true, format = format)
      assert(asGeneric(s, write(scalaBack, custom = false)) == expected, s"Scala -> Java -> Scala ${s.getName}/$format")

      // Official Java encoder -> avro2s custom decoder -> official generated Java record.
      val scalaResult = read(s, official.write(javaInput, format), custom = true, reuse = reuse, format = format)
      if (reuse != null) assert(scalaResult eq reuse)
      val javaBack = official.read(s, write(scalaResult, custom = true, format = format), format, reuse = javaInput)
      assert(asGeneric(s, official.write(javaBack)) == expected, s"Java round trip oracle ${s.getName}/$format")
    }

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

    for (seed <- 0 until 24; format <- List("binary", "blocking", "json", "container")) {
      val input = sample(schema, seed).asInstanceOf[GenericRecord]
      input.put("count", Int.box(if (seed % 2 == 0) Int.MinValue else Int.MaxValue))
      input.put("longValue", Long.box(if (seed % 2 == 0) Long.MinValue else Long.MaxValue))
      // Avro's JsonEncoder.writeFloat adds 0d (losing negative zero), and its JSON
      // decoder cannot read nonfinite numbers. Test those values in binary formats.
      if (format != "json") {
        input.put("floatValue", Float.box(List(0.0f, -0.0f, Float.MinPositiveValue, Float.MaxValue,
          Float.PositiveInfinity, Float.NegativeInfinity, Float.NaN)(seed % 7)))
        input.put("doubleValue", Double.box(List(0.0d, -0.0d, Double.MinPositiveValue, Double.MaxValue,
          Double.PositiveInfinity, Double.NegativeInfinity, Double.NaN)(seed % 7)))
      }
      javaRoundTrips(schema, genericBytes(schema, input), format, guarded)
    }
    val choices = example.Choices.SCHEMA$
    val choiceGuard = new example.Choices() {
      override def get(index: Int): AnyRef = throw new AssertionError("custom union write called get")
      override def put(index: Int, value: Any): Unit = throw new AssertionError("custom union read called put")
    }
    for (seed <- 0 until 20; format <- List("binary", "blocking", "json", "container")) {
      javaRoundTrips(choices, genericBytes(choices, sample(choices, seed)), format, choiceGuard)
    }

    // The Decoder contract permits ByteBuffers with offsets, spare capacity or no
    // accessible backing array. BinaryDecoder normally returns only the exact shape.
    val buffers = example.Buffers.SCHEMA$
    for (size <- List(0, 1, 257); shape <- List("exact", "offset", "position", "capacity", "readonly", "direct")) {
      val input = sample(buffers, size).asInstanceOf[GenericRecord]
      input.put("data", ByteBuffer.wrap(Array.tabulate[Byte](size)(_.toByte)))
      val bytes = genericBytes(buffers, input)
      val decoder = new org.apache.avro.io.EdgeCaseResolvingDecoder(buffers, bytes, shape, false)
      val decoded = new example.Buffers()
      decoded.customDecode(decoder)
      decoder.drain()
      assert(asGeneric(buffers, write(decoded, false)) == asGeneric(buffers, bytes), s"bytes size=$size shape=$shape")
      javaRoundTrips(buffers, bytes, "binary")
    }
    def rejectsUnion(body: => Unit): Unit = {
      try { body; sys.error("invalid union unexpectedly accepted") }
      catch { case _: AvroTypeException => () }
    }
    rejectsUnion {
      val bytes = genericBytes(buffers, sample(buffers, 1))
      new example.Buffers().customDecode(new org.apache.avro.io.EdgeCaseResolvingDecoder(buffers, bytes, "exact", true))
    }
    for (invalid <- List(null, Some(null))) {
      val value = new example.Buffers()
      value.data = Array.emptyByteArray
      value.choice = invalid
      rejectsUnion { write(value, custom = true); () }
    }
    val invalidChoice = read(choices, genericBytes(choices, sample(choices, 1)), false).asInstanceOf[example.Choices]
    invalidChoice.record = null
    rejectsUnion { write(invalidChoice, custom = true); () }

    // Exercise primitive arrays across small and large blocks, including boundary-sized arrays.
    // Keep this schema separate so existing fixture fields and public types stay unchanged.
    val arrays = example.ArrayValues.SCHEMA$
    def arraySample(s: Schema, size: Int): GenericRecord = {
      def values(element: Schema, n: Int): java.util.List[AnyRef] =
        (0 until n).map { i =>
          val number = if (i % 2 == 0) 1000 + i else -1000 - i
          element.getType match {
            case Schema.Type.ARRAY => values(element.getElementType, size)
            case Schema.Type.LONG => Long.box(number.toLong)
            case Schema.Type.INT => Int.box(number)
            case Schema.Type.FLOAT => Float.box(number.toFloat + 0.5f)
            case Schema.Type.DOUBLE => Double.box(number.toDouble + 0.5d)
            case Schema.Type.BOOLEAN => Boolean.box(i % 2 == 0)
            case Schema.Type.STRING => s"héllo-界-$i"
            case other => throw new AssertionError(s"Unexpected array element: $other")
          }
        }.toList.asJava
      val record = new GenericData.Record(s)
      s.getFields.asScala.foreach { f =>
        val element = f.schema().getElementType
        record.put(f.pos(), values(element, if (element.getType == Schema.Type.ARRAY) 2 else size))
      }
      record
    }

    def arrayBlocks(s: Schema, input: AnyRef, sizes: List[Int]): Array[Byte] = {
      val output = new ByteArrayOutputStream()
      val out = EncoderFactory.get().binaryEncoder(output, null)
      def emit(s: Schema, value: AnyRef): Unit = s.getType match {
        case Schema.Type.RECORD =>
          s.getFields.asScala.foreach(f => emit(f.schema(), value.asInstanceOf[GenericRecord].get(f.pos())))
        case Schema.Type.ARRAY =>
          val values = value.asInstanceOf[java.util.List[AnyRef]]
          out.writeArrayStart()
          var index = 0
          var block = 0
          while (index < values.size()) {
            val end = math.min(index + sizes(block % sizes.size), values.size())
            out.setItemCount((end - index).toLong)
            while (index < end) {
              out.startItem()
              emit(s.getElementType, values.get(index))
              index += 1
            }
            block += 1
          }
          out.writeArrayEnd()
        case _ => new GenericDatumWriter[AnyRef](s).write(value, out)
      }
      emit(s, input)
      out.flush()
      output.toByteArray
    }

    // Promote array items through the official resolving decoder, including nested arrays.
    val oldArrays = legacy.schema("example.ArrayValues")
    val arrayGuard = new example.ArrayValues() {
      override def get(index: Int): AnyRef = throw new AssertionError("custom array write called get")
      override def put(index: Int, value: Any): Unit = throw new AssertionError("custom array read called put")
    }
    for (size <- List(0, 1, 16, 31, 32, 33, 63, 64, 65, 1024, 2049); writer <- List(arrays, oldArrays)) {
      val input = arraySample(writer, size)
      val encodings = List(
        genericBytes(writer, input),
        genericBytes(writer, input, blocking = true),
        arrayBlocks(writer, input, List(1, 33, 65)),
        arrayBlocks(writer, input, List(33, 1, 64))
      )
      if (writer == arrays) {
        for (format <- List("binary", "blocking"))
          javaRoundTrips(arrays, genericBytes(arrays, input), format, arrayGuard)
      } else {
        val javaInput = legacy.read(writer, genericBytes(writer, input))
        for (format <- List("binary", "blocking", "json", "container")) {
          val bytes = legacy.write(javaInput, format)
          val decoded = read(arrays, bytes, true, reuse = arrayGuard, writer = writer, format = format)
          val javaBack = official.read(arrays, write(decoded, true, format), format)
          assert(asGeneric(arrays, official.write(javaBack)) == asGeneric(arrays, genericBytes(writer, input), writer),
            s"Java array item promotion size=$size/$format")
        }
      }
      for (bytes <- encodings) {
        val expected = asGeneric(arrays, bytes, writer)
        val decoded = read(arrays, bytes, custom = true, writer = writer).asInstanceOf[example.ArrayValues]
        assert(asGeneric(arrays, write(decoded, custom = false)) == expected, s"array fresh size=$size")
        val previous = arrayGuard.longs
        val snapshot = previous.toVector
        assert(read(arrays, bytes, custom = true, reuse = arrayGuard, writer = writer) eq arrayGuard)
        assert(previous.toVector == snapshot, "reusing a record mutated its previous immutable List")
        assert(asGeneric(arrays, write(arrayGuard, custom = true)) == expected, s"array reuse size=$size")
        val stream = DecoderFactory.get().binaryDecoder(bytes ++ bytes, null)
        val reader = new SpecificDatumReader[SpecificRecordBase](writer, arrays, model(arrays, true))
        (0 until 2).foreach(_ => assert(asGeneric(arrays, write(reader.read(null, stream), true)) == expected))
        assert(stream.isEnd, "array decoding left data at the record boundary")
      }
      val truncated = genericBytes(writer, input).dropRight(1)
      try {
        read(arrays, truncated, custom = true, writer = writer)
        sys.error("truncated array data unexpectedly accepted")
      } catch { case _: java.io.IOException => () }
      if (size >= 32) {
        // Fail inside an array's element loop, not just on a missing final block marker.
        val partialBlock = genericBytes(writer, input).take(20)
        try {
          read(arrays, partialBlock, custom = true, writer = writer)
          sys.error("truncated array elements unexpectedly accepted")
        } catch { case _: java.io.IOException => () }
      }
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
    val old = legacy.schema("example.Old")
    for (seed <- 0 until 6) {
      val input = sample(old, seed).asInstanceOf[GenericRecord]
      // Bytes promoted to string must contain valid UTF-8.
      input.put("text", ByteBuffer.wrap("héllo-界".getBytes(java.nio.charset.StandardCharsets.UTF_8)))
      val bytes = genericBytes(old, input, chunks = true)
      val expected = asGeneric(evolved, bytes, old)
      val javaInput = legacy.read(old, bytes)
      for (format <- List("binary", "blocking", "json", "container")) {
        val javaBytes = legacy.write(javaInput, format)
        val decoded = read(evolved, javaBytes, true, writer = old, format = format)
        val javaBack = official.read(evolved, write(decoded, true, format), format)
        assert(asGeneric(evolved, official.write(javaBack)) == expected, s"Java schema resolution seed=$seed/$format")
        // The official Java reader independently resolves the same old writer schema.
        val javaResolved = official.read(evolved, javaBytes, format, writer = old)
        val scalaBack = read(evolved, official.write(javaResolved, format), true, format = format)
        assert(asGeneric(evolved, write(scalaBack, false)) == expected, s"Java resolved round trip seed=$seed/$format")
      }
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
    println("Custom coders: official generated Java <-> avro2s round trips, generic oracles, reuse, blocks, JSON, containers and schema evolution passed")
  }
}
