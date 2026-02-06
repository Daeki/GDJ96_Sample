package com.winter.app.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	
	public static Connection getConnection() throws Exception {
		String user = "sample";
		String password = "sample";
		String url = "jdbc:mysql://localhost:3306/sample";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		Class.forName(driver);
		
		return DriverManager.getConnection(url, user, password);
		
		
		
	}

}
