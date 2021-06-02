import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;

public class StudentDao {
	static Connection con=null;
	static Statement st;
	
	
	static {
		 //System.out.println("Check1");
		 try {
		String url="jdbc:mysql://localhost:3306/employee";
		String uname="sammy";
		String pass="Pass@1234";
		
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,uname,pass);
			} 
			
			catch (ClassNotFoundException | SQLException classNotFoundException) 
			{
				//System.out.println("class not found");
				classNotFoundException.printStackTrace();
			}
	 	}
			
			public void insert(String name , String roll_num) throws IOException, SQLException
			{
			//System.out.println("Check3.1");
				
			try {
			String query1 = "insert into MVCdemo(Name, RollNo) values(?,?)";
			PreparedStatement presmt=con.prepareStatement(query1);
			presmt.setString(1,name);
			presmt.setString(2,roll_num);
			presmt.executeUpdate();
				}
				catch(SQLException sqlException)
				{
					sqlException.printStackTrace();
				}
//				catch(SQLTimeoutException sqlTimeoutException)
//				{
//					sqlTimeoutException.printStackTrace();
//				}
			}
			
			public ResultSet getStudents() throws SQLException
			{				
			try
			{
			Statement st = con.createStatement();
			ResultSet rs = null;
			rs = st.executeQuery("select * from MVCdemo");
			return rs;
			}
			catch(SQLTimeoutException sqlTimeoutException)
			{
				sqlTimeoutException.printStackTrace();
			}
			catch(SQLException sqlException)
			{
				sqlException.printStackTrace();
			}
			return null;
			}
			
		}


