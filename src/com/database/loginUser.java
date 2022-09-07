package com.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.helper.Helper;

public class loginUser {
	public static boolean checkUsernamePassword(String inputUserName, String inputPassword) throws SQLException {

		String query = "select * from Executive";
		PreparedStatement preparedStatement = Helper.getConnectionPreparedStatement(query);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			String eUserName = resultSet.getString(3);
			String ePassword = resultSet.getString(8);
			if(eUserName.equals(inputUserName) && ePassword.equals(inputPassword)) {
				return true;
			}
			else {
				return false;
			}
		}
		
		Helper.closeConnectionPreparedStatement();
		return false;
	}
}
