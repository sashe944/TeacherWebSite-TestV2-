package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import objects.Teacher;

public class FindTeacherService {
	
	public Teacher find(String Name, String Password){
		Teacher teacher = new Teacher();
    	  Connection conn = null;
    	    Statement stmt = null;
    	    try{
    	    	Class.forName("org.sqlite.JDBC");
    	    	conn=DriverManager.getConnection("jdbc:sqlite:/C:/Users/Home/Desktop/TestV2.db");
    	        conn.setAutoCommit(false);
    	        stmt = conn.createStatement();
    	        ResultSet rs = stmt.executeQuery("SELECT * FROM User WHERE"
    	        		+ " Name = \"" + Name + 
    	        		"\" AND Password=\"" +Password + "\"");

    	        while (rs.next()){
    	        	teacher.id = rs.getInt("_id");
    	            teacher.email = rs.getString("Email");
    	        	teacher.name = rs.getString("Name");
    	        	teacher.gender = rs.getString("Gender");
    	        	teacher.password = rs.getString("Password");
    	        	teacher.usertypeid = rs.getString("UserTypeID");
    	        	
    	        }  
    	    }
    	    catch(Exception e){
    	    	e.printStackTrace();
    	    } finally {
    			try {
    				stmt.close();
    				conn.close();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    	    System.out.println(teacher.toString());
		return teacher;
	}

}
