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
<title>工具管理系统</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/ionicons.min.css">
<link rel="stylesheet" href="assets/css/owl.carousel.css">
<link rel="stylesheet" href="assets/css/owl.theme.css">
<link rel="stylesheet" href="assets/css/main.css">
<link rel="stylesheet" href="assets/css/section.css">
<link rel="stylesheet" href="assets/css/contact.css">

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
			<li><a href="allKit.jsp">全部工具</a></li>
			<li class="active">&nbsp;PhotoShop CC 2015</li>
		</ol>
	</div>
	<!-- /.container --> </section>
	<!-- /.section-background -->


	<!-- Contact with us -->
	<section class="contact section-wrapper" id="contact">
	<div class="container">
		<div class="row">
			<h1>Photoshop CC 2015</h1>
			<br>
			<table class="table" height="500px">
				<tr>
					<td>工具名称</td>
					<td>Photoshop CC 2015</td>
				</tr>
				<tr>
					<td>版本号</td>
					<td>V15.121.49</td>
				</tr>
				<tr>
					<td>分类</td>
					<td>美工工具</td>
				</tr>
				<tr>
					<td>标签</td>
					<td>图像处理;常用软件;大型软件</td>
				</tr>
				<tr>
					<td>文件大小</td>
					<td>1.68G</td>
				</tr>
				<tr>
					<td>上传人</td>
					<td>张昌健</td>
				</tr>
				<tr>
					<td>上传时间</td>
					<td>2018.1.3 23:59</td>
				</tr>
				<tr>
					<td>下载量</td>
					<td>136次</td>
				</tr>
				<tr>
					<td>我要点赞</td>
					<td><button type="button" class="btn btn-danger">√点赞</button></td>
				</tr>
				<tr>
					<td>下载</td>
					<td><button type="button" class="btn btn-success">立即下载</button></td>
				</tr>
			</table>
			<h1>软件评论</h1>
			<br>
		</div>
		<c:forEach items="${activityList}" var="activity">
			<form class="row form">
				<h3>1#&nbsp;&nbsp;&nbsp;用户A</h3>
				<div class="row">
					<div class="col-md-12 col-xs-12 form-group">
						&nbsp;&nbsp;53534354453 <br>
						<div align="right">
							<button type="button" class="btn btn-primary">&nbsp;回&nbsp;复&nbsp;</button>
							&nbsp;&nbsp;&nbsp;
						</div>
					</div>
				</div>
			</form>
		</c:forEach>
		<!-- <form class="row form">
			<h3>2#&nbsp;&nbsp;&nbsp;用户B</h3>
			<div class="row">
				<div class="col-md-12 col-xs-12 form-group">
					<blockquote>
						<p>回复1#：............</p>
					</blockquote>
					&nbsp;&nbsp;53534354453 <br>
					<div align="right">
						<button type="button" class="btn btn-primary">&nbsp;回&nbsp;复&nbsp;</button>
						&nbsp;&nbsp;&nbsp;
					</div>
				</div>
			</div>
		</form>
		<form class="row form">
			<h3>3#&nbsp;&nbsp;&nbsp;用户C</h3>
			<div class="row">
				<div class="col-md-12 col-xs-12 form-group">
					&nbsp;&nbsp;53534354453 <br>
					<div align="right">
						<button type="button" class="btn btn-primary">&nbsp;回&nbsp;复&nbsp;</button>
						&nbsp;&nbsp;&nbsp;
					</div>
				</div>
			</div>
		</form> -->



		<!-- /.row -->
		<form class="row form">
			<h3>我要评论</h3>
			<div class="row">
				<div class="col-md-12 col-xs-12 form-group">
					<label class="sr-only">Message</label>
					<textarea class="message form-control" placeholder="请在此输入"></textarea>
				</div>
				<!-- /.form-group -->
				<input class="btn btn-sub" type="submit" value="提交">
			</div>
		</form>
		<!-- /.row -->
	</div>
	<!-- /.container --> </section>
	<!-- /.contact -->



	<%@ include file="footer.jsp"%>
</body>
</html>