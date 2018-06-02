<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/user/user.css">
<link rel="stylesheet" href="/css/user/findPW.css">
<script type="text/javascript" src="/js/user/findPW.js"></script>
</head>
<body>
	<jsp:include page="../userMenu.jsp" />
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
						<li class=""><a href="main.do">홈</a></li>
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
<div class="page-findPW">
<div class="row">
<div class="col-sm-3"></div>
<div class="col-sm-6 box-findPW">
	<h2 class="text-center"><strong>비밀번호찾기</strong></h2>
	<input type="text" id="id" class="form-control" placeholder="아이디">
	<input type="text" id="name" class="form-control" placeholder="이름">
	<input type="email" id="email" class="form-control" placeholder="이메일">
	<input type="button" id="btn_sendNewPW" class="btn btn-primary" value="비밀번호찾기">
</div>
<div class="col-sm-3"></div>

</div>
	<!-- 회원가입, ID 및 비밀번호 찾기 -->
	<jsp:include page="loginFooter.jsp" />
</div>
</div>
</body>
</html>