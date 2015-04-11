package audiolibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Information {
	Vector<String> file=new Vector<String>();
	Vector<String> author=new Vector<String>();
	Vector<String> language=new Vector<String>();

	public  Information() throws SQLException{
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/audiolibrary","root","");
         PreparedStatement st = connection.prepareStatement("select audio_file_details.audio_title,audio_file_details.author,audio_file_details.language from audio_file_details");
         ResultSet rs = st.executeQuery();
         while(rs.next()){
         file.addElement(rs.getString(1));
         String str=rs.getString(2);
         author.addElement(str);
         String str1=rs.getString(3);
         language.addElement(str1);
         System.out.println(str1);
         
         }
         
        
        }
	public Vector<String> returnfile(){
    	return file;
        }
	public Vector<String> returnauthor(){
    	return author;
        }
	public Vector<String> returnlang(){
    	return language;
        }
         
         
	}


