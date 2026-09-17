lazy val common = Seq(
  scalaVersion := "3.3.6",
  Compile / fork := true,
  Compile / avro2sCustomCodersEnabled := true,
  Compile / avro2sSchemaSource := (LocalRootProject / baseDirectory).value / "src" / "main" / "avro",
  Compile / unmanagedSourceDirectories := Seq((LocalRootProject / baseDirectory).value / "src" / "main" / "scala"),
  Compile / sourceGenerators += (Compile / avro2sGenerate).taskValue,
  // Deliberately no avro2s runtime dependency.
  libraryDependencies += "org.apache.avro" % "avro" % "1.12.1"
)
lazy val root = project.in(file(".")).aggregate(javaEnums, nativeEnums, rawJava, rawNative)
lazy val javaEnums = project.in(file("java")).settings(common)
lazy val nativeEnums = project.in(file("native")).settings(common).settings(Compile / avro2sEnumType := "scala")
lazy val rawJava = project.in(file("raw-java")).settings(common).settings(Compile / avro2sLogicalTypesEnabled := false)
lazy val rawNative = project.in(file("raw-native")).settings(common).settings(
  Compile / avro2sLogicalTypesEnabled := false,
  Compile / avro2sEnumType := "scala"
)
