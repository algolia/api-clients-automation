ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.8.4"

val algoliasearch = ProjectRef(file("../../../clients/algoliasearch-client-scala"), "root")

lazy val root = (project in file("."))
  .dependsOn(algoliasearch)
  .settings(
    name := "scala-tests",
    // The client cross-builds Scala 2.13/3 with a 2.13 default; sbt 2.x enforces
    // matching Scala versions across project dependencies (sbt 1.x matched only the
    // binary version). Allow the Scala 3 tests to depend on the client build.
    allowMismatchScala := true
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.20" % Test
libraryDependencies += "io.github.cdimascio" % "dotenv-java" % "3.0.1" % Test
