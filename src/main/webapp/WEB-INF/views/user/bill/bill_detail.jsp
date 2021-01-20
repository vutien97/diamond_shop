<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>

<title>Chi tiết hóa đơn</title>
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
				<li><a href="${pageContext.request.contextPath}/user/bill">Hóa đơn</a><span class="divider">/</span></li>
				<li class="active">Chi tiết hóa đơn</li>
			</ul>
		
			<table class="table table-bordered table-condensed">
				<thead>
					<tr>
						<th>Hình ảnh</th>
						<th>Sản phẩm</th>
						<th>Số lượng</th>
						<th>Tổng tiền</th>
						
					</tr>
				</thead>
				<tbody>

					<c:forEach var="i" begin="0" end="${listBillDetail.size() - 1}">
						<tr>
							<td><img width="100"
								src="<c:url value="/assets/user/img/${listProduct.get(i).img}"/>"
								alt=""></td>
							<td>${ listProduct.get(i).name}</td>
							<td>${listBillDetail.get(i).quantity}</td>
							<td><fmt:formatNumber type="number" groupingUsed="true"
									value="${listBillDetail.get(i).total}" /> ₫</td>
							
						</tr>

					</c:forEach>
				</tbody>
			</table>


		</div>

	</div>
</body>
