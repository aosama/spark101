package org.bitcamp.spark101

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by aosama on 4/8/17.
  */
object SimpleScalaSpark {


  private def runDistinctOperation(rdd: RDD[String]) :Unit = {

    //print values before distinct
    rdd.foreach(s => System.out.println(s))

    //print a separator line
    System.out.println("=================================================")


    rdd.distinct().foreach(s => print(s + "\n"));
  }

  //this is your local entry point for testing and/or running on your local machine
  def launchDistinctOperationInTestMode() :Unit =
  {
    //Create a spark configuration object
    val conf: SparkConf = new SparkConf().setAppName("SimpleSparkSample")
    //This is to let spark know that we are running locally
    conf.setMaster("local[4]")

    var sc = new SparkContext(conf)


    val rdd: RDD[String] =sc.textFile(FileLocations.getCountriesfileLocation)

    runDistinctOperation(rdd)

    sc.stop()
  }

  //this is the method that should be called to laucnh the code on an AWS cluster using spark-submit
  //spark-submit --class <your main class> --conf spark.yarn.executor.memoryOverhead=3072
  // --executor-memory 10G --driver-memory 10G --driver-class-path 'hadoop classpath' --master yarn-client
  // --num-executrs 600 <jarfilename.jar> > outputStream.txt 2> errorStream.txt
  def main (args: Array[String]) : Unit ={

  }



}
