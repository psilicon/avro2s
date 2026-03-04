name := "standard-test"

scalaVersion := "3.3.7"

Compile / sourceGenerators += (Compile / avro2sGenerate).taskValue

libraryDependencies ++= Seq(
  "org.apache.avro" % "avro" % "1.12.1"
)