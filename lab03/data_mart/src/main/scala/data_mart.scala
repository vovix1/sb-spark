//package data_mart

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.rdd.RDD

object  data_mart  {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf(true)
      .setMaster("yarn")
      .setAppName("data_mart")
    val spark = SparkSession.builder.config(conf).getOrCreate
    val sc = spark.sparkContext

    val cities: Vector[String] = Vector("Moscow", "Paris", "Madrid", "London", "New York")


    spark.read
      .format("org.apache.spark.sql.cassandra")
      .options(Map("spark.cassandra.connection.host" -> "10.0.0.5",
        "spark.cassandra.connection.port" -> "9042",
        "spark.cassandra.auth.username" -> "vladimir.kartsev",
        "spark.cassandra.auth.password" -> "vGHn5A5f",
        "table" -> "clients",
        "keyspace" -> "labdata"))

    val rdd = sc.parallelize(cities)
    println(s"The RDD has ${rdd.count} elements, the first one is ${rdd.first}")
  }



}