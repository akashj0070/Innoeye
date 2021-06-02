package sparkjava;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;

import org.apache.ivy.Main;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SparkOp {
	public static void main(String[] args)
	{
		Logger logger = LoggerFactory.getLogger("Spark Operaions");
		logger.info("Starting main application");
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(11);
		list1.add(13);
		list1.add(14);
		list1.add(15);
		list1.add(16);
		SparkConf sconf= new SparkConf().setAppName("spark operations").setMaster("local");
		try (JavaSparkContext sc = new JavaSparkContext(sconf)) {
			JavaRDD<Integer> jrdd = sc.parallelize(list1);
			int count= (int) jrdd.count();
		
			JavaRDD rdd2=jrdd.distinct();
			//rdd2.saveAsTextFile("/home/ist/Desktop/rdd2data");
			System.out.println(count);
			System.out.println(rdd2.collect());
		}
	}
}
