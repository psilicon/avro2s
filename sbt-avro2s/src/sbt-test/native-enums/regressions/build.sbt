scalaVersion := "2.13.16"
crossScalaVersions := Seq("2.13.16", "3.3.6")

Compile / avro2sEnumType := "scala"
Compile / avro2sSchemaSource := crossTarget.value / "schemas"
Compile / sourceGenerators += (Compile / avro2sGenerate).taskValue

libraryDependencies += "org.apache.avro" % "avro" % "1.12.1"
libraryDependencies ++= (if (scalaBinaryVersion.value == "2.13")
  Seq("com.chuusai" %% "shapeless" % "2.3.13") else Nil)

val prepareSchemas = taskKey[Unit]("Create large enum schemas for compilation tests")

prepareSchemas := {
  val directory = (Compile / avro2sSchemaSource).value
  IO.copyDirectory((Compile / sourceDirectory).value / "avro", directory)
  Seq(
    "LargeAscii" -> ("x" * 70000),
    "LargeUnicode" -> ("界" * 22000),
    "LargeSupplementary" -> ("😀" * 11000)
  ).foreach { case (name, doc) =>
    IO.write(directory / s"$name.avsc",
      s"""{"type":"enum","name":"$name","namespace":"example","doc":"$doc","symbols":["A","org","Array"]}""")
  }

  // Scala 2 previously compiled this many symbols before unrolled cache initialization
  // exceeded the JVM method-size limit. Keep Scala 3 below its existing enum limits.
  val symbolCount = if (scalaBinaryVersion.value == "2.13") 2450 else 400
  val symbols = (0 until symbolCount).map(index => "\"S" + index + "\"").mkString(",")
  IO.write(directory / "LargeSymbolCount.avsc",
    s"""{"type":"enum","name":"LargeSymbolCount","namespace":"example","symbols":[$symbols]}""")
}

Compile / avro2sGenerate := ((Compile / avro2sGenerate) dependsOn prepareSchemas).value
