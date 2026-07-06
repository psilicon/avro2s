/** GENERATED CODE */

package avro2s.test.adtenums.internal

sealed trait Kw extends _root_.scala.Product with _root_.scala.Serializable

object Kw {
  case object `new` extends Kw
  case object `type` extends Kw
  case object `lazy` extends Kw
  case object NORMAL extends Kw

  val values: _root_.scala.List[_root_.avro2s.test.adtenums.internal.Kw] = _root_.scala.List(_root_.avro2s.test.adtenums.internal.Kw.`new`, _root_.avro2s.test.adtenums.internal.Kw.`type`, _root_.avro2s.test.adtenums.internal.Kw.`lazy`, _root_.avro2s.test.adtenums.internal.Kw.NORMAL)

  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"enum","name":"Kw","namespace":"avro2s.test.adtenums","symbols":["new","type","lazy","NORMAL"]}""")

  def valueOf(value: _root_.java.lang.String): _root_.avro2s.test.adtenums.internal.Kw = value match {
    case "new" => _root_.avro2s.test.adtenums.internal.Kw.`new`
    case "type" => _root_.avro2s.test.adtenums.internal.Kw.`type`
    case "lazy" => _root_.avro2s.test.adtenums.internal.Kw.`lazy`
    case "NORMAL" => _root_.avro2s.test.adtenums.internal.Kw.NORMAL
    case other => throw new org.apache.avro.AvroRuntimeException("No enum symbol " + other + " in avro2s.test.adtenums.Kw")
  }
}