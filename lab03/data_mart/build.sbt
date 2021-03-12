name := "data_mart"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.3.0"
// https://mvnrepository.com/artifact/com.datastax.spark/spark-cassandra-connector-embedded
libraryDependencies += "com.datastax.spark" %% "spark-cassandra-connector-embedded" % "2.3.0"
libraryDependencies += "org.elasticsearch" %% "elasticsearch-spark-20" % "7.7.0"