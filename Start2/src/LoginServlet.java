import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String rs="<button>Clik here this was Get request</button>";
//		resp.getWriter().write(rs);
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rs="<button>Clik here this was POST request</button>";
		resp.getWriter().write(rs);
	}
	/*
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)req;
		String method= request.getMethod();
		
		System.out.println("Login Servlet Called");
		String resp=" ";
	    if(method.equals("POST"))
	    {
	    	resp="<button>Clik here this was POST request</button>";
	    }
	    else if(method.equals("GET"))
	    {
	    	resp="<button>This was get request</button>";
	    }
		System.out.println(req instanceof HttpServletRequest);
		PrintWriter writer =res.getWriter();
		//writer.write("Hello this is from login servlet");
		writer.write(resp);
		writer.flush();
		writer.close();
		*/
	}



