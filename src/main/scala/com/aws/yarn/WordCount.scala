package com.aws.yarn

import com.aws.config.ConfigFactory.{NODE_INTERNAL_2, NODE_EXTERNAL_2}
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object WordCount extends App {

//  val thisConfig = new SparkConf()
//      .setAppName("Gal Test Job on Aws Yarn Cluster")
//      .setMaster("yarn")
//      .set("spark.hadoop.fs.defaultFS", "hdfs://ip-172-31-21-121.eu-west-2.compute.internal:8020")
//      .set("spark.hadoop.yarn.resourcemanager.address", NODE_EXTERNAL_2 + ":8032")
//      .set("spark.yarn.jars", "hdfs://"+ NODE_INTERNAL_2 + ":8020/user/centos/*.jar")
//      .set("spark.hadoop.yarn.application.classpath", "$HADOOP_CLIENT_CONF_DIR,$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*")

  SparkSession
    .builder()
//    .config(thisConfig)
    .appName("Gal Test Job on Aws Yarn Cluster")
    .master("yarn")
    .config("spark.hadoop.fs.defaultFS", "hdfs://" + NODE_INTERNAL_2 + ":8020")
    .config("spark.hadoop.yarn.resourcemanager.address", NODE_INTERNAL_2 + ":8032")
    .config("spark.yarn.jars", "hdfs://" + NODE_INTERNAL_2 + ":8020/user/centos/*.jar")
    .config("spark.hadoop.yarn.application.classpath", "$HADOOP_CLIENT_CONF_DIR,$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*")

//    .config("spark.hadoop.dfs.namenode.servicerpc-address", NODE_EXTERNAL_2 + ":8022")
//    .config("spark.hadoop.dfs.https.address", NODE_EXTERNAL_2 + ":50470")
//    .config("spark.hadoop.dfs.namenode.http-address", NODE_EXTERNAL_2 + ":50070")
//
//    .config("spark.hadoop.yarn.resourcemanager.address", NODE_EXTERNAL_2 + ":8032")
//    .config("spark.hadoop.yarn.resourcemanager.admin.address", NODE_EXTERNAL_2 + ":8033")
//    .config("spark.hadoop.yarn.resourcemanager.scheduler.address", NODE_EXTERNAL_2 + ":8030")
//    .config("spark.hadoop.yarn.resourcemanager.resource-tracker.address", NODE_EXTERNAL_2 + ":8031")
//    .config("spark.hadoop.yarn.resourcemanager.webapp.address", NODE_EXTERNAL_2 + ":8088")
//    .config("spark.hadoop.yarn.resourcemanager.webapp.https.address", NODE_EXTERNAL_2 + ":8090")

    .config("spark.executor.memory", "512m")
    .config("spark.class", "com.aws.yarn.MaxFromList")
//    .config("spark.authenticate", "true")
//    .config("spark.hadoop.proxyuser.sparknotebook.hosts", "*")
//    .config("spark.hadoop.proxyuser.sparknotebook.users", "*")
//    .config("spark.hadoop.proxyuser.sparknotebook.groups", "*")
//    .config("spark.yarn.appMasterEnv.HADOOP_USER_NAME", "centos")
    //.config("spark.hadoop.yarn.scheduler.minimum-allocation-mb", "512")

    .getOrCreate()

  println("Gal Job Submitted")
}
