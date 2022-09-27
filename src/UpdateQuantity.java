

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateQuantity extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField entryQuantity;
	private JTextField entryBy;
	private JTextField remark;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateQuantity frame = new UpdateQuantity();
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
	public UpdateQuantity() {
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
		
		JLabel lblNewLabel_1_1 = new JLabel("ENTRY DATE");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(19, 143, 115, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("ENTRY QUANTITY");
		lblNewLabel_1_3.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(19, 195, 115, 16);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("ENTRY BY");
		lblNewLabel_1_4.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(19, 243, 115, 16);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("REMARKS");
		lblNewLabel_1_5.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(19, 295, 115, 16);
		contentPane.add(lblNewLabel_1_5);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(185, 139, 232, 21);
		contentPane.add(dateChooser);
		
		textField = new JTextField();
		textField.setBounds(185, 83, 204, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		entryQuantity = new JTextField();
		entryQuantity.setColumns(10);
		entryQuantity.setBounds(185, 191, 204, 26);
		contentPane.add(entryQuantity);
		
		entryBy = new JTextField();
		entryBy.setColumns(10);
		entryBy.setBounds(185, 239, 204, 26);
		contentPane.add(entryBy);
		
		remark = new JTextField();
		remark.setColumns(10);
		remark.setBounds(185, 285, 204, 26);
		contentPane.add(remark);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					connectionClass con = new connectionClass();
			        Connection connectionDB = con.getConnection();
			        String BSQ=textField.getText();
			        String ReturnDate=String.valueOf(dateChooser.getDate());
			        
			        String IssueBy=entryBy.getText();
			        String IssueQuantity=entryQuantity.getText();
			        String remarks=remark.getText();

			        
			        String sql1="Select BalancedQuantity from table1 where BSQPartNumber='"+textField.getText()+"'";
			        
			        PreparedStatement pst = connectionDB.prepareStatement(sql1);

			        String quantity_ = null;
			        ResultSet rs=pst.executeQuery();
					
			        if(rs.next()){
			            quantity_=(rs.getString(1));
			        }


			        if( IssueBy.isEmpty() || IssueQuantity.isEmpty()){
			            JOptionPane.showMessageDialog(null,"enter all fields","error",JOptionPane.ERROR_MESSAGE);
			        }else {
			          	
			            	for(int i=1;i<=20;i++) {
			            		if(i==20) {
			            			for(int j=1;j<20;j++) {
			            				String newe=String.valueOf(j);
			            				String sqlstart="alter table table1 drop column EntryDate"+newe+" , drop column EntryQuantity"+newe+" , drop column EntryBy"+newe+", drop column Remarks"+newe+" ";
			            				
			            				PreparedStatement pst3 = connectionDB.prepareStatement(sqlstart);
			            				pst3.execute();
			            				
			            				i=1;
			            			}
			            		}
			            		try {
			            			String newe=String.valueOf(i);
			            			
			            			String sqlstart="alter table table1 add column EntryDate"+newe+" varchar(200), add column EntryQuantity"+newe+" varchar(200), add column EntryBy"+newe+" varchar(200), add column Remarks"+newe+" varchar(200)";
			            			
			            			String sql = "update table1 set EntryBy"+newe+"='" + IssueBy + "',EntryDate"+newe+"='" + ReturnDate + "',EntryQuantity"+newe+"='" + Integer.valueOf(IssueQuantity) + "',BalancedQuantity=BalancedQuantity+'" + IssueQuantity + "',Remarks"+newe+"='" + remarks + "' where BSQPartNumber='" + BSQ + "'";
//			            			
			            			
				                 
			            			pst = connectionDB.prepareStatement(sqlstart);
			            			pst.executeQuery();
			            			System.out.println("working fine 180");
			            			
			            				
			            				PreparedStatement pst2 = connectionDB.prepareStatement(sql);
			            				
			            				pst2.executeQuery();	
			            				
				            			
			            				JOptionPane.showMessageDialog(null,"successfully added");
			            				dispose();	
			            				break;
			            			
			            			}		catch(Exception ev) {		
			            				
			            			continue;
			              
			            }  }
			            			        }
					
				}
				
			catch(Exception ev) {
				JOptionPane.showMessageDialog(null,"Cant connect to database","error",JOptionPane.ERROR_MESSAGE);
                                ev.printStackTrace();
				
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
			        
			        entryQuantity.setText(null);
			        entryBy.setText(null);
			        remark.setText(null);
				
				
				
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
