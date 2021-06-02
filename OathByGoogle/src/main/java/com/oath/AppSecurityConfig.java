package com.oath;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	org.slf4j.Logger logger = LoggerFactory.getLogger(AppSecurityConfig.class);
	@Autowired
	private UserDetailsService UserDetailsService;
		
	@SuppressWarnings("deprecation")
	@Bean
	public AuthenticationProvider authProvider()
	{	
		logger.info("Authentication provider class");
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(UserDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		System.out.println(provider);
		return provider;
	}
	
	/*
	@Bean
	@Override
	protected UserDetailsService userDetailsService()
	{
		List <UserDetails> users = new ArrayList();
		users.add(User.withDefaultPasswordEncoder().username("akash").password("1234").roles("USER").build());
		return new InMemoryUserDetailsManager();
		
	}
	*/

}
