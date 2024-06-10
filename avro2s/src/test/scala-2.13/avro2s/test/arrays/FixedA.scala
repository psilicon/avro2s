/** GENERATED CODE */

package avro2s.test.arrays

case class FixedA() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = FixedA.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.arrays.FixedA.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.arrays.FixedA.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object FixedA {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"FixedA","namespace":"avro2s.test.arrays","size":2}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[FixedA](FixedA.SCHEMA$)
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[FixedA](FixedA.SCHEMA$)
  def apply(data: Array[Byte]): FixedA = {
    val fixed = new avro2s.test.arrays.FixedA()
    fixed.bytes(data)
    fixed
  }
}