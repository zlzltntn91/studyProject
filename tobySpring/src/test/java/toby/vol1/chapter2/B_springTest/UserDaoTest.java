package toby.vol1.chapter2.B_springTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/chapter2/B_springTest/applicationContext.xml")
public class UserDaoTest {

	@Autowired
	ApplicationContext context;

	@Before
	public void setUp(){
		log.info(Arrays.toString(context.getBeanDefinitionNames()));
		log.info(this.toString());
		log.info(this.context.toString());
	}

	@Test
	public void t1(){}
	@Test
	public void t2(){}
	@Test
	public void t3(){}
}
