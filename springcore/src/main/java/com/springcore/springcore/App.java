package com.springcore.springcore;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{	
	
	public static Logger logger=Logger.getLogger(App.class);
	private AbstractApplicationContext context;
	public void SpringTest()
	{
		try{ 
			 BasicConfigurator.configure();
			 logger.info("Starting Spring application");
//			 Using config file
	    	 context = new ClassPathXmlApplicationContext("config.xml");
	    	 context.start();
	    	 Student studentObjectConfig =(Student) context.getBean("student1");
			 System.out.println(studentObjectConfig);
			 
//	    	 Setting and getting a value
//	    	 studentObjectConfig.setStudentId(4567);
//	    	 System.out.println(studentObjectConfig.getStudentId());
 
//	    	 Student studentObj2= (Student) context.getBean("student1");
//	    	 System.out.println(studentObjectConfig);			 
			 
			 
//			 Using annotaion file
/*
 * context =new AnnotationConfigApplicationContext( AppConfig.class); Student
 * studentObject =context.getBean(Student.class);
 * studentObject.setStudentId(13); studentObject.setStudentName("Akash");
 * studentObject.setStudentAddress("Kshipra");
 * System.out.println(studentObject);
 */
	    
			 
			 CollectionInSpring collectionInSpring = (CollectionInSpring) context.getBean("collections");
			 System.out.println(collectionInSpring);
			 
			 context.stop();
			 context.close();
			 context.registerShutdownHook();
	    	 logger.info("Successfully terminated");
	      	}
		
	    catch(NoSuchBeanDefinitionException noSuchBeanDefinitionException)
	    {  
	    	  logger.error(noSuchBeanDefinitionException);
	    }
		catch(BeansException beansException)
		{
			logger.error(beansException);
		}
		catch(IllegalStateException illegalStateException )
		{
			logger.error(illegalStateException);
		}
		catch(ClassCastException classCastException)
		{
			logger.error(classCastException);
		}

	}
    public static void main( String[] args )
    {      
     App appObj = new App();
     appObj.SpringTest();
    }
}
