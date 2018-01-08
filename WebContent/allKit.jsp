<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<link rel="stylesheet" href="assets/css/kit.css">
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

	<!-- Home -->
	<section class="portfolio-header" id="header"> <nav
		class="navbar navbar-default">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">

			<a class="navbar-brand" href="index.jsp">工具管理系统</a>
		</div>
		<!-- /.navbar-header -->

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.jsp">主页</a></li>
				<li class="active"><a href="allKit.jsp">全部工具</a></li>
				<li><a href="upload.jsp">工具上传</a></li>
				<li><a href="center.jsp">个人中心</a></li>
			</ul>
			<!-- /.nav -->
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav> </section>
	<!-- /#header -->


	<!-- Section Background -->
	<section class="section-background">
	<div class="container">
		<ol class="breadcrumb">
			<li><a href="index.jsp">主页</a></li>
			<li class="active">&nbsp;全部工具</li>
		</ol>
	</div>
	<!-- /.container --> </section>
	<!-- /.section-background -->

	<!-- Contact with us -->
	<section class="contact section-wrapper" id="contact">
	<div class="container">
		<h1>工具检索</h1>
		<br>
		<table border="0">
			<tr>
				<td><select class="form-control">
						<option>请选择</option>
						<option>名称</option>
						<option>描述</option>
						<option>发布者</option>
						<option>标签</option>
				</select></td>
				<td width="500px"><input name="" class="form-control"
					type="text" placeholder="请输入关键词"></td>
				<td><button type="submit" class="btn btn-primary">&nbsp;&nbsp;搜&nbsp;&nbsp;索&nbsp;&nbsp;</button></td>
			</tr>
		</table>
		<br>
		<h1>工具列表</h1>
		<br>
		<table class="table table-striped">
			<tr>
				<th>序号</th>
				<th>名称</th>
				<th>版本号</th>
				<th>类别</th>
				<!-- <th>上传时间</th> -->
				<th>下载量<a href="">↓</a></th>
				<th>点赞数<a href="">↑</a></th>
			</tr>
			<c:forEach items="${pageBean}" var="tool" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td><a href="kit.jsp">${tool.toolName}</a></td>
					<td>${tool.toolEdition}</td>
					<td>${tool.toolTypeName}</td>
					<!-- 	<td>2017.11.30</td> -->
					<td>${tool.downloadNum}</td>
					<td>${tool.likeNum}</td>
				</tr>
			</c:forEach>
			<table align="center">
				<tr>
					<td align="right"><span>第${page.currPage}/${page.totalPage}页
					</span>&nbsp;&nbsp; <span>总记录数：${page.totalCount}&nbsp;&nbsp;每页显示：${page.pageSize}条
					</span>&nbsp;&nbsp; <span> <c:if test="${page.currPage != 1}">
								<a href="KitShowAll.do?currPage=1">[首页]</a>&nbsp;&nbsp; 
			<a href="KitShowAll.do?currPage=${page.currPage-1}">[上一页]</a>&nbsp;&nbsp;
			</c:if> <c:if test="${page.currPage != page.totalPage}">
								<a href="KitShowAll.do?currPage=${page.currPage+1}">[下一页]</a>&nbsp;&nbsp; 
			<a href="KitShowAll.do?currPage=${page.totalPage}">[尾页]</a>&nbsp;&nbsp;
		</c:if>
					</span></td>
				</tr>
			</table>
			</section>

			<%@ include file="footer.jsp"%>
</body>
</html>