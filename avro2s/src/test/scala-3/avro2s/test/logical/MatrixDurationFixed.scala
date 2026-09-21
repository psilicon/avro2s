/** GENERATED CODE */

package avro2s.test.logical

case class MatrixDurationFixed() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = MatrixDurationFixed.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.logical.MatrixDurationFixed.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.logical.MatrixDurationFixed.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object MatrixDurationFixed {
  val SCHEMA$ = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"MatrixDurationFixed","namespace":"avro2s.test.logical","size":12,"logicalType":"duration"}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[MatrixDurationFixed](MatrixDurationFixed.SCHEMA$, MatrixDurationFixed.SCHEMA$, new org.apache.avro.specific.SpecificData())
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[MatrixDurationFixed](MatrixDurationFixed.SCHEMA$, new org.apache.avro.specific.SpecificData())
  def apply(data: Array[Byte]): MatrixDurationFixed = {
    val fixed = new avro2s.test.logical.MatrixDurationFixed()
    fixed.bytes(data)
    fixed
  }
}