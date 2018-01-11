<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Home -->
<section class="portfolio-header" id="header">
	<nav class="navbar navbar-default">
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
					<li ${param.type1}><a href="index.jsp">主页</a></li>
					<li ${param.type2}><a href="showAlltool.do?currPage=1">全部工具</a></li>
					<li ${param.type3}><a href="ShowUpload.do">工具上传</a></li>
					<li ${param.type4}><a href="center.jsp">${user.userNickname}:个人中心</a></li>
				</ul>
				<!-- /.nav -->
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
</section>
<!-- /#header -->