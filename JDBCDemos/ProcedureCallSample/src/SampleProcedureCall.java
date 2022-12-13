import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SampleProcedureCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con;
		String url="jdbc:mysql://localhost:3306/ctsdata";
		String user="root";
		String password="MySQL_@123456";//MySQL_@123456
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		/*	CallableStatement cstmt = con.prepareCall("{call MyProc1}") also is OK */
			CallableStatement cstmt = con.prepareCall("call MyProc1");
			ResultSet rs = cstmt.executeQuery();
			System.out.println("Employee Details are....");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"    "+rs.getString(2)+"      "+rs.getString(3)+"     "+rs.getString(4)+"    "+rs.getInt(5)+"    "+rs.getFloat(6));
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
