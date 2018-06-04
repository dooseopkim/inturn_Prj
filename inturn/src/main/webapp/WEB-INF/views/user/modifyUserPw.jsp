<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/user/user.css">
<link rel="stylesheet" href="/css/user/modifyUserPw.css">
<script type="text/javascript" src="/js/user/modifyUserPw.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/sha256.js"></script>	

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
<div class="page-modifyUserPw">
<div class="row">
<div class="col-sm-3"></div>
<div class="col-sm-6 box-modifyUserPw">
	<h2 class="text-center"><strong>비밀번호 변경</strong></h2>
	<input type="hidden" id="id" class="form-control" value="${login.id}">
	<input type="hidden" id="chkModPw" value="${chkModPw}">
	<input type="password" id="pw" class="form-control" placeholder="현재 비밀번호">
	<div id="feedbackPw" class="feedback"></div>
	<input type="password" id="newPw" class="form-control" placeholder="새 비밀번호">
	<div id="feedbackNewPw" class="feedback"></div>
	<input type="password" id="rePw" class="form-control" placeholder="새 비밀번호 확인">
	<div id="feedbackRePw" class="feedback"></div>
	<div class="feedback"></div>
	<input type="button" id="btn_modifyUserPW" class="btn btn-primary" value="비밀번호변경">
</div>
<div class="col-sm-3"></div>

</div>
</div>
</div>
</body>
</html>