package toby.vol1.chapter1.solution5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NConnectionMaker implements SimpleConnectionMakerInterface{

	@Override
	public Connection makeConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/toby?characterEncoding=utf8", "zlatn91", "kim90soo");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;

	}
}
