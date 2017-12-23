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
<script>
    function test(){
        var s = document.getElementById("txt");
        location.href="iframe/teacher/TInfo.jsp?"+"txt="+encodeURI(s.value);
    }
</script>
</head>
<body>
<h1 >发布消息</h1>
	<form  >

		<div class="form-group">
			<label for="name">名称</label> 
			<input type="text" class="form-control" id="txt" placeholder="请输入名称" >
			
			<label for="name">内容</label>
			<textarea class="form-control" rows="8" ></textarea>
			
			<input type="submit" value="发布" class="btn btn-default" onclick="test()" >
		</div>
	</form>
</body>
</html>

