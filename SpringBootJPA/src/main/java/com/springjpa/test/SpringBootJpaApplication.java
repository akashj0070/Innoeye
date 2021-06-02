package com.springjpa.test;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.orm.jpa.JpaSystemException;

import com.springjpa.test.dao.UserRepo;
import com.springjpa.test.entities.User;
@SpringBootApplication
public class SpringBootJpaApplication {
	org.slf4j.Logger logger = LoggerFactory.getLogger(SpringBootJpaApplication.class);
	
	
	public void SpringCrudOperations(){
		try {
		logger.info("Spring Crud operation application started");
		ApplicationContext context=SpringApplication.run(SpringBootJpaApplication.class);
		UserRepo userRepo = context.getBean(UserRepo.class);
		User user=new User();
		user.setName("Akash");
		user.setCity("Indore");
		userRepo.save(user);
		System.out.println(user);
		
		
		//Check if user exists or not
		Boolean result= userRepo.existsById(2);
		System.out.println("Exists or not "+result);
		
		
		//Print all elements using findAll 
		  Iterable<User> iterator = userRepo.findAll();
		  for(User itr:iterator)
		  {
			  System.out.println(itr);
		  }
		  
		 //Number of Users in table
		  Long count =userRepo.count();
		  System.out.println("No. of User "+count);

		//Findbyid
		  Optional<User> optional = userRepo.findById(5);
		  System.out.println(optional);
		
		//  delete
//		  logger.info("Deleting Current saved User");
//		  userRepo.delete(user);
		 
		//Delete by id
		 userRepo.deleteById(user.getId());
	}
		catch(IllegalArgumentException illegalArgumentException)
		{
			logger.error("Error is " +illegalArgumentException);
		}
		catch(IllegalStateException illegalStateException)
		{
			logger.error("Error is "+illegalStateException);
		}
		catch(JpaSystemException jpaSystemException)
		{
			logger.error("Error is "+ jpaSystemException);
		}
		catch(JpaObjectRetrievalFailureException jpaObjectRetrievalFailureException)
		{
			logger.error("Error is "+jpaObjectRetrievalFailureException);
		}
	}
	
	public static void main(String[] args) 
	{
		SpringBootJpaApplication springBootJpaApplicationObject=new SpringBootJpaApplication();
		springBootJpaApplicationObject.SpringCrudOperations();
	}

}
