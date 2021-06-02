package com.springboot.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Servlet Filter implementation class FirstFilter
 */
@WebFilter("/studentlist")
@Component
public class FirstFilter implements Filter {
	org.slf4j.Logger logger = LoggerFactory.getLogger(DemoSpringBootWebApplication.class);
	static PrintWriter outp;
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.info("filter studentList called");
		 outp=response.getWriter();
		response.setContentType("text/html");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String id = httpServletRequest.getParameter("id");
		if(id==null)
		{ chain.doFilter(request, response);}
		
		else {
		com.springboot.web.StudentRepo repo= com.springboot.web.DemoSpringBootWebApplication.context.getBean(StudentRepo.class);
		Integer id2= Integer.parseInt(id);
		Boolean re= repo.existsById(id2);
			if (re)
			{
				chain.doFilter(request, response);
			}
			else
			{
				System.out.println("Studetn does not exists please enter a valid student id ");
				outp.println("<body style=\"text-align:center;\">Invalid student id entered, go back and enter a valid id\n" + 
						"<form action=\"/\"> \n" + 
						"<input type=\"Submit\" style=\"text-align:center;\">\n" + 
						"</form>\n" + 
						"</body>");
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
