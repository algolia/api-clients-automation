organization := "com.algolia"
name := "algoliasearch-scala"
description := "Scala client for Algolia Search API"
scalaVersion := "2.13.18"
crossScalaVersions := Seq("2.13.12", "3.6.3")
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

lazy val root = project
  .in(file("."))
  .enablePlugins(BuildInfoPlugin)
  .settings(
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "algoliasearch"
  )

// Project dependencies
libraryDependencies ++= Seq(
  "com.squareup.okhttp3" % "okhttp" % "5.3.2" % "compile",
  "org.json4s" %% "json4s-native" % "4.0.7" % "compile",
  "com.squareup.okhttp3" % "logging-interceptor" % "5.3.2",
  "org.slf4j" % "slf4j-api" % "2.0.17"
)

scalacOptions := Seq(
  "-unchecked",
  "-deprecation",
  "-feature"
)
