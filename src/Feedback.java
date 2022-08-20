import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Feedback extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	 public JRadioButton rdbtnNewRadioButton;
	 public JRadioButton rdbtnNewRadioButton_1;
	 public JRadioButton rdbtnNewRadioButton_2;
	 public JRadioButton rdbtnNewRadioButton_3;
	 public JRadioButton rdbtnNewRadioButton_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedback frame = new Feedback();
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
	public Feedback() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 592);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("How was your experience?");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(174, 10, 396, 75);
		contentPane.add(lblNewLabel);
		
		JTextPane txtpnHelloUser = new JTextPane();
		txtpnHelloUser.setForeground(new Color(255, 255, 255));
		txtpnHelloUser.setBackground(new Color(51, 204, 204));
		txtpnHelloUser.setFont(new Font("Arial Black", Font.BOLD, 19));
		txtpnHelloUser.setText("                                           Hello user!\r\n                 we would love it if you could give us a review \r\n                           to make better of ourselves.\r\n");
		txtpnHelloUser.setBounds(21, 78, 701, 94);
		contentPane.add(txtpnHelloUser);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 309, 701, 75);
		contentPane.add(textPane);
		
		JLabel lblNewLabel_2 = new JLabel("Customer_id");
		lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblNewLabel_2.setBounds(208, 209, 105, 21);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(344, 213, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Courier_id");
		lblNewLabel_3.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblNewLabel_3.setBounds(208, 270, 105, 13);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(344, 270, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c;
				PreparedStatement p;
				ResultSet r;
				String driver="com.mysql.cj.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/asap_courier";
				String username="root";
				String password="";
				
			
				try
				{
					String sql="INSERT INTO `feedback` (`Comments`,`Customer_id`,`Courier_id`,`Rating`) values(?,?,?,?)";
					 
					       Class.forName(driver);
					        c= DriverManager.getConnection(url,username,password);
				            p=c.prepareStatement(sql);
				            p.setString(3, textField_1.getText());
				            p.setString(2, textField.getText());
				            p.setString(1, textPane.getText());
//				            int Rating=0;
//				            if(rdbtnNewRadioButton.isSelected()) {  
//		            				Rating=1;
//			        		}
//				            if(rdbtnNewRadioButton_1.isSelected()) {
//				        			Rating=2;
//				        			
//				        		}				            
//				            if(rdbtnNewRadioButton_2.isSelected()) {
//				        			Rating=3;
//				        			
//				        		}
//				            if(rdbtnNewRadioButton_3.isSelected()) {
//				        			Rating=4;
//				        			
//				        		}
//				            if(rdbtnNewRadioButton_4.isSelected()) {
//				        			Rating=5;
//				        		}
//				            p.setInt(4, Rating);
				            String Rating="";
				            if(e.getSource()==rdbtnNewRadioButton) {
				            	Rating="1";
				            	
				            }
				            else if(e.getSource()==rdbtnNewRadioButton_1) {
				            	Rating="2";
				            	
				            }
				            else if(e.getSource()==rdbtnNewRadioButton_2) {
				            	Rating="3";
				            	
				            }
				            else if(e.getSource()==rdbtnNewRadioButton_3) {
				            	Rating="4";
				            	
				            }
				            else if(e.getSource()==rdbtnNewRadioButton_4) {
				            	Rating="5";
				            	
				            }
				            p.setString(4, Rating);
				            p.executeUpdate();
					    	  JOptionPane.showMessageDialog(null, "THANKS FOR THE REVIEW!!");
					    	  CustomerMain cm=new CustomerMain();
					    	  cm.setVisible(true);
					    	  dispose();
				            }
				           	
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
		
		btnNewButton.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(51, 204, 204));
		btnNewButton.setBounds(309, 511, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Rate Us :");
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblNewLabel_1.setBounds(27, 422, 66, 21);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("1");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnNewRadioButton.setBackground(new Color(51, 204, 204));
		rdbtnNewRadioButton.setBounds(91, 449, 28, 29);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnNewRadioButton_1.setBackground(new Color(51, 204, 204));
		rdbtnNewRadioButton_1.setBounds(205, 449, 28, 29);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("3");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnNewRadioButton_2.setBackground(new Color(51, 204, 204));
		rdbtnNewRadioButton_2.setBounds(332, 449, 28, 29);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("4");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnNewRadioButton_3.setBackground(new Color(51, 204, 204));
		rdbtnNewRadioButton_3.setBounds(462, 449, 28, 29);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("5");
		rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnNewRadioButton_4.setBackground(new Color(51, 204, 204));
		rdbtnNewRadioButton_4.setBounds(578, 449, 28, 29);
		contentPane.add(rdbtnNewRadioButton_4);
		
		ButtonGroup group=new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_3);
		group.add(rdbtnNewRadioButton_4);
		
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(Feedback.class.getResource("/IMAGES/WhatsApp Image 2022-01-16 at 3.49.09 PM.jpeg")));
		lblNewLabel_4.setBounds(125, 407, 66, 57);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(Feedback.class.getResource("/IMAGES/WhatsApp Image 2022-01-16 at 3.49.49 PM.jpeg")));
		lblNewLabel_5.setBounds(239, 407, 79, 57);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(Feedback.class.getResource("/IMAGES/WhatsApp Image 2022-01-16 at 3.50.17 PM.jpeg")));
		lblNewLabel_6.setBounds(366, 407, 74, 57);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(Feedback.class.getResource("/IMAGES/WhatsApp Image 2022-01-16 at 3.50.39 PM.jpeg")));
		lblNewLabel_7.setBounds(496, 407, 74, 57);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(Feedback.class.getResource("/IMAGES/WhatsApp Image 2022-01-16 at 3.51.00 PM.jpeg")));
		lblNewLabel_8.setBounds(612, 407, 74, 57);
		contentPane.add(lblNewLabel_8);
		
		
		
	}
}

