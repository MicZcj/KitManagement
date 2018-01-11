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
	function jumpTo(floor, comment, toUserID) {
		document.getElementsByTagName('BODY')[0].scrollTop = document
				.getElementsByTagName('BODY')[0].scrollHeight;
		document.getElementById("label").innerHTML = "<input type=\"hidden\" id=\"reply\" name=\"reply\" value=\""+"回复" + floor + "#:" + comment+"\" /><input type=\"hidden\" id=\"toUserID\" name=\"toUserID\" value=\""+toUserID+"\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "回复" + floor + "#:" + comment;

	}
</script>
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
				<%-- <tr>
					<td>上传时间</td>
					<td>${tool.uploadTime}</td>
				</tr> --%>
				<tr>
					<td>下载量</td>
					<td>${tool.downloadNum}</td>
				</tr>
				<tr>

					<td>我要点赞</td>
					<td><c:if test="${likeRecord}">
							<button type="button" class="btn btn-default" disabled="disabled">已点赞
								(${tool.likeNum})</button>
						</c:if> <c:if test="${!likeRecord}">
							<a
								href="LikeSubmit.do?toolID=${tool.toolID}&userID=${user.userID}">
								<button type="button" class="btn btn-danger"
									<c:if test="${fn:length(admin.adminNickname)>0}">disabled="disabled"</c:if>>点赞
									(${tool.likeNum})</button>
							</a>

						</c:if></td>
				</tr>

				<tr>
					<td>下载</td>
					<td><button type="button"
							onclick="javascript:window.location.href='/KitManagement/Down?toolID=${tool.toolID}'"
							class="btn btn-success">立即下载</button></td>
				</tr>
				<c:if
					test="${admin.toolTypeID == tool.toolTypeID || admin.toolTypeID==0}">


					<tr>
						<td>删除工具</td>
						<td><button type="button"
								onclick="javascript:window.location.href='/KitManagement/DeleteTool?toolID=${tool.toolID}'"
								class="btn btn-danger">立即删除</button></td>
					</tr>
				</c:if>

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
					<c:if test="${fn:length(admin.adminNickname)<=0}">
					<div align="right">
						<button type="button" class="btn btn-primary"
							onclick="jumpTo('${status.index+1}','${comment.comment}','${comment.userID}');">&nbsp;回&nbsp;复&nbsp;</button>
						&nbsp;&nbsp;&nbsp;
					</div>
					</c:if>
				</div>
			</div>
		</c:forEach>
		<c:if test="${fn:length(admin.adminNickname)<=0}">
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
		</c:if>
		<!-- /.row -->
	</div>
	<!-- /.container --> </section>
	<!-- /.contact -->



	<%@ include file="footer.jsp"%>
</body>
</html>