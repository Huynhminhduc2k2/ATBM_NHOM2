package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.UserModel;
import oracle.jdbc.driver.OracleDriver;

public class JDBCUtil {
//	private static String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static JDBCUtil instance = null;
	private static String dbURL = "jdbc:oracle:thin:@localhost:1521";
	private static boolean isChecked = false;

	private JDBCUtil(String DB) {
		if (isChecked) {
			return;
		}
		if (DB.equals("XE")) {
			dbURL += ":XE";
		} else {
			dbURL += "/" + DB;
		}
		isChecked = true;
		System.out.println(dbURL);

		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static JDBCUtil getInstance(String DB) {
		if (instance == null)
			instance = new JDBCUtil(DB);
		return instance;
	}

	public Connection getConnection(UserModel usr) {
		try {
			// Đăng ký Oracle Driver với DriverManager
//			DriverManager.registerDriver(new OracleDriver());

			// Tạo kết nối
			return DriverManager.getConnection(dbURL, usr.getUsername(), usr.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void closeConnection(Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
