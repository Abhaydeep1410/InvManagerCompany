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
import java.awt.event.ActionEvent;

public class signUp extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUp frame = new signUp();
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
	public signUp() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 354, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGNUP");
		lblNewLabel.setFont(new Font("Chalkboard SE", Font.BOLD, 20));
		lblNewLabel.setBounds(124, 6, 105, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Chalkboard SE", Font.PLAIN, 16));
		lblUsername.setBounds(18, 102, 105, 36);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Chalkboard SE", Font.PLAIN, 16));
		lblPassword.setBounds(18, 183, 105, 36);
		contentPane.add(lblPassword);
		
		username = new JTextField();
		username.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		username.setBounds(124, 106, 156, 33);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(124, 183, 156, 33);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("ADD USER");
		btnNewButton.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e) {
				String sql2="insert into tableClient (username,password) values('"+username.getText()+"','"+password.getText()+"')";
		        try{

		            connectionClass con = new connectionClass();
		            Connection connectionDB = con.getConnection();
		            
		            PreparedStatement pst=connectionDB.prepareStatement(sql2);
		            pst.execute();

		            JOptionPane.showMessageDialog(btnNewButton, "successfully added");
		            
		            username.setText(null);
		            password.setText(null);
		            dispose();
		            
		        }catch (Exception ev){
		        	JOptionPane.showMessageDialog(null, "username already exist enter again");
		            
		        }

		    
		
				
			}
		});
		btnNewButton.setBounds(112, 269, 117, 43);
		contentPane.add(btnNewButton);
		
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

