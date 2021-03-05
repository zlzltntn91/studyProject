package toby.vol1.chapter1.solution4;

import lombok.extern.slf4j.Slf4j;
import toby.vol1.chapter1.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 구성에 의한 구현을 하여 분리는 확실하게 했지만 기존에 N사와 D사에 UserDao 클래스만 공급하고
 * DB 커넥션을 가져오는 기능을 확장하는 기능은 불가능해짐
 *
 * UserDao 클래스가 SimpleConnectionMaker 라는 특정 클래스에 종속되어 버려서 코드의 수정없이 커낵션 생성기능을 변경 할 방법이 없다.
 *
 * 첫번째 문제
 * 만약 D사가 SimpleConnectionMaker를 openConnection()라는 메서드명으로 구현하였다면 UserDao의 소스코드를 수정해야함
 *
 * 두번째 문제
 * Db커넥션을 제공하는 클래스가 어떤것인지를 UserDao가 구체적으로 알고 있어야함
 * N사에서 NConnectionMaker 라는 클래스명으로 구현하면 UserDao를 수정해야함
 *
 * 특정 클래스와 그 코드에 종속적으로 되어버렸다. 이래서는 상속보다 나은점이 없어보인다.
 */
@Slf4j
public class UserDao_Composition {

	// is not implemented by inheritance, just implemented by omposition
	SimpleConnectionMaker simpleConnectionMaker;

	public UserDao_Composition() {
		simpleConnectionMaker = new SimpleConnectionMaker(); // 특정 클래스를 인스턴스화 함
	}

	private User get(String id) throws SQLException {

		Connection con = simpleConnectionMaker.makeConnection();

		PreparedStatement pstmt = con.prepareStatement("select * from users where id = ?");
		pstmt.setString(1, id);

		User user = new User();

		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) {
			user.setId(rst.getString(1));
			user.setName(rst.getString(2));
			user.setPassword(rst.getString(3));
		}

		rst.close();
		pstmt.close();
		con.close();

		return user;

	}

	public static void main(String[] args) throws SQLException {
		UserDao_Composition userDao_composition = new UserDao_Composition();
		log.info(userDao_composition.get("kim90soo6") + "");
	}
}
