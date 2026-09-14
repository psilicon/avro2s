/** GENERATED CODE */

package avro2s.test.docs

/**
 * A four-byte identifier.
 */
case class DocumentedFixed() extends org.apache.avro.specific.SpecificFixed {
  override def getSchema: org.apache.avro.Schema = DocumentedFixed.SCHEMA$
  override def readExternal(in: java.io.ObjectInput): Unit = {
    avro2s.test.docs.DocumentedFixed.READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in))
    ()
  }
  override def writeExternal(out: java.io.ObjectOutput): Unit = {
    avro2s.test.docs.DocumentedFixed.WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out))
  }
}

object DocumentedFixed {
  val SCHEMA$ = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"fixed","name":"DocumentedFixed","namespace":"avro2s.test.docs","doc":"A four-byte identifier.","size":4}""")
  val READER$ = new org.apache.avro.specific.SpecificDatumReader[DocumentedFixed](DocumentedFixed.SCHEMA$, DocumentedFixed.SCHEMA$, new org.apache.avro.specific.SpecificData())
  val WRITER$ = new org.apache.avro.specific.SpecificDatumWriter[DocumentedFixed](DocumentedFixed.SCHEMA$, new org.apache.avro.specific.SpecificData())
  def apply(data: Array[Byte]): DocumentedFixed = {
    val fixed = new avro2s.test.docs.DocumentedFixed()
    fixed.bytes(data)
    fixed
  }
}