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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

public class RoleView extends JFrame implements WindowListener {
	private URMView parent;
	private JPanel contentPane;
	private JTextField textField_Search;
	private JTextField textField_Name;
	private JTextField textField_Privilige;
	private JTextField textField_Table;
	private JTable table_role;
	private JTable table_search;
	private JScrollPane scrollPane_role,scrollPane_search;

	public RoleView(URMView urm) {
		this.init();
		this.parent = urm;
		this.setVisible(true);
	}
	public void init() {
		this.addWindowListener(this);
		ActionListener ac = new RoleController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Role = new JPanel();
		panel_Role.setBounds(10, 142, 451, 312);
		contentPane.add(panel_Role);
		panel_Role.setLayout(null);
		
		table_role = new JTable();
		table_role.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table_role.setBounds(10, 10, 431, 292);
		panel_Role.add(table_role);
		
		scrollPane_role = new JScrollPane();
		scrollPane_role.setBounds(0, 0, 451, 312);
		panel_Role.add(scrollPane_role);
		
		JPanel panel_ResultSearch = new JPanel();
		panel_ResultSearch.setBounds(478, 142, 380, 312);
		contentPane.add(panel_ResultSearch);
		panel_ResultSearch.setLayout(null);
		
		table_search = new JTable();
		table_search.setBounds(10, 10, 360, 302);
		panel_ResultSearch.add(table_search);
		
		scrollPane_search = new JScrollPane();
		scrollPane_search.setBounds(0, 0, 380, 312);
		panel_ResultSearch.add(scrollPane_search);
		
		JPanel panel_Grant = new JPanel();
		panel_Grant.setBounds(25, 10, 438, 122);
		contentPane.add(panel_Grant);
		panel_Grant.setLayout(null);
		
		JLabel lblNewLabel_Grant = new JLabel("GRANT");
		lblNewLabel_Grant.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_Grant.setBounds(159, 4, 107, 25);
		panel_Grant.add(lblNewLabel_Grant);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Name.setBounds(229, 33, 173, 19);
		panel_Grant.add(textField_Name);
		textField_Name.setColumns(10);
		
		textField_Privilige = new JTextField();
		textField_Privilige.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Privilige.setBounds(229, 67, 173, 19);
		panel_Grant.add(textField_Privilige);
		textField_Privilige.setColumns(10);
		
		textField_Table = new JTextField();
		textField_Table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Table.setBounds(229, 96, 173, 19);
		panel_Grant.add(textField_Table);
		textField_Table.setColumns(10);
		
		JLabel lblNewLabel_Name = new JLabel("Name");
		lblNewLabel_Name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_Name.setBounds(159, 34, 45, 13);
		panel_Grant.add(lblNewLabel_Name);
		
		JLabel lblNewLabel_Privilige = new JLabel("Privilige");
		lblNewLabel_Privilige.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_Privilige.setBounds(158, 68, 72, 13);
		panel_Grant.add(lblNewLabel_Privilige);
		
		JLabel lblNewLabel_Table = new JLabel("Table");
		lblNewLabel_Table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_Table.setBounds(159, 97, 45, 13);
		panel_Grant.add(lblNewLabel_Table);
		
		JButton btnRevole = new JButton("Revoke");
		btnRevole.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRevole.setBounds(8, 80, 107, 21);
		panel_Grant.add(btnRevole);
		btnRevole.addActionListener(ac);
		
		JButton btnGrant = new JButton("Grant");
		btnGrant.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGrant.setBounds(8, 37, 107, 21);
		panel_Grant.add(btnGrant);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(0, 0, 60, 23);
		btnNewButton.addActionListener(ac);
		
		panel_Grant.add(btnNewButton);
		btnGrant.addActionListener(ac);
		
		JPanel panel_Search = new JPanel();
		panel_Search.setBounds(478, 10, 362, 130);
		contentPane.add(panel_Search);
		panel_Search.setLayout(null);
		
		JLabel lblNewLabel_Search = new JLabel("SEARCH");
		lblNewLabel_Search.setBounds(159, 0, 90, 25);
		lblNewLabel_Search.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_Search.add(lblNewLabel_Search);
		
		textField_Search = new JTextField();
		textField_Search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Search.setBounds(153, 42, 199, 19);
		panel_Search.add(textField_Search);
		textField_Search.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(28, 40, 102, 21);
		panel_Search.add(btnSearch);
		btnSearch.addActionListener(ac);
		
		JButton btnAllrole = new JButton("All Role");
		btnAllrole.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAllrole.setBounds(28, 71, 102, 36);
		panel_Search.add(btnAllrole);
		btnAllrole.addActionListener(ac);
	}
	private void clearJTableRole() {
		DefaultTableModel model = (DefaultTableModel) table_role.getModel();
		model.setRowCount(0);
		table_role.repaint();
		scrollPane_role.revalidate();
	}
	private void clearJTableSearch() {
		DefaultTableModel model = (DefaultTableModel) table_search.getModel();
		model.setRowCount(0);
		table_search.repaint();
		scrollPane_search.revalidate();
	}

	private void setJTableRole() {
		this.clearJTableRole();

		UserModel userModel = UserModel.getInstance("", "", "");

		Connection connection = JDBCUtil.getInstance("").getConnection(userModel);

		try {
			String sql = "SELECT GRANTEE,PRIVILEGE FROM DBA_TAB_PRIVS;";

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
		this.clearJTableSearch();

		UserModel userModel = UserModel.getInstance("", "", "");

		Connection connection = JDBCUtil.getInstance("").getConnection(userModel);

		try {
			String sql = "SELECT GRANTEE,PRIVILEGE FROM DBA_TAB_PRIVS WHERE GRANTEE = upper(?)";
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

			this.textField_Search.setText("");

			// Buoc 5: ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}
	public void toURMView() {
		this.parent.setVisible(true);
		this.dispose();
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.parent.destroyParent();
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
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
