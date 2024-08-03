name := "standard-test"

scalaVersion := "3.4.0"

Compile / sourceGenerators += (Compile / avro2sGenerate).taskValue

libraryDependencies ++= Seq(
  "org.apache.avro" % "avro" % "1.11.3"
)