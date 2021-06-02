package kafka.kafkaproducer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.LoggerFactory;

import kafka.constant.Constants;


public class App {		
	
	static Logger logger = Logger.getLogger(App.class);
	public App(){
		try {	
			Properties props = new Properties();
			props.load(new FileInputStream("Log4j.properties"));
			PropertyConfigurator.configure(props);
			System.out.println("producer");
			logger.info("calling constructor for producer");
			Properties properties = new Properties();
			properties.put(Constants.server,Constants.localhost);

		//we send data from kafka producer to kafka server than it is consumed by consumer
		//we cannot directly send object , we need a serialization 
		properties.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
		properties.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
		
		//when we send data to kafka server we send it as producer record 
		ProducerRecord proRec = new ProducerRecord("mytopic", "Msg data");
		
		//creating instance of kafkaproducer
		KafkaProducer kafkaProducer = new KafkaProducer(properties);
		
		kafkaProducer.send(proRec);
		
		kafkaProducer.close();
		}
		catch(FileNotFoundException fileNotFoundException)
		{	
			fileNotFoundException.printStackTrace();
			logger.info("Exception is : "+fileNotFoundException);
		}
		catch(IOException ioException)
		{
			ioException.printStackTrace();
			logger.info("Exception is : "+ioException);
		}
		catch(Exception exception)
		{	
			exception.printStackTrace();
			logger.info("Exception  is : "+exception);
		}
	}
    public static void main( String[] args ) 
    {             	App objApp = new App();
        
    }
}
