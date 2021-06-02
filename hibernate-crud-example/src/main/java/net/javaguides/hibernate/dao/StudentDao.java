package net.javaguides.hibernate.dao;

import java.util.List;

//import org.hibernate.Transaction;
import net.javaguides.hibernate.model.Student;
import net.javaguides.hibernate.util.HibernateUtil;

public class StudentDao {
	//savesStudent
	//getAllStudents
	//getStudentByid
	//updateStudent
	//DeleteStudent
	public void saveStudent(Student student)
	{org.hibernate.Transaction transaction = null;
	try  {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		// start a transaction
		transaction = session.beginTransaction();
		// save the student object
		session.save(student);
		// commit transaction
		transaction.commit();
	} catch (Exception e) {
		if (transaction != null) {
			transaction.rollback();
		}
		e.printStackTrace();
	}

	}
	
	public void updateStudent(Student student)
	{org.hibernate.Transaction transaction = null;
	try  {
		// start a transaction
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		// save the student object
		session.saveOrUpdate(student);
		// commit transaction
		transaction.commit();
	} catch (Exception e) {
		if (transaction != null) {
			transaction.rollback();
		}
		e.printStackTrace();
	}

	}
	
	public Student getStudentById(long id)
	{org.hibernate.Transaction transaction = null;
	Student student=null;
	try  {
		// start a transaction
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		// save the student object
		student = session.get(Student.class, id);
		// commit transaction
		transaction.commit();
	} catch (Exception e) {
		if (transaction != null) {
			transaction.rollback();
		}
		//return student;
	}
	return student;

	}

	public List<Student> getAllStudents()
	{org.hibernate.Transaction transaction = null;
	List<Student> students =null;
	try  {
		// start a transaction
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();		
		transaction = session.beginTransaction();
		// save the student object
		students = session.createQuery("from Student").list();
				// commit transaction
		transaction.commit();
	} catch (Exception e) {
		if (transaction != null) {
			transaction.rollback();
		}
		
	}
	return students;
	}
	
	

	public void deleteStudent(String name)
	{org.hibernate.Transaction transaction = null;
	Student student=null;
	try  {
		// start a transaction
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		// save the student object
		student =session.get(Student.class, name);
		session.delete(student);
		// commit transaction
		transaction.commit();
	} catch (Exception e) {
		if (transaction != null) {
			transaction.rollback();
		}
		
	}
	}
	

}

