// import web settings
seq(webSettings :_*)

organization := "jcheng"

name := "scala-web"

version := "1.0"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.1.v20110908" % "container",
  "javax.servlet" % "servlet-api" % "2.5" % "provided",
  "com.sun.jersey" % "jersey-bundle" % "1.10",
  "com.sun.jersey" % "jersey-json" % "1.10",
  "asm" % "asm" % "3.3.1"
)

retrieveManaged := true

transitiveClassifiers := Seq("sources")


