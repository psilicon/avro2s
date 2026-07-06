/** GENERATED CODE */

package avro2s.test.scalaenums.internal {
  enum Kw {
    case `new`, `type`, `given`, NORMAL
  }

  object Kw {
    val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"enum","name":"Kw","namespace":"avro2s.test.scalaenums","symbols":["new","type","given","NORMAL"]}""")
  }
}

package avro2s.test.scalaenums {
  type Kw = avro2s.test.scalaenums.internal.Kw
  val Kw: avro2s.test.scalaenums.internal.Kw.type = avro2s.test.scalaenums.internal.Kw
}