import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SampleProcedureCallPar {

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
			CallableStatement cstmt = con.prepareCall("call MyProc5(?)");
			cstmt.setString(1, "E001");
			ResultSet rs = cstmt.executeQuery();
			rs.next();
			System.out.println("The Employee Details for Id "+rs.getString(1)+" are...");
			System.out.println(rs.getString(2)+"      "+rs.getString(3)+"     "+rs.getString(4)+"    "+rs.getInt(5)+"    "+rs.getFloat(6));

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
