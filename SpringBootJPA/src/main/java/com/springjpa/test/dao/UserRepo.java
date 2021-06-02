package com.springjpa.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.springjpa.test.entities.User;

public interface UserRepo extends CrudRepository<User,Integer> {
	
}
