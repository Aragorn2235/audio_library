package audiolibrary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Memberdetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Memberdetails frame = new Memberdetails();
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
	public Memberdetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMembershipId = new JLabel("Membership ID *");
		lblMembershipId.setBounds(10, 11, 101, 14);
		contentPane.add(lblMembershipId);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        //Create DataBase Coonection and Fetching Records
		 
		        try {
		         int str = Integer.parseInt(textField.getText());
		        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/audiolibrary","root","");
		            PreparedStatement st = connection.prepareStatement("select * from member_details where member_details.MembershipID=?");
		            st.setInt(1, str);
		 
		            //Excuting Query
		            ResultSet rs = st.executeQuery();
		 
		            if (rs.next()) {
		                String s = rs.getString(1);
		                String s1 = rs.getString(2);
		                String s2 = rs.getString(3);
		                String s3 = rs.getString(4);
		                String s4 = rs.getString(5);
		                String s5 = rs.getString(6);
		                String s6 = rs.getString(7);
		                String s7 = rs.getString(8);
		                String s8 = rs.getString(9);
		               // String s9 = rs.getString(10);
		                String s10 = rs.getString(10);
		                String s11 = rs.getString(11);
		                String s12 = rs.getString(12);
		                String s13 = rs.getString(13);
		                String s14 = rs.getString(14);
		                String s15 = rs.getString(15);
		                
		                
		 
		                //Sets Records in TextFields.
		                textField_1.setText(s1);
		                textField_2.setText(s2);
		                textField_3.setText(s3);
		                textField_4.setText(s4);
		                textField_5.setText(s5);
		                textField_6.setText(s6);
		                textField_7.setText(s7);
		                textField_8.setText(s8);
		              //  textField_9.setText(s9);
		                textField_10.setText(s10);
		                textField_11.setText(s11);
		                textField_12.setText(s12);
		                textField_13.setText(s13);
		                textField_14.setText(s14);
		                textField_15.setText(s15);
		               
		                
		                
		            } else {
		                JOptionPane.showMessageDialog(null, "MemberShip ID doesn't exists");
		            }
		 
		            //Create Exception Handler
		        } catch (Exception ex) {
		 
		            System.out.println(ex);
		        }
		    
			}
		});
		btnNewButton.setBounds(121, 38, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(121, 8, 160, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(51, 75, 60, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Father's/Husband's/Mother's Name");
		lblNewLabel_1.setBounds(10, 100, 216, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(40, 125, 71, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("City");
		lblNewLabel_3.setBounds(40, 150, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PinCode");
		lblNewLabel_4.setBounds(40, 175, 71, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("State");
		lblNewLabel_5.setBounds(40, 200, 57, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("PhoneNo");
		lblNewLabel_6.setBounds(40, 225, 71, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("MobileNo ");
		lblNewLabel_7.setBounds(40, 250, 82, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("E-Mail");
		lblNewLabel_9.setBounds(40, 275, 57, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Date of Birth");
		lblNewLabel_10.setBounds(38, 300, 84, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Sex");
		lblNewLabel_11.setBounds(51, 325, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Educational Qualification");
		lblNewLabel_12.setBounds(10, 350, 152, 14);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Occupation");
		lblNewLabel_13.setBounds(38, 375, 101, 14);
		contentPane.add(lblNewLabel_13);
		
		textField_1 = new JTextField();
		textField_1.setBounds(224, 72, 196, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(224, 322, 89, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(224, 97, 196, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(224, 122, 196, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(224, 147, 196, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(224, 172, 196, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(224, 197, 196, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(224, 222, 196, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(224, 247, 196, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(224, 272, 196, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(224, 297, 152, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(224, 347, 196, 20);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(224, 372, 196, 20);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(224, 403, 152, 20);
		contentPane.add(textField_15);
		textField_15.setColumns(10);
		
		textField_1.setEditable(false);
		textField_2.setEditable(false);
		textField_3.setEditable(false);
		textField_4.setEditable(false);
		textField_5.setEditable(false);
		textField_6.setEditable(false);
		textField_7.setEditable(false);
		textField_8.setEditable(false);
		textField_10.setEditable(false);
		textField_11.setEditable(false);
		textField_13.setEditable(false);
		textField_14.setEditable(false);
		textField_15.setEditable(false);
		textField_12.setEditable(false);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Home frame1 = new Home();
					frame1.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		btnCancel.setBounds(243, 38, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblApprovedDateOf = new JLabel("Approved Date of Membership");
		lblApprovedDateOf.setBounds(10, 403, 175, 14);
		contentPane.add(lblApprovedDateOf);
		
		JLabel lblFormatyyyymmdd = new JLabel("Format:-YYYY-MM-DD");
		lblFormatyyyymmdd.setBounds(391, 300, 136, 14);
		contentPane.add(lblFormatyyyymmdd);
		
		JLabel lblFormatyyyymmdd_1 = new JLabel("Format:-YYYY-MM-DD");
		lblFormatyyyymmdd_1.setBounds(396, 406, 131, 14);
		contentPane.add(lblFormatyyyymmdd_1);
		
		JLabel lblFieldsAre = new JLabel("* Fields are required");
		lblFieldsAre.setBounds(349, 11, 152, 14);
		contentPane.add(lblFieldsAre);
		
		
	        
	}
}
