package net.javaguides.hibernate.util;
import java.util.List;

import javax.transaction.Transaction;

import net.javaguides.hibernate.dao.StudentDao;
import net.javaguides.hibernate.model.Student;

public class App {
	static Transaction t;
	
	public static void main(String[] args) {
		/*StudentDao studentDao = new StudentDao();
		Student student= new Student("akash", "prajapat", "akash.prajapat@innoeye.com");
		studentDao.saveStudent(student);
		
		student.setFirstname("Ram");
		studentDao.updateStudent(student);
		Student student2= studstatic org.apache.log4j.Logger logger =  org.apache.log4j.Logger.getLogger(StoreData.class);
	static Scanner scan=new Scanner(System.in);
	static Integer Id;
	static String firstName;
	static String lastName;
	public staticentDao.getStudentById(student.getId());s
		
		List<Student> students = studentDao.getAllStudents();
		students.forEach(student1 -> System.out.println(student1.getId()));
		*/
		
		StudentDao studentDao = new StudentDao();
	
		Student student = new Student("Akash", "Prajapat", "akash.prajapat@innoeye.com");
		studentDao.saveStudent(student);
	    Student student1 =new  Student("Manoj", "Choudhary", "manoj.choudhary@innoeye.com");
		studentDao.saveStudent(student1);
		
		List<Student> students = studentDao.getAllStudents();
		students.forEach(s -> System.out.println(s.getId()+" "+s.getFirstName()+" "+
		s.getLastName()+" "+s.getEmail()));
	//	studentDao.deleteStudent(student.getFirstName());
	}

}
