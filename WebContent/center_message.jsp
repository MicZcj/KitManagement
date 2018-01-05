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
<link rel="stylesheet" href="assets/css/portfolio.css">
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
		<jsp:param name="type4" value="class=\"active\"" />
	</jsp:include>


	<!-- Section Background -->
	<section class="section-background">
	<div class="container">
		<ol class="breadcrumb">
			<li><a href="index.jsp">主页</a></li>
			<li><a href="center.jsp">个人中心</a></li>
			<li class="active">&nbsp;站内通知</li>
		</ol>
	</div>
	<!-- /.container --> </section>
	<!-- /.section-background -->


	<!-- Contact with us -->
	<section class="contact section-wrapper" id="contact">
	<div class="container">
		<div class="row">
			<h1>站内通知</h1>
			<br>


			<div class="panel panel-danger">
				<div class="panel-heading">【未读】[2018.1.3 23:09] 新消息提醒：标题标题标题标题</div>
				<div class="panel-body">内容内容内容</div>
			</div>
			<div class="panel panel-primary">
				<div class="panel-heading">[2018.1.3 22:09] 新消息提醒：标题标题标题标题</div>
				<div class="panel-body">内容内容内容</div>
			</div>
			<div class="panel panel-primary">
				<div class="panel-heading">[2018.1.3 21:09] 新消息提醒：标题标题标题标题</div>
				<div class="panel-body">内容内容内容</div>
			</div>
			<div class="panel panel-primary">
				<div class="panel-heading">[2018.1.3 20:09] 新消息提醒：标题标题标题标题</div>
				<div class="panel-body">内容内容内容</div>
			</div>



			<div align="center">
				<a href="center.jsp"><button type="button"
						class="btn btn-primary">&nbsp;返&nbsp;回&nbsp;</button></a>
			</div>

		</div>

	</div>
	<!-- /.container --> </section>
	<!-- /.contact -->

	<%@ include file="footer.jsp"%>


</body>
</html>