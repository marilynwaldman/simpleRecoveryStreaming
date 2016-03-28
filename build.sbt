//import AssemblyKeys._

name := "Streaming with Recovery"

organization := "com.level3"

scalaVersion := "2.10.4"

version := "1.0"



libraryDependencies ++= Seq ("org.apache.spark" %% "spark-core" % "1.3.0" % "provided",
                            "org.apache.spark" % "spark-streaming_2.10" % "1.3.0" % "provided",
                            "org.apache.spark" % "spark-streaming-kafka_2.10" % "1.3.0"  exclude("org.spark-project.spark", "unused") )

// Configure jar named used with the assembly plug-in
jarName in assembly := "streaming-with-recovery.jar"

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)



