package com.database.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class Helper {
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	
	// Connection
	public static Statement getConnectionStatement() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Helper.connection = DriverManager.getConnection("jdbc:derby:myDB;create=true");
			Helper.statement = Helper.connection.createStatement();
			return statement;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	// Statement
	public static Statement getConnectionPreparedStatement(String sql) {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			
			Helper.connection = DriverManager.getConnection("jdbc:derby:myDB;create=true");
			Helper.preparedStatement = Helper.connection.prepareStatement(sql);
			return preparedStatement;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	// Close connection statement 
	public static void closeConnectionStatement() {
		try {
			Helper.statement.close();
			Helper.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Close connection prepared statement
	public static void closeConnectionPreparedStatement() {
		try {
			Helper.preparedStatement.close();
			Helper.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
