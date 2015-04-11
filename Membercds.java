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
import com.toedter.calendar.JDateChooser;

public class Membercds extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Membercds frame = new Membercds();
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
	
	public Membercds() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		setBounds(100, 100, 756, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-d");
		dateChooser.setBounds(115, 42, 91, 20);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("yyyy-MM-d");
		dateChooser_1.setBounds(115, 73, 91, 20);
		contentPane.add(dateChooser_1);
		
		textField = new JTextField();
		textField.setBounds(115, 11, 146, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		DefaultTableModel model = new DefaultTableModel();
		table_2 = new JTable(model);
		table_2.setBounds(10, 174, 709, 248);
		contentPane.add(table_2);
		 model.addColumn("audiofile title");
		 model.addColumn("MembershipID");
		 model.addColumn("Name");
	
		 model.addColumn("Issued Date");
		 model.addColumn("author");
		 model.addColumn("language");
		 
		  
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(723, 174, 17, 248);
		contentPane.add(scrollBar);
		
		JLabel lblAudiofileName = new JLabel("Membership ID *");
		lblAudiofileName.setBounds(10, 14, 85, 14);
		contentPane.add(lblAudiofileName);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                //  model.clear();
		        //Create DataBase Coonection and Fetching Records
		 
		        try {
		        int str = Integer.parseInt(textField.getText());
		         String url = "jdbc:mysql://localhost:3306/audiolibrary";
		          //String driver = "jdbc.odbc.JdbcOdbcDriver";
		           String user = "root";
		           String password = "";
		          // Class.forName(driver);
		           Connection connection = DriverManager.getConnection(url,user, password);
		            PreparedStatement st = connection.prepareStatement("select DISTINCT member_details.MembershipID,member_details.Name,issue_details.audio_title,issue_details.issued_date,issue_details.author,issue_details.language from issue_details,member_details where issue_details.MembershipID=? AND issue_details.MembershipID=member_details.MembershipID AND issue_details.issued_date>=? AND issue_details.issued_date<=? ORDER BY issued_date");
		            st.setInt(1, str);
		            st.setString(2,((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
		            st.setString(3,((JTextField)dateChooser_1.getDateEditor().getUiComponent()).getText());
		 
		            //Excuting Query
		            ResultSet rs = st.executeQuery();
		            
		            
		 
		           if (rs.next()) {
		                String s = rs.getString(1);
		                String s1 = rs.getString(2);
		                String s2 = rs.getString(3);
		                String s3 = rs.getString(4);
		                String s4 = rs.getString(5);
		                String s5 = rs.getString(6);
		                
		                model.addRow(new Object[] { s,s1,s2,s3,s4,s5});

		            }
		            

		            while (rs.next()) {
		                String s = rs.getString(1);
		                String s1 = rs.getString(2);
		                String s2 = rs.getString(3);
		                String s3 = rs.getString(4);
		                String s4 = rs.getString(5);
		                String s5 = rs.getString(6);
		                
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
		btnSubmit.setBounds(117, 114, 89, 23);
		contentPane.add(btnSubmit);
		
		
		
		JLabel lblFrom = new JLabel("From *");
		lblFrom.setBounds(10, 48, 46, 14);
		contentPane.add(lblFrom);
		
		JLabel lblTo = new JLabel("To *");
		lblTo.setBounds(10, 79, 46, 14);
		contentPane.add(lblTo);
		
		JLabel lblFormatyyyymmdd = new JLabel("Format:-YYYY-MM-DD");
		lblFormatyyyymmdd.setBounds(228, 48, 135, 14);
		contentPane.add(lblFormatyyyymmdd);
		
		JLabel lblFormatyyyymmdd_1 = new JLabel("Format:-YYYY-MM-DD");
		lblFormatyyyymmdd_1.setBounds(227, 79, 136, 14);
		contentPane.add(lblFormatyyyymmdd_1);
		
		JLabel lblMembershipId = new JLabel("Membership ID");
		lblMembershipId.setBounds(10, 157, 85, 14);
		contentPane.add(lblMembershipId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(127, 157, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblAudioFile = new JLabel("Audio File");
		lblAudioFile.setBounds(247, 157, 79, 14);
		contentPane.add(lblAudioFile);
		
		JLabel lblIssuedDate = new JLabel("Issued date");
		lblIssuedDate.setBounds(364, 157, 76, 14);
		contentPane.add(lblIssuedDate);
		
		JLabel lblNewLabel = new JLabel("Author");
		lblNewLabel.setBounds(484, 157, 85, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setBounds(602, 157, 85, 14);
		contentPane.add(lblLanguage);
		
		JLabel lblFieldsAre = new JLabel("* Fields are required");
		lblFieldsAre.setBounds(363, 14, 146, 14);
		contentPane.add(lblFieldsAre);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Membercds frame = new Membercds();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnClear.setBounds(223, 114, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(335, 114, 89, 23);
		contentPane.add(btnBack);
		
	}
}
