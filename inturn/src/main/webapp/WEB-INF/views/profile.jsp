<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人Turn &mdash; 다시 인생을 시작하다.</title>
<link rel="stylesheet" href="/css/user/profile.css">
<script type="text/javascript" src="js/profile.js"></script>
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
				<div class="card">
					<h3>인적사항</h3>
				</div>
				<div class="card">
					<h3>인적사항</h3>
				</div>
				<div class="card">
					<h3>인적사항</h3>
				</div>
				
				<!-- 학력사항 기존 데이터 불러오기 -->
				<div id="education" class="card">
					<div class="row">
						<div class="col-sm-6">
							<h3>학력사항</h3>
						</div>
						<div class="col-sm-6 text-right">
							<input type="button" class="btn btn-primary" id="btn_addSchool" value="추가">
						</div>
					</div>
					<!-- 기등록 학력사항 -->
					<div id="box_education">
					
						<input type="hidden" id="eduLevel_num" value="">
						<div class="row">
						<div class="col-sm-6">
							<label class="col-form-label label-edu" for="data_degree_level">학업수준</label>
							<input type="text" id="data_degree_level" class="form-control" readonly="">
						</div>
						<div class="col-sm-6">
							<label class="col-form-label label-edu" for="data_school_name">학교명</label>
							<input type="text" id="data_school_name" class="form-control" readonly="">
						</div>
					</div>
					<div class="row">
						<div class="col-sm-4">
							<label class="col-form-label label-edu" for="data_admission_date">입학일</label>
							<input type="text" id="data_admission_date" class="form-control" readonly="">
							<label class="col-form-label label-edu" for="data_major">전공</label>
							<input type="text" id="data_major" class="form-control" readonly="">
						</div>
						<div class="col-sm-4">
							<label class="col-form-label label-edu" for="data_graduation_date">졸업일</label>
							<input type="text" id="data_graduation_date" class="form-control" readonly="">
							<label class="col-form-label label-edu" for="data_avg_score">평점</label>
							<input type="text" id="data_avg_score" class="form-control" readonly="">
						</div>
						<div class="col-sm-4">
							<label class="col-form-label label-edu" for="data_current_status">현재상태</label>
							<input type="text" id=data_degree_level" class="form-control" readonly="">
							<label class="col-form-label label-edu" for="data_total_score">총점</label>
							<input type="text" id="data_total_score" class="form-control" readonly="">
						</div>
					</div>
					<div id="box_eduBtn">
						<input type="button" id="btn_education" class="btn btn-primary" value="수정">
						<input type="button" id="btn_cancelEducation" class="btn btn-default"value="삭제">
					</div>
						
					</div>
					
					<!-- 학력사항 추가 -->
					<div id="box_addEducation">
					<div class="row">
						<h4><strong>학력사항 추가</strong></h4>
						<div class="col-sm-6">
							<label class="col-form-label label-edu" for="degree_level">학업수준<span class="point">*</span></label>
							<select id="degree_level" class="form-control">
							<option value="high_list">고등학교</option>
							<option value="univ_list">대학교 이상</option>
							</select>
						</div>
						<div class="col-sm-6">
							<label class="col-form-label label-edu" for="">학교명<span class="point">*</span></label>
							<input type="text" id="school_name" class="form-control" readonly="">
						</div>
					</div>
					<div class="row">
						<div class="col-sm-4">
							<label class="col-form-label label-edu" for="admission_date">입학일</label>
							<input type="date" id="admission_date" class="form-control">
							<label class="col-form-label label-edu" for="major">전공</label>
							<input type="text" id="major" class="form-control">
						</div>
						<div class="col-sm-4">
							<label class="col-form-label label-edu" for="graduation_date">졸업일</label>
							<input type="date" id="graduation_date" class="form-control">
							<label class="col-form-label label-edu" for="avg_score">평점</label>
							<input type="text" id="avg_score" class="form-control">
						</div>
						<div class="col-sm-4">
							<label class="col-form-label label-edu" for="current_status">현재상태</label>
							<select id="degree_level" class="form-control">
							<option value=""></option>
							<option value=""></option>
							</select>
							<label class="col-form-label label-edu" for="total_score">총점</label>
							<input type="text" id="total_score" class="form-control">
						</div>
					</div>
					<div id="box_addEduBtn">
						<input type="button" id="btn_addEducation" class="btn btn-primary" value="저장">
						<input type="button" id="btn_cancelAddEducation" class="btn btn-default" value="취소">
					</div>
					</div>
				</div>
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
						<li><a class="btn icon-newspaper" href="javascript:void(0);"
							id="formLicense" onclick="formLicenseClick()"
							data-sync_id="InputStat_LicenseInputStat"> <span>자격증</span>
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

	<!-- <div class="container-wrap">
		<div id="fh5co-contact">
			<div class="row animate-box">
				<div class="col-md-6 col-md-offset-3 text-center fh5co-heading">
					<h2>Contact us</h2>
					<p>Far far away, behind the word mountains, far from the
						countries Vokalia and Consonantia.</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 col-md-push-1 animate-box">
					<h3>Our Address</h3>
					<ul class="contact-info">
						<li><i class="icon-location4"></i>198 West 21th Street, Suite
							721 New York NY 10016</li>
						<li><i class="icon-phone3"></i>+ 1235 2355 98</li>
						<li><i class="icon-location3"></i><a href="#">info@yoursite.com</a></li>
						<li><i class="icon-globe2"></i><a href="#">www.yoursite.com</a></li>
					</ul>
				</div>
				<div class="col-md-7 col-md-push-1 animate-box">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Name">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Email">
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<textarea name="" class="form-control" id="" cols="30" rows="7"
									placeholder="Message"></textarea>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<input type="submit" value="Send Message"
									class="btn btn-primary btn-modify">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div> -->

	<!-- 모달 : 학력사항 - 고등학교 선택 -->
	<div class="modal" id="schoolModal">
	<div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h3 class="modal-title">학교 선택</h3>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div id="school" class="row">
        	<div class="col-sm-4">
		        <label class="col-form-label label-edu" for="region">지역</label>
				<select id="region" class="form-control" onchange="regionChange()">
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
				<label class="col-form-label label-edu" for="gubun" >분류</label>
				<select id="gubun" class="form-control" onchange="gubunChange()">
				<option value="high_list">고등학교</option>
				<option value="univ_list">대학교</option>
				</select>
			</div>
			<div class="col-sm-4">
				<label class="col-form-label label-edu" for="sch" >유형</label>
				<select id="sch" class="form-control" onchange="schChange()">
				<option value=100362>일반고</option>
				<option value=100363>특성화고</option>
				<option value=100364>특수목적고</option>
				<option value=100365>자율고</option>
				<option value=100366>기타</option>
			</select>
			</div>
			<div class="col-sm-12">
				<label class="col-form-label label-edu" for="sch" >학교명</label>
				<select id="schoolName" class="form-control" ></select>
			</div>
		</div>	
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="btn_schoolModal">저장</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>
	<jsp:include page="schoolJS.jsp"></jsp:include>
</body>
</html>