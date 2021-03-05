package toby.vol1.chapter1.solution3;

import lombok.extern.slf4j.Slf4j;
import toby.vol1.chapter1.User;

import java.sql.*;

/**
 * 같은 클래스에 다른 메서드로 분리되었던 DB 커넥션 연결이라는 관심을 상속을 통해 서브클래스로 분리한다.
 *
 * UserDao의 관심은 어떻게 데이터를 등록하고 가져올것인가에 대한 것이고
 * 서브클래스에서는 DB 커넥션을 어떻게 할 것인가에 대한 것으로 나누어짐
 *
 * 이 과정으로 UserDao는 변경이 용이하다를 넘어선 손쉽게 확장된다.
 *
 * getConnection 메서드는 Connection interface Type을 리턴받는다는 것 외에는 관심을 두지 않는는다.
 */
@Slf4j
public abstract class UserDao3_abstractMethod {

	/**
	 * 구현 코드는 제거하고 추상 메소드로 바꿈
	 * 
	 * Connection 오브젝트를 어떻게 생성할 것인지를 결정하는 방법
	 * 서브클래스에서 구체적인 오브젝트 생성 방법을 결정하게 하는것을 팩토리 메서드 패턴이라고 함
	 */
	protected abstract Connection getConnection();

	/**
	 * 템플릿 메서드 패턴을 적용
	 */
	private void add(User user) throws ClassNotFoundException, SQLException {

		Connection c = getConnection();

		PreparedStatement pstmt = c.prepareStatement("insert into users(id, name, password) values (?, ?, ?)");
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		pstmt.executeUpdate();

		pstmt.close();
		c.close();
	}

	private User get(String id) throws SQLException {

		Connection con = getConnection();

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

}

