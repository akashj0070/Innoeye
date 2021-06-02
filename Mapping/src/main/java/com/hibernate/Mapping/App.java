package com.hibernate.Mapping;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App 
{	 
//	 static Session sessionObj;
//	    static SessionFactory sessionFactoryObj;
//	 
//	   
//	public void Implementation()
//	{
//		 Configuration configObj = new Configuration();
//	        configObj.configure("hibernate.cfg.xml");
//	 
//	        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
//	        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
//	 
//	        // Creating Hibernate SessionFactory Instance
//	        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
//	       
//	        sessionObj = sessionFactoryObj.openSession();
//	        sessionObj.beginTransaction();
//	        
//	        Books bookObj= new Books();
//	        bookObj.setDescription("Data Persistence");
//	        bookObj.setPublish( new Date());
//	        bookObj.setAuthor( new Author("Author1","author1@mail.com"));
//	        sessionObj.save(bookObj);
//	        
//	        sessionObj.getTransaction().commit();
//	}
	    static Session sessionObj;
	    static SessionFactory sessionFactoryObj;
	 
	    private static SessionFactory buildSessionFactory() {
	        // Creating Configuration Instance & Passing Hibernate Configuration File
	        Configuration configObj = new Configuration();
	        configObj.configure("hibernate.cfg.xml");
	 
	        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
	        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
	 
	        // Creating Hibernate SessionFactory Instance
	        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
	        return sessionFactoryObj;
	    }
	 
	    public static void main(String[] args) {
	        System.out.println(".......Hibernate One To One Mapping Example.......\n");
	        try {
	            sessionObj = buildSessionFactory().openSession();
	            sessionObj.beginTransaction();
	 
	            // Creating A Book Entity
	            Books bookObj = new Books();
	          
	            bookObj.setDescription("Simplified Data Persistence with Hibernate and JPA");
	            bookObj.setPublish(new Date());
	 
	            bookObj.setAuthor(new Author("Cameron Wallace McKenzie", "cameron.bckenzie@gmail.com"));
	 
	            // Persisting (Or Saving) The Book Entity To The Database
	            sessionObj.saveOrUpdate(bookObj);           
	 
	            // Committing The Transactions To The Database
	            sessionObj.getTransaction().commit();
	 
	            System.out.println("\n.......Records Saved Successfully To The Database.......");
	        } catch(Exception sqlException) {
	            if(null != sessionObj.getTransaction()) {
	                System.out.println("\n.......Transaction Is Being Rolled Back.......");
	                sessionObj.getTransaction().rollback();
	            }
	            sqlException.printStackTrace();
	        } finally {
	            if(sessionObj != null) {
	                sessionObj.close();
	            }
	        }
	    }
}
