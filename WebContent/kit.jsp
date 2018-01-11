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
<link rel="stylesheet" href="assets/css/contact.css">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
				<script src="assets/js/html5shiv.js"></script>
				<script src="assets/js/respond.js"></script>
			<![endif]-->

<!--[if IE 8]>
		    	<script src="assets/js/selectivizr.js"></script>
		    <![endif]-->
<script type="text/javascript">
	function jumpTo(floor, comment) {
		document.getElementsByTagName('BODY')[0].scrollTop = document
				.getElementsByTagName('BODY')[0].scrollHeight;
		document.getElementById("label").innerHTML = "<input type=\"hidden\" id=\"reply\" name=\"reply\" value=\""+"回复" + floor + "#:" + comment+"\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "回复" + floor + "#:" + comment;
		alert("正确");
	}
</script>
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
			<li><a href="allKit.jsp">主页</a></li>
			<li class="active">&nbsp;${tool.toolName}</li>
		</ol>
	</div>
	<!-- /.container --> </section>
	<!-- /.section-background -->


	<!-- Contact with us -->
	<section class="contact section-wrapper" id="contact">
	<div class="container">
		<div class="row">
			<h1>${tool.toolName}</h1>
			<br>
			<table class="table" height="500px">
				<tr>
					<td>工具名称</td>
					<td>${tool.toolName}</td>
				</tr>
				<tr>
					<td>版本号</td>
					<td>${tool.toolEdition}</td>
				</tr>
				<tr>
					<td>分类</td>
					<td>${tool.toolTypeName}</td>
				</tr>
				<tr>
					<td>标签</td>
					<td>${tool.toolEdition}</td>
				</tr>
				<tr>
					<td>文件大小</td>
					<td>${tool.toolEdition}</td>
				</tr>
				<tr>
					<td>上传人</td>
					<td>${tool.userNickname}</td>
				</tr>
				<tr>
					<td>上传时间</td>
					<td>
						<%-- ${tool.toolEdition} --%>
					</td>
				</tr>
				<tr>
					<td>下载量</td>
					<td>${tool.downloadNum}</td>
				</tr>
				<tr>
					<td>我要点赞</td>
					<td><a href="CommentLike.do?toolID=1&userID=1"><button
								type="button" class="btn btn-danger">点赞
								(${tool.likeNum})</button></a></td>
				</tr>
				<tr>
					<td>下载</td>
					<td><button type="button" onclick="javascript:window.location.href='/KitTest/Down?fileID=${tool.toolID}'"
							class="btn btn-success">立即下载</button></td>
				</tr>

			</table>

			<h1>软件评论</h1>
			<br>
		</div>
		<c:forEach items="${commentRecord}" var="comment" varStatus="status">
			<h3>${status.index+1}#&nbsp;&nbsp;&nbsp;用户ID:${comment.userID}</h3>
			<div class="row">
				<div class="col-md-12 col-xs-12 form-group">
					<c:if test="${fn:length(comment.reply)>2}">
						<blockquote>
							<p>${comment.reply}</p>
						</blockquote>
					</c:if>
					&nbsp;&nbsp; ${comment.comment} <br>
					<div align="right">
						<button type="button" class="btn btn-primary"
							onclick="jumpTo('${status.index+1}','${comment.comment}');">&nbsp;回&nbsp;复&nbsp;</button>
						&nbsp;&nbsp;&nbsp;
					</div>
				</div>
			</div>
		</c:forEach>

		<!-- /.row -->
		<form action="CommentSubmit.do" method="post" class="row form">
			<input type="hidden" name="toolID" value="${tool.toolID}"> <input
				type="hidden" name="userID" value="${user.userID}">
			<h3>我要评论</h3>
			<div class="row">
				<div class="col-md-12 col-xs-12 form-group">
					<p id="label"></p>
					<textarea name="comment" id="commit" class="message form-control"
						placeholder="请在此输入"></textarea>
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