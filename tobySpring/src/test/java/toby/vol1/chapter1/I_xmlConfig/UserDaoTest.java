package toby.vol1.chapter1.I_xmlConfig;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;
import java.util.Arrays;

@Slf4j
public class UserDaoTest {

	@Test
	public void xmlConfig() throws SQLException {
		ApplicationContext applicationContext = new GenericXmlApplicationContext(
				"chapter1/I_xmlConfig/applicationContext.xml");
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml", UserDaoTest.class);
		log.info(String.valueOf(applicationContext.getBeanDefinitionCount()));
		log.info(Arrays.toString(applicationContext.getBeanDefinitionNames()));
		UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
		log.info(userDao.get("kim90soo"));
	}
}