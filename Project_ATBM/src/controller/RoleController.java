package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import view.RoleView;
public class RoleController implements ActionListener{
	private RoleView roleview;
		
		public RoleController(RoleView view) {
			// TODO Auto-generated constructor stub
			this.roleview = view;
		}
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String src = e.getActionCommand();
			if (src.equals("All Role")) {
				System.out.println(src);
			}
			else if (src.equals("Grant")) {
				System.out.println(src);
			}
			else if (src.equals("Revoke")) {
				System.out.println(src);
			}
			else if (src.equals("Search")) {
				System.out.println(src);
			} else if (src.equals("<")) {
				this.roleview.toURMView();
			}
		}
}
