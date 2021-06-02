package com.springcore.Autowire.Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	
	public void Autowiring()
	{
		ApplicationContext context =new ClassPathXmlApplicationContext("com/springcore/Autowire/Annotation/AutoConfig.xml");
		Employee employee=context.getBean("employee",Employee.class);
		System.out.println(employee);
		
		  //For Sterotype Annotaion
		  Address address=context.getBean("addressObj",Address.class);
		  System.out.println(address);
		 
	}
	
	public static void main(String[] args) {
		Application applicationObj=new Application();
		applicationObj.Autowiring();
	}

}
