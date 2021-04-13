package toby.vol1.chapter3;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import toby.vol1.chapter1.User;
import toby.vol1.chapter3.e.UserDao;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/chapter3/applicationContext.xml")
public class UserDaoTest {

	@Autowired
	UserDao dao;

	ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() throws Exception {

	}

	@Test

	public void name() {
	}
}
