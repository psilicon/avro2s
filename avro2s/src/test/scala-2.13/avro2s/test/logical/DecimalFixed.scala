/** GENERATED CODE */

package avro2s.test.logical

case class DecimalFixed() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = DecimalFixed.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.logical.DecimalFixed.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.logical.DecimalFixed.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object DecimalFixed {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"DecimalFixed","namespace":"avro2s.test.logical","size":2,"logicalType":"decimal","precision":4,"scale":2}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[DecimalFixed](DecimalFixed.SCHEMA$)
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[DecimalFixed](DecimalFixed.SCHEMA$)
  def apply(data: Array[Byte]): DecimalFixed = {
    val fixed = new avro2s.test.logical.DecimalFixed()
    fixed.bytes(data)
    fixed
  }
}