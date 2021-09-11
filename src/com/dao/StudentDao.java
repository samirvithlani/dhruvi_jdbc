package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBConnection;

public class StudentDao {

	//preparedStatement -->
	//query compile
	
	
	public void addStudent() {
		
		Connection conn = DBConnection.getDatabaseConnection();
		//place holders -->
		String insertSQL = "insert  into student(sname,smarkas,sage)values(?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(insertSQL);
			
			pstmt.setString(1, "jay");
			pstmt.setInt(2, 550);
			pstmt.setInt(3, 15);
			
			
			int res = pstmt.executeUpdate();
			if(res>0) {
				
				System.out.println("inserted..");
			}
			else {
				
				System.out.println("not inserted.."); 
				
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
public void addStudents() {
		
		Connection conn = DBConnection.getDatabaseConnection();
		//place holders -->
		String insertSQL = "insert  into student(sname,smarkas,sage)values(?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(insertSQL);
			
			pstmt.setString(1, "jaya");
			pstmt.setInt(2, 450);
			pstmt.setInt(3, 17);
			
			//add to batch-->
			pstmt.addBatch();
			
			pstmt.setString(1, "jayanti");
			pstmt.setInt(2, 570);
			pstmt.setInt(3, 18);
			
			pstmt.addBatch();
			
			pstmt.setString(1, "raj");
			pstmt.setInt(2, 590);
			pstmt.setInt(3, 20);
			
			pstmt.addBatch();
		
			
			int res[] = pstmt.executeBatch();
			
			if(res.length>0) {
				
				System.out.println(res.length+" students inserted..");
			}
			else {
				
				System.out.println("not inserted.."); 
				
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void updateStudent() {
		
		
		Connection conn= DBConnection.getDatabaseConnection();
		if(conn!=null) {
			
			//"delete from student where sid = ?"
			String updateSQL = "update student set smarkas =? where sname = ? ";
			try {
				PreparedStatement pstmt = conn.prepareStatement(updateSQL);
				pstmt.setInt(1, 600);
				pstmt.setString(2,"raj");
				pstmt.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
				
		
	}
	
	
	public static void main(String[] args) {
		
	
		StudentDao s = new StudentDao();
		//s.addStudents();
		s.updateStudent();
		
	}
	
}
