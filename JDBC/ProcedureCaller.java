import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcedureCaller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url="jdbc:mysql://localhost:3306/ctsdata";
		String user = "root";
		String password = "MySQL_@123456";
		CallableStatement cstmt;
		ResultSet rs;
		Connection con;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con  = DriverManager.getConnection(url, user, password);
			cstmt = con.prepareCall("call ctsProcJ1()");
			rs = cstmt.executeQuery();
			System.out.println("Records Returned by the Procedure are ....");
			while(rs.next())
			{
				System.out.println("Employee Id "+rs.getString(1)+" Employee Name:"+rs.getString(2)+" Employee Address :"+rs.getString(3)+"  Employee Salary :"+rs.getInt(5));
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
