<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/admin/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><decorator:title default="Master-layout" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link href="<c:url value="/assets/admin/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" media="all">
<!-- Custom Theme files -->
<link href="<c:url value="/assets/admin/css/style.css"/>"
	rel="stylesheet" type="text/css" media="all" />
<!--js-->
<script src="<c:url value="/assets/admin/js/jquery-2.1.1.min.js"/>"></script>
<!--icons-css-->
<link href="<c:url value="/assets/admin/css/font-awesome.css"/>"
	rel="stylesheet">
<!--Google Fonts-->
<link href='//fonts.googleapis.com/css?family=Carrois+Gothic'
	rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Work+Sans:400,500,600'
	rel='stylesheet' type='text/css'>
<!--static chart-->
<script src="<c:url value="/assets/admin/js/Chart.min.js"/>"></script>
<!--//charts-->
<!-- geo chart -->
<script src="//cdn.jsdelivr.net/modernizr/2.8.3/modernizr.min.js"
	type="text/javascript"></script>
<script>
	window.modernizr
			|| document
					.write('<script src="lib/modernizr/modernizr-custom.js"><\/script>')
</script>
<!--<script src="lib/html5shiv/html5shiv.js"></script>-->
<!-- Chartinator  -->
<script src="<c:url value="/assets/admin/js/chartinator.js"/>"></script>
<script type="text/javascript">
	jQuery(function($) {

		var chart3 = $('#geoChart').chartinator(
				{
					tableSel : '.geoChart',

					columns : [ {
						role : 'tooltip',
						type : 'string'
					} ],

					colIndexes : [ 2 ],

					rows : [ [ 'China - 2015' ], [ 'Colombia - 2015' ],
							[ 'France - 2015' ], [ 'Italy - 2015' ],
							[ 'Japan - 2015' ], [ 'Kazakhstan - 2015' ],
							[ 'Mexico - 2015' ], [ 'Poland - 2015' ],
							[ 'Russia - 2015' ], [ 'Spain - 2015' ],
							[ 'Tanzania - 2015' ], [ 'Turkey - 2015' ] ],

					ignoreCol : [ 2 ],

					chartType : 'GeoChart',

					chartAspectRatio : 1.5,

					chartZoom : 1.75,

					chartOffset : [ -12, 0 ],

					chartOptions : {

						width : null,

						backgroundColor : '#fff',

						datalessRegionColor : '#F5F5F5',

						region : 'world',

						resolution : 'countries',

						legend : 'none',

						colorAxis : {

							colors : [ '#679CCA', '#337AB7' ]
						},
						tooltip : {

							trigger : 'focus',

							isHtml : true
						}
					}

				});
	});
</script>
<!--geo chart-->

<!--skycons-icons-->
<script src="<c:url value="/assets/admin/js/skycons.js"/>"></script>
<!--//skycons-icons-->
<decorator:head />
</head>

<body>
	<div class="page-container">
		<div class="left-content">
			<div class="mother-grid-inner">
			<%@include file="/WEB-INF/views/layouts/admin/header.jsp"%>
				<div class="inner-block">
				
					<decorator:body />
							
				</div>
			<!--copy rights start here-->	
			<div class="copyrights">
				 <p>© 2020 Diamond Shop. All Rights Reserved </p>
			</div>	
			<!--COPY rights end here-->
			</div>
		</div>
		<!--slider menu-->
	    <div class="sidebar-menu">
			  	<div class="logo"> <a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> <a href="#"> <span id="logo" ></span> 
				      <!--<img id="logo" src="" alt="Logo"/>--> 
				  </a> </div>		  
			    <div class="menu">
			      <ul id="menu" >
			       
			       
			        <li id="menu-comunicacao" ><a href="${pageContext.request.contextPath}/admin/user"><i class="fa fa-book nav_icon"></i><span>Danh sách người dùng</span><span  style="float: right"></span></a>
			          
			        </li>
			        
			          
			        <li id="menu-academico" ><a href="${pageContext.request.contextPath}/admin/bill"><i class="fa fa-file-text"></i><span>Hóa đơn</span><span style="float: right"></span></a>
			          
			        </li>
			        
			       
			        <!-- <li><a href="#"><i class="fa fa-envelope"></i><span>Mailbox</span><span class="fa fa-angle-right" style="float: right"></span></a>
			        	 <ul id="menu-academico-sub" >
				            <li id="menu-academico-avaliacoes" ><a href="inbox.html">Inbox</a></li>
				            <li id="menu-academico-boletim" ><a href="inbox-details.html">Compose email</a></li>
			             </ul>
			        </li> -->
			         
			         <li><a href="#"><i class="fa fa-shopping-cart"></i><span>Sản phẩm</span><span class="fa fa-angle-right" style="float: right"></span></a>
			         	<ul id="menu-academico-sub" >
				            <li id="menu-academico-avaliacoes" ><a href="${pageContext.request.contextPath}/admin/product">Danh sách sản phẩm</a></li>
				            <li id="menu-academico-boletim" ><a href="${pageContext.request.contextPath}/admin/product/add">Thêm sản phẩm</a></li>
			             </ul>
			         </li>
			      </ul>
			    </div>
		 </div>
		 <div class="clearfix"> </div>
	</div>
	<script>
	var toggle = true;
	            
	$(".sidebar-icon").click(function() {                
	  if (toggle)
	  {
	    $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
	    $("#menu span").css({"position":"absolute"});
	  }
	  else
	  {
	    $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
	    setTimeout(function() {
	      $("#menu span").css({"position":"relative"});
	    }, 400);
	  }               
	                toggle = !toggle;
	            });
	</script>
	<!--scrolling js-->
			<script src="<c:url value="/assets/admin/js/jquery.nicescroll.js"/>"></script>
			<script src="<c:url value="/assets/admin/js/scripts.js"/>"></script>
			<!--//scrolling js-->
	<script src="<c:url value="/assets/admin/js/bootstrap.js"/>"> </script>
	<!-- mother grid end here-->
</body>
</html>