package com.database.helper;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;

public class Helper {
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	
	// Connection
	public static Statement getConnectionStatement() {
		try {
			String url = "jdbc:mysql://localhost:3306/mydb";
		    String uname = "root";
		    String pass = "aadish";
		      
		    Class.forName("com.mysql.cj.jdbc.Driver");
			Helper.connection = DriverManager.getConnection(url, uname, pass);
			Helper.statement = Helper.connection.createStatement();
			return statement;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	// Statement
	public static PreparedStatement getConnectionPreparedStatement(String sql) {
		try {
			String url = "jdbc:mysql://localhost:3306/mydb";
		    String uname = "root";
		    String pass = "aadish";
		      
		    Class.forName("com.mysql.cj.jdbc.Driver");
			Helper.connection = DriverManager.getConnection(url, uname, pass);
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
	
	public static boolean tableExists(String tableName) throws SQLException {
		try {
			String url = "jdbc:mysql://localhost:3306/mydb";
		    String uname = "root";
		    String pass = "aadish";
		      
		    Class.forName("com.mysql.cj.jdbc.Driver");
			Helper.connection = DriverManager.getConnection(url, uname, pass);
			DatabaseMetaData dbm = Helper.connection.getMetaData();
			// check if "employee" table is there
			ResultSet tables = dbm.getTables(null, null, tableName, null);
			if (tables.next()) {
			  // Table exists
				return true;
			}
			else {
			  // Table does not 
				return false;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
}
