package toby.vol1.chapter1.solution3;

import java.sql.Connection;

public class DUserDao extends UserDao3_abstractMethod{
	@Override
	protected Connection getConnection() {
		return null;
	}

}
