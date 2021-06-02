package com.oath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class OathByGoogleApplication {
	@RequestMapping("/")
	public String home()
	{	
		System.out.println("home called");
		return "home.jsp";
	}
	
	@RequestMapping("/index")
	public String index()
	{	
		System.out.println("home called from index");
		return "home.jsp";
	}
	public static void main(String[] args) {
		SpringApplication.run(OathByGoogleApplication.class, args);
	}

}
