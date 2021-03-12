package datamart

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.rdd.RDD

object  Main extends App {
  val conf = (new SparkConf(true)
                  .setMaster("yarn")
                  .setAppName("datamart"))
  val spark = SparkSession.builder.config(conf).getOrCreate

  val cities: Vector[String] = Vector("Moscow", "Paris", "Madrid", "London", "New York")



  val rdd = spark.parallelize(cities)
  println(s"The RDD has ${rdd.count} elements, the first one is ${rdd.first}")

}