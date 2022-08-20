
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CProfile extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton_5;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	DefaultTableModel model;
	private JTextField textField_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CProfile frame = new CProfile();
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
	public CProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 447);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("<--back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerMain cm=new CustomerMain();
				cm.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(51, 204, 204));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(10, 379, 85, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("View My Details");
		btnNewButton_1.addActionListener(new ActionListener() {
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
					Class.forName(driver);
		            Connection con=DriverManager.getConnection(url,username,password);
		            String sql="SELECT * from `customer` where `Customer_id`=?";
		            p=con.prepareStatement(sql);
		            p.setInt(1, Integer.parseInt(textField_5.getText()));
			        r=p.executeQuery();
			        table.setModel(DbUtils.resultSetToTableModel(r));
//			            if(r.next())
//			            {
//			                textField.setText(r.getString("CName"));
//			                textField_2.setText(r.getString("CPoneNum"));
//			                textField_3.setText(r.getString("CEmail"));
//			                textField_4.setText(r.getString("Address"));
//			                textField_1.setText(r.getString("Customer_id"));
//			               
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
		btnNewButton_1.setBackground(new Color(51, 204, 204));
		btnNewButton_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnNewButton_1.setBounds(331, 23, 186, 21);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Update  Details");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i =table.getSelectedRow();
				if(i>=0) {
				Connection c;
				PreparedStatement p;
				ResultSet r;
				String driver="com.mysql.cj.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/asap_courier";
				String username="root";
				String password="";
				  try
			        {
					  Class.forName(driver);
			            Connection con=DriverManager.getConnection(url,username,password);
			            String sql="UPDATE `customer` SET `CName`=?, `CPhoneNum`=?,  `CEmail`=?, `CAddress`=?, `CPassword`=? WHERE `Customer_id`=?";
			            p=con.prepareStatement(sql);
			            p.setString(1, textField_1.getText());
			            p.setInt(6, Integer.parseInt(textField.getText()));
			            p.setInt(2,Integer.parseInt(textField_2.getText()));
			            p.setString(3,textField_3.getText());
			            p.setString(4,textField_4.getText());
			            p.setString(5,textField_6.getText());
			            p.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Update successful");
			            con.close();
			        }
			        catch(Exception e1)
			        {
			           JOptionPane.showMessageDialog(null, e1);
			            
			        }
				}
				  else {
					  JOptionPane.showMessageDialog(null,"Select your row to update!");
				  }
				
			}
		});
		btnNewButton_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnNewButton_2.setBackground(new Color(51, 204, 204));
		btnNewButton_2.setBounds(211, 356, 158, 21);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Insert more");
		Object[] row1=new Object[5];
		btnNewButton_3.addActionListener(new ActionListener() {
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
					  Class.forName(driver);
			            Connection con=DriverManager.getConnection(url,username,password);
			            String sql="INSERT INTO `customer` (`Customer_id`,`CName`,`CPhoneNum`,`CEmail`,`CAddress`,`CPassword`) values(?,?,?,?,?,?)";
			            p=con.prepareStatement(sql);
			            p.setString(2, textField_1.getText());
			            p.setInt(1, Integer.parseInt(textField.getText()));
			            p.setInt(3,Integer.parseInt(textField_2.getText()));
			            p.setString(4,textField_3.getText());
			            p.setString(5,textField_4.getText());
			            p.setString(6,textField_6.getText());
			            p.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Insertion successful");
			            con.close();
			        }
			        catch(Exception e1)
			        {
			           JOptionPane.showMessageDialog(null, e1);
			            
			        }
			}
		});
		btnNewButton_3.setBackground(new Color(51, 204, 204));
		btnNewButton_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnNewButton_3.setBounds(211, 311, 158, 21);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Delete Details");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
				Connection c;
				PreparedStatement p;
				ResultSet r;
				String driver="com.mysql.cj.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/asap_courier";
				String username="root";
				String password="";
				  try
			        {
					  Class.forName(driver);
			            Connection con=DriverManager.getConnection(url,username,password);
			            String sql="DELETE FROM `customer` WHERE `Customer_id`=?";
			            p=con.prepareStatement(sql);
			            p.setInt(1, Integer.parseInt(textField.getText()));
			            int n=p.executeUpdate();
			            if(n==1)
			            {
			                JOptionPane.showMessageDialog(null, "Record deleted");
			        }
			            else
			            {
			               JOptionPane.showMessageDialog(null, "No Record found");  
			        }
			            con.close();
			        }
			        catch(Exception e1)
			        {
			           JOptionPane.showMessageDialog(null, e1);
			            
			        }
			model.removeRow(i);
			}
				else {
					JOptionPane.showMessageDialog(null,"Select your details");
				}
			}
		});
		btnNewButton_4.setBackground(new Color(51, 204, 204));
		btnNewButton_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnNewButton_4.setBounds(49, 311, 139, 21);
		contentPane.add(btnNewButton_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(CProfile.class.getResource("/IMAGES/cprof (1).png")));
		lblNewLabel_5.setBounds(402, 160, 206, 212);
		contentPane.add(lblNewLabel_5);
		
		btnNewButton_5 = new JButton("Clear");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_6.setText("");
			}
		});
		btnNewButton_5.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnNewButton_5.setBackground(new Color(51, 204, 204));
		btnNewButton_5.setBounds(49, 356, 139, 21);
		contentPane.add(btnNewButton_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int i= table.getSelectedRow();
			
				textField.setText(model.getValueAt(i, 0).toString());
				textField_1.setText(model.getValueAt(i, 1).toString());
				textField_2.setText(model.getValueAt(i, 2).toString());
				textField_3.setText(model.getValueAt(i, 3).toString());
				textField_4.setText(model.getValueAt(i, 4).toString());
				textField_6.setText(model.getValueAt(i, 5).toString());
			}
		});
		scrollPane.setBounds(21, 54, 587, 40);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int i= table.getSelectedRow();
			
				textField.setText(model.getValueAt(i, 0).toString());
				textField_1.setText(model.getValueAt(i, 1).toString());
				textField_2.setText(model.getValueAt(i, 2).toString());
				textField_3.setText(model.getValueAt(i, 3).toString());
				textField_4.setText(model.getValueAt(i, 4).toString());
				textField_6.setText(model.getValueAt(i, 5).toString());
			}
		});
		model= new DefaultTableModel();
		Object[] column= {"Customer_id", "CName", "CPhoneNum", "CEmail", "CAddress","CPassword"};
		Object[] row=new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Customer_id", "CName", "CPhoneNum", "CEmail", "CAddress", "CPassword"
			}
		));
		table.setBackground(new Color(51, 204, 204));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Customer_id:");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel.setBounds(61, 108, 110, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CName:");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(71, 139, 79, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CPhoneNum:");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(64, 183, 104, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CEmail:");
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(64, 214, 96, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CAddress:");
		lblNewLabel_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(64, 253, 96, 21);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBackground(new Color(102, 204, 204));
		textField.setBounds(186, 113, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(102, 204, 204));
		textField_1.setBounds(186, 148, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(102, 204, 204));
		textField_2.setBounds(186, 185, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(102, 204, 204));
		textField_3.setBounds(186, 216, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(102, 204, 204));
		textField_4.setBounds(186, 255, 96, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(102, 204, 204));
		textField_5.setBounds(148, 26, 96, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		lblNewLabel_6 = new JLabel("CPassword:");
		lblNewLabel_6.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_6.setBackground(new Color(51, 204, 204));
		lblNewLabel_6.setBounds(71, 288, 79, 13);
		contentPane.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(102, 204, 204));
		textField_6.setBounds(186, 286, 96, 19);
		contentPane.add(textField_6);
		}}
	
		


