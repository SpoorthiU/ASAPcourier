import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class fpassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fpassword frame = new fpassword();
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
	public fpassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 518);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter UserName");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel.setBounds(42, 119, 291, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(new Color(102, 204, 204));
		textField.setBounds(152, 155, 156, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Create New Password");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1.setBounds(42, 200, 212, 19);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(102, 204, 204));
		textField_1.setBounds(152, 247, 156, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm Password");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_2.setBounds(42, 293, 179, 19);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Save changes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c;
				PreparedStatement p;
				ResultSet r;
				String driver="com.mysql.cj.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/asap_courier";
				String username="root";
				String password="";
				
				String user=textField.getText();
				String pass=String.valueOf(textField_1.getText());
				//String pass1=String.valueOf(textField_2.getText());
				try {
					        Class.forName(driver);
					        c= DriverManager.getConnection(url,username,password);
					        String sql="UPDATE `login` SET `Password`=? WHERE `UserName`=?";
				            p=c.prepareStatement(sql);
				            p.setString(1,textField.getText());
				            p.setString(2,textField_1.getText());
				           
				            //p.setString(3,String.valueOf(textField_2.getText()));
				            p.executeUpdate();
//				            System.out.println(pass);
					    	JOptionPane.showMessageDialog(null, "password changed successfully");
				            c.close(); 
					 }	
				catch(ClassNotFoundException cnfe)
				{
					System.out.println(cnfe);
				}
				catch(SQLException sqle)
				{
					System.out.println(sqle);
				}
				courier c1=new courier();
		    	  c1.setVisible(true);
		    	   dispose();
			}
		});
		btnNewButton.setBackground(new Color(51, 204, 204));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 10));
		btnNewButton.setBounds(110, 386, 125, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Forgot Password?");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setBackground(new Color(51, 204, 204));
		lblNewLabel_3.setBounds(192, 24, 156, 55);
		contentPane.add(lblNewLabel_3);
		
		JTextPane txtpnForYourPassword = new JTextPane();
		txtpnForYourPassword.setForeground(new Color(255, 0, 0));
		txtpnForYourPassword.setBackground(new Color(51, 204, 204));
		txtpnForYourPassword.setFont(new Font("Arial", Font.PLAIN, 13));
		txtpnForYourPassword.setText("For your password to be up to the latest security standards, please make sure to consider the following aspects when creating your password .\r\n*)The password should consists of a minimum of 8 characters .\r\n*)It should include capital and lower case letters and atleast a special character.\r\n*)Include combination of the characters mentioned above.");
		txtpnForYourPassword.setBounds(370, 130, 156, 296);
		contentPane.add(txtpnForYourPassword);
		txtpnForYourPassword.setEditable(false);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(102, 204, 204));
		passwordField.setBounds(152, 341, 156, 19);
		contentPane.add(passwordField);
	}
}
