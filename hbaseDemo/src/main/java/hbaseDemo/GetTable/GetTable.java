package hbaseDemo.GetTable;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetTable{
	static Logger logger = LoggerFactory.getLogger(GetTable.class);
   @SuppressWarnings("deprecation")
public static void main(String[] args){
	  
   try {
	  logger.info("In the try block");
      // Instantiating Configuration class
      Configuration config = HBaseConfiguration.create();

      // Instantiating HTable class
      HTable table = new HTable(config, "emp");

      // Instantiating Get class
      Get get = new Get(Bytes.toBytes("2"));
      Scan sc = new Scan();
      // Scanning the required columns
      sc.addColumn(Bytes.toBytes("personal data"), Bytes.toBytes("name"));
      sc.addColumn(Bytes.toBytes("personal data"), Bytes.toBytes("city"));
      sc.addColumn(Bytes.toBytes("professional data"), Bytes.toBytes("role"));
      sc.addColumn(Bytes.toBytes("professional data"), Bytes.toBytes("salary"));
      ResultScanner scanner = table.getScanner(sc);
		for (Result result = scanner.next(); result != null; result = scanner.next())
		System.out.println(result);
		
      // Reading the data
      Result result = table.get(get);

      // Reading values from Result class object
      byte [] value = result.getValue(Bytes.toBytes("personal data"),Bytes.toBytes("name"));

      byte [] value1 = result.getValue(Bytes.toBytes("personal data"),Bytes.toBytes("city"));

      // Printing the values
      String name = Bytes.toString(value);
      String city = Bytes.toString(value1);
      table.close();
      System.out.println("name: " + name + " city: " + city);
   }
   catch(Exception exception)
   {
	   exception.printStackTrace();
   }
   }
}