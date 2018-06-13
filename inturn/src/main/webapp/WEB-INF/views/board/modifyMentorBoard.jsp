<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/board/modifyMentorBoard.css">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="js/board/modifyMentorBoard.js"></script>
<script type="text/javascript" src="./resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
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
		<div id="page_modifyMentorBoard">
			<form action="modifyMentorBoard.do" method="POST" id="modifyMentorBoardFrm" enctype="multipart/form-data">
				<div id="box_title">
						<input type="text" id="title" name="title" class="form-control" value="${mentorBoard.title}">
				</div>
				<div id="box_checkProfile" class="form-check">
					<label class="form-check-label"> 공개할 정보를 체크하세요&nbsp;&nbsp;:&nbsp;&nbsp;</label>
	                <label class="form-check-label" for="edu">학력</label>
					<c:choose>
						<c:when test="${mentorBoard.edu eq 'true'}">
							<input class="form-check-input" id="edu" name="edu" type="checkbox" value="true" checked="checked">
						</c:when>
						<c:otherwise>
							<input class="form-check-input" id="edu" name="edu" type="checkbox" value="true">
						</c:otherwise>
					</c:choose>
					<label class="form-check-label" for="career">&nbsp;&nbsp;경력</label>
					<c:choose>
						<c:when test="${mentorBoard.career eq 'true'}">
							<input class="form-check-input" id="career" name="career" type="checkbox" value="true" checked="checked">
						</c:when>
						<c:otherwise>
							<input class="form-check-input" id="career" name="career" type="checkbox" value="true">
						</c:otherwise>
					</c:choose>
					<label class="form-check-label" for="">&nbsp;&nbsp;자격증</label>
					<c:choose>
						<c:when test="${mentorBoard.certificate eq 'true'}">
							<input class="form-check-input" id="certificate" name="certificate" type="checkbox" value="true" checked="checked">
						</c:when>
						<c:otherwise>
							<input class="form-check-input" id="certificate" name="certificate" type="checkbox" value="true">
						</c:otherwise>
					</c:choose>
				</div>
				<div id="box_content">
					<textarea name="editor" id="editor">${mentorBoard.content}</textarea>
				</div>
				<input type="hidden" id="nowPage" name="nowPage" value="${nowPage}">
				<input type="hidden" id="condition" name="condition" value="${condition}">	
				<input type="hidden" id="keyword" name="keyword" value="${keyword}">	
				<input type="hidden" id="mb_num" name="mb_num" value="${mentorBoard.mb_num}">
			</form>	
			<div id="box_btnModifyMentorBoard">
				<input type="button" id="btn_modifyMentorBoard" class="btn btn-primary" value="저장">
				<input type="button" id="btn_cancelMentorBoard" class="btn btn-default" value="취소">
			</div>
		</div>
	</div>
</body>
</html>