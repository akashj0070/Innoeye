package spark.udaf.average;


import java.util.ArrayList;
import java.util.List;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.expressions.MutableAggregationBuffer;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inn.sparkrunner.udaf.AbstractUdaf;


public class Myavg2 extends AbstractUdaf {


	private static Logger logger = LoggerFactory.getLogger(Myavg2.class);
	public	StructType inputSchema;
	public	StructType bufferSchema;

	
	@Override
	public String getName() {
		return "myavg2";}

	
	public Myavg2() {
		inputSchema = DataTypes.createStructType(new StructField[] { DataTypes.createStructField("Column", DataTypes.IntegerType,true)});
		bufferSchema = DataTypes.createStructType(new StructField[] { DataTypes.createStructField(
				"Column1", DataTypes.DoubleType,true),
				 DataTypes.createStructField(
							"Column2", DataTypes.DoubleType,true)});
	}



	@Override
	public StructType bufferSchema() {
	return bufferSchema;
	}

	@Override
	public DataType dataType() {
		return DataTypes.DoubleType;
	}

	@Override
	public boolean deterministic() {
		return true;
	}

	@Override
	public Object evaluate(Row arg0) {
		logger.info("inside evaluate  method  arg0.getDble(0) value is:{}",arg0.getDouble(0));
		return arg0.getDouble(0);
	}

	@Override
	public void initialize(MutableAggregationBuffer buffer) {
		logger.info("inside initialize  method before initialization");
		buffer.update(0, new Double(0));
		logger.info("inside initialize  method after initializing oth buffer");
		buffer.update(1, new Double(0));
		logger.info("inside initialize  method after initialization buffer value is:{}",buffer.getDouble(0));
	}

	@Override
	public StructType inputSchema() {
		return inputSchema;
	}

	@Override
	public void merge(MutableAggregationBuffer buffer, Row row) {
		logger.info("inside merge  method buffer value is:{} and row value is:{}",buffer.getDouble(0),row.getDouble(0));
		Double avg=row.getDouble(0)/row.getDouble(1);
		buffer.update(0,avg);
		//buffer.update(0, row.getInt(0));
		//buffer.update(1, row.getInt(0));
	}



	@Override
	public void update(MutableAggregationBuffer buffer, Row row) {
		logger.info("inside update method buffer value is:{} and row value is:{}",buffer,(Integer)row.getInt(0));
		Integer as = (Integer)row.getInt(0);
		Double updatedSum=buffer.getDouble(0)+as;
		Double updatedCount = buffer.getDouble(1)+1;
		buffer.update(0, updatedSum);
		buffer.update(1, updatedCount);
	}
}