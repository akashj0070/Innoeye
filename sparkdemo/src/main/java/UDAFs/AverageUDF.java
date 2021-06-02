package UDAFs;


import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.expressions.MutableAggregationBuffer;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inn.sparkrunner.udaf.AbstractUdaf;

public class AverageUDF extends AbstractUdaf {

	private static Logger logger = LoggerFactory.getLogger(AverageUDF.class);
	public	StructType inputSchema;
	public	StructType bufferSchema;
	
	@Override
	public String getName() {

		return "myavg";
	}
	
	public AverageUDF() {
		inputSchema = DataTypes.createStructType(new StructField[] { DataTypes.createStructField("Column", DataTypes.StringType,true)});
		bufferSchema = DataTypes.createStructType(new StructField[] { DataTypes.createStructField(
				"Column", DataTypes.createArrayType(DataTypes.StringType), true) });
	}

	@Override
	public StructType bufferSchema() {

		return bufferSchema;
	}

	@Override
	public DataType dataType() {

		return DataTypes.createArrayType(DataTypes.StringType);
	}

	@Override
	public boolean deterministic() {

		return true;
	}

	@Override
	public Object evaluate(Row arg0) {
		logger.info("inside evaluate  method  arg0.getList(0) value is:{}",arg0.getList(0));
		return arg0.getList(0);
	}

	@Override
	public void initialize(MutableAggregationBuffer buffer) {
		buffer.update(0, new ArrayList<String>());
		logger.info("inside initialize  method after initialization buffer value is:{}",buffer.<String>getList(0));
	}

	@Override
	public StructType inputSchema() {

		return inputSchema;
	}

	@Override
	public void merge(MutableAggregationBuffer buffer, Row row) {
		logger.info("inside merge  method buffer value is:{} and row value is:{}",buffer.<String>getList(0),row.<String>getList(0));
		List<String> rowList = getList(row.<String>getList(0));
		List<String> bufferList = getList(buffer.<String>getList(0));
		bufferList.addAll(rowList);
		buffer.update(0, bufferList);
	}

	@Override
	public void update(MutableAggregationBuffer buffer, Row row) {
		logger.info("inside update method buffer value is:{} and row value is:{}",buffer.<String>getList(0),row.getString(0));
		String value = row.getString(0);
		List<String> list = getList(buffer.<String>getList(0));
		if(value!= null){
			list.add(value);
		}
		buffer.update(0, list);
	}
	private List<String> getList(List<String> list) {
		List<String> newList = new ArrayList<String>();
		if(!list.isEmpty()){
			
			newList.addAll(list);
		}
		return newList;
	}

	public static void main(String[] args)
	{
		SparkConf sparkConf = new SparkConf();
	    sparkConf.setAppName("Spark WordCount example using Java");
	     //Setting Master for running it from IDE.
	    sparkConf.setMaster("local");	    
	    JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
	    SparkSession sparkSession=SparkSession.builder().config(sparkConf).getOrCreate();
	    sparkSession.sql("select 5");
	}
	
}