<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
<style>
	.product-content{
	overflow-x: hidden;
	}
</style>
</head>
<body>
	<div class="row product-content">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">
					<c:forEach var="item" items="${category}">
						<li><a href='<c:url value="/san-pham/${item.id}" />'><span
								class="icon-circle-blank"></span> ${item.name}</a></li>
					</c:forEach>


					<li style="border: 0">&nbsp;</li>
					<li><a class="totalInCart" href="<c:url value="/gio-hang/"/>"><strong>Đã
								mua <span class="badge badge-warning pull-right"
								style="line-height: 18px;"><fmt:formatNumber
										type="number" groupingUsed="true" value="${TotalPrice}" /> ₫</span>
						</strong></a></li>
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
				<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
				<li><a href="products.html">Sản phẩm</a> <span class="divider">/</span></li>
				<li class="active">Chi tiết sản phẩm</li>
			</ul>
			<div class="well well-small">
				<div class="row-fluid">
					<div class="span5">
						<div id="myCarousel" class="carousel slide cntr">
							<div class="carousel-inner">
								<div class="item active">
									<a href="#"> <img src="<c:url value="/assets/user/img/${productById.img}"/>" alt=""
										style="width: 100%"></a>
								</div>
							</div>
							<a class="left carousel-control" href="#myCarousel"
								data-slide="prev">‹</a> <a class="right carousel-control"
								href="#myCarousel" data-slide="next">›</a>
						</div>
					</div>
					<div class="span7">
						<h3>${productById.name}</h3>
						<hr class="soft" />

						<form class="form-horizontal qtyFrm" method="get" action="<c:url value="/addCart/${productById.id_product}"/>">
							<div class="control-group">
								<label class="control-label"><span><fmt:formatNumber type="number" groupingUsed="true" value="${productById.price}" />₫</span></label>
								<div class="controls">
									<input type="number" min="0" value="0" class="span6">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label"><span>Có sẵn trong kho: </span></label>
								<div class="controls">
									<label class="control-label"><span>${productById.quantity}</span></label> 
								</div>
							</div>
							<h4></h4>
							<p>
							${productById.title}
							<p>
								<button type="submit" class="shopBtn">
									<span class=" icon-shopping-cart"></span> Thêm vào giỏ hàng
								</button>
						</form>
					</div>
				</div>
				<hr class="softn clr" />


				<ul id="productDetail" class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab">Chi tiết sản phẩm</a></li>
					<li class=""><a href="#profile" data-toggle="tab">Sản phẩm liên quan</a></li>
					
				</ul>
				<div id="myTabContent" class="tab-content tabWrapper">
					<div class="tab-pane fade active in" id="home">
						${productById.detail}
					</div>
					<div class="tab-pane fade" id="profile">
					
					<c:set var="count" value="${productByCId.size()}"/>
					<c:if test="${productByCId.size() > 5}">
						<c:set var="count" value="5"/>
					</c:if>
					
						<c:forEach var="item" items="${productByCId}" begin="1" end="${count}" varStatus="loop">
								<div class="row-fluid">
								<div class="span2">
									<img src="<c:url value="/assets/user/img/${item.img}"/>" alt="">
								</div>
								<div class="span6">
									<h5>${item.name}</h5>
									<p>${item.title}</p>
								</div>
								<div class="span4 alignR">
									<form class="form-horizontal qtyFrm">
										<h3><fmt:formatNumber type="number" groupingUsed="true" value="${item.price}" />₫</h3>
										
										<div class="btn-group">
											<a href="<c:url value="/addCart/${item.id_product}"/>" class="defaultBtn"><span
												class=" icon-shopping-cart"></span> Thêm vào giỏ</a> <a
												href="${pageContext.request.contextPath}/chi-tiet-san-pham/${item.id_product}" class="shopBtn">VIEW</a>
										</div>
									</form>
								</div>
							</div>
							<hr class="soft" />
							
						</c:forEach>
						
						
						
					</div>
					
				</div>

			</div>
		</div>
	</div>
</body>
