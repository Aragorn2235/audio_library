package audiolibrary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import java.awt.List;
import java.awt.Choice;
import java.awt.ScrollPane;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.toedter.calendar.JDateChooser;

public class CDmembers extends JFrame {
	

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CDmembers frame = new CDmembers();
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
	
	public CDmembers() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		setBounds(100, 100, 756, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Information info=new Information();
		contentPane.setLayout(null);
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-d");
		dateChooser.setBounds(115, 93, 91, 20);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("yyyy-MM-d");
		dateChooser_1.setBounds(115, 120, 91, 20);
		contentPane.add(dateChooser_1);
		

		JLabel lblFrom = new JLabel("From *");
		lblFrom.setBounds(10, 99, 46, 14);
		contentPane.add(lblFrom);
		
		JLabel lblTo = new JLabel("To *");
		lblTo.setBounds(10, 126, 46, 14);
		contentPane.add(lblTo);
		
		JLabel lblFormatyyyymmdd = new JLabel("Format:-YYYY-MM-DD");
		lblFormatyyyymmdd.setBounds(228, 93, 135, 14);
		contentPane.add(lblFormatyyyymmdd);
		
		JLabel lblFormatyyyymmdd_1 = new JLabel("Format:-YYYY-MM-DD");
		lblFormatyyyymmdd_1.setBounds(227, 124, 136, 14);
		contentPane.add(lblFormatyyyymmdd_1);
		
		JLabel lblMembershipId = new JLabel("Audio File Title");
		lblMembershipId.setBounds(10, 202, 91, 14);
		contentPane.add(lblMembershipId);
		
		JLabel lblName = new JLabel("Language");
		lblName.setBounds(131, 202, 91, 14);
		contentPane.add(lblName);
		
		JLabel lblAudioFile = new JLabel("Author");
		lblAudioFile.setBounds(248, 202, 79, 14);
		contentPane.add(lblAudioFile);
		
		JLabel lblIssuedDate = new JLabel("Membership ID");
		lblIssuedDate.setBounds(360, 202, 95, 14);
		contentPane.add(lblIssuedDate);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(485, 202, 85, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblLanguage = new JLabel("Issued Date");
		lblLanguage.setBounds(600, 202, 85, 14);
		contentPane.add(lblLanguage);
		
		
		
		JLabel lblAuthor = new JLabel("Author *");
		lblAuthor.setBounds(10, 45, 75, 14);
		contentPane.add(lblAuthor);
		
		JLabel lblLanguage_1 = new JLabel("Language *");
		lblLanguage_1.setBounds(10, 68, 91, 14);
		contentPane.add(lblLanguage_1);
		
		//textField = new JTextField();
		AutoCompleteComboBox box = new AutoCompleteComboBox(info.returnfile(), false);
		box.setBounds(115, 11, 146, 20);
		contentPane.add(box);
		//textField.setColumns(10);
		
		//textField_1 = new JTextField();
				AutoCompleteComboBox box_1 = new AutoCompleteComboBox(info.returnauthor(), false);
				box_1.setBounds(115, 42, 146, 20);
				contentPane.add(box_1);
				//textField_1.setColumns(10);
				
				//textField_2 = new JTextField();
				AutoCompleteComboBox box_2 = new AutoCompleteComboBox(info.returnlang(), false);
				box_2.setBounds(115, 68, 146, 20);
				contentPane.add(box_2);
				//textField_2.setColumns(10);
				
		DefaultTableModel model = new DefaultTableModel();
		table_2 = new JTable(model);
		table_2.setBounds(20, 221, 709, 227);
		contentPane.add(table_2);
		 model.addColumn("audiofile title");
		 model.addColumn("MembershipID");
		 model.addColumn("Name");
	
		 model.addColumn("Issued Date");
		 model.addColumn("author");
		 model.addColumn("language");
		 
		  
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(723, 221, 17, 227);
		contentPane.add(scrollBar);
		
		JLabel lblAudiofileName = new JLabel("Audio File Title  *");
		lblAudiofileName.setBounds(10, 14, 95, 14);
		contentPane.add(lblAudiofileName);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 System.out.println("break2;");

                //  model.clear();
		        //Create DataBase Coonection and Fetching Records
		 
		        try {
		       // int str = Integer.parseInt(textField.getText());
		         String url = "jdbc:mysql://localhost:3306/audiolibrary";
		          //String driver = "jdbc.odbc.JdbcOdbcDriver";
		           String user = "root";
		           String password = "";
		          // Class.forName(driver);
		           Connection connection = DriverManager.getConnection(url,user, password);
		            PreparedStatement st = connection.prepareStatement( " select DISTINCT issue_details.audio_title,issue_details.language,issue_details.author,member_details.MembershipID,member_details.Name,issue_details.issued_date from  issue_details,member_details where member_details.MembershipID=issue_details.MembershipID AND issue_details.audio_title=? AND issue_details.author=? AND issue_details.language=? AND issue_details.issued_date>=? AND issue_details.issued_date<=? ORDER BY issued_date");
		           // System.out.println("break3;");
		            st.setString(1, (String)box.getSelectedItem());
		            st.setString(2,(String)box_1.getSelectedItem());
		            st.setString(3,(String)box_2.getSelectedItem());
		            st.setString(4,((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
		            st.setString(5,((JTextField)dateChooser_1.getDateEditor().getUiComponent()).getText());
		            System.out.println("break1;");
		 
		            //Excuting Query
		            ResultSet rs = st.executeQuery();
		            
		            
		 /*
		           if (rs.next()) {
		                String s = rs.getString(1);
		                String s1 = rs.getString(2);
		                String s2 = rs.getString(3);
		                String s3 = rs.getString(4);
		                String s4 = rs.getString(5);
		                String s5 = rs.getString(6);
		                
		                model.addRow(new Object[] { s,s1,s2,s3,s4,s5});

		            }
		            */

		            while (rs.next()) {
		                String s = rs.getString(1);
		                String s1 = rs.getString(2);
		                String s2 = rs.getString(3);
		                int s3 = rs.getInt(4);
		                String s4 = rs.getString(5);
		                String s5 = rs.getString(6);
		                System.out.println("break;");
		                
		                model.addRow(new Object[] { s,s1,s2,s3,s4,s5});

		            }/*else {
		                JOptionPane.showMessageDialog(null, "MemberShip ID doesn't exists");
		            }*/
		 
		            //Create Exception Handler
		        } catch (Exception ex) {
		 
		            System.out.println(ex);
		        }
		    
			
			}
		});
		btnSubmit.setBounds(115, 151, 89, 23);
		contentPane.add(btnSubmit);
		
		JLabel lblFieldsAre = new JLabel("*  Fields are required");
		lblFieldsAre.setBounds(337, 27, 151, 14);
		contentPane.add(lblFieldsAre);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CDmembers frame = new CDmembers();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnClear.setBounds(228, 151, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(334, 151, 89, 23);
		contentPane.add(btnBack);
		
		
		
		
	}
}
