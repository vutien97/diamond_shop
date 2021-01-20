<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<title>Admin Login</title>
</head>
<body>
	<h5>ADMIN LOGIN</h5>
	<h3>${statusAdminLogin}</h3>
	<h4>${statusLogin}</h4>
	<form:form action="admin-login" method="POST" modelAttribute="user">
		<div class="control-group">
			<label class="control-label" for="inputEmail">E-mail</label>
			<div class="controls">
				<form:input type="email" class="span3" placeholder="E-mail" path="email" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputPassword">Password</label>
			<div class="controls">
				<form:input type="password" class="span3" placeholder="Password" path="password" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="defaultBtn">Đăng nhập</button>
				<a href="#">Quên mật khẩu?</a>
			</div>
		</div>
	</form:form>
</body>