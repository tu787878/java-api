package me.halotu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection initializeDatabase() { 
	        // Initialize all the information regarding 
	        // Database Connection 
//	        String dbDriver = "com.mysql.jdbc.Driver"; 
	        String dbURL = "jdbc:mysql://localhost:3306/"; 
	        // Database name to access 
	        String dbName = "java-new"; 
	        String dbUsername = "username"; 
	        String dbPassword = "Tu123456"; 
	        try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//	        Class.forName(dbDriver); 
	        Connection con;
			try {
				con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
				System.out.println("SUCCEEDED");
				return con;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} 
	        
	         
	    } 
}
