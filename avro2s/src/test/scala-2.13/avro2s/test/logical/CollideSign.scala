/** GENERATED CODE */

package avro2s.test.logical

case class CollideSign() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = CollideSign.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.logical.CollideSign.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.logical.CollideSign.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object CollideSign {
  val SCHEMA$ = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"CollideSign","namespace":"avro2s.test.logical","size":8,"logicalType":"decimal","precision":10,"scale":2}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[CollideSign](CollideSign.SCHEMA$, CollideSign.SCHEMA$, new org.apache.avro.specific.SpecificData())
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[CollideSign](CollideSign.SCHEMA$, new org.apache.avro.specific.SpecificData())
  def apply(data: Array[Byte]): CollideSign = {
    val fixed = new avro2s.test.logical.CollideSign()
    fixed.bytes(data)
    fixed
  }
}