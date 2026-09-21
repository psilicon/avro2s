/** GENERATED CODE */

package avro2s.test.logical

case class CollideResult() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = CollideResult.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.logical.CollideResult.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.logical.CollideResult.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object CollideResult {
  val SCHEMA$ = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"CollideResult","namespace":"avro2s.test.logical","size":8,"logicalType":"decimal","precision":10,"scale":2}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[CollideResult](CollideResult.SCHEMA$, CollideResult.SCHEMA$, new org.apache.avro.specific.SpecificData())
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[CollideResult](CollideResult.SCHEMA$, new org.apache.avro.specific.SpecificData())
  def apply(data: Array[Byte]): CollideResult = {
    val fixed = new avro2s.test.logical.CollideResult()
    fixed.bytes(data)
    fixed
  }
}