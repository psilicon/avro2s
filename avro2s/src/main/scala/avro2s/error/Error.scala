package avro2s.error

private[avro2s] object Error {
  case class NotImplementedError(msg: String) extends Exception(msg)
  case class SchemaError(msg: String) extends Exception(msg)
  case class ConfigError(msg: String) extends Exception(msg)
}
