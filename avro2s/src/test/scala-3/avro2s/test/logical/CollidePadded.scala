/** GENERATED CODE */

package avro2s.test.logical

case class CollidePadded() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = CollidePadded.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.logical.CollidePadded.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.logical.CollidePadded.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object CollidePadded {
  val SCHEMA$ = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"CollidePadded","namespace":"avro2s.test.logical","size":8,"logicalType":"decimal","precision":10,"scale":2}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[CollidePadded](CollidePadded.SCHEMA$, CollidePadded.SCHEMA$, new org.apache.avro.specific.SpecificData())
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[CollidePadded](CollidePadded.SCHEMA$, new org.apache.avro.specific.SpecificData())
  def apply(data: Array[Byte]): CollidePadded = {
    val fixed = new avro2s.test.logical.CollidePadded()
    fixed.bytes(data)
    fixed
  }
}