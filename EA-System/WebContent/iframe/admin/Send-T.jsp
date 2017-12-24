<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>对教师发送消息</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="libs/bootstrap-3.3.7-dist/js/jquery-3.2.1.js"></script>
<script src="libs/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<style type="text/css">
body {
	margin: 200px;
	padding: 2px;
	text-align: center;
}

</style>

</head>
<body>
<h1 >发布消息-教师</h1>
	<form action = "/EA-System/NotifyServlet" method="post" >
		<div class="form-group">
		<input type="hidden" name="send-type" value="T">
			<label for="name">名称</label> 
			<input type="text" class="form-control" name ="head" placeholder="请输入名称" >
			
			<label for="content">内容</label>
			<textarea class="form-control" rows="8" name = "content" ></textarea>
			
			<input type="submit" value="发布" class="btn btn-default" >
		</div>
	</form>
</body>
</html>

