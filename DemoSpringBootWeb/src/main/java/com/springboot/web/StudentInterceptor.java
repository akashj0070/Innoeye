package com.springboot.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class StudentInterceptor implements HandlerInterceptor {
	Logger logger = LoggerFactory.getLogger(StudentInterceptor.class);
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
      throws Exception {
      logger.info("Pre Handle method is Calling");
     
      return true;
   }
   public void postHandle(HttpServletRequest request, HttpServletResponse response, 
      Object handler, ModelAndView modelAndView) throws Exception {
      
     logger.info("Post Handle method is Calling");
   }
   public void afterCompletion
      (HttpServletRequest request, HttpServletResponse response, Object 
      handler, Exception exception) throws Exception {
	  logger.info("Request and Response is completed");
   }
}
