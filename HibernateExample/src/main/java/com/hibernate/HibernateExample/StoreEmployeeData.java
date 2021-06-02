package com.hibernate.HibernateExample;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;

import javax.naming.directory.InvalidAttributesException;
import javax.net.ssl.SSLException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.sound.midi.MidiDevice.Info;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.query.spi.ParamLocationRecognizer.InFlightOrdinalParameterState;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.SQLGrammarException;  
  
@SuppressWarnings("unused")
public class StoreEmployeeData {  
  
      SessionFactory factory ;
	  Metadata metadata;
	  StandardServiceRegistry standardserviceregistry;
	  Configuration configuration;
	 Session session ;
	 Transaction transaction;
	 org.apache.log4j.Logger logger =  org.apache.log4j.Logger.getLogger(StoreEmployeeData.class);
	 Scanner scan=new Scanner(System.in);
	 private Integer Id=13;
	 private String firstName="Akash";
	 private String lastName="Prajapat";
	 private Integer AccountNumber=1319;
	// private String AccountHoldername="Akash Nandkishore Prajapat";
	 
	public void Employee()
		{
		  
    	try {
    		logger.info("Logs are Set");
        standardserviceregistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        metadata = new MetadataSources(standardserviceregistry).getMetadataBuilder().build();  
        factory = metadata.getSessionFactoryBuilder().build();  
         
        
        //To take custom inputs from the user with proper validations
/*    	System.out.println("Enter Id ");
    	while (!scan.hasNextInt()) 
    	{
    	System.out.println("Enter a valid Id");
            scan.next();
        }
    	Id=scan.nextInt();
    	
    	
    	System.out.println("Enter First Name");
    	while(!scan.hasNext("[A-Za-z]+"))
    	{
    		System.out.println("Enter Valid Name");
    		scan.next();
    	}
    	firstName=scan.next();
    	
    	
    	System.out.println("Enter Last Name");
    	while(!scan.hasNext("[A-Za-z]+"))
    	{
    		System.out.println("Enter a valid Last name");
    		scan.next();
    	}
    	lastName=scan.next();
    	
    	
    	System.out.println("Enter Account number ");
    	while (!scan.hasNextInt()) 
    	{
    	System.out.println("Enter a valid Account number");
            scan.next();
        }
    	AccountNumber=scan.nextInt();
*/
    	session = factory.openSession();  
    	transaction = session.beginTransaction();  
    	    Employees employee=new Employees(); 
    	    EmpAccount empAccount=new EmpAccount();
    	    employee.setId(Id);
            employee.setFirstName(firstName);    
            employee.setLastName(lastName);
            empAccount.setId(Id);
            empAccount.setAccountNumber(AccountNumber);
            empAccount.setAccountHolderName(firstName+" "+lastName);
            session.saveOrUpdate(empAccount);
            employee.setEmpAccount(empAccount);
            session.saveOrUpdate(employee);
          //  empAccount.setEmployees(employee);
            	System.out.println(employee.getEmpAccount());
            transaction.commit();  
            
            
            TypedQuery query=session.createQuery("from Employees e");    
            List<Employees> list=query.getResultList();    
                
            Iterator<Employees> iterator=list.iterator();    
            while(iterator.hasNext()){    
             Employees employeeobject=iterator.next();    
             System.out.println(employeeobject.getFirstName()+" "+employeeobject.getLastName()+" "+employeeobject.getId());    
             EmpAccount address=employeeobject.getEmpAccount();    
             System.out.println(address.getAccountNumber()+" "+address.getAccountHolderName()) ; 
            } 

       System.out.println("successfully saved");    
    	}
		catch(SQLGrammarException sqlGrammarException)
		{
			logger.error("SQLGrammarException Occured" + sqlGrammarException);
		}
		catch(PersistenceException persistenceException)
		{
			logger.error(persistenceException);
		}
		catch(IncompatibleClassChangeError incompatibleClassChangeError)
		{
			logger.error(incompatibleClassChangeError);
		}
		catch(ClassCastException classCastException)
		{
			logger.error(classCastException);
		}
    	finally
    	{	
    		logger.info("Closing session");
    		session.close(); 
    	}
  }
		
	public static void main( String[] args ) 
    { 
		StoreEmployeeData storeEmployeeData = new StoreEmployeeData();
		storeEmployeeData.Employee();
    }  
}  





//    	catch(SQLIntegrityConstraintViolationException sqlIntegrityConstraintViolationException)
//    	{
//    		sqlIntegrityConstraintViolationException.printStackTrace();
//    	}
//    	catch(IOException ioException)
//    	{
//    		ioException.printStackTrace();
//    	}