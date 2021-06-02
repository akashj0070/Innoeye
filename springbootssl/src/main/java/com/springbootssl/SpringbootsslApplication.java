package com.springbootssl;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootsslApplication {
	
	@GetMapping(value="/home")
	public String home()
	{
		return "Hello SSL";
	}
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringbootsslApplication.class, args);
	}

}
