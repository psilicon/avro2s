/** GENERATED CODE */

package avro2s.test.spec

case class md5() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = md5.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.spec.md5.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.spec.md5.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object md5 {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"md5","namespace":"avro2s.test.spec","size":16}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[md5](md5.SCHEMA$)
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[md5](md5.SCHEMA$)
  def apply(data: Array[Byte]): md5 = {
    val fixed = new avro2s.test.spec.md5()
    fixed.bytes(data)
    fixed
  }
}