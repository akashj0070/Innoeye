package com.scheduling;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@SuppressWarnings("unused")
@EnableScheduling
@SpringBootApplication
@Controller
public class SchedulingApplication {
	Logger  logger = LoggerFactory.getLogger(SchedulingApplication.class);
		
	@SuppressWarnings("deprecation")
		@Bean
	   public WebMvcConfigurer corsConfigurer() {
	      return new WebMvcConfigurerAdapter() {
	    	  @Override
	         public void addCorsMappings(CorsRegistry registry) {
	        	 //** in add maping and * in allowedOrigins
	            registry.addMapping("products").allowedOrigins("http://localhost:1236");
	            logger.info("CORS is ready");
	         }
	      };
	   }
//	@Scheduled(fixedRate=1000)
//	   public void cronJobSch() {
//	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//	      Date now = new Date(0);
//	      String strDate = sdf.format(now);
//	      System.out.println("Java cron job expression:: " + strDate);
//	   }
//	
//	@Scheduled(fixedDelay = 1000, initialDelay = 1000)
//	public void fixedDelaySch() {
//		System.out.println("fixed Delay");
//	}
	
	 @RequestMapping("locale")
	   public String locale() {
	      return "locale";
	   }
	 
	 

	public static void main(String[] args) {
		SpringApplication.run(SchedulingApplication.class, args);
		SchedulingApplication schedulingApplication = new SchedulingApplication();
		//schedulingApplication.cronJobSch();
		//schedulingApplication.fixedDelaySch();
	}

}
