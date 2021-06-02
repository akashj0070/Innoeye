package com.springboot.web;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<StudentModel, Integer> {

}
