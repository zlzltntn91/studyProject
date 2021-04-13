package toby.vol1.chapter3.f;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcContext {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void workWithStatementStrategy(StatementStrategy stmt) throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;

		try {
			c = dataSource.getConnection();

			ps = stmt.makePreparedStatement(c);

			ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public void excuteQuery(final String query) throws SQLException {
		workWithStatementStrategy(new StatementStrategy() {
									  @Override
									  public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
										  return c.prepareStatement(query);
									  }
								  }
		);
	}

	public void excuteQuery(final String query, String... args) throws SQLException {
		workWithStatementStrategy(new StatementStrategy() {
									  @Override
									  public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
										  PreparedStatement pstmt = c.prepareStatement(query);
										  for (int i = 0; i < args.length; i++) {
										  	String arg = args[i];
										  	pstmt.setString(i+1, arg);
										  }
										  return pstmt;
									  }
								  }
		);
	}

}
