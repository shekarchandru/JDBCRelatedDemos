package com.cts.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	Connection con=null;
	String user = "root";
	String url = "jdbc:mysql://localhost:3306/ctsdata";
	String password = "MySQL_@123456";
	public Connection getMyConnections()
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException sqe)
		{
			sqe.printStackTrace();
		}
		return con;
	}
}
