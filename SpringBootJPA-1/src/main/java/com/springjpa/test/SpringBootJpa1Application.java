package com.springjpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class SpringBootJpa1Application {

	public static void main(String[] args) {
	
		SpringApplication.run(SpringBootJpa1Application.class, args);
	
	}	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
}
