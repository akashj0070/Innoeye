package com.filehandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@SpringBootApplication
public class FileHandlingSpringBootApplication {
	@Autowired	
	private FileUpload fileUpload;
	

	@RequestMapping(value="home")
	public String home()
	{	
		System.out.println("index page");
		return "home";
		
	}
	
//	@RequestMapping("upload")
//	public String index()
//	{	
//
//		return "index";
//		
//	}
		
//		@RequestMapping("uploading")
//		public ResponseEntity<String> uploadfile(@RequestParam("file") MultipartFile file)
//		{	
//		try {
//			if(file.isEmpty())
//			{
//				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//						.body("Request must contain a file");
//			}
//			
//			if(file.getContentType().equals("image/jpeg"))
//			{
//				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//						.body("only jpeg are allowed");	
//			}
//			
//			//File uploading code
//			//Req - Where to upload file on server
//			
//			Boolean f=fileUpload.uplpoad(file);
//			if(f)
//			{
//				return ResponseEntity.ok("File is successfully uploaded");
//				
//			}
//		}
//		
//		catch(Exception exception)
//		{
//			exception.printStackTrace();
//		}			
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some error pccured");
//					
//		}
		

public static void main(String[] args) {
	@SuppressWarnings("unused")
	FileHandlingSpringBootApplication fileHandlingSpringBootApplication =new FileHandlingSpringBootApplication();
	ApplicationContext context=SpringApplication.run(FileHandlingSpringBootApplication.class);
}	
}