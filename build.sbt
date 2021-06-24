organization := "com.hitsoft"

name := "rogue-index-ensure"

version := "1.0.0"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  "com.foursquare" %% "rogue-index" % "2.5.1" intransitive(),
  "net.liftweb" %% "lift-mongodb-record" % "2.6.2"
)
