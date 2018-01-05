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
<title>工具管理系统</title>

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/ionicons.min.css">
<link rel="stylesheet" href="assets/css/owl.carousel.css">
<link rel="stylesheet" href="assets/css/owl.theme.css">
<link rel="stylesheet" href="assets/css/main.css">
<link rel="stylesheet" href="assets/css/section.css">
<link rel="stylesheet" href="assets/css/service.css">
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

	<jsp:include page="header.jsp">
		<jsp:param name="type3" value="class=\"active\"" />
	</jsp:include>



	<!-- Section Background -->
	<section class="section-background">
	<div class="container">
		<ol class="breadcrumb">
			<li><a href="index.jsp">主页</a></li>
			<li class="active">&nbsp;工具上传</li>
		</ol>
	</div>
	<!-- /.container --> </section>
	<!-- /.section-background -->



	<!-- Contact with us -->
	<section class="contact section-wrapper" id="contact">
	<div class="container">
		<div align="center">
			<div class="row">
				<h1>工具上传</h1>
				<br>
				<table border="0" height="500px">

					<tr>
						<td>名称</td>
						<td width="700px"><input name="" class="form-control"
							type="text" placeholder="请输入名称"></td>
					</tr>
					<tr>
						<td>版本号&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><input name="" class="form-control" type="text"
							placeholder="请输入版本号"></td>
					</tr>
					<tr>
						<td>分类</td>
						<td><select class="form-control">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
						</select></td>
					</tr>
					<tr>
						<td>描述</td>
						<td><textarea name="" class="message form-control"
								placeholder="请输入描述" rows="6"></textarea></td>
					</tr>
					<tr>
						<td>标签</td>
						<td><input name="" class="form-control" type="text"
							placeholder="请输入标签"></td>
					</tr>
					<tr>
						<td>文件</td>
						<td>这里放文件的button</td>
					</tr>

				</table>
				<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary">&nbsp;&nbsp;上&nbsp;&nbsp;传&nbsp;&nbsp;</button>
				<br> <br> <br>
			</div>
		</div>
	</div>
	<!-- /.container --> </section>
	<!-- /.contact -->

	<%@ include file="footer.jsp"%>


</body>
</html>