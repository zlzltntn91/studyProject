package toby.vol1.chapter1.solution7_spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import toby.vol1.chapter1.solution5.UserDao;

import java.sql.SQLException;

@Slf4j
public class UserDaoTest {


	public static void main(String[] args) throws SQLException {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
		log.info(String.valueOf(userDao.get("kim90soo")));

	}
}
