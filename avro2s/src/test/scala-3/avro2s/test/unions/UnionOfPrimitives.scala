/** GENERATED CODE */

package avro2s.test.unions

import org.apache.avro.AvroRuntimeException

import scala.annotation.switch

case class UnionOfPrimitives(var _primitives: Long | Boolean | Int) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(0)

  override def getSchema: org.apache.avro.Schema = UnionOfPrimitives.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _primitives match {
        case x: Long => x.asInstanceOf[AnyRef]
        case x: Boolean => x.asInstanceOf[AnyRef]
        case x: Int => x.asInstanceOf[AnyRef]
      }
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => value match {
        case x: Long => this._primitives = x
        case x: Boolean => this._primitives = x
        case x: Int => this._primitives = x
        case _ => throw new AvroRuntimeException("Invalid value")
      }
    }
  }
}

object UnionOfPrimitives {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"UnionOfPrimitives","namespace":"avro2s.test.unions","fields":[{"name":"_primitives","type":["long","boolean","int"]}]}""")
}