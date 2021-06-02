package hbaseDemo.ListTables;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.zookeeper.server.ConnectionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListTables {
	static Logger logger = LoggerFactory.getLogger(ListTables.class);
   @SuppressWarnings("deprecation")
public static void main(String args[])throws MasterNotRunningException, IOException{
	   try {
      // Instantiating a configuration class
      Configuration conf = HBaseConfiguration.create();

      // Instantiating HBaseAdmin class
      @SuppressWarnings("resource")
	HBaseAdmin admin = new HBaseAdmin(conf);

      // Getting all the list of tables using HBaseAdmin object
      HTableDescriptor[] tableDescriptor = admin.listTables();

      // printing all the table names.
      for (int i=0; i<tableDescriptor.length;i++ ){
         System.out.println(tableDescriptor[i].getNameAsString());
      }
   
   }
	   catch(Exception exception)
	   {
		   logger.info("Exception is : "+ exception  );
	   }
	   }
}