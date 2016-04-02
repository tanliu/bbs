<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>帖子管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/bootstrap-table.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#sidebar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><span>Lumino</span>Admin</a>
			<ul class="user-menu">
				<li class="dropdown pull-right"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"><span
						class="glyphicon glyphicon-user"></span> User <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#"><span class="glyphicon glyphicon-user"></span>
								Profile</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-cog"></span>
								Settings</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-log-out"></span>
								Logout</a></li>
					</ul></li>
			</ul>
		</div>

	</div>
	<!-- /.container-fluid --> </nav>

	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<ul class="nav menu">
			<li class="active"><a href="index.html"><span
					class="glyphicon glyphicon-dashboard"></span>浏览帖子</a></li>
			<li><a href="myblogs.html"><span
					class="glyphicon glyphicon-th"></span>我的帖子</a></li>
			<li><a href="myinfo.html"><span
					class="glyphicon glyphicon-stats"></span>我的信息</a></li>
			<li><a href="usermanager.html"><span
					class="glyphicon glyphicon-list-alt"></span>用户管理 </a></li>
			<li><a href="usermanager.html"><span
					class="glyphicon glyphicon-pencil"></span>帖子管理</a></li>


			<li role="presentation" class="divider"></li>
			<li><a href="login.html"><span
					class="glyphicon glyphicon-user"></span> Login Page</a></li>
		</ul>

	</div>
	<!--/.sidebar-->

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">帖子管理</li>
			</ol>
		</div>
		<!--/.row-->

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">帖子管理</h1>
			</div>
		</div>
		<!--/.row-->

		<div class="row">
			<div class="col-lg-12">
				<table class="table table-bordered" align="center">
					<caption>
						<form action="ManagerBlogServlet">
						    <input type="hidden" name="method" value="listUI">
							<div class="input-group col-md-3">
								<input id="btn-input" type="text" class="form-control input-md"
									placeholder="输入查询的内容" name="query" value="${query}" /> <span class="input-group-btn">
									<button class="btn btn-success btn-md" id="query">查询</button>

								</span>
						</form>

					</caption>
					<thead>
						<tr align="center">
							<th><a class="btn btn-danger" id="deleteAll">批量删除</span></th>
							<th>标题</th>
							<th>发帖人</th>
							<th>发帖时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<form id="deletform" action="ManagerBlogServlet">
							<input type="hidden" name="method" value="deleteAll">
							<c:forEach var="blog" items="${pagetUtils.pageData}">
								<tr align="center">
									<td width="12%"><input type="checkbox" name="ids"
										value="${blog.id}"></td>
									<td>${blog.title}</td>
									<td>${blog.userId}</td>
									<td>${blog.time}</td>
									<td><a
										href="ManagerBlogServlet?method=delete&id=${blog.id}"
										class="btn btn-danger">删除</a></td>
								</tr>
							</c:forEach>
						</form>
					</tbody>
				</table>
			</div>
		</div>


	</div>

	<div class="row fixed-bottom">
		<div align="center">
			<nav>
			
			<ul class="pagination pagination-lg">
				<c:if test="${ pagetUtils.currentPage>1}">
			<li>
		
			<a href="ManagerBlogServlet?method=listUI&currentPage=${pagetUtils.currentPage-1}&query=${query}" aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span>
				</a></li>
				</c:if>
			<c:forEach var="i" begin="1" end="${pagetUtils.totalPage}">
				
				<li <c:if test="${pagetUtils.currentPage==i}">class="active"</c:if> >
				<a href="ManagerBlogServlet?method=listUI&currentPage=${i}&query=${query}"><c:out value="${i}"></c:out></a></li>
				
				</c:forEach>
				<c:if test="${ pagetUtils.currentPage<pagetUtils.totalPage}">
				<li><a href="ManagerBlogServlet?method=listUI&currentPage=${pagetUtils.currentPage+1}&query=${query}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
				</c:if>
			</ul>
			
			</nav>
		</div>
	</div>
	</div>
	</div>
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	<script>
		$("#deleteAll").on("click", function() {
			$("#deletform").submit();
		});

		!function($) {
			$(document)
					.on(
							"click",
							"ul.nav li.parent > a > span.icon",
							function() {
								$(this).find('em:first').toggleClass(
										"glyphicon-minus");
							});
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function() {
			if ($(window).width() > 768)
				$('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function() {
			if ($(window).width() <= 767)
				$('#sidebar-collapse').collapse('hide')
		})
	</script>
</body>

</html>

