import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class SampleProcCallParInOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//MyProc4
		Connection con;
		String url="jdbc:mysql://localhost:3306/ctsdata";
		String user="root";
		String password="MySQL_@123456";//MySQL_@123456
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			CallableStatement cstmt = con.prepareCall("call MyProc4(?,?,?)");
			//1st is Input and other 2 are output parameters
			cstmt.setString(1, "E003");
			
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.executeUpdate();
			
			int empSalary = cstmt.getInt(2);
			String empAddress = cstmt.getString(3);
			System.out.println("The Salary & Address for the Employee with Id E003 is");
			System.out.println("The Employee Salary is "+empSalary);
			System.out.println("The Employee Address is "+empAddress);
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
