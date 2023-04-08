package controller;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.LoginView;

public class LoginController implements ActionListener {
	private LoginView loginView;
	private JDialog message;

	public LoginController(LoginView loginView) {
		super();
		this.loginView = loginView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.loginView.setLogin();
		String src = e.getActionCommand();
		if (src.equals("Login")) {
			// create dialog
			message = new JDialog();
			JLabel mess = new JLabel("Login sucessfully.");
			JButton ojbtn = new JButton("OK");
			message.setLayout(new GridLayout(2, 1, 10, 10));
			message.setLocationRelativeTo(null);
			
			ojbtn.addActionListener(this.loginView.getAC());

			message.add(mess);
			message.add(ojbtn);
			message.setSize(100, 100);
			message.setVisible(true);
		} else if (src.equals("OK")) {
			this.message.dispose();//destroy dialogs
			this.loginView.toURM();
		}
	}

}
