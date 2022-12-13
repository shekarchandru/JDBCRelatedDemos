import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PrcedureWithParCaller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan1 = new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/ctsdata";
		String user = "root";
		String password = "MySQL_@123456";
		CallableStatement cstmt;
		ResultSet rs;
		String strId="";
		Connection con;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con  = DriverManager.getConnection(url, user, password);
			cstmt = con.prepareCall("call ctsProcJ2(?)");
			System.out.println("PLease Enter The ID of the Employee You WIsh to See thru Procedure");
			strId = scan1.next();
			cstmt.setString(1, strId);
			rs = cstmt.executeQuery();
			
			rs.next();
			System.out.println("The Record returned by the Procedure is ...");
			System.out.println("Employee Id :"+rs.getString(1)+"  Name :"+rs.getString(2)+"  Salary :"+rs.getInt(5));
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
		catch(SQLException sqfe)
		{
			sqfe.printStackTrace();
		}
	}

}
