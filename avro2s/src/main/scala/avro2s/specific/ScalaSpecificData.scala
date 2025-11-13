package avro2s.specific

import org.apache.avro.Schema
import org.apache.avro.generic.GenericEnumSymbol
import org.apache.avro.specific.SpecificData

/**
 * Custom SpecificData implementation that handles Scala enums (both sealed ADTs and Scala 3 enums)
 * in addition to standard Java enums.
 * 
 * This class overrides the createEnum method to support Scala enums that have a companion object
 * with a fromString method.
 */
class ScalaSpecificData extends SpecificData {
  
  override def createEnum(symbol: String, schema: Schema): AnyRef = {
    try {
      val enumClass = getClass(schema)
      
      // Try to get the companion object's fromString method for Scala enums
      val companionClassName = enumClass.getName + "$"
      try {
        val companionClass = Class.forName(companionClassName, true, enumClass.getClassLoader)
        val companionModule = companionClass.getField("MODULE$").get(null)
        val fromStringMethod = companionClass.getMethod("fromString", classOf[String])
        fromStringMethod.invoke(companionModule, symbol).asInstanceOf[AnyRef]
      } catch {
        case _: ClassNotFoundException | _: NoSuchMethodException | _: NoSuchFieldException =>
          // If companion object or fromString method not found, fall back to Java enum
          super.createEnum(symbol, schema)
      }
    } catch {
      case e: Exception =>
        throw new org.apache.avro.AvroRuntimeException(s"Failed to create enum for symbol: $symbol", e)
    }
  }
}

object ScalaSpecificData {
  private val instance = new ScalaSpecificData()
  
  def get(): ScalaSpecificData = instance
}

