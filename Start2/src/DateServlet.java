import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet{
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	resp.getWriter().write("Date Servlet\n");
	PrintWriter writer =resp.getWriter();
	Date date=new Date(); 
	writer.write("<h1>"+date+"</h1>");
	writer.flush();
	writer.close();
}
}
