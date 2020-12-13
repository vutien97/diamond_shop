<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/admin/taglib.jsp"%>
<head>

<title>Danh sách người dùng</title>
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

.pagination a:hover:not (.active ) {
	background-color: #ddd;
}
</style>
</head>
<body>
	<div class="pagination">
		<span class="text-muted m-r-sm">Pages <br></span>
		
			<c:forEach var="i" begin="0" end="${totalItem}">
				<a class="btn btn-default"
					href="${pageContext.request.contextPath}/admin/user/${i+1}"><c:out
						value="${i+1}" /></a>
			</c:forEach>
		
		<div class="clearfix"></div>
	</div>
	
	<table class="table tab-border">
		<tbody>
			<tr>
				<td class="hidden-xs" style="width: 50px;"><b>User ID</b></td>
				<td class="hidden-xs" style="width: 250px;"><b>Email</b></td>
				<td style="text-align: center; width: 100px;"><b>Phone</b></td>
				<td style="text-align: center; width: 200px;"><b>Họ tên</b></td>
				<td style="text-align: center; width: 150px;"><b>Địa chỉ</b></td>
				<td style="text-align: center; width: 150px;"><b>Ngày tạo</b></td>
				<td style="text-align: center; width: 150px;"><b>Option</b></td>
				
			</tr>
			<c:forEach var="item" items="${list_user}">
				<tr class="unread checked">
					<td class="hidden-xs">${item.id}</td>
					<td class="hidden-xs">${item.email}</td>
					<td class="hidden-xs">${item.phone}</td>
					<td class="hidden-xs" style="text-align: center; width: 200px;">${item.display_name}</td>
					<td class="hidden-xs" style="text-align: center; width: 200px;">${item.address}</td>			
					<td style="text-align: center; width: 150px;">${item.created_at}</td>
					<td style="text-align: center; width: 150px;"><a
						class="btn btn-default" href="${pageContext.request.contextPath}/admin/user/delete/${item.id}" title="Xóa người dùng"><i class="fa fa-remove"></i></a></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
