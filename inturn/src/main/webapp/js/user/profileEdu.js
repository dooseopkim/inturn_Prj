/**
 * 
 */
$(function(){
	/**
	 * 학력사항 카드에서 추가 관련 function
	 */
	$("#btn_addSchool").click(function(){
		$("#box_addEducation").show();
		resetboxAddEdu();
		$("#school_name").focus();
	});
	
	$("#btn_cancelAddEducation").click(function(){
		if(confirm("변경사항이 저장되지 않습니다. 현재 페이지에서 나가시겠습니까?")){
			resetboxAddEdu();
			$("#box_addEducation").hide();
		}
	});
	
	$("#school_name").click(function(){
		$("#schoolModal").modal("show");
		$("#gubun").val("high_list");
		gubunChange();
		getSchoolList();
	});
	
	$("#btn_schoolModal").click(function(){
		var degreeLvl = $("#sch :selected").text();
		$("#school_name").val($("#schoolName").val());
		$("#degree_level").val(degreeLvl);
		
		$("#schoolModal").modal("hide");
	});
	
	$("#btn_addEducation").click(function(){
		if($("#school_name").val()==""){
			alert("학교명을 입력하세요.");
			$("#school_name").focus();
			return false;
		} else if($("#admission_date").val()==""){
			alert("입학일을 입력하세요.");
			$("#admission_date").focus();
			return false;
		} else if($("#graduation_date").val()==""){
			alert("졸업일을 입력하세요.");
			$("#graduation_date").focus();
			return false;
		} else if($("#major").val()==""){
			alert("전공을 입력하세요.");
			$("#major").focus();
			return false;
		} else if($("#avg_score").val()==""){
			alert("학점을 입력하세요.");
			$("#avg_score").focus();
			return false;
		}
		
		$.ajax({
			url: "addProfileEdu.do",
			method: "POST",
			type: "JSON",
			data: {
				"degree_level" : $("#degree_level").val(),
				"school_name" : $("#school_name").val(),
				"admission_date" : $("#admission_date").val(),
				"graduation_date" : $("#graduation_date").val(),
				"current_status" : $("#current_status").val(),
				"major" : $("#major").val(),
				"avg_score" : $("#avg_score").val(),
				"total_score" : $("#total_score").val()
			},
			success: function(data){
				if(data.result=="success"){
					alert("학력사항을 추가했습니다.");
					resetboxAddEdu();
					$("#box_addEducation").hide();
					setEduLvlList(data);
				} else {
					alert(data.result);
				}
			}
		});
	});
	
	function resetboxAddEdu(){
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
			success : function(data){
				if(data.result == "success"){
					setEduLvlList(data);
					$("#education").show();
				} else if(data.result == "null"){
					$("#education").show();
				} else {
					alert(data.result);
				}
			}
		});
	}
}



function modifyEdu(eduLevel_num){
	$("#box_education"+eduLevel_num).empty();
	var a = '';
	a += '<div id="box_education'+ data.eduLvlList[i].eduLevel_num+'" class="box_education">';
//	a += '<form action="deleteEducation.do" method="POST" onsubmit="return chkDelete('+ data.eduLvlList[i].eduLevel_num+')">';
	a += '<div class="row">';
	a += '<div class="col-sm-6">';
	a += '<label class="col-form-label label-edu" for="degree_level'+ data.eduLvlList[i].eduLevel_num+'">구분</label>';
	a += '<input type="text" id="degree_level'+ data.eduLvlList[i].eduLevel_num+'" class="form-control" readonly="" value="'+ data.eduLvlList[i].degree_level+'">';
	a += '</div>';
	a += '<div class="col-sm-6">';
	a += '<label class="col-form-label label-edu" for="school_name'+ data.eduLvlList[i].eduLevel_num+'">학교명</label>';
	a += '<input type="text" id="school_name'+ data.eduLvlList[i].eduLevel_num+'" class="form-control" readonly="" value="'+ data.eduLvlList[i].school_name+'">';
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
//	a += '</form>';
	a += '</div>';
}

function deleteEdu(eduLevel_num){
	if(confirm("삭제 후 복구할 수 없습니다. 삭제하시겠습니까?")){
	}else {
		return false;
	}
	$.ajax({
		url: "deleteProfileEdu.do",
		method: "POST",
		type: "JSON",
		data: {
			"eduLevel_num" : eduLevel_num
		},
		success: function(data){
			if(data.result=="success"){
				alert("삭제 완료했습니다.");
				setEduLvlList(data);
			} else if (data.result == "null"){
				alert("삭제 완료했습니다.");
				$("#getUserEdu").empty();
			} else {
				alert(data.result);
			}
		}
	});
}

function setEduLvlList(data){
	$("#getUserEdu").empty();
	var a = '';
	for(var i=0 ; i< data.eduLvlList.length; i++){
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
