/** GENERATED CODE */

package avro2s.test.logical

case class CollideFirst() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = CollideFirst.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.logical.CollideFirst.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.logical.CollideFirst.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object CollideFirst {
  val SCHEMA$ = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"CollideFirst","namespace":"avro2s.test.logical","size":8,"logicalType":"decimal","precision":10,"scale":2}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[CollideFirst](CollideFirst.SCHEMA$, CollideFirst.SCHEMA$, new org.apache.avro.specific.SpecificData())
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[CollideFirst](CollideFirst.SCHEMA$, new org.apache.avro.specific.SpecificData())
  def apply(data: Array[Byte]): CollideFirst = {
    val fixed = new avro2s.test.logical.CollideFirst()
    fixed.bytes(data)
    fixed
  }
}