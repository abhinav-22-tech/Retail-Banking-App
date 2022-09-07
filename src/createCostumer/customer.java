package createCostumer;

import java.sql.Connection;
import java.sql.DriverManager;

public class customer {
	public static void main(String[] args) throws Exception {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection con = DriverManager.getConnection("jdbc:derby:myDB;create=true");
		System.out.println("Connected To Derby Database!");
		con.close();
	}
}
