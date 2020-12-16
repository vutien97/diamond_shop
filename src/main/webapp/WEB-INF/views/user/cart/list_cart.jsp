<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<title>Giỏ hàng</title>
</head>
<body>
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Giỏ hàng</li>
			</ul>
			<div class="well well-small">
				<h1>
					Giỏ hàng <small class="pull-right"> ${TotalQuantity} sản
						phẩm trong giỏ hàng </small>
				</h1>
				<hr class="soften" />

				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th>Hình ảnh</th>
							<th>Mô tả</th>
							<th>Có sẵn</th>
							<th>Giá bán</th>
							<th>Số lượng</th>
							<th>Chỉnh sửa</th>
							<th>Xóa</th>
							<th>Tổng tiền</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="item" items="${Cart}">
							<tr>
								<td><img width="100"
									src="<c:url value="/assets/user/img/${item.value.product.img}"/>"
									alt=""></td>
								<td>${ item.value.product.title }</td>
								<td>${item.value.product.quantity}</td>
								<td><fmt:formatNumber type="number" groupingUsed="true"
										value="${item.value.product.price}" /> ₫</td>
								<td><input type="number" min="0"
									max="${item.value.product.quantity}" class="span2"
									style="max-width: 40px" placeholder="1"
									id="quantity-cart-${item.key}" size="16" type="text"
									value="${item.value.quantity}"></td>
								<td><button data-id="${item.key}"
										class="btn btn-mini btn-danger edit-cart" type="button">
										<span class="icon-edit"></span>
									</button></td>
								<td><a href="<c:url value="/deleteCart/${item.key}"/>"
									class="btn btn-mini btn-danger" type="button"> <span
										class="icon-remove"></span>
								</a></td>
								<td><fmt:formatNumber type="number" groupingUsed="true"
										value="${item.value.totalPrice}" /> ₫</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<br />
				<c:if test="${TotalQuantity == 0}">
					<a href="<c:url value = "/trang-chu" />"
						class="shopBtn btn-large pull-center">Chưa có sản phẩm nào
						trong giỏ hàng, quay lại trang mua sắm <span
						class="icon-arrow-right"></span>
					</a>
				</c:if>
				<c:if test="${TotalQuantity > 0}">
					<a href="${pageContext.request.contextPath}/trang-chu"
						class="shopBtn btn-large"><span class="icon-arrow-left"></span>
						Tiếp tục mua sắm </a>

					<c:if test="${empty LoginInfo}">
						<a href="<c:url value = "/dang-ky" />"
							class="shopBtn btn-large pull-right">Thanh toán <span
							class="icon-arrow-right"></span>
						</a>
					</c:if>
					<c:if test="${not empty LoginInfo}">
						<a href="<c:url value = "/checkout" />"
							class="shopBtn btn-large pull-right">Thanh toán <span
							class="icon-arrow-right"></span>
						</a>
					</c:if>
				</c:if>

			</div>
		</div>
	</div>

	<content tag="script"> <script>
		$(".edit-cart").on("click", function() {
			var id = $(this).data("id");
			var quantity = $("#quantity-cart-" + id).val();
			window.location = "editCart/" + id + "/" + quantity;
		});
	</script> </content>
</body>
