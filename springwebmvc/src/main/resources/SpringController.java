
package springwebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringController {
		
		@RequestMapping("/home")
		public String home()
		{	
			System.out.println("This is home URL");
			return "index";
		}
		
		@RequestMapping("/about")
		public String about()
		{
			System.out.println("this is about caontroller");
			return "about";
		}
		