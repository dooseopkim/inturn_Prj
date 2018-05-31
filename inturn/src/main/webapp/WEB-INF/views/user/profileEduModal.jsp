<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<!-- 모달 : 학력사항 - 학교 선택 -->
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
						<input type="hidden" id="eduLevel_num" value="">
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
							<label class="col-form-label label-edu" for="schoolName">학교명</label>
							<select id="schoolName" class="form-control"></select>
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
</body>
</html>