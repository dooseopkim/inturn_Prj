<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="/js/user/profileCareer.js"></script>
</head>
<body>
	<div id="career" class="card">
		<div class="row">
			<div class="col-sm-6">
				<h3>경력사항</h3>
			</div>
			<div class="col-sm-6 text-right">
				<input type="button" class="btn btn-primary" id="btn_addCareer"
					value="추가">
			</div>
		</div>
		<br/>
		<div id="box_career">
			<div class="row">
				<div class="col-sm-4">
					<label>회사명</label> <input type="text" id="company_name"
						class="form-control">
				</div>
				<div class="col-sm-4">
					<label>부서명</label> <input type="text" id="dept_name"
						class="form-control">
				</div>
				<div class="col-sm-2">
					<label>입사년월</label> <input type="text" id="indate"
						class="form-control" placeholder="2016.03">
				</div>
				<div class="col-sm-2">
					<label>퇴사년월</label> <input type="text" id="outdate"
						class="form-control" placeholder="2016.03">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<label>직급/직책</label> <input type="text" id="position"
						class="form-control">
				</div>
				<div class="col-sm-4">
					<label>직무</label> <input type="text" id="duty" class="form-control">
				</div>
				<div class="col-sm-2">
					<label>세부직무</label> <input type="text" id="kind"
						class="form-control">
				</div>
			</div>
			<div class="box_careerBtn">
				<input type="button" id="btn_career" class="btn btn-primary"
					value="수정"> <input type="button" id="btn_cancelCareer"
					class="btn btn-tmp" value="삭제">
			</div>
		</div>

		<!-- 경력사항 추가 -->
		<div id="box_addCareer">
			<div class="row">
				<div class="col-sm-6">
					<h3>경력사항 추가</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<label>회사명</label> <input type="text" id="company_name2"
						class="form-control">
				</div>
				<div class="col-sm-4">
					<label>부서명</label> <input type="text" id="dept_name2"
						class="form-control">
				</div>
				<div class="col-sm-2">
					<label>입사년월</label> <input type="text" id="indate2"
						class="form-control" placeholder="2016.03">
				</div>
				<div class="col-sm-2">
					<label>퇴사년월</label> <input type="text" id="outdate2"
						class="form-control" placeholder="2016.03">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-4">
					<label>직급/직책</label> <input type="text" id="position2"
						class="form-control">
				</div>
				<div class="col-sm-4">
					<label>직무</label> <input type="text" id="duty2" class="form-control">
				</div>
				<div class="col-sm-2">
					<label>세부직무</label> <input type="text" id="kind2"
						class="form-control">
				</div>
			</div>
			<div class="box_careerBtn">
				<input type="button" id="btn_addEducation" class="btn btn-primary"
					value="저장"> <input type="button"
					id="btn_cancelAddEducation" class="btn btn-tmp" value="취소">
			</div>
		</div>
	</div>

	<!-- 학교정보 OpenAPI 활용 -->
	<jsp:include page="../schoolJS.jsp"></jsp:include>

</body>
</html>