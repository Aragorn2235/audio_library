package audiolibrary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Choice;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateAudioLibrary extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateAudioLibrary frame = new UpdateAudioLibrary();
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
	public UpdateAudioLibrary() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Information info=new Information();
		JLabel lblAudiofilename = new JLabel("Audio File Title *");
		lblAudiofilename.setBounds(32, 27, 89, 24);
		contentPane.add(lblAudiofilename);
		
		//textField = new JTextField();
		AutoCompleteComboBox box = new AutoCompleteComboBox(info.returnfile(), false);
		//textField.setBounds(131, 29, 140, 20);
		box.setBounds(131, 29, 140, 20);
		contentPane.add(box);
		//contentPane.add(textField);
		//textField.setColumns(10);
		//textField_2 = new JTextField();
		AutoCompleteComboBox box_2 = new AutoCompleteComboBox(info.returnlang(), false);
		//textField_2.setBounds(131, 60, 140, 20);
		box_2 .setBounds(131, 60, 140, 20);
		//contentPane.add(textField_2);
		contentPane.add(box_2);
		//textField_2.setColumns(10);
		
		//textField_3 = new JTextField();
		AutoCompleteComboBox box_3 = new AutoCompleteComboBox(info.returnauthor(), false);
		box_3.setBounds(131, 91, 140, 20);
		contentPane.add(box_3);
		//textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(131, 171, 140, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		//textField_4.setVisible(false);
		textField_4.setEditable(false);
		
		JButton btnUpdate = new JButton("Choose File");
		btnUpdate.addActionListener(new ActionListener() {
			public String promptForFolder( Component parent )
			{
			    JFileChooser fc = new JFileChooser();
			    fc.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );

			    if( fc.showOpenDialog( parent ) == JFileChooser.APPROVE_OPTION )
			    {
			        return fc.getSelectedFile().getAbsolutePath();
			    }

			    return null;
			}	
			public void actionPerformed(ActionEvent arg0) {
				Path p=new Path();
			}
		});
		btnUpdate.setBounds(298, 170, 111, 23);
		contentPane.add(btnUpdate);
		
		JLabel lblNewLabel_1 = new JLabel("Path");
		lblNewLabel_1.setBounds(32, 174, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Language *");
		lblNewLabel_2.setBounds(32, 62, 81, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Author *");
		lblNewLabel_3.setBounds(32, 94, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnUpdate_1 = new JButton(" Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					//int str = Integer.parseInt(textField.getText());
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/audiolibrary", "root", "");
					PreparedStatement st = con.prepareStatement("UPDATE `audiolibrary`.`audio_file_details` SET `Path`=? where audio_file_details.audio_title=? AND audio_file_details.language=? AND audio_file_details.author=?" );
					st.setString(1,textField_4.getText());
					st.setString(2,(String)box.getSelectedItem());
					st.setString(3,(String)box_2.getSelectedItem());
					st.setString(4,(String)box_3.getSelectedItem());
		 
		            //Excuting Query
		           st.execute();
		           con.close();
		 
		         /*   if (rs.next()) {
						
						String s1 = rs.getString(2);
		                String s2 = rs.getString(3);
		                String s3 = rs.getString(4);
		                String s4 = rs.getString(5);
		                
						
						textField_1.setText(s1);
		                textField_2.setText(s2);
		                textField_3.setText(s3);
		                textField_4.setText(s4);
		            } else {
		                JOptionPane.showMessageDialog(null, "MemberShip ID doesn't exists");
		            }*/
		 
		            //Create Exception Handler
		        } catch (Exception e) {
		 
		            System.out.println(e);
		        }
		    
			}
		});
		btnUpdate_1.setBounds(131, 216, 89, 23);
		contentPane.add(btnUpdate_1);
		
		
		
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
		btnCancel.setBounds(242, 216, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/audiolibrary", "root", "");
					PreparedStatement st = con.prepareStatement("select ad.Path from audio_file_details ad where ad.audio_title=? AND ad.language=? AND ad.author=?");
					st.setString(1,(String)box.getSelectedItem());
					st.setString(2,(String)box_2.getSelectedItem());
					st.setString(3,(String)box_3.getSelectedItem());
					ResultSet rs = st.executeQuery();
					  textField_4.setEditable(true);
					  if (rs.next()){
					   textField_4.setText(rs.getString(1));
					  }
					  
					  
					con.close();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnSubmit.setBounds(131, 122, 89, 23);
		contentPane.add(btnSubmit);
		
		JLabel lblFieldsAre = new JLabel("* Fields are required");
		lblFieldsAre.setBounds(275, 11, 149, 14);
		contentPane.add(lblFieldsAre);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
