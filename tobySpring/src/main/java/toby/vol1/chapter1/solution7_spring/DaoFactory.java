package toby.vol1.chapter1.solution7_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toby.vol1.chapter1.solution5.NConnectionMaker;
import toby.vol1.chapter1.solution5.SimpleConnectionMakerInterface;
import toby.vol1.chapter1.solution5.UserDao;

@Configuration
public class DaoFactory {

	@Bean
	public UserDao userDao(){
		UserDao userDao = new UserDao(makeConnection());
		return userDao;
	}

	@Bean
	public SimpleConnectionMakerInterface makeConnection(){
		return new NConnectionMaker();
	}
}
