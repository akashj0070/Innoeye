package com.springcore.JDBC;

import java.util.List;

    public interface StudentDao {
	public  List<Student> listStudents();
	public int insert(Student student);
	public int update(Student student);
	public int delete(Student student);
}
