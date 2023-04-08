package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.LoginController;
import database.JDBCUtil;
import model.UserModel;

public class LoginView extends JFrame {
	private JTextField jTextArea_username, jTextArea_password, jTextArea_DB;
	private UserModel userModel;

	public LoginView() throws HeadlessException {
		super();
		this.init();
	}

	private void init() {
		this.setTitle("Login");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font font = new Font("Arial", Font.PLAIN, 20);

		// Tạo controller
		LoginController loginController = new LoginController(this);

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
		userModel = new UserModel(jTextArea_username.getText(), jTextArea_password.getText(), jTextArea_DB.getText());

		Connection connection = JDBCUtil.getInstance(jTextArea_DB.getText()).getConnection(userModel);

		// Buoc 2: tao ra doi tuong statement
		try {
			Statement st = connection.createStatement();

			// Buoc 3: thuc thi 1 cau lenh SQL
			String sql = "select * from ROLE_SYS_PRIVS ";

			ResultSet check = st.executeQuery(sql);

			while (check.next()) {
				// Buoc 4: xu ly ket qua tra ve
				System.out.println(check.getString("privilege"));
			}
			// Buoc 5: ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new LoginView();
	}
}
