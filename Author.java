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

public class Author extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Author frame = new Author();
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
	public Author() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAuthor = new JLabel("Author *");
		lblAuthor.setBounds(22, 33, 46, 14);
		contentPane.add(lblAuthor);
		
		Information info=new Information();
		AutoCompleteComboBox box = new AutoCompleteComboBox(info.returnauthor(), false);
		box.setBounds(91, 30, 186, 20);
		contentPane.add(box);
		
		
		DefaultTableModel model = new DefaultTableModel();
		table_2 = new JTable(model);
		table_2.setBounds(10, 115, 403, 135);
		contentPane.add(table_2);
		 model.addColumn("audiofile title");
		 model.addColumn("Language");
		 model.addColumn("Author");
		 
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				      
				         String url = "jdbc:mysql://localhost:3306/audiolibrary";
				          
				           String user = "root";
				           String password = "";
				      
				           Connection connection =  DriverManager.getConnection(url,user, password);
				            PreparedStatement st = connection.prepareStatement( " select audio_file_details.audio_title,audio_file_details.language,audio_file_details.author from audio_file_details  where audio_file_details.author=?");
				           
				            st.setString(1, (String)box.getSelectedItem());
				            
				 
				           
				            ResultSet rs = st.executeQuery();
				            
				            
			

				            while (rs.next()) {
				                String s = rs.getString(1);
				                String s1 = rs.getString(2);
				                String s2 = rs.getString(3);
				              
				               // DefaultTableModel model = new DefaultTableModel();
				                
				                model.addRow(new Object[] { s,s1,s2});

				            }
				        } catch (Exception ex) {
				 
				            System.out.println(ex);
				        }
			}
		});
		btnSubmit.setBounds(91, 61, 89, 23);
		contentPane.add(btnSubmit);
		
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
		btnCancel.setBounds(289, 61, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblAudioFileName = new JLabel("Audio File Name");
		lblAudioFileName.setBounds(10, 96, 112, 14);
		contentPane.add(lblAudioFileName);
		
		JLabel lblAuthor_1 = new JLabel("Language");
		lblAuthor_1.setBounds(158, 96, 89, 14);
		contentPane.add(lblAuthor_1);
		
		JLabel lblPath = new JLabel("Author");
		lblPath.setBounds(301, 96, 66, 14);
		contentPane.add(lblPath);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(417, 115, 17, 135);
		contentPane.add(scrollBar);
		
		JLabel lblNewLabel = new JLabel("* Fields are required");
		lblNewLabel.setBounds(313, 33, 121, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(188, 61, 89, 23);
		contentPane.add(btnClear);
		
	}
}
