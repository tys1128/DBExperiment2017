package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PersonDAO;
import entity.SectionInfo;
import entity.StuInfo;

public class StudentDAO implements PersonDAO {
	Connection conn;

	public StudentDAO() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@47.94.200.154:1521:ORCL", "teacher", "teacher");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 判断登陆是否合法
	 * 
	 * @param userid
	 *            登陆用户名，即ID
	 * @param password
	 *            登陆密码
	 * @return 是否合法
	 */
	@Override
	public boolean canLogin(String userid, String password) {
		boolean can = false;
		try {
			Statement stmt = conn.createStatement();
			String sql = "select password from student where id='" + userid + "'";
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
	 * 获得学生姓名
	 */
	@Override
	public String getName(String id) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "select name from student where id='" + id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			return rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得学生的所有课程
	 * 
	 * @param id 学生id
	 * @return 课程列表
	 */
	public List<StuInfo> getStuInfo(String id) {
		List<StuInfo> sList = new ArrayList<StuInfo>();
		String[] week = new String[] { "一", "二", "三", "四", "五", "六", "日" };
		try {
			Statement stmt = conn.createStatement();
			//
			String sql = "select title,building,room_num,time_slot,grade\r\n"
					+ "from course natural join section natural join takes \r\n" + "where takes.id='" + id + "'";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				StuInfo sInfo = new StuInfo();
				sInfo.courseName = rs.getString(1);
				sInfo.buliding = rs.getString(2);
				sInfo.classroom = rs.getString(3);
				// 处理时间
				String str = rs.getString(4);
				sInfo.week = str.charAt(0) - '0';
				sInfo.lession = str.charAt(2) - '0';
				sInfo.time = "星期" + week[sInfo.week] + " 第" + sInfo.lession + "节";
				sInfo.grade = rs.getString(5);

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
}
