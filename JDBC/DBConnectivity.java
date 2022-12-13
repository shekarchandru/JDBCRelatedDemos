import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ctsdata";
			String user = "root";
			String password = "MySQL_@123456";
			Connection con = DriverManager.getConnection(url,user,password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Customers");
			System.out.println("The Customer Details from DB are.................");
			System.out.println("CustomerId       CustomerName      CustomerAddress CustomerPhone  CustomerEmail");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5) );
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
