package toby.vol1.chapter1.F_solution6;

import toby.vol1.chapter1.E_solution5.NConnectionMaker;
import toby.vol1.chapter1.E_solution5.SimpleConnectionMaker;
import toby.vol1.chapter1.E_solution5.UserDao;

public class DaoFactory {

	public UserDao userDao(){
		UserDao userDao = new UserDao(makeConnection());
		return userDao;
	}

	/**
	 * UserDao가 아닌 여러개의 dao가 생겼을때 아래의 코드가 중복되는걸 방지한다.
	 *
	 * SimpleConnectionMaker connection = new NConnectionMaker();
	 * @return
	 */
	private SimpleConnectionMaker makeConnection(){
		return new NConnectionMaker();
	}

}
