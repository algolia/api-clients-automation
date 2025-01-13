organization := "com.algolia"
name := "algoliasearch-scala"
description := "Scala client for Algolia Search API"
scalaVersion := "2.13.16"
crossScalaVersions := Seq("2.13.12", "3.5.2")
publishMavenStyle := true
Test / publishArtifact := false
licenses += ("MIT", url("https://opensource.org/licenses/MIT"))
homepage := Some(url("https://github.com/algolia/algoliasearch-client-scala/"))
scmInfo := Some(
  ScmInfo(
    url("https://github.com/algolia/algoliasearch-client-scala"),
    "scm:git:git@github.com:algolia/algoliasearch-client-scala.git"
  )
)
pomIncludeRepository := { _ =>
  false
}
developers += Developer(
  "algolia",
  "Algolia",
  "contact@algolia.com",
  url("https://github.com/algolia/algoliasearch-client-scala/")
)

publishTo := sonatypePublishToBundle.value

lazy val root = project
  .in(file("."))
  .enablePlugins(BuildInfoPlugin)
  .settings(
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "algoliasearch"
  )

// Project dependencies
libraryDependencies ++= Seq(
  "com.squareup.okhttp3" % "okhttp" % "4.12.0" % "compile",
  "org.json4s" %% "json4s-native" % "4.0.7" % "compile",
  "com.squareup.okhttp3" % "logging-interceptor" % "4.12.0",
  "org.slf4j" % "slf4j-api" % "2.0.16"
)

scalacOptions := Seq(
  "-unchecked",
  "-deprecation",
  "-feature"
)
