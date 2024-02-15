package avro2s.language

import enumeratum._

sealed trait ScalaVersion extends EnumEntry

object ScalaVersion extends Enum[ScalaVersion] {
  val values = findValues

  case object Scala_2_13 extends ScalaVersion
  case object Scala_3_X extends ScalaVersion

}
