import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FakeDataServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer=resp.getWriter();
		Random random=new Random();
		resp.setContentType("text/html");
		writer.write("<ol>");
		for(int i=0;i<20;i++) {
		
		String cardNumber=(random.nextFloat()+"").substring(2,6)+"-"+
				(random.nextFloat()+"").substring(2,6)+"-"+
				(random.nextFloat()+"").substring(2,6)+"-"+
				(random.nextFloat()+"").substring(2,6);
		writer.write("<li>"+cardNumber+"</li>");
		}
		writer.write("</ol>");
		writer.flush();
		writer.close();
	}

}
