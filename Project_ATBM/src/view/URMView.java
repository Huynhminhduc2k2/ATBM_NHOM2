package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.URMController;

public class URMView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table_1;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					URMView frame = new URMView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public URMView() {
		ActionListener ac = new URMController(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
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

		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Find");
		panel_4.add(btnNewButton);

		table = new JTable();
		table.setBounds(0, 72, 268, 444);
		panel_1.add(table);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(268, 72, 119, 444);
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("User name:");
		lblNewLabel_3.setBounds(0, 2, 119, 55);
		panel_5.add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setBounds(0, 51, 119, 20);
		panel_5.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Password:");
		lblNewLabel_4.setBounds(0, 76, 119, 55);
		panel_5.add(lblNewLabel_4);

		textField_2 = new JTextField();
		textField_2.setBounds(0, 122, 119, 20);
		panel_5.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_1 = new JButton("Create user");
		btnNewButton_1.setBounds(0, 166, 119, 55);
		panel_5.add(btnNewButton_1);
		btnNewButton_1.addActionListener(ac);

		JButton btnNewButton_2 = new JButton("Delete user");
		btnNewButton_2.setBounds(0, 240, 119, 55);
		panel_5.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Change password");
		btnNewButton_3.setBounds(0, 314, 119, 55);
		panel_5.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("User's privileges");
		btnNewButton_4.setBounds(0, 387, 119, 55);
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

		JButton btnNewButton_5 = new JButton("Find");
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
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6.setBounds(0, 166, 119, 55);
		panel_8.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Delete role");
		btnNewButton_7.setBounds(0, 240, 119, 55);
		panel_8.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("Change password");
		btnNewButton_8.setBounds(0, 314, 119, 55);
		panel_8.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("Role's privileges");
		btnNewButton_9.setBounds(0, 387, 119, 55);
		panel_8.add(btnNewButton_9);
	}

}
