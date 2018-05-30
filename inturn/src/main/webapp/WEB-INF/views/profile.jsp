<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人Turn &mdash; 다시 인생을 시작하다.</title>
<link rel="stylesheet" href="/css/user/profileEdu.css">
<link rel="stylesheet" href="css/user/certificate.css">
<script type="text/javascript" src="js/profile.js"></script>
<script type="text/javascript" src="js/user/certificate.js"></script>
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

	<!-- 테스트용도 -->
	<div class="container-wrap" style="background-color: #e8e8e8;">

		<div class="row blogLayout animate-box">
			<div class="leftcolumn" id="leftcolumn">
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

			</div>

			<div class="rightcolumn">
				<div class="card sidenav" id="sidenav">
					<h4>이력서 항목</h4>
					<ul class="fh5co-social-icons" style="display: inline-block;">
						<li><a class="btn icon-pencil" href="javascript:void(0);"
							id="formEducation" onclick="formEducationClick()"
							data-sync_id="InputStat_SchoolInputStat"> <span>학력&nbsp;&nbsp;&nbsp;</span>
						</a></li>
						<li><a class="btn icon-briefcase" href="javascript:void(0);"
							id="formCareer" onclick="formCareerClick()"
							data-sync_id="InputStat_CareerInputStat"> <span>경력</span>
						</a></li>
						<input type="hidden" id="certificateCount" value="0">
						<li><a class="btn icon-newspaper" href="javascript:void(0);"
							id="formLicense" data-sync_id="InputStat_LicenseInputStat"> <span>자격증</span>
						</a></li>
						<li><a class="btn icon-file-text2" href="javascript:void(0);"
							id="formIntroduction" onclick="formIntroductionClick()"
							data-sync_id="InputStat_UserIntroduceInputStat"> <span>자기소개서</span>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>


	<!-- 학력사항 모달 -->
	<jsp:include page="user/profileEduModal.jsp" />

</body>
</html>