package Spark.sparkdemo;


import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

public class App {

	private static JavaSparkContext sparkContext;

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(App.class);
		   try {
			SparkConf sparkConf = new SparkConf();
			    
			    sparkConf.setAppName("Spark WordCount example using Java");
			    
			    //Setting Master for running it from IDE.
			    sparkConf.setMaster("local");
			    
			    sparkContext = new JavaSparkContext(sparkConf);
			 JavaRDD<String> textFile = sparkContext.textFile("/home/ist/Desktop/employee.txt");
			JavaPairRDD<String, Integer> counts = textFile
			    .flatMap(s -> Arrays.asList(s.split(" ")).iterator())
			    .mapToPair(word -> new Tuple2<>(word, 1))
			    .reduceByKey((a, b) -> a + b);
			
			counts.saveAsTextFile("/home/ist/Desktop/new3");
			logger.info("data saved");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
