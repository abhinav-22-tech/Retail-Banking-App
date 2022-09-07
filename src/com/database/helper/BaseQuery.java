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
			System.out.println("All Table Deleted");
			
		}else {
			String query = "create table Customer ("
					+ "customerId int primary key GENERATED ALWAYS AS IDENTITY, "
					+ "customerName varchar(20),  "
					+ "customerAge int, "
					+ "customerAddress varchar(30), "
					+ "customerCity varchar(20), "
					+ "customerState varchar(20), "
					+ "customerPassword varchar(20))";
			
			Statement statement = Helper.getConnectionStatement();
			statement.execute(query);
			System.out.println("New Table Created");
		}
		Helper.closeConnectionStatement();
	}
}
