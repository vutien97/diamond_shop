<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>Sản phẩm</title>


</head>
<body>
	<div class="well well-small">
		<div class="row">	
				<span style="margin-left: 25px"><h4>&emsp;&ensp;Danh sách sản phẩm với từ khóa: ${search}</h4></span>
		</div>
		<c:if test="${list_product_by_search.size()==0 }"><h3>Không có sản phẩm nào</h3></c:if>

		<c:if test="${list_product_by_search.size()>0 }">
			<div class="row-fluid">
				<ul class="thumbnails">
					<c:forEach var="item" items="${list_product_by_search}" varStatus="loop">
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
						<c:if test="${(loop.index + 1) % 3 == 0 || (loop.index + 1) == list_product_by_search.size() }">
								</ul>
							</div>
							<c:if test="${(loop.index + 1) < list_product_by_search.size() }">
								<div class="row-fluid">
									<ul class="thumbnails">
							</c:if>
						</c:if>

					</c:forEach>
		</c:if>
		
	</div>
	
</body>
