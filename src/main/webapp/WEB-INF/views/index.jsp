<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js">
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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/main.js"></script>
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
	<div class="container">
	<br>
		<div class = "col-md-6" id ="chart">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<thead>
				          <tr>
				              <th width = 80px">검색 순위</th>
				              <th>아파트 이름</th>
				          </tr>
				      </thead>
				      <tbody>
				          <tr>
				              <td>1</td>
				              <td id = "first"></td>
				          </tr>
				          <tr class="warning">
				              <td>2</td>
				              <td id = "second"></td>
				          </tr>
				          <tr class="info">
				              <td>3</td>
				              <td id = "third"></td>
				          </tr>
				          <tr class="success">
				              <td>4</td>
				              <td id = "fourth"></td>
				          </tr>
				          <tr class="danger">
				              <td>5</td>
				              <td id = "fifth"></td>
				          </tr>
					</tbody>
			</table>
			<script type="text/javascript">
				$(document).ready(function(){					
					$.get("/map/popularApt"
						,function(data, status){
							$.each(data, function(index, vo) {
								if(index == 0){
									$("#first").append(vo.aptName);
								} else if (index == 1) {
									$("#second").append(vo.aptName);
								} else if (index == 2) {
									$("#third").append(vo.aptName);
								} else if (index == 3) {
									$("#fourth").append(vo.aptName);
								} else if (index == 4) {
									$("#fifth").append(vo.aptName);
								}
							});
						}
						, "json"
					);
				});
			</script>
		</div>
		<div class = "col-md-6" id ="chart">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<thead>
				          <tr>
				              <th width = 80px">검색 순위</th>
				              <th>동 이름</th>
				          </tr>
				      </thead>
				      <tbody>
				          <tr>
				              <td>1</td>
				              <td id = "firstD"></td>
				          </tr>
				          <tr class="warning">
				              <td>2</td>
				              <td id = "secondD"></td>
				          </tr>
				          <tr class="info">
				              <td>3</td>
				              <td id = "thirdD"></td>
				          </tr>
				          <tr class="success">
				              <td>4</td>
				              <td id = "fourthD"></td>
				          </tr>
				          <tr class="danger">
				              <td>5</td>
				              <td id = "fifthD"></td>
				          </tr>
					</tbody>
			</table>
			<script type="text/javascript">
				$(document).ready(function(){					
					$.get("/map/popularDong"
						,function(data, status){
							$.each(data, function(index, vo) {
								if(index == 0){
									$("#firstD").append(vo.dongName);
								} else if (index == 1) {
									$("#secondD").append(vo.dongName);
								} else if (index == 2) {
									$("#thirdD").append(vo.dongName);
								} else if (index == 3) {
									$("#fourthD").append(vo.dongName);
								} else if (index == 4) {
									$("#fifthD").append(vo.dongName);
								}
							});
						}
						, "json"
					);
				});
			</script>
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