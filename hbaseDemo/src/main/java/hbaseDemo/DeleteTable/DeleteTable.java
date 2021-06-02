package hbaseDemo.DeleteTable;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteTable{

   public static void main(String args[]) {
	   Logger logger = LoggerFactory.getLogger(DeleteTable.class);
      // Instantiating configuration class
      Configuration conf = HBaseConfiguration.create();
      try {
      // Instantiating HBaseAdmin class
      HBaseAdmin admin = new HBaseAdmin(conf);
      // Verifying weather the table is disabled
     
      Boolean bool = admin.isTableDisabled("employee");
      System.out.println(bool);
      
      // Disabling the table using HBaseAdmin object
      if(!bool){
         admin.disableTable("employee");
         //admin.deleteTable("employee");
         System.out.println("Table disabled");
      }
   }
      catch(Exception exception)
      {
    	  logger.info("Exception is "+exception);
      }
   }
}