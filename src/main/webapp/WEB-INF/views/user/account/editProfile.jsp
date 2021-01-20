<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>

<title>Chỉnh sửa thông tin cá nhân</title>
</head>
<body>
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">
					<c:forEach var="item" items="${category}">
						<li><a href='<c:url value="/san-pham/${item.id}" />'><span
								class="icon-circle-blank"></span> ${item.name}</a></li>
					</c:forEach>


					<%-- <li style="border: 0">&nbsp;</li>
					<li><a class="totalInCart" href="<c:url value="/gio-hang/"/>"><strong>Đã
								mua <span class="badge badge-warning pull-right"
								style="line-height: 18px;"><fmt:formatNumber
										type="number" groupingUsed="true" value="${TotalPrice}" /> ₫</span>
						</strong></a></li> --%>
				</ul>
			</div>

			<div class="well well-small alert alert-warning cntr">
				<h2>50% Discount</h2>
				<p>
					only valid for online order. <br> <br> <a
						class="defaultBtn" href="#">Click here </a>
				</p>
			</div>
			<div class="well well-small">
				<img
					src="<c:url value="/assets/user/img/paypal.jpg"/>"
					alt="payment method paypal">
			</div>
			<a class="shopBtn btn-block" href="#">Upcoming products <br>
				<small>Click to view</small></a> <br> <br>
		</div>
		
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/trang-chu">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">User</li>
			</ul>
			<h3>Chỉnh sửa thông tin cá nhân</h3>
			<hr class="soft" />

			<div class="row">
				<div class="span4">
					<div class="well">
	
					<br />
					
						<form:form action="${pageContext.request.contextPath}/user/${user.id}" method="POST" modelAttribute="user">  
							<div class="control-group">
								<label class="control-label" for="inputEmail">E-mail</label>
								<div class="controls">
									${user.email}
									<%-- <form:input type="email" class="span3" placeholder="E-mail" path="email" /> --%>  
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Mật khẩu</label>
								<div class="controls">
									<form:input type="password" class="span3" placeholder="Password" path="password" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Tên hiển thị</label>
								<div class="controls">
									<form:input type="text" class="span3" placeholder="Name" path="display_name" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Địa chỉ</label>
								<div class="controls">
									<form:input type="text" class="span3" placeholder="Address" path="address" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Số điện thoại</label>
								<div class="controls">
									<form:input type="text" class="span3" placeholder="Phone" path="phone" />
								</div>
							</div>
							<div class="controls">
								<button type="submit" class="btn block">Save</button>
							</div>
						</form:form>
					</div>
				</div>
		
		</div>
	</div>
</body>
