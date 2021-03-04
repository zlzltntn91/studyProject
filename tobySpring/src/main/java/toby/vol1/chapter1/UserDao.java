package toby.vol1.chapter1;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * 초 난감 UserDao
 */
@Slf4j
public class UserDao {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		UserDao userDao = new UserDao();
		User user = new User();
		user.setId("kim90soo5");
		user.setName("김은수");
		user.setPassword("qwe123!@#");
		try {
			userDao.add(user);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		User resultUser = userDao.get("kim90soo");
		log.debug(resultUser.toString());

	}

	public void add(User user) throws ClassNotFoundException, SQLException {
		// 관심 1
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/toby?characterEncoding=UTF-8", "zlatn91", "kim90soo");

		// 관심 2
		PreparedStatement pstmt = c.prepareStatement("insert into users(id, name, password) values (?, ?, ?)");
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		pstmt.executeUpdate();

		// 관심 3
		pstmt.close();
		c.close();
	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/toby?characterEncoding=UTF-8", "zlatn91", "kim90soo");
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
