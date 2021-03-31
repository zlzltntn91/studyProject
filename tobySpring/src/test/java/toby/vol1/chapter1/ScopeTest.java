package toby.vol1.chapter1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import toby.vol1.chapter1.solution5.UserDao;
import toby.vol1.chapter1.solution7_spring.DaoFactory;

@Slf4j
public class ScopeTest {

	@Test
	public void scopeTest(){
		DaoFactory factory = new DaoFactory();
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao daoFactory = factory.userDao();
		UserDao daoFactory2 = factory.userDao();
		UserDao daoFactory3 = factory.userDao();
		UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
		UserDao userDao2 = applicationContext.getBean("userDao", UserDao.class);
		UserDao userDao3 = applicationContext.getBean("userDao", UserDao.class);

		log.info(daoFactory.toString());
		log.info(daoFactory2.toString());
		log.info(String.valueOf(daoFactory3 == daoFactory));

		log.info(userDao.toString());
		log.info(userDao2.toString());
		log.info(String.valueOf(userDao3 == userDao));
	}
}
