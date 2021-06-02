import java.sql.*;
public class JDBc {
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{	
		String url="jdbc:mysql://localhost:3306/employee";
		String uname="sammy";
		String pass="Pass@1234";
		System.out.println("out");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,pass);
		Statement st=con.createStatement();
		//st.executeUpdate("alter table Employee modify COLUMN emp_phone int(14)");
		st.executeUpdate("insert into Employee values(9,'K',98721045)");
		st.executeUpdate("insert into Employee values(2,'Namy',9241087)");
		ResultSet rs=st.executeQuery("select * from Employee");
		
		while(rs.next()) {
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		
		
		}
		st.close();
		con.close();
	}

}
