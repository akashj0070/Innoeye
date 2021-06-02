package springwebmvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringController {
		
		@RequestMapping(value="/index", method = RequestMethod.GET)
		public String home()
		{	
			System.out.println("This is home URL");
			return "index";
		}
		
		@RequestMapping("/")
		public String about()
		{
			System.out.println("this is about caontroller");
			return "about";
		}
		
}
