package com.aws.yarn

import com.aws.config.ConfigFactory._
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object WordCount extends App {

  val sc = new SparkConf()
      .setMaster("yarn")
      .setAppName("Gal Yarn Spark Aws Test Job")
      .set("spark.yarn.jars", "hdfs://<>/centos/jars/*.jar")
      .setJars(Array(""))

  SparkSession
    .builder()
    .config(yarnDefaultConf)
    .config("spark.yarn.jars", "hdfs://"+ NODE_EXTERNAL_2 + ":50470/user/centos/*.jar")
    .getOrCreate()
}
