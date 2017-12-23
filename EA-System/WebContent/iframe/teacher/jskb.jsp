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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师课表</title>
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
			<caption id="title">您的课表信息</caption>
			<thead>
				<tr>
					<th>周一</th>
					<th>周二</th>
					<th>周三</th>
					<th>周四</th>
					<th>周五</th>
					<th>周六</th>
					<th>周日</th>
				</tr>
			</thead>
			<tbody>
				<%
					String[][] sche = new String[8][7];
					for (SectionInfo si : sList) {
						sche[si.lession][si.week] = si.courseName+"<br/>"+si.buliding+"<br/>"+si.classroom;
					}

					for (int l = 0; l < 4; l++) {//遍历行-第几节
						out.println("<tr>");
						for (int w = 0; w < 7; w++) {//列-第几周
							if (sche[l][w]=="") {//空单元格
								out.println("<td><br/></td>");
							} else {
								out.println("<td>"+sche[l][w]+"</td>");
							}
						}
						out.println("</tr>");
					}
				%>

			</tbody>
		</table>
	</div>
</body>
</html>