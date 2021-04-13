package toby.vol1.chapter1.G_solution7_spring;

import toby.vol1.chapter1.E_solution5.NConnectionMaker;
import toby.vol1.chapter1.E_solution5.SimpleConnectionMaker;
import toby.vol1.chapter1.E_solution5.UserDao;

//@Configuration
public class DaoFactory {

//	@Bean
	public UserDao userDao(){
		UserDao userDao = new UserDao(connectionMaker());
		return userDao;
	}

//	@Bean
	public SimpleConnectionMaker connectionMaker(){
		return new NConnectionMaker();
	}
}
