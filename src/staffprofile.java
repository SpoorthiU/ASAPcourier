import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class staffprofile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JLabel lblNewLabel_4;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField_4;
	DefaultTableModel model;
	private JLabel lblNewLabel_5;
	private JTextField textField_5;
	
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staffprofile frame = new staffprofile();
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
	public staffprofile() {
//		Connection c;
//		String driver="com.mysql.cj.jdbc.Driver";
//		String url="jdbc:mysql://localhost:3306/asap_courier";
//		String username="root";
//		String password="";
//	
//		String id="";
//		String ph="";
//		String mail="";
//		String Name="";
//		
//		
//		try
//		{
//			String sql="SELECT * FROM `staff` WHERE `SName`=?";
//            Class.forName(driver);
//
//            c= DriverManager.getConnection(url,username,password);
//            Statement st = c.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            System.out.println(rs);
//           if(rs.next()) {
//               id = String.valueOf(rs.getInt("Staff_id"));
//              ph = rs.getString("SPhoneNum");
//              mail = rs.getString("SEmail");
//           
//              }
//            
//		}
//	catch(ClassNotFoundException cnfe)
//	{
//		System.out.println(cnfe);
//	}
//	catch(SQLException sqle)
//	{
//		System.out.println(sqle);
//	}
//		 textField.setText(id);
//       textField_1.setText(Name);
//      textField_2.setText(ph);
//       textField_3.setText(mail);
		setBackground(new Color(51, 204, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 476);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setBounds(104, 172, 78, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Staff_Id :");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1.setBounds(81, 143, 83, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone Number :");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_2.setBounds(28, 217, 154, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email :");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_3.setBounds(101, 245, 75, 22);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("<-- BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffMain sm= new StaffMain();
				sm.setVisible(true);
				dispose();	
				
			}
		});
		btnNewButton.setBackground(new Color(51, 204, 204));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(10, 414, 105, 21);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBackground(new Color(102, 204, 204));
		textField.setBounds(186, 143, 140, 19);
	
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(102, 204, 204));
		textField_1.setBounds(186, 176, 140, 19);
	    
		contentPane.add(textField_1);
		textField_1.setColumns(10);

	
		
		
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(102, 204, 204));
		textField_2.setBounds(186, 216, 140, 19);
	
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(102, 204, 204));
		textField_3.setBounds(186, 249, 140, 19);
		
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
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
		            String sql="SELECT * FROM `staff` WHERE `Staff_id`=?";
		            p=con.prepareStatement(sql);
		            p.setInt(1, Integer.parseInt(textField_4.getText()));
			        r=p.executeQuery();
			        table.setModel(DbUtils.resultSetToTableModel(r));
			        }
//			            if(r.next())
//			            {
//			                textField_1.setText(r.getString("SName"));
//			                textField_2.setText(r.getString("SPoneNum"));
//			                textField_3.setText(r.getString("SEmail"));
//		
//			               
//			           }	}		
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
		btnNewButton_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(51, 204, 204));
		btnNewButton_1.setBounds(347, 25, 200, 21);
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
			            String sql="UPDATE `staff` SET `SName`=?,`SPhoneNum`=?,`SEmail`=?, `SPassword`=? WHERE `Staff_id`=?";
			            p=con.prepareStatement(sql);
			            p.setString(1, textField_1.getText());
			            p.setInt(5, Integer.parseInt(textField.getText()));
			            p.setInt(2,Integer.parseInt(textField_2.getText()));
			            p.setString(3,textField_3.getText());
			            p.setString(4,textField_5.getText());
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
		btnNewButton_2.setBounds(10, 341, 154, 21);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Insert more");
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
			            String sql="INSERT INTO `staff` (`Staff_id`,`SName`,`SPhoneNum`,`SEmail`,`SPassword`) values (?,?,?,?,?)";
			            p=con.prepareStatement(sql);
			            p.setString(2, textField_1.getText());
			            p.setInt(1, Integer.parseInt(textField.getText()));
			            p.setInt(3,Integer.parseInt(textField_2.getText()));
			            p.setString(4,textField_3.getText());
			            p.setString(5, textField_5.getText());
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
		btnNewButton_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnNewButton_3.setBackground(new Color(51, 204, 204));
		btnNewButton_3.setBounds(10, 372, 154, 21);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Delete Details");
		btnNewButton_4.addActionListener(new ActionListener() {
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
			            String sql="DELETE FROM `staff` WHERE `Staff_id`=?";
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
			}
		});
		btnNewButton_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnNewButton_4.setBackground(new Color(51, 204, 204));
		btnNewButton_4.setBounds(214, 341, 165, 21);
		contentPane.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Clear");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
			}
			
		});
		btnNewButton_5.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnNewButton_5.setBackground(new Color(51, 204, 204));
		btnNewButton_5.setBounds(214, 372, 165, 21);
		contentPane.add(btnNewButton_5);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(staffprofile.class.getResource("/IMAGES/sprof (2).png")));
		lblNewLabel_4.setBounds(389, 143, 238, 256);
		contentPane.add(lblNewLabel_4);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int i= table.getSelectedRow();
			
				textField.setText(model.getValueAt(i, 0).toString());
				textField_1.setText(model.getValueAt(i, 1).toString());
				textField_2.setText(model.getValueAt(i, 2).toString());
				textField_3.setText(model.getValueAt(i, 3).toString());
				textField_5.setText(model.getValueAt(i, 4).toString());
				textField_4.setText(model.getValueAt(i, 5).toString());
			}
		});
		scrollPane.setBounds(30, 69, 585, 40);
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
				textField_5.setText(model.getValueAt(i, 4).toString());
				textField_4.setText(model.getValueAt(i, 5).toString());
			}
		});
		model= new DefaultTableModel();
		Object[] column= {"Staff_id", "SName", "SPhoneNum", "SEmail", "SPassword"};
		Object[] row=new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Staff_id", "SName", "SPhoneNum", "SEmail", "SPassword"
			}
		));
		table.setBackground(new Color(51, 204, 204));
		scrollPane.setViewportView(table);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(102, 204, 204));
		textField_4.setBounds(104, 28, 175, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Password:");
		lblNewLabel_5.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_5.setBounds(65, 280, 111, 22);
		contentPane.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(102, 204, 204));
		textField_5.setColumns(10);
		textField_5.setBounds(186, 283, 140, 19);
		contentPane.add(textField_5);
	}
}
