scalaVersion := "2.13.16"
crossScalaVersions := Seq("2.13.16", "3.3.6")

Compile / avro2sEnumType := "scala"
Compile / sourceGenerators += (Compile / avro2sGenerate).taskValue

libraryDependencies += "org.apache.avro" % "avro" % "1.12.1"

val prepareSchemas = taskKey[Unit]("Create large enum schemas for compilation tests")

prepareSchemas := {
  val directory = (Compile / sourceDirectory).value / "avro"
  Seq(
    "LargeAscii" -> ("x" * 70000),
    "LargeUnicode" -> ("界" * 22000),
    "LargeSupplementary" -> ("😀" * 11000)
  ).foreach { case (name, doc) =>
    IO.write(directory / s"$name.avsc",
      s"""{"type":"enum","name":"$name","namespace":"example","doc":"$doc","symbols":["A"]}""")
  }
}
