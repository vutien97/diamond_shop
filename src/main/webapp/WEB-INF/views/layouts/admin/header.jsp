<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/admin/taglib.jsp"%>
<!--header start here-->
<div class="header-main">
	<div class="header-left">
		<div class="logo-name">
			<a href="index.html">
				<h1>Shoppy</h1> <!--<img id="logo" src="" alt="Logo"/>-->
			</a>
		</div>
		<!--search-box-->
		
		<!--//end-search-box-->
		<div class="clearfix"></div>
	</div>
	<div class="header-right">
		<div class="profile_details_left">
			<!--notifications of menu start -->
			
			<div class="clearfix"></div>
		</div>
		<!--notification menu end -->
		<div class="profile_details">
			<ul>
				<li class="dropdown profile_details_drop"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"
					aria-expanded="false">
						<div class="profile_img">
							<span class="prfil-img"><img src="<c:url value="/assets/admin/images/p1.png"/>" alt="">
							</span>
							<div class="user-name">
								<p>${AdminLoginInfo.display_name}</p>
								<span>Administrator</span>
							</div>
							<i class="fa fa-angle-down lnr"></i> <i
								class="fa fa-angle-up lnr"></i>
							<div class="clearfix"></div>
						</div>
				</a>
					<ul class="dropdown-menu drp-mnu">
						<li><a href="#"><i class="fa fa-user"></i> Trang cá nhân</a></li>
						<li><a href="<c:url value="/admin-logout"/>"><i class="fa fa-sign-out"></i> Đăng xuất</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="clearfix"></div>
</div>
<!--heder end here-->
<!-- script-for sticky-nav -->
<script>
	$(document).ready(function() {
		var navoffeset = $(".header-main").offset().top;
		$(window).scroll(function() {
			var scrollpos = $(window).scrollTop();
			if (scrollpos >= navoffeset) {
				$(".header-main").addClass("fixed");
			} else {
				$(".header-main").removeClass("fixed");
			}
		});

	});
</script>
<!-- /script-for sticky-nav -->