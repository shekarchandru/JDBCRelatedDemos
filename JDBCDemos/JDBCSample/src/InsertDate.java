import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ctsdata";
			String user = "root";
			String password = "MySQL_@123456";
			Connection con = DriverManager.getConnection(url,user,password);
			String query1 = "insert into Agent values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(query1);
			pstmt.setString(1,"A003");
			
			String strDate = "2019-05-24";
			
			Date dtDate = stringToDateConverter(strDate);
			pstmt.setDate(2, utilToSqlDateConverter(dtDate));
			
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

	public static java.sql.Date utilToSqlDateConverter(java.util.Date utDate) {
		java.sql.Date sqlDate = null;
		if (utDate != null) {
			sqlDate = new java.sql.Date(utDate.getTime());
		}
		return sqlDate;
	}
	
	public static java.util.Date stringToDateConverter(String stringDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		try {
			return dateFormat.parse(stringDate);
		} catch (ParseException pe) {
			return null;
		}
	}
}
