package toby.vol1.chapter1.solution5;

import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

@Slf4j
public class UserDaoTest {
	public static void main(String[] args) throws SQLException {
		UserDao userDao_composition = new UserDao(new NConnectionMaker());
		log.info(userDao_composition.get("kim90soo6") + "");
	}
}
