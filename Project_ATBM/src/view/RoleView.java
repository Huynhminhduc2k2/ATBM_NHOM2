package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.RoleController;
import database.JDBCUtil;
import model.UserModel;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class RoleView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Search;
	private JTextField textField_Name;
	private JTextField textField_Privilige;
	private JTextField textField_Table;
	private JTable table_role;
	private JTextField textField_SearchGrant;
	private JScrollPane js_search;
	private JTable table_search;
	private JScrollPane js_role;
	public RoleView() {
		this.init();
		this.setVisible(true);
	}
	public void init() {
		ActionListener ac = new RoleController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Role = new JPanel();
		panel_Role.setBounds(17, 172, 451, 312);
		contentPane.add(panel_Role);
		panel_Role.setLayout(null);
		
		js_role = new JScrollPane(table_role, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js_role.setBounds(10, 10, 431, 292);
		panel_Role.add(js_role);
		
		table_role = new JTable((TableModel) null);
		
		js_role.setColumnHeaderView(table_role);
		
		JPanel panel_ResultSearch = new JPanel();
		panel_ResultSearch.setBounds(478, 172, 367, 312);
		contentPane.add(panel_ResultSearch);
		panel_ResultSearch.setLayout(null);
		
		js_search = new JScrollPane(table_search, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js_search.setBounds(10, 10, 346, 292);
		panel_ResultSearch.add(js_search);
				
		String[] columnNames = { "Username" };
		Object[][] data = {};
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table_search = new JTable(model);
		js_search.setColumnHeaderView(table_search);
		panel_ResultSearch.add(js_search);
		
		JPanel panel_Grant = new JPanel();
		panel_Grant.setBounds(23, 40, 438, 122);
		contentPane.add(panel_Grant);
		panel_Grant.setLayout(null);
		
		JLabel lblNewLabel_Grant = new JLabel("Grant");
		lblNewLabel_Grant.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_Grant.setBounds(159, 4, 107, 25);
		panel_Grant.add(lblNewLabel_Grant);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Name.setBounds(229, 33, 173, 19);
		panel_Grant.add(textField_Name);
		textField_Name.setColumns(10);
		
		textField_Privilige = new JTextField();
		textField_Privilige.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Privilige.setBounds(229, 62, 173, 19);
		panel_Grant.add(textField_Privilige);
		textField_Privilige.setColumns(10);
		
		textField_Table = new JTextField();
		textField_Table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Table.setBounds(229, 91, 173, 19);
		panel_Grant.add(textField_Table);
		textField_Table.setColumns(10);
		
		JLabel lblNewLabel_Name = new JLabel("Name");
		lblNewLabel_Name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_Name.setBounds(159, 34, 45, 13);
		panel_Grant.add(lblNewLabel_Name);
		
		JLabel lblNewLabel_Privilige = new JLabel("Privilige");
		lblNewLabel_Privilige.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_Privilige.setBounds(159, 62, 72, 13);
		panel_Grant.add(lblNewLabel_Privilige);
		
		JLabel lblNewLabel_Table = new JLabel("Table");
		lblNewLabel_Table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_Table.setBounds(159, 94, 45, 13);
		panel_Grant.add(lblNewLabel_Table);
		
		JButton btnRevole = new JButton("Revoke");
		btnRevole.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRevole.setBounds(8, 67, 107, 34);
		panel_Grant.add(btnRevole);
		btnRevole.addActionListener(ac);
		
		JButton btnGrant = new JButton("Grant");
		btnGrant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGrant.setBounds(8, 26, 107, 33);
		panel_Grant.add(btnGrant);
		btnGrant.addActionListener(ac);
		
		JPanel panel_Search = new JPanel();
		panel_Search.setBounds(483, 40, 362, 104);
		contentPane.add(panel_Search);
		panel_Search.setLayout(null);
		
		JLabel lblNewLabel_Search = new JLabel("Search");
		lblNewLabel_Search.setBounds(159, 0, 60, 25);
		lblNewLabel_Search.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_Search.add(lblNewLabel_Search);
		
		textField_Search = new JTextField();
		textField_Search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Search.setBounds(153, 35, 199, 25);
		panel_Search.add(textField_Search);
		textField_Search.setColumns(10);
		
		JButton btnSearch = new JButton("Search Role");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBounds(10, 33, 118, 28);
		panel_Search.add(btnSearch);
		btnSearch.addActionListener(ac);
		
		textField_SearchGrant = new JTextField();
		textField_SearchGrant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_SearchGrant.setColumns(10);
		textField_SearchGrant.setBounds(153, 70, 199, 25);
		panel_Search.add(textField_SearchGrant);
		
		JButton btnSearchGrant = new JButton("Search Grant");
		btnSearchGrant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearchGrant.setBounds(10, 67, 118, 28);
		panel_Search.add(btnSearchGrant);
		btnSearchGrant.addActionListener(ac);
		
		JButton btnAllrole = new JButton("All Role");
		btnAllrole.setBounds(493, 143, 118, 25);
		contentPane.add(btnAllrole);
		btnAllrole.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("Role List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(383, 0, 135, 48);
		contentPane.add(lblNewLabel);
		btnAllrole.addActionListener(ac);
	}
	private void clearJTableRole() {
		DefaultTableModel model = (DefaultTableModel) table_role.getModel();
		model.setRowCount(0);
		table_role.repaint();
		js_role.revalidate();
	}
	private void clearJTableSearch() {
		DefaultTableModel model = (DefaultTableModel) table_search.getModel();
		model.setRowCount(0);
		table_search.repaint();
		js_search.revalidate();
	}
	
	public void LoadALLRole() {
		this.clearJTableRole();
		
		UserModel userModel = UserModel.getInstance("", "", "");

		Connection connection = JDBCUtil.getInstance("").getConnection(userModel);

		try {
			String sql = "SELECT role,role_id FROM DBA_ROLES";
			PreparedStatement st = connection.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel dTModel = (DefaultTableModel) table_role.getModel();

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
	public void findByRole() {
		this.clearJTableRole();
		
		UserModel userModel = UserModel.getInstance("", "", "");

		Connection connection = JDBCUtil.getInstance("").getConnection(userModel);

		try {
			String sql = "SELECT role,role_id FROM DBA_ROLES WHERE role = upper(?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, this.textField_Search.getText());

			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel dTModel = (DefaultTableModel) table_role.getModel();

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

	public void findGrantOfRole() {
		this.clearJTableSearch();
		
		UserModel userModel = UserModel.getInstance("", "", "");

		Connection connection = JDBCUtil.getInstance("").getConnection(userModel);

		try {
			String sql = "SELECT GRANTEE, PRIVILEGE, TABLE_NAME FROM DBA_TAB_PRIVS WHERE GRANTEE = upper(?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, this.textField_SearchGrant.getText());

			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel dTModel = (DefaultTableModel) table_search.getModel();

			int colCount = rsmd.getColumnCount();
			String[] colName = new String[colCount];
			for (int i = 0; i < colCount; i++) {
				colName[i] = rsmd.getColumnName(i + 1);
				System.out.println(colName[i]);
			}
			dTModel.setColumnIdentifiers(colName);
			
			System.out.println(colName);

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

	public void GrantRole() {
		
		UserModel userModel = UserModel.getInstance("", "", "");

		Connection connection = JDBCUtil.getInstance("").getConnection(userModel);

		try {
			String sql = "GRANT upper(?) ON upper(?) TO upper(?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, this.textField_Privilige.getText());
			st.setString(2, this.textField_Table.getText());
			st.setString(3, this.textField_Name.getText());
			
			st.executeQuery();			
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}
	public void RevokeGrantRole() {
		
		UserModel userModel = UserModel.getInstance("", "", "");

		Connection connection = JDBCUtil.getInstance("").getConnection(userModel);

		try {
			String sql = "REVOKE upper(?) ON upper(?) FROM upper(?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, this.textField_Privilige.getText());
			st.setString(2, this.textField_Table.getText());
			st.setString(3, this.textField_Name.getText());
			
			st.executeQuery();	
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}

	public static void main(String[] args) {
		UserModel userModel = UserModel.getInstance("pdb1_admin", "1", "xe");

		Connection connection = JDBCUtil.getInstance("pdb").getConnection(userModel);

		if (connection == null) {
			System.out.println("Khong dang nhap thanh cong");
		} else {
			System.out.println("Dang nhap thanh cong");
			System.out.println("Hello world");
		}
		new RoleView();
	}
}
