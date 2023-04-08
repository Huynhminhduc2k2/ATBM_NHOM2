package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;
import model.UserModel;

public class TestJDBCUtil {
	public static void main(String[] args) {

		// Buoc 1: tao ket noi
//		String username = "system", password = "JusticeFreedom@26";
//		UserModel usr = new UserModel(username, password);
//		//		Connection connection = JDBCUtil.getConnection("system", "JusticeFreedom@26");
//		Connection connection = JDBCUtil.getConnection(usr);
//
//		// Buoc 2: tao ra doi tuong statement
//		try {
//			Statement st = connection.createStatement();
//			
//			// Buoc 3: thuc thi 1 cau lenh SQL
//			String sql = "select * from ROLE_SYS_PRIVS ";
//
//			ResultSet check = st.executeQuery(sql);
//			
//			while (check.next()) {
//				// Buoc 4: xu ly ket qua tra ve
//				System.out.println(check.getString("privilege"));
//			}
//			// Buoc 5: ngat ket noi
//			JDBCUtil.closeConnection(connection);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
}
