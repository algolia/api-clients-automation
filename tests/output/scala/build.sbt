ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.5.2"

lazy val root = (project in file("."))
  .settings(name := "scala-tests")

val algoliasearch = ProjectRef(file("../../../clients/algoliasearch-client-scala"), "root")
dependsOn(algoliasearch)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test
libraryDependencies += "io.github.cdimascio" % "dotenv-java" % "3.2.0" % Test
