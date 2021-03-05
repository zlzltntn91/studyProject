package toby.vol1.chapter1.solution5;

import lombok.extern.slf4j.Slf4j;
import toby.vol1.chapter1.User;
import toby.vol1.chapter1.solution4.UserDao_Composition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 이전 솔루션에서 가장 큰 문제점은 클래스간 긴밀한 결합
 * 이를 해결하기 위해 중간에 추상적인 느슨한 연결고리를 만들어 주는 게 필요
 * 
 * 추상화란 어떤 것들의 공통적인 성격을 뽑아내어 이를 따로 분리해내는 작업
 * 자바가 추상화를 위해 제공하는 가장 유용한 도구는 바로 인터페이스
 * 인터페이스는 자신을 구현한 클래스에 대한 구체적인 정보는 모두 감춰버린다.
 */
@Slf4j
public class UserDao_composition_interface {

	SimpleConnectionMakerInterface connectionMaker;

	public UserDao_composition_interface(SimpleConnectionMakerInterface connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	private User get(String id) throws SQLException {

		Connection con = connectionMaker.makeConnection();

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
		UserDao_composition_interface userDao_composition = new UserDao_composition_interface(new NConnectionMaker());
		log.info(userDao_composition.get("kim90soo6") + "");
	}

}
