package sparkdemo.udf;

import static org.apache.spark.sql.functions.udf;

import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.expressions.UserDefinedFunction;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;
class SparkUdf
{
	static Logger logger = Logger.getLogger(SparkUdf.class);
	public static void main(String[] args)
	{	try {
		
		logger.info("Loggers are ready");
		SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("Spark WordCount example using Java");
    
    sparkConf.setMaster("local");
    SparkSession sparkSession=SparkSession.builder().config(sparkConf).getOrCreate();

//    StructType schema = new StructType()
//        .add("department", "string")
//        .add("designation", "string")
//        .add("ctc", "long")
//        .add("state", "string");
//    Dataset<Row> products =sparkSession.read().format("csv").option("header", "true")
//    		.schema(schema).load("/home/ist/Desktop/empdata.csv");
//    products.show();
//    
    
    UserDefinedFunction random = udf(() -> Math.random(), DataTypes.DoubleType);
    random.asNondeterministic();
    sparkSession.udf().register("random", random);
    sparkSession.sql("SELECT random()").show();
		
    sparkSession.udf().register("plusOne", new UDF1<Integer, Integer>() {
    	  @Override
    	  public Integer call(Integer x) {
    	    return x + 1;
    	  }
    	}, DataTypes.IntegerType);
    sparkSession.sql("SELECT plusOne(5)").show();
	}
	catch(IllegalStateException illegalStateException)
	{
		illegalStateException.printStackTrace();
	}
	catch(Exception exception)
	{
		exception.printStackTrace();
	}
	}	
}