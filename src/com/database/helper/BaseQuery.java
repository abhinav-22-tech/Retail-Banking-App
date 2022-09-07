package com.database.helper;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class BaseQuery {
	public static void makeTable(boolean isTableToBeDelete) throws Exception{
		if(isTableToBeDelete) {
			// delete the table first and then create a new Table
			String query = "drop table Customer";
			
			Statement statement = Helper.getConnectionStatement();
			statement.execute(query);
			
			query = "drop table Executive";
			statement = Helper.getConnectionStatement();
			statement.execute(query);
			
			
			System.out.println("All Table Deleted");
			
		}else {
			String query = "create table Customer ("
					+ "customerId int primary key GENERATED ALWAYS AS IDENTITY, "
					+ "customerSSNID int, "
					+ "customerName varchar(20),  "
					+ "customerAge int, "
					+ "customerAddress varchar(30), "
					+ "customerCity varchar(20), "
					+ "customerState varchar(20))";
			
			Statement statement = Helper.getConnectionStatement();
			statement.execute(query);
			System.out.println("Customer Table Created");
			
			query = "create table Executive ("
					+ "executiveId int primary key GENERATED ALWAYS AS IDENTITY, "
					+ "executiveName varchar(20),  "
					+ "executiveUserName varchar(20),  "
					+ "executiveAge int, "
					+ "executiveAddress varchar(30), "
					+ "executiveCity varchar(20), "
					+ "executiveState varchar(20), "
					+ "executivePassword varchar(20))";
			
			statement = Helper.getConnectionStatement();
			statement.execute(query);
			System.out.println("Executive Table Created");
		}
		Helper.closeConnectionStatement();
	}
	
	
}
