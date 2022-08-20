import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class SViewBook extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	DefaultTableModel model = new DefaultTableModel();
//	Container cnt=this.getContentPane();
//	JTable jtbl=new JTable(model);

	private Object FlowLayout;
	private JTable table;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SViewBook frame = new SViewBook();
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

	
	public SViewBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("load Bookings");
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
				try
				{
					String sql="Select * from courier";
				        Class.forName(driver);
				        c= DriverManager.getConnection(url,username,password);
				        p=c.prepareStatement(sql);
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
		btnNewButton.setBounds(197, 213, 224, 21);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 262, 595, 130);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(51, 204, 204));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("<--Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffMain cm = new StaffMain();
				cm.setVisible(true);
				dispose();
						
			}
		});
		btnNewButton_1.setBackground(new Color(51, 204, 204));
		btnNewButton_1.setBounds(10, 10, 83, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SViewBook.class.getResource("/IMAGES/cour1 (1).png")));
		lblNewLabel.setBounds(59, 34, 500, 196);
		contentPane.add(lblNewLabel);
		
		
	
		}
	}

