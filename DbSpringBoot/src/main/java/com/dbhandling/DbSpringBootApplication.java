package com.dbhandling;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ControllerAdvice
public class DbSpringBootApplication {
	Logger logger = LoggerFactory.getLogger(DbSpringBootApplication.class);
	@Autowired
	ProductRepository repo;
	
	 @PostMapping(path="/add") // Map ONLY POST Requests
	  public @ResponseBody String addNewUser (@RequestParam String name) {
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request
		logger.info("Post mapping... adding user");
	    ProductModel productModel = new ProductModel();
	    productModel.setProd_name(name);
	    repo.save(productModel);
	    logger.info("Post mapping...user added");
	    return "Saved";
	  }
	
	
	@GetMapping(value="/all")
	public @ResponseBody Iterable<ProductModel> getAll()
	{	
		 logger.info("Get mapping... Retrieving all users");
		 return repo.findAll();
		
	}

	@PutMapping(value="/update" )//update?id=1&name=manoj
	public @ResponseBody String updateUser(@RequestParam Integer id, @RequestParam String name )
	{
		logger.info("Put Mapping, Updating user");
		try {
		ProductModel proModel= repo.findById(id).get();
		proModel.setProd_name(name);
		repo.save(proModel);
		logger.info("User Updated");
		return "updated";}
		catch(NoSuchElementException noSuchElementException)
		{
			logger.error("User not present "+noSuchElementException);
		}
		return  "No such user";
	}
	
	@DeleteMapping(value="/delete")
	public @ResponseBody String deleteUser(@RequestParam Integer id)
	{	try {
		logger.info("Delete Mapping, Deleting user");
		repo.deleteById(id);
		return "deleted";}
		
		catch(NoSuchElementException noSuchElementException)
		{
			logger.error("User not present "+noSuchElementException);
		}
	return "No such user";
	}

	public static void main(String[] args) {
		SpringApplication.run(DbSpringBootApplication.class);
		
	}

}
