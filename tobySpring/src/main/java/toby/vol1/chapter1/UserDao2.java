package toby.vol1.chapter1;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class UserDao2 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		UserDao2 userDao = new UserDao2();
		User user = new User();
		user.setId("kim90soo6");
		user.setName("김은수");
		user.setPassword("qwe123!@#");
		try {
			userDao.add(user);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		User resultUser = userDao.get("kim90soo6");
		log.debug(resultUser.toString());

	}

	/**
	 * 메서드 추출 기법을 사용하여 중복 코드를 제거했다.
	 * 관심의 종류에 따라 코드를 구분해놓았기 때문에 Connection에 대한 변경이 일어날 경우
	 * 관심이 집중되어있는 부분의 코드만 수정하면 된다.
	 * 
	 * 다른 메서드에 영향을 주지도 않을 뿐더러, 관심 내용이 독립적으로 존재하므로 수정도 간단해짐
	 */
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/toby?characterEncoding=UTF-8", "zlatn91", "kim90soo");
	}

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

	private User get(String id) throws ClassNotFoundException, SQLException {
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
