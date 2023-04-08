package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.UserModel;
import oracle.jdbc.driver.OracleDriver;

public class JDBCUtil {
	private static JDBCUtil instance = null;
	private static String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";

	private JDBCUtil() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static JDBCUtil getInstance() {
		if (instance == null)
			instance = new JDBCUtil();
		return instance;
	}

	public static Connection getConnection(String username, String password) {
		try {
			return DriverManager.getConnection(dbURL, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection(UserModel usr) {
		Connection c = null;

		try {
			// Đăng ký Oracle Driver với DriverManager
			DriverManager.registerDriver(new OracleDriver());

			// Cac thong so
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String url = "jdbc:oracle:thin:@localhost:1521/ORCLPDB1";

			// Tao ket noi
			return DriverManager.getConnection(url, usr.getUsername(), usr.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	public static void closeConnection(Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void printInfo(Connection c) {
		if (c != null) {
			try {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
