<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board/mentorBoard.css">
<script type="text/javascript" src="js/board/mentorBoard.js"></script>
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
		<div id="fh5co-blog">
			<div class="row">
				<div
					style="text-align: center; vertical-align: middle; font-size: x-large; color: black; font-weight: bold;">
					중년 멘토를 소개합니다 :D</div>
			</div>
		</div>
		<div id="page_mentorBoard">
			<div id="box_keyword"></div>
			<div id="box_mentorCards">
				<c:forEach var="mentorBoardList" items="${mentorBoardList}">
					<div class="card border-success mb-3"
						onclick="viewMentorBoard(${mentorBoardList.mb_num})">
						<div class="card-header text-center">${mentorBoardList.title}</div>
						<div class="card-body">
							<div class="card-subtitle">${mentorBoardList.id}님</div>
							<div class="card-text">${mentorBoardList.content}</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div id="box_vsw" class="row">
				<div id="box_viewList" class="col-sm-3">
					<input type="button" id="btn_mentorBoardList"
						class="btn btn-default btn-sm" value="목록보기"
						onclick="location.href='mentorBoard.do'">
				</div>
				<div id="box_search" class="col-sm-6">
					<form action="mentorBoard.do" method="POST">
						<select name="condition" class="from-control m-1">
							<option value="title">제목</option>
							<option value="content">내용</option>
							<option value="id">작성자</option>
						</select> <input name="keyword" class="form-control" type="text"
							placeholder="검색어를 입력하세요"> <input type="submit"
							class="btn btn-dark btn-sm" value="검색">
					</form>
				</div>
				<div id="box_write" class="col-sm-3">
					<input type="button" id="btn_mentorBoardForm"
						class="btn btn-default btn-sm" value="글쓰기">
				</div>
			</div>
			<input type="hidden" id="nowPage" value="${nowPage}"> <input
				type="hidden" id="condition" value="${condition}"> <input
				type="hidden" id="keyword" value="${keyword}">

			<div id="box_page">
				<ul class="pagination pagination-sm">
					<c:if test="${totalPage > 0 }">
						<c:choose>
							<c:when test="${nowPage eq 1 }">
								<li class="page-item disabled"><a href="#">&laquo;</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a href="mentorBoard.do?nowPage=1">&laquo;</a></li>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${nowPage eq 1}">
								<li class="page-item disabled"><a href="#">&lsaquo;</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a
									href="mentorBoard.do?nowPage=${nowPage-1}">&lsaquo;</a></li>
							</c:otherwise>
						</c:choose>
						<c:forEach var="i" begin="${startPage}" end="${endPage}">
							<c:choose>
								<c:when test="${nowPage eq i}">
									<li class="page-item active"><a
										href="mentorBoard.do?nowPage=${i}">${i}</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a
										href="mentorBoard.do?nowPage=${i}">${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${nowPage eq totalPage}">
								<li class="page-item disabled"><a href="#">&rsaquo;</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a
									href="mentorBoard.do?nowPage=${nowPage+1}">&rsaquo;</a></li>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${nowPage eq totalPage}">
								<li class="page-item disabled"><a href="#">&raquo;</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a
									href="mentorBoard.do?nowPage=${totalPage}">&raquo;</a></li>
							</c:otherwise>
						</c:choose>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>