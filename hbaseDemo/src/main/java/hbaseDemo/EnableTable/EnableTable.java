package hbaseDemo.EnableTable;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class EnableTable{
	static Logger logger;
   public static void main(String args[]) {
	   try {
		   Logger logger = LoggerFactory.getLogger(EnableTable.class);
      // Instantiating configuration class
      Configuration conf = HBaseConfiguration.create();

      // Instantiating HBaseAdmin class
      HBaseAdmin admin = new HBaseAdmin(conf);

      // Verifying whether the table is disabled
      Boolean bool = admin.isTableEnabled("emp");
      System.out.println("Table status : "+bool);

      // Enabling the table using HBaseAdmin object
      if(!bool){
         admin.enableTable("emp");
         System.out.println("Table Enabled");
      }}
	   catch(Exception exception)
	   {
		   logger.info("Exception is: "+ exception);
	   }
   }
}