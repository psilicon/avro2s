/** GENERATED CODE */

package avro2s.test.logical

case class CollideRaw() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = CollideRaw.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.logical.CollideRaw.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.logical.CollideRaw.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object CollideRaw {
  val SCHEMA$ = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"CollideRaw","namespace":"avro2s.test.logical","size":8,"logicalType":"decimal","precision":10,"scale":2}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[CollideRaw](CollideRaw.SCHEMA$, CollideRaw.SCHEMA$, new org.apache.avro.specific.SpecificData())
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[CollideRaw](CollideRaw.SCHEMA$, new org.apache.avro.specific.SpecificData())
  def apply(data: Array[Byte]): CollideRaw = {
    val fixed = new avro2s.test.logical.CollideRaw()
    fixed.bytes(data)
    fixed
  }
}