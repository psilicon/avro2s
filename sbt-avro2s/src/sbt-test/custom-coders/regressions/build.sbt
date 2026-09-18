// Compile Apache Avro's own Java output separately: it has the same fullnames as
// the Scala records and is loaded by an isolated loader in the interoperability tests.
def officialSettings(schemaDirectory: String) = Seq(
  autoScalaLibrary := false,
  crossPaths := false,
  libraryDependencies += "org.apache.avro" % "avro" % "1.12.1",
  Compile / sourceGenerators += Def.task {
    val inputs = ((LocalRootProject / baseDirectory).value / "src" / schemaDirectory / "avro" ** "*.avsc").get
    val output = (Compile / sourceManaged).value
    inputs.foreach { input =>
      val schema = new org.apache.avro.Schema.Parser().parse(input)
      val compiler = new org.apache.avro.compiler.specific.SpecificCompiler(schema)
      compiler.compileToDestination(input, output)
    }
    (output ** "*.java").get
  }.taskValue
)
lazy val officialJava = project.in(file("official-java")).settings(officialSettings("main"))
lazy val legacyJava = project.in(file("legacy-java")).settings(officialSettings("legacy"))

lazy val common = Seq(
  scalaVersion := "3.3.6",
  Compile / fork := true,
  Compile / javaOptions += {
    (officialJava / Compile / compile).value
    "-Davro2s.test.officialClasses=" + (officialJava / Compile / classDirectory).value.getAbsolutePath
  },
  Compile / javaOptions += {
    (legacyJava / Compile / compile).value
    "-Davro2s.test.legacyClasses=" + (legacyJava / Compile / classDirectory).value.getAbsolutePath
  },
  Compile / avro2sSchemaSource := (LocalRootProject / baseDirectory).value / "src" / "main" / "avro",
  Compile / unmanagedSourceDirectories := Seq((LocalRootProject / baseDirectory).value / "src" / "main" / "scala"),
  Compile / unmanagedSourceDirectories += (LocalRootProject / baseDirectory).value / "src" / "main" / "java",
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
