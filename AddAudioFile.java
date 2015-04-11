package audiolibrary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.ItemSelectable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.JFormattedTextField;

import java.awt.Choice;

public class AddAudioFile extends JFrame    {
	static private String selectedString(ItemSelectable is) {
	    Object selected = is.getSelectedObjects();
	    return (String) selected;
	  }

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JLabel statusLabel;
	static String data;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAudioFile frame = new AddAudioFile();
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
	public AddAudioFile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblAudiofilename = new JLabel("Audio File Name *");
		lblAudiofilename.setBounds(10, 11, 89, 50);
		contentPane.add(lblAudiofilename);
		
		JLabel lblLanguage = new JLabel("Language *");
		lblLanguage.setBounds(10, 80, 83, 31);
		contentPane.add(lblLanguage);
		
		JLabel lblAuthor = new JLabel("Author *");
		lblAuthor.setBounds(10, 122, 83, 50);
		contentPane.add(lblAuthor);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Home gotohome = new Home();
					gotohome.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				setVisible(false);
			}
		});
		btnCancel.setBounds(277, 210, 89, 23);
		contentPane.add(btnCancel);
		
		textField = new JTextField();
		textField.setBounds(103, 22, 230, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(103, 136, 230, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(103, 80, 230, 23);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		table = new JTable();
		table.setBounds(381, 159, 1, 1);
		contentPane.add(table);
		
		String paths[] = { "C:/Desktop", "aa" };
	    
		
		JButton btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try{
						ItemListener itemListener = new ItemListener() {
						      public void itemStateChanged(ItemEvent itemEvent) {
						        int state = itemEvent.getStateChange();
						        ItemSelectable is = itemEvent.getItemSelectable();
						        data= selectedString(is);
						        System.out.println(data);
						      }
						    };
		//				    comboBox.addItemListener(itemListener);
						    				
						
			         
						
						String audiofilename = textField.getText();
						String language = textField_1.getText();
						String author = textField_2.getText();
						String path=textField_3.getText();
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/audiolibrary", "root", "");
						 String addfile = " insert into audio_file_details (audio_file_details.audio_title,audio_file_details.author ,audio_file_details.language, audio_file_details.Path)" + " values (?, ?, ?, ?);";
						
						 PreparedStatement preparedStmt = con.prepareStatement(addfile);
					      preparedStmt.setString (1, audiofilename);
					      preparedStmt.setString (2, language);
					      preparedStmt.setString (3, author);
					      preparedStmt.setString (4, path);
					      preparedStmt.execute();
					       
					      con.close();
				
					}
					catch(Exception e){
						System.err.println(e.getMessage());
					}
				}
			});
			btnAdd.setBounds(164, 210, 89, 23);
			contentPane.add(btnAdd);
			
			JButton btnChooseFile = new JButton("Choose Path");
			btnChooseFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Path p=new Path();
					
					
				}
			});
			
			
			
			btnChooseFile.setBounds(363, 171, 128, 23);
			contentPane.add(btnChooseFile);
			
			JLabel lblPath = new JLabel("Path *");
			lblPath.setBounds(10, 174, 46, 14);
			contentPane.add(lblPath);
			
			textField_3 = new JTextField();
			textField_3.setBounds(103, 170, 230, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblFieldsAre = new JLabel("*  Fields are required");
			lblFieldsAre.setBounds(368, 47, 133, 14);
			contentPane.add(lblFieldsAre);
			
			
	}
	
		
	
}