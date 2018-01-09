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
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
			<meta name="viewport" content="width=device-width, initial-scale = 1.0, maximum-scale=1.0, user-scalable=no"/>
		<title>工具管理系统</title>

		<link rel="stylesheet" href="assets/css/bootstrap.min.css">
		<link rel="stylesheet" href="assets/css/ionicons.min.css">
		<link rel="stylesheet" href="assets/css/owl.carousel.css">
		<link rel="stylesheet" href="assets/css/owl.theme.css">
	    <link rel="stylesheet" href="assets/css/main.css">
	    <link rel="stylesheet" href="assets/css/one-page.css">
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
	<section class="header" id="header">
		
		<nav class="navbar navbar-default">
			<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					
					<a class="navbar-brand" href="index.jsp">工具管理系统</a>
				</div> <!-- /.navbar-header -->

		    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li class="active"><a href="index.jsp">主页</a></li>
						<li><a href="allKit.jsp">全部工具</a></li>
						<li><a href="ShowUpload.do">工具上传</a></li>
						<li><a href="center.jsp">${user.userNickname}:个人中心</a></li>
					</ul> <!-- /.nav -->
			    </div><!-- /.navbar-collapse -->
		  	</div><!-- /.container -->
		</nav>
		<div class="container">
			<div class="header-table">
				<div class="header-wrapper">
					<h1 class="header-title">
						<b>工具管理系统</b>
					</h1>
					<p class="header-subtitle">
						软件工程 2017
					</p>
				</div> <!-- /.header-wrapper -->
			</div>
		</div> <!-- /.container -->
	</section> <!-- /#header -->
	


<!-- Note -->
	<section class="note purple">
		<div class="container section-wrapper text-center">
			<p class="quote">
				软件工程是一门研究用工程化方法构建和维护有效的、实用的和高质量的软件的学科。它涉及程序设计语言、数据库、软件开发工具、系统平台、标准、设计模式等方面。
在现代社会中，软件应用于多个方面。典型的软件有电子邮件、嵌入式系统、人机界面、办公套件、操作系统、编译器、数据库、游戏等。同时，各个行业几乎都有计算机软件的应用，如工业、农业、银行、航空、政府部门等。这些应用促进了经济和社会的发展，也提高了工作效率和生活效率 。
					</p> <!-- /.quote -->
			<div class="quoter">软件工程</div>
		</div> <!-- /.container -->
	</section> <!-- /.note -->


<!-- Fan Facts -->
	<section class="fun">
		<div class="container section-wrapper">
		<h2 class="section-title black">
				工具管理系统
			</h2> <!-- /.section-title -->
			<div class="underline purple"></div>	
			<div class="row">
				<div class="col-sm-3 col-xs-6">
					<div class="fun-box">
						<div class="number">
							195
						</div>
						<div class="number-title">
							工具数
						</div>
					</div> <!-- /.fun-box -->
				</div> <!-- /.col-md-3 -->
				<div class="col-sm-3 col-xs-6">
					<div class="fun-box">
						<div class="number">
							473
						</div>
						<div class="number-title">
							用户数
						</div>
					</div> <!-- /.fun-box -->
				</div> <!-- /.col-md-3 -->
				<div class="col-sm-3 col-xs-6">
					<div class="fun-box">
						<div class="number">
							5547
						</div>
						<div class="number-title">
							下载量
						</div>
					</div> <!-- /.fun-box -->
				</div> <!-- /.col-md-3 -->
				<div class="col-sm-3 col-xs-6">
					<div class="fun-box">
						<div class="number">
							101
						</div>
						<div class="number-title">
							运行天数
						</div>
					</div> <!-- /.fun-box -->
				</div> <!-- /.col-md-3 -->
			</div> <!-- /.row -->
		</div> <!-- /.container -->
	</section> <!-- /.fun -->


<%@ include file="footer.jsp" %>


</body>
</html>