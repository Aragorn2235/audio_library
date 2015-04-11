package audiolibrary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.toedter.calendar.JDateChooser;

import java.io.*;
public class Issue extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnIssueAndOpen;

	DateFormat issued_date=DateFormat.getDateInstance();
	private JDateChooser date_fetch;
	private JTextField textField_2;
	private JTextField textField_3;
	String location;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issue frame = new Issue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Issue() throws SQLException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Information info=new Information();
		
		textField = new JTextField();
		textField.setBounds(132, 33, 186, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMembershipId = new JLabel("Membership ID *");
		lblMembershipId.setBounds(36, 18, 200, 50);
		contentPane.add(lblMembershipId);
	//	String [] gender={"male","female"};
		AutoCompleteComboBox box = new AutoCompleteComboBox(info.returnfile(), false);
		box.setBounds(132, 64, 186, 20);
		contentPane.add(box);
		//textField_2 = new JTextField();
				AutoCompleteComboBox box_2 = new AutoCompleteComboBox(info.returnlang(), false);
				//textField_2.setBounds(132, 151, 186, 20);
				box_2.setBounds(132, 151, 186, 20);
				contentPane.add(box_2);
				//contentPane.add(textField_2);
				//textField_2.setColumns(10);
				
				//textField_3 = new JTextField();
				AutoCompleteComboBox box_3 = new AutoCompleteComboBox(info.returnauthor(), false);
				//textField_3.setBounds(132, 182, 186, 20);
				box_3.setBounds(132, 182, 186, 20);
				contentPane.add(box_3);
				//contentPane.add(textField_3);
				//textField_3.setColumns(10);
		JLabel lblAudioFileTitle = new JLabel("Audio File Title *");
		lblAudioFileTitle.setBounds(36, 49, 200, 50);
		contentPane.add(lblAudioFileTitle);
		
		JLabel lblDateOfIssued = new JLabel("Issued Date *");
		lblDateOfIssued.setBounds(36, 100, 84, 27);
		contentPane.add(lblDateOfIssued);
		
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
			}
		});
		btnCancel.setBounds(259, 227, 126, 23);
		contentPane.add(btnCancel);
		
		btnIssueAndOpen = new JButton(" Issue and open folder");
		btnIssueAndOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try{
					
				    
				    
					String MembershipID = textField.getText();
					String audio_title = (String)box.getSelectedItem();
					String language =(String)box_2.getSelectedItem();
					String author = (String)box_3.getSelectedItem();
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/audiolibrary", "root", "");
					String addfile = "INSERT INTO `audiolibrary`.`issue_details` (`audio_title`, `MembershipID`, `issued_date`, `language`, `author`) VALUES (?, ?, ?, ?, ?);";
					
					 PreparedStatement preparedStmt = con.prepareStatement(addfile);
				      preparedStmt.setString (1, audio_title);
				      preparedStmt.setString (2, MembershipID);
				      preparedStmt.setString (3, ((JTextField)date_fetch.getDateEditor().getUiComponent()).getText());
				      preparedStmt.setString (4, language);
				      preparedStmt.setString (5, author);
				      preparedStmt.execute();
				     // con.close();
				      
				      try{
				      //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/audiolibrary", "root", "");
				      PreparedStatement st = con.prepareStatement("SELECT ad.Path FROM audiolibrary.audio_file_details ad where ad.audio_title=? AND ad.author=? AND ad.language=?; ");
				      st.setString(1, audio_title);
				      st.setString(2, author);
				      st.setString(3, language);
				      ResultSet rs = st.executeQuery();
				      if (rs.next()){
				        location=rs.getString(1);
				      }
				      // System.out.println(location+"aaaaaaaaaaaaaaaaaaaaaaaa");
				      // System.out.println("avinash");
				      
				      con.close();
				      }
				      catch(Exception e){
				    	  System.out.println("error");
							
						}
					
				}
				catch(Exception e){
					
				}
				try {
					OpenFolder open=new OpenFolder(location);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnIssueAndOpen.setBounds(57, 227, 179, 23);
		contentPane.add(btnIssueAndOpen);
		
		date_fetch = new JDateChooser();
		date_fetch.setDateFormatString("yyyy-MM-d");
		date_fetch.setBounds(132, 100, 104, 20);
		contentPane.add(date_fetch);
		
		JLabel lblNewLabel = new JLabel("Language *");
		lblNewLabel.setBounds(36, 148, 88, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblAuthor = new JLabel("Author *");
		lblAuthor.setBounds(36, 185, 46, 14);
		contentPane.add(lblAuthor);
		
		JLabel lblFieldsAre = new JLabel("* Fields are required");
		lblFieldsAre.setBounds(259, 8, 165, 14);
		contentPane.add(lblFieldsAre);
		
		
	}
}