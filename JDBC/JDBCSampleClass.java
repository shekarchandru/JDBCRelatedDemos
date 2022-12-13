import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSampleClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/ctsdata";
		String user = "root";
		String password ="MySQL_@123456";
		Connection con;
		Statement stmt ;
		ResultSet rs;
		// http://www.rediff.com/login
		// Load The Driver
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		// Establish Connection
			con  = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from employee");
			while(rs.next())
			{
				System.out.println("Employee Id :"+rs.getString(1)+"Employee Name :"+rs.getString(2));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException sqe)
		{
			sqe.printStackTrace();
		}

	}

}
