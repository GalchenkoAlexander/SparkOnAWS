package com.aws.local

import com.aws.config.ConfigFactory.localConf
import org.apache.spark.SparkContext

object MaxFromList extends App {

  val sc: SparkContext = new SparkContext(localConf)

  val rdd = sc.parallelize(List("0", "1", "2", "3", "4", "5"))
      .map(Integer.decode)
      .filter(i => i % 2 == 0)
      .map(i => i * 10)
  val res = rdd
      .reduce(Integer.max)

  println("Array of:")
  rdd.foreach(println)

  println(String.format("Max = [%s]", res.toString))
}
