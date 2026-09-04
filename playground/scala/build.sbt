ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.9.0"

val algoliasearch = ProjectRef(file("../../clients/algoliasearch-client-scala"), "root")

lazy val root = (project in file("."))
  .dependsOn(algoliasearch)
  .settings(
    name := "scala-playground"
  )

libraryDependencies += "io.github.cdimascio" % "dotenv-java" % "3.2.0"
libraryDependencies += "io.github.json4s" %% "json4s-native" % "4.1.1"
