<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/admin/taglib.jsp"%>

<title>Admin Index</title>
<body>
	<!--market updates updates-->
	<div class="market-updates">
		<div class="col-md-4 market-update-gd">
			<div class="market-update-block clr-block-1">
				<div class="col-md-8 market-update-left">
					<h3>${userIn1Month.size()}</h3>
					<h4>Người đăng ký mới</h4>
					<p>Trong 1 tháng</p>
				</div>
				<div class="col-md-4 market-update-right">
					<i class="fa fa-file-text-o"> </i>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="col-md-4 market-update-gd">
			<div class="market-update-block clr-block-2">
				<div class="col-md-8 market-update-left">
					<h3>${billIn1Week.size()}</h3>
					<h4>Đơn hàng</h4>
					<p>Trong tuần qua</p>
				</div>
				<div class="col-md-4 market-update-right">
					<i class="fa fa-file-text-o"> </i>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="col-md-4 market-update-gd">
			<div class="market-update-block clr-block-3">
				<div class="col-md-8 market-update-left">
					<h3><fmt:formatNumber type="number" groupingUsed="true" value="${totalIn1Month}" />₫</h3>
					<h4>Tổng doanh thu</h4>
					<p>Trong 1 tháng</p>
				</div>
				<div class="col-md-4 market-update-right">
					<i class="fa fa-envelope-o"> </i>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<!--market updates end here-->
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
