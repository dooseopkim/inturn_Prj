/**
 * 
 * @author 이슬기
 * @version 1.0
 * @since 2018.05.28
 * @see MentorBoard modify 관련 JQuery 및 JavaScript
 */

$(function() {
	
	$.ajax({
		url : "getUserEduLvl.do",
		method : "POST",
		type : "JSON",
		data : {},
		success : function(data) {
			if (data.result == "success") {
				setEduLvlList(data);
				$("#btn_addSchool").show();
				$("#education").show();
			} else {
				console.log("edu : "+data.result);
			}
		}
	});
	
	
	/**
	 * 학력사항 카드에서 추가 관련 function
	 */
	$("#btn_addSchool").click(function() {
		$("#box_addEducation").show();
		resetboxAddEdu();
		$("#btn_addSchool").hide();
		$("#school_name").focus();
	});

	$("#btn_cancelAddEducation").click(function() {
		if (confirm("변경사항이 저장되지 않습니다. 현재 페이지에서 나가시겠습니까?")) {
			resetboxAddEdu();
			$("#box_addEducation").hide();
			$("#btn_addSchool").show();
		}
	});

	$("#btn_closeSchool").click(function() {
		$("#box_addEducation").hide();
		$("#education").hide();
	});

	$("#school_name").click(function() {
		$("#schoolModal").modal("show");
		$("#region").val("100260");
		$("#gubun").val("high_list");
		gubunChange();
		getSchoolList();
	});

	$("#btn_schoolModal").click(function() {
		var degreeLvl = $("#sch :selected").text();
		if ($("#eduLevel_num").val() == "") {
			$("#school_name").val($("#schoolName").val());
			$("#degree_level").val(degreeLvl);

		} else {
			var eduLevel_num = $("#eduLevel_num").val();
			$("#school_name" + eduLevel_num).val($("#schoolName").val());
			$("#degree_level" + eduLevel_num).val(degreeLvl);
			$("#eduLevel_num").val("");
		}

		$("#schoolModal").modal("hide");
	});

	$("#btn_addEducation").click(function() {
		var avg_score = $("#avg_score").val();
		var total_score = $("#total_score").val();

		if (checkEdu(avg_score, total_score)) {
			$.ajax({
				url : "addProfileEdu.do",
				method : "POST",
				type : "JSON",
				data : {
					"degree_level" : $("#degree_level").val(),
					"school_name" : $("#school_name").val(),
					"admission_date" : $("#admission_date").val(),
					"graduation_date" : $("#graduation_date").val(),
					"current_status" : $("#current_status").val(),
					"major" : $("#major").val(),
					"avg_score" : $("#avg_score").val(),
					"total_score" : $("#total_score").val()
				},
				success : function(data) {
					if (data.result == "success") {
						alert("학력사항을 추가했습니다.");
						resetboxAddEdu();
						$("#box_addEducation").hide();
						$("#btn_addSchool").show();
						setEduLvlList(data);
					} else {
						alert(data.result);
					}
				}
			});
		}

	});

	function checkEdu(avg_score, total_score) {
		if ($("#school_name").val() == "") {
			alert("학교명을 입력하세요.");
			$("#school_name").focus();
			return false;
		} else if ($("#admission_date").val() == "") {
			alert("입학일을 입력하세요.");
			$("#admission_date").focus();
			return false;
		} else if ($("#graduation_date").val() == "") {
			alert("졸업일을 입력하세요.");
			$("#graduation_date").focus();
			return false;
		} else if ($("#degree_level").val() == "전문대학"
				|| $("#degree_level").val() == "대학(4년제)") {
			if ($("#major").val() == "") {
				alert("전공을 입력하세요.");
				$("#major").focus();
				return false;
			}
		}

		if (avg_score != "" && !checkAvgScore(avg_score, total_score)) {
			avg_score.focus();
			return false;
		}
		return true;
	}

	function checkAvgScore(avg_score, total_score) {
		var reg = /^[0-9]+(.[0-9]{1,2})?$/;

		if (!reg.test(avg_score)) {
			alert("학점은 점수(숫자)를 입력하세요.");
			return false;
		} else if (avg_score > total_score) {
			alert("학점은 총점 이하의 점수(숫자)를 입력하세요.");
			return false;
		}
		return true;
	}

	function resetboxAddEdu() {
		$("#school_name").val("");
		$("#degree_level").val("");
		$("#admission_date").val("");
		$("#graduation_date").val("");
		$("#current_status").val("졸업");
		$("#major").val("");
		$("#avg_score").val("");
		$("#total_score").val("4.5");
	}

});

/**
 * 학력 항목을 클릭할 때
 * 
 * @returns
 */
function formEducationClick() {
	if ($("#education").is(':visible')) {
		$("#box_addEducation").hide();
		$("#education").hide();

	} else {
		$.ajax({
			url : "getUserEduLvl.do",
			method : "POST",
			type : "JSON",
			data : {},
			success : function(data) {
				if (data.result == "success") {
					setEduLvlList(data);
					$("#btn_addSchool").show();
					$("#education").show();
				} else if (data.result == "null") {
					$("#education").show();
				} else {
					alert(data.result);
				}
			}
		});
	}
}

/**
 * 각 학력사항에 대하여 수정 버튼 클릭 시 수정 가능한 폼으로 변경
 * 
 * @param eduLevel_num
 * @returns
 */
function modifyEduForm(eduLevel_num) {
	$.ajax({
		url : "modifyEduForm.do",
		method : "POST",
		type : "JSON",
		data : {
			"eduLevel_num" : eduLevel_num
		},
		success : function(data) {
			if (data.result == "success") {
				setModifyEduForm(data)
				console.log("성공");
			} else {
				alert(data.result);
			}
		}
	});

}

/**
 * 학력사항 수정 폼에서 학교명 클릭 시 모달 오픈
 * 
 * @param eduLevel_num
 * @returns
 */
function modifySchoolModal(eduLevel_num) {
	$("#schoolModal").modal("show");
	$("#eduLevel_num").val(eduLevel_num);
	$("#region").val("100260");
	$("#gubun").val("high_list");
	gubunChange();
	getSchoolList();
}

/**
 * 학력사항 수정 폼에서 취소 클릭 시
 * 
 * @param eduLevel_num
 * @returns
 */
function cencelModifyEdu(eduLevel_num) {
	if (confirm("수정을 취소하시겠습니까?")) {
		$.ajax({
			url : "getUserEduLvl.do",
			method : "POST",
			type : "JSON",
			data : {},
			success : function(data) {
				if (data.result == "success") {
					setEduLvlList(data);
					// $("#education").show();
				} else if (data.result == "null") {
					$("#education").show();
				} else {
					alert(data.result);
				}
			}
		});
	} else {
		return false;
	}
}

function modifyEdu(eduLevel_num) {
	var avg_score = $("#avg_score" + eduLevel_num).val();
	var total_score = $("#total_score" + eduLevel_num).val();
	var reg = /^[0-9]+(.[0-9]{1,2})?$/;

	if (!reg.test(avg_score)) {
		alert("학점은 점수(숫자)를 입력하세요.");
		return false;
	} else if (avg_score > total_score) {
		alert("학점은 총점 이하의 점수(숫자)를 입력하세요.");
		return false;
	}
	
	 if ($("#degree_level" + eduLevel_num).val() == "전문대학"
			|| $("#degree_level" + eduLevel_num).val() == "대학(4년제)") {
		if ($("#major" + eduLevel_num).val() == "") {
			alert("전공을 입력하세요.");
			$("#major" + eduLevel_num).focus();
			return false;
		}
	}
	 
	if (avg_score != ""){
		if (!reg.test(avg_score)) {
			alert("학점은 점수(숫자)를 입력하세요.");
			avg_score.focus();
			return false;
		} else if (avg_score > total_score) {
			alert("학점은 총점 이하의 점수(숫자)를 입력하세요.");
			avg_score.focus();
			return false;
		}
	} 
	
	$.ajax({
		url : "modifyEdu.do",
		method : "POST",
		type : "JSON",
		data : {
			"eduLevel_num" : eduLevel_num,
			"degree_level" : $("#degree_level" + eduLevel_num).val(),
			"school_name" : $("#school_name" + eduLevel_num).val(),
			"admission_date" : $("#admission_date" + eduLevel_num).val(),
			"graduation_date" : $("#graduation_date" + eduLevel_num).val(),
			"current_status" : $("#current_status" + eduLevel_num).val(),
			"major" : $("#major" + eduLevel_num).val(),
			"avg_score" : $("#avg_score" + eduLevel_num).val(),
			"total_score" : $("#total_score" + eduLevel_num).val()
		},
		success : function(data) {
			if (data.result == "success") {
				setEduLvlList(data);
				// $("#education").show();
			} else if (data.result == "null") {
				// $("#education").show();
			} else {
				alert(data.result);
			}
		}
	});

}

/**
 * 각 학력사항에 삭제 버튼 클릭 시
 * 
 * @param eduLevel_num
 * @returns
 */
function deleteEdu(eduLevel_num) {
	if (confirm("삭제 후 복구할 수 없습니다. 삭제하시겠습니까?")) {
	} else {
		return false;
	}
	$.ajax({
		url : "deleteProfileEdu.do",
		method : "POST",
		type : "JSON",
		data : {
			"eduLevel_num" : eduLevel_num
		},
		success : function(data) {
			if (data.result == "success") {
				alert("삭제 완료했습니다.");
				setEduLvlList(data);
			} else if (data.result == "null") {
				alert("삭제 완료했습니다.");
				$("#getUserEdu").empty();
			} else {
				alert(data.result);
			}
		}
	});
}

/**
 * 불러온 EduLvlList를 화면에 표시
 * 
 * @param data
 * @returns
 */
function setEduLvlList(data) {
	var a = '';

	$("#getUserEdu").empty();

	for (var i = 0; i < data.eduLvlList.length; i++) {
		a += '<div id="box_education' + data.eduLvlList[i].eduLevel_num
				+ '" class="box_education">';
		a += '<div class="row">';
		a += '<div class="col-sm-6">';
		a += '<label class="col-form-label label-edu" for="school_name'
				+ data.eduLvlList[i].eduLevel_num + '">학교명</label>';
		a += '<input type="text" id="school_name'
				+ data.eduLvlList[i].eduLevel_num
				+ '" class="form-control" readonly="" value="'
				+ data.eduLvlList[i].school_name + '">';
		a += '</div>';
		a += '<div class="col-sm-6">';
		a += '<label class="col-form-label label-edu" for="degree_level'
				+ data.eduLvlList[i].eduLevel_num + '">구분</label>';
		a += '<input type="text" id="degree_level'
				+ data.eduLvlList[i].eduLevel_num
				+ '" class="form-control" readonly="" value="'
				+ data.eduLvlList[i].degree_level + '">';
		a += '</div>';
		a += '</div>';
		a += '<div class="row">';
		a += '<div class="col-sm-4">';
		a += '<label class="col-form-label label-edu" for="admission_date'
				+ data.eduLvlList[i].eduLevel_num + '">입학일</label>';
		a += '<input type="text" id="admission_date'
				+ data.eduLvlList[i].eduLevel_num
				+ '" class="form-control" readonly="" value="'
				+ data.eduLvlList[i].admission_date + '">';
		a += '</div>';
		a += '<div class="col-sm-4">';
		a += '<label class="col-form-label label-edu" for="graduation_date'
				+ data.eduLvlList[i].eduLevel_num + '">졸업일</label>';
		a += '<input type="text" id="graduation_date'
				+ data.eduLvlList[i].eduLevel_num
				+ '" class="form-control" readonly="" value="'
				+ data.eduLvlList[i].graduation_date + '">';
		a += '</div>';
		a += '<div class="col-sm-4">';
		a += '<label class="col-form-label label-edu" for="current_status'
				+ data.eduLvlList[i].eduLevel_num + '">현재상태</label>';
		a += '<input type="text" id=current_status'
				+ data.eduLvlList[i].eduLevel_num
				+ '" class="form-control" readonly="" value="'
				+ data.eduLvlList[i].current_status + '">';
		a += '</div>';
		a += '</div>';
		a += '<div class="row">';
		a += '<div class="col-sm-6">';
		a += '<label class="col-form-label label-edu" for="major'
				+ data.eduLvlList[i].eduLevel_num + '">전공</label>';
		a += '<input type="text" id="major' + data.eduLvlList[i].eduLevel_num
				+ '" class="form-control" readonly="" value="'
				+ data.eduLvlList[i].major + '">';
		a += '</div>';
		a += '<div class="col-sm-1"></div>';
		a += '<div class="col-sm-5">';
		a += '<label class="col-form-label label-edu" for="avg_score'
				+ data.eduLvlList[i].eduLevel_num + '">학점 / 총점</label>';
		a += '<div>';
		a += '<input type="text" id="avg_score'
				+ data.eduLvlList[i].eduLevel_num
				+ '" class="form-control avg_score" readonly="" value="'
				+ data.eduLvlList[i].avg_score + '"> <span>/</span>';
		a += '<input type="text" id="total_score'
				+ data.eduLvlList[i].eduLevel_num
				+ '" class="form-control total_score" readonly="" value="'
				+ data.eduLvlList[i].total_score + '">';
		a += '</div>';
		a += '</div>';
		a += '</div>';
		a += '<div id="box_eduBtn' + data.eduLvlList[i].eduLevel_num
				+ '" class="box_eduBtn">';
		a += '<input type="button" id="btn_education" class="btn btn-primary" value="수정" onclick="modifyEduForm('
				+ data.eduLvlList[i].eduLevel_num + ')">';
		a += '<input type="button" id="btn_deleteEducation" class="btn btn-default" value="삭제" onclick="deleteEdu('
				+ data.eduLvlList[i].eduLevel_num + ')">';
		a += '</div>';
		a += '</div>';
	}
	$("#getUserEdu").append(a);
}

/**
 * 수정 버튼을 클릭한 학력사항을 수정 가능한 폼으로 표시
 * 
 * @param data
 * @returns
 */
function setModifyEduForm(data) {
	var a = '';

	$("#box_education" + data.eduLvl.eduLevel_num).empty();

	a += '<div class="row">';
	a += '<div class="col-sm-6">';
	a += '<label class="col-form-label label-edu" for="school_name'
			+ data.eduLvl.eduLevel_num + '">학교명</label>';
	a += '<input type="text" id="school_name' + data.eduLvl.eduLevel_num
			+ '" class="form-control" readonly="" value="'
			+ data.eduLvl.school_name + '" onclick="modifySchoolModal('
			+ data.eduLvl.eduLevel_num + ')">';
	a += '</div>';
	a += '<div class="col-sm-6">';
	a += '<label class="col-form-label label-edu" for="degree_level'
			+ data.eduLvl.eduLevel_num + '">구분</label>';
	a += '<input type="text" id="degree_level' + data.eduLvl.eduLevel_num
			+ '" class="form-control" readonly="" value="'
			+ data.eduLvl.degree_level + '">';
	a += '</div>';
	a += '</div>';
	a += '<div class="row">';
	a += '<div class="col-sm-4">';
	a += '<label class="col-form-label label-edu" for="admission_date'
			+ data.eduLvl.eduLevel_num + '">입학일</label>';
	a += '<input type="date" id="admission_date' + data.eduLvl.eduLevel_num
			+ '" class="form-control" value="' + data.eduLvl.admission_date
			+ '">';
	a += '</div>';
	a += '<div class="col-sm-4">';
	a += '<label class="col-form-label label-edu" for="graduation_date'
			+ data.eduLvl.eduLevel_num + '">졸업일</label>';
	a += '<input type="date" id="graduation_date' + data.eduLvl.eduLevel_num
			+ '" class="form-control" value="' + data.eduLvl.graduation_date
			+ '">';
	a += '</div>';
	a += '<div class="col-sm-4">';
	a += '<label class="col-form-label label-edu" for="current_status'
			+ data.eduLvl.eduLevel_num + '">현재상태</label>';
	a += '<select id="current_status' + data.eduLvl.eduLevel_num
			+ '" class="form-control">'
	a += '<option value="졸업">졸업</option>';
	a += '<option value="재학중">재학중</option>';
	a += '<option value="휴학중">휴학중</option>';
	a += '<option value="수료">수료</option>';
	a += '<option value="중퇴">중퇴</option>';
	a += '<option value="자퇴">자퇴</option>';
	a += '<option value="졸업예정">졸업예정</option>';
	a += '</select>';
	a += '</div>';
	a += '</div>';
	a += '<div class="row">';
	a += '<div class="col-sm-6">';
	a += '<label class="col-form-label label-edu" for="major'
			+ data.eduLvl.eduLevel_num + '">전공</label>';
	a += '<input type="text" id="major' + data.eduLvl.eduLevel_num
			+ '" class="form-control" value="' + data.eduLvl.major + '">';
	a += '</div>';
	a += '<div class="col-sm-1"></div>';
	a += '<div class="col-sm-5">';
	a += '<label class="col-form-label label-edu" for="avg_score'
			+ data.eduLvl.eduLevel_num + '">학점 / 총점</label>';
	a += '<div>';
	a += '<input type="text" id="avg_score' + data.eduLvl.eduLevel_num
			+ '" class="form-control avg_score" value="'
			+ data.eduLvl.avg_score + '"> <span>/</span>';
	a += '<select id="total_score' + data.eduLvl.eduLevel_num
			+ '" class="form-control total_score">';
	a += '<option value="4.0">4.0</option>';
	a += '<option value="4.3">4.3</option>';
	a += '<option value="4.5">4.5</option>';
	a += '<option value="5.0">5.0</option>';
	a += '<option value="7.0">7.0</option>';
	a += '<option value="100">100</option>';
	a += '</select>';
	a += '</div>';
	a += '</div>';
	a += '</div>';
	a += '<div id="box_modifyEduBtn' + data.eduLvl.eduLevel_num
			+ '" class="box_eduBtn">';
	a += '<input type="button" id="btn_modifyEdu" class="btn btn-primary" value="저장" onclick="modifyEdu('
			+ data.eduLvl.eduLevel_num + ')">';
	a += '<input type="button" id="btn_cancelModifyEdu" class="btn btn-default" value="취소" onclick="cencelModifyEdu('
			+ data.eduLvl.eduLevel_num + ')">';
	a += '</div>';

	$("#box_education" + data.eduLvl.eduLevel_num).append(a);
	$("#current_status" + data.eduLvl.eduLevel_num).val(
			data.eduLvl.current_status);
	$("#total_score" + data.eduLvl.eduLevel_num).val(data.eduLvl.total_score);
}
