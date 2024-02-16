package avro2s.filesorter

import io.circe.parser._

private[avro2s] object TypeComparator {
  def strContainsType(candName: String, str: String, name: String): Boolean = {
    def isMatch(regex: String): Boolean = {
      regex.r.findFirstIn(str).isDefined
    }
    val types = ReferredTypeFinder.findReferredTypes(parse(str).getOrElse(throw new Exception("Failed to parse json")))
    val namespace = name.split("\\.") match {
      case x if x.length == 1 => ""
      case x => x.dropRight(1).mkString("\\.")
    }
    val namespaceRegex = "\\\"namespace\\\"\\s*:\\s*\\\"" + namespace + "\\\""
    val isSameNamespace = isMatch(namespaceRegex)
    val simpleTypeName = name.split("\\.").last
    val simpleCandidateName = candName.split("\\.").last

    val withoutSelf: List[String] = types
      .filter(x => x != candName)
      .filter(x => if (isSameNamespace) x != simpleCandidateName else true)

    def isReferred(name:String): Boolean = {
      withoutSelf.contains(name)
    }

    isReferred(name) || (isSameNamespace && isReferred(simpleTypeName))
  }

}
