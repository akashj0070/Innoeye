package spark.udaf.udaf;


import org.apache.spark.sql.Row;
import org.apache.spark.sql.expressions.MutableAggregationBuffer;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import com.inn.sparkrunner.udaf.AbstractUdaf;


public class TestUdaf extends AbstractUdaf {
	private static final long serialVersionUID = 1L;
	public StructType inputSchema;
	public StructType bufferSchema;
	public Integer max=null;
			@Override
			public String getName() {
				return "addition";
			}

			public TestUdaf() {		
				inputSchema = DataTypes.createStructType(
						new StructField[] { DataTypes.createStructField("Column", DataTypes.IntegerType, true) });
				bufferSchema = DataTypes.createStructType(
						new StructField[] { DataTypes.createStructField("Column1", DataTypes.IntegerType, true) });
			}

			
			//This method describes the schema of input to the UDAF.
			//Spark UDAFs can be defined to operate on any number of columns.
			@Override
			public StructType inputSchema() {
				return inputSchema;
			}

			//Similar to inputSchema, this method describes the schema of the UDAF buffer.
		    //for SumOFMax UDAF, we need to maintain only one piece of information.
			//i.e the total sum for each ID hence DoubleType
			@Override
			public StructType bufferSchema() {
				return bufferSchema;
			}

			@Override
			public boolean deterministic() {
				//This describes whether the UDAF we are implementing is deterministic or not.
				//Since, spark executes by splitting data, processing the chunks separately and 
				//combining them. If the UDAF logic is such that the result is independent of the
				//order in which data is processed and combined then the UDAF is deterministic.
				return true;
			}

			@Override
			public void initialize(MutableAggregationBuffer buffer) {
				//This method is used to initialize the buffer. 
				//This method is called once for each group
				buffer.update(0, new Integer(0));
			}

			@Override
			public void update(MutableAggregationBuffer buffer, Row row) {
//				
				Integer as = (Integer) row.getInt(0);
////				if (min==null) min=as;
				if(max<as) max=as;
//				Integer updatedsum = buffer.getInt(0) + as;
//				buffer.update(0, min);
				
//				Integer as = (Integer) row.getInt(0);
//				Integer updatedsum = buffer.getInt(0) + as;
//				buffer.update(0, updatedsum);

			}

			@Override
			public void merge(MutableAggregationBuffer buffer, Row row) {
				Integer sum = row.getInt(0);
				buffer.update(0, sum);
			}

			@Override
			public DataType dataType() {
				return DataTypes.IntegerType;
			}

			//This method will be called when all processing is complete and there is only one buffer left.
			//This will return the final value of UDAF.
			@Override
			public Object evaluate(Row row) {
				return row.getInt(0);
			}
			
			
//			public static void main(String[] args)
//			{
//				TestUdaf runavg = new TestUdaf();
//				
//		SparkConf sparkConf = new SparkConf();
//	    sparkConf.setAppName("Spark WordCount example using Java");
//	     //Setting Master for running it from IDE.
//	    sparkConf.setMaster("local");	    
//	    JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
//	    SparkSession sparkSession=SparkSession.builder().config(sparkConf).getOrCreate();
//	    sparkSession.sql("select 5");
//	    
//	}

}
