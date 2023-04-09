ThisBuild / scalaVersion := "2.12.8"

val project_name = "ExperimentGraphs"
name := project_name

val scalaTestVersion = "3.1.2"

run / fork := true

lazy val root = (project in file("."))
  .settings(
    name := f"${project_name}",
    libraryDependencies += "org.scalatest" %% "scalatest" % scalaTestVersion % "test",
    libraryDependencies += "ch.epfl.data" %% "cloudcity-library" % "2.0-SNAPSHOT",
    Test / parallelExecution := false,
  )