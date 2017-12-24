<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>StudentHome</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="libs/bootstrap-3.3.7-dist/js/jquery-3.2.1.js"></script>
<script src="libs/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<style type="text/css">
html {
	margin: 0;
	height: 100%;
}

body {
	margin: 0;
	height: 100%;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default " role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#example-navbar-collapse">
					<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="Login.jsp"> 教务系统</a>
			</div>
			<div class="collapse navbar-collapse" id="example-navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="button"><a href="iframe/student/Chooselesson.jsp"
						target="left-frame"> 网上选课 </a></li>
					<li class="button"><a href="iframe/student/xskb.jsp"
						target="left-frame">学生个人课表</a></li>
					<li class="button"><a href="iframe/student/xscj.jsp"
						target="left-frame">学生成绩</a></li>
											<li>
						<a>欢迎登陆,${cookie.name.value}同学</a>
					</li>
			</ul>
			</div>
		</div>

	</nav>
	<div style="height: 100%">
		<iframe id="left-frame" name="left-frame" src="iframe/Info.jsp"
			width="80%" height="100%"></iframe>
		<iframe id="right-frame" name="right-frame"
			src="iframe/student/SInfo.jsp" width="20%" height="100%"
			align="right"></iframe>
	</div>

</body>
</html>