<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知</title>
</head>
<body>
	<%
		String Path = getServletContext().getRealPath("./") + File.separator + "notify"+File.separator+"s-notify.txt";
		FileReader fr = new FileReader(Path);
		Scanner sc = new Scanner(fr);
	%>
	<h3><%=sc.nextLine()%></h3>
	<%
		while (sc.hasNext()) {
	%>
	<p><%=sc.nextLine()%></p>
	<%
		}
		sc.close();
	%>
</body>
</html>
