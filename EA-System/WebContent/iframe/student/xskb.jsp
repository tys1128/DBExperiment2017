<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.*"%>
<%@ page import="entity.*"%>
<%@ page import="dao.*"%>
<%@ page import="dao.impl.*"%>
<%
	//存储教师的id
	String id = null;
	//获取id
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		//遍历cookie
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("id")) {
				id = cookie.getValue();
			}
		}
	} else {
		//out.println("<h2>没有发现 Cookie</h2>");
	}
	TeacherDAO tDAO = new TeacherDAO();
	List<SectionInfo> sList = tDAO.getSectionInfo(id);
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>