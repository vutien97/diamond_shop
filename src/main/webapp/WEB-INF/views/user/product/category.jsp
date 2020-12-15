<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>Sản phẩm</title>
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
	<div class="well well-small">
		<div class="row">
			<span style="margin-left: 25px">Danh sách sản phẩm</span> <select
				class="pull-right">
				
			</select>
		</div>


		<c:if test="${productPaginate.size()>0 }">
			<div class="row-fluid">
				<ul class="thumbnails">
					<c:forEach var="item" items="${productPaginate}" varStatus="loop">
						<li class="span4">
							<div class="thumbnail">
								<a href="${pageContext.request.contextPath}/chi-tiet-san-pham/${item.id_product}" class="overlay"></a> <a
									class="zoomTool" href="product_details.html"
									title="add to cart"><span class="icon-search"></span> QUICK
									VIEW</a> <a href="<c:url value="/chi-tiet-san-pham/${item.id_product}"/>"><img
										src="<c:url value="/assets/user/img/${item.img}"/>" alt=""></a>
								<div class="caption cntr">
									<p>${item.name}</p>
									<p>
										<strong><fmt:formatNumber type="number" groupingUsed="true" value="${item.price}" />₫ </strong>
									</p>
									<h4>
										<a class="shopBtn" href="<c:url value="/addCart/${item.id_product}"/>" title="Thêm vào giỏ"> Thêm vào giỏ </a>
									</h4>
									
									<br class="clr">
								</div>
							</div>
						</li>
						<c:if test="${(loop.index + 1) % 3 == 0 || (loop.index + 1) == productPaginate.size() }">
								</ul>
							</div>
							<c:if test="${(loop.index + 1) < productPaginate.size() }">
								<div class="row-fluid">
									<ul class="thumbnails">
							</c:if>
						</c:if>

					</c:forEach>
		</c:if>
		
	</div>
	
	<div class="pagination">
		<c:forEach var="item" begin="1" end="${paginateInfo.totalPage}" varStatus="loop">
			<c:if test="${loop.index == paginateInfo.currentPage}">
				<a href="<c:url value="/san-pham/${id_category}/${loop.index}"/>" class="active">${loop.index}</a>
			</c:if>
			<c:if test="${loop.index != paginateInfo.currentPage}">
				<a href="<c:url value="/san-pham/${id_category}/${loop.index}"/>">${loop.index}</a>
			</c:if>
		</c:forEach>
	</div>
</body>
