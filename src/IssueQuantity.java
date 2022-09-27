/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author abhaydeep
 */


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class IssueQuantity extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueQuantity frame = new IssueQuantity();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void image(String location,JLabel label) {
		ImageIcon myimage2=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(location)));
		Image img2_2=myimage2.getImage();
		Image img22=img2_2.getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH);
		
		ImageIcon i1=new ImageIcon(img22);
		label.setIcon(i1);
	}

	/**
	 * Create the frame.
	 */
	public IssueQuantity() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUANTITY DETAILS");
		lblNewLabel.setFont(new Font("Chalkboard SE", Font.BOLD, 19));
		lblNewLabel.setBounds(138, 6, 184, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BSQPartNumber");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(19, 87, 115, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ISSUE DATE");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(19, 123, 115, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("RETURN DATE");
		lblNewLabel_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(19, 163, 115, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("ISSUE QUANTITY");
		lblNewLabel_1_3.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(19, 205, 115, 16);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("ISSUE BY");
		lblNewLabel_1_4.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(19, 243, 115, 16);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("REMARKS");
		lblNewLabel_1_5.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(19, 285, 115, 16);
		contentPane.add(lblNewLabel_1_5);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(185, 119, 232, 21);
		contentPane.add(dateChooser);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(185, 158, 232, 21);
		contentPane.add(dateChooser_1);
		
		textField = new JTextField();
		textField.setBounds(185, 83, 204, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(185, 201, 204, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(185, 239, 204, 26);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(185, 275, 204, 26);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					connectionClass con = new connectionClass();
			        Connection connectionDB = con.getConnection();
			        String BSQ=textField.getText();
			        String ReturnDate=String.valueOf(dateChooser.getDate());
			        String IssueDate=String.valueOf(dateChooser_1.getDate());
			        String IssueBy=textField_4.getText();
			        String IssueQuantity=textField_3.getText();
			        String remarks=textField_5.getText();

			        
			        String sql1="Select BalancedQuantity from table1 where BSQPartNumber='"+textField.getText()+"'";
			        
			        PreparedStatement pst = connectionDB.prepareStatement(sql1);

			        String quantity_ = null;
			        ResultSet rs=pst.executeQuery(sql1);
					
			        if(rs.next()){
			            quantity_=(rs.getString(1));
			        }


			        if( IssueBy.isEmpty() || IssueDate.isEmpty()|| IssueQuantity.isEmpty()){
			            JOptionPane.showMessageDialog(null,"enter all fields","error",JOptionPane.ERROR_MESSAGE);
			        }else {
			        
			            if (Integer.parseInt(IssueQuantity) <= Integer.parseInt(quantity_)) {
			            	
			            	for(int i=1;i<=20;i++) {
			            		if(i==20) {
			            			for(int j=1;j<20;j++) {
			            				String newe=String.valueOf(j);
			            				String sqlstart="alter table table1 drop column IssueDate"+newe+" , drop column ReturnDate"+newe+" , drop column IssueQuantity"+newe+" , drop column IssueBy"+newe+", drop column Remark"+newe+" ";
			            				
			            				PreparedStatement pst3 = connectionDB.prepareStatement(sqlstart);
			            				pst3.execute();
			            				
			            				i=1;
			            			}
			            		}
			            		try {
			            			String newe=String.valueOf(i);
			            			
			            			String sqlstart="alter table table1 add column IssueDate"+newe+" varchar(200), add column ReturnDate"+newe+" varchar(200), add column IssueQuantity"+newe+" varchar(200), add column IssueBy"+newe+" varchar(200), add column Remark"+newe+" varchar(200)";
			            			
			            			String sql = "update table1 set IssueDate"+newe+"='" + IssueDate + "',IssueBy"+newe+"='" + IssueBy + "',ReturnDate"+newe+"='" + ReturnDate + "',IssueQuantity"+newe+"='" + Integer.valueOf(IssueQuantity) + "',BalancedQuantity=BalancedQuantity-'" + IssueQuantity + "',Remark"+newe+"='" + remarks + "' where BSQPartNumber='" + BSQ + "'";
//			            			
			            			
				                 
			            			pst = connectionDB.prepareStatement(sqlstart);
			            			pst.execute();
			            			
			            			
			            				
			            				PreparedStatement pst2 = connectionDB.prepareStatement(sql);
			            				
			            				pst2.execute();	
			            				
				            			
			            				JOptionPane.showMessageDialog(null,"successfully issued");
			            				dispose();	
			            				break;
			            			
			            			}		catch(Exception ev) {		
			            				
			            			continue;
			              
			            }  }
			            }
			            
			            else{
			            	JOptionPane.showMessageDialog(null,"Issue quantity is greater than balance quantity","error",JOptionPane.ERROR_MESSAGE);

			            }
			        }
					
				}
				
			catch(Exception ev) {
				JOptionPane.showMessageDialog(null,"Cant connect to database","error",JOptionPane.ERROR_MESSAGE);
				
			}
				}
		});
		btnNewButton.setBounds(68, 351, 117, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				
				
				 textField.setText(null);
			        dateChooser.setDate(null);
			        dateChooser_1.setDate(null);
			        textField_3.setText(null);
			        textField_4.setText(null);
			        textField_5.setText(null);
				
				
				
						}
		});
		btnNewButton_1.setBounds(257, 351, 117, 40);
		contentPane.add(btnNewButton_1);
	
	
	JLabel closeicon = new JLabel("");
		
		closeicon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				
			}
		});
		closeicon.setBounds(6, 6, 25, 21);
		contentPane.add(closeicon);
		image("/icons/x-button.png",closeicon);
	
	
	}
	
		
	

}
