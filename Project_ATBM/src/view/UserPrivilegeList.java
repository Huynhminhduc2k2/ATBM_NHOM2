package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.UserPrivilegesController;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import view.URMView;

public class UserPrivilegeList extends JFrame implements WindowListener {
	private URMView parent;
	private JPanel contentPane;
	private JPanel titlePane;
	private JTextField listPrivilege_Container;
	private JTextField fieldUser;
	private JTextField fieldRevoke;
	private JTextField fieldGrant;
	private JButton grantPrivilege_Button;
	private JTextField fieldLoad;
	private JButton searchUser_Button;
	private JButton loadPrivileges_Button;
	private JTextField searchUserGrant_Container;
	private JLabel searchTableGrant_Label;
	private JTextField searchTableGrant_Container;
	private JLabel dropPrivilegeGrant_Label;
	private JLabel dropOptionGrant_Label;
	private JLabel lblRevokePrivilege;
	private JLabel searchUser_Label;
	private JLabel loadPrivilege_Label;
	private JLabel searchUserRevoke_Label;
	private JLabel searchTableRevoke_Label;
	private JLabel searchPrivilegeRevoke_Label;
	private JTextField searchUserRevoke_Container;
	private JTextField searchTable_Container;
	private JTextField searchPrivilege_Container;
	private JTextField searchUser_Container;
	private JButton btnNewButton;

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

	/**
	 * Create the frame.
	 */
	public UserPrivilegeList(URMView urm) {
		this.parent = urm;
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
		
		listPrivilege_Container = new JTextField();
		listPrivilege_Container.setColumns(10);
		listPane.add(listPrivilege_Container, BorderLayout.CENTER);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(20, 371, 968, 247);
		contentPane.add(buttonPane);
		buttonPane.setLayout(null);
		
		searchUser_Container = new JTextField();
		searchUser_Container.setColumns(10);
		searchUser_Container.setBounds(730, 49, 160, 21);
		buttonPane.add(searchUser_Container);
		
		searchPrivilege_Container = new JTextField();
		searchPrivilege_Container.setColumns(10);
		searchPrivilege_Container.setBounds(435, 113, 160, 21);
		buttonPane.add(searchPrivilege_Container);
		
		searchTable_Container = new JTextField();
		searchTable_Container.setColumns(10);
		searchTable_Container.setBounds(435, 82, 160, 21);
		buttonPane.add(searchTable_Container);
		
		searchUserRevoke_Container = new JTextField();
		searchUserRevoke_Container.setColumns(10);
		searchUserRevoke_Container.setBounds(435, 49, 160, 21);
		buttonPane.add(searchUserRevoke_Container);
		
		searchPrivilegeRevoke_Label = new JLabel("Privilege");
		searchPrivilegeRevoke_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchPrivilegeRevoke_Label.setBounds(360, 111, 70, 21);
		buttonPane.add(searchPrivilegeRevoke_Label);
		
		searchTableRevoke_Label = new JLabel("Table");
		searchTableRevoke_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchTableRevoke_Label.setBounds(360, 80, 43, 21);
		buttonPane.add(searchTableRevoke_Label);
		
		searchUserRevoke_Label = new JLabel("User");
		searchUserRevoke_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchUserRevoke_Label.setBounds(360, 47, 43, 21);
		buttonPane.add(searchUserRevoke_Label);
		
		loadPrivilege_Label = new JLabel("LOAD PRIVILEGES");
		loadPrivilege_Label.setHorizontalAlignment(SwingConstants.CENTER);
		loadPrivilege_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		loadPrivilege_Label.setBounds(652, 133, 316, 40);
		buttonPane.add(loadPrivilege_Label);
		
		searchUser_Label = new JLabel("SEARCHING USER");
		searchUser_Label.setHorizontalAlignment(SwingConstants.CENTER);
		searchUser_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		searchUser_Label.setBounds(652, 0, 316, 40);
		buttonPane.add(searchUser_Label);
		
		lblRevokePrivilege = new JLabel("REVOKE PRIVILEGE");
		lblRevokePrivilege.setHorizontalAlignment(SwingConstants.CENTER);
		lblRevokePrivilege.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRevokePrivilege.setBounds(326, 0, 316, 40);
		buttonPane.add(lblRevokePrivilege);
		
		dropOptionGrant_Label = new JLabel("Option");
		dropOptionGrant_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dropOptionGrant_Label.setBounds(35, 146, 75, 19);
		buttonPane.add(dropOptionGrant_Label);
		
		dropPrivilegeGrant_Label = new JLabel("Privilege");
		dropPrivilegeGrant_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dropPrivilegeGrant_Label.setBounds(35, 115, 75, 19);
		buttonPane.add(dropPrivilegeGrant_Label);
		
		JComboBox dropOptionGrant_Container = new JComboBox();
		dropOptionGrant_Container.setBounds(120, 147, 160, 21);
		buttonPane.add(dropOptionGrant_Container);
		
		JComboBox dropPrivilegeGrant_Container = new JComboBox();
		dropPrivilegeGrant_Container.setBounds(120, 113, 160, 21);
		buttonPane.add(dropPrivilegeGrant_Container);
		
		searchTableGrant_Container = new JTextField();
		searchTableGrant_Container.setColumns(10);
		searchTableGrant_Container.setBounds(120, 82, 160, 21);
		buttonPane.add(searchTableGrant_Container);
		
		searchTableGrant_Label = new JLabel("Table");
		searchTableGrant_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchTableGrant_Label.setBounds(35, 88, 45, 13);
		buttonPane.add(searchTableGrant_Label);
		
		searchUserGrant_Container = new JTextField();
		searchUserGrant_Container.setBounds(120, 49, 160, 21);
		buttonPane.add(searchUserGrant_Container);
		searchUserGrant_Container.setColumns(10);
		
		JLabel searchUserGrant_Label = new JLabel("User");
		searchUserGrant_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchUserGrant_Label.setBounds(35, 47, 43, 21);
		buttonPane.add(searchUserGrant_Label);
		
		JLabel grantPrivilege_Label = new JLabel("GRANT PRIVILEGE");
		grantPrivilege_Label.setHorizontalAlignment(SwingConstants.CENTER);
		grantPrivilege_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		grantPrivilege_Label.setBounds(0, 0, 316, 40);
		buttonPane.add(grantPrivilege_Label);
		
		loadPrivileges_Button = new JButton("Load");
		loadPrivileges_Button.setFont(new Font("Tahoma", Font.BOLD, 15));
		loadPrivileges_Button.setBounds(770, 200, 85, 21);
		buttonPane.add(loadPrivileges_Button);
		
		searchUser_Button = new JButton("Search");
		searchUser_Button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchUser_Button.setBounds(770, 80, 85, 21);
		buttonPane.add(searchUser_Button);
		
		grantPrivilege_Button = new JButton("Grant");
		grantPrivilege_Button.setFont(new Font("Tahoma", Font.BOLD, 15));
		grantPrivilege_Button.setBounds(110, 200, 85, 21);
		buttonPane.add(grantPrivilege_Button);
		
		JButton revokePrivilege_Button = new JButton("Revoke");
		revokePrivilege_Button.setFont(new Font("Tahoma", Font.BOLD, 15));
		revokePrivilege_Button.setBounds(435, 200, 95, 21);
		buttonPane.add(revokePrivilege_Button);
		
		fieldUser = new JTextField();
		fieldUser.setColumns(10);
		fieldUser.setBounds(652, 0, 316, 120);
		buttonPane.add(fieldUser);
		
		fieldRevoke = new JTextField();
		fieldRevoke.setColumns(10);
		fieldRevoke.setBounds(326, 0, 316, 247);
		buttonPane.add(fieldRevoke);
		
		fieldGrant = new JTextField();
		fieldGrant.setColumns(10);
		fieldGrant.setBounds(0, 0, 316, 247);
		buttonPane.add(fieldGrant);
		
		fieldLoad = new JTextField();
		fieldLoad.setColumns(10);
		fieldLoad.setBounds(652, 127, 316, 120);
		buttonPane.add(fieldLoad);
		
		this.setVisible(true);
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
