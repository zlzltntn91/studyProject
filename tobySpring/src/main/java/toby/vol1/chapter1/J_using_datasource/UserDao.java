package toby.vol1.chapter1.J_using_datasource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import toby.vol1.chapter1.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class UserDao {

	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String get(String id) throws SQLException {

		Connection con = dataSource.getConnection();

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



		return user.toString();

	}


}
