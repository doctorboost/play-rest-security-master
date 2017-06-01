lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

name := "play-rest-security"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  evolutions,
  "org.webjars" % "jquery" % "2.2.1",
  "mysql" % "mysql-connector-java" % "5.1.21",
  "io.swagger"        %% "swagger-play2"              % "1.5.3",
  "io.swagger"         % "swagger-parser"             % "1.0.16")

routesGenerator := InjectedRoutesGenerator

