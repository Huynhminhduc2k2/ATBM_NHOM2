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
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Role extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Role frame = new Role();
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
	public Role() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 142, 438, 312);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 21, 418, 281);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(458, 142, 400, 312);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 20, 366, 282);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(25, 10, 423, 122);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Grant");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(158, 10, 107, 13);
		panel_3.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(229, 33, 173, 19);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(229, 67, 173, 19);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(229, 96, 173, 19);
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(159, 34, 45, 13);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Privilige");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(158, 68, 72, 13);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Table");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(159, 97, 45, 13);
		panel_3.add(lblNewLabel_4);
		
		JButton btnNewButton_5_1 = new JButton("Revole Role");
		btnNewButton_5_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_5_1.setBounds(8, 80, 107, 21);
		panel_3.add(btnNewButton_5_1);
		
		JButton btnNewButton_4_1 = new JButton("Grant Role");
		btnNewButton_4_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_4_1.setBounds(8, 37, 107, 21);
		panel_3.add(btnNewButton_4_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(478, 10, 362, 130);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setBounds(159, 0, 60, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(153, 42, 199, 19);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Search role");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setBounds(28, 40, 102, 21);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("All Role");
		btnNewButton_1.setBounds(28, 71, 102, 36);
		panel_2.add(btnNewButton_1);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
