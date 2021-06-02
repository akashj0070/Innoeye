package com.springcore.JDBC;



import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
public class StudentDaoImplement implements StudentDao{
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		String insertQuery="insert into student(id,name,city) values(?,?,?)";
		int result = this.jdbcTemplate.update(insertQuery,student.getId(), student.getName(), student.getCity());
		return result;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int update(Student student) {
		String updateQuery="update student set name=? where id=?";
		int result= this.jdbcTemplate.update(updateQuery,student.getName(),student.getId());		
		return result;
	}

	public int delete(Student student) {
		String deleteQuery="delete from student where id=?";
		int result=this.jdbcTemplate.update(deleteQuery,student.getId());
		return result;
	}

	public List<Student> listStudents() {
	      String SQL = "select * from student ";
	      List <Student> studentMarks = jdbcTemplate.query(SQL,new StudentMapper());
		return studentMarks;
	}

		
}
