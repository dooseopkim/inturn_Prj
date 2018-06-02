<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人Turn &mdash; 다시 인생을 시작하다.</title>
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
						<li class="active"><a href="main.do">홈</a></li>
						<li class="has-dropdown"><a href="intro1.do">소개</a>
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
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</nav>

	<div class="container-wrap">
		<div class="container">
			<ul class="list-inline">
				<li class="selected">
					<div class="step-bar">
						<strong><em>01</em> 약관동의 및 <span class="m-br">본인인증</span></strong>
						<p>
							약관동의와 본인인증이<br>필요합니다.
						</p>
					</div>
				</li>
				<li class="selected">
					<div class="step-bar">
						<strong><em>02</em> 개인정보<span class="m-br">입력</span></strong>
						<p>
							입력하신 정보는 안전하게<br>보호됩니다.
						</p>
					</div>
				</li>
				<li class="selected">
					<div class="step-bar">
						<strong><em>04</em> 가입완료</strong>
						<p>
							진로교육정보망 통합회원이<br>되신 것을 환영합니다.
						</p>
					</div>
				</li>
			</ul>
		</div>
		<!-- END container -->
		<aside id="fh5co-hero">
		<div class="flexslider">
			<ul class="slides">
				<li style="background-image: url(images/img_bg_3.jpg);">
					<div class="overlay-gradient"></div>
					<div class="container-fluids">
						<div class="row">
							<div class="col-md-6 col-md-offset-3 slider-text">
								<div class="slider-text-inner text-center">
									<h1>회원가입에 성공했습니다!</h1>
									<h2>
										계속해서 이력서를 작성하시려면 프로필작성 버튼을<br> 로그인을 하시려면 로그인 버튼을 클릭해주세요.
									</h2>
									<p>
										<a class="btn btn-primary btn-demo" href="profileForm.do">프로필작성</a> <a
											class="btn btn-primary btn-learn" href="loginForm.do">로그인</a>
									</p>
								</div>
							</div>
						</div>
					</div>
				</li>
			</ul>
		</div>
		</aside>
	</div>
</body>
</html>