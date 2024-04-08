/** GENERATED CODE */

package avro2s.test.logical

case class FixedDecimal() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = FixedDecimal.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.logical.FixedDecimal.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.logical.FixedDecimal.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object FixedDecimal {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"FixedDecimal","namespace":"avro2s.test.logical","size":2,"logicalType":"decimal","precision":4,"scale":2}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[FixedDecimal](FixedDecimal.SCHEMA$)
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[FixedDecimal](FixedDecimal.SCHEMA$)
  def apply(data: Array[Byte]): FixedDecimal = {
    val fixed = new avro2s.test.logical.FixedDecimal()
    fixed.bytes(data)
    fixed
  }
}