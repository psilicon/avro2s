/** GENERATED CODE */

package avro2s.test.logical

case class CollidePeriod() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = CollidePeriod.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.logical.CollidePeriod.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.logical.CollidePeriod.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object CollidePeriod {
  val SCHEMA$ = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"CollidePeriod","namespace":"avro2s.test.logical","size":12,"logicalType":"duration"}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[CollidePeriod](CollidePeriod.SCHEMA$, CollidePeriod.SCHEMA$, new org.apache.avro.specific.SpecificData())
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[CollidePeriod](CollidePeriod.SCHEMA$, new org.apache.avro.specific.SpecificData())
  def apply(data: Array[Byte]): CollidePeriod = {
    val fixed = new avro2s.test.logical.CollidePeriod()
    fixed.bytes(data)
    fixed
  }
}