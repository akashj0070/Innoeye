package hbaseDemo.PutTable;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class PutTable{

   @SuppressWarnings("deprecation")
public static void main(String[] args)  {
try {
      // Instantiating Configuration class
      Configuration config = HBaseConfiguration.create();

      // Instantiating HTable class
      HTable hTable = new HTable(config, "emp");

      // Instantiating Put class
      // accepts a row name.
      Put p = new Put(Bytes.toBytes("1")); 

      // adding values using add() method
      // accepts column family name, qualifier/row name ,value
      p.add(Bytes.toBytes("personal data"),
      Bytes.toBytes("name"),Bytes.toBytes("akash"));

      p.add(Bytes.toBytes("personal data"),
      Bytes.toBytes("city"),Bytes.toBytes("indore"));

      p.add(Bytes.toBytes("professional data"),Bytes.toBytes("designation"),
      Bytes.toBytes("trainee"));

      p.add(Bytes.toBytes("professional data"),Bytes.toBytes("salary"),
      Bytes.toBytes("12000"));
      
      // Saving the put Instance to the HTable.
      hTable.put(p);
      System.out.println("data inserted");
      
      // closing HTable
      hTable.close();}
catch(Exception exception)
{
	exception.printStackTrace();
}
   }
}