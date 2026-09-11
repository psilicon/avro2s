import example.{Empty, Symbols, SymbolsRecord}
import org.apache.avro.specific.SpecificDatumReader

object CheckScala3 {
  def main(args: Array[String]): Unit = {
    val reader = new SpecificDatumReader[SymbolsRecord]()
    reader.setSchema(SymbolsRecord.SCHEMA$)
    EnumWireChecks.check(reader)
    EnumWireChecks.check(new SpecificDatumReader[SymbolsRecord](classOf[SymbolsRecord]))
    assert(Symbols.valueOf("values$avro") eq Symbols.fromAvroSymbol("values"))
    assert(Symbols.fromAvroSymbol("fromOrdinal") eq Symbols.fromOrdinal$avro)
    Symbols.values.zipWithIndex.foreach { case (symbol, ordinal) =>
      assert(Symbols.fromOrdinal(ordinal) eq symbol)
    }
    List(-1, 0, 1).foreach { ordinal =>
      try {
        Empty.fromOrdinal(ordinal)
        sys.error("An empty enum must reject every ordinal")
      } catch { case _: java.util.NoSuchElementException => () }
    }
  }
}
