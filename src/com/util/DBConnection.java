package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private final static String userName = "root";
	private final static String password = "root";
	// 3306 mysql service ->
	private final static String connectionURL = "jdbc:mysql://localhost:3306/dhruvi_java";
	// jar
	private final static String driverClassName = "com.mysql.jdbc.Driver";

	public static Connection getDatabaseConnection() {

		// forName -> jvm force -->
		Connection conn = null;
		try {
			// 1st step
			Class.forName(driverClassName);

			 conn= DriverManager.getConnection(connectionURL, userName, password);
			if (conn != null) {

				System.out.println("Connected to database.....");
			} else {

				System.out.println("not connected to database....");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;

	}

	public static void main(String[] args) {

		
		DBConnection.getDatabaseConnection();
	}

}
