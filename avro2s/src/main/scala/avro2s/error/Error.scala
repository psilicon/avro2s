package avro2s.error

object Error {
  case class NotImplementedError(msg: String) extends Exception(msg)
  case class SchemaError(msg: String) extends Exception(msg)
}
