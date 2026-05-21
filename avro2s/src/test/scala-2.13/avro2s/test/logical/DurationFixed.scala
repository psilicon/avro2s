/** GENERATED CODE */

package avro2s.test.logical

case class DurationFixed() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = DurationFixed.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.logical.DurationFixed.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.logical.DurationFixed.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object DurationFixed {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"DurationFixed","namespace":"avro2s.test.logical","size":12,"logicalType":"duration"}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[DurationFixed](DurationFixed.SCHEMA$, DurationFixed.SCHEMA$, new org.apache.avro.specific.SpecificData())
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[DurationFixed](DurationFixed.SCHEMA$, new org.apache.avro.specific.SpecificData())
  def apply(data: Array[Byte]): DurationFixed = {
    val fixed = new avro2s.test.logical.DurationFixed()
    fixed.bytes(data)
    fixed
  }
}