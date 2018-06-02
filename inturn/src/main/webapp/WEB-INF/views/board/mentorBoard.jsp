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
		<div id="page_mentorBoard">	
			<div id="box_keyword"></div>
			<div id="box_mentorCards">
				<c:forEach var="mentorBoardList" items="${mentorBoardList}">
				<div class="card border-success mb-3" onclick="viewMentorBoard(${mentorBoardList.id})">
					<div class="card-header">
						<img class="card-img" alt="thor" src="https://cdn.vox-cdn.com/thumbor/59bGBdvjHpvNw8jW2vC5shp9s54=/0x0:1200x503/1200x800/filters:focal(537x159:729x351)/cdn.vox-cdn.com/uploads/chorus_image/image/57500661/thor6.0.jpeg">
						<strong>${mentorBoardList.id} 님</strong>
					</div>
					<div class="card-body">
						<h4 class="card-title">${mentorBoardList.title}</h4>
						<p class="card-text">${mentorBoardList.content}</p>
					</div>
				</div>
				</c:forEach>
			</div>
			<div id="box_vsw" class="row">
				<div id="box_viewList" class="col-sm-3">
					<input type="button" id="btn_mentorBoardList" class="btn btn-default btn-sm" value="목록보기">
				</div>
				<div id="box_search" class="col-sm-6">
					<select id="condition" class="from-control m-1">
						<option value="board_title">제목</option>
						<option value="board_content">내용</option>
						<option value="board_content">전공</option>
						<option value="user_id">작성자</option>
					</select>
					<input id="keyword" class="form-control" type="text" placeholder="검색어를 입력하세요">
					<input type="button" id="btn_searchMentorBoard" class="btn btn-dark btn-sm" value="검색">
				</div>
				<div id="box_write" class="col-sm-3">
					<input type="button" id="btn_mentorBoardWriteForm" class="btn btn-default btn-sm" value="글쓰기">
				</div>
			</div>
			
			
			<div id="box_page">
				<ul class="pagination pagination-sm">
					<li class="page-item disabled"><a class="page-link" href="#">«</a>
					</li>
					<li class="page-item active"><a class="page-link" href="#">1</a>
					</li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">4</a></li>
					<li class="page-item"><a class="page-link" href="#">5</a></li>
					<li class="page-item"><a class="page-link" href="#">»</a></li>
				</ul>
			</div>
		</div>	
	</div>

</body>
</html>