<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="/js/user/profileEdu.js"></script>
</head>
<body>
	<!-- 학력사항 기존 데이터 불러오기 -->
	<div id="education" class="card">
		<div class="row">
			<div class="col-sm-6">
				<h3>학력사항</h3>
			</div>
			<div class="col-sm-6 text-right">
				<input type="button" class="btn btn-primary" id="btn_addSchool"
					value="추가">
			</div>
		</div>
		<!-- 기등록 학력사항 -->
		<div id="box_education">

			<input type="hidden" id="eduLevel_num" value="">
			<div class="row">
				<div class="col-sm-6">
					<label class="col-form-label label-edu" for="data_degree_level">구분</label>
					<input type="text" id="data_degree_level" class="form-control"
						readonly="">
				</div>
				<div class="col-sm-6">
					<label class="col-form-label label-edu" for="data_school_name">학교명</label>
					<input type="text" id="data_school_name" class="form-control"
						readonly="">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<label class="col-form-label label-edu" for="data_admission_date">입학일</label>
					<input type="text" id="data_admission_date" class="form-control"
						readonly=""> 
				</div>
				<div class="col-sm-4">
					<label class="col-form-label label-edu" for="data_graduation_date">졸업일</label>
					<input type="text" id="data_graduation_date" class="form-control"
						readonly="">
				</div>
				<div class="col-sm-4">
					<label class="col-form-label label-edu" for="data_current_status">현재상태</label>
					<input type="text" id=data_degree_level " class="form-control"
						readonly=""> 
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<label class="col-form-label label-edu" for="data_major">전공</label>
					<input type="text" id="data_major" class="form-control" readonly="">
				</div>
				<div class="col-sm-1"></div>
				<div class="col-sm-5">
					<label class="col-form-label label-edu" for="data_avg_score">학점 / 총점</label>
					<div>
						<input type="text" id="data_avg_score" class="form-control" readonly="">
						<span>/</span>
						<input type="text" id="data_total_score" class="form-control" readonly="">
					</div>
					
				</div>				
			</div>
			<div id="box_eduBtn">
				<input type="button" id="btn_education" class="btn btn-primary"
					value="수정"> <input type="button" id="btn_cancelEducation"
					class="btn btn-default" value="삭제">
			</div>

		</div>

		<!-- 학력사항 추가 -->
		<div id="box_addEducation">
			<div class="row">
				<h4>
					<strong>학력사항 추가</strong>
				</h4>
				<div class="col-sm-6">
					<label class="col-form-label label-edu" for="school_name">학교명<span class="point">*</span></label>
					<input type="text" id="school_name" class="form-control" readonly="">
				</div>
				<div class="col-sm-6">
					<label class="col-form-label label-edu" for="degree_level">구분<span class="point">*</span></label>
					<input type="text" id="degree_level" class="form-control" readonly="">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<label class="col-form-label label-edu" for="admission_date">입학일</label>
					<input type="date" id="admission_date" class="form-control">
				</div>
				<div class="col-sm-4">
					<label class="col-form-label label-edu" for="graduation_date">졸업일</label>
					<input type="date" id="graduation_date" class="form-control">
				</div>
				<div class="col-sm-4">
					<label class="col-form-label label-edu" for="current_status">현재상태</label>
					<select id="current_status" class="form-control">
						<option value="졸업">졸업</option>
						<option value="재학중">재학중</option>
						<option value="휴학중">휴학중</option>
						<option value="수료">수료</option>
						<option value="중퇴">중퇴</option>
						<option value="자퇴">자퇴</option>
						<option value="졸업예정">졸업예정</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<label class="col-form-label label-edu" for="major">전공</label>
					<input type="text" id="major" class="form-control">
				</div>
				<div class="col-sm-1"></div>
				<div class="col-sm-5">
					<label class="col-form-label label-edu" for="avg_score">학점 / 총점</label>
					<div>
					<input type="text" id="avg_score" class="form-control">
					<span>/</span>
					<select id="total_score" class="form-control">
						<option value="4.0">4.0</option>
						<option value="4.3">4.3</option>
						<option value="4.5" selected>4.5</option>
						<option value="5.0">5.0</option>
						<option value="7.0">7.0</option>
						<option value="100">100</option>
					</select>
					</div>
				</div>
			</div>
			<div id="box_addEduBtn">
				<input type="button" id="btn_addEducation" class="btn btn-primary" value="저장">
				<input type="button" id="btn_cancelAddEducation" class="btn btn-default" value="취소">
			</div>
		</div>
	</div>
	
	<!-- 학교정보 OpenAPI 활용 -->
	<jsp:include page="../schoolJS.jsp"></jsp:include>

</body>
</html>