package com.oath;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{
	Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);
	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("My User details service class");
		User user= repo.findByUsername(username);
		if (user==null)
			throw new UsernameNotFoundException("user 404");
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return new UserPrincipal(user);
	}

}
