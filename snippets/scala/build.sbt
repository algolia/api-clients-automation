ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(name := "scala-snippets")

val algoliasearch = ProjectRef(file("../../clients/algoliasearch-client-scala"), "root")
dependsOn(algoliasearch)
