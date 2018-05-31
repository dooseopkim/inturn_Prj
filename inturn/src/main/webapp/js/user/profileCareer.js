/**
 * 
 */
$(function() {
	/**
	 * 경력사항 추가 버튼 클릭 시
	 */
	$("#btn_addCareer").click(function() {
		$("#box_addCareer").show();
		$("#company_name2").focus();
	});

	/**
	 * 직급/직책 입력란 클릭 시
	 */
	$("input[name=position]").click(function() {
		$("#positionModal").modal("show");
	});

	/**
	 * 직급/직책 모달에서 직접입력 선택 시
	 */
	$("#job_grade_etc021").click(function() {
		$("#job_text_input").attr("readonly", false);
		$("input:radio[name=job_grade]").removeAttr('checked');
		$("input:radio[name=job_duties]").removeAttr('checked');
	});

	/**
	 * 직급/직책 모달에서 프리랜서 선택 시
	 */
	$("#job_grade_etc020").click(function() {
		$("#job_text_input").attr("readonly", true);
		$("input:radio[name=job_grade]").removeAttr('checked');
		$("input:radio[name=job_duties]").removeAttr('checked');
	});

	/**
	 * 직급/직책 모달에서 초기화 버튼 클릭 시
	 */
	$("#modalClear").click(function() {
		$("input:radio[name=job_grade]").removeAttr('checked');
		$("input:radio[name=job_duties]").removeAttr('checked');
		$("input:radio[name=job_grade_etc]").removeAttr('checked');
	});

	/**
	 * 직급/직책 모달에서 취소 버튼 클릭 시
	 */
	$("#modalCancel").click(function() {
		$("#positionModal").modal("hide");
	});

	/**
	 * 직급/직책 모달에서 완료 버튼 클릭 시
	 */
	$("#modalOk")
			.click(
					function() {
						var job_grade = $(':radio[name="job_grade"]:checked')
								.size();
						var job_duties = $(':radio[name="job_duties"]:checked')
								.size();

						var job_grade_etc020 = $(
								':radio[id="job_grade_etc020"]:checked').val();
						var job_grade_etc021 = $(
								':radio[id="job_grade_etc021"]:checked').val();

						if (job_grade_etc020 != null) {
							$("#positionModal").modal("hide");
							$("#position").val('임시직/프리랜서');
						} else if (job_grade_etc021 != null) {
							$("#positionModal").modal("hide");
							$("#position").val($("#job_text_input").val());
						} else if (job_grade_etc020 == null
								&& job_grade_etc021 == null) {
							if (job_grade == 0 && job_duties == 1) {
								alert("직급을 선택해주세요!");
								return false;
							} else if (job_grade == 1 && job_duties == 0) {
								alert("직책을 선택해주세요!");
								return false;
							} else {
								$("#positionModal").modal("hide");
								$("#position").val($(':radio[name="job_grade"]:checked').val()+ "/"+ $(':radio[name="job_duties"]:checked').val());
								$("#duty").focus();
							}
						}

					});

	/**
	 * 경력사항 취소 버튼 클릭 시
	 */
	$("#btn_cancelAddCareer").click(function() {
		if (confirm("변경사항이 저장되지 않습니다. 현재 페이지에서 나가시겠습니까?")) {
			resetboxAddCareer();
			$("#box_addCareer").hide();
		}
	});

	/**
	 * 경력사항 입력란 전체 초기화
	 * 
	 * @returns
	 */
	function resetboxAddCareer() {
		$("#company_name").val("");
		$("#dept_name").val("");
		$("#position").val("");
		$("#duty").val("");
		$("#kinds").val("");
		$("#indate").val("");
		$("#outdate").val("");
	}

	/**
	 * 경력사항 저장 버튼 클릭 시
	 */
	$("#btn_submitAddCareer").click(function() {
		if ($("#company_name").val() == "") {
			alert("회사명을 입력하세요.");
			$("#company_name").focus();
			return false;
		} else if ($("#dept_name").val() == "") {
			alert("부서명을 입력하세요.");
			$("#dept_name").focus();
			return false;
		} else if ($("#position").val() == "") {
			alert("직급/직책을 입력하세요.");
			$("#position").focus();
			return false;
		} else if ($("#duty").val() == "") {
			alert("직무를 입력하세요.");
			$("#duty").focus();
			return false;
		} else if ($("#kinds").val() == "") {
			alert("상세직무를 입력하세요.");
			$("#kinds").focus();
			return false;
		} else if ($("#indate").val() == "") {
			alert("입사년월을 입력하세요.");
			$("indate").focus();
			return false;
		} else if ($("#outdate").val() == "") {
			alert("퇴사년월을 입력하세요.");
			$("#outdate").focus();
			return false;
		}

		$.ajax({
			url : "addProfileCareer.do",
			method : "POST",
			type : "JSON",
			data : {
				"company_num" : $("#company_name").val(),
				"dept_name" : $("#dept_name").val(),
				"indate" : $("#indate").val(),
				"outdate" : $("#outdate").val(),
				"position" : $("#position").val(),
				"kinds" : $("#kinds").val(),
				"duty" : $("#duty").val(),
			},
			success : function(data) {
				if (data.result == "success") {
					alert("학력사항을 추가했습니다.");
					resetboxAddCareer();
					$("#box_addCareer").hide();
					setCareerList(data);
				} else {
					alert(data.result);
				}
			}

		});

	});
});

/**
 * 사이드네비에서 경력 항목을 클릭할 때
 * 
 * @returns
 */
function formCareerClick() {
	/*
	 * var tag = ''; tag += '<div id="education" class="card">'; tag += '<div
	 * class="row">'; tag += '<div class="col-sm-6">'; tag += '<h3>학력</h3>';
	 * tag += '</div>'; tag += '<div class="col-sm-6">'; tag += '<input
	 * type="button" id="addSchool" value="추가">'; tag += '<input type="button"
	 * id="deleteSchool" value="삭제">'; tag += '</div>'; tag += '</div>'; tag += '<div
	 * id="schoolArea" class="row border border-info">'; tag += '테스트'; tag += '</div>';
	 * tag += '</div>'; $("#leftcolumn").append(tag);
	 */
	$("#career").toggle(function() {
		$("#box_addCareer").hide();
		$('#company_name').focus();
	});
}

/**
 * 경력사항 추가 완료 시 
 * @param data 유저의 모든 career와 job정보를 담고 있음
 * @returns
 */
function setCareerList(data){
	$("#getUserCareer").empty();
	var a = '';
	for(var i=0 ; i< data.careerList.length; i++){
		a += '<div id="box_education'+ data.eduLvlList[i].eduLevel_num+'" class="box_education">';
//		a += '<form action="deleteEducation.do" method="POST" onsubmit="return chkDelete('+ data.eduLvlList[i].eduLevel_num+')">';
		a += '<div class="row">';
		a += '<div class="col-sm-6">';
		a += '<label class="col-form-label label-edu" for="school_name'+ data.eduLvlList[i].eduLevel_num+'">학교명</label>';
		a += '<input type="text" id="school_name'+ data.eduLvlList[i].eduLevel_num+'" class="form-control" readonly="" value="'+ data.eduLvlList[i].school_name+'">';
		a += '</div>';
		a += '<div class="col-sm-6">';
		a += '<label class="col-form-label label-edu" for="degree_level'+ data.eduLvlList[i].eduLevel_num+'">구분</label>';
		a += '<input type="text" id="degree_level'+ data.eduLvlList[i].eduLevel_num+'" class="form-control" readonly="" value="'+ data.eduLvlList[i].degree_level+'">';
		a += '</div>';
		a += '</div>';
		a += '<div class="row">';
		a += '<div class="col-sm-4">';
		a += '<label class="col-form-label label-edu" for="admission_date'+ data.eduLvlList[i].eduLevel_num+'">입학일</label>';
		a += '<input type="text" id="admission_date'+ data.eduLvlList[i].eduLevel_num+'" class="form-control" readonly="" value="'+ data.eduLvlList[i].admission_date+'">';
		a += '</div>';
		a += '<div class="col-sm-4">';
		a += '<label class="col-form-label label-edu" for="graduation_date'+ data.eduLvlList[i].eduLevel_num+'">졸업일</label>';
		a += '<input type="text" id="graduation_date'+ data.eduLvlList[i].eduLevel_num+'" class="form-control" readonly="" value="'+ data.eduLvlList[i].graduation_date+'">';
		a += '</div>';
		a += '<div class="col-sm-4">';
		a += '<label class="col-form-label label-edu" for="current_status'+ data.eduLvlList[i].eduLevel_num+'">현재상태</label>';
		a += '<input type="text" id=current_status'+ data.eduLvlList[i].eduLevel_num+'" class="form-control" readonly="" value="'+ data.eduLvlList[i].current_status+'">';
		a += '</div>';
		a += '</div>';
		a += '<div class="row">';
		a += '<div class="col-sm-6">';
		a += '<label class="col-form-label label-edu" for="major'+ data.eduLvlList[i].eduLevel_num+'">전공</label>';
		a += '<input type="text" id="major'+ data.eduLvlList[i].eduLevel_num+'" class="form-control" readonly="" value="'+ data.eduLvlList[i].major+'">';
		a += '</div>';
		a += '<div class="col-sm-1"></div>';
		a += '<div class="col-sm-5">';
		a += '<label class="col-form-label label-edu" for="avg_score'+ data.eduLvlList[i].eduLevel_num+'">학점 / 총점</label>';
		a += '<div>';
		a += '<input type="text" id="avg_score'+ data.eduLvlList[i].eduLevel_num+'" class="form-control avg_score" readonly="" value="'+ data.eduLvlList[i].avg_score+'"> <span>/</span>';
		a += '<input type="text" id="total_score'+ data.eduLvlList[i].eduLevel_num+'" class="form-control total_score" readonly="" value="'+ data.eduLvlList[i].total_score+'">';
		a += '</div>';
		a += '</div>';
		a += '</div>';
		a += '<div id="box_eduBtn'+ data.eduLvlList[i].eduLevel_num+'" class="box_eduBtn">';
		a += '<input type="button" id="btn_education" class="btn btn-primary" value="수정" onclick="modifyEdu('+ data.eduLvlList[i].eduLevel_num+')">';
		a += '<input type="button" id="btn_deleteEducation" class="btn btn-default" value="삭제" onclick="deleteEdu('+ data.eduLvlList[i].eduLevel_num+')">';
		a += '</div>';
//		a += '</form>';
		a += '</div>';
	}
	$("#getUserEdu").append(a);
}
