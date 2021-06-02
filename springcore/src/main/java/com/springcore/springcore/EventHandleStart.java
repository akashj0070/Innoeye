package com.springcore.springcore;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class EventHandleStart implements ApplicationListener<ContextStartedEvent>{


	   public void onApplicationEvent(ContextStartedEvent event) {
	      System.out.println("ContextStartedEvent Received");
	   }
}

