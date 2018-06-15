<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="js/mainJs.js"></script>
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

		<div id="myCarousel" class="carousel slide">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li class="item1 active"></li>
				<li class="item2"></li>
				<li class="item3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">

				<div class="item active">
					<img src="images/main01.png" alt="main01">
					<div class="carousel-caption carousel-caption-title">
						<h1>
							<strong>人Turn, 다시 인생을 시작하다</strong>
						</h1>
						<h3>
							<strong>당신의 경험으로 누군가의 미래를 성공으로 이끌 수 있습니다.</strong>
						</h3>
					</div>
					<div class="carousel-caption carousel-caption-btn">
						<c:choose>
							<c:when test="${login.type eq 'mentor'}">
								<button class="btn btn-primary btn-lg btn-mentee">멘티찾기</button>
								<button class="btn btn-primary btn-lg btn-free">자유게시판</button>
							</c:when>
							<c:when test="${login.type eq 'mentee'}">
								<button class="btn btn-primary btn-lg btn-mentor">멘토찾기</button>
								<button class="btn btn-primary btn-lg btn-free">자유게시판</button>
							</c:when>
							<c:otherwise>
								<button class="btn btn-primary btn-lg btn-signup">회원가입</button>
								<button class="btn btn-primary btn-lg btn-login">로그인</button>	
							</c:otherwise>
						</c:choose>
					</div>
				</div>

				<div class="item">
					<img src="images/main02.png" alt="main02">
					<div class="carousel-caption carousel-caption-title">
						<h1>
							<strong>人Turn, 다시 인생을 시작하다</strong>
						</h1>
						<h3>
							<strong>당신의 꿈은 누군가의 조언으로 실현될 수 있습니다.</strong>
						</h3>
					</div>
					<div class="carousel-caption carousel-caption-btn">
						<c:choose>
							<c:when test="${login.type eq 'mentor'}">
								<button class="btn btn-primary btn-lg btn-mentee">멘티찾기</button>
								<button class="btn btn-primary btn-lg btn-free">자유게시판</button>
							</c:when>
							<c:when test="${login.type eq 'mentee'}">
								<button class="btn btn-primary btn-lg btn-mentor">멘토찾기</button>
								<button class="btn btn-primary btn-lg btn-free">자유게시판</button>
							</c:when>
							<c:otherwise>
								<button class="btn btn-primary btn-lg btn-signup">회원가입</button>
								<button class="btn btn-primary btn-lg btn-login">로그인</button>	
							</c:otherwise>
						</c:choose>
					</div>
				</div>

				<div class="item">
					<img src="images/main03.png" alt="main03">
					<div class="carousel-caption carousel-caption-title">
						<h1>
							<strong>人Turn, 다시 인생을 시작하다</strong>
						</h1>
						<h3>
							<strong>멘토, 멘티가 되어 인턴의 놀라운 서비스를 경험하세요.</strong>
						</h3>
					</div>
					<div class="carousel-caption carousel-caption-btn">
						<c:choose>
							<c:when test="${login.type eq 'mentor'}">
								<button class="btn btn-primary btn-lg btn-mentee">멘티찾기</button>
								<button class="btn btn-primary btn-lg btn-free">자유게시판</button>
							</c:when>
							<c:when test="${login.type eq 'mentee'}">
								<button class="btn btn-primary btn-lg btn-mentor">멘토찾기</button>
								<button class="btn btn-primary btn-lg btn-free">자유게시판</button>
							</c:when>
							<c:otherwise>
								<button class="btn btn-primary btn-lg btn-signup">회원가입</button>
								<button class="btn btn-primary btn-lg btn-login">로그인</button>	
							</c:otherwise>
						</c:choose>
					</div>
				</div>

			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button">
				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>

	</div>
	<!-- END container-wrap -->
</body>
</html>