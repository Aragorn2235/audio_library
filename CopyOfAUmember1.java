package audiolibrary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;

public class CopyOfAUmember1 extends JFrame {
	

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
	private JTextField textField;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopyOfAUmember1 frame = new CopyOfAUmember1();
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
	public CopyOfAUmember1() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 582);
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
		textField_1.setBounds(190, 51, 180, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		  textField_1.setEditable(false);
		
		JLabel lblMemberName = new JLabel("Member Name");
		lblMemberName.setBounds(58, 36, 200, 50);
		contentPane.add(lblMemberName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(190, 82, 178, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
		JLabel lblFathershusbandsmothersNmae = new JLabel("Father's/Husband's/Mothers Name");
		lblFathershusbandsmothersNmae.setBounds(20, 67, 200, 50);
		contentPane.add(lblFathershusbandsmothersNmae);
		
		textField_3 = new JTextField();
		textField_3.setBounds(190, 110, 180, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEditable(false);
		
		textField_4 = new JTextField();
		textField_4.setBounds(190, 141, 180, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setEditable(false);
		
		
		textField_5 = new JTextField();
		textField_5.setBounds(190, 172, 178, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		textField_5.setEditable(false);
		
		
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
		textField_6.setBounds(190, 203, 178, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		textField_6.setEditable(false);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(58, 188, 200, 50);
		contentPane.add(lblState);
		
		textField_7 = new JTextField();
		textField_7.setBounds(219, 234, 149, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		textField_7.setEditable(false);
		
		
		JLabel label = new JLabel("+91");
		label.setBounds(190, 219, 200, 50);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Mobile No");
		lblNewLabel.setBounds(58, 218, 200, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblPhoneNo = new JLabel("Phone No");
		lblPhoneNo.setBounds(58, 249, 89, 50);
		contentPane.add(lblPhoneNo);
		
		textField_8 = new JTextField();
		textField_8.setBounds(200, 265, 168, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		textField_8.setEditable(false);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(58, 280, 57, 50);
		contentPane.add(lblSex);
		
		textField_9 = new JTextField();
		textField_9.setBounds(190, 355, 178, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		textField_9.setEditable(false);
		
		JLabel lblEducationalQualification = new JLabel("Educational Qualification");
		lblEducationalQualification.setBounds(34, 340, 200, 50);
		contentPane.add(lblEducationalQualification);
		
		textField_10 = new JTextField();
		textField_10.setBounds(190, 386, 178, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		textField_10.setEditable(false);
		
		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setBounds(58, 371, 200, 50);
		contentPane.add(lblOccupation);
		
		textField_11 = new JTextField();
		textField_11.setBounds(190, 422, 178, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		textField_11.setEditable(false);
		
		textField_12 = new JTextField();
		textField_12.setBounds(190, 325, 118, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		textField_12.setEditable(false);
		
		textField_13 = new JTextField();
		textField_13.setBounds(190, 448, 118, 20);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		textField_13.setEditable(false);
		
		textField_14 = new JTextField();
		textField_14.setBounds(190, 296, 97, 20);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		textField_14.setEditable(false);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(58, 407, 39, 50);
		contentPane.add(lblEmail);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(46, 310, 71, 50);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblApprovedDateOf = new JLabel("Approved Date of Membership");
		lblApprovedDateOf.setBounds(13, 433, 149, 50);
		contentPane.add(lblApprovedDateOf);
		String[] gender = {"Male","Female"};
		//dateChooser_5.setEditable(false);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
		        { 
					int str1=Integer.parseInt(textField.getText());
					
					 String Sex=textField_14.getText();//(comboBox.getSelectedItem().toString();
				
					 
					 
					 //String MembershipID = textField_13.getText();
					String Name = textField_1.getText();
					String FHM_Name = textField_2.getText();
					String Address = textField_3.getText();
					String City = textField_4.getText();
					int Pincode = Integer.parseInt(textField_5.getText());
					String State = textField_6.getText();
					int mobileno = Integer.parseInt(textField_7.getText());
					int phoneno = Integer.parseInt(textField_8.getText());
					String DOB = textField_12.getText();
					String EduQualification = textField_9.getText();
					String Occupation= textField_10.getText();
					String email = textField_11.getText();
					String date= textField_13.getText();
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/audiolibrary", "root", "");
					Calendar calendar = Calendar.getInstance();
				    java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
					 
					String query = "UPDATE `audiolibrary`.`member_details` SET `Name`=?, `Father's/Husband's/Mother's Name`=?, `Address`=?, `City`=?, `PinCode`=?, `State`=?, `PhoneNo`=?, `MobileNo`=?, `E-Mail`=?, `DateofBirth`=?, `Sex`=?, `EducationalQualification`=?, `Occupation`=?, `Date`=? WHERE member_details.MembershipID=?";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					preparedStmt.setInt(15, str1);
					
				
				    preparedStmt.setString (1, Name);
				    preparedStmt.setString (2, FHM_Name);
				    preparedStmt.setString (3, Address);
				    preparedStmt.setString (4, City);
				    preparedStmt.setLong   (5, Pincode);
				    preparedStmt.setString (6, State);
				    preparedStmt.setLong (7, phoneno);
				    preparedStmt.setLong (8, mobileno);
				    preparedStmt.setString (9, email);
				    preparedStmt.setString (10,DOB);
				    preparedStmt.setString (11, Sex);
				    preparedStmt.setString (12, EduQualification);
				    preparedStmt.setString (13, Occupation);
				    preparedStmt.setString (14, date);
				    preparedStmt.execute();
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
		
		textField = new JTextField();
		textField.setBounds(134, 11, 135, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMembershipId = new JLabel("Membership ID *");
		lblMembershipId.setBounds(34, 14, 90, 14);
		contentPane.add(lblMembershipId);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {



		        //Create DataBase Coonection and Fetching Records
		 
		        try {
		    		int str=Integer.parseInt(textField.getText());
		     
		         String url = "jdbc:mysql://localhost:3306/audiolibrary";
		          //String driver = "jdbc.odbc.JdbcOdbcDriver";
		           String user = "root";
		           String password = "";
		          // Class.forName(driver);
		           Connection connection = DriverManager.getConnection(url,user, password);
		            PreparedStatement st = connection.prepareStatement("Select  `MembershipID`, `Name`, `Father's/Husband's/Mother's Name`, `Address`, `City`, `PinCode`, `State`, `PhoneNo`, `MobileNo`, `E-Mail`, `DateofBirth`, `Sex`, `EducationalQualification`, `Occupation`, `Date` FROM member_details M WHERE M.MembershipID=? ");
		            st.setInt(1, str);
		 
		            //Excuting Query
		            ResultSet rs = st.executeQuery();
		 
		            if (rs.next()) {
		                String s = rs.getString(2); //N
		                String s1 = rs.getString(3);//Fn
		                String s2 = rs.getString(4);//add
		                String s3 = rs.getString(5);//ci
		                String s4 = rs.getString(6);//pincode
		                String s5 = rs.getString(7);//sta
		                String s6 = rs.getString(8);//phone
		                String s7 = rs.getString(9);//mobile
		                String s8 = rs.getString(10);//email
		                String s9 = rs.getString(11);//date
		                String s10 = rs.getString(12);//sex
		                String s11 = rs.getString(13);//edu
		                String s12 = rs.getString(14);//occu
		                String s13 = rs.getString(15);//date
		               
		                
		                
		 
		                //Sets Records in TextFields.
		                textField_1.setEditable(true); 
		                textField_2.setEditable(true); 
		                textField_3.setEditable(true); 
		                textField_4.setEditable(true); 
		                textField_5.setEditable(true);
		                textField_6.setEditable(true); 
		                textField_7.setEditable(true); 
		                textField_8.setEditable(true); 
		                textField_9.setEditable(true); 
		                textField_10.setEditable(true); 
		                textField_11.setEditable(true); 
		                textField_14.setEditable(true);
		                textField_12.setEditable(true);
		                textField_13.setEditable(true);
		                textField_1.setText(s); 
		                textField_2.setText(s1); 
		                textField_3.setText(s2); 
		                textField_4.setText(s3); 
		                textField_5.setText(s4);
		                textField_6.setText(s5); 
		                textField_7.setText(s7); 
		                textField_8.setText(s6); 
		                textField_9.setText(s11); 
		                textField_10.setText(s12); 
		                textField_11.setText(s8); 
		                textField_14.setText(s10);
		                textField_12.setText(s9);
		                textField_13.setText(s13);
		                
		               
		                
		                
		            } else {
		                JOptionPane.showMessageDialog(null, "MemberShip ID doesn't exists");
		            }
		 
		            //Create Exception Handler
		        } catch (Exception ex) {
		 
		            System.out.println(ex);
		        }
		    
			
			
			}
		});
		btnSubmit.setBounds(301, 10, 89, 23);
		contentPane.add(btnSubmit);
		
		JLabel lblYyyymmdd = new JLabel("Format:-YYYY-MM-DD");
		lblYyyymmdd.setBounds(316, 451, 114, 14);
		contentPane.add(lblYyyymmdd);
		
		JLabel lblFormatyyyymmdd = new JLabel("Format:-YYYY-MM-DD");
		lblFormatyyyymmdd.setBounds(318, 328, 112, 14);
		contentPane.add(lblFormatyyyymmdd);
		
		
		
		
		
	}
}

