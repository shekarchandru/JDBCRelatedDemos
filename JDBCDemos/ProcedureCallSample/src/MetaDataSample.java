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
		Connection con;
		String url="jdbc:mysql://localhost:3306/ctsdata";
		String user="root";
		String password="MySQL_@123456";//MySQL_@123456
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Employee");
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("-------------------------RESULTSET METADATA-------------------------");
			System.out.println("The Table Name is "+rsmd.getTableName(1));
			
			int columnsNo = rsmd.getColumnCount();
			System.out.println("The Number of Columns Present is "+columnsNo);
		
			for(int i=1;i<columnsNo;i++)
			{
				System.out.println("The Column Name is "+rsmd.getColumnName(i)+" And its Corresponding Type is "
			+rsmd.getColumnType(i)+" Column Name "+rsmd.getColumnTypeName(i));
			}
			System.out.println("-------------------------DATABASE METADATA-------------------------");
			DatabaseMetaData dbmd = con.getMetaData();
		
			System.out.println("The Driver Being used    :"+dbmd.getDriverName());
			System.out.println("The Driver Major Version  :"+dbmd.getDriverMajorVersion());
			System.out.println("The Driver Minor Version  :"+dbmd.getDriverMinorVersion());
			System.out.println("The Database Name "+dbmd.getDatabaseProductName());
			System.out.println("The DB Product Version "+dbmd.getDatabaseProductVersion());
			String[] tables= {"view"};
			System.out.println("------------------------DATABASE METADATA: TABLE DATA-------------------------");
			ResultSet rs1 =dbmd.getTables(null,null, null, tables);
			while(rs1.next())
			{
				System.out.println("Table "+rs1.getString(3));
			}
			
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
