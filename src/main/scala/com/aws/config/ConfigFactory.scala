package com.aws.config

import org.apache.spark.SparkConf

object ConfigFactory {

  val NODE_EXTERNAL_1 = "ec2-35-178-171-55.eu-west-2.compute.amazonaws.com"
  val NODE_EXTERNAL_2 = "ec2-35-177-239-202.eu-west-2.compute.amazonaws.com"
  val NODE_EXTERNAL_3 = "ec2-35-178-239-117.eu-west-2.compute.amazonaws.com"

  val NODE_INTERNAL_1 = "ip-172-31-23-34.eu-west-2.compute.internal"
  val NODE_INTERNAL_2 = "172.31.21.121"
  val NODE_INTERNAL_3 = "ip-172-31-16-151.eu-west-2.compute.internal"

  def yarnDefaultConf: SparkConf = new SparkConf()
    .setMaster("yarn")
    .setAppName("Gal Yarn Spark Aws Test Job")

  def yarnManualConf: SparkConf = yarnDefaultConf
    .set("spark.hadoop.fs.defaultFS", "hdfs://ip-172-31-21-121.eu-west-2.compute.internal:8020")
    .set("spark.hadoop.yarn.resourcemanager.address", "ip-172-31-21-121.eu-west-2.compute.internal:8032")
    .set("spark.yarn.jars", "hdfs://ip-172-31-21-121.eu-west-2.compute.internal:8020/user/centos/jars/*.jar")
    .set("spark.hadoop.yarn.application.classpath", "$HADOOP_CLIENT_CONF_DIR,$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*")

  def localConf: SparkConf = new SparkConf()
    .setMaster("local[2]")
    .setAppName("Gal Local Spark Aws Test Job")

}
