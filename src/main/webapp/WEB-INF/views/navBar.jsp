<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<nav class="navbar navbar-default ">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <ul class="main-nav nav navbar-nav">
                        <li class="wow fadeInDown " data-wow-delay="0.1s"><a href='/'>홈</a></li>
                    </ul>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse yamm" id="navigation">
                    <div class="button navbar-right">
                   	<c:if test="${empty id }">
                   		<button class="navbar-btn nav-button wow bounceInRight login" onclick="location.href='/register'" data-wow-delay="0.4s">Login</button>
                   	</c:if>
                   	<c:if test="${!empty id }">
                        <button class="navbar-btn nav-button wow bounceInRight login" onclick="location.href='/logout'" data-wow-delay="0.4s">Logout</button>
                        <button class="navbar-btn nav-button wow fadeInRight" onclick="location.href='/profile'" data-wow-delay="0.5s">My Page</button>
                    </c:if>
                    </div>
                    <ul class="main-nav nav navbar-nav">
                        <li class="wow fadeInDown " data-wow-delay="0.1s"><a href="/searchApt" class="">아파트 검색</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="/searchDong">동 별 검색</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="http://localhost:8080">QNA 게시판</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
</nav>