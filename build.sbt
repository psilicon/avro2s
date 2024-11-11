ThisBuild / version := "0.21.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

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
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true

ThisBuild / credentials += Credentials(
  "Sonatype Nexus Repository Manager",
  "s01.oss.sonatype.org",
  sys.env.getOrElse("NEXUS_USERNAME", ""),
  sys.env.getOrElse("NEXUS_PASSWORD", "")
)

pgpPassphrase := sys.env.get("GPG_PASSPHRASE").map(_.toArray)

lazy val root = (project in file("."))
  .aggregate(avro2s.projectRefs ++ sbtAvro2s.projectRefs: _*)
  .settings(
    publish / skip := true
  )

lazy val avro2s = (projectMatrix in file("avro2s"))
  .settings(
    name := "avro2s",
    libraryDependencies ++= Seq(
      "org.apache.avro" % "avro" % versions.avro,
      "org.apache.avro" % "avro-compiler" % versions.avro,
      "io.circe" %% "circe-core" % "0.14.6",
      "io.circe" %% "circe-parser" % "0.14.6",
      "org.scala-lang.modules" %% "scala-collection-compat" % "2.8.1",
      // Test
      "org.scalatest" %% "scalatest" % "3.2.16" % Test,
      "org.slf4j" % "slf4j-api" % "1.7.36" % Test,
      "ch.qos.logback" % "logback-classic" % "1.2.10" % Test,
    ) ++ (
      if (scalaVersion.value.startsWith("2")) {
        Seq(
          "com.chuusai" %% "shapeless" % "2.3.10" % Test
        )
      } else {
        Seq()
      }
    ),
  ).jvmPlatform(scalaVersions = Seq("2.12.18", "2.13.12", "3.4.0"))

lazy val sbtAvro2s = (projectMatrix in file("sbt-avro2s"))
  .settings(
    name := "sbt-avro2s",
    scalaVersion := "2.12.18",
    crossSbtVersions := Seq(sbtVersion.value),
    scriptedLaunchOpts := { scriptedLaunchOpts.value ++
      Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
    },
    scriptedBufferLog := false
  ).jvmPlatform(scalaVersions = Seq("2.12.18")).dependsOn(avro2s)
  .enablePlugins(SbtPlugin)

lazy val versions = new {
  val avro = "1.11.3"
}
