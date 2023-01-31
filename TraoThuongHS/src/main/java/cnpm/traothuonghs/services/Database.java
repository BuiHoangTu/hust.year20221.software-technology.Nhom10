package cnpm.traothuonghs.services;

import java.sql.*;

public class Database {
	private static final String dbURL = "jdbc:mysql://localhost:3306/trao_thuong_hoc_sinh"; // TODO: 27/01/2023 change database
	private static final String dbUName = "root";
	private static final String dbPasswd = "";
	private static volatile Connection connection = null;


	public static Connection getConnection(boolean autocommit) {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(dbURL, dbUName, dbPasswd);
				connection.setAutoCommit(autocommit);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	public static Connection getConnection() {
		return getConnection(true);
	}

	public static int login(String uname, String passwd) throws SQLException {
		Connection connection = getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("""
				SELECT ID
				FROM users
				WHERE userName = ?
				AND passwd = ?
				""");
		preparedStatement.setString(1, uname);
		preparedStatement.setString(2, passwd);

		ResultSet resultSet = preparedStatement.executeQuery();
		if (!resultSet.next()) {
			return -1;
		}

		return Integer.parseInt(resultSet.getString("ID"));
	}
}
