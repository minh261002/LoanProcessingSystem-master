package com.aptech.LoanProcessingSystem.database;

import java.sql.*;

public class ConnectDB {

	private static Connection connection;

	public static Connection connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan_processing_system?serverTimezone=UTC", "root",
					"1234567");

		} catch (Exception e) {
			e.printStackTrace();
			connection = null;
		}
		return connection;
	}

	public static void disconnect() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
