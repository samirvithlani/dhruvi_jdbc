package com.dao;

import java.util.List;

import com.bean.StudentBean;

public interface StudentServices {

	
	public boolean addStudent(StudentBean studentBean);
	public List<StudentBean> studentList();
	public StudentBean getHighestMarskStudent();
	
}
