package com.hibernate.ManyToMany2;

import java.util.ArrayList;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.exception.SQLGrammarException;


public class App 
{	
	static StandardServiceRegistry standardServiceRegistry;
	static Metadata metadata;
	static SessionFactory factory;
	static Session session;
	static Transaction transaction;
	static Logger logger;
    public static void main( String[] args )
    {
    	  try {
			standardServiceRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();    
			     metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();    
			     factory=metadata.getSessionFactoryBuilder().build();    
			     session=factory.openSession();    
			     transaction=session.beginTransaction();      
			          
     
			Student student1=new Student(1,"Akash",null);  
			Student student2=new Student(2,"Prajapat",null);  
			  
			session.save(student1); 
			session.save(student2);
			  
			  
			ArrayList<Student> list1=new ArrayList<Student>();  
			ArrayList<Student> list2=new ArrayList<Student>();  
			  
			list1.add(student1);  
			list1.add(student2);  
			  
			list2.add(student1);  
			list2.add(student2);  
			  
			Library lib1=new Library(101,"Data Structure",list1);  
			Library lib2=new Library(102,"DBMS",list2);  
			  
			  
			session.save(lib1);
			session.save(lib2);
			  
			transaction.commit();  
			
		} 		catch(SQLGrammarException sqlGrammarException)
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
    		  session.close();
    		  logger.info("Success"); 
    	  }
        
    }  
    }

