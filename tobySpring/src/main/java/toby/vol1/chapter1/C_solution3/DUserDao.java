package toby.vol1.chapter1.C_solution3;

import java.sql.Connection;

public class DUserDao extends UserDao {
	@Override
	protected Connection getConnection() {
		return null;
	}

}
