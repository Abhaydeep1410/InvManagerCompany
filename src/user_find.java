/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author abhaydeep
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;

public class user_find extends JFrame {


	private JPanel contentPane;
	private JTable table;
	private JTextField txtSearch;
	private JTextField item;
	private JTextField BSQPartNumber;
	private JTextField PartNumber;
	private JTextField Manufacturer;
	private JTextField Rack;
	private JTextField BoxNumber;
	private JTextField Project;
	private JTextField QuantityType;
	private JTextField MountingType;
	private JTextField BalancedQunatity;
	private JTextArea Description;
	DefaultTableModel model=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_find frame = new user_find();
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
		            String query="select * from table1";
		            PreparedStatement pst=connectionDB.prepareStatement(query);
		            ResultSet rs=pst.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		            
		            theader();
		            
		            
		            
			}catch(Exception e) {
				System.out.print("cant load table");
			}
		}
	
	PreparedStatement pst=null;
	public void add(ActionEvent event) throws SQLException {
	    String sql="insert into table1 (item,MountingType,BSQPartNumber,PartNumber,Description,Manufacturer,Rack,BoxNumber,Project,BalancedQuantity,QuantityType)values(?,?,?,?,?,?,?,?,?,?,?)";
	    try {
	        connectionClass con = new connectionClass();
	        Connection connectionDB = con.getConnection();
	        
	        pst = connectionDB.prepareStatement(sql);
	        pst.setString(1, item.getText());
	        pst.setString(2, MountingType.getText());
	        pst.setString(3, BSQPartNumber.getText());
	        pst.setString(4, PartNumber.getText());
	        pst.setString(5, Description.getText());
	        pst.setString(6, Manufacturer.getText());
	        pst.setString(7, Rack.getText());
	        pst.setString(8, BoxNumber.getText());
	        pst.setString(9, Project.getText());
	        pst.setString(10, BalancedQunatity.getText());
	        pst.setString(11, QuantityType.getText());
	        pst.execute();
	        
//	        UpdateTable();
	    }
	    catch (Exception e){
	        System.out.print("error at add table");

	    }


	}
	
	

	
	
	
	
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public user_find() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 0, 1351, 870);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.disabledText"));
		panel.setBounds(273,-5, 1081, 149);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Find");
		lblNewLabel_1.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 48));
		lblNewLabel_1.setBounds(408, 22, 324, 90);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(257, 6, 120, 102);
		panel.add(lblNewLabel_4);
		image("/icons/cart 2.png",lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.disabledText"));
		panel_1.setBounds(0, 0, 281, 881);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dashboard");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main m=new Main();
				try {
					user_dashboard ud=new user_dashboard();
					ud.show();
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblNewLabel.setBounds(35, 248, 197, 103);
		panel_1.add(lblNewLabel);
		
		JLabel lblFind = new JLabel("Find");
		
		lblFind.setForeground(UIManager.getColor("Button.highlight"));
		lblFind.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
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
		
		JScrollPane scrollPane = new JScrollPane();
	 
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
		
				
		
		
		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(760, 297, 573, 520);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id;
				DefaultTableModel tmodel=(DefaultTableModel)table.getModel();
				int selectrowindex=table.getSelectedRow();
				id=(tmodel.getValueAt(selectrowindex,2).toString());
				String sql="select item,Mountingtype,BSQPartNumber,PartNumber,Description,Manufacturer,Rack,BoxNumber,Project,BalancedQuantity,QuantityType from table1 where BSQPartNumber='"+id+"'";
				try {
					connectionClass c=new connectionClass();
					
					connectionClass con = new connectionClass();
					  
				        Connection connectionDB = con.getConnection();
				        
				        pst = connectionDB.prepareStatement(sql);
				        ResultSet rs=pst.executeQuery();
				        
				        if(rs.next()) {
				        	item.setText(rs.getString("item"));
				        	BSQPartNumber.setText(rs.getString("BSQPartNumber"));
				        	PartNumber.setText(rs.getString("PartNumber"));
				        	
				        	
				        	
				        	Description.setText(rs.getString("Description"));
				        
				        	
				        	MountingType.setText(rs.getString("Mountingtype"));
				        	Manufacturer.setText(rs.getString("Manufacturer"));
				        	Rack.setText(rs.getString("Rack"));
				        	BoxNumber.setText(rs.getString("BoxNumber"));
				        	Project.setText(rs.getString("Project"));
				        	QuantityType.setText(rs.getString("QuantityType"));
				        	BalancedQunatity.setText(rs.getString("BalancedQuantity"));
				      
				        	
				        }
				}catch(Exception ev) {
					ev.printStackTrace();
				}
			
			}
		});
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	
		scrollPane.setViewportView(table);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				model=(DefaultTableModel)table.getModel();
				String search=txtSearch.getText();
				TableRowSorter <DefaultTableModel> tr=new TableRowSorter <DefaultTableModel>(model); 
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
				
			}
		});
		txtSearch.setOpaque(true);
		txtSearch.setBounds(495, 217, 556, 50);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("ITEM");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(293, 333, 68, 17);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("BSQPartNumber");
		lblNewLabel_5_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_5_1.setBounds(293, 396, 114, 17);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("PartNumber");
		lblNewLabel_5_2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_5_2.setBounds(293, 459, 114, 17);
		contentPane.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("Manufacturer");
		lblNewLabel_5_3.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_5_3.setBounds(293, 522, 114, 17);
		contentPane.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("Rack");
		lblNewLabel_5_4.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_5_4.setBounds(293, 585, 68, 17);
		contentPane.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_5 = new JLabel("QuantityType");
		lblNewLabel_5_5.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_5_5.setBounds(293, 774, 114, 17);
		contentPane.add(lblNewLabel_5_5);
		
		JLabel lblNewLabel_5_6 = new JLabel("BoxNumber");
		lblNewLabel_5_6.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_5_6.setBounds(293, 648, 114, 17);
		contentPane.add(lblNewLabel_5_6);
		
		JLabel lblNewLabel_5_7 = new JLabel("Project");
		lblNewLabel_5_7.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_5_7.setBounds(293, 711, 68, 17);
		contentPane.add(lblNewLabel_5_7);
		
		item = new JTextField();
		item.setBounds(394, 328, 130, 26);
		contentPane.add(item);
		item.setColumns(10);
		
		BSQPartNumber = new JTextField();
		BSQPartNumber.setColumns(10);
		BSQPartNumber.setBounds(394, 391, 130, 26);
		contentPane.add(BSQPartNumber);
		
		PartNumber = new JTextField();
		PartNumber.setColumns(10);
		PartNumber.setBounds(394, 455, 130, 26);
		contentPane.add(PartNumber);
		
		Manufacturer = new JTextField();
		Manufacturer.setColumns(10);
		Manufacturer.setBounds(394, 519, 130, 26);
		contentPane.add(Manufacturer);
		
		Rack = new JTextField();
		Rack.setColumns(10);
		Rack.setBounds(394, 578, 130, 26);
		contentPane.add(Rack);
		
		BoxNumber = new JTextField();
		BoxNumber.setColumns(10);
		BoxNumber.setBounds(394, 644, 130, 26);
		contentPane.add(BoxNumber);
		
		Project = new JTextField();
		Project.setColumns(10);
		Project.setBounds(394, 706, 130, 26);
		contentPane.add(Project);
		
		QuantityType = new JTextField();
		QuantityType.setColumns(10);
		QuantityType.setBounds(394, 768, 130, 26);
		contentPane.add(QuantityType);
		
		JLabel lblNewLabel_5_8 = new JLabel("MountingType");
		lblNewLabel_5_8.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_5_8.setBounds(597, 328, 114, 17);
		contentPane.add(lblNewLabel_5_8);
		
		JLabel lblNewLabel_5_8_1 = new JLabel("BalancedQuantity");
		lblNewLabel_5_8_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_5_8_1.setBounds(597, 396, 114, 17);
		contentPane.add(lblNewLabel_5_8_1);
		
		JLabel lblNewLabel_5_8_1_1 = new JLabel("Description");
		lblNewLabel_5_8_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_5_8_1_1.setBounds(597, 485, 114, 17);
		contentPane.add(lblNewLabel_5_8_1_1);
		
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
		
		JLabel lblNewLabel_9 = new JLabel("USER");
		lblNewLabel_9.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_9.setForeground(new Color(0, 100, 0));
		lblNewLabel_9.setBounds(88, 34, 46, 16);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("USER");
		lblNewLabel_9_1.setForeground(new Color(0, 100, 0));
		lblNewLabel_9_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_9_1.setBounds(88, 96, 46, 16);
		panel_2.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setBounds(6, 31, 46, 43);
		panel_2.add(lblNewLabel_10);
		image("/icons/key.png",lblNewLabel_10);
		
		
		
		 Description = new JTextArea();
		 Description.setLineWrap(true);
		Description.setBounds(578, 504, 129, 79);
		contentPane.add(Description);
		
		MountingType = new JTextField();
		MountingType.setColumns(10);
		MountingType.setBounds(578, 347, 130, 26);
		contentPane.add(MountingType);
		
		BalancedQunatity = new JTextField();
		BalancedQunatity.setColumns(10);
		BalancedQunatity.setBounds(578, 413, 130, 26);
		contentPane.add(BalancedQunatity);
		table();
		
	}

}

