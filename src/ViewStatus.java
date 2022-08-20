import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ViewStatus extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStatus frame = new ViewStatus();
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
	public ViewStatus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 462);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LOAD CURRENT STATUS ");
		btnNewButton.setBackground(new Color(51, 204, 204));
		btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c;
				PreparedStatement p;
				ResultSet r;
				String driver="com.mysql.cj.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/asap_courier";
				String username="root";
				String password="";
				
				String Courier_id=textField.getText();
				try
				{
					String sql="Select * from status where Courier_id=?";
				        Class.forName(driver);
				        c= DriverManager.getConnection(url,username,password);
				        p=c.prepareStatement(sql);
				        p.setString(1, Courier_id);
				        r=p.executeQuery();
				        table.setModel(DbUtils.resultSetToTableModel(r));
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
		btnNewButton.setBounds(195, 228, 245, 33);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Enter Your Courier ID  :");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblNewLabel.setBounds(135, 34, 207, 33);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(new Color(102, 204, 204));
		textField.setBounds(352, 43, 123, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 271, 602, 98);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(51, 204, 204));
		scrollPane.setViewportView(table);
		
		btnNewButton_1 = new JButton("<--Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			CustomerMain cm= new CustomerMain();
			cm.setVisible(true);
			dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(51, 204, 204));
		btnNewButton_1.setBounds(10, 394, 79, 21);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ViewStatus.class.getResource("/IMAGES/bookingsblwhhhdijxo.jpg")));
		lblNewLabel_1.setBounds(216, 72, 200, 156);
		contentPane.add(lblNewLabel_1);
	}

}
