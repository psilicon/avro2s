/** GENERATED CODE */

package avro2s.test.unions

case class Fixed1() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = Fixed1.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.unions.Fixed1.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.unions.Fixed1.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object Fixed1 {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"Fixed1","namespace":"avro2s.test.unions","size":1}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[Fixed1](Fixed1.SCHEMA$)
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[Fixed1](Fixed1.SCHEMA$)
  def apply(data: Array[Byte]): Fixed1 = {
    val fixed = new avro2s.test.unions.Fixed1()
    fixed.bytes(data)
    fixed
  }
}