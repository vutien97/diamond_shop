<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>

<title>Thanh toán</title>
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
				<a href="#"><img
					src="<c:url value="/assets/user/img/paypal.jpg"/>"
					alt="payment method paypal"></a>
			</div>
			<a class="shopBtn btn-block" href="#">Upcoming products <br>
				<small>Click to view</small></a> <br> <br>


		</div>
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/trang-chu">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">User</li>
			</ul>
			<h3>Thanh toán<h3>
			<hr class="soft" />

			<div class="row">
				<div class="span8">
					<div class="well">
					
						<form:form class="form-horizontal" action="checkout" method="POST" modelAttribute="bill" > 
							<div class="control-group">
								<label class="control-label">Họ tên<sup>*</sup></label>
								<div class="controls">
									${LoginInfo.display_name} 
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Email <sup>*</sup></label>
								<div class="controls">
									${LoginInfo.email} 
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Liên hệ <sup>*</sup></label>
								<div class="controls">
									<form:input type="text" class="span3" placeholder="Mời nhập số điện thoại" path="phone" /> 
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Địa chỉ <sup>*</sup></label>
								<div class="controls">
									<form:textarea path="address" rows="5" cols="30"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Ghi chú <sup>*</sup></label>
								<div class="controls">
									<form:textarea path="note" rows="5" cols="30"/>
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<input type="submit" name="submitAccount" value="Đặt hàng"
										class="shopBtn exclusive">
								</div>
							</div>
						</form:form>
					</div>
				</div>

				<div class="span1">&nbsp;</div>
			</div>

		</div>
	</div>
</body>
