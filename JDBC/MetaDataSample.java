import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaDataSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url="jdbc:mysql://localhost:3306/ctsdata";
		String user = "root";
		String password = "MySQL_@123456";
		Statement stmt;
		ResultSet rs;
		Connection con;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con  = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from employee");
			ResultSetMetaData rsmd = rs.getMetaData();
			
			String tableName =  rsmd.getTableName(1);
			System.out.println("The Table associated with ResultSet is "+tableName);
			int columnCount = rsmd.getColumnCount();
			System.out.println("The No of columns the table has :"+columnCount);
			
			for(int i=1;i<columnCount;i++)
			{
				System.out.println("Column Name :"+rsmd.getColumnName(i)+"Column Type :"+rsmd.getColumnType(i)+"Column Label :"+rsmd.getColumnLabel(i)+"Column TypeName :"+rsmd.getColumnTypeName(i));
			}
			
			DatabaseMetaData dbmd = 	con.getMetaData();
			
			
			
		
			System.out.println("The Database Name :"+dbmd.getDatabaseProductName());
			System.out.println("The Database Version  :"+dbmd.getDatabaseProductVersion());
			System.out.println("The Database Major Version :"+dbmd.getDatabaseMajorVersion());
			System.out.println("The Database Minor Version :"+dbmd.getDatabaseMinorVersion());
			System.out.println("The Driver Name :"+dbmd.getDriverName());
			System.out.println("The Driver Major Version :"+dbmd.getDriverMajorVersion());
			System.out.println("The Driver MInor Version :"+dbmd.getDriverMinorVersion());
			
			
			
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
