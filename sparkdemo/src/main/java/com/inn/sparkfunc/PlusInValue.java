package com.inn.sparkfunc;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;

import com.inn.sparkrunner.udf.AbstractUDF;

public class PlusInValue implements UDF1<Integer, Integer> , AbstractUDF{

	
	private static final long serialVersionUID = 1L;

	public String getName() {
		return "plusInValue";
	}

	public DataType getReturnType() {
		return DataTypes.IntegerType;
	}

	public Integer call(Integer x) throws Exception {
		return x+1;
	}
		
}

