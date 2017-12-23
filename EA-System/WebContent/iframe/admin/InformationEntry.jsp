<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
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
	<h1>文件上传</h1>
	<form method="post" action="/EA-System/UploadServlet"
		enctype="multipart/form-data">
		选择一个文件: <input id="inputfile" type="file" name="InformationEntry" accept=".txt"/> <br />
		<br /> <input type="submit" value="上传" class="btn btn-default" />
	</form>
</body>
</html>