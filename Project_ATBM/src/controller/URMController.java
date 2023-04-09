package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.JDBCUtil;
import model.UserModel;
import view.URMView;

public class URMController implements ActionListener {
	private URMView urmview;

	public URMController(URMView view) {
		// TODO Auto-generated constructor stub
		this.urmview = view;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equals("Create user")) {
			System.out.println("create user");
		} else if (src.equals("Find user")) {
			UserModel userModel = UserModel.getInstance("", "", "");

			System.out.println(userModel.getUsername() + " " + userModel.getPassword());

			Connection connection = JDBCUtil.getInstance("").getConnection(userModel);
		
			try {
				String sql = "select * from DBa_users";

				PreparedStatement st = connection.prepareStatement(sql);

				ResultSet check = st.executeQuery(sql);
				Object[][] data;
				while (check.next()) {
					System.out.println(check.getString("username"));
				}
				// Buoc 5: ngat ket noi
				JDBCUtil.closeConnection(connection);

				userModel = UserModel.getInstance("", "", "");
				System.out.println(userModel.getUsername() + " " + userModel.getPassword());
			} catch (SQLException err) {
				err.printStackTrace();
			}
		}
	}

}
