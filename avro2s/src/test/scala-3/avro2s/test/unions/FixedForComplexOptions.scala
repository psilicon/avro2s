/** GENERATED CODE */

package avro2s.test.unions

case class FixedForComplexOptions() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = FixedForComplexOptions.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.unions.FixedForComplexOptions.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.unions.FixedForComplexOptions.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object FixedForComplexOptions {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"FixedForComplexOptions","namespace":"avro2s.test.unions","size":16}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[FixedForComplexOptions](FixedForComplexOptions.SCHEMA$)
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[FixedForComplexOptions](FixedForComplexOptions.SCHEMA$)
  def apply(data: Array[Byte]): FixedForComplexOptions = {
    val fixed = new avro2s.test.unions.FixedForComplexOptions()
    fixed.bytes(data)
    fixed
  }
}