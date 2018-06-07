<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/user/myPage.css">
<script type="text/javascript" src="js/user/myPage.js"></script>
<title>MyPage</title>
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
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</nav>
	<div class="container-wrap">
		<div class="row">
			<div class="col-sm-8">
				<div class="row">
					<div id="mentorBoardAlarm" class="col-sm-6">
						<label>멘토게시판 알림</label>
						<p>가장 최근 게시글들의 댓글을 알려드립니다.</p>
					</div>
					<div id="menteeAlarm" class="col-sm-6">
						<label>멘티게시판 알림</label>
						<p>가장 최근 게시글들의 댓글을 알려드립니다.</p>
					</div>
				</div>
				<div class="row">
					<div id="freeBoardAlarm" class="col-sm-6">
						<label>자유게시판 알림</label>
						<p>가장 최근 게시글들의 댓글을 알려드립니다.</p>
					</div>
					<div id="csBoardAlarm" class="col-sm-6">
						<label>고객 서비스 게시판 알림</label>
						<p>가장 최근 문의에 대한 답변을 알려드립니다.</p>
					</div>
				</div>
			</div>
			<div id="profile" class="col-sm-4">
				<div class="card" style="width: 100%">
					<img class="card-img-top" src="images/myPage_profile.png"
						alt="Card image" style="width: 100%">
					<div class="card-body">
						<div class="row">
							<h4 class="card-title">${login.id}님 환영합니다!</h4>
							<p class="card-text">회원 정보를 여기다 적을건데 음 Ajax로 .do 
							해놓은거에서 정보 가져와서 뿌려주는게 가장 좋을듯 함 왜냐면 안그러면 게시판이랑
							유저 정보가 다있는 컨트롤러가 있어야하는데 그말은 모든 서비스가 다 담긴 그런 컨트롤러를
							하나 만들어야 한다는 뜻임 일단 이렇게 해놓았고 어떻게 할지는 생각해보시길
							나는 일단 자유게시판 관련된건 Ajax로 불러와서 그냥 자바스크립트에서 몽땅 뿌리겠음</p>
						</div>
						<div class="row text-right">
							<a href="profileForm.do" class="btn btn-primary">Profile 수정</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>