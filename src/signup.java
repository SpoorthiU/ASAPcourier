import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class signup extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 508);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial Black", Font.BOLD, 13));
		comboBox.setBackground(new Color(51, 204, 204));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"STAFF", "CUSTOMER"}));
		comboBox.setBounds(265, 78, 110, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("UserName :");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel.setBounds(181, 122, 118, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(new Color(102, 204, 204));
		textField.setBounds(374, 121, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_1.setBackground(new Color(51, 204, 204));
		lblNewLabel_1.setBounds(103, 166, 118, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("PhoneNumber :");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_3.setBounds(158, 179, 118, 13);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(102, 204, 204));
		textField_3.setBounds(374, 178, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Set Password :");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_4.setBounds(168, 244, 119, 13);
		contentPane.add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(102, 204, 204));
		passwordField.setBounds(374, 243, 96, 19);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c;
				PreparedStatement p;
				ResultSet r;
				String driver="com.mysql.cj.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/asap_courier";
				String username="root";
				String password="";
				String role=comboBox.getSelectedItem().toString();
				String UserName=textField.getText();
				String PhoneNumber=textField_3.getText();
				String setpassword=String.valueOf(passwordField.getText());
				System.out.println(role+UserName+setpassword);
				try
				{
					String sql="Insert into  login values (?,?,?,?)";
				       Class.forName(driver);
				       Class.forName(driver);
				        c= DriverManager.getConnection(url,username,password);
				        p=c.prepareStatement(sql);
				        p.setString(1,comboBox.getSelectedItem().toString());
			            p.setString(2, textField.getText());
			            p.setString(3, textField_3.getText());
			            p.setString(4, String.valueOf(passwordField.getText()));
			            
			            int x=p.executeUpdate();
			            if(x!=0)
			            {
			                JOptionPane.showMessageDialog(null, "Welcome!!\n Successfully registered");
			                courier c1=new courier();
			                c1.setVisible(true);
			                dispose();
			            }
			            else
			            {
			                JOptionPane.showMessageDialog(null, "Unsuccessful Registration");

			            }}			
			catch(ClassNotFoundException cnfe)
			{
				System.out.println(cnfe);
			}
			catch(SQLException sqle)
			{
				System.out.println(sqle);
			}
				
		}
		});
		btnNewButton.setBackground(new Color(51, 204, 204));
		btnNewButton.setBounds(265, 421, 85, 21);
		contentPane.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("I hereby agree to the terms and conditions. ");
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					btnNewButton.enable();
				}
				else {
					btnNewButton.disable();
					JOptionPane.showMessageDialog(null, "please agree to out terms to continue!!");
				}
			}
		});
		chckbxNewCheckBox.setFont(new Font("Arial Black", Font.PLAIN, 15));
		chckbxNewCheckBox.setBackground(new Color(51, 204, 204));
		chckbxNewCheckBox.setBounds(135, 370, 416, 21);
		contentPane.add(chckbxNewCheckBox);
		
		
		JLabel lblNewLabel_5 = new JLabel("New Here?SignUp Now!!");
		lblNewLabel_5.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(128, 20, 438, 34);
		contentPane.add(lblNewLabel_5);
	}
}
