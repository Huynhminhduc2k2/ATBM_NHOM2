package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.URMController;
import database.JDBCUtil;
import model.UserModel;

public class URMView extends JFrame implements WindowListener {
	private LoginView parent;
	private JPanel contentPane;
	private JTextField findUserTextField;
	private JTable table;
	private JTextField textField_Username;
	private JTextField textField_UserPassword;
	private JTextField textField_3;
	private JTable table_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JScrollPane js1;

	/**
	 * Launch the application.
	 */
	public URMView(LoginView login) {
		this.addWindowListener(this);
		this.parent = login;
		this.init();
	}

	public URMView() {
		this.init();
	}

	/**
	 * Create the frame.
	 */
	public void init() {
		ActionListener ac = new URMController(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
//		this.setLocationRelativeTo(null);
//		this.setPreferredSize(new Dimension(800, 600));
//		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("User and Role Management");
		lblNewLabel.setBounds(5, 5, 774, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(5, 40, 774, 516);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 387, 516);
		panel_1.setBackground(Color.CYAN);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 387, 72);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(3, 1, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("User");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Find by name:");
		panel_3.add(lblNewLabel_2);

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 2, 0, 0));

		findUserTextField = new JTextField();
		panel_4.add(findUserTextField);
		findUserTextField.setColumns(10);

		JButton btnNewButton = new JButton("Find user");
		btnNewButton.addActionListener(ac);
		panel_4.add(btnNewButton);

		String[] columnNames = { "Username" };
		Object[][] data = {};
		DefaultTableModel model = new DefaultTableModel(data, columnNames);

		table = new JTable(model);
		table.setBounds(0, 72, 268, 444);
		panel_1.add(new JScrollPane(table));
		js1 = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js1.setBounds(0, 72, 268, 444);
		panel_1.add(js1);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(268, 72, 119, 444);
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("User name:");
		lblNewLabel_3.setBounds(0, 2, 119, 55);
		panel_5.add(lblNewLabel_3);

		textField_Username = new JTextField();
		textField_Username.setBounds(0, 51, 119, 20);
		panel_5.add(textField_Username);
		textField_Username.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Password:");
		lblNewLabel_4.setBounds(0, 76, 119, 55);
		panel_5.add(lblNewLabel_4);

		textField_UserPassword = new JTextField();
		textField_UserPassword.setBounds(0, 122, 119, 20);
		panel_5.add(textField_UserPassword);
		textField_UserPassword.setColumns(10);

		JButton btnNewButton_1 = new JButton("Create user");
		btnNewButton_1.setBounds(0, 166, 119, 55);
		panel_5.add(btnNewButton_1);
		btnNewButton_1.addActionListener(ac);

		JButton btnNewButton_2 = new JButton("Delete user");
		btnNewButton_2.setBounds(0, 240, 119, 55);
		btnNewButton_2.addActionListener(ac);
		panel_5.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Change password");
		btnNewButton_3.setBounds(0, 314, 119, 55);
		btnNewButton_3.addActionListener(ac);
		panel_5.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("User's privileges");
		btnNewButton_4.setBounds(0, 387, 119, 55);
		btnNewButton_4.addActionListener(ac);
		panel_5.add(btnNewButton_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(387, 0, 387, 516);
		panel_2.setBackground(Color.CYAN);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 0, 387, 72);
		panel_2.add(panel_6);
		panel_6.setLayout(new GridLayout(3, 1, 0, 0));

		JLabel lblNewLabel_5 = new JLabel("Role");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Find by name:");
		panel_6.add(lblNewLabel_6);

		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 2, 0, 0));

		textField_3 = new JTextField();
		panel_7.add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton_5 = new JButton("Find role");
		btnNewButton_5.addActionListener(ac);
		panel_7.add(btnNewButton_5);

		table_1 = new JTable();
		table_1.setBounds(0, 72, 268, 444);
		panel_2.add(table_1);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(268, 72, 119, 444);
		panel_2.add(panel_8);
		panel_8.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Role name:");
		lblNewLabel_7.setBounds(0, 2, 119, 55);
		panel_8.add(lblNewLabel_7);

		textField_4 = new JTextField();
		textField_4.setBounds(0, 50, 119, 20);
		panel_8.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Password:");
		lblNewLabel_8.setBounds(0, 75, 119, 55);
		panel_8.add(lblNewLabel_8);

		textField_5 = new JTextField();
		textField_5.setBounds(0, 122, 119, 20);
		panel_8.add(textField_5);
		textField_5.setColumns(10);

		JButton btnNewButton_6 = new JButton("Create role");
		btnNewButton_6.addActionListener(ac);
		btnNewButton_6.setBounds(0, 166, 119, 55);
		panel_8.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Delete role");
		btnNewButton_7.addActionListener(ac);
		btnNewButton_7.setBounds(0, 240, 119, 55);
		panel_8.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("Change password");
		btnNewButton_8.addActionListener(ac);
		btnNewButton_8.setBounds(0, 314, 119, 55);
		panel_8.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("Role's privileges");
		btnNewButton_9.setBounds(0, 387, 119, 55);
		btnNewButton_9.addActionListener(ac);
		panel_8.add(btnNewButton_9);

		this.setJTableUser();
		this.setVisible(true);
	}

	private void clearJTableUser() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		table.repaint();
		js1.revalidate();
	}

	private void setJTableUser() {
		this.clearJTableUser();

		UserModel userModel = UserModel.getInstance("", "", "");

		Connection connection = JDBCUtil.getInstance("").getConnection(userModel);

		try {
			String sql = "select username, user_id from DBa_users";

			PreparedStatement st = connection.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel dTModel = (DefaultTableModel) table.getModel();

			int colCount = rsmd.getColumnCount();
			String[] colName = new String[colCount];
			for (int i = 0; i < colCount; i++) {
				colName[i] = rsmd.getColumnName(i + 1);
			}
			dTModel.setColumnIdentifiers(colName);

			while (rs.next()) {
				String[] rowValue = new String[colCount];
				for (int i = 0; i < rowValue.length; i++) {
					rowValue[i] = rs.getString(i + 1);
				}
				dTModel.addRow(rowValue);
			}
			// Buoc 5: ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}

	public void findByUser() {
		this.clearJTableUser();

		UserModel userModel = UserModel.getInstance("", "", "");

		Connection connection = JDBCUtil.getInstance("").getConnection(userModel);

		try {
			String sql = "select username, user_id from DBa_users where username = upper(?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, this.findUserTextField.getText());

			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel dTModel = (DefaultTableModel) table.getModel();

			int colCount = rsmd.getColumnCount();
			String[] colName = new String[colCount];
			for (int i = 0; i < colCount; i++) {
				colName[i] = rsmd.getColumnName(i + 1);
			}
			dTModel.setColumnIdentifiers(colName);

			while (rs.next()) {
				String[] rowValue = new String[colCount];
				for (int i = 0; i < rowValue.length; i++) {
					rowValue[i] = rs.getString(i + 1);
					System.out.println(rowValue[i]);
				}
				dTModel.addRow(rowValue);
			}

			this.findUserTextField.setText("");

			// Buoc 5: ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}

	public void createUser() {
		this.clearJTableUser();

		UserModel userModel = UserModel.getInstance("", "", "");

		Connection connection = JDBCUtil.getInstance("").getConnection(userModel);

		try {
			CallableStatement st = connection.prepareCall("{CALL SYS.create_user(?, ?, ?, ?)}");
			st.registerOutParameter(1, Types.INTEGER);
			st.setString(2, userModel.getUsername());
			st.setString(3, userModel.getPassword());
			st.setInt(4, userModel.getIsCommonUser() ? 0 : 1);
			st.execute();

			int state = st.getInt(1);
			if (state != 1) {
				return;
			}

			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel dTModel = (DefaultTableModel) table.getModel();

			int colCount = rsmd.getColumnCount();
			String[] colName = new String[colCount];
			for (int i = 0; i < colCount; i++) {
				colName[i] = rsmd.getColumnName(i + 1);
			}
			dTModel.setColumnIdentifiers(colName);

			while (rs.next()) {
				String[] rowValue = new String[colCount];
				for (int i = 0; i < rowValue.length; i++) {
					rowValue[i] = rs.getString(i + 1);
					System.out.println(rowValue[i]);
				}
				dTModel.addRow(rowValue);
			}

			this.findUserTextField.setText("");

			// Buoc 5: ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.parent.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		this.parent.dispose();
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		UserModel userModel = UserModel.getInstance("system", "JusticeFreedom@26", "xe");

		Connection connection = JDBCUtil.getInstance("xe").getConnection(userModel);

		if (connection == null) {
			System.out.println("Khong dang nhap thanh cong");
		} else {
			System.out.println("Dang nhap thanh cong");
		}
		new URMView();
	}
}
