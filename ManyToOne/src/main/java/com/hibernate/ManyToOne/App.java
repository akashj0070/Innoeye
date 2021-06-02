package com.hibernate.ManyToOne;


import org.apache.log4j.Logger;
import org.hibernate.*;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.exception.SQLGrammarException;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
//import com.mysql.cj.api.xdevapi.Collection;    
    
public class App { 
	Logger logger;
	StandardServiceRegistry standardServiceRegistry;
	Metadata metadata;
	SessionFactory factory;
	Session session;
	Transaction transaction;
	public void ManyToOneImplementaion()
	{	
		try {
			logger.info("Starting applicaiton");
		 standardServiceRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	     metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();  
	      
	     logger.info("Creating factory and session objects");
	     factory=metadata.getSessionFactoryBuilder().build();  
	     session=factory.openSession();  
	      
	     transaction=session.beginTransaction();    
	        
	    Employee employee1=new Employee();    
	    employee1.setName("Akash");    
	    employee1.setEmail("akash@gmail.com");    
	      
	    Employee employee2=new Employee();  
	    employee2.setName("Anurag");  
	    employee2.setEmail("anurag@gmail.com");  
	        
	    Address address1=new Address();    
	    address1.setAddressLine1("G-13,Sector 3");    
	    address1.setCity("Noida");    
	    address1.setState("UP");    
	    address1.setCountry("India");    
	    address1.setPincode(201301);    
	  
	    employee1.setAddress(address1);    
	    employee2.setAddress(address1);  
	  
	    session.persist(employee1);    
	    session.persist(employee2);  
	    transaction.commit();    
	        logger.info("Transaction successful");
	    //Hibernate Named Query    
	    TypedQuery query = session.getNamedQuery("findEmployeeByName"); 
	    
	     query.setParameter("name","Aksah");  
	    
	             System.out.println("check2");
	     List<Employee> employees=query.getResultList();       
	     Iterator<Employee> itr=employees.iterator();    
	     while(itr.hasNext()){    
	     Employee e=itr.next();    
	     System.out.println(e);    
	     }  
	    
	
	     
//	     TypedQuery query=session.createQuery("from Employee a");    
//	    List<Employee> list=query.getResultList(); 
//	           
//	    Iterator<Employee> iterator=list.iterator();    
//	    while(iterator.hasNext()){    
//	     Employee employee=iterator.next();    
//	     System.out.println(employee.getEmployeeId()+" "+employee.getName()+" "+employee.getEmail());    
//	     Address address=employee.getAddress();    
//	     System.out.println(address.getAddressLine1()+" "+address.getCity()+" "+    
//	        address.getState()+" "+address.getCountry()+" "+address.getPincode());    
//	    }   
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
		finally {
			session.close();    
			logger.info("Success"); 
			
		}
	}
	public static void main(String[] args) {    
      
      App appObject=new App();
      appObject.ManyToOneImplementaion();
}    
}    