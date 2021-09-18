package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bean.StudentBean;
import com.util.DBConnection;

public class StudentDao1 implements StudentServices {

	Connection conn;
	PreparedStatement pstmt;

	@Override
	public boolean addStudent(StudentBean studentBean) {

		boolean flag = false;
		conn = DBConnection.getDatabaseConnection();
		if (conn != null) {

			String insertSQL = "insert  into student(sname,smarkas,sage)values(?,?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1, studentBean.getsName());
				pstmt.setInt(2, studentBean.getsMarks());
				pstmt.setInt(3, studentBean.getsAge());

				int res = pstmt.executeUpdate();
				if (res > 0) {

					flag = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flag;
	}

	@Override
	public List<StudentBean> studentList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentBean getHighestMarskStudent() {
		conn = DBConnection.getDatabaseConnection();
		StudentBean studentBean = null;
		if (conn != null) {

			String selectSQL = "select * from student where sage =(SELECT MAX(sage) from student)";
			try {
				pstmt = conn.prepareStatement(selectSQL);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					studentBean = new StudentBean();
					
					studentBean.setsId(rs.getInt("sid"));
					studentBean.setsAge(rs.getInt("sage"));
					studentBean.setsMarks(rs.getInt("smarkas"));
					studentBean.setsName(rs.getString("sname"));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return studentBean;
	}

}
