package com.operation.JpaDemo;
//import org.slf4j.Logger;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class App 
{
    private static Scanner scanner;
    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(App.class);
    
	public static void main( String[] args )
    {	Integer id;
    	String name ;
    	String technology;
    	try {
    		
    		//Log my_log = new Log("log.txt");
    	//	final Logger loge = Logger.getLogger(App.class);
    		logger.info("Logs are ready to set");
 //   		LogManager lgmngr = LogManager.getLogManager();
    		//logger.log(Level.ALL, "All levels are logged");
    		//logger.isEnabled(WARN);
   // FileWriter file=new FileWriter("logs.txt");
    		
    	scanner = new Scanner(System.in);
    	
    	logger.info("Logging in main method");
    	System.out.println("Enter Id ");
    	while (!scanner.hasNextInt()) {
    	System.out.println("Enter a valid Id");
            scanner.next();
        }
    	id=scanner.nextInt();
    	
    	
    	logger.info("log in name field");
    	System.out.println("Enter your name");
    	while (!scanner.hasNext("[A-Za-z]+")) {
            System.out.println("Enter a valid name");
            scanner.next();
        }    	
    	name=scanner.next();
    	
//    	java.util.logging.Logger log = slg.getLogger(name);
 //   	log.log(Level.WARNING, "Logging after name"); 
    	logger.info("Log in Technnology field");
    	System.out.println("Enter technology ");
    	while (!scanner.hasNext("[A-Za-z]+")) {
            System.out.println("Enter a valid Technology");
            scanner.next();
        }    
    	technology=scanner.next();
    	
    	EntityManagerFactory emf= Persistence.createEntityManagerFactory("PersistentUnit");
    	EntityManager em= emf.createEntityManager();
    	EntityTransaction transaction = em.getTransaction();
        DemoJpa a = em.find(DemoJpa.class, 13);
        DemoJpa jpa = new DemoJpa();
        transaction.begin();
        jpa.setId(id);
        jpa.setName(name);
        jpa.setTech(technology);
        em.persist(jpa);
        
        transaction.commit();
        System.out.println("Success check your DB table");
    	}
    	catch(IllegalStateException illegalStateException){
    		illegalStateException.printStackTrace();    		
    	}
    	catch(IllegalArgumentException illegalArgumentException)
    	{
    		illegalArgumentException.printStackTrace();
    	}
    	catch (InputMismatchException inputMismatchException)
    	{
    		inputMismatchException.printStackTrace();
    	} 

    	System.exit(0);
    }
}
