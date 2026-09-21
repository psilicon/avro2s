/** GENERATED CODE */

package avro2s.test.logical

case class MatrixDecimalFixed() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = MatrixDecimalFixed.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.logical.MatrixDecimalFixed.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.logical.MatrixDecimalFixed.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object MatrixDecimalFixed {
  val SCHEMA$ = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"MatrixDecimalFixed","namespace":"avro2s.test.logical","size":16,"logicalType":"decimal","precision":20,"scale":4}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[MatrixDecimalFixed](MatrixDecimalFixed.SCHEMA$, MatrixDecimalFixed.SCHEMA$, new org.apache.avro.specific.SpecificData())
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[MatrixDecimalFixed](MatrixDecimalFixed.SCHEMA$, new org.apache.avro.specific.SpecificData())
  def apply(data: Array[Byte]): MatrixDecimalFixed = {
    val fixed = new avro2s.test.logical.MatrixDecimalFixed()
    fixed.bytes(data)
    fixed
  }
}