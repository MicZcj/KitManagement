<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<!-- Section Background -->
	<section class="section-background">
	<div class="sight">
		<h1 class="title">工具管理系统 | 后台管理</h1>
		<p class="subtitle">欢迎你，管理员！</p>
	</div>

	<div class="container">
		<ol class="breadcrumb">
			<li><a href="admin_index.jsp">后台主页</a></li>
			<li class="active"><a href="admin_user.jsp">管理员设置</a></li>
			<li><a href="admin_type.jsp">工具类别设置</a></li>
		</ol>
	</div>
	<!-- /.container --> </section>
	<!-- /.section-background -->



	<section class="main">
	<div class="container">
		<div class="row">
			<h1>管理员列表</h1>
			<br>
			<button type="button" class="btn btn-info">&nbsp;新&nbsp;增&nbsp;管&nbsp;理&nbsp;员</button>
			&nbsp;<br>&nbsp;
			<table class="table table-striped">
				<tr>
					<th>ID</th>
					<th>用户名</th>
					<th>姓名</th>
					<th>权限</th>
					<th>操作</th>
				</tr>
				<tr>
					<td>1</td>
					<td>haha</td>
					<td>姓名111</td>
					<td>图像处理</td>
					<td><button type="button" class="btn btn-warning">修改</button>&nbsp;<button type="button" class="btn btn-danger">删除</button></td>
					
				</tr>
								<tr>
					<td>2</td>
					<td>hahahaha</td>
					<td>姓名222</td>
					<td>图像处理</td>
					<td><button type="button" class="btn btn-warning">修改</button>&nbsp;<button type="button" class="btn btn-danger">删除</button></td>
					
				</tr>
								<tr>
					<td>3</td>
					<td>hahahahahaha</td>
					<td>姓名333</td>
					<td>编译器</td>
					<td><button type="button" class="btn btn-warning">修改</button>&nbsp;<button type="button" class="btn btn-danger">删除</button></td>
					
				</tr>
				
			</table>


		</div>
		<!-- /.row -->
	</div>
	<!-- /.container --> </section>
	<!-- /.main -->

	<%@ include file="footer.jsp"%>


	<script src="assets/js/jquery-1.11.2.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>

</body>
</html>