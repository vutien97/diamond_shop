<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/admin/taglib.jsp"%>

<head>

<title>Chỉnh sửa hóa đơn</title>
</head>
<body>
	<div class="inbox">
		<h2>Xác nhận thanh toán: </h2>
		<div class="col-md-12 compose-right">
			<div class="inbox-details-default">
				<div class="inbox-details-body">
					<form:form method="POST" modelAttribute="bill" class="com-mail"
						action="${pageContext.request.contextPath}/admin/not_pay_bill/edit/${bill.id}">
						
						<label>Thanh toán: </label>
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
