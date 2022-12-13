import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.Scanner;

public class CallProcedureWithIpOpParam {

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
			cstmt = con.prepareCall("call ctsProcJ3(?,?,?,?)");
			System.out.println("PLease Enter The ID of the Employee You WIsh to See thru Procedure");
						strId = scan1.next();
			cstmt.setString(1, strId);
			
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.INTEGER);
			
			cstmt.executeUpdate();
			
			String empName = cstmt.getString(2);
			String empAddress = cstmt.getString(3);
			int empSalary = cstmt.getInt(4);
			
			System.out.println("The Employee Details returned for Employee Id "+strId+"are...");
			System.out.println("The Employee Name "+empName);
			System.out.println("The Employee Address "+empAddress);
			System.out.println("The Employee Salary Name "+empSalary);
			
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
