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
			this.urmview.createUser();
		} else if (src.equals("Find user")) {
			this.urmview.findByUser();
		}
	}

}
