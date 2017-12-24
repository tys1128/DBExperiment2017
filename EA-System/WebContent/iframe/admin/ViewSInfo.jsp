<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.*"%>
<%@ page import="entity.*"%>
<%@ page import="dao.*"%>
<%@ page import="dao.impl.*"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看或修改学生信息</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="libs/bootstrap-3.3.7-dist/js/jquery-3.2.1.js"></script>
<script src="libs/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<body>
	<div class="panel-body" style="padding-bottom: 0px;">
		<div class="panel panel-default">
			<div class="panel-heading">查询条件</div>
			<div class="panel-body">
				<form id="formSearch" class="form-horizontal" action=""
					method="post">
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-1"
							for="txt_search_departmentname">学生id</label>
						<div class="col-sm-3">
							<input type="text" class="form-control"
								id="txt_search_departmentname">
						</div>
						<label class="control-label col-sm-1" for="txt_search_statu">学生姓名</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="txt_search_statu">
						</div>
						<div class="col-sm-4" style="text-align: left;">
							<button type="submit" style="margin-left: 50px" id="btn_query"
								class="btn btn-primary">查询</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_edit" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button id="btn_delete" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
		</div>
		<div>
			<table class="table table-bordered">
				<caption id="title">学生信息</caption>
				<thead>
					<tr>
						<th>姓名</th>
						<th>学生id</th>
						<th>性别</th>
						<th>所在学院</th>
						<th>总学分</th>
						<th></th>
					</tr>
				</thead>
				<thead>
					<%
						AdminDAO aDAO = new AdminDAO();
						List<Student> sList = aDAO.getStudent();
						//生成行
						for (Student s : sList) {
					%>
					<tr>
						<td><%=s.name%></td>
						<td><%=s.id%></td>
						<td><%=s.sex%></td>
						<td><%=s.department_Name%></td>
						<td><%=s.tol_cred%></td>
						<td><input type="button" value="添加" onclick="add()"
							class="btn btn-default"> <input type="button" value="删除"
							onclick="del(this)" class="btn btn-default"></td>
					</tr>
					<%
						}
					%>
				
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
<script>
	function add() {
		var trObj = document.createElement("tr");
		trObj.id = new Date().getTime();
		trObj.innerHTML = "<td><input name='姓名'/></td><td><input name='性别'/><td><input name='学号'/><td><input name='出生日期'/><td><input name='身份证号'/></td><td><input type='button' value='添加' onclick='add()' class='btn btn-default'> <input type='button' value='删除' onclick='del(this)' class='btn btn-default'></td>";
		document.getElementById("tb").appendChild(trObj);
	}

	function del(obj) {
		var trId = obj.parentNode.parentNode.id;
		var trObj = document.getElementById(trId);
		document.getElementById("tb").removeChild(trObj);
	}
</script>
