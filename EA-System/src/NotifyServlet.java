

import java.io.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NotifiServlet
 */
@WebServlet("/NotifyServlet")
public class NotifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "notify";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("send-type");
		String head = request.getParameter("head");
		String content = request.getParameter("content");
		StringBuilder str = new StringBuilder();//存储文件
        String filePath;
        FileWriter out;
        
        //获取通知
        str.append(head);
        str.append("\n");
        str.append(content);
        
        // 构造临时路径来存储保存的文件
        String savePath = getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
        // 如果目录不存在则创建
        File uploadDir = new File(savePath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
		if(type.equals("T")) {//教师
			filePath = savePath + File.separator + "t-notify.txt";
			out = new FileWriter(filePath);
			out.write(str.toString());
		}else if(type.equals("S")){//学生
			filePath = savePath + File.separator + "s-notify.txt";
			out = new FileWriter(filePath);
			out.write(str.toString());
		}else {//同时
			filePath = savePath + File.separator + "t-notify.txt";
			out = new FileWriter(filePath);
			out.write(str.toString());
			out.close();
			filePath = savePath + File.separator + "s-notify.txt";
			out = new FileWriter(filePath);
			out.write(str.toString());
		}
		out.close();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
