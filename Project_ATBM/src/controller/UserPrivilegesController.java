package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.UserPrivilegeList;

public class UserPrivilegesController implements ActionListener{
	private UserPrivilegeList up;
	public UserPrivilegesController(UserPrivilegeList userprivileges) {
		// TODO Auto-generated constructor stub
		this.up = userprivileges;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equals("<")) {
			this.up.toURMView();
		} else if (src.equals("Load")) {
			this.up.loadUser();
		} else if (src.equals("Search")) {
			this.up.search();
		} else if (src.equals("Grant")) {
			this.up.grantPriv();
//		} else if (src.equals("Revoke")) {
//			this.up.revokePriv();
		}
	}
}
