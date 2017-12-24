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
	StudentDAO sDAO = new StudentDAO();
	List<StuInfo> sList = sDAO.getStuInfo(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生成绩</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="libs/bootstrap-3.3.7-dist/js/jquery-3.2.1.js"></script>
<script src="libs/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<style type="text/css">
#biaoge {
	margin: 200px;
	padding: 2px;
	text-align: center;
}

#title {
	text-align: center;
	font-size: 30px;
	font-family: verdana;
}
</style>
</head>
<body>
	<div id="biaoge">
		<table class="table table-bordered">
			<caption id="title">您的课程信息</caption>
			<thead>
				<tr>
					<th>课程名称</th>
					<th>成绩</th>
				</tr>
			</thead>
			<tbody>
				<%
					//生成行
					for (StuInfo si : sList) {
				%>
				<tr>
					<td><%=si.courseName%></td>
					<td><%=si.grade%></td>

				</tr>
					<%
						}
					%>
				
			</tbody>
		</table>
	</div>
</body>
</html>