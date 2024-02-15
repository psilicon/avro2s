/** GENERATED CODE */

package avro2s.test.unions

case class Fixed2() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = Fixed2.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.unions.Fixed2.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.unions.Fixed2.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object Fixed2 {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"Fixed2","namespace":"avro2s.test.unions","size":1}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[Fixed2](Fixed2.SCHEMA$)
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[Fixed2](Fixed2.SCHEMA$)
  def apply(data: Array[Byte]): Fixed2 = {
    val fixed = new avro2s.test.unions.Fixed2()
    fixed.bytes(data)
    fixed
  }
}