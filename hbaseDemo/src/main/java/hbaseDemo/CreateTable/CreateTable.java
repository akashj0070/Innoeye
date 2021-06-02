package hbaseDemo.CreateTable;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateTable {
    static Logger logger;
   @SuppressWarnings("resource")
public static void main(String[] args) {
	   Logger logger = LoggerFactory.getLogger(CreateTable.class);
      // Instantiating configuration class
	   try {
      Configuration con = HBaseConfiguration.create();

      // Instantiating HbaseAdmin class
     
	HBaseAdmin admin = new HBaseAdmin(con);

      // Instantiating table descriptor class
      HTableDescriptor tableDescriptor = new
      HTableDescriptor(TableName.valueOf("employee"));

      // Adding column families to table descriptor
      tableDescriptor.addFamily(new HColumnDescriptor("personal"));
      tableDescriptor.addFamily(new HColumnDescriptor("professional"));

      // Execute the table through admin
      admin.createTable(tableDescriptor);
      logger.info(" Table created ");
	   }
	   catch(Exception exception)
	   {
		   logger.info("Exception is "+exception);
	   }
   }
}
