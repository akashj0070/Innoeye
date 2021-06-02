package com.springcore.JDBC;

import java.util.List;
import java.util.Map;

import javax.sound.midi.Soundbank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


public class Application {
	
	private ApplicationContext context;
	private PlatformTransactionManager transactionManager;
 public void setTransactionManager(PlatformTransactionManager transactionManager) {
	      this.transactionManager = transactionManager;
	 }
	public void Autowiring()
	{
		
		TransactionDefinition def = new DefaultTransactionDefinition();
	      TransactionStatus status = transactionManager.getTransaction(def);
		 System.out.println("check2");
		try {
			System.out.println("Application started");
			System.out.println(def.getName());
		context = new ClassPathXmlApplicationContext("com/springcore/JDBC/config.xml");
		StudentDao studentDao =context.getBean("studentDao",StudentDao.class);
		
		
		
		
		
		  //Inserting into Table 
			/*
			 * Student student=new Student(); 
			 * student.setId(15); 
			 * student.setName("Mahesh");
			 * student.setCity("Dewas"); 
			 * int result =studentDao.insert(student);
			 * System.out.println("Student Added "+ result);
			 */
		 
		
		//Updating tables field name
		/*
		 * Student studentObj=new Student(); studentObj.setId(15);
		 * studentObj.setName("Anurag"); int result=studentDao.update(studentObj);
		 * System.out.println("Student updated"+result);
		 */
		 		
		
		//Delete from table students
		/* Student studentObj=new Student(); 
		 * studentObj.setId(11); 
		 * int result=studentDao.delete(studentObj);
		 * System.out.println("Student deleted"+result);
		 */
		
		//InsertQuery
		 JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
		  String insertQuery="insert into student(id,name,city) values(?,?,?)"; 
		template.update(insertQuery,12,"Ajay","Dewas");
		System.out.println("Successful");
		transactionManager.getTransaction(def);
		  
		  //Select Query
	     List<Student> studentdetails =studentDao.listStudents();
	     	  for (Student record : studentdetails) 
			  { System.out.print("ID : " +  record.getId() );
			  System.out.print("Name : " + record.getName() );
			  System.out.print("City :"+ record.getCity());
			  System.out.println();
			  }
			 			
				  transactionManager.commit(status);
				 		
		}
		catch (DataAccessException dataAccessException) {
	         System.out.println("Error in creating record, rolling back");
	         //transactionManager.rollback(status);
	         throw dataAccessException;
	      }
		catch(ClassCastException classCastException)
		{
			classCastException.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Application applicationObj=new Application();
		applicationObj.Autowiring();
	}

}
