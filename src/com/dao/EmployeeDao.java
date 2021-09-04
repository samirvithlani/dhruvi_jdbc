package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBConnection;

public class EmployeeDao {

	public void addEmployee() {
		
		//connection...
		Connection conn = DBConnection.getDatabaseConnection();
		//est connection
		if(conn!=null) {
			
			//logic
			//3rd statement
			try {
				Statement stmt =conn.createStatement();
				//preapare query
				Scanner sc = new Scanner(System.in);
				System.out.println("pls enter employee name");
				String name = sc.next();
				System.out.println("pls enter employee email");
				String email = sc.next();
				System.out.println("pls enter employee password");
				String password = sc.next();
				
				
				String insertSQL ="insert into employee(ename,eemail,epassword)values('"+name+"','"+email+"','"+password+"')";
				//submit query...
				
				//executeUpdate(insertSQL); return int --> 1 2 3 4 10
				//execute      return boolean     -> DDL DML    -->  DDL FALSE  DML TRUE procedure
				//executeQuery   --->ResultSet INTERFACE select
				
				int res = stmt.executeUpdate(insertSQL);
				if(res>0) {
					
					System.out.println(res + "raws affected..");
				}
				else {
					
					System.out.println(res + "raws affected..");
				}
				
				stmt.close();
				conn.close();
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	public void deleteEmployee() {
		
		
		Connection conn = DBConnection.getDatabaseConnection();
		
		if(conn!=null) {
			
			try {
				Scanner sc = new Scanner(System.in);
				Statement stmt = conn.createStatement();
				System.out.println("enter name to delete");
				String name = sc.next();
				String deleteSQL = " delete from employee where ename ='"+name+"'";
				
				int res = stmt.executeUpdate(deleteSQL);
				if(res>0) {
					
					System.out.println(res+ "raws deleted");
				}
				else {
					
					System.out.println("not deleted..");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 
		}
	}
	
	//update operation
	
	
	public static void main(String[] args) {
		
		
		EmployeeDao employeeDao = new EmployeeDao();
		//employeeDao.addEmployee();
		employeeDao.deleteEmployee();
	}
}
