/** GENERATED CODE */

package avro2s.test.arrays

case class FixedB() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = FixedB.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.arrays.FixedB.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.arrays.FixedB.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object FixedB {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"FixedB","namespace":"avro2s.test.arrays","size":2}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[FixedB](FixedB.SCHEMA$)
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[FixedB](FixedB.SCHEMA$)
  def apply(data: Array[Byte]): FixedB = {
    val fixed = new avro2s.test.arrays.FixedB()
    fixed.bytes(data)
    fixed
  }
}