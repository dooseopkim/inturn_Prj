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
					value="추가"> <input type="button" class="btn btn-tmp"
					id="btn_closeCareer" value="닫기">
			</div>
		</div>

		<!-- 기존에 등록한 경력사항 -->
		<div id="getUserCareers"></div>

		<!-- 경력사항 추가 -->
		<div id="box_addCareer">
			<div class="row">
				<div class="col-sm-6">
					<h3>경력사항 추가</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<label>회사명</label> <input type="text" id="company_name"
						class="form-control" name="company_name">
				</div>
				<div class="col-sm-6">
					<label>부서명</label> <input type="text" id="dept_name"
						class="form-control" name="dept_name">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-4">
					<label>직급/직책</label> <input type="text" id="position"
						onclick="modalShow(0)" onkeydown="modalShow(0)"
						class="form-control" name="position" readonly="readonly">
				</div>
				<div class="col-sm-4">
					<label>직무</label> <input type="text" id="duty" class="form-control"
						name="duty">
				</div>
				<div class="col-sm-4">
					<label>세부직무</label> <input type="text" id="kinds"
						class="form-control" name="kinds">
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-sm-4">
					<label>입사일</label> <input type="date" id="indate"
						class="form-control" name="indate">
				</div>
				<div class="col-sm-4">
					<label>퇴사일</label> <input type="date" id="outdate"
						class="form-control" name="outdate">
				</div>
			</div>
			<div class="box_careerBtn">
				<input type="button" id="btn_submitAddCareer"
					class="btn btn-primary" value="저장"> <input type="button"
					id="btn_cancelAddCareer" class="btn btn-tmp" value="취소">
			</div>
		</div>
	</div>
</body>
</html>