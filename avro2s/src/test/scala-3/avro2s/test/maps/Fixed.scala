/** GENERATED CODE */

package avro2s.test.maps

case class Fixed() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = Fixed.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.maps.Fixed.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.maps.Fixed.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object Fixed {
  val SCHEMA$ = new org.apache.avro.SchemaParser().parse("""{"type":"fixed","name":"Fixed","namespace":"avro2s.test.maps","size":2}""").mainSchema()
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[Fixed](Fixed.SCHEMA$, Fixed.SCHEMA$, new org.apache.avro.specific.SpecificData())
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[Fixed](Fixed.SCHEMA$, new org.apache.avro.specific.SpecificData())
  def apply(data: Array[Byte]): Fixed = {
    val fixed = new avro2s.test.maps.Fixed()
    fixed.bytes(data)
    fixed
  }
}