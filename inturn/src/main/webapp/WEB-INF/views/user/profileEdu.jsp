<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="/css/user/profileEdu.css">
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

	<jsp:include page="../schoolJS.jsp"></jsp:include>
					
</body>
</html>