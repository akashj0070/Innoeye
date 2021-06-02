package kafka.consumer;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import kafka.constant.Constants;  

public class Consumer {
static Logger logger = Logger.getLogger(Consumer.class);
public Consumer()
{		
	
	System.out.println("Consumer");
	try{
		Properties props = new Properties();
		props.load(new FileInputStream("Log4j.properties"));
		PropertyConfigurator.configure(props);
		logger.info("In consumer ");
	  String bootstrapServers=Constants.localhost;  
      String grp_id=Constants.third_app;  
      String topic=Constants.mytopic;  
      //Creating consumer properties  
      Properties properties=new Properties();  
      properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);  
      properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,   StringDeserializer.class.getName());  
      properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());  
      properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,grp_id);  
      properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");  
      //creating consumer  
      KafkaConsumer<String,String> consumer= new KafkaConsumer<String,String>(properties);  
      //Subscribing  
      System.out.println("subscribing topic");
              consumer.subscribe(Arrays.asList(topic));  
      //polling  
      while(true){  
          ConsumerRecords<String,String> records=consumer.poll(Duration.ofMillis(100));  
          for(ConsumerRecord<String,String> record: records){  
        	  System.out.println( "Value:" +record.value());
        	  System.out.println("Partition:" + record.partition()+",Offset:"+record.offset());
              logger.info("Key: "+ record.key() + ", Value:" +record.value());  
              logger.info("Partition:" + record.partition()+",Offset:"+record.offset());  
          }
}
}
	catch(Exception exception)
	{
		logger.info("Exception is : "+exception);
	}
      
}
 public static void main(String[] args) {
	Consumer consumerObj = new Consumer();
	
}
}
