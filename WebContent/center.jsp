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
			<li class="active">&nbsp;个人中心</li>
		</ol>
	</div>
	<!-- /.container --> </section>
	<!-- /.section-background -->


	<!-- Portfolio -->
	<section class="portfolio" id="portfolio">
	<div class="container section-wrapper">
		<h2 class="section-title black">个&nbsp;人&nbsp;中&nbsp;心</h2>
		<!-- /.section-title -->
		<div class="underline purple"></div>
		<div class="row">
			<div class="col-sm-4 col-xs-6">
				<div class="portfolio-item">
					<div class="portfolio-img">
						<img src="assets/images/port-1.png" alt="port-1" class="port-item">
						<div class="portfolio-img-hover">
							<a href="center_info.jsp"><img src="assets/images/plus.png"
								alt="plus" class="plus"></a>
						</div>
						<!-- /.portfolio-img-hover -->
					</div>
					<!-- /.portfolio-img -->
					<div class="portfolio-item-details">
						<div class="portfolio-item-name">
							个人信息<br>
							<small>Personal information</small>
						</div>
						<!-- /.portfolio-item-name -->
					</div>
					<!-- /.portfolio-item-details -->
				</div>
				<!-- /.portfolio-item -->
			</div>
			<!-- /.col-md-4 -->
			<div class="col-sm-4 col-xs-6">
				<div class="portfolio-item">
					<div class="portfolio-img">
						<img src="assets/images/port-2.png" alt="port-2" class="port-item">
						<div class="portfolio-img-hover">
							<a href="center_password.jsp"><img
								src="assets/images/plus.png" alt="plus" class="plus"></a>
						</div>
						<!-- /.portfolio-img-hover -->
					</div>
					<!-- /.portfolio-img -->
					<div class="portfolio-item-details">
						<div class="portfolio-item-name">
							修改密码<br>
							<small>Password Change</small>
						</div>
						<!-- /.portfolio-item-name -->

					</div>
					<!-- /.portfolio-item-details -->
				</div>
				<!-- /.portfolio-item -->
			</div>
			<!-- /.col-md-4 -->
			<div class="col-sm-4 col-xs-6">
				<div class="portfolio-item">
					<div class="portfolio-img">
						<img src="assets/images/port-3.png" alt="port-3" class="port-item">
						<div class="portfolio-img-hover">
							<a href="NotificationShow.do"><img
								src="assets/images/plus.png" alt="plus" class="plus"></a>
						</div>
						<!-- /.portfolio-img-hover -->
					</div>
					<!-- /.portfolio-img -->
					<div class="portfolio-item-details">
						<div class="portfolio-item-name">
							站内通知<br>
							<small>Website Message</small>
						</div>
						<!-- /.portfolio-item-name -->

					</div>
					<!-- /.portfolio-item-details -->
				</div>
				<!-- /.portfolio-item -->
			</div>
			<!-- /.col-md-4 -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container --> </section>
	<!-- /.portfolio -->

	<%@ include file="footer.jsp"%>


</body>
</html>