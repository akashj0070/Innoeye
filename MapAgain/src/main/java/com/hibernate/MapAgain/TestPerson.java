package com.hibernate.MapAgain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.exception.SQLGrammarException;

public class TestPerson {
	

     SessionFactory factory ;
	 Metadata meta;
	 StandardServiceRegistry ssr;
	 Session session ;
	 Transaction transaction;
	 public void TestPersonImplement()

	 {		
	  try 
	 	{
		    ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		    System.out.println("check1");
		    meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	        factory = meta.getSessionFactoryBuilder().build();
	        session = factory.openSession();  
	    	transaction = session.beginTransaction(); 
	    	
	    	PersonDetail personDetail = new PersonDetail();
	    	personDetail.setZipCode("1234");
	    	personDetail.setIncome(30000);   
	    	personDetail.setJob("Engineer");
	    	
	    	Person person = new Person();
	    	person.setPersonName("Akash");
	    	person.setPersonDetail(personDetail);
	    	System.out.println(person.getPersonDetail().getJob());
	    	session.save(person);
	    	transaction.commit();
	 }
	 catch(SQLGrammarException sqlGrammarException) {
		 sqlGrammarException.printStackTrace();
	 }
	 finally {
		 session.close();
		 
	 	}
	    	
	 }
	 
		 public static void main(String[] args)
		 {
			 TestPerson object=new TestPerson();
			 object.TestPersonImplement();
		 }

}


