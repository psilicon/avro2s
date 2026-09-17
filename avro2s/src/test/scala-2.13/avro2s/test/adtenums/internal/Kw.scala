/** GENERATED CODE */

package avro2s.test.adtenums.internal

sealed trait Kw extends _root_.scala.Product with _root_.scala.Serializable

object Kw {
  case object `new` extends _root_.avro2s.test.adtenums.internal.Kw { override def toString: _root_.java.lang.String = "new" }
  case object `type` extends _root_.avro2s.test.adtenums.internal.Kw { override def toString: _root_.java.lang.String = "type" }
  case object `lazy` extends _root_.avro2s.test.adtenums.internal.Kw { override def toString: _root_.java.lang.String = "lazy" }
  case object NORMAL extends _root_.avro2s.test.adtenums.internal.Kw { override def toString: _root_.java.lang.String = "NORMAL" }

  val values: _root_.scala.List[_root_.avro2s.test.adtenums.internal.Kw] = _root_.scala.List(_root_.avro2s.test.adtenums.internal.Kw.`new`, _root_.avro2s.test.adtenums.internal.Kw.`type`, _root_.avro2s.test.adtenums.internal.Kw.`lazy`, _root_.avro2s.test.adtenums.internal.Kw.NORMAL)

  val SCHEMA$: _root_.org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"enum","name":"Kw","namespace":"avro2s.test.adtenums","symbols":["new","type","lazy","NORMAL"]}""")

  private val avroSymbol$0: _root_.org.apache.avro.generic.GenericData.EnumSymbol = new _root_.org.apache.avro.generic.GenericData.EnumSymbol(SCHEMA$, "new")
  private val avroSymbol$1: _root_.org.apache.avro.generic.GenericData.EnumSymbol = new _root_.org.apache.avro.generic.GenericData.EnumSymbol(SCHEMA$, "type")
  private val avroSymbol$2: _root_.org.apache.avro.generic.GenericData.EnumSymbol = new _root_.org.apache.avro.generic.GenericData.EnumSymbol(SCHEMA$, "lazy")
  private val avroSymbol$3: _root_.org.apache.avro.generic.GenericData.EnumSymbol = new _root_.org.apache.avro.generic.GenericData.EnumSymbol(SCHEMA$, "NORMAL")

  def toAvroSymbol$(value: _root_.avro2s.test.adtenums.internal.Kw): _root_.org.apache.avro.generic.GenericData.EnumSymbol = {
    if (value == null) null
    else value.toString match {
      case "new" => avroSymbol$0
      case "type" => avroSymbol$1
      case "lazy" => avroSymbol$2
      case "NORMAL" => avroSymbol$3
      case other => throw new _root_.org.apache.avro.AvroRuntimeException("No enum symbol " + other + " in avro2s.test.adtenums.Kw")
    }
  }

  def fromAvroSymbol(value: _root_.java.lang.String): _root_.avro2s.test.adtenums.internal.Kw = value match {
    case "new" => _root_.avro2s.test.adtenums.internal.Kw.`new`
    case "type" => _root_.avro2s.test.adtenums.internal.Kw.`type`
    case "lazy" => _root_.avro2s.test.adtenums.internal.Kw.`lazy`
    case "NORMAL" => _root_.avro2s.test.adtenums.internal.Kw.NORMAL
    case other => throw new _root_.org.apache.avro.AvroRuntimeException("No enum symbol " + other + " in avro2s.test.adtenums.Kw")
  }

  def valueOf(value: _root_.java.lang.String): _root_.avro2s.test.adtenums.internal.Kw = fromAvroSymbol(value)
}