package dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.PersonDAO;
import entity.*;

public class TeacherDAO implements PersonDAO {
	Connection conn;

	public TeacherDAO() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@47.94.200.154:1521:ORCL", "teacher", "teacher");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 判断老师登陆是否合法
	 * 
	 * @param userid
	 *            登陆用户名，即老师ID
	 * @param password
	 *            登陆密码
	 * @return 是否合法
	 */
	@Override
	public boolean canLogin(String userid, String password) {
		boolean can = false;
		try {
			Statement stmt = conn.createStatement();
			String sql = "select password from instructor where id='" + userid + "'";
			ResultSet rs = stmt.executeQuery(sql);

			rs.next();
			String pw = rs.getString("password");
			if (password.equals(pw)) {
				can = true;
			} else {
				can = false;
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return can;
	}

	/**
	 * 获得教师姓名
	 */
	@Override
	public String getName(String id) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "select name from instructor where id='" + id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			return rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得教师的所有课程
	 * 
	 * @param id 教师id
	 * @return 课程列表
	 */
	public List<SectionInfo> getSectionInfo(String id) {
		List<SectionInfo> sList = new ArrayList<SectionInfo>();
		String[] week = new String[] { "一", "二", "三", "四", "五", "六", "日" };
		try {
			Statement stmt = conn.createStatement();
			//
			String sql = "select title,building,room_num,time_slot\r\n"
					+ "from course natural join section natural join teaches \r\n" + "where teaches.id='" + id + "'";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				SectionInfo sInfo = new SectionInfo();
				sInfo.courseName = rs.getString(1);
				sInfo.buliding = rs.getString(2);
				sInfo.classroom = rs.getString(3);
				// 处理时间
				String str = rs.getString(4);
				sInfo.week = str.charAt(0) - '0';
				sInfo.lession = str.charAt(2) - '0';
				sInfo.time = "星期" + week[sInfo.week] + " 第" + sInfo.lession + "节";

				sList.add(sInfo);
			}
			rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sList;
	}

	/**
	 * 关闭DAO
	 */
	@Override
	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 这是读取或查询老师个人基本信息的功能函数说明 无参
	 * 
	 * @return 所要查询的老师的信息
	 */
	public ArrayList<Teacher> getTeacherManagement_Privilege() {
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		try {

			Connection conn_1 = DriverManager.getConnection("jdbc:oracle:thin:@47.94.200.154:1521:ORCL", "teacher",
					"teacher");
			Statement state_1 = conn_1.createStatement();
			String sql = "select name,id,dept_name,salary from instructor ";
			ResultSet result_1 = state_1.executeQuery(sql);
			while (result_1.next()) {
				Teacher teacher = new Teacher();
				teacher.setName(result_1.getString("name"));
				teacher.setId(result_1.getString("id"));
				teacher.setDepartment_Name(result_1.getString("dept_name"));
				teacher.setSalary(result_1.getInt("salary"));
				if (teacher != null) {
					teachers.add(teacher);
				}
			}
			result_1.close();
			state_1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teachers;
	}

}