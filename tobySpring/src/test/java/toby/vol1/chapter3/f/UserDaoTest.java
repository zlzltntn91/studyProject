package toby.vol1.chapter3.f;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import toby.vol1.chapter1.User;

import java.sql.SQLException;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/chapter3/f/applicationContext.xml")
public class UserDaoTest {

	@Autowired
	UserDao dao;

	ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() throws Exception {
		dao.add(User.builder().name("김은수").id("qwe123").password("qwe123").build());
	}

	@Test
	public void add() throws SQLException {
	}

	@Test
	public void get() throws SQLException {
		User user = dao.get("qwe123");
		log.info(user.toString());
	}

	@After
	public void deleteAll() throws SQLException {
		dao.deleteAll();
	}

}
