import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import java.sql.*;

public class Add extends HttpServlet{
	

	HttpServletResponse resp;
	Integer num1 = null,num2=null,num3=null;
	String Name=null;
	Statement st;
	



	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		System.out.println("check1");
		this.resp=resp;
		PrintWriter outp=resp.getWriter();
		resp.setContentType("text/html");
			
		try {
			Name=req.getParameter("Name");
			String temp=req.getParameter("mark1");
//			if(temp.contentEquals("a-z Z-A"))
//			{
//				outp.println("You should write only integer here");
//			}
		num1= Integer.parseInt(temp);
		num2= Integer.parseInt(req.getParameter("mark2"));
		num3= Integer.parseInt(req.getParameter("mark3"));
		
		Integer sum=num1+num2+num3;
		Float per=(float) (sum/3);		
		//outp.println("document.getElementById(\"answer\").value= c;");
		outp.println("Percentage of marks "+per+"%<br>");
		}
		catch (NumberFormatException numberFormatException)
		{
			outp.println("Invalid data format "+ numberFormatException);
		}
		
//		catch(SQLTimeoutException sQLTimeoutException)
//		{
//			sQLTimeoutException.printStackTrace();
//		}
		try {
//			System.out.println("check 1.5");
			DatabaseConnectivity();
//			System.out.println("check2");
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void DatabaseConnectivity() throws IOException, SQLException
	{
		
		//JDBC

	//  1. import
	//  2. load and register
	//  3. establish the connection
	//  4. create the statement
	//  5. execute the  query
	//  6. process the query
	// 7. close 
	 
		
		String url="jdbc:mysql://localhost:3306/employee";
		String uname="sammy";
		String pass="Pass@1234";
		
//		System.out.println("check3");
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
			} 
			
			catch (ClassNotFoundException classNotFoundException) 
			{
				// TODO Auto-generated catch block
				System.out.println("class not found");
				classNotFoundException.printStackTrace();
			}
			Connection con = null;
		
		try {
//			System.out.println("check4");
			PrintWriter outp =resp.getWriter();
			con = DriverManager.getConnection(url,uname,pass);
			Statement st = con.createStatement();
			String query = "insert into model(name,mark1,mark2,mark3) values(?,?,?,?)";
			
			//st.executeUpdate("insert into model (name,mark1,mark2,mark3) "
				//	+ "values(manoj,"+num1+","+num2+","+num3+")");
			
			PreparedStatement presmt=con.prepareStatement(query);
			presmt.setString(1,Name);
			presmt.setInt(2, num1);
			presmt.setInt(3, num2);
			presmt.setInt(4, num3);
			presmt.executeUpdate();
			
			ResultSet rs = null;
//			System.out.println("check5");
			rs = st.executeQuery("select * from model");
			
			outp.println("<table border=1>");
			while(rs.next()) 
			{
				
				System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getInt(4));	
				outp.println("<tr>"+"<td>"+rs.getString(1)+"<td>"+rs.getInt(2)+"<td>"+rs.getInt(3)+"<td>"+rs.getInt(4)+"<br>");
			}
			
			outp.println("</table>");
			System.out.println("check6");
		} 
		
		catch (SQLException sQLException) 
		{
			sQLException.printStackTrace(); 
		}
		finally
		{
			//st.close();
			con.close();
		}
	}
}

	
	
	


