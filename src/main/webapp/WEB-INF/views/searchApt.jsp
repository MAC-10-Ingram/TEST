<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>GARO ESTATE | Home page</title>
<meta name="description" content="GARO is a real-estate template">
<meta name="author" content="Kimarotec">
<meta name="keyword"
	content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800'
	rel='stylesheet' type='text/css'>

<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">

<link rel="stylesheet" href="assets/css/normalize.css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/fontello.css">
<link href="assets/fonts/icon-7-stroke/css/pe-icon-7-stroke.css"
	rel="stylesheet">
<link href="assets/fonts/icon-7-stroke/css/helper.css" rel="stylesheet">
<link href="assets/css/animate.css" rel="stylesheet" media="screen">
<link rel="stylesheet" href="assets/css/bootstrap-select.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/icheck.min_all.css">
<link rel="stylesheet" href="assets/css/price-range.css">
<link rel="stylesheet" href="assets/css/owl.carousel.css">
<link rel="stylesheet" href="assets/css/owl.theme.css">
<link rel="stylesheet" href="assets/css/owl.transitions.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/responsive.css">
<link rel="stylesheet" href="css/apt.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

	<div id="preloader">
		<div id="status">&nbsp;</div>
	</div>
	<!-- Body content -->

	<div class="header-connect">
		<div class="container">
			<div class="row">
				<div class="col-md-5 col-sm-8  col-xs-12">
					<div class="header-half header-call">
						<p>
							<span><i class="pe-7s-call"></i> 02-3429-5100 </span> <span><i
								class="pe-7s-mail"></i> ssafy@ssafy.com </span>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--End top header -->
	<jsp:include page="navBar.jsp"></jsp:include>
	<!-- End of nav bar -->

	<div class="slider-area">
		<div class="slider">
			<div id="bg-slider" class="owl-carousel owl-theme">
				<div class="item">
					<img src="assets/img/slide1/slider-image-1.jpg" alt="Mirror Edge">
				</div>
				<div class="item">
					<img src="assets/img/slide1/slider-image-2.jpg"
						alt="The Last of us">
				</div>
				<div class="item">
					<img src="assets/img/slide1/slider-image-4.jpg" alt="GTA V">
				</div>
			</div>
		</div>
	</div>


	<!-- property area -->
		
	<div class="content-area recent-property"
		style="padding-bottom: 60px; background-color: rgb(252, 252, 252);">
		<div class="container">
			<div
				class="col-lg-9 col-lg-offset-2 col-md-10 col-md-offset-1 col-sm-12">
				<div class="search-form wow pulse" data-wow-delay="0.8s">

					<div class="form-inline">
						<div class="form-group">
							<input type="text" id="apt" name="apt" size="10">
						</div>
						<div class="form-group">
							<button class="btn search-btn" id="aptSearchBtn" type="submit">
							<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
				</div>
				<table class="table mt-2">
						<colgroup>
							<col width="100">
							<col width="150">
							<col width="*">
							<col width="120">
							<col width="120">
						</colgroup>	
						<thead>
							<tr>
								<th>번호</th>
								<th>아파트이름</th>
								<th class="text-center">주소</th>
								<th>건축연도</th>
								<th>최근거래금액</th>
								<th>기준 위치와의 거리(km)</th>
							</tr>
						</thead>
						<tbody id="searchResult"></tbody>
				</table>
				<div class = "row">
					<div class = "col-md-8" id="map" style="width:100%;height:400px;"></div>
						<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=780b54d172c681c02f76c0542e5851c9&libraries=services"></script>
						<script type="text/javascript" src="js/map.js"></script>
						<script type="text/javascript">
						let colorArr = ['table-primary','table-success','table-danger'];
						$(document).on("click", "#aptSearchBtn", function() {
							$.get(root + "/map/apt2"
									,{aptName: $("#apt").val()}
									,function(data, status){
										$("tbody").empty();
										$.each(data, function(index, vo) {
											if (vo.distance == null) vo.distance = '';
											$('<tr>').append($('<td>').text(vo.aptCode))
											.append($('<td>').text(vo.aptName))
		                                    .append($('<td>').text(vo.sidoName + " " + vo.gugunName + " " + vo.dongName + " " + vo.jibun))
		                                    .append($('<td>').text(vo.buildYear))
		                                    .append($('<td>').text(vo.recentPrice))
		                                    .append($('<td>').text(vo.distance))
		                                    .appendTo('tbody');
										});
										displayMarkers(data);
									}
									, "json"
							);
						});
						</script>
				</div>
			</div>
		</div>
	</div>


	<!-- Footer area-->
	<div class="footer-area">

		<div class="footer-copy text-center">
			<div class="container">
				<div class="row">
					<div class="pull-left">
						<span> (C) <a href="http://www.ssafy.com">Ssafy</a> , All
							rights reserved 2021
						</span>
					</div>
				</div>
			</div>
		</div>

	</div>

	<script src="assets/js/modernizr-2.6.2.min.js"></script>

	<script src="assets/js/jquery-1.10.2.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/bootstrap-select.min.js"></script>
	<script src="assets/js/bootstrap-hover-dropdown.js"></script>

	<script src="assets/js/easypiechart.min.js"></script>
	<script src="assets/js/jquery.easypiechart.min.js"></script>

	<script src="assets/js/owl.carousel.min.js"></script>
	<script src="assets/js/wow.js"></script>

	<script src="assets/js/icheck.min.js"></script>
	<script src="assets/js/price-range.js"></script>

	<script src="assets/js/main.js"></script>
</body>
</html>