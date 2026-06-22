ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.18"

lazy val root = (project in file("."))
  .settings(
    name := "scala-playground"
  )


val algoliasearch = ProjectRef(file("../../clients/algoliasearch-client-scala"), "root")
dependsOn(algoliasearch)

libraryDependencies += "io.github.cdimascio" % "dotenv-java" % "3.2.0"
libraryDependencies += "io.github.json4s" %% "json4s-native" % "4.1.1"
