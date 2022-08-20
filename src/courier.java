
//FEEDBACK WORKS! BUT RATING STAYS NULL
//FORGOR PASSWORD NOPE!!


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class courier extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	private JPasswordField passwordField;
	public static  String UserName;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courier frame = new courier();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});}


	/**
	 * Create the frame.
	 */
	public courier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(51, 204, 204));
		comboBox.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		comboBox.addItem("Staff");
		comboBox.addItem("Customer");
		comboBox.setSelectedItem(null);
		comboBox.setToolTipText("");
		comboBox.setBounds(411, 107, 115, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("LOGIN NAME");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel.setBounds(411, 153, 137, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(new Color(102, 204, 204));
		textField.setBounds(411, 184, 115, 19);
		contentPane.add(textField);
		System.out.println(UserName);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1.setBounds(414, 231, 115, 21);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(102, 204, 204));
		passwordField.setEchoChar('*');
		passwordField.setBounds(411, 262, 115, 19);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("forgot password?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fpassword fp=new fpassword();
				fp.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(51, 204, 204));
		btnNewButton.setBounds(493, 401, 127, 19);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LOGIN!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c;
				PreparedStatement p;
				ResultSet r;
				String driver="com.mysql.cj.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/asap_courier";
				String username="root";
				String password="";
				
				String role=comboBox.getSelectedItem().toString();
				UserName=textField.getText();
				String Password=String.valueOf(passwordField.getText());
				System.out.println(role+UserName+Password);
				try
				{
					String sql="Select * from login where role=? and UserName=? and Password=?";
					       Class.forName(driver);
					        c= DriverManager.getConnection(url,username,password);
				            p=c.prepareStatement(sql);
				            p.setString(1, role);
				            p.setString(2, UserName);
				            p.setString(3, Password);
				            r=p.executeQuery();
				            if(r.next())
				            {
				                JOptionPane.showMessageDialog(null, "Welcome!Successful Login");
				                if(role=="Staff") {
				                	StaffMain sm= new StaffMain();
				                	sm.setVisible(true);
				                	dispose();
				                }
				                else {
				                	CustomerMain cm= new CustomerMain();
				                	cm.setVisible(true);
				                	dispose();
				                }
				                
				            }
				            else
				            {
				                JOptionPane.showMessageDialog(null, "Invalid Username or Password\nUnsuccessful Login");

				            }
					        
					 }		
				catch(ClassNotFoundException cnfe)
				{
					System.out.println(cnfe);
				}
				catch(SQLException sqle)
				{
					System.out.println(sqle);
				}
					
			}});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(51, 204, 204));
		btnNewButton_1.setBounds(414, 310, 115, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel(" ASAP COURIER");
		lblNewLabel_3.setFont(new Font("Stencil", Font.BOLD, 42));
		lblNewLabel_3.setBounds(132, 10, 515, 66);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon(courier.class.getResource("/IMAGES/MASKBOY.jpeg")));
		lblNewLabel_2.setBounds(10, 41, 637, 432);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("sign up..");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				signup su=new signup();
				su.setVisible(true);
				dispose();
			}	
		});
		btnNewButton_2.setBackground(new Color(51, 204, 204));
		btnNewButton_2.setBounds(503, 430, 117, 19);
		contentPane.add(btnNewButton_2);
	}}
	
		





