<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--[if IE 7 ]><html class="ie ie7 lte9 lte8 lte7" lang="en-US"><![endif]-->
<!--[if IE 8]><html class="ie ie8 lte9 lte8" lang="en-US">	<![endif]-->
<!--[if IE 9]><html class="ie ie9 lte9" lang="en-US"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="noIE" lang="en-US">
<!--<![endif]-->
<head>
<!-- meta -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale = 1.0, maximum-scale=1.0, user-scalable=no" />
<title>后台 | 工具管理系统</title>

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/sight.css">
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
				<script src="assets/js/html5shiv.js"></script>
				<script src="assets/js/respond.js"></script>
			<![endif]-->

<!--[if IE 8]>
		    	<script src="assets/js/selectivizr.js"></script>
		    <![endif]-->

</head>
${alert}
<body>
	<%@ include file="admin_header.jsp"%>

	<section class="main">
	<div class="container">
		<div class="row">
			<h1>管理员设置</h1>
			<br> <a href="ToolTypeShowAll_admin.do"><button
					type="button" class="btn btn-info">&nbsp;新&nbsp;增&nbsp;管&nbsp;理&nbsp;员</button></a>
			&nbsp;<br>&nbsp;
			<table class="table table-striped">
				<tr>
					<th>ID</th>
					<th>用户名</th>
					<th>姓名</th>
					<th>权限</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${admin1}" var="admin">
					<tr>
						<td>${admin.adminID}</td>
						<td>${admin.adminNickname}</td>
						<td>${admin.adminName}</td>
						<td>${admin.toolTypeName}</td>
						<td><a href="Admin_Userchange1.do?id=${admin.adminID}"><button
									type="button" class="btn btn-warning">修改</button></a>&nbsp;
							<a href="Admin_Userchangeps.do?id=${admin.adminID}"><button type="button" class="btn btn-info" onclick="return reset();">重置密码</button></a>&nbsp;
							<a href="Admin_Userdelete.do?id=${admin.adminID}"><button type="button" class="btn btn-danger">删除</button></a></td>
					</tr>
				</c:forEach>

			</table>


		</div>
		<!-- /.row -->
	</div>
	<!-- /.container --> </section>
	<!-- /.main -->

	<%@ include file="admin_footer.jsp"%>


	<script src="assets/js/jquery-1.11.2.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>

</body>
</html>