import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBInsertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ctsdata";
			String user = "root";
			String password = "MySQL_@123456";
			Connection con = DriverManager.getConnection(url,user,password);
			String query1 = "insert into Customers values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query1);
			pstmt.setString(1, "C007");
			pstmt.setString(2, "Suman");
			pstmt.setString(3, "Indiranagar");
			pstmt.setString(4, "9829929922");
			pstmt.setString(5, "sum@gmail.com");
			pstmt.execute();
			System.out.println("Inserted Record Successfully...");
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
		catch(SQLException sqe)
		{
			sqe.printStackTrace();
		}
	}

}
