package com.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.SQLGrammarException;

public class App 
{	 
	 static SessionFactory factory ;
	static  Metadata meta;
	static  StandardServiceRegistry ssr;
	static Session session ;
	static Transaction transaction;
	 static Configuration configuration;
 
    public static void main( String[] args )
    {
            	try 
    	{ 
    		System.out.println("check1");
    		ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    		meta = new MetadataSources(ssr).getMetadataBuilder().build();  
    		factory = meta.getSessionFactoryBuilder().build();  
    		
    		
    		System.out.println("check2");
    		College college=new College();
    		session = factory.openSession();  
    		transaction = session.beginTransaction();
    		
    		college.setCollegeName("AITR");
    		
    		Students student1= new Students();
    		student1.setStudentName("Akash");
    		
    		Students student2=new Students();
    		student2.setStudentName("Anurag");
    		
    		student1.setCollege(college);
    		student2.setCollege(college);
    		
    		session.save(college);
    		session.save(student1);
    		session.save(student2);
    		
    		transaction.commit();
    	}	  
    	catch(SQLGrammarException sqlGrammarException)
    	{
    		sqlGrammarException.printStackTrace();
    	}
    	finally
    	{
    		session.close();
    	}
    }
}
