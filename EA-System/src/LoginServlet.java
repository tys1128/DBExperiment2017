
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonDAO;
import dao.impl.StudentDAO;
import dao.impl.TeacherDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 声明一个集合类，用于保存错误信息
		List<String> errors = new ArrayList<String>();
		//
		PersonDAO personDAO = null;
		// 要跳转的页面
		String path = null;
		// 接收请求的内容
		String id = request.getParameter("uname");
		String password = request.getParameter("upassword");
		
		// 预处理(获取用户类型）
		try {
			if (id.subSequence(0, 2).equals("02")) {// 教师
				path = "iframe/teacher/TeacherHome.jsp";
				personDAO = new TeacherDAO();
			} else if (id.subSequence(0, 2).equals("01")) {// 学生
				path = "iframe/student/StudentHome.jsp";
				personDAO = new StudentDAO();
			} else if ("admin".equals(id)) {//管理员
				path = "iframe/admin/AdminHome.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				return;
			}else {//id或密码错误
				path = "Login.jsp";
				errors.add("错误的用户ID及密码！");
				request.setAttribute("errors", errors);
			}
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("StringIndexOutOfBounds !");
		} catch (NullPointerException e) {
			System.out.println(" NullPointerException !");
		}
		
		// 判断+重定向
		if (personDAO != null && personDAO.canLogin(id, password)) {// 学生或老师验证
			//request.setAttribute("id", id);//设置id
			response.addCookie(new Cookie("id", id));//添加cookie
			response.addCookie(new Cookie("name",personDAO.getName(id)));//添加cookie

			request.getRequestDispatcher(path).forward(request, response);
			//response.sendRedirect(request.getRequestURI()+ + path);
		} else// 非法用户
		{
			path = "Login.jsp";
			errors.add("错误的用户ID及密码！");
			request.setAttribute("errors", errors);
			request.getRequestDispatcher(path).forward(request, response);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//personDAO.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
