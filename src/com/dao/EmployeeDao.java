package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBConnection;

public class EmployeeDao {

	public void addEmployee() {

		// connection...
		Connection conn = DBConnection.getDatabaseConnection();
		// est connection
		if (conn != null) {

			// logic
			// 3rd statement
			try {
				Statement stmt = conn.createStatement();
				// preapare query
				Scanner sc = new Scanner(System.in);
				System.out.println("pls enter employee name");
				String name = sc.next();
				System.out.println("pls enter employee email");
				String email = sc.next();
				System.out.println("pls enter employee password");
				String password = sc.next();

				System.out.println("plsease select employee role");
				System.out.println("press 1 for dev");
				System.out.println("press 2 for pm");
				System.out.println("press 3 for tl");
				System.out.println("press 4 for ceo");
				int choice = sc.nextInt();
				int rid = 0;

				switch (choice) {
				case 1:

					rid = 1;

				case 2:
					rid = 2;
					break;

				case 3:
					rid = 3;
					break;
				case 4:
					rid = 4;
					break;

				default:
						System.out.println("no more roles available....");
					break;

				
					
				}

				String insertSQL = "insert into employee(ename,eemail,epassword,rid)values('" + name + "','" + email + "','"
						+ password + "',"+rid+")";
				// submit query...

				// executeUpdate(insertSQL); return int --> 1 2 3 4 10
				// execute return boolean -> DDL DML --> DDL FALSE DML TRUE procedure
				// executeQuery --->ResultSet INTERFACE select

				int res = stmt.executeUpdate(insertSQL);
				if (res > 0) {

					System.out.println(res + "raws affected..");
				} else {

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

		if (conn != null) {

			try {
				Scanner sc = new Scanner(System.in);
				Statement stmt = conn.createStatement();
				System.out.println("enter name to delete");
				String name = sc.next();
				String deleteSQL = " delete from employee where ename ='" + name + "'";

				int res = stmt.executeUpdate(deleteSQL);
				if (res > 0) {

					System.out.println(res + "raws deleted");
				} else {

					System.out.println("not deleted..");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	// update operation

	// 6th step interface -->

	public void getEmployeeData() {

		Connection conn = DBConnection.getDatabaseConnection();

		if (conn != null) {

			try {
				Statement stmt = conn.createStatement();
				String selectSQL = "select * from employee  natural join role";

				ResultSet rs = stmt.executeQuery(selectSQL);
				// rs

				while (rs.next()) {

					System.out.println();
					System.out.println("-----------------------------------");
					System.out.print(" " + rs.getInt("eid"));
					System.out.print("\t" + rs.getString("ename"));
					System.out.print("\t" + rs.getString("eemail"));
					System.out.print("\t" + rs.getString("epassword"));
					System.out.println("\t"+rs.getString("rname"));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	//prepa

	public static void main(String[] args) {

		EmployeeDao employeeDao = new EmployeeDao();
		// employeeDao.addEmployee();
		// employeeDao.deleteEmployee();
		employeeDao.getEmployeeData();
	}
}
