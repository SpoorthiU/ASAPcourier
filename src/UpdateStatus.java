
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateStatus extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStatus frame = new UpdateStatus();
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
	public UpdateStatus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 563);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delivery_ID");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel.setBounds(32, 89, 115, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Updates");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(32, 118, 115, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Courier_ID");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_2.setBackground(new Color(51, 204, 204));
		lblNewLabel_2.setBounds(32, 153, 115, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Delivery Date ");
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(32, 192, 115, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Current Location ");
		lblNewLabel_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(32, 227, 115, 25);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBackground(new Color(102, 204, 204));
		textField.setBounds(157, 90, 108, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(102, 204, 204));
		textField_1.setBounds(157, 122, 108, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(102, 204, 204));
		textField_2.setBounds(157, 157, 108, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(102, 204, 204));
		textField_3.setBounds(157, 196, 108, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(102, 204, 204));
		textField_4.setBounds(157, 231, 108, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int i= table.getSelectedRow();
			
				textField.setText(model.getValueAt(i, 0).toString());
				textField_1.setText(model.getValueAt(i, 1).toString());
				textField_2.setText(model.getValueAt(i, 2).toString());
				textField_3.setText(model.getValueAt(i, 3).toString());
				textField_4.setText(model.getValueAt(i, 4).toString());
			}
		});
		scrollPane.setBounds(296, 77, 406, 404);
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
			}
		});
		model= new DefaultTableModel();
		Object[] column= {"Deliver_ID","Updates","Courier_ID","Delivery Date","Current Location"};
		Object[] row=new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Delivery ID", "Update", "Courier id", "Delivery Date", "Currrent Location"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(4).setPreferredWidth(101);
		scrollPane.setViewportView(table);
		table.setBackground(new Color(51, 204, 204));
		
		JButton btnNewButton = new JButton("ADD");
		Object[] row1=new Object[5];
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")||textField_4.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please fill all Details!!");
				}
				else {
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
				            String sql="INSERT INTO `status` (`Delivery_id`,`Updates`,`Courier_id`,`DeliveryDate`,`CurrentLocation`) values (?,?,?,?,?)";
				            p=con.prepareStatement(sql);
				            p.setString(2, textField_1.getText());
				            p.setInt(1, Integer.parseInt(textField.getText()));
				            p.setInt(3,Integer.parseInt(textField_2.getText()));
				            p.setString(4,textField_3.getText());
				            p.setString(5, textField_4.getText());
				            p.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Insertion successful");
				            con.close();
				        }
				        catch(Exception e1)
				        {
				           JOptionPane.showMessageDialog(null, e1);
				            
				        }
//				row1[0]=textField.getText();
//				row1[1]=textField_1.getText();
//				row1[2]=textField_2.getText();
//				row1[3]=textField_3.getText();
//				row1[4]=textField_4.getText();
//				model.addRow(row1);
////				model.addRow(new Object[]{textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText()});
//				textField.setText("");
//				textField_1.setText("");
//				textField_2.setText("");
//				textField_3.setText("");
//				textField_4.setText("");
//				JOptionPane.showMessageDialog(null,"Saved Successfully!!");
				}
				
			}
		});
		btnNewButton.setBackground(new Color(51, 204, 204));
		btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnNewButton.setBounds(32, 342, 115, 21);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
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
				            String sql="DELETE FROM `status` WHERE `Delivery_id`=?";
				            p=con.prepareStatement(sql);
				            p.setInt(1, Integer.parseInt(textField.getText()));
				            int n=p.executeUpdate();
				            if(n==1)
				            {
				                JOptionPane.showMessageDialog(null, "Deleted Successfully!!");
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
					JOptionPane.showMessageDialog(null,"Select a Row!!!!");
				}
			}
		});
		btnDelete.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnDelete.setBackground(new Color(51, 204, 204));
		btnDelete.setBounds(32, 395, 115, 21);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
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
				            String sql="UPDATE `status` SET `Updates`=?,  `Courier_id`=?, `DeliveryDate`=?, `CurrentLocation`=? WHERE `Delivery_id`=?";
				            PreparedStatement pst=con.prepareStatement(sql);
				            pst.setString(1, textField_1.getText());
				            pst.setInt(5, Integer.parseInt(textField.getText()));
				            pst.setInt(2,Integer.parseInt(textField_2.getText()));
				            pst.setString(3,textField_3.getText());
				            pst.setString(4,textField_4.getText());
				            pst.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Update successful");
				            con.close();
				        }
				        catch(Exception e1)
				        {
				           JOptionPane.showMessageDialog(null, e1);
				            
				        }
//				model.setValueAt(textField.getText(), i, 0);
//				model.setValueAt(textField_1.getText(), i, 1);
//				model.setValueAt(textField_2.getText(), i, 2);
//				model.setValueAt(textField_3.getText(), i, 3);
//				model.setValueAt(textField_4.getText(), i, 4);
//				JOptionPane.showMessageDialog(null,"Updated Successfully!");
			}
				else {
					JOptionPane.showMessageDialog(null,"Select a row to update!");
				}
			}
		});
		btnUpdate.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnUpdate.setBackground(new Color(51, 204, 204));
		btnUpdate.setBounds(156, 342, 109, 21);
		contentPane.add(btnUpdate);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnClear.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnClear.setBackground(new Color(51, 204, 204));
		btnClear.setBounds(156, 395, 109, 21);
		contentPane.add(btnClear);
		
		JButton btnViewAll = new JButton("VIEW ALL COURIER STATUS");
		btnViewAll.addActionListener(new ActionListener() {
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
					String sql="Select * from status";
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
		btnViewAll.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnViewAll.setBackground(new Color(51, 204, 204));
		btnViewAll.setBounds(358, 31, 286, 25);
		contentPane.add(btnViewAll);
		
		JButton btnNewButton_1 = new JButton("<--Back");
		btnNewButton_1.setBackground(new Color(51, 204, 204));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffMain sm= new StaffMain();
				sm.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 495, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
