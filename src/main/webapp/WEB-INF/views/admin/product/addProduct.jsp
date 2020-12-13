<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/admin/taglib.jsp"%>

<head>

<title>Thêm sản phẩm</title>
</head>
<body>
	<div class="inbox">
		<h2>Chi tiết sản phẩm</h2>
		<div class="col-md-12 compose-right">
			<div class="inbox-details-default">
				<div class="inbox-details-body">
					<div class="alert alert-info">${status}</div>
					<form:form method="POST" modelAttribute="product" class="com-mail"
						action="${pageContext.request.contextPath}/admin/product/add">
						<label>Category</label>
						<form:select path="id_category">

							<form:option value="1" label="Nhẫn" />
							<form:option value="2" label="Lắc tay" />
							<form:option value="3" label="Khuyên tai" />
							<form:option value="4" label="Dây chuyền" />
							<form:option value="5" label="Lắc chân" />
						</form:select>
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
