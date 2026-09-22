ThisBuild / version := "0.33.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.16"

ThisBuild / organization := "io.psilicon"
ThisBuild / organizationName := "psilicon"
ThisBuild / organizationHomepage := Some(url("http://github.com/psilicon"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/psilicon/avro2s"),
    "scm:git@github.com:psilicon/avro2s.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id = "psilicon",
    name = "Psilicon",
    email = "hello@psilicon.io",
    url = url("http://github.com/psilicon")
  )
)

ThisBuild / description := "Avro to Scala case class generator"
ThisBuild / licenses := List(
  "Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")
)
ThisBuild / homepage := Some(url("https://github.com/psilicon/avro2s"))

ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val centralSnapshots = "https://central.sonatype.com/repository/maven-snapshots/"
  if (isSnapshot.value) Some("central-snapshots" at centralSnapshots)
  else localStaging.value
}

pgpPassphrase := sys.env.get("GPG_PASSPHRASE").map(_.toArray)

lazy val root = (project in file("."))
  .aggregate(avro2s.projectRefs ++ sbtAvro2s.projectRefs ++ benchmarks.projectRefs: _*)
  .settings(
    publish / skip := true
  )

lazy val avro2s = (projectMatrix in file("avro2s"))
  .settings(
    name := "avro2s",
    libraryDependencies ++= Seq(
      "org.apache.avro" % "avro" % versions.avro,
      "org.apache.avro" % "avro-compiler" % versions.avro,
      "io.circe" %% "circe-core" % "0.14.13",
      "io.circe" %% "circe-parser" % "0.14.13",
      "org.scala-lang.modules" %% "scala-collection-compat" % "2.13.0",
      // Test
      "org.scalatest" %% "scalatest" % "3.2.19" % Test,
      "org.slf4j" % "slf4j-api" % "1.7.36" % Test,
      "ch.qos.logback" % "logback-classic" % "1.2.10" % Test,
    ) ++ (
      if (scalaVersion.value.startsWith("2")) {
        Seq(
          "com.chuusai" %% "shapeless" % "2.3.13" % Test
        )
      } else {
        Seq()
      }
    ),
    // GenerateBenchmarkModels needs avro2s's generator on its classpath. Keeping it in Test
    // scope keeps it out of the published artifact, alongside RegenerateTestCode.
    Test / unmanagedSourceDirectories += (ThisBuild / baseDirectory).value / "benchmarks" / "generator"
  ).jvmPlatform(scalaVersions = Seq("2.12.20", "2.13.16", "3.3.6"))

lazy val sbtAvro2s = (projectMatrix in file("sbt-avro2s"))
  .settings(
    name := "sbt-avro2s",
    scalaVersion := "2.12.20",
    crossSbtVersions := Seq(sbtVersion.value),
    crossPaths := true,
    scriptedLaunchOpts := { scriptedLaunchOpts.value ++
      Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
    },
    scriptedBufferLog := false,
    // Disable plain sbt-avro2s artifacts
    publishArtifact := false,
    Compile / publishArtifact := false,
    Test / publishArtifact := false
  ).jvmPlatform(scalaVersions = Seq("2.12.20")).dependsOn(avro2s)
  .enablePlugins(SbtPlugin)

lazy val versions = new {
  val avro = "1.12.1"
}

// JMH benchmarks for the generated code. Models are generated from benchmarks/src/main/resources/avro
// on every compile, so the benchmarks always measure the working tree's generator output.
// scripts/compare-benchmarks.sh additionally drops another revision's output into baselineModelDirectory.
lazy val benchmarkBaselineDirectory = settingKey[File]("Generated models for the revision being compared against")

// The generator's own Scala version does not affect its output, so pin one and avoid
// rebuilding avro2s for Scala 3 purely to emit sources.
lazy val avro2sGenerator = avro2s.jvm("2.13.16")

lazy val benchmarks = (projectMatrix in file("benchmarks"))
  .dependsOn(avro2s)
  .enablePlugins(JmhPlugin)
  .settings(
    name := "avro2s-benchmarks",
    // Never publish this module. It is aggregated by root purely so its guard suite runs with
    // +test, and root aggregation is the path publishSigned takes on release. JmhPlugin also
    // puts jmh-core on the Compile classpath, which must never reach a published pom.
    publish / skip := true,
    publishArtifact := false,
    libraryDependencies ++= Seq(
      "org.apache.avro" % "avro" % versions.avro,
      "org.scalatest" %% "scalatest" % "3.2.19" % Test
    ) ++ (
      // Scala 2 union fields are shapeless Coproducts; Scala 3 uses native union types.
      if (scalaBinaryVersion.value == "2.13") Seq("com.chuusai" %% "shapeless" % "2.3.13") else Seq()
    ),
    benchmarkBaselineDirectory := target.value / "baseline-models",
    Compile / unmanagedSourceDirectories += benchmarkBaselineDirectory.value,
    Compile / sourceGenerators += Def.task {
      val output = (Compile / sourceManaged).value / "avro2s-models"
      val resources = (Compile / resourceDirectory).value / "avro"
      val targetVersion = if (scalaBinaryVersion.value == "2.13") "2.13" else "3"
      val arguments = Seq(resources.getAbsolutePath, output.getAbsolutePath, targetVersion)
      (avro2sGenerator / Test / runner).value.run(
        "GenerateBenchmarkModels",
        (avro2sGenerator / Test / fullClasspath).value.files,
        arguments,
        streams.value.log
      ).get
      // Java enums are emitted as .java, so both languages must be handed back.
      ((output ** "*.scala") +++ (output ** "*.java")).get()
    }.taskValue
  ).jvmPlatform(scalaVersions = Seq("2.13.16", "3.3.6"))
