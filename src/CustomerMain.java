import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMain frame = new CustomerMain();
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
	public CustomerMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 468);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO ASAP COURIERS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBackground(new Color(0, 0, 102));
		lblNewLabel.setBounds(10, 10, 496, 70);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(10, 70, 447, 16);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CustomerMain.class.getResource("/IMAGES/cust (1).jpeg")));
		lblNewLabel_1.setBounds(10, 112, 283, 256);
		contentPane.add(lblNewLabel_1);
		
		JTextPane txtpnWeProvideYou = new JTextPane();
		txtpnWeProvideYou.setBackground(new Color(51, 204, 204));
		txtpnWeProvideYou.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		txtpnWeProvideYou.setText(" WE PROVIDE YOU\r\n\r\n*Fast Delivery Services\r\n\r\n*Affordable Cost Of Service\r\n\r\n*Your Parcels Are Safe And Secure\r\n\r\n*Completeness Of Service From Door To Door\r\n\r\n*Adaptability to Loads");
		txtpnWeProvideYou.setBounds(307, 112, 268, 258);
		contentPane.add(txtpnWeProvideYou);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CProfile cp=new CProfile();
				cp.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(CustomerMain.class.getResource("/IMAGES/profile.jpeg")));
		btnNewButton.setBounds(515, 16, 85, 70);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Profile");
		lblNewLabel_2.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		lblNewLabel_2.setBounds(539, 96, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("View Status ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStatus vs=new ViewStatus();
				vs.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(51, 204, 204));
		btnNewButton_1.setBounds(10, 400, 122, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New Booking");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bookings b=new Bookings();
				b.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		btnNewButton_2.setBackground(new Color(51, 204, 204));
		btnNewButton_2.setBounds(168, 400, 110, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Bookings");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CViewBook cv=new CViewBook();
				cv.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_3.setBackground(new Color(51, 204, 204));
		btnNewButton_3.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		btnNewButton_3.setBounds(307, 400, 122, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Feedback");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Feedback f=new Feedback();
				f.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBackground(new Color(51, 204, 204));
		btnNewButton_4.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		btnNewButton_4.setBounds(459, 401, 116, 21);
		contentPane.add(btnNewButton_4);
	}
}
