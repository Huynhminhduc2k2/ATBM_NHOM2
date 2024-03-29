package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.LoginController;
import database.JDBCUtil;
import model.UserModel;

public class LoginView extends JFrame {
	private LoginController loginController;
	private JTextField jTextArea_username, jTextArea_password, jTextArea_DB;
	private UserModel userModel;

	public LoginView() throws HeadlessException {
		super();
		this.init();
	}
	
	public ActionListener getAC() {
		return this.loginController;
	}

	private void init() {
		this.setTitle("Login");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font font = new Font("Arial", Font.PLAIN, 20);

		// Tạo controller
		loginController = new LoginController(this);

		// Label
		JLabel jLabel_username = new JLabel("Username", SwingConstants.CENTER);
		jLabel_username.setFont(font);
		JLabel jLabel_password = new JLabel("Password", SwingConstants.CENTER);
		jLabel_password.setFont(font);
		JLabel jLabel_DB = new JLabel("Database", SwingConstants.CENTER);
		jLabel_DB.setFont(font);
		JLabel jLabel_empty1 = new JLabel();
		jLabel_empty1.setFont(font);
		JLabel jLabel_empty2 = new JLabel();
		jLabel_empty2.setFont(font);
		JLabel jLabel_empty3 = new JLabel();
		jLabel_empty3.setFont(font);
		JLabel jLabel_empty4 = new JLabel();
		jLabel_empty4.setFont(font);

		// TextField
		jTextArea_username = new JTextField();
		jTextArea_username.setFont(font);
		jTextArea_password = new JTextField();
		jTextArea_password.setFont(font);
		jTextArea_DB = new JTextField();
		jTextArea_DB.setFont(font);

		// Button
		JButton jButton = new JButton("Login");
		jButton.setFont(font);
		jButton.addActionListener(loginController);

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(7, 1));
		jPanel.add(jLabel_username);
		jPanel.add(jTextArea_username);
		jPanel.add(jLabel_password);
		jPanel.add(jTextArea_password);
		jPanel.add(jLabel_DB);
		jPanel.add(jTextArea_DB);
		jPanel.add(jButton);

		this.setLayout(new BorderLayout(150, 150));
		this.add(jPanel, BorderLayout.CENTER);
		this.add(jLabel_empty1, BorderLayout.NORTH);
		this.add(jLabel_empty2, BorderLayout.EAST);
		this.add(jLabel_empty3, BorderLayout.SOUTH);
		this.add(jLabel_empty4, BorderLayout.WEST);
		setVisible(true);
	}

	public void setLogin() {
		userModel = UserModel.getInstance(jTextArea_username.getText(), jTextArea_password.getText(),
				jTextArea_DB.getText());

		System.out.println(userModel.getUsername() + " " + userModel.getPassword());

		Connection connection = JDBCUtil.getInstance(jTextArea_DB.getText()).getConnection(userModel);

		if (connection == null) {
			System.out.println("Khong dang nhap thanh cong");
		}
	}

	public static void main(String[] args) {
		new LoginView();
	}

	public void toURM() {
		URMView urm = new URMView(this);
		this.setVisible(false);
		urm.setVisible(true);
	}
}
