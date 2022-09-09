package com.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.entities.Customer;
import com.database.helper.Helper;

public class loginUser {

	// Check user name and password in database
	public static boolean checkUsernamePassword(String inputUserName, String inputPassword) {
		try {
			String query = "select * from Executive";
			PreparedStatement preparedStatement = Helper.getConnectionPreparedStatement(query);
			ResultSet resultSet;
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String eUserName = resultSet.getString(3);
				String ePassword = resultSet.getString(8);
				if (eUserName.equals(inputUserName) && ePassword.equals(inputPassword)) {
					boolean addIntoLog = addUserStore(eUserName, ePassword);
					return true && addIntoLog;
				}
			}

			Helper.closeConnectionPreparedStatement();
			return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Internal Error");
		}
		return false;
	}

	// Add login user name and password in userStore table
	public static boolean addUserStore(String userName, String password) throws SQLException {
		boolean flag = false;
		String query = "insert into userStore(username, password" + ") values (?,?)";
		PreparedStatement preparedStatement = Helper.getConnectionPreparedStatement(query);

		preparedStatement.setString(1, userName);
		preparedStatement.setString(2, password);

		int temp = preparedStatement.executeUpdate();
		if (temp >= 1) {
			flag = true;
		}
		Helper.closeConnectionPreparedStatement();
		return flag;
	}
}
