<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/admin/taglib.jsp"%>
<head>

<title>Danh sách tìm kiếm hóa đơn</title>

</head>
<body>
	<div class="search-box">
		<form action="${pageContext.request.contextPath}/admin/not_pay_bill/search">
			<input type="text" name="search"
				placeholder="Tìm kiếm hóa đơn theo email của người dùng">
			<button>Tìm kiếm</button>
		</form>
		<div class="clearfix"></div>
	</div>
	<!--//end-search-box-->
	
	<c:if test="${list_bill.size() == 0}">
		<h4>User không có hóa đơn nào chưa thanh toán!</h4>
	</c:if>

	<c:if test="${list_bill.size() > 0}">
		<table class="table tab-border">
			<tbody>
				<tr>
					<td class="hidden-xs" style="width: 50px;"><b>Hóa đơn ID</b></td>
					<td class="hidden-xs" style="width: 200px;"><b>Email</b></td>
					<td style="text-align: center; width: 100px;"><b>Phone</b></td>
					<td style="text-align: center; width: 200px;"><b>Họ tên</b></td>
					<td style="text-align: center; width: 150px;"><b>Địa chỉ</b></td>
					<td style="text-align: center; width: 150px;"><b>Giá trị</b></td>
					<td style="text-align: center; width: 150px;"><b>Ghi chú</b></td>
					<td style="text-align: center; width: 150px;"><b>Ngày tạo</b></td>
					<td style="text-align: center; width: 150px;"><b>Option</b></td>
				</tr>
				<c:forEach var="item" items="${list_bill}">
					<tr class="unread checked">
						<td class="hidden-xs">${item.id}</td>
						<td class="hidden-xs">${item.email}</td>
						<td class="hidden-xs">${item.phone}</td>
						<td class="hidden-xs" style="text-align: center; width: 200px;">${item.display_name}</td>
						<td class="hidden-xs" style="text-align: center; width: 200px;">${item.address}</td>
						<td style="text-align: center; width: 150px;"><fmt:formatNumber
								type="number" groupingUsed="true" value="${item.total}" />₫</td>
						<td style="text-align: center; width: 150px;">${item.note}</td>
						<td style="text-align: center; width: 150px;">${item.billDate}</td>

						<!-- <td style="text-align: center; width: 150px;"><a
						class="btn btn-default" href="#"><i class="fa fa-edit"></i></a></td> -->
						<td style="text-align: center; width: 150px;"><a
							class="btn btn-default"
							href="${pageContext.request.contextPath}/admin/not_pay_bill/edit/${item.id}"
							title="Edit hóa đơn"><i class="fa fa-edit"></i></a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
