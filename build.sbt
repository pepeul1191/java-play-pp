name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.8"

libraryDependencies += javaJdbc
libraryDependencies += cache
libraryDependencies += javaWs

libraryDependencies += "com.google.code.gson" % "gson" % "2.8.0"