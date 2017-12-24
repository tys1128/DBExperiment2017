package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PersonDAO;
import entity.StuInfo;
import entity.Student;
import entity.Teacher;

public class AdminDAO implements PersonDAO{
	Connection conn;

	public AdminDAO() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@47.94.200.154:1521:ORCL", "teacher", "teacher");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * �жϵ�½�Ƿ�Ϸ�
	 * 
	 * @param userid
	 *            ��½�û�������ID
	 * @param password
	 *            ��½����
	 * @return �Ƿ�Ϸ�
	 */
	@Override
	public boolean canLogin(String userid, String password) {
		boolean can = false;
		return can;
	}

	/**
	 * ���ѧ������
	 */
	@Override
	public String getName(String id) {
		return null;
	}


	public List<Teacher> getTeacher() {
		List<Teacher> tList = new ArrayList<Teacher>();
		try {
			Statement stmt = conn.createStatement();
			//
			String sql = "select*\r\n"
					+ "from instructor";
			
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.name = rs.getString(2);
				teacher.id = rs.getString(1);
				teacher.sex = rs.getString(6);
				teacher.department_Name = rs.getString(3);
				teacher.salary = rs.getFloat(4);
				
				tList.add(teacher);
			}
			rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tList;

	}
	public List<Student> getStudent() {
		List<Student> sList = new ArrayList<Student>();
		try {
			Statement stmt = conn.createStatement();
			//
			String sql = "select*\r\n"
					+ "from student";
			
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Student stu = new Student();
				stu.name = rs.getString(2);
				stu.id = rs.getString(1);
				stu.sex = rs.getString(6);
				stu.department_Name = rs.getString(4);
				stu.tol_cred = rs.getFloat(3);
				
				sList.add(stu);
			}
			rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sList;

	}
	/**
	 * �ر�DAO
	 */
	@Override
	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
