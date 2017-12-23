<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知</title>
</head>
<body>
<h4>通知</h4>
<p>暂无</p>

 <script >
  var loc = location.href;
  var n1 = loc.length;
  var n2 = loc.indexOf("=");
  var id = decodeURI(loc.substr(n2+1, n1-n2));

  document.write(id);

  </script>
</body>
</html>
