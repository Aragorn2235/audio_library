package audiolibrary;


import java.awt.BorderLayout;
import java.sql.*;
import java.text.ParseException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.awt.EventQueue;
import java.lang.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;


public class AUmember extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_13;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AUmember frame = new AUmember();
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
	public AUmember() {
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnCancel = new JButton("Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Home frame1 = new Home();
					frame1.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				setVisible(false);
				//dispose();
			}
		});
		btnCancel.setBounds(236, 494, 89, 23);
		contentPane.add(btnCancel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(212, 51, 180, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMemberName = new JLabel("Member Name *");
		lblMemberName.setBounds(58, 36, 200, 50);
		contentPane.add(lblMemberName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(212, 82, 178, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFathershusbandsmothersNmae = new JLabel("Father's/Husband's/Mothers Name");
		lblFathershusbandsmothersNmae.setBounds(10, 67, 200, 50);
		contentPane.add(lblFathershusbandsmothersNmae);
		
		textField_3 = new JTextField();
		textField_3.setBounds(212, 113, 180, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(212, 141, 180, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(214, 172, 178, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(58, 97, 200, 50);
		contentPane.add(lblAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(58, 128, 200, 50);
		contentPane.add(lblCity);
		
		JLabel lblPincode = new JLabel("Pincode");
		lblPincode.setBounds(58, 157, 200, 50);
		contentPane.add(lblPincode);
		
		textField_6 = new JTextField();
		textField_6.setBounds(214, 203, 178, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(58, 188, 200, 50);
		contentPane.add(lblState);
		
		textField_7 = new JTextField();
		textField_7.setBounds(243, 234, 149, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel label = new JLabel("+91");
		label.setBounds(210, 218, 200, 50);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Mobile No");
		lblNewLabel.setBounds(58, 218, 200, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblPhoneNo = new JLabel("Phone No");
		lblPhoneNo.setBounds(58, 249, 200, 50);
		contentPane.add(lblPhoneNo);
		
		textField_8 = new JTextField();
		textField_8.setBounds(212, 264, 178, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(58, 280, 133, 50);
		contentPane.add(lblSex);
		
		textField_9 = new JTextField();
		textField_9.setBounds(214, 355, 178, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblEducationalQualification = new JLabel("Educational Qualification");
		lblEducationalQualification.setBounds(34, 340, 158, 50);
		contentPane.add(lblEducationalQualification);
		
		textField_10 = new JTextField();
		textField_10.setBounds(214, 386, 178, 20);
		textField_10.setColumns(10);
		
		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setBounds(58, 371, 89, 50);
		contentPane.add(lblOccupation);
		
		textField_11 = new JTextField();
		textField_11.setBounds(214, 417, 178, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(58, 407, 200, 50);
		contentPane.add(lblEmail);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(46, 310, 200, 50);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblApprovedDateOf = new JLabel("Approved Date of Membership *");
		lblApprovedDateOf.setBounds(10, 433, 200, 50);
		contentPane.add(lblApprovedDateOf);
		
		textField_13 = new JTextField();
		textField_13.setBounds(212, 21, 180, 20);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblMembershipId = new JLabel("MemberShip ID  *");
		lblMembershipId.setBounds(58, 6, 200, 50);
		contentPane.add(lblMembershipId);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-d");
		dateChooser.setBounds(213, 326, 132, 20);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("yyyy-MM-d");
		dateChooser_1.setBounds(212, 448, 143, 20);
		contentPane.add(dateChooser_1);
		
		textField = new JTextField();
		textField.setBounds(212, 386, 180, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		String[] gender = {"Male","Female"};
		JComboBox comboBox = new JComboBox(gender);
		comboBox.setBounds(212, 295, 133, 20);
		contentPane.add(comboBox);
		
		JButton btnUpdate = new JButton("Add ");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
		        { 
					
					 String Sex=comboBox.getSelectedItem().toString();
				
					 
					String Name;
						String FHM_Name = "none";
						String Address = "none";
						String City ="none";
						int Pincode = 0;
						String State = "none";
						int mobileno = 0;
						int phoneno = 0;
						String DOB ="0000-00-00";
						String EduQualification = "none";
						String Occupation= "none";
						String email = "none";
					 
					 
					 String MembershipID = textField_13.getText();
					 Name = textField_1.getText();
					 FHM_Name = textField_2.getText();
					 Address = textField_3.getText();
					 City = textField_4.getText();
					Pincode = Integer.parseInt(textField_5.getText());
					 State = textField_6.getText();
					 mobileno = Integer.parseInt(textField_7.getText());
					 phoneno = Integer.parseInt(textField_8.getText());
					 DOB = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
					 EduQualification = textField_9.getText();
					 Occupation= textField.getText();
					 email = textField_11.getText();
					String date= ((JTextField)dateChooser_1.getDateEditor().getUiComponent()).getText();
					
					
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/audiolibrary", "root", "");
					Calendar calendar = Calendar.getInstance();
				    java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
					 
					String query = "INSERT INTO `audiolibrary`.`member_details` (`MembershipID`, `Name`, `Father's/Husband's/Mother's Name`, `Address`, `City`, `PinCode`, `State`, `PhoneNo`, `MobileNo`, `E-Mail`, `DateofBirth`, `Sex`, `EducationalQualification`, `Occupation`, `Date`)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					
					preparedStmt.setString (1, MembershipID);
				    preparedStmt.setString (2, Name);
				    preparedStmt.setString (3, FHM_Name);
				    preparedStmt.setString (4, Address);
				    preparedStmt.setString (5, City);
				    preparedStmt.setLong (6, Pincode);
				    preparedStmt.setString (7, State);
				    preparedStmt.setLong (8, phoneno);
				    preparedStmt.setLong (9, mobileno);
				    preparedStmt.setString (10, email);
				    preparedStmt.setString (11,DOB);
				    preparedStmt.setString (12, Sex);
				    preparedStmt.setString (13, EduQualification);
				    preparedStmt.setString (14, Occupation);
				    preparedStmt.setString (15, ((JTextField)dateChooser_1.getDateEditor().getUiComponent()).getText());
				    preparedStmt.execute();
				      
				   //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/audiolibrary", "root", "");
		           //java.sql.Statement st =  con.createStatement();
		           // ResultSet rs = st.executeQuery(query);
                    
		                    con.close();
		        }
		        catch(Exception e)
		        {
		            System.out.println("SQL exception occured" + e);
		        }			  
			}
		});
		btnUpdate.setBounds(124, 494, 89, 23);
		contentPane.add(btnUpdate);
		
		JLabel lblYyyymmdd = new JLabel("Format:-YYYY-MM-DD");
		lblYyyymmdd.setBounds(355, 330, 114, 14);
		contentPane.add(lblYyyymmdd);
		
		JLabel lblYyyymmdd_1 = new JLabel("Format:-YYYY-MM-DD");
		lblYyyymmdd_1.setBounds(365, 451, 104, 14);
		contentPane.add(lblYyyymmdd_1);
		
		JLabel lblFieldsAre = new JLabel("* Fields are required");
		lblFieldsAre.setBounds(336, 6, 143, 14);
		contentPane.add(lblFieldsAre);
		
		
	}
}
