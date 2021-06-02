import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoMVC extends HttpServlet{
	
	String name;
	String roll_num;
	StudentView modelobj=new StudentView();
	public void service(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		//this.resp=resp;
		try {
			StudentDao studentdao=new StudentDao();
			PrintWriter outp=resp.getWriter();
			resp.setContentType("text/html");
				
			name=req.getParameter("Name");
			roll_num= req.getParameter("roll_number");
			modelobj.setName(name);
			modelobj.setRollNo(roll_num);
				
			studentdao.insert(name, roll_num);
			
			ResultSet students = studentdao.getStudents();
			outp.println("<table border=1>");
			while(students.next()) 
			{				
				System.out.println(students.getString(1)+" "+students.getString(2));	
				outp.println("<tr>"+"<td>"+students.getString(1)+"<td>"+students.getString(2));
				
			}
			outp.println("</table>");
			}
			catch (IOException ioException){
					ioException.printStackTrace();
			}
			catch(SQLException sqlException)
			{
			sqlException.printStackTrace();
			}
		
		}
}

