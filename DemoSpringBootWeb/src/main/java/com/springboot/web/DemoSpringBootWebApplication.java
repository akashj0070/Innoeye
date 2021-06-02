package com.springboot.web;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
@SpringBootApplication
public class DemoSpringBootWebApplication {
	
	JdbcTemplate jdbcTemplate;
	static ApplicationContext context;
	org.slf4j.Logger logger = LoggerFactory.getLogger(DemoSpringBootWebApplication.class);
//	@Autowired
//	RestTemplate restTemplate;
//		@RequestMapping("home")
	//Instead of using HttpServletRequest-
//		public ModelAndView home(StudentModel model)
//		{ 	
//			ModelAndView mv= new ModelAndView();
//			mv.addObject("obj",model);
//			mv.setViewName("home");
//			
//			logger.info("home funcition called");
//			
////			session.setAttribute("name", name);
//			
//			System.out.println("This is home page");
//			return mv;
//		} 
//		
	
//	@RequestMapping(value = "download") 
//	public ResponseEntity<InputStreamResource> downloadFile() throws IOException  {
//	   String filename = "/home/ist/Pictures/img.jpeg";
//	   File file = new File(filename);
//	   InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//	   HttpHeaders headers = new HttpHeaders();
//	      
//	   headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
//	   headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
//	   headers.add("Pragma", "no-cache");
//	   headers.add("Expires", "0");
//	      
//	   ResponseEntity<InputStreamResource> 
//	   responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(
//	      MediaType.parseMediaType("application/txt")).body(resource);
//	      
//	   return responseEntity;
//	}
//		
		@RequestMapping("/")
		//		@CrossOrigin(origins = "http://localhost:8087")
		public java.lang.String home()
		{	
//			logger.info("Home page");
			return "home";
		}
					
		@RequestMapping("addStudent")
		public java.lang.String addStudent(StudentModel student)
		{	try {
			logger.info("Adding student data in home page");
			ApplicationContext contestaddStudent;
			System.out.println("Student is "+student);
			System.out.println("Marks are "+student.getMarks());
			contestaddStudent=DemoSpringBootWebApplication.context;			
			StudentRepo studentRepo =contestaddStudent.getBean(StudentRepo.class);
			StudentModel model=new StudentModel();
			model.getName();
			model.getMarks();
			studentRepo.save(student);
						
		}
		catch(IllegalArgumentException illegalArgumentException)
		{
			logger.error("Error is"+illegalArgumentException);
		}
		catch(IllegalStateException illegalStateException)
		{
			logger.error("Error is "+illegalStateException);
		}
		catch(Exception exception)
		{
			logger.error("Exception is " + exception);
		}
			return "home";
		}
			
		@RequestMapping(value="studentlist")
		public ModelAndView getStudent(@RequestParam int id)
		{   ModelAndView mv = null;
			try {
			ApplicationContext contestaddStudent;
			contestaddStudent=DemoSpringBootWebApplication.context;	
			StudentRepo studentRepo =contestaddStudent.getBean(StudentRepo.class);
			mv = new ModelAndView("studentlist"); 
			StudentModel model= studentRepo.findById(id).orElse(new StudentModel());
			Integer marktoupdate=model.getMarks();
			model.setMarks(marktoupdate*20);
//			Iterable<StudentModel> model= studentRepo.findAll();
			mv.addObject(model);
			System.out.println("mv "+mv);
//			studentRepo.deleteById(id+1);
			return mv;
			}
		catch(Exception exception)
					{
			logger.error("Error is "+exception);
		}
			return mv;
		}
		
		public static void main(String[] args) {
			
			 context=SpringApplication.run(DemoSpringBootWebApplication.class);
		//	 DemoSpringBootWebApplication demoSpringBootWebApplicationObject= new DemoSpringBootWebApplication();
			
		}
	}




//	//Upload
//	@RequestMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
//	      File convertFile = new File("/home/ist/snap"+file.getOriginalFilename());
//	      convertFile.createNewFile();
//	      FileOutputStream fout = new FileOutputStream(convertFile);
//	      fout.write(file.getBytes());
//	      fout.close();
//	      return "File is upload successfully";
//	  }
//	//Download
