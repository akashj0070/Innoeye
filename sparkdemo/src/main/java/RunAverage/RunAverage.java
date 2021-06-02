package RunAverage;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.expressions.MutableAggregationBuffer;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import com.google.flatbuffers.Struct;
import com.inn.sparkrunner.udaf.AbstractUdaf;


public class RunAverage extends AbstractUdaf {
	public StructType inputSchema;
	public StructType bufferSchema;

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "addition";
			}

			public RunAverage() {
		
				inputSchema = DataTypes.createStructType(
						new StructField[] { DataTypes.createStructField("sal", DataTypes.IntegerType, true) });
				bufferSchema = DataTypes.createStructType(
						new StructField[] { DataTypes.createStructField("saladd", DataTypes.IntegerType, true) });

			}

			@Override
			public StructType inputSchema() {

				return null;
			}

			@Override
			public StructType bufferSchema() {
				// TODO Auto-generated method stub
				return bufferSchema;
			}

			@Override
			public boolean deterministic() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public void initialize(MutableAggregationBuffer buffer) {

				buffer.update(0, new Integer(0));
			}

			@Override
			public void update(MutableAggregationBuffer buffer, Row row) {
				// TODO Auto-generated method stub
				Integer as = (Integer) row.getInt(0);
				Integer updatedsum = buffer.getInt(0) + as;
				buffer.update(0, updatedsum);

			}

			@Override
			public void merge(MutableAggregationBuffer buffer, Row row) {
				// TODO Auto-generated method stub
				Integer sum = row.getInt(0);
				buffer.update(0, sum);

			}

			@Override
			public DataType dataType() {
				// TODO Auto-generated method stub
				return DataTypes.IntegerType;
			}

			@Override
			public Object evaluate(Row row) {
				// TODO Auto-generated method stub
				return row.getInt(0);
			}
			
			public static void main(String[] args)
			{
				RunAverage runavg = new RunAverage();
				
		SparkConf sparkConf = new SparkConf();
	    sparkConf.setAppName("Spark WordCount example using Java");
	     //Setting Master for running it from IDE.
	    sparkConf.setMaster("local");	    
	    JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
	    SparkSession sparkSession=SparkSession.builder().config(sparkConf).getOrCreate();
	    sparkSession.sql("select 5");
	    
	}

}
