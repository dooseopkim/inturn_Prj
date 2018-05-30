<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人Turn &mdash; 다시 인생을 시작하다.</title>
<link rel="stylesheet" href="/css/user/profileEdu.css">
<link rel="stylesheet" href="/css/user/profileCareer.css">
<link rel="stylesheet" href="css/user/certificate.css">
<script type="text/javascript" src="js/profile.js"></script>
<script type="text/javascript" src="js/user/certificate.js"></script>
</head>
<body>
	<!-- 우측 최상단 메뉴 -->
	<jsp:include page="userMenu.jsp" />

	<!-- 상단 내비게이션 -->
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
								<li><a href="csBoard.do">고객서비스</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</nav>
	<!-- 상단 내비 div END -->

	<!-- 프로필 -->
	<div class="container-wrap" style="background-color: #e8e8e8;">
		<!-- 블로그레이아웃 -->
		<div class="row blogLayout animate-box">
			<!-- 좌측 (프로필작성란) -->
			<div class="leftcolumn" id="leftcolumn">
				<!-- 인적사항 -->
				<div id="personal" class="card">
					<div class="row">
						<h3>인적사항</h3>
					</div>
					<div id="box_personal">
						<div class="row">
							<div class="col-sm-4">
								<label class="">이름</label> <input type="text"
									class="form-control" id="name" readonly="readonly"
									value="${login.name }">
							</div>
							<div class="col-sm-4">
								<label class="">생년월일</label> <input type="text"
									class="form-control" id="birthday" readonly="readonly"
									value="${login.birthday }">
							</div>
							<div class="col-sm-4">
								<label class="">타입</label> <input type="text"
									class="form-control" id="type" readonly="readonly"
									value="${login.type }">
							</div>
						</div>
						<div class="row" style="margin-top: 1em;">
							<div class="col-sm-6">
								<label>휴대전화</label> <input type="text" class="form-control"
									id="phone" value="${login.phone }">
							</div>
							<div class="col-sm-6">
								<label>이메일</label> <input type="text" class="form-control"
									id="email" value="${login.email }">
							</div>
						</div>
					</div>
				</div>

				<div class="card">
					<h3>인적사항</h3>
				</div>
				<div class="card">
					<h3>인적사항</h3>
				</div>
				
				<!-- 학력사항 -->
				<jsp:include page="user/profileEdu.jsp" />

				<!-- 경력사항 -->
				<jsp:include page="user/profileCareer.jsp" />
			</div>

			<!-- 우측(사이드 네비게이션) -->
			<div class="rightcolumn">
				<div class="card sidenav" id="sidenav">
					<h4>이력서 항목</h4>
					<div>
						<ul class="fh5co-social-icons" style="display: inline-block;">
							<li><a class="btn icon-pencil" href="javascript:void(0);"
								id="formEducation" onclick="formEducationClick()"> <span>학력&nbsp;&nbsp;&nbsp;</span>
							</a></li>
							<li><a class="btn icon-briefcase" href="javascript:void(0);"
								id="formCareer" onclick="formCareerClick()"> <span>경력</span>
							</a></li>
							<input type="hidden" id="certificateCount" value="0">
							<li><a class="btn icon-newspaper" href="javascript:void(0);"
								id="formLicense" > <span>자격증</span>
							</a></li>
							<li><a class="btn icon-book" href="javascript:void(0);"
								id="formPortfolio" onclick="formPortfolioClick()"> <span>포트폴리오</span>
							</a></li>
							<li><a class="btn icon-file-text2"
								href="javascript:void(0);" id="formIntroduction"
								onclick="formIntroductionClick()"> <span>자기소개서</span>
							</a></li>
						</ul>
					</div>
					<br>
					<div class="row" style="text-align: center;">
						<a class="btn btn-tmp">임시저장</a>
					</div>
					<div class="row" style="text-align: center;">
						<a class="btn btn-primary btn-learn">작성완료</a>
					</div>
				</div>
			</div>
			<!-- 사이드네비 div END -->
		</div>
		<!-- 블로그레이아웃 div END -->
	</div>
	<!-- 프로필(container-wrap) div END -->

	<%-- 
	<!-- 모달 : 학력사항 - 고등학교 선택 -->
	<div class="modal" id="schoolModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title">학교 선택</h3>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div id="school" class="row">
						<div class="col-sm-4">
							<label class="col-form-label label-edu" for="region">지역</label> <select
								id="region" class="form-control" onchange="regionChange()">
								<option value="100260">서울특별시</option>
								<option value="100267">부산광역시</option>
								<option value="100269">인천광역시</option>
								<option value="100271">대전광역시</option>
								<option value="100272">대구광역시</option>
								<option value="100273">울산광역시</option>
								<option value="100275">광주광역시</option>
								<option value="100276">경기도</option>
								<option value="100278">강원도</option>
								<option value="100280">충청북도</option>
								<option value="100281">충청남도</option>
								<option value="100282">전라북도</option>
								<option value="100283">전라남도</option>
								<option value="100285">경상북도</option>
								<option value="100291">경상남도</option>
								<option value="100292">제주도</option>
							</select>
						</div>
						<div class="col-sm-4">
							<label class="col-form-label label-edu" for="gubun">분류</label> <select
								id="gubun" class="form-control" onchange="gubunChange()">
								<option value="high_list">고등학교</option>
								<option value="univ_list">대학교</option>
							</select>
						</div>
						<div class="col-sm-4">
							<label class="col-form-label label-edu" for="sch">유형</label> <select
								id="sch" class="form-control" onchange="schChange()">
								<option value=100362>일반고</option>
								<option value=100363>특성화고</option>
								<option value=100364>특수목적고</option>
								<option value=100365>자율고</option>
								<option value=100366>기타</option>
							</select>
						</div>
						<div class="col-sm-12">
							<label class="col-form-label label-edu" for="sch">학교명</label> <select
								id="schoolName" class="form-control"></select>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="btn_schoolModal">저장</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="schoolJS.jsp"></jsp:include>

	<!-- 학력사항 모달 -->
<<<<<<< HEAD
	<jsp:include page="user/profileEduModal.jsp" />
=======
	<jsp:include page="user/profileEduModal.jsp" /> --%>
</body>
</html>