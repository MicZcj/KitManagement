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
			<h1 class="title">
				工具管理系统  | 后台管理
			</h1>
			<p class="subtitle">
				欢迎你，管理员！
			</p>
		</div>
	</section> <!-- /.section-background -->
	
	<section class="main">
		<div class="container">
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<div class="row">
						<div class="col-md-6">
							<div class="pages">
								<h2 class="page-title">
									管理员设置
								</h2>
								<a href="admin_user.jsp" target="_blink">
									<img src="assets/images/port-1.png" alt="page" class="page-img img-responsive">	
								</a>
							</div>
						</div> <!-- /.col-md-6 -->
						<div class="col-md-6">
							<div class="pages">
								<h2 class="page-title">
									工具类别设置
								</h2>
								<a href="admin_type.jsp" target="_blink">
									<img src="assets/images/port-3.png" alt="page" class="page-img img-responsive">
								</a>
							</div>
						</div> <!-- /.col-md-6 -->
						
					</div> <!-- .row -->
				</div> <!-- /.col-md-10 -->
			</div> <!-- /.row -->
		</div> <!-- /.container -->
	</section> <!-- /.main -->

	<%@ include file="footer.jsp"%>


	<script src="assets/js/jquery-1.11.2.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

</body>
</html>