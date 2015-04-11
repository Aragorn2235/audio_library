package audiolibrary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Language extends JFrame {

	private JPanel contentPane;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {                         // this where we create Jframe for this module
				try {
					Language frame = new Language();
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
	public Language() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();                           //here we are jpanel to this Jframe and setting boundaries according to it
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel();  /*here we are creating Jtable there we can display information of
		                                                     audio files for particular Language in respective columns*/
		table_2 = new JTable(model);
		table_2.setBounds(26, 111, 398, 139);
		contentPane.add(table_2);
		 model.addColumn("audiofile title");              //Here are we are adding coulmn names that are going to display from audio File
		 model.addColumn("language");
		 model.addColumn("author");
	
		
		Information info = new Information();      // here we are calling this class to get complete list of audio_titles,Authors,languages present in the database
		AutoCompleteComboBox box_2 = new AutoCompleteComboBox(info.returnlang(), false);
		box_2.setBounds(99, 26, 146, 20);         //this is pop-up search based box when you write input it suggests which names are there in database
		contentPane.add(box_2);
		
		JButton btnSubmit = new JButton(" Submit");    //created this button ,By clicking this we get the list of audiofiles for paticular language
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{ 
				String url = "jdbc:mysql://localhost:3306/audiolibrary";
		          //String driver = "jdbc.odbc.JdbcOdbcDriver";
		           String user = "root";
		           String password = "";
		          // Class.forName(driver);
		           Connection connection = DriverManager.getConnection(url,user, password);
		            PreparedStatement st = connection.prepareStatement( " select audio_file_details.audio_title,audio_file_details.language,audio_file_details.author from  audio_file_details where   audio_file_details.language=? ");
		                                    // The above commands are for connecting to database
		            
		            st.setString(1,(String)box_2.getSelectedItem());  //get the input from respective combo box and keep it in respective ?
		           
		            //Excuting Query
		            ResultSet rs = st.executeQuery();  //executing the above query in database
		           
		            while (rs.next()) {
		                String s = rs.getString(1);
		                String s1 = rs.getString(2);          //we are fetching the output values from database according to above query 
		                String s2 = rs.getString(3);
		               
		                
		                model.addRow(new Object[] { s,s1,s2}); //And keeping this values in the Jtable to display values to users

		            }
		        } catch (Exception ex) {
		 
		            System.out.println(ex); // to dispaly error message when we are not connected to database
		        }
				
			}
		});
		btnSubmit.setBounds(31, 69, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnClear = new JButton("Clear");               //created this button to clear the complete text and ready for to execute next query
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClear.setBounds(145, 69, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnCancel = new JButton("Cancel");              //this button is created,By clicking it goes to main menu
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
		btnCancel.setBounds(241, 69, 89, 23);                 
		contentPane.add(btnCancel);
		
		JLabel lblLanguage = new JLabel("Language*");        /*These are jlabels to identify the particular textfields that should be filled with 
		                                                       information and make user to type input according to these labels*/
		lblLanguage.setBounds(26, 29, 74, 14);
		contentPane.add(lblLanguage);
		
		JLabel lblAudioFileName = new JLabel("Audio File Name");
		lblAudioFileName.setBounds(27, 92, 93, 14);
		contentPane.add(lblAudioFileName);
		
		JLabel lblLanguage_1 = new JLabel("Language");
		lblLanguage_1.setBounds(155, 92, 65, 14);
		contentPane.add(lblLanguage_1);
		
		JLabel lblNewLabel = new JLabel("Author");
		lblNewLabel.setBounds(266, 92, 46, 14);
		contentPane.add(lblNewLabel);
	}
}
