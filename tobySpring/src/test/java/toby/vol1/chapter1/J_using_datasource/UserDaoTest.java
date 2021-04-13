package toby.vol1.chapter1.J_using_datasource;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;
import java.util.Arrays;

@Slf4j
public class UserDaoTest {
	@Test
	public void dataSource() throws SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		log.info(String.valueOf(context.getBeanDefinitionCount()));
		log.info(Arrays.toString(context.getBeanDefinitionNames()));
		UserDao dao = context.getBean("userDao", UserDao.class);
		log.info(dao.get("kim90soo"));
	}

	@Test
	public void dataSource_xml() throws SQLException {
		ApplicationContext context = new GenericXmlApplicationContext(
				"chapter1/J_using_datasource/applicationContext.xml");
		log.info(String.valueOf(context.getBeanDefinitionCount()));
		log.info(Arrays.toString(context.getBeanDefinitionNames()));
		UserDao dao = context.getBean("userDao", UserDao.class);
		log.info(dao.get("kim90soo"));
	}
}