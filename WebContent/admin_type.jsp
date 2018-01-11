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
		
			<h1>工具类别设置</h1>
			<br>
			<form action="ToolTypenew.do" method="post" >
			<table border="0">
				<tr>
					<td>新增工具类别&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td width="200px"><input name="tooltypename" class="form-control"
						type="text" placeholder="请输入类别名称"></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;
					    
						<button type="submit" class="btn btn-primary">&nbsp;&nbsp;新&nbsp;&nbsp;增&nbsp;&nbsp;</button>
					</td>
				</tr>
			</table>
			</form>
			&nbsp;<br>&nbsp;
			<table class="table table-striped">
				<tr>
					<th>ID</th>
					<th>类别名称</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${tooltype}" var="tool" >
				<tr>
					<td>${tool.toolTypeID}</td>
					<td>${tool.toolTypeName}</td>
					<td><a href="ToolTypechange?id=${tool.toolTypeID}"><button type="button"
								class="btn btn-warning">修改</button></a>&nbsp;
						<a href="ToolTypedelete.do?id=${tool.toolTypeID}"><button type="button" class="btn btn-danger">删除</button></a></td>
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