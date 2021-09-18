package com.controller;

import java.util.Scanner;

import com.bean.StudentBean;
import com.dao.StudentDao1;

public class StudentController {

	
	//driver class --> JSP / HTML
	//Scanner
	
	public void addStudent() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter student name");
		String sName  = sc.next();
		System.out.println("enter student age");
		int sAge = sc.nextInt();
		System.out.println("enter student marks");
		int sMarks = sc.nextInt();
		
		//HTML/JSP FORM
		StudentBean studentBean = new StudentBean();
		studentBean.setsName(sName);
		studentBean.setsAge(sAge);
		studentBean.setsMarks(sMarks);
		
//		StudentDao1 studentDao1 = new StudentDao1();
//		boolean flag = studentDao1.addStudent(studentBean);
//		if(flag==true) {
//			
//		}
//		else {
//			
//		}
		
		
		if(new StudentDao1().addStudent(studentBean)) {
		
				System.out.println("STUDENT ADDED...");
			
		}
		else {
			
			System.out.println("NOT ADDED..");
		}
		
	}
	
	public void getHighestmarksdata() {
		
		StudentBean studentBean = new StudentDao1().getHighestMarskStudent();
		System.out.println(studentBean.getsName()+" -- "+studentBean.getsMarks());
		
		
	}
	
	public static void main(String[] args) {
		
		
		StudentController studentController = new StudentController();
		//studentController.addStudent();
		studentController.getHighestmarksdata();
	}
}
