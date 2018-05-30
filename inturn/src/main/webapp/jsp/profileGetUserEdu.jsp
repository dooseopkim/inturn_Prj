<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 기등록 학력사항 -->
	<c:forEach var="eduTest" items="${eduLvlList}">
		<div id="box_education">
			<form action="deleteEducation.do" method="POST" onsubmit="return chkDelete()">
			<input type="hidden" id="eduLevel_num"
				value="${eduTest.eduLevel_num}">
			<div class="row">
				<div class="col-sm-6">
					<label class="col-form-label label-edu" for="data_degree_level">구분</label>
					<input type="text" id="data_degree_level" class="form-control"
						readonly="" value="${eduTest.degree_level}">
				</div>
				<div class="col-sm-6">
					<label class="col-form-label label-edu" for="data_school_name">학교명</label>
					<input type="text" id="data_school_name" class="form-control"
						readonly="" value="${eduTest.school_name}">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<label class="col-form-label label-edu" for="data_admission_date">입학일</label>
					<input type="text" id="data_admission_date" class="form-control"
						readonly="" value="${eduTest.admission_date}">
				</div>
				<div class="col-sm-4">
					<label class="col-form-label label-edu" for="data_graduation_date">졸업일</label>
					<input type="text" id="data_graduation_date" class="form-control"
						readonly="" value="${eduTest.graduation_date}">
				</div>
				<div class="col-sm-4">
					<label class="col-form-label label-edu" for="data_current_status">현재상태</label>
					<input type="text" id=data_current_status " class="form-control"
						readonly="" value="${eduTest.current_status}">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<label class="col-form-label label-edu" for="data_major">전공</label>
					<input type="text" id="data_major" class="form-control" readonly=""
						value="${eduTest.major}">
				</div>
				<div class="col-sm-1"></div>
				<div class="col-sm-5">
					<label class="col-form-label label-edu" for="data_avg_score">학점
						/ 총점</label>
					<div>
						<input type="text" id="data_avg_score" class="form-control"
							readonly="" value="${eduTest.avg_score}"> <span>/</span>
						<input type="text" id="data_total_score" class="form-control"
							readonly="" value="${eduTest.total_score}">
					</div>
				</div>
			</div>
			<div id="box_eduBtn">
				<input type="button" id="btn_education" class="btn btn-primary"
					value="수정"> <input type="submit" id="btn_deleteEducation"
					class="btn btn-default" value="삭제">
			</div>
			</form>
		</div>
	</c:forEach>
</body>
</html>