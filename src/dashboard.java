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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import com.mysql.cj.xdevapi.Statement;

import net.proteanit.sql.DbUtils;

import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.Box;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Canvas;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dashboard extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard frame = new dashboard();
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
	
	public void theader() {
		JTableHeader thead=table.getTableHeader();
		thead.setForeground(Color.black);
		thead.setFont(new Font("Tahome",Font.BOLD,14));
	}
	
	public void table() {
        try {
				 connectionClass con = new connectionClass();
		            Connection connectionDB = con.getConnection();
		            String query="select BSQPartNumber,BalancedQuantity from table1 where BalancedQuantity <20";
		            PreparedStatement pst=connectionDB.prepareStatement(query);
		            ResultSet rs=pst.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
	theader();	            
		            
		            
		            
			}catch(Exception e) {
				System.out.print("cant load table");
			}
		}
	
	/**
	 * Create the frame.
	 */
	public dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 0, 1351, 870);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.disabledText"));
		panel.setBounds(273,-5, 1081, 149);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Dashboard");
		lblNewLabel_1.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 48));
		lblNewLabel_1.setBounds(408, 22, 324, 90);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(257, 6, 120, 102);
		panel.add(lblNewLabel_4);
		image("/icons/cart 2.png",lblNewLabel_4);
		
		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				login l=new login();
		l.show();
		
				
				
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(929, 43, 117, 41);
		panel.add(btnNewButton);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.disabledText"));
		panel_1.setBounds(0, 0, 281, 881);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dashboard");
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		lblNewLabel.setBounds(35, 248, 197, 103);
		panel_1.add(lblNewLabel);
		
		JLabel lblFind = new JLabel("Find");
		lblFind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Main m=new Main();
				try {
					m.changeSceneFind();
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		lblFind.setForeground(UIManager.getColor("Button.highlight"));
		lblFind.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		lblFind.setBounds(35, 495, 197, 103);
		panel_1.add(lblFind);
		
		JLabel lblNewLabel_2 = new JLabel("Inventory");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 34));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(87, 31, 207, 66);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(16, 31, 61, 66);
		panel_1.add(lblNewLabel_3);
		
		image("/icons/Logo.png",lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("OVERVIEW");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.BOLD, 34));
		lblNewLabel_5.setForeground(new Color(139, 69, 19));
		lblNewLabel_5.setBounds(712, 228, 197, 73);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(1043, 321, 116, 109);
		contentPane.add(lblNewLabel_6);
		image("/icons/warning.png",lblNewLabel_6);
		
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.WHITE, 1, true));
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(23, 691, 219, 137);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("LOGGED IN AS:");
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(63, 6, 123, 16);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("LEVEL ACCESS:");
		lblNewLabel_8_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_8_1.setForeground(Color.WHITE);
		lblNewLabel_8_1.setBounds(63, 76, 123, 16);
		panel_2.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_9 = new JLabel("ADMIN");
		lblNewLabel_9.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_9.setForeground(new Color(0, 100, 0));
		lblNewLabel_9.setBounds(88, 34, 66, 16);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("ADMIN");
		lblNewLabel_9_1.setForeground(new Color(0, 100, 0));
		lblNewLabel_9_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_9_1.setBounds(88, 96, 66, 16);
		panel_2.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setBounds(6, 31, 46, 43);
		panel_2.add(lblNewLabel_10);
		image("/icons/key.png",lblNewLabel_10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(956, 446, 296, 289);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(789, 395, 1, 367);
		contentPane.add(separator);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table();
			}
		});
        lblNewLabel_7.setBounds(1071, 761, 71, 63);
        contentPane.add(lblNewLabel_7);
        image("/icons/refresh.png",lblNewLabel_7);
		
        //table show//
        table();
        
        
        
        
        
        
		
		
	}
}
