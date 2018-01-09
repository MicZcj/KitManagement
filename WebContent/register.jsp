<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>工具管理系统</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>
	<jsp:include page="header.jsp">
		<jsp:param name="type1" value="class=\"active\"" />
	</jsp:include>

	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1>
							<strong>工具管理系统</strong>
						</h1>
						<div class="description">
							<p>kit management</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<h3>登陆</h3>
							</div>
							<div class="form-top-right"></div>
						</div>
						<div class="form-bottom">
							<form role="form" action="UserRegister.do" method="post" class="login-form">
								<div class="form-group">
									<label class="sr-only" for="form-username">用户名</label> <input
										type="text" name="userNickname" placeholder="用户名"
										class="form-username form-control" id="userNickname">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-password">密码</label> <input
										type="password" name="userPassword" placeholder="密码"
										class="form-password form-control" id="userPassword">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-password">重复输入</label> <input
										type="password" name="form-password" placeholder="重复输入"
										class="form-password form-control" id="form-password">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-username">姓名</label> <input
										type="text" name="userName" placeholder="姓名"
										class="form-username form-control" id="userName">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-username">电子邮箱</label> <input
										type="text" name="email" placeholder="电子邮箱"
										class="form-username form-control" id="email">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-username">联系电话</label> <input
										type="text" name="phone" placeholder="联系电话"
										class="form-username form-control" id="phone">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-username">所在部门</label> <input
										type="text" name="department" placeholder="所在部门"
										class="form-username form-control" id="department">
								</div>

								<a href="login.jsp"><button type="submit" class="btn">注册</button></a>
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>

	</div>


	<!-- Javascript -->
	<script src="assets/js/jquery-1.11.2.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.backstretch.min.js"></script>
	<script src="assets/js/scripts1.js"></script>

	<!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

</body>

</html>