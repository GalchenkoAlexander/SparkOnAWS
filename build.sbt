name := "SparkOnAWS"

version := "0.1"

scalaVersion := "2.11.12"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.2"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.3.2"

// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.3.2" % "provided"

// https://mvnrepository.com/artifact/org.apache.spark/spark-mllib
libraryDependencies += "org.apache.spark" %% "spark-mllib" % "2.3.2" % "runtime"

// https://mvnrepository.com/artifact/org.apache.spark/spark-graphx
libraryDependencies += "org.apache.spark" %% "spark-graphx" % "2.3.2"

// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming-kafka
libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka" % "1.6.3"

mainClass in (Compile, run) := Some("com.aws.local")