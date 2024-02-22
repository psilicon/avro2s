/** GENERATED CODE */

package avro2s.test.arrays

case class Fixed() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = Fixed.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.arrays.Fixed.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.arrays.Fixed.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object Fixed {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"Fixed","namespace":"avro2s.test.arrays","size":2}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[Fixed](Fixed.SCHEMA$)
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[Fixed](Fixed.SCHEMA$)
  def apply(data: Array[Byte]): Fixed = {
    val fixed = new avro2s.test.arrays.Fixed()
    fixed.bytes(data)
    fixed
  }
}