package avro2s.filesorter

/*
 * This code is from the avrohugger project - https://github.com/julianpeeters/avrohugger
 * Modifications:
 *  - package name
 *  - reimplemented
 */

import io.circe._

private[avro2s] object ReferredTypeFinder {
  def findReferredTypes(json: Json): List[String] = {
    json.fold(
      jsonNull = List.empty,
      jsonBoolean = _ => List.empty,
      jsonNumber = _ => List.empty,
      jsonString = str => List(str),
      jsonArray = arr => arr.toList.flatMap(findReferredTypes),
      jsonObject = obj => matchComplexType(obj)
    )
  }

  private def matchComplexType(fields: JsonObject): List[String] = {
    val typeOfRef = fields(Keys.Type).get
    typeOfRef.asString match {
      case Some(Keys.Array) => findReferredTypes(fields(Keys.Items).get)
      case Some(Keys.Enum) => List(fields(Keys.Name).get.as[String].getOrElse(throw new Exception("Enum must have a name")))
      case Some(Keys.Record) => findReferredTypes(fields(Keys.Fields).get)
      case Some(Keys.Map) => findReferredTypes(fields(Keys.Values).get)
      case _ => findReferredTypes(typeOfRef)
    }
  }

  private object Keys {
    val Fields = "fields"
    val Type = "type"
    val Items = "items"
    val Values = "values"
    val Array = "array"
    val Map = "map"
    val Enum = "enum"
    val Record = "record"
    val Name = "name"
  }

}
