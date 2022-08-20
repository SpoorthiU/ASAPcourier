import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class StaffMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffMain frame = new StaffMain();
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
	public StaffMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 446);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO ASAP COURIERS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(51, 10, 496, 70);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(21, 87, 553, 16);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staffprofile sp=new staffprofile();
				sp.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(StaffMain.class.getResource("/IMAGES/profile.jpeg")));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnNewButton.setBounds(484, 103, 78, 70);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(StaffMain.class.getResource("/IMAGES/right staff(1).jpeg")));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_1.setBounds(461, 266, 101, 122);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(StaffMain.class.getResource("/IMAGES/left staff(1).jpeg")));
		lblNewLabel_2.setBounds(21, 103, 121, 129);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Profile");
		lblNewLabel_3.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblNewLabel_3.setBounds(502, 183, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JTextPane txtpnBenefitsOfBeing = new JTextPane();
		txtpnBenefitsOfBeing.setBackground(new Color(51, 204, 204));
		txtpnBenefitsOfBeing.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		txtpnBenefitsOfBeing.setText("BENEFITS OF BEING A PART OF US\r\n\r\n          *Health Insurance\r\n\r\n          *Educational Assistance\r\n\r\n          *Free Transport\r\n\r\n          *Team Outings\r\n\r\n          *Job Security");
		txtpnBenefitsOfBeing.setBounds(174, 113, 258, 237);
		contentPane.add(txtpnBenefitsOfBeing);
		
		
		JButton btnNewButton_2 = new JButton("View Bookings");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SViewBook sv = new SViewBook();
				sv.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(51, 204, 204));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setBounds(147, 379, 121, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update Status");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStatus us=new UpdateStatus();
				us.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.setBackground(new Color(51, 204, 204));
		btnNewButton_3.setBounds(278, 379, 132, 21);
		contentPane.add(btnNewButton_3);
	}
}
