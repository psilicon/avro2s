/** GENERATED CODE */

package avro2s.test.scalaenums.internal {
  enum Kw(private val symbol$: _root_.java.lang.String) {
    case `new` extends _root_.avro2s.test.scalaenums.internal.Kw("new")
    case `type` extends _root_.avro2s.test.scalaenums.internal.Kw("type")
    case `given` extends _root_.avro2s.test.scalaenums.internal.Kw("given")
    case NORMAL extends _root_.avro2s.test.scalaenums.internal.Kw("NORMAL")

    override def toString: _root_.java.lang.String = symbol$
  }

  object Kw {
    val SCHEMA$: _root_.org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"enum","name":"Kw","namespace":"avro2s.test.scalaenums","symbols":["new","type","given","NORMAL"]}""")

    def fromAvroSymbol(value: _root_.java.lang.String): _root_.avro2s.test.scalaenums.internal.Kw = value match {
      case "new" => _root_.avro2s.test.scalaenums.internal.Kw.`new`
      case "type" => _root_.avro2s.test.scalaenums.internal.Kw.`type`
      case "given" => _root_.avro2s.test.scalaenums.internal.Kw.`given`
      case "NORMAL" => _root_.avro2s.test.scalaenums.internal.Kw.NORMAL
      case other => throw new _root_.org.apache.avro.AvroRuntimeException("No enum symbol " + other + " in avro2s.test.scalaenums.Kw")
    }
  }
}

package avro2s.test.scalaenums {
  type Kw = _root_.avro2s.test.scalaenums.internal.Kw
  val Kw: _root_.avro2s.test.scalaenums.internal.Kw.type = _root_.avro2s.test.scalaenums.internal.Kw
}