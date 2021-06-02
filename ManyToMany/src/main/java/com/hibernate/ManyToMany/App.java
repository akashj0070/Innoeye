package com.hibernate.ManyToMany;

import java.util.ArrayList;
import java.util.ServiceConfigurationError;

import javax.naming.directory.InvalidAttributesException;
import javax.persistence.PersistenceException;

import org.apache.log4j.*;
import org.hibernate.*;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.exception.SQLGrammarException;  
     
public class App {   
	StandardServiceRegistry standardServiceRegistry;
	Metadata metadata;
	SessionFactory factory;
	Session session;
	Logger logger;
	Transaction transaction;
public void PersistData() {    
	try {     
	standardServiceRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();    
    metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();    
    factory=metadata.getSessionFactoryBuilder().build();    
    session=factory.openSession();    
    transaction=session.beginTransaction();      
          
    Answer asnwer1=new Answer();  
    asnwer1.setAnswername("Java is a programming language");  
    asnwer1.setPostedBy("Akash Prajapat");  
      
    Answer answer2=new Answer();  
    answer2.setAnswername("Java is a platform");  
    answer2.setPostedBy("Manoj Choudhary");  
     
    Question question1=new Question();  
    question1.setQname("What is Java?");  
    ArrayList<Answer> list=new ArrayList<Answer>();  
    list.add(asnwer1);  
    list.add(answer2);  
    question1.setAnswers(list);  
      
      
      Answer answer3=new Answer();    
        answer3.setAnswername("Servlet is an Interface");    
        answer3.setPostedBy("Anurag Jain");    
            
        Answer answer4=new Answer();    
        answer4.setAnswername("Servlet is an API");    
        answer4.setPostedBy("Aishwarya Pawar");    
      
    Question question2=new Question();  
    question2.setQname("What is Servlet?");  
    ArrayList<Answer> list2=new ArrayList<Answer>();  
    list2.add(answer3);  
    list2.add(answer4);  
    question2.setAnswers(list2);  
      
    session.persist(question1);    
    session.persist(question2);    
	
	
    transaction.commit(); }
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
    

public static void main(String[] args)
{
	App appObj=new App();
	appObj.PersistData();
}
}   