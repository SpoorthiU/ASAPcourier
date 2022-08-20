import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Bookings extends JFrame {

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
					Bookings frame = new Bookings();
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
	public Bookings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 491);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Bookings.class.getResource("/IMAGES/booking (1).jpeg")));
		lblNewLabel.setBounds(0, 10, 319, 336);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Courier_id :");
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblNewLabel_1.setBounds(329, 94, 82, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Weight :");
		lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblNewLabel_2.setBounds(329, 138, 108, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date :");
		lblNewLabel_3.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblNewLabel_3.setBounds(334, 177, 77, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Amount :");
		lblNewLabel_4.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblNewLabel_4.setBounds(329, 200, 77, 37);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Receiver Name :");
		lblNewLabel_5.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblNewLabel_5.setBounds(329, 290, 121, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Receiver Address :");
		lblNewLabel_6.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblNewLabel_6.setBounds(94, 346, 152, 13);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(452, 94, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(452, 138, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(452, 179, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(452, 212, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(452, 290, 96, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(229, 346, 319, 32);
		contentPane.add(textPane);
		
		JButton btnNewButton = new JButton("Confirm Booking");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c;
				PreparedStatement p;
				ResultSet r;
				String driver="com.mysql.cj.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/asap_courier";
				String username="root";
				String password="";
				
				String Courid=textField.getText();
				String Sender_id=textField_5.getText();
				String weight=textField_1.getText();
				String amount=textField_3.getText();
				String date=textField_2.getText();
				String Recname=textField_4.getText();
				String recadd=textPane.getText();
				try
				{
					String sql="insert into courier values(?,?,?,?,?,?,?)";
					 
					       Class.forName(driver);
					        c= DriverManager.getConnection(url,username,password);
				            p=c.prepareStatement(sql);
				            p.setString(1, textField.getText());
				            p.setString(7, textField_5.getText());
				            p.setString(2, textField_1.getText());
				            p.setString(3, textField_2.getText());
				            p.setString(4, textField_3.getText());
				            p.setString(5,textField_4.getText());
				            p.setString(6,textPane.getText());
				            int xr=p.executeUpdate();
				            if(xr!=0){
					    	  JOptionPane.showMessageDialog(null, "THANK YOU!!!\n your Bookings has been confirmed");
					    	  CustomerMain cm=new CustomerMain();
					    	  cm.setVisible(true);
					    	  dispose();
				            }
				            else {
				            	 JOptionPane.showMessageDialog(null,"Booking failed");
				             
					 }}	
				catch(ClassNotFoundException cnfe)
				{
					System.out.println(cnfe);
				}
				catch(SQLException sqle)
				{
					System.out.println(sqle);
				}
				CustomerMain cm=new CustomerMain();
				cm.setVisible(true);
				dispose();
				
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(51, 204, 204));
		btnNewButton.setBounds(234, 410, 139, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Courier Booking");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Segoe UI Light", Font.BOLD, 25));
		lblNewLabel_7.setBounds(356, 10, 213, 32);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("<-- back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerMain cm=new CustomerMain();
				cm.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBackground(new Color(51, 204, 204));
		btnNewButton_1.setBounds(10, 423, 96, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("Sender_id : ");
		lblNewLabel_8.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblNewLabel_8.setBounds(339, 253, 82, 13);
		contentPane.add(lblNewLabel_8);
		
		textField_5 = new JTextField();
		textField_5.setBounds(452, 253, 96, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}
}
