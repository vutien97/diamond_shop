<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/admin/taglib.jsp"%>

<head>

<title>Edit sản phẩm</title>
</head>
<body>
	<div class="inbox">
		<h2>Edit sản phẩm</h2>
		<div class="col-md-12 compose-right">
			<div class="inbox-details-default">
				<div class="inbox-details-body">
			
					<form:form method="POST" modelAttribute="product" class="com-mail"
						action="${pageContext.request.contextPath}/admin/product/edit/${product.id_product}">
						<label>Category: </label>
						<c:choose>
							<c:when test="${product.id_category == 1}">Nhẫn</c:when>
							<c:when test="${product.id_category == 2}">Lắc tay</c:when>
							<c:when test="${product.id_category == 3}">Khuyên tai</c:when>
							<c:when test="${product.id_category == 4}">Dây chuyền</c:when>
							<c:when test="${product.id_category == 5}">Lắc chân</c:when>
						</c:choose>
						<br />
						<label>Tên sản phẩm</label>
						<form:input path="name" />
						<label>Price ₫</label>
						<form:input path="price" />
						<label>Title</label>
						<form:input path="title" />
						<label>Số lượng</label>
						<form:input path="quantity" />
						<label>Hình ảnh</label>
						<form:input path="img" />
						<label>Sản phẩm mới?</label>
						<form:select path="new_product">
							<form:option value="true" label="Yes" />
							<form:option value="false" label="No" />
						</form:select>
						<br>
						<label>Sản phẩm nổi bật?</label>
						<form:select path="highlight">
							<form:option value="true" label="Yes" />
							<form:option value="false" label="No" />
						</form:select>
						<br>
						<label>Chi tiết</label>
						<form:textarea path="detail" />
						
						<input type="submit" value="Save">
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<div class="clearfix"></div>
</body>

