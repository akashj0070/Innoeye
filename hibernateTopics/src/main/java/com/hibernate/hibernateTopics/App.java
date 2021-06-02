package com.hibernate.hibernateTopics;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.naming.directory.InvalidAttributesException;
import javax.net.ssl.SSLException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.SQLGrammarException;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.config.CacheConfigError;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App 
{		
	  SessionFactory factory ;
	  Metadata meta;
	  StandardServiceRegistry standardServiceRegistry;
	  Session session ;
	  Logger logger;
	  Transaction transaction;
	public void insertMethod()
	{	
		
		try {
			Students student=null;
			logger = Logger.getLogger(App.class);
			logger.info("Starting standard service Registry");
			 standardServiceRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();    
		     meta=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();    
		     factory=meta.getSessionFactoryBuilder().build();
		    logger.info("creating session");
		    session = factory.openSession();  
		    transaction = session.beginTransaction();  
//    	Random random=new Random();
//    	
//    	for(int iterations=1;iterations<=15;iterations++)
//    	{
//    		Students studebt1=new Students();
//    		studebt1.setStud_id(iterations);
//    		studebt1.setStud_name("Name"+iterations);
//    		studebt1.setStud_subject("Subject"+random.nextInt(4));
//    		session.save(studebt1);
//    	}
//    	transaction.commit();
    	
//      	 Students student2=new Students();
//      
//         Updating values
//         Query query=session.createQuery("update Students set name=:name where id=:id");
//         query.setParameter("name","Akash Prajapat");  
//         query.setParameter("id",13);
//         int status=query.executeUpdate();  
//         System.out.println(status); 
      
         
       //  Example of HQL delete query
//         Query query=session.createQuery("delete from Students where id=8");  
//         query.executeUpdate();
        
		    //Creating Sql Query 
         //Aggregate Functions
//         Query query2=session.createQuery("select sum(stud_id) from Students");  
//         List<Integer> list=query2.list(); 
//         System.out.println(list.get(0));  
	         
//	         TypedQuery<Integer> query3=session.createSQLQuery("select max(stud_id) from students");  
//	         List<Integer> list= query3.getResultList(); 
//	       System.out.println(list.get(0));
		    
//	       Query query4=session.createQuery("select min(stud_id) from Students");  
//	       List<Integer> list=query4.list(); 
//	     System.out.println(list.get(0));
//	     
//	     Query query5=session.createQuery("select avg(stud_id) from Students");  
//	     List<Integer> list=query5.list(); 
//	     System.out.println(list.get(0));
//    
//	     Query query6=session.createSQLQuery("select count(stud_id) from Students");  
//	     List<Integer> list=query6.list(); 
//	     System.out.println(list.get(0));
       
         
         //Group by in HQL
     	//     Query query= session.createQuery("from Students group by Name ");
//       
//            List<Students> list1= query.getResultList();
//
//            for(Students stud1:list1)
//            {
//            	System.out.println(((Students) stud1).getStud_id()+" "+((Students) stud1).getStud_name()+" "+((Students) stud1).getStud_subject());
//
//            }
         
//	     Query query7=session.createQuery(" from Students order by id DESC");  
//	     List<Students> list=query7.getResultList(); 
//	     for (Students studentiterator:list)
//	     {
//	    	 System.out.println(studentiterator.getStud_name());
//	     }
//	     session.getTransaction().commit();
//	     session.close();
	     
         //Fetching table data
         //Named Query
//         TypedQuery query = session.getNamedQuery("findbyname");    
//         query.setParameter("name","Name14"); 
//
//       List<Students> list1= query.getResultList();
//
//       for(Students stud1:list1)
//       {
//       	System.out.println(((Students) stud1).getStud_id()+" "+((Students) stud1).getStud_name()+" "+((Students) stud1).getStud_subject());
//
//       }
//        
		    
		//Caching Example
//        student=(Students) session.get(Students.class, 13);
//        System.out.println(student.getStud_name());
//    	
//        session.getTransaction().commit();
//        
//        Session session1 = factory.openSession();  
//	    transaction = session1.beginTransaction();
//	    
//        student=(Students) session1.get(Students.class, 13);
//        System.out.println(student.getStud_name());
//    	    	
    	
    	
    	
	    
//         TypedQuery<Students> query=session.createNativeQuery("select stud_id, Name,Subject from students", Students.class);
//         List<Students> list2= query.getResultList();
//         for (Students studentiterator :list2) {
//        	  System.out.println(studentiterator.getStud_name());
//		}
		    
		    
		    //HCQL example
//		    Criteria criteria=  session.createCriteria(Students.class);
//		    criteria.setFirstResult(7);
//		    criteria.setMaxResults(14);
//		    criteria.add(Restrictions.gt("stud_id",9));
//		    criteria.addOrder(Order.desc("stud_id"));  
//		    criteria.setProjection(Projections.property("stud_name"));  
//
//		    List<Students> clist = criteria.list();
//		    for(Students st:clist)
//		    {
//		    	System.out.println(st.getStud_name());
//		    }
		    
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
		catch (Exception exception) {
				exception.printStackTrace();
		}
	
	}

	public static void main( String[] args )
    {
        App appObj=new App();
        appObj.insertMethod();
    }
}
