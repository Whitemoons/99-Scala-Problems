lazy val root = project 
    .in(file("."))
    .settings(
        name := "s99",

        version := "1.0",

        scalaVersion := "3.3.1",

        libraryDependencies += "org.scalameta" %% "munit" % "1.0.0-M10" % Test,

        cancelable in Global := true
    )