package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.UserPrivilegesController;
import database.JDBCUtil;
import model.UserModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
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

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import view.URMView;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class UserPrivilegeList extends JFrame implements WindowListener {
	private URMView parent;
	private JPanel contentPane;
	private JPanel titlePane;
	private JButton grantPrivilege_Button;
	private JButton searchUser_Button;
	private JTextField searchUserGrant_Container;
	private JLabel searchTableGrant_Label;
	private JTextField searchTableGrant_Container;
	private JLabel dropPrivilegeGrant_Label;
	private JLabel lblRevokePrivilege;
	private JLabel searchUser_Label;
	private JLabel searchUserRevoke_Label;
	private JLabel searchTableRevoke_Label;
	private JLabel searchPrivilegeRevoke_Label;
	private JTextField searchUserRevoke_Container;
	private JTextField searchTable_Container;
	private JTextField searchPrivilege_Container;
	private JButton btnNewButton;
	private JScrollPane js1;
	private JTable table;
	private JTextField searchPrivGrant;
	private JLabel searchUserName_Label;
	private JTextField userName_txt;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPrivilegeList frame = new UserPrivilegeList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public UserPrivilegeList(URMView urm) {
		this.parent = urm;
		this.init();
	}

	public UserPrivilegeList() {
		this.init();
	}	
	/**
	 * Create the frame.
	 */
	public void init() {
		this.addWindowListener(this);
		ActionListener ac = new UserPrivilegesController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titlePane = new JPanel();
		titlePane.setBounds(20, 10, 973, 35);
		contentPane.add(titlePane);
		titlePane.setLayout(new BorderLayout(0, 0));
		
		JLabel userPrivilegesList_Title = new JLabel("USER PRIVILEGES LIST");
		userPrivilegesList_Title.setHorizontalAlignment(SwingConstants.CENTER);
		userPrivilegesList_Title.setFont(new Font("Arial", Font.BOLD, 20));
		titlePane.add(userPrivilegesList_Title);
		
		btnNewButton = new JButton("<");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(ac);
		titlePane.add(btnNewButton, BorderLayout.WEST);
		
		JPanel listPane = new JPanel();
		listPane.setBounds(20, 55, 973, 300);
		contentPane.add(listPane);
		listPane.setLayout(new BorderLayout(0, 0));
		
		js1 = new JScrollPane();
		listPane.add(js1);
		
		table = new JTable();
		js1.setViewportView(table);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(20, 371, 968, 247);
		contentPane.add(buttonPane);
		buttonPane.setLayout(null);
		
		searchPrivilege_Container = new JTextField();
		searchPrivilege_Container.setColumns(10);
		searchPrivilege_Container.setBounds(438, 151, 160, 21);
		buttonPane.add(searchPrivilege_Container);
		
		searchTable_Container = new JTextField();
		searchTable_Container.setColumns(10);
		searchTable_Container.setBounds(438, 115, 160, 21);
		buttonPane.add(searchTable_Container);
		
		searchUserRevoke_Container = new JTextField();
		searchUserRevoke_Container.setColumns(10);
		searchUserRevoke_Container.setBounds(438, 82, 160, 21);
		buttonPane.add(searchUserRevoke_Container);
		
		searchPrivilegeRevoke_Label = new JLabel("Privilege");
		searchPrivilegeRevoke_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchPrivilegeRevoke_Label.setBounds(363, 149, 70, 21);
		buttonPane.add(searchPrivilegeRevoke_Label);
		
		searchTableRevoke_Label = new JLabel("Table");
		searchTableRevoke_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchTableRevoke_Label.setBounds(363, 113, 43, 21);
		buttonPane.add(searchTableRevoke_Label);
		
		searchUserRevoke_Label = new JLabel("User");
		searchUserRevoke_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchUserRevoke_Label.setBounds(363, 80, 43, 21);
		buttonPane.add(searchUserRevoke_Label);
		
		lblRevokePrivilege = new JLabel("REVOKE PRIVILEGE");
		lblRevokePrivilege.setHorizontalAlignment(SwingConstants.CENTER);
		lblRevokePrivilege.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRevokePrivilege.setBounds(326, 0, 316, 72);
		buttonPane.add(lblRevokePrivilege);
		
		dropPrivilegeGrant_Label = new JLabel("Privilege");
		dropPrivilegeGrant_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dropPrivilegeGrant_Label.setBounds(36, 153, 75, 19);
		buttonPane.add(dropPrivilegeGrant_Label);
		
		searchTableGrant_Container = new JTextField();
		searchTableGrant_Container.setColumns(10);
		searchTableGrant_Container.setBounds(121, 113, 160, 21);
		buttonPane.add(searchTableGrant_Container);
		
		searchTableGrant_Label = new JLabel("Table");
		searchTableGrant_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchTableGrant_Label.setBounds(36, 119, 45, 13);
		buttonPane.add(searchTableGrant_Label);
		
		searchUserGrant_Container = new JTextField();
		searchUserGrant_Container.setBounds(121, 80, 160, 21);
		buttonPane.add(searchUserGrant_Container);
		searchUserGrant_Container.setColumns(10);
		
		JLabel searchUserGrant_Label = new JLabel("User");
		searchUserGrant_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchUserGrant_Label.setBounds(36, 78, 43, 21);
		buttonPane.add(searchUserGrant_Label);
		
		JLabel grantPrivilege_Label = new JLabel("GRANT PRIVILEGE");
		grantPrivilege_Label.setHorizontalAlignment(SwingConstants.CENTER);
		grantPrivilege_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		grantPrivilege_Label.setBounds(0, 0, 316, 70);
		buttonPane.add(grantPrivilege_Label);
		
		grantPrivilege_Button = new JButton("Grant");
		grantPrivilege_Button.addActionListener(ac);
		grantPrivilege_Button.setFont(new Font("Tahoma", Font.BOLD, 15));
		grantPrivilege_Button.setBounds(121, 200, 85, 21);
		buttonPane.add(grantPrivilege_Button);
		
		JButton revokePrivilege_Button = new JButton("Revoke");
		revokePrivilege_Button.addActionListener(ac);
		revokePrivilege_Button.setFont(new Font("Tahoma", Font.BOLD, 15));
		revokePrivilege_Button.setBounds(438, 200, 95, 21);
		buttonPane.add(revokePrivilege_Button);
		
		JPanel panelLoadUser = new JPanel();
		panelLoadUser.setBackground(new Color(255, 255, 255));
		panelLoadUser.setBounds(652, 142, 316, 105);
		buttonPane.add(panelLoadUser);
		panelLoadUser.setLayout(null);
		
		searchUser_Button = new JButton("Load");
		searchUser_Button.addActionListener(ac);;
		searchUser_Button.setBounds(110, 55, 100, 27);
		panelLoadUser.add(searchUser_Button);
		searchUser_Button.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		searchUser_Label = new JLabel("LOAD USER");
		searchUser_Label.setBounds(0, 0, 316, 58);
		panelLoadUser.add(searchUser_Label);
		searchUser_Label.setHorizontalAlignment(SwingConstants.CENTER);
		searchUser_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel panelRevoke = new JPanel();
		panelRevoke.setBackground(new Color(255, 255, 255));
		panelRevoke.setBounds(326, 0, 316, 247);
		buttonPane.add(panelRevoke);
		panelRevoke.setLayout(null);
		
		JPanel panelGrant = new JPanel();
		panelGrant.setBackground(Color.WHITE);
		panelGrant.setBounds(0, 0, 316, 247);
		buttonPane.add(panelGrant);
		panelGrant.setLayout(null);
		
		searchPrivGrant = new JTextField();
		searchPrivGrant.setColumns(10);
		searchPrivGrant.setBounds(121, 150, 160, 21);
		panelGrant.add(searchPrivGrant);
		
		JPanel panelSearch_1 = new JPanel();
		panelSearch_1.setLayout(null);
		panelSearch_1.setBackground(Color.WHITE);
		panelSearch_1.setBounds(652, 0, 316, 136);
		buttonPane.add(panelSearch_1);
		
		JButton searchPrivilege_Button = new JButton("Search");
		searchPrivilege_Button.addActionListener(ac);
		searchPrivilege_Button.setFont(new Font("Tahoma", Font.BOLD, 15));
		searchPrivilege_Button.setBounds(105, 99, 100, 27);
		panelSearch_1.add(searchPrivilege_Button);
		
		JLabel searchPrivilege_Label = new JLabel("SEARCHING");
		searchPrivilege_Label.setHorizontalAlignment(SwingConstants.CENTER);
		searchPrivilege_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		searchPrivilege_Label.setBounds(0, 0, 316, 58);
		panelSearch_1.add(searchPrivilege_Label);
		
		searchUserName_Label = new JLabel("User");
		searchUserName_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchUserName_Label.setBounds(30, 68, 43, 21);
		panelSearch_1.add(searchUserName_Label);
		
		userName_txt = new JTextField();
		userName_txt.setColumns(10);
		userName_txt.setBounds(120, 68, 160, 21);
		panelSearch_1.add(userName_txt);
		
		this.setJTableUser();
		this.setVisible(true);
	}
	
	public void toURMView() {
		this.parent.setVisible(true);
		this.dispose();
	}

	////////////////////////////////////////////////////////////////////////////////////////
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
			String sql = "SELECT GRANTEE, TABLE_NAME, PRIVILEGE FROM DBA_TAB_PRIVS";

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

	public void loadUser() {
		this.clearJTableUser();

		UserModel userModel = UserModel.getInstance("", "", "");

		Connection connection = JDBCUtil.getInstance("").getConnection(userModel);

		try {
			String sql = "select * from QLTTNV.VIEW_NHANVIEN";
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
					System.out.println(rowValue[i]);
				}
				dTModel.addRow(rowValue);
			}

			

			// Buoc 5: ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}
	
	
	public void search() {
	this.clearJTableUser();

	UserModel userModel = UserModel.getInstance("", "", "");

	Connection connection = JDBCUtil.getInstance("").getConnection(userModel);

	try {
		String sql = "select GRANTEE, TABLE_NAME, PRIVILEGE from DBA_TAB_PRIVS where GRANTEE = upper(?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, this.userName_txt.getText());
		
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

		this.userName_txt.setText("");


		// Buoc 5: ngat ket noi
		JDBCUtil.closeConnection(connection);
	} catch (SQLException err) {
		err.printStackTrace();
	}
}
	
	public void grantPriv() {
		this.clearJTableUser();

		UserModel userModel = UserModel.getInstance("", "", "");

		Connection connection = JDBCUtil.getInstance("").getConnection(userModel);

		try {
			String userName = this.searchUserGrant_Container.getText();
			String tableName = this.searchTableGrant_Container.getText();
			String priv = this.searchPrivGrant.getText();
			String sql = "GRANT " + priv + " ON QLTTNV." + tableName + " TO " + userName;
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
					System.out.println(rowValue[i]);
				}
				dTModel.addRow(rowValue);
			}

			this.searchUserGrant_Container.setText("");
			this.searchTableGrant_Container.setText("");
			this.searchPrivGrant.setText("");


			// Buoc 5: ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}

	public void revokePriv() {
		this.clearJTableUser();

		UserModel userModel = UserModel.getInstance("", "", "");

		Connection connection = JDBCUtil.getInstance("").getConnection(userModel);

		try {
			String userName = this.searchUserRevoke_Container.getText();
			String tableName = this.searchTable_Container.getText();
			String priv = this.searchPrivilege_Container.getText();
			String sql = "REVOKE " + priv + " ON QLTTNV." + tableName + " FROM " + userName;
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
					System.out.println(rowValue[i]);
				}
				dTModel.addRow(rowValue);
			}

			this.searchUserRevoke_Container.setText("");
			this.searchTable_Container.setText("");
			this.searchPrivilege_Container.setText("");


			// Buoc 5: ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}

	public static void main(String[] args) {
		UserModel userModel = UserModel.getInstance("system", "Hizumi6/2/2002", "xe");

		Connection connection = JDBCUtil.getInstance("xe").getConnection(userModel);

		if (connection == null) {
			System.out.println("Khong dang nhap thanh cong");
		} else {
			System.out.println("Dang nhap thanh cong");
			System.out.println("Hello world");
		}
		new UserPrivilegeList();
	}

	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		this.parent.destroyParent();
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
}
