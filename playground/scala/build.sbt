ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.5.2"

lazy val root = (project in file("."))
  .settings(
    name := "scala-playground"
  )


val algoliasearch = ProjectRef(file("../../clients/algoliasearch-client-scala"), "root")
dependsOn(algoliasearch)

libraryDependencies += "io.github.cdimascio" % "dotenv-java" % "3.0.1"
libraryDependencies += "org.json4s" %% "json4s-native" % "4.0.7"
