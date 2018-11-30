package com.aws.cluster.yarn

import com.aws.config.ConfigFactory.yarnDefaultConf
import org.apache.spark.SparkContext

object MaxFromList extends App {

  val sc: SparkContext = new SparkContext(yarnDefaultConf)

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
