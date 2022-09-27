/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author abhaydeep
 */

import java.awt.EventQueue;

import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.TextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;
	private JComboBox typeup;
	private JButton btnNewButton;
	private JTextField passwordstore;
	private JLabel lblWarnPassword;

	PreparedStatement pst=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 540, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		panel.setBounds(0, 0, 540, 124);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblNewLabel.setBounds(251, 44, 117, 45);
		panel.add(lblNewLabel);
		
		
		
		

		JLabel imglabel = new JLabel("");
		imglabel.setBounds(142, 27, 72, 78);
		panel.add(imglabel);
		ImageIcon myimage=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/Accounts_main.png")));
		Image img=myimage.getImage();
		Image img2=img.getScaledInstance(imglabel.getWidth(),imglabel.getHeight(),Image.SCALE_SMOOTH);
		
		ImageIcon i=new ImageIcon(img2);
		imglabel.setIcon(i);
		
		
		String[] user= {"ADMIN","USER"};
		
		typeup = new JComboBox(user);
		
		typeup.setBounds(197, 156, 161, 23);
		
		contentPane.add(typeup);
		
		username = new JTextField();
		username.setToolTipText("");
		username.setBounds(197, 226, 161, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		JCheckBox checkbox = new JCheckBox("");
		checkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkbox.isSelected()){
		            passwordstore.setText(passwordField.getText());
		            passwordstore.setVisible(true);
		            passwordField.setVisible(false);
		        }
		        else{
		            passwordField.setText(passwordstore.getText());
		            passwordstore.setVisible(false);
		            passwordField.setVisible(true);
		        }
				
				
			}
		});
		checkbox.setBounds(374, 291, 128, 23);
		contentPane.add(checkbox);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(197, 291, 161, 26);
		contentPane.add(passwordField);
		
		
		
		
		
		btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Main m = new Main();
		        try {
		        	
		            if (typeup.getSelectedItem().toString().equals("ADMIN")) {
		            	
		                try {
		                    String sql = "Select * from loginAdmin where username='" + username.getText().toString() + "' and password='" + passwordField.getText().toString() + "'";
		                    connectionClass con = new connectionClass();
		                    Connection connectionDB = con.getConnection();

		                    pst = connectionDB.prepareStatement(sql);

		                    ResultSet rs = pst.executeQuery();

		                    if (rs.next()) {
		        m.changeSceneDashboard();     
		        dispose();
		                    	
		                    	
		                    	

		                    } else if (username.getText().isEmpty() && passwordField.getText().isEmpty()) {
		                        lblWarnPassword.setText("enter you data");
		                        JOptionPane.showMessageDialog(null,"empty field","error",JOptionPane.ERROR_MESSAGE);

		                    } else {

		                    	JOptionPane.showMessageDialog(null,"wrong username or password","error",JOptionPane.ERROR_MESSAGE);


		                    }
		                } catch (Exception ev) {
		                	JOptionPane.showMessageDialog(null,"Cant connect to database","error",JOptionPane.ERROR_MESSAGE);
		                }
		            } else {
		                try {
		                    String sql = "Select * from tableClient where username='" + username.getText().toString() + "' and password='" + passwordField.getText().toString() + "'";
		                    connectionClass con = new connectionClass();
		                    Connection connectionDB = con.getConnection();

		                    pst = connectionDB.prepareStatement(sql);

		                    ResultSet rs = pst.executeQuery();
		                    if (rs.next()) {

		                    	user_dashboard u=new user_dashboard();
		                    	u.show();
		                    	dispose();
		                    	
		                    	
		                    	
		                    } else if (username.getText().isEmpty() && passwordField.getText().isEmpty()) {
		                        lblWarnPassword.setText("enter you data");
		                    } else {
		                    	JOptionPane.showMessageDialog(null,"wrong username or password","error",JOptionPane.ERROR_MESSAGE);
		                    	

		                    }
		                } catch (Exception ev) {
		                	JOptionPane.showMessageDialog(null,"Cant connect to database","error",JOptionPane.ERROR_MESSAGE);	
		                ev.printStackTrace();	
		                }

		            }
		        }
		        catch (Exception ev){
		        	JOptionPane.showMessageDialog(null,"Choose type","error",JOptionPane.ERROR_MESSAGE);		        }
				
				
				
				
				
				
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(114, 382, 128, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SIGNUP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUp sign=new signUp();
				sign.show();
				
				
				
			}
		});
		btnNewButton_1.setBounds(309, 382, 117, 40);
		btnNewButton_1.setBackground(new Color(119, 136, 153));
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setBounds(93, 231, 80, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setBounds(93, 298, 80, 16);
		contentPane.add(lblNewLabel_1_1);
		
		passwordstore = new JTextField();
		passwordstore.setToolTipText("");
		passwordstore.setColumns(10);
		passwordstore.setBounds(197, 291, 161, 26);
		contentPane.add(passwordstore);
		
		lblWarnPassword = new JLabel("Field Required");
		lblWarnPassword.setForeground(UIManager.getColor("Button.select"));
		lblWarnPassword.setBounds(233, 329, 103, 16);
		contentPane.add(lblWarnPassword);
		
	}
}
