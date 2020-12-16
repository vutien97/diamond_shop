<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/admin/taglib.jsp"%>

<head>

<title>Chỉnh sửa hóa đơn</title>
</head>
<body>
	<div class="inbox">
		<h2>Chi tiết hóa đơn:</h2>
		<div class="col-md-12 compose-right">
			<div class="inbox-details-default">
				<div class="inbox-details-body">
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
									<td>${listProduct.get(i).name}</td>
									<td>${listBillDetail.get(i).quantity}</td>
									<td><fmt:formatNumber type="number" groupingUsed="true"
											value="${listBillDetail.get(i).total}" /> ₫</td>

								</tr>

							</c:forEach>
						</tbody>
					</table>
					<form:form method="POST" modelAttribute="bill" class="com-mail"
						action="${pageContext.request.contextPath}/admin/not_pay_bill/edit/${bill.id}">

						<label>Xác nhận thanh toán: </label>
						<form:select path="status">
							<form:option value="true" label="Yes" />
							<form:option value="false" label="No" />
						</form:select>


						<input type="submit" value="Save">
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<div class="clearfix"></div>
</body>
