package org.bitcamp.spark101;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aosama on 4/8/17.
 */
public class SimpleJavaSpark {


    public static void main(String args[])
    {
        JavaSparkContext sparkContext = new JavaSparkContext("local[1]", "SimpleSpak");


        //parallelize a list
        List<String> list1 = new ArrayList<>();
        list1.add("John");
        list1.add("Jake");
        list1.add("FINRA");
        list1.add("FINRA");
        list1.add("FINRA");
        list1.add("FINRA");


        JavaRDD<String> rdd = sparkContext.parallelize(list1);

        rdd.foreach(new VoidFunction<String>() {
            @Override
            public void call(String s) throws Exception {
                System.out.println(s);
            }
        });

        //write a separtor line
        System.out.println("=========================================================");

        rdd.distinct().foreach(new VoidFunction<String>() {
            @Override
            public void call(String s) throws Exception {
                System.out.println(s);
            }
        });


        sparkContext.stop();

    }

}
