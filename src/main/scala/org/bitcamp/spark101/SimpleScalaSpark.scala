package org.bitcamp.spark101

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by aosama on 4/8/17.
  */
object SimpleScalaSpark {


  def simpleSparkExample() :Unit = {
    val conf: SparkConf = new SparkConf().setAppName("SimpleSparkSample")

    //This is to let spark know that we are running locally
    conf.setMaster("local[4]")

    var sc = new SparkContext(conf)


    val rdd: RDD[String] =sc.textFile(FileLocations.getSamplefileLocation)

    //print values before distinct
    rdd.foreach(s => System.out.println(s))

    //print a separator line
    System.out.println("=================================================")


    rdd.distinct().foreach(s => print(s + "\n"));
  }


}
