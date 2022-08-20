import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.LayoutManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CViewBook extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private Object FlowLayout;
	private JTable table;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CViewBook frame = new CViewBook();
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
	public CViewBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 496);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LOAD MY BOOKINGS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c;
				PreparedStatement p;
				ResultSet r;
				String driver="com.mysql.cj.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/asap_courier";
				String username="root";
				String password="";
				
				String Sender_id=textField.getText();
				try
				{
					String sql="Select * from courier where Sender_id=?";
				        Class.forName(driver);
				        c= DriverManager.getConnection(url,username,password);
				        p=c.prepareStatement(sql);
				        p.setString(1, Sender_id);
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
		btnNewButton.setBackground(new Color(51, 204, 204));
		btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnNewButton.setBounds(210, 229, 225, 29);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 299, 500, 94);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(51, 204, 204));
		scrollPane.setViewportView(table);
		
		btnNewButton_1 = new JButton("<--Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerMain sm= new CustomerMain();
				sm.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(51, 204, 204));
		btnNewButton_1.setBounds(10, 428, 85, 21);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("Enter Your ID :");
		lblNewLabel.setBackground(new Color(51, 204, 204));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblNewLabel.setBounds(180, 68, 124, 37);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(344, 79, 110, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CViewBook.class.getResource("/IMAGES/cour1 (1).png")));
		lblNewLabel_1.setBounds(66, 54, 500, 204);
		contentPane.add(lblNewLabel_1);
	}
	}

