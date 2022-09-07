package com.database.helper;

import java.sql.Statement;

public class BaseQuery {
	public static void makeTable(boolean isTableToBeDelete) throws Exception{
		if(isTableToBeDelete) {
			// delete the table first and then create a new Table
			String query = "drop table Employee";
			query = "Create table Customer("
					+ "customerId int,"
					+ "customerName varchar(20),"
					+ "customerAge int"
					+ "";
			
			Statement statement = Helper.getConnectionStatement();
			statement.execute(query);
			
		}else {
			String query = "Create table Employee("
					+ "empId int,"
					+ "empName varchar(20),"
					+ "empDesg varchar(20))";
			
			Statement statement = Helper.getConnectionStatement();
			statement.execute(query);
		}
		Helper.closeConnectionStatement();
	}
}
