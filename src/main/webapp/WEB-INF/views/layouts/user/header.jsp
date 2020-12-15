<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<header id="header">
	<div class="row">
		<div class="span4">
			<h1>
				<a class="logo" href="<c:url value="/"/>"><span>Twitter Bootstrap
						ecommerce template</span> <img
					src="<c:url value = "/assets/user/img/logo-bootstrap-shoping-cart.png"/>"
					alt="bootstrap sexy shop"> </a>
			</h1>
		</div>
		<div class="span4">
			
		</div>
		<div class="span4 alignR">
			<p>
				<br> <strong> Hỗ trợ (24/7) : 0943 838 536 </strong><br>
				<br>
			</p>
			<%-- <span class="btn btn-mini">${TotalQuantity} <span
				class="icon-shopping-cart"></span></span> <span
				class="btn btn-warning btn-mini">$</span> <span class="btn btn-mini">&pound;</span>
			<span class="btn btn-mini">&euro;</span> --%>
		</div>
	</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a data-target=".nav-collapse" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="nav-collapse">
				<ul class="nav">
					<c:forEach var="item" items="${menu}" varStatus="index">
						<c:if test="${index.first}">
							<li class="active">
						</c:if>
						<c:if test="${not index.first}">
							<li class="">
						</c:if>
						<a href="${pageContext.request.contextPath}/${item.url}">${item.name}</a></li>
					</c:forEach>
				</ul>
				<form action="${pageContext.request.contextPath}/search" class="navbar-search pull-right">
					<input type="text" name="search" placeholder="Search" class="search-query span2">
					<button class="defaultBtn">Tìm kiếm</button>
				</form>
				
			</div>
		</div>
	</div>
</div>