/** GENERATED CODE */

package avro2s.generated

import org.apache.avro.Schema
import org.apache.avro.specific.SpecificData

class ScalaSpecificData extends SpecificData {
  override def createEnum(symbol: String, schema: Schema): AnyRef = {
    schema.getFullName match {
      case "avro2s.test.enums.Suit" => avro2s.test.enums.Suit.fromString(symbol)
      case _ => super.createEnum(symbol, schema)
    }
  }
}

object ScalaSpecificData {
  private val instance = new ScalaSpecificData()

  def get(): ScalaSpecificData = instance
}