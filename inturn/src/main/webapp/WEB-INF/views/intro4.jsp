<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>intro2</title>
</head>
<body>
	<jsp:include page="userMenu.jsp" />
	<nav class="fh5co-nav" role="navigation">
	<div class="container-wrap">
		<div class="top-menu">
			<div class="row">
				<div class="col-xs-2">
					<div id="fh5co-logo">
						<a href="main.do">人Turn</a>
					</div>
				</div>
				<div class="col-xs-10 text-right menu-1">
					<ul>
						<li><a href="main.do">홈</a></li>
						<li class="active has-dropdown"><a href="intro1.do">소개</a>
							<ul class="dropdown">
								<li><a href="intro1.do">사업소개</a></li>
								<li><a href="intro2.do">서비스소개</a></li>
							</ul></li>
						<li><a href="mentor.do">멘토찾기</a></li>
						<li><a href="mentee.do">멘티찾기</a></li>
						<li><a href="freeBoard.do?page_num=1">자유게시판</a></li>
						<li class="has-dropdown"><a href="#">이용안내</a>
							<ul class="dropdown">
								<li><a href="#">자주 묻는 질문</a></li>
								<li><a href="csBoard.do?page_num=1">고객서비스</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</nav>
	<div class="container-wrap">
		<div id="fh5co-about">
			<div class="row animate-box">
				<div class="col-md-6 col-md-offset-3 text-center heading-section">
					<h3>API 테스트 고우고우</h3>
					<jsp:include page="school.jsp"></jsp:include>
				</div>
			</div>

			<!-- <div class="row">
				<div class="col-md-10 col-md-offset-1 text-center animate-box">
					<p>
						<img src="images/cover_bg_3.jpg"
							alt="Free HTML5 Bootstrap Template" class="img-responsive">
					</p>
				</div>
				<div class="col-md-8 col-md-offset-2 text-center animate-box">
					<div class="about-desc">
						<h3>Hi! I'm Kathy</h3>
						<p>I am a French Designer. Facilis ipsum reprehenderit nemo
							molestias. Aut cum mollitia reprehenderit. Eos cumque dicta
							adipisci architecto culpa amet. Dignissimos asperiores vitae
							velit veniam totam fuga molestias accusamus alias autem
							provident. Odit ab aliquam dolor eius.</p>
					</div>
				</div>
			</div> -->
		</div>
	</div>
</body>
</html>