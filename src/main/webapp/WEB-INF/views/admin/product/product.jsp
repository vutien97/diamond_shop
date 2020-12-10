<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/admin/taglib.jsp"%>

<title>Trang sản phẩm</title>
<style>
.pagination {
	display: flex;
	justify-content: center;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}
.pagination a:hover:not(.active)
{
background-color: #ddd;
}
</style>
</head>
<body>
	<div class="pagination">
		<span class="text-muted m-r-sm">Pages </span>
		<div class="btn-group">
			<c:forEach var="i" begin="0" end="${totalItem}">
				<a class="btn btn-default"
					href="${pageContext.request.contextPath}/admin/edit_product/${i+1}"><c:out
						value="${i+1}" /></a>
			</c:forEach>
		</div>
		<div class="clearfix"></div>
	</div>
	<table class="table tab-border">
		<tbody>
			<tr>
				<td class="hidden-xs" style="width: 200px;"><b>Img</b></td>
				<td class="hidden-xs" style="width: 250px;"><b>Sản phẩm</b></td>
				<td style="text-align: center;" hidden-xs" style="width: 100px;"><b>Category
						ID</b></td>
				<td style="text-align: right; width: 150px;"><b>Giá</b></td>
				<td style="text-align: right; width: 150px;"><b>Số lượng</b></td>
				<td style="text-align: center; width: 150px;"><b>Option</b></td>
			</tr>
			<c:forEach var="item" items="${list_product}">
				<tr class="unread checked">
					<td class="hidden-xs">${item.img}</td>
					<td class="hidden-xs">${item.name}</td>
					<td class="hidden-xs" style="text-align: center; width: 100px;">${item.id_category}</td>
					<td style="text-align: right; width: 150px;"><fmt:formatNumber
							type="number" groupingUsed="true" value="${item.price}" />₫</td>
					<td style="text-align: right; width: 150px;">${item.quantity}</td>
					<td style="text-align: center; width: 150px;"><a
						class="btn btn-default" href="#"><i class="fa fa-edit"></i></a> <a
						class="btn btn-default" href="<c:url value="product/delete/${item.id_product}"/>" title="Xóa sản phẩm"><i class="fa fa-remove"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>