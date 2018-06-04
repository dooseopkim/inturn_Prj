<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board/viewMentorBoard.css">
<script type="text/javascript" src="js/board/viewMentorBoard.js"></script>
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
						<li class="active"><a href="mentor.do">멘토찾기</a></li>
						<li><a href="mentee.do">멘티찾기</a></li>
						<li><a href="freeBoard.do?page_num=1">자유게시판</a></li>
						<li class="has-dropdown"><a href="#">이용안내</a>
							<ul class="dropdown">
								<li><a href="#">자주 묻는 질문</a></li>
								<li><a href="csBoard.do">고객서비스</a></li>
						</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</nav>
	
	<div class="container-wrap">
		<div id="page_viewMentorBoard">
		<div class="row">
			<div class="col-sm-4" style="text-align: left;">
				<button id="btn_prevMentorBoard" class="btn btn-primary">이전 글</button>
				<button id="btn_nextMentorBoard" class="btn btn-warning">다음 글</button>
			</div>
			<div class="col-sm-4"></div>
			<div class="col-sm-4" style="text-align: right;">
				<button id="btn_mentorBoardList" class="btn btn-success">목록</button>
				<c:if test="${mentorBoard.id eq login.id}">
					<button id="btn_modifyMentorBoardForm" class="btn btn-info">수정</button>
					<button id="btn_deleteMentorBoard" class="btn btn-danger">삭제</button>
				</c:if>
			</div>
		</div>
		<div class="row">
			<br>
			<div class="col-sm-7" style="text-align: left;">
				제목 : ${mentorBoard.title}
			</div>
			<div class="col-sm-5" style="text-align: right;">
				작성일 : ${mentorBoard.regDate} |
				작성자 : ${mentorBoard.id} |
				<%-- 조회수 : ${board.hit} --%>
			</div>
		</div>
		<div class="row">
			<br>
			<div id="boardContent" class="col-sm-12">
				내용 : ${mentorBoard.content}
			</div>
		</div>
		<input type="hidden" id="nowPage" value="${nowPage}">
		<input type="hidden" id="prevMb_num" value="${prevMb_num}">
		<input type="hidden" id="nextMb_num" value="${nextMb_num}">
		<input type="hidden" id="condition" value="${condition}">	
		<input type="hidden" id="keyword" value="${keyword}">	
		<input type="hidden" id="mb_num" value="${mentorBoard.mb_num}">	
		</div>
		
	</div>
	<jsp:include page="../reply/reply.jsp" />
</body>
</html>