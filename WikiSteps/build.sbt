ThisBuild / useCoursier := false

name := "FirstSteps"
version := "0.1"

scalaVersion := "2.12.8"

scalacOptions ++= Seq(
  "-language:existentials",
  "-language:implicitConversions"
)


libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.3.1"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "3.3.1"
libraryDependencies += "io.gatling"            % "gatling-core"              % "3.3.1"

enablePlugins(GatlingPlugin)