$(function() {

	$.ajax({
		url : "getUserCareer.do",
		method : "POST",
		type : "JSON",
		data : {},
		success : function(data) {
			if (data.result == "success") {
				setCareerList(data);
				// $("#btn_addSchool").show();
				$("#career").show();
			} else {
				console.log("career & job : " + data.result);
			}
		}
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
	 * 직급 라디오버튼 선택 시 임시직/프리랜서 , 직접입력 중 선택 된 것 해제
	 */
	$('input:radio[name="job_grade"]').click(function(){
		$("#job_text_input").attr("readonly", true);
		$("input:radio[name=job_grade_etc]").removeAttr('checked');
	});

	/**
	 * 직책 라디오버튼 선택 시 임시직/프리랜서 , 직접입력 중 선택 된 것 해제
	 */
	$('input:radio[name="job_duties"]').click(function(){
		$("#job_text_input").attr("readonly", true);
		$("input:radio[name=job_grade_etc]").removeAttr('checked');
	});

	/**
	 * 경력사항 추가 버튼 클릭 시
	 */
	$("#btn_addCareer").click(function() {
		$("#box_addCareer").show();
		$("#company_name").focus();
	});
	
	$("#btn_closeCareer").click(function(){
		$("#career").hide();
		$("#box_addCareer").hide();
	})

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
				"duty" : $("#duty").val()
			},
			success : function(data) {
				if (data.result == "success") {
					alert("경력사항을 추가했습니다.");
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
 * 경력사항 수정 시 직급/직책란 마우스/키보드 이벤트 발생 시
 * 
 * @returns
 */
function modalShow(index) {
	$("#positionModal").modal("show");
	document.getElementById('modalOk').setAttribute("onClick",
			"modalOK(" + index + ")");
}

/**
 * 직급/직책 모달에서 프리랜서 선택 시
 */
function free() {
	$("#job_text_input").attr("readonly", true);
	$("input:radio[name=job_grade]").removeAttr('checked');
	$("input:radio[name=job_duties]").removeAttr('checked');
}

/**
 * 직급/직책 모달에서 직접입력 선택 시
 */
function self() {
	$("#job_text_input").attr("readonly", false);
	$("input:radio[name=job_grade]").removeAttr('checked');
	$("input:radio[name=job_duties]").removeAttr('checked');
}

/**
 * 직급/직책 선택 모달 창에서 완료 버튼 클릭 시
 * @param index
 * @returns
 */
function modalOK(index) {
	var job_grade = $(':radio[name="job_grade"]:checked').size();
	var job_duties = $(':radio[name="job_duties"]:checked').size();

	var job_grade_etc020 = $(':radio[id="job_grade_etc020"]:checked').val();
	var job_grade_etc021 = $(':radio[id="job_grade_etc021"]:checked').val();

	if (job_grade_etc020 != null) {
		$("#positionModal").modal("hide");
		if (index == 0) {
			$("#position").val('임시직/프리랜서');
		} else {
			$("#position" + index).val('임시직/프리랜서');
		}
	} else if (job_grade_etc021 != null) {
		$("#positionModal").modal("hide");
		if (index == 0) {
			$("#position").val($("#job_text_input").val());
		} else {
			$("#position" + index).val($("#job_text_input").val());
		}
	} else if (job_grade_etc020 == null && job_grade_etc021 == null) {
		if (job_grade == 0 && job_duties == 1) {
			alert("직급을 선택해주세요!");
			return false;
		} else if (job_grade == 1 && job_duties == 0) {
			alert("직책을 선택해주세요!");
			return false;
		} else {
			$("#positionModal").modal("hide");
			if (index == 0) {

				$("#position").val(
						$(':radio[name="job_grade"]:checked').val() + "/"
								+ $(':radio[name="job_duties"]:checked').val());
				$("#duty").focus();
			} else {
				$("#position"+index).val(
						$(':radio[name="job_grade"]:checked').val() + "/"
								+ $(':radio[name="job_duties"]:checked').val());
				$("#duty"+index).focus();
			}
		}
	}
}

/**
 * 사이드네비에서 경력 항목을 클릭할 때
 * 
 * @returns
 */
function formCareerClick() {
	$("#career").toggle(function() {
		$("#box_addCareer").hide();
		$('#company_name').focus();
	});
}

/**
 * 기존 데이터를 불러와서 뿌려줌
 * 
 * @param data
 *            유저의 모든 career와 job정보를 담고 있음
 * @returns
 */
function setCareerList(data) {
	$("#getUserCareers").empty();
	var a = '';
	for (var i = 0; i < data.careerList.length; i++) {
		a += '<div id="getUserCareer' + data.careerList[i].num
				+ '" class="getUserCareer"><div class="row">';
		a += '<div class="col-sm-6"><input type="hidden" id="job_num'
				+ data.jobList[i].job_num + '" value="'
				+ data.jobList[i].job_num + '"><input type="hidden" id="num'
				+ data.careerList[i].num + '" value="' + data.careerList[i].num
				+ '">';
		a += '<label>회사명</label> <input type="text" id="company_name'
				+ data.careerList[i].num
				+ '"class="form-control" readonly="" value="'
				+ data.careerList[i].company_num + '"></div>';
		a += '<div class="col-sm-6">';
		a += '<label>부서명</label> <input type="text" id="dept_name'
				+ data.careerList[i].num
				+ '"class="form-control" readonly="" value="'
				+ data.careerList[i].dept_name + '"></div></div><br>';
		a += '<div class="row"><div class="col-sm-4">';
		a += '<label>직급/직책</label> <input type="text" id="position'
				+ data.jobList[i].job_num
				+ '"class="form-control" readonly="" value="'
				+ data.jobList[i].position
				+ '" onclick="" onkeydown="" ></div>';
		a += '<div class="col-sm-4">';
		a += '<label>직무</label> <input type="text" id="duty'
				+ data.jobList[i].job_num
				+ '" class="form-control" readonly="" value="'
				+ data.jobList[i].duty + '"></div>';
		a += '<div class="col-sm-4">';
		a += '<label>세부직무</label> <input type="text" id="kinds'
				+ data.jobList[i].job_num
				+ '"class="form-control" readonly="" value="'
				+ data.jobList[i].kinds + '"></div></div><br/>';
		a += '<div class="row"><div class="col-sm-4">';
		a += '<label>입사일</label> <input type="date" id="indate'
				+ data.careerList[i].num
				+ '"class="form-control" readonly="" value="'
				+ data.careerList[i].indate + '"></div>';
		a += '<div class="col-sm-4">';
		a += '<label>퇴사일</label> <input type="date" id="outdate'
				+ data.careerList[i].num
				+ '"class="form-control" readonly="" value="'
				+ data.careerList[i].outdate + '"></div></div>';
		a += '<div class="box_careerBtn">';
		a += '<input type="button" id="btn_submitAddCareer'
				+ data.careerList[i].num
				+ '" class="btn btn-primary" value="수정" onclick="modifyCareerForm('
				+ data.jobList[i].job_num + ',' + data.careerList[i].num
				+ ')"> <input type="button" id="btn_cancelAddCareer'
				+ data.careerList[i].num
				+ '" class="btn btn-tmp" value="삭제" onclick="delCareer('
				+ data.jobList[i].job_num + ',' + data.careerList[i].num
				+ ')"></div></div>';
	}
	$("#getUserCareers").append(a);
}

/**
 * 각 경력사항에 대하여 수정 버튼 클릭 시 수정 가능한 폼으로 변경
 * 
 * @param job_num
 * @param num
 * @returns
 */
function modifyCareerForm(job_num, num) {

	$("#company_name" + num).prop("readonly", false);
	$("#dept_name" + num).prop("readonly", false);
	$("#indate" + num).prop("readonly", false);
	$("#outdate" + num).prop("readonly", false);
	$("#position" + job_num).prop("readonly", false);
	$("#kinds" + job_num).prop("readonly", false);
	$("#duty" + job_num).prop("readonly", false);

	$("#company_name" + num).focus().select();

	$("#btn_submitAddCareer" + num).val("저장");
	$("#btn_cancelAddCareer" + num).val("취소");

	document.getElementById('position' + job_num).setAttribute("onClick",
			"modalShow("+job_num+")");
	document.getElementById('position' + job_num).setAttribute("onKeydown",
			"modalShow("+job_num+")");

	document.getElementById('btn_submitAddCareer' + num).setAttribute(
			"onClick", "modifyCareer(" + job_num + "," + num + ")");
	document.getElementById('btn_cancelAddCareer' + num).setAttribute(
			"onClick", "cencelModifyCareer(" + job_num + "," + num + ")");
}

/**
 * 경력사항 수정 후 저장 버튼 클릭 시
 * 
 * @param job_num
 * @param num
 * @returns
 */
function modifyCareer(job_num, num) {
	if ($("#company_name" + num).val() == "") {
		alert("회사명을 입력하세요.");
		$("#company_name" + num).focus();
		return false;
	} else if ($("#dept_name" + num).val() == "") {
		alert("부서명을 입력하세요.");
		$("#dept_name" + num).focus();
		return false;
	} else if ($("#position" + job_num).val() == "") {
		alert("직급/직책을 입력하세요.");
		$("#position" + job_num).focus();
		return false;
	} else if ($("#duty" + job_num).val() == "") {
		alert("직무를 입력하세요.");
		$("#duty" + job_num).focus();
		return false;
	} else if ($("#kinds" + job_num).val() == "") {
		alert("상세직무를 입력하세요.");
		$("#kinds" + job_num).focus();
		return false;
	} else if ($("#indate" + num).val() == "") {
		alert("입사년월을 입력하세요.");
		$("indate" + num).focus();
		return false;
	} else if ($("#outdate" + num).val() == "") {
		alert("퇴사년월을 입력하세요.");
		$("#outdate" + num).focus();
		return false;
	}

	$
			.ajax({
				url : "modifyCareer.do",
				method : "POST",
				type : "JSON",
				data : {
					"company_num" : $("#company_name" + num).val(),
					"dept_name" : $("#dept_name" + num).val(),
					"indate" : $("#indate" + num).val(),
					"outdate" : $("#outdate" + num).val(),
					"position" : $("#position" + job_num).val(),
					"kinds" : $("#kinds" + job_num).val(),
					"duty" : $("#duty" + job_num).val(),
					"job_num" : job_num,
					"num" : num
				},
				success : function(data) {
					if (data.result == "success") {
						alert("경력사항을 수정했습니다.");
						$("#company_name" + num).prop("readonly", true);
						$("#dept_name" + num).prop("readonly", true);
						$("#indate" + num).prop("readonly", true);
						$("#outdate" + num).prop("readonly", true);
						$("#position" + job_num).prop("readonly", true);
						$("#kinds" + job_num).prop("readonly", true);
						$("#duty" + job_num).prop("readonly", true);

						$("#btn_submitAddCareer" + num).val("수정");
						$("#btn_cancelAddCareer" + num).val("삭제");

						document.getElementById('btn_submitAddCareer' + num)
								.setAttribute(
										"onClick",
										"modifyCareerForm(" + job_num + ","
												+ num + ")");
						document.getElementById('btn_cancelAddCareer' + num)
								.setAttribute(
										"onClick",
										"delCareer(" + job_num + "," + num
												+ ")");

						setCareerList(data);
					} else {
						alert(data.result);
					}
				}
			});
}

/**
 * 기존 등록 경력사항의 삭제 버튼 클릭 시
 * 
 * @param num
 * @param job_num
 * @returns
 */
function delCareer(job_num, num) {
	if (confirm("삭제 후 복구할 수 없습니다. 삭제하시겠습니까?")) {
	} else {
		return false;
	}
	$.ajax({
		url : "deleteProfileCareer.do",
		method : "POST",
		type : "JSON",
		data : {
			"num" : num,
			"job_num" : job_num
		},
		success : function(data) {
			if (data.result == "success") {
				alert("삭제 완료했습니다.");
				setCareerList(data);
			} else if (data.result == "null") {
				alert("삭제 완료했습니다.");
				$("#getUserCareers").empty();
			} else {
				alert(data.result);
			}
		}
	});
}

/**
 * 경력사항 수정 중 취소 버튼 클릭 시
 * 
 * @param num
 * @returns
 */
function cencelModifyCareer(job_num, num) {
	if (confirm("수정을 취소하시겠습니까?")) {
		$.ajax({
			url : "getUserCareer.do",
			method : "POST",
			type : "JSON",
			data : {},
			success : function(data) {
				if (data.result == "success") {
					setCareerList(data);
				} else {
					alert(data.result);
				}
			}
		});
	} else {
		return false;
	}
}
