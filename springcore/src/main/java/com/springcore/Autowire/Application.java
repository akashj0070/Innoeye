package com.springcore.Autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	
	public void Autowiring()
	{
		ApplicationContext context =new ClassPathXmlApplicationContext("com/springcore/Autowire/AutoConfig.xml");
		Employee employee=context.getBean("employee",Employee.class);
		System.out.println(employee);
	}
	public static void main(String[] args) {
		Application applicationObj=new Application();
		applicationObj.Autowiring();
	}

}
