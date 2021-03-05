package toby.vol1.chapter1.solution3;

import java.sql.Connection;

/**
 * 어떠한 방법으로 Connection Object를 생성하는 것에만 관심이 있다.
 */
public class NUserDao extends UserDao3_abstractMethod{
	@Override
	protected Connection getConnection() {
		return null;
	}

}
