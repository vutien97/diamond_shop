<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>

<title>Hóa đơn</title>
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
			<c:if test="${list_bill.size() == 0 }">
				<h4>Bạn chưa có hóa đơn nào</h4>
			</c:if>
			<c:if test="${list_bill.size() > 0 }">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Hóa đơn Id</th>
							<th>Phone</th>
							<th>Họ tên</th>
							<th>Địa chỉ</th>
							<th>Tổng tiền</th>
							<th>Ghi chú</th>
							<th>Ngày tạo</th>

						</tr>
					</thead>
					<tbody>

						<c:forEach var="item" items="${list_bill}">
							<tr>
								<td>${ item.id }</td>
								<td>${ item.phone }</td>
								<td>${ item.display_name }</td>
								<td>${ item.address }</td>
								<td><fmt:formatNumber type="number" groupingUsed="true"
										value="${item.total}" /> ₫</td>
								<td>${ item.note }</td>
								<td>${ item.billDate }</td>

							</tr>
						</c:forEach>

					</tbody>
				</table>
			</c:if>
		</div>

	</div>
</body>
