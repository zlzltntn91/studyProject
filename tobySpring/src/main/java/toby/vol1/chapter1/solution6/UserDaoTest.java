package toby.vol1.chapter1.solution6;

import lombok.extern.slf4j.Slf4j;
import toby.vol1.chapter1.solution5.UserDao;

import java.sql.SQLException;

@Slf4j
public class UserDaoTest {
	public static void main(String[] args) throws SQLException {
		UserDao dao = new DaoFactory().userDao();
		log.info(dao.get("kim90soo5").toString());
	}
}
