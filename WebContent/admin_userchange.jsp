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

<body>
	<%@ include file="admin_header.jsp"%>

	<section class="main">
	<div class="container">
		<div class="row">
			<div align="center">
			<form action="Admin_Userchange.do" method="post" >
				<h1>修改管理员</h1>
				<br>
				<table border="0" height="200px">
					<tr>
						<td>管理员id</td>
						<td>${adminid}</td>
					</tr>
					<tr>
						<td>用户名</td>
						<td><input name="adminnickname" class="form-control" type="text"
							></td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input name="adminname" class="form-control" type="text"
							></td>
					</tr>
					<tr>
						<td>权限类别&nbsp;&nbsp;&nbsp;</td>
						<td><select class="form-control" name="toolTypeid" id="toolTypeid" >
								<option>请选择</option>
								<c:forEach items="${tooltype}" var="tool" >
								<option value="${tool.toolTypeID}">${tool.toolTypeName}</option>
								</c:forEach>
						</select></td>
					</tr>
				</table>
				<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary">&nbsp;&nbsp;修&nbsp;&nbsp;改&nbsp;</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="AdminShowAll.do"><button
						type="button" class="btn btn-primary">&nbsp;&nbsp;返&nbsp;&nbsp;回&nbsp;&nbsp;</button></a>
				<br>
				<br>
				<br>
            </form>
			</div>

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